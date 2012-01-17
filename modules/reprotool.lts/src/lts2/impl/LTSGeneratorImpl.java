/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lts2.impl;

import java.util.ArrayList;
import lts2.AbortState;
import lts2.FinalState;
import lts2.InitialState;
import lts2.LTSGenerator;
import lts2.Lts2Factory;
import lts2.Lts2Package;
import lts2.State;
import lts2.StateMachine;
import lts2.Transition;
import lts2.TransitionalState;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LTS Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link lts2.impl.LTSGeneratorImpl#getLabelTransitionSystem <em>Label Transition System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LTSGeneratorImpl extends EObjectImpl implements LTSGenerator {
	/**
	 * The cached value of the '{@link #getLabelTransitionSystem() <em>Label Transition System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelTransitionSystem()
	 * @generated
	 * @ordered
	 */
	protected StateMachine labelTransitionSystem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LTSGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Lts2Package.Literals.LTS_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getLabelTransitionSystem() {
		return labelTransitionSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabelTransitionSystem(StateMachine newLabelTransitionSystem, NotificationChain msgs) {
		StateMachine oldLabelTransitionSystem = labelTransitionSystem;
		labelTransitionSystem = newLabelTransitionSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Lts2Package.LTS_GENERATOR__LABEL_TRANSITION_SYSTEM, oldLabelTransitionSystem, newLabelTransitionSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/*
	 * @generated NOT
	 */
	public LTSCache getLtsCache() {
		return ltsCache;
	}
	
	/*
	 * @generated NOT
	 */
	private LTSCache ltsCache = new LTSCache();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void processUseCase(UseCase useCase) {
		labelTransitionSystem = Lts2Factory.eINSTANCE.createStateMachine();
		InitialState init = Lts2Factory.eINSTANCE.createInitialState();
		FinalState fin = Lts2Factory.eINSTANCE.createFinalState();
		labelTransitionSystem.setInitialState(init);
		labelTransitionSystem.setFinalState(fin);
		processScenario(useCase.getMainScenario(), labelTransitionSystem.getInitialState(), null, true);
		processGotoSteps();
	}

	/**
	 * We can not process the goto steps while processing the scenario
	 * because at that time some goto targets may not be known yet.
	 * Thus we process the goto steps only after all steps have been visited.
	 * @generated NOT
	 */
	private void processGotoSteps() {
		for (UseCaseStep ucStep: ltsCache.getGotoSteps()) {
			Assert.isTrue(ucStep.getAction() instanceof Goto);
			Goto gotoAction = (Goto) ucStep.getAction();
			State src = ltsCache.getUCStep2TSrcState().get(ucStep);
			State dst = ltsCache.getUCStep2TSrcState().get(gotoAction.getGotoTarget());
			
			if ((src == null) || (dst == null)) {
				return;
			}

			Transition t = Lts2Factory.eINSTANCE.createTransition();
			t.setRelatedStep(ucStep);
			Assert.isTrue(src instanceof TransitionalState);
			TransitionalState srcTransitional = (TransitionalState) src;
			t.setSourceState(srcTransitional);
			t.setTargetState(dst);
			srcTransitional.getTransitions().add(t);
			ltsCache.getGotoTransitions().add(t);
			ltsCache.getUCStep2Trans().put(ucStep, t);
			ltsCache.getUCStep2TransLayout().put(ucStep, t);
		}
	}
	
	/**
	 * @param mainScenario
	 * @param initialState
	 * @param object
	 * @generated NOT
	 */
	private State processScenario(Scenario scen, State init, State next, boolean mainScenario) {
		
		if ((scen == null) || (scen.getSteps().isEmpty())) {
			System.out.println("Returning null");
			return null;
		}
		
		State srcState = init;
		UseCaseStep lastStep = scen.getSteps().get(scen.getSteps().size() - 1);
		
		UseCaseStep prevStep = null;
		for(UseCaseStep ucStep: scen.getSteps()) {
			if (ucStep.getAction() instanceof UseCaseInclude) {
				UseCaseInclude include = (UseCaseInclude) ucStep.getAction();
				ltsCache.getIncludedUseCases().add(include.getIncludeTarget());
			}
			
			ltsCache.getUCStep2TSrcState().put(ucStep, srcState);
			State tgtState;
			if (mainScenario && (ucStep == lastStep) && (lastStep.getExtensions().isEmpty())) {
				tgtState = labelTransitionSystem.getFinalState();
			} else {
				tgtState = Lts2Factory.eINSTANCE.createTransitionalState();
			}
			
			if (
					(srcState != init) &&
					(ltsCache.getExtClosures().containsKey(srcState))
			) {
				TransitionalState extHolder = Lts2Factory.eINSTANCE.createTransitionalState();
				labelTransitionSystem.getTransitionalStates().add(extHolder);

				for (TransitionalState src: ltsCache.getExtClosures().get(srcState)) {
					Transition t = Lts2Factory.eINSTANCE.createTransition();
					UseCaseStep dummy = reprotool.model.usecase.UsecaseFactory.eINSTANCE.createUseCaseStep();
					dummy.setContent("_ext_" + prevStep.getLabel());
					t.setRelatedStep(dummy);
					src.getTransitions().add(t);
					t.setSourceState(src);
					t.setTargetState(extHolder);
				}
				ltsCache.getExtClosures().remove(srcState);
				
				Transition t = Lts2Factory.eINSTANCE.createTransition();
				((TransitionalState) srcState).getTransitions().add(t);
				UseCaseStep dummy = reprotool.model.usecase.UsecaseFactory.eINSTANCE.createUseCaseStep();
				dummy.setContent("_ext_" + prevStep.getLabel());
				t.setRelatedStep(dummy);
				t.setSourceState((TransitionalState) srcState);
				t.setTargetState(extHolder);
				ltsCache.getUCStep2TransLayout().put(prevStep, t);
				
				srcState = extHolder;
				ltsCache.getUCStep2TSrcState().put(ucStep, srcState);
			}

			// Variations are attached to the source state.
			if (!ucStep.getVariations().isEmpty()) {
				for (int i = 0; i < ucStep.getVariations().size(); i++) {
					Scenario sc = ucStep.getVariations().get(i);
					processScenario(sc, srcState, tgtState, false);
				}
			}
			
			if (ucStep.getAction() instanceof AbortUseCase) {				
				Transition t = Lts2Factory.eINSTANCE.createTransition();
				t.setRelatedStep(ucStep);
				Assert.isTrue(srcState instanceof TransitionalState);
				TransitionalState srcTransitional = (TransitionalState) srcState;
				t.setSourceState(srcTransitional);
				if (labelTransitionSystem.getAbortState() == null) {
					AbortState abortState = Lts2Factory.eINSTANCE.createAbortState();
					labelTransitionSystem.setAbortState(abortState);
				}
				t.setTargetState(labelTransitionSystem.getAbortState());				
				srcTransitional.getTransitions().add(t);
				ltsCache.getUCStep2Trans().put(ucStep, t);
				ltsCache.getUCStep2TransLayout().put(ucStep, t);
				continue;
			}
			
			if(ucStep.getAction() instanceof Goto) {
				ltsCache.getGotoSteps().add(ucStep);
				continue;
			}
				
			Transition t = Lts2Factory.eINSTANCE.createTransition();
			t.setRelatedStep(ucStep);

			ltsCache.getUCStep2Trans().put(ucStep, t);
			if (!ltsCache.getUCStep2TransLayout().containsKey(ucStep)) {
				ltsCache.getUCStep2TransLayout().put(ucStep, t);
			}
			
			Assert.isTrue(srcState instanceof TransitionalState);
			TransitionalState srcTransitional = (TransitionalState) srcState;
			t.setSourceState(srcTransitional);
			
			if (tgtState instanceof TransitionalState) {
				labelTransitionSystem.getTransitionalStates().add((TransitionalState) tgtState);
			}
			t.setTargetState(tgtState);
			srcTransitional.getTransitions().add(t);
			
			// Extensions are attached to the target state
			if (!ucStep.getExtensions().isEmpty()) {
				ltsCache.getExtClosures().put(tgtState, new ArrayList<TransitionalState>());
				
				for (int i = 0; i < ucStep.getExtensions().size(); i++) {
					Scenario sc = ucStep.getExtensions().get(i);
					if (!sc.getSteps().isEmpty()) {
						UseCaseStep lStep = sc.getSteps().get(sc.getSteps().size() - 1);
						State st = processScenario(sc, tgtState, null, false);
						
						if (
							(!(lStep.getAction() instanceof Goto)) &&
							(!(lStep.getAction() instanceof AbortUseCase))
						) {
						
							Assert.isNotNull(ltsCache.getExtClosures().get(tgtState));
							Assert.isTrue(st instanceof TransitionalState);
							ltsCache.getExtClosures().get(tgtState).add((TransitionalState) st);
						}
					}
				}
			} 
			
			// iterate.
			srcState = tgtState;
			prevStep = ucStep;
		}	
		
		if (
				(srcState != init) &&
				(mainScenario) &&
				(ltsCache.getExtClosures().containsKey(srcState))
		) {
			for (TransitionalState src: ltsCache.getExtClosures().get(srcState)) {
				Transition t = Lts2Factory.eINSTANCE.createTransition();
				UseCaseStep dummy = reprotool.model.usecase.UsecaseFactory.eINSTANCE.createUseCaseStep();
				dummy.setContent("_ext_" + prevStep.getLabel());
				t.setRelatedStep(dummy);
				src.getTransitions().add(t);
				t.setSourceState(src);
				t.setTargetState(labelTransitionSystem.getFinalState());
			}
			ltsCache.getExtClosures().remove(srcState);
			
			State tgtState = labelTransitionSystem.getFinalState();
			
			Transition t = Lts2Factory.eINSTANCE.createTransition();
			UseCaseStep dummy = reprotool.model.usecase.UsecaseFactory.eINSTANCE.createUseCaseStep();
			dummy.setContent("_ext_" + prevStep.getLabel());
			t.setRelatedStep(dummy);
			ltsCache.getUCStep2TransLayout().put(lastStep, t);
			Assert.isTrue(srcState instanceof TransitionalState);
			TransitionalState srcTransitional = (TransitionalState) srcState;
			t.setSourceState(srcTransitional);
			t.setTargetState(tgtState);
			srcTransitional.getTransitions().add(t);
		}
				
		if (
				(srcState != init) &&
				(!mainScenario) &&
				(ltsCache.getExtClosures().containsKey(srcState)) &&
				(!ltsCache.getExtClosures().get(srcState).isEmpty())
		) {

			TransitionalState extHolder = Lts2Factory.eINSTANCE.createTransitionalState();
			labelTransitionSystem.getTransitionalStates().add(extHolder);

			for (TransitionalState src: ltsCache.getExtClosures().get(srcState)) {
				Transition t = Lts2Factory.eINSTANCE.createTransition();
				UseCaseStep dummy = reprotool.model.usecase.UsecaseFactory.eINSTANCE.createUseCaseStep();
				dummy.setContent("_ext_" + prevStep.getLabel());
				t.setRelatedStep(dummy);
				src.getTransitions().add(t);
				t.setSourceState(src);
				t.setTargetState(extHolder);
			}
			ltsCache.getExtClosures().remove(srcState);
			
			Transition t = Lts2Factory.eINSTANCE.createTransition();
			((TransitionalState) srcState).getTransitions().add(t);
			UseCaseStep dummy = reprotool.model.usecase.UsecaseFactory.eINSTANCE.createUseCaseStep();
			dummy.setContent("_ext_" + prevStep.getLabel());
			t.setRelatedStep(dummy);
			t.setSourceState((TransitionalState) srcState);
			t.setTargetState(extHolder);
			ltsCache.getUCStep2TransLayout().put(prevStep, t);
			
			srcState = extHolder;
		}		
		
		if (
				(!(lastStep.getAction() instanceof Goto)) &&
				(!(lastStep.getAction() instanceof AbortUseCase)) &&
				(next != null)
		) {
			Transition t = Lts2Factory.eINSTANCE.createTransition();
			t.setRelatedStep(null);
			Assert.isTrue(srcState instanceof TransitionalState);
			TransitionalState srcTransitional = (TransitionalState) srcState;
			t.setSourceState(srcTransitional);
			t.setTargetState(next);
			srcTransitional.getTransitions().add(t);
		}
		
		return srcState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Lts2Package.LTS_GENERATOR__LABEL_TRANSITION_SYSTEM:
				return basicSetLabelTransitionSystem(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Lts2Package.LTS_GENERATOR__LABEL_TRANSITION_SYSTEM:
				return getLabelTransitionSystem();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Lts2Package.LTS_GENERATOR__LABEL_TRANSITION_SYSTEM:
				return labelTransitionSystem != null;
		}
		return super.eIsSet(featureID);
	}

} //LTSGeneratorImpl
