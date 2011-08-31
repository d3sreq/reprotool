/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import reprotool.model.linguistic.actionpart.RepresentativeObject;
import reprotool.model.linguistic.actionpart.Subject;
import reprotool.model.linguistic.actionpart.Verb;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.Receive#getVerb <em>Verb</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.Receive#getSubject <em>Subject</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.Receive#getRepresentativeObject <em>Representative Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getReceive()
 * @model
 * @generated
 */
public interface Receive extends Action {
	/**
	 * Returns the value of the '<em><b>Verb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verb</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verb</em>' containment reference.
	 * @see #setVerb(Verb)
	 * @see reprotool.model.linguistic.action.ActionPackage#getReceive_Verb()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Verb getVerb();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Receive#getVerb <em>Verb</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verb</em>' containment reference.
	 * @see #getVerb()
	 * @generated
	 */
	void setVerb(Verb value);

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' containment reference.
	 * @see #setSubject(Subject)
	 * @see reprotool.model.linguistic.action.ActionPackage#getReceive_Subject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Subject getSubject();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Receive#getSubject <em>Subject</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' containment reference.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(Subject value);

	/**
	 * Returns the value of the '<em><b>Representative Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representative Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representative Object</em>' containment reference.
	 * @see #setRepresentativeObject(RepresentativeObject)
	 * @see reprotool.model.linguistic.action.ActionPackage#getReceive_RepresentativeObject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RepresentativeObject getRepresentativeObject();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Receive#getRepresentativeObject <em>Representative Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representative Object</em>' containment reference.
	 * @see #getRepresentativeObject()
	 * @generated
	 */
	void setRepresentativeObject(RepresentativeObject value);

} // Receive
