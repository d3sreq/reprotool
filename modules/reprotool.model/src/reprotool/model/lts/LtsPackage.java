/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see reprotool.model.lts.LtsFactory
 * @model kind="package"
 * @generated
 */
public interface LtsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/lts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LtsPackage eINSTANCE = reprotool.model.lts.impl.LtsPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.lts.Transition <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.lts.Transition
	 * @see reprotool.model.lts.impl.LtsPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SENTENCE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link reprotool.model.lts.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.lts.impl.StateImpl
	 * @see reprotool.model.lts.impl.LtsPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Token</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TOKEN = 0;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.lts.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.lts.impl.StateMachineImpl
	 * @see reprotool.model.lts.impl.LtsPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 2;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__INITIAL_STATE = 0;

	/**
	 * The feature id for the '<em><b>Abort State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__ABORT_STATE = 1;

	/**
	 * The feature id for the '<em><b>Success State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__SUCCESS_STATE = 2;

	/**
	 * The feature id for the '<em><b>All Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__ALL_TRANSITIONS = 3;

	/**
	 * The feature id for the '<em><b>All States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__ALL_STATES = 4;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link reprotool.model.lts.impl.ActionTransitionImpl <em>Action Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.lts.impl.ActionTransitionImpl
	 * @see reprotool.model.lts.impl.LtsPackageImpl#getActionTransition()
	 * @generated
	 */
	int ACTION_TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TRANSITION__SENTENCE = TRANSITION__SENTENCE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TRANSITION__SOURCE = TRANSITION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TRANSITION__TARGET = TRANSITION__TARGET;

	/**
	 * The number of structural features of the '<em>Action Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link reprotool.model.lts.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see reprotool.model.lts.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.lts.Transition#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sentence</em>'.
	 * @see reprotool.model.lts.Transition#getSentence()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Sentence();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.lts.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see reprotool.model.lts.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.lts.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see reprotool.model.lts.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for class '{@link reprotool.model.lts.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see reprotool.model.lts.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute list '{@link reprotool.model.lts.State#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Token</em>'.
	 * @see reprotool.model.lts.State#getToken()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Token();

	/**
	 * Returns the meta object for class '{@link reprotool.model.lts.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see reprotool.model.lts.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.lts.StateMachine#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see reprotool.model.lts.StateMachine#getInitialState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_InitialState();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.lts.StateMachine#getAbortState <em>Abort State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Abort State</em>'.
	 * @see reprotool.model.lts.StateMachine#getAbortState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_AbortState();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.lts.StateMachine#getSuccessState <em>Success State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Success State</em>'.
	 * @see reprotool.model.lts.StateMachine#getSuccessState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_SuccessState();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.lts.StateMachine#getAllTransitions <em>All Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All Transitions</em>'.
	 * @see reprotool.model.lts.StateMachine#getAllTransitions()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_AllTransitions();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.lts.StateMachine#getAllStates <em>All States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All States</em>'.
	 * @see reprotool.model.lts.StateMachine#getAllStates()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_AllStates();

	/**
	 * Returns the meta object for class '{@link reprotool.model.lts.ActionTransition <em>Action Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Transition</em>'.
	 * @see reprotool.model.lts.ActionTransition
	 * @generated
	 */
	EClass getActionTransition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LtsFactory getLtsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link reprotool.model.lts.Transition <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.lts.Transition
		 * @see reprotool.model.lts.impl.LtsPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SENTENCE = eINSTANCE.getTransition_Sentence();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '{@link reprotool.model.lts.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.lts.impl.StateImpl
		 * @see reprotool.model.lts.impl.LtsPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__TOKEN = eINSTANCE.getState_Token();

		/**
		 * The meta object literal for the '{@link reprotool.model.lts.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.lts.impl.StateMachineImpl
		 * @see reprotool.model.lts.impl.LtsPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__INITIAL_STATE = eINSTANCE.getStateMachine_InitialState();

		/**
		 * The meta object literal for the '<em><b>Abort State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__ABORT_STATE = eINSTANCE.getStateMachine_AbortState();

		/**
		 * The meta object literal for the '<em><b>Success State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__SUCCESS_STATE = eINSTANCE.getStateMachine_SuccessState();

		/**
		 * The meta object literal for the '<em><b>All Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__ALL_TRANSITIONS = eINSTANCE.getStateMachine_AllTransitions();

		/**
		 * The meta object literal for the '<em><b>All States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__ALL_STATES = eINSTANCE.getStateMachine_AllStates();

		/**
		 * The meta object literal for the '{@link reprotool.model.lts.impl.ActionTransitionImpl <em>Action Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.lts.impl.ActionTransitionImpl
		 * @see reprotool.model.lts.impl.LtsPackageImpl#getActionTransition()
		 * @generated
		 */
		EClass ACTION_TRANSITION = eINSTANCE.getActionTransition();

	}

} //LtsPackage
