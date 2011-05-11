/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification.LTS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.specification.LTS.StateMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link reprotool.model.specification.LTS.StateMachine#getAbortState <em>Abort State</em>}</li>
 *   <li>{@link reprotool.model.specification.LTS.StateMachine#getSuccessState <em>Success State</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.specification.LTS.LTSPackage#getStateMachine()
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
	 * @see reprotool.model.specification.LTS.LTSPackage#getStateMachine_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.LTS.StateMachine#getInitialState <em>Initial State</em>}' reference.
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
	 * @see reprotool.model.specification.LTS.LTSPackage#getStateMachine_AbortState()
	 * @model
	 * @generated
	 */
	State getAbortState();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.LTS.StateMachine#getAbortState <em>Abort State</em>}' reference.
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
	 * @see reprotool.model.specification.LTS.LTSPackage#getStateMachine_SuccessState()
	 * @model required="true"
	 * @generated
	 */
	State getSuccessState();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.LTS.StateMachine#getSuccessState <em>Success State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success State</em>' reference.
	 * @see #getSuccessState()
	 * @generated
	 */
	void setSuccessState(State value);

} // StateMachine
