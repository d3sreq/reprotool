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
 * A representation of the model object '<em><b>From System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.FromSystem#getReceiver <em>Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getFromSystem()
 * @model
 * @generated
 */
public interface FromSystem extends Communication {
	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' containment reference.
	 * @see #setReceiver(SentenceActor)
	 * @see reprotool.model.linguistic.action.ActionPackage#getFromSystem_Receiver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SentenceActor getReceiver();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.FromSystem#getReceiver <em>Receiver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' containment reference.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(SentenceActor value);

} // FromSystem
