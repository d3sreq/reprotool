/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lts2;

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
 *   <li>{@link lts2.StateMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link lts2.StateMachine#getTransitionalStates <em>Transitional States</em>}</li>
 *   <li>{@link lts2.StateMachine#getFinalState <em>Final State</em>}</li>
 *   <li>{@link lts2.StateMachine#getAbortState <em>Abort State</em>}</li>
 * </ul>
 * </p>
 *
 * @see lts2.Lts2Package#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' containment reference.
	 * @see #setInitialState(InitialState)
	 * @see lts2.Lts2Package#getStateMachine_InitialState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InitialState getInitialState();

	/**
	 * Sets the value of the '{@link lts2.StateMachine#getInitialState <em>Initial State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' containment reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(InitialState value);

	/**
	 * Returns the value of the '<em><b>Transitional States</b></em>' containment reference list.
	 * The list contents are of type {@link lts2.TransitionalState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitional States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitional States</em>' containment reference list.
	 * @see lts2.Lts2Package#getStateMachine_TransitionalStates()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransitionalState> getTransitionalStates();

	/**
	 * Returns the value of the '<em><b>Final State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final State</em>' containment reference.
	 * @see #setFinalState(FinalState)
	 * @see lts2.Lts2Package#getStateMachine_FinalState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FinalState getFinalState();

	/**
	 * Sets the value of the '{@link lts2.StateMachine#getFinalState <em>Final State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final State</em>' containment reference.
	 * @see #getFinalState()
	 * @generated
	 */
	void setFinalState(FinalState value);

	/**
	 * Returns the value of the '<em><b>Abort State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abort State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abort State</em>' containment reference.
	 * @see #setAbortState(AbortState)
	 * @see lts2.Lts2Package#getStateMachine_AbortState()
	 * @model containment="true"
	 * @generated
	 */
	AbortState getAbortState();

	/**
	 * Sets the value of the '{@link lts2.StateMachine#getAbortState <em>Abort State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abort State</em>' containment reference.
	 * @see #getAbortState()
	 * @generated
	 */
	void setAbortState(AbortState value);

} // StateMachine
