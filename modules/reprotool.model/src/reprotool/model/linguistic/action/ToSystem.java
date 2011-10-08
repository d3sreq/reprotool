/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import reprotool.model.linguistic.actionpart.SentenceActor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.ToSystem#getSender <em>Sender</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getToSystem()
 * @model
 * @generated
 */
public interface ToSystem extends Communication {
	/**
	 * Returns the value of the '<em><b>Sender</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' containment reference.
	 * @see #setSender(SentenceActor)
	 * @see reprotool.model.linguistic.action.ActionPackage#getToSystem_Sender()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SentenceActor getSender();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.ToSystem#getSender <em>Sender</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' containment reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(SentenceActor value);

} // ToSystem
