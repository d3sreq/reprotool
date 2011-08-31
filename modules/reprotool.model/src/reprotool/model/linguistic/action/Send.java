/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import reprotool.model.linguistic.actionpart.IndirectObject;
import reprotool.model.linguistic.actionpart.RepresentativeObject;
import reprotool.model.linguistic.actionpart.Subject;
import reprotool.model.linguistic.actionpart.Verb;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.Send#getVerb <em>Verb</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.Send#getSubject <em>Subject</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.Send#getRepresentativeObject <em>Representative Object</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.Send#getIndirectObject <em>Indirect Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getSend()
 * @model
 * @generated
 */
public interface Send extends Action {
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
	 * @see reprotool.model.linguistic.action.ActionPackage#getSend_Verb()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Verb getVerb();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Send#getVerb <em>Verb</em>}' containment reference.
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
	 * @see reprotool.model.linguistic.action.ActionPackage#getSend_Subject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Subject getSubject();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Send#getSubject <em>Subject</em>}' containment reference.
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
	 * @see reprotool.model.linguistic.action.ActionPackage#getSend_RepresentativeObject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RepresentativeObject getRepresentativeObject();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Send#getRepresentativeObject <em>Representative Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representative Object</em>' containment reference.
	 * @see #getRepresentativeObject()
	 * @generated
	 */
	void setRepresentativeObject(RepresentativeObject value);

	/**
	 * Returns the value of the '<em><b>Indirect Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indirect Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indirect Object</em>' containment reference.
	 * @see #setIndirectObject(IndirectObject)
	 * @see reprotool.model.linguistic.action.ActionPackage#getSend_IndirectObject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IndirectObject getIndirectObject();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Send#getIndirectObject <em>Indirect Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indirect Object</em>' containment reference.
	 * @see #getIndirectObject()
	 * @generated
	 */
	void setIndirectObject(IndirectObject value);

} // Send
