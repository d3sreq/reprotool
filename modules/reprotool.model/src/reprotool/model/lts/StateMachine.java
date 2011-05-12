/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.lts.StateMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link reprotool.model.lts.StateMachine#getAbortState <em>Abort State</em>}</li>
 *   <li>{@link reprotool.model.lts.StateMachine#getSuccessState <em>Success State</em>}</li>
 *   <li>{@link reprotool.model.lts.StateMachine#getAllTransitions <em>All Transitions</em>}</li>
 *   <li>{@link reprotool.model.lts.StateMachine#getAllStates <em>All States</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.lts.LtsPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see reprotool.model.lts.LtsPackage#getStateMachine_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link reprotool.model.lts.StateMachine#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Abort State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abort State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abort State</em>' reference.
	 * @see #setAbortState(State)
	 * @see reprotool.model.lts.LtsPackage#getStateMachine_AbortState()
	 * @model
	 * @generated
	 */
	State getAbortState();

	/**
	 * Sets the value of the '{@link reprotool.model.lts.StateMachine#getAbortState <em>Abort State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abort State</em>' reference.
	 * @see #getAbortState()
	 * @generated
	 */
	void setAbortState(State value);

	/**
	 * Returns the value of the '<em><b>Success State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Success State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success State</em>' reference.
	 * @see #setSuccessState(State)
	 * @see reprotool.model.lts.LtsPackage#getStateMachine_SuccessState()
	 * @model required="true"
	 * @generated
	 */
	State getSuccessState();

	/**
	 * Sets the value of the '{@link reprotool.model.lts.StateMachine#getSuccessState <em>Success State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success State</em>' reference.
	 * @see #getSuccessState()
	 * @generated
	 */
	void setSuccessState(State value);

	/**
	 * Returns the value of the '<em><b>All Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.lts.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Transitions</em>' containment reference list.
	 * @see reprotool.model.lts.LtsPackage#getStateMachine_AllTransitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getAllTransitions();

	/**
	 * Returns the value of the '<em><b>All States</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.lts.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All States</em>' containment reference list.
	 * @see reprotool.model.lts.LtsPackage#getStateMachine_AllStates()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getAllStates();

} // StateMachine
