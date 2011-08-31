/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import reprotool.model.linguistic.actionpart.RepresentativeObject;
import reprotool.model.linguistic.actionpart.Verb;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.Internal#getVerb <em>Verb</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.Internal#getRepresentativeObjects <em>Representative Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getInternal()
 * @model
 * @generated
 */
public interface Internal extends Action {
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
	 * @see reprotool.model.linguistic.action.ActionPackage#getInternal_Verb()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Verb getVerb();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Internal#getVerb <em>Verb</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verb</em>' containment reference.
	 * @see #getVerb()
	 * @generated
	 */
	void setVerb(Verb value);

	/**
	 * Returns the value of the '<em><b>Representative Objects</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representative Objects</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representative Objects</em>' containment reference.
	 * @see #setRepresentativeObjects(RepresentativeObject)
	 * @see reprotool.model.linguistic.action.ActionPackage#getInternal_RepresentativeObjects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RepresentativeObject getRepresentativeObjects();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Internal#getRepresentativeObjects <em>Representative Objects</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representative Objects</em>' containment reference.
	 * @see #getRepresentativeObjects()
	 * @generated
	 */
	void setRepresentativeObjects(RepresentativeObject value);

} // Internal
