/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lts2.impl;

import lts2.LTSGenerator;
import lts2.Lts2Package;
import lts2.State;
import lts2.StateMachine;
import lts2.Transition;
import lts2.TransitionalState;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.linguistic.action.Goto;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;

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
	 * @generated
	 */
	protected LTSGeneratorImpl() {
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

	/**
	 * Helper method.
	 * @return List of GOTO transitions
	 * @generated NOT
	 */
	private EList<Transition> getGotoTransitions() {
		EList<Transition> outputList = new BasicEList<Transition>();
		for (TransitionalState state : labelTransitionSystem.getTransitionalStates()) {
			for (Transition transition : state.getTransitions()) {
				if( transition.getRelatedStep().getAction() instanceof Goto )
					outputList.add(transition);
			}
		}
		return outputList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void processUseCase(UseCase useCase) {
		processScenario(useCase.getMainScenario(), labelTransitionSystem.getInitialState(), null);
		processGotoSteps();
	}

	/**
	 * We can not process the goto steps while processing the scenario
	 * because at that time some goto targets may not be known yet.
	 * Thus we process the goto steps only after all steps have been visited.
	 * @generated NOT
	 */
	private void processGotoSteps() {
//		for (UseCaseStep ucStep: gotoSteps) {
//			Assert.isTrue(ucStep.getAction() instanceof Goto);
//			Goto gotoAction = (Goto) ucStep.getAction();
//			State src = ucStep2SrcState.get(ucStep);
//			State dst = ucStep2SrcState.get(gotoAction.getGotoTarget());
//			Assert.isNotNull(src);
//			Assert.isNotNull(dst);
//
//			Transition t = LtsFactory.eINSTANCE.createActionTransition();
//			// reference to UseCaseStep
//			assert t.getSentence() == null;
//			t.setSentence(ucStep);
//			
//			t.setSource(src);
//			t.setTarget(dst);
//			machine.getAllTransitions().add(t);
//			gotoTransitions.add(t);
//			ucStep2Trans.put(ucStep, t);
//		}
	}

	/**
	 * @param mainScenario
	 * @param initialState
	 * @param object
	 * @generated NOT
	 */
	private State processScenario(Scenario scen, State init, State next) {
		
		if ((scen == null) || (scen.getSteps().isEmpty())) {
			return null;
		}
		
		State srcState = init;
		
//		for(UseCaseStep ucStep: scen.getSteps()) {
//			//TODO: ucStep2SrcState.put(ucStep, srcState);
//			State tgtState = Lts2Factory.eINSTANCE.createTransitionalState();
//			
//			if ( srcState != init && registerExtClosure.containsKey(srcState) ) {
//				for (State src: registerExtClosure.get(srcState)) {
//
//					Transition t = Lts2Factory.eINSTANCE.createTransition();
//					// reference to UseCaseStep
//					assert t.getSentence() == null;
//					t.setSentence(ucStep);
//					
//					t.setSource(src);
//					t.setTarget(tgtState);
//
//					machine.getAllTransitions().add(t);
//				}
//				registerExtClosure.remove(srcState);
//			}

			// Variations are attached to the source state.
//			if (!ucStep.getVariations().isEmpty()) {
//				for (int i = 0; i < ucStep.getVariations().size(); i++) {
//					Scenario sc = ucStep.getVariations().get(i);
//					processScenario(sc, srcState, tgtState);
//				}
//			}
//			
//			if (ucStep.getAction() instanceof AbortUseCase) {				
//				Transition t = LtsFactory.eINSTANCE.createActionTransition();
//				// reference to UseCaseStep
//				assert t.getSentence() == null;
//				t.setSentence(ucStep);
//				
//				t.setSource(srcState);
//				t.setTarget(machine.getAbortState());				
//				machine.getAllTransitions().add(t);
//				ucStep2Trans.put(ucStep, t);
//				continue;
//			}
//			
//			if( ucStep.getAction() instanceof Goto ) {
//				gotoSteps.add(ucStep);
//				continue;
//			}
//			
//			
//			Transition t = LtsFactory.eINSTANCE.createActionTransition();
//			// reference to UseCaseStep
//			assert t.getSentence() == null;
//			t.setSentence(ucStep);
//
//			ucStep2Trans.put(ucStep, t);
//			t.setSource(srcState);
//			
//			machine.getAllStates().add(tgtState);
//			t.setTarget(tgtState);
//			machine.getAllTransitions().add(t);
//			
//			// Extensions are attached to the target state
//			if (!ucStep.getExtensions().isEmpty()) {
//				registerExtClosure.put(tgtState, new ArrayList<State>());
//				
//				for (int i = 0; i < ucStep.getExtensions().size(); i++) {
//					Scenario sc = ucStep.getExtensions().get(i);
//					if (!sc.getSteps().isEmpty()) {
//						UseCaseStep lastStep = sc.getSteps().get(sc.getSteps().size() - 1);
//						State st = processScenario(sc, tgtState, null);
//						if (
//							(!(lastStep.getAction() instanceof Goto)) &&
//							(!(lastStep.getAction() instanceof AbortUseCase))
//						) {
//							Assert.isNotNull(registerExtClosure.get(tgtState));
//							registerExtClosure.get(tgtState).add(st);
//						}
//					}
//				}
//			} 
//			
//			// iterate.
//			srcState = tgtState;
//		}
//		
//		UseCaseStep lastStep = s.getSteps().get(s.getSteps().size() - 1);
//		
//		if (
//				(!(lastStep.getAction() instanceof Goto)) &&
//				(!(lastStep.getAction() instanceof AbortUseCase)) &&
//				(next != null)
//		) {
//			Transition t = LtsFactory.eINSTANCE.createActionTransition();
//			// reference to UseCaseStep
//			assert t.getSentence() == null;
//			t.setSentence(lastStep);
//			
//			t.setSource(srcState);
//			t.setTarget(next);
//			machine.getAllTransitions().add(t);
//		}
		
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
