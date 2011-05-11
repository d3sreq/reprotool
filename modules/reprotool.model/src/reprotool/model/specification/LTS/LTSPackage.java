/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification.LTS;

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
 * @see reprotool.model.specification.LTS.LTSFactory
 * @model kind="package"
 * @generated
 */
public interface LTSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "LTS";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/specification/LTS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "LTS";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LTSPackage eINSTANCE = reprotool.model.specification.LTS.impl.LTSPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.specification.LTS.Transition <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.LTS.Transition
	 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getTransition()
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
	 * The meta object id for the '{@link reprotool.model.specification.LTS.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.LTS.impl.StateImpl
	 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.LTS.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.LTS.impl.StateMachineImpl
	 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getStateMachine()
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
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.LTS.impl.ActionTransitionImpl <em>Action Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.LTS.impl.ActionTransitionImpl
	 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getActionTransition()
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
	 * The meta object id for the '{@link reprotool.model.specification.LTS.impl.GuardTransitionImpl <em>Guard Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.LTS.impl.GuardTransitionImpl
	 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getGuardTransition()
	 * @generated
	 */
	int GUARD_TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TRANSITION__SENTENCE = TRANSITION__SENTENCE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TRANSITION__SOURCE = TRANSITION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TRANSITION__TARGET = TRANSITION__TARGET;

	/**
	 * The feature id for the '<em><b>Negated Guards</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TRANSITION__NEGATED_GUARDS = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.LTS.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see reprotool.model.specification.LTS.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.LTS.Transition#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sentence</em>'.
	 * @see reprotool.model.specification.LTS.Transition#getSentence()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Sentence();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.LTS.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see reprotool.model.specification.LTS.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.LTS.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see reprotool.model.specification.LTS.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.LTS.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see reprotool.model.specification.LTS.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.LTS.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see reprotool.model.specification.LTS.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.LTS.StateMachine#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see reprotool.model.specification.LTS.StateMachine#getInitialState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_InitialState();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.LTS.StateMachine#getAbortState <em>Abort State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Abort State</em>'.
	 * @see reprotool.model.specification.LTS.StateMachine#getAbortState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_AbortState();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.LTS.StateMachine#getSuccessState <em>Success State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Success State</em>'.
	 * @see reprotool.model.specification.LTS.StateMachine#getSuccessState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_SuccessState();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.LTS.ActionTransition <em>Action Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Transition</em>'.
	 * @see reprotool.model.specification.LTS.ActionTransition
	 * @generated
	 */
	EClass getActionTransition();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.LTS.GuardTransition <em>Guard Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Transition</em>'.
	 * @see reprotool.model.specification.LTS.GuardTransition
	 * @generated
	 */
	EClass getGuardTransition();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.specification.LTS.GuardTransition#getNegatedGuards <em>Negated Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Negated Guards</em>'.
	 * @see reprotool.model.specification.LTS.GuardTransition#getNegatedGuards()
	 * @see #getGuardTransition()
	 * @generated
	 */
	EReference getGuardTransition_NegatedGuards();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LTSFactory getLTSFactory();

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
		 * The meta object literal for the '{@link reprotool.model.specification.LTS.Transition <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.LTS.Transition
		 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getTransition()
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
		 * The meta object literal for the '{@link reprotool.model.specification.LTS.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.LTS.impl.StateImpl
		 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.LTS.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.LTS.impl.StateMachineImpl
		 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getStateMachine()
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
		 * The meta object literal for the '{@link reprotool.model.specification.LTS.impl.ActionTransitionImpl <em>Action Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.LTS.impl.ActionTransitionImpl
		 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getActionTransition()
		 * @generated
		 */
		EClass ACTION_TRANSITION = eINSTANCE.getActionTransition();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.LTS.impl.GuardTransitionImpl <em>Guard Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.LTS.impl.GuardTransitionImpl
		 * @see reprotool.model.specification.LTS.impl.LTSPackageImpl#getGuardTransition()
		 * @generated
		 */
		EClass GUARD_TRANSITION = eINSTANCE.getGuardTransition();

		/**
		 * The meta object literal for the '<em><b>Negated Guards</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_TRANSITION__NEGATED_GUARDS = eINSTANCE.getGuardTransition_NegatedGuards();

	}

} //LTSPackage
