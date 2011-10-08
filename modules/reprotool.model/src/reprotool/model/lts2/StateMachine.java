/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts2;

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
 *   <li>{@link reprotool.model.lts2.StateMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link reprotool.model.lts2.StateMachine#getTransitionalStates <em>Transitional States</em>}</li>
 *   <li>{@link reprotool.model.lts2.StateMachine#getFinalState <em>Final State</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.lts2.Lts2Package#getStateMachine()
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
	 * @see reprotool.model.lts2.Lts2Package#getStateMachine_InitialState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InitialState getInitialState();

	/**
	 * Sets the value of the '{@link reprotool.model.lts2.StateMachine#getInitialState <em>Initial State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' containment reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(InitialState value);

	/**
	 * Returns the value of the '<em><b>Transitional States</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.lts2.TransitionalState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitional States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitional States</em>' containment reference list.
	 * @see reprotool.model.lts2.Lts2Package#getStateMachine_TransitionalStates()
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
	 * @see reprotool.model.lts2.Lts2Package#getStateMachine_FinalState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FinalState getFinalState();

	/**
	 * Sets the value of the '{@link reprotool.model.lts2.StateMachine#getFinalState <em>Final State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final State</em>' containment reference.
	 * @see #getFinalState()
	 * @generated
	 */
	void setFinalState(FinalState value);

} // StateMachine
