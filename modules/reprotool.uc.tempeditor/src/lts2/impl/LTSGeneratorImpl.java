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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.action.Goto;
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
 *   <li>{@link lts2.impl.LTSGeneratorImpl#getGotoTransitions <em>Goto Transitions</em>}</li>
 *   <li>{@link lts2.impl.LTSGeneratorImpl#getLabelTransitionSystem <em>Label Transition System</em>}</li>
 *   <li>{@link lts2.impl.LTSGeneratorImpl#getStepToTransitionMap <em>Step To Transition Map</em>}</li>
 *   <li>{@link lts2.impl.LTSGeneratorImpl#getRegisterExtClosure <em>Register Ext Closure</em>}</li>
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
	 * The cached value of the '{@link #getStepToTransitionMap() <em>Step To Transition Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepToTransitionMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<UseCaseStep, Transition> stepToTransitionMap;

	/**
	 * The cached value of the '{@link #getRegisterExtClosure() <em>Register Ext Closure</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisterExtClosure()
	 * @generated
	 * @ordered
	 */
	protected EMap<State, EList<State>> registerExtClosure;

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
	 * Goto transitions 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Transition> getGotoTransitions() {
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
	public boolean isSetGotoTransitions() {
		return true;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<UseCaseStep, Transition> getStepToTransitionMap() {
		if (stepToTransitionMap == null) {
			stepToTransitionMap = new EcoreEMap<UseCaseStep,Transition>(Lts2Package.Literals.STEP_TO_TRANSITION_MAP, StepToTransitionMapImpl.class, this, Lts2Package.LTS_GENERATOR__STEP_TO_TRANSITION_MAP);
		}
		return stepToTransitionMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<State, EList<State>> getRegisterExtClosure() {
		if (registerExtClosure == null) {
			registerExtClosure = new EcoreEMap<State,EList<State>>(Lts2Package.Literals.REGISTER_EXT_CLOSURE, RegisterExtClosureImpl.class, this, Lts2Package.LTS_GENERATOR__REGISTER_EXT_CLOSURE);
		}
		return registerExtClosure;
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
			case Lts2Package.LTS_GENERATOR__STEP_TO_TRANSITION_MAP:
				return ((InternalEList<?>)getStepToTransitionMap()).basicRemove(otherEnd, msgs);
			case Lts2Package.LTS_GENERATOR__REGISTER_EXT_CLOSURE:
				return ((InternalEList<?>)getRegisterExtClosure()).basicRemove(otherEnd, msgs);
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
			case Lts2Package.LTS_GENERATOR__GOTO_TRANSITIONS:
				return getGotoTransitions();
			case Lts2Package.LTS_GENERATOR__LABEL_TRANSITION_SYSTEM:
				return getLabelTransitionSystem();
			case Lts2Package.LTS_GENERATOR__STEP_TO_TRANSITION_MAP:
				if (coreType) return getStepToTransitionMap();
				else return getStepToTransitionMap().map();
			case Lts2Package.LTS_GENERATOR__REGISTER_EXT_CLOSURE:
				if (coreType) return getRegisterExtClosure();
				else return getRegisterExtClosure().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Lts2Package.LTS_GENERATOR__STEP_TO_TRANSITION_MAP:
				((EStructuralFeature.Setting)getStepToTransitionMap()).set(newValue);
				return;
			case Lts2Package.LTS_GENERATOR__REGISTER_EXT_CLOSURE:
				((EStructuralFeature.Setting)getRegisterExtClosure()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Lts2Package.LTS_GENERATOR__STEP_TO_TRANSITION_MAP:
				getStepToTransitionMap().clear();
				return;
			case Lts2Package.LTS_GENERATOR__REGISTER_EXT_CLOSURE:
				getRegisterExtClosure().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Lts2Package.LTS_GENERATOR__GOTO_TRANSITIONS:
				return isSetGotoTransitions();
			case Lts2Package.LTS_GENERATOR__LABEL_TRANSITION_SYSTEM:
				return labelTransitionSystem != null;
			case Lts2Package.LTS_GENERATOR__STEP_TO_TRANSITION_MAP:
				return stepToTransitionMap != null && !stepToTransitionMap.isEmpty();
			case Lts2Package.LTS_GENERATOR__REGISTER_EXT_CLOSURE:
				return registerExtClosure != null && !registerExtClosure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LTSGeneratorImpl
