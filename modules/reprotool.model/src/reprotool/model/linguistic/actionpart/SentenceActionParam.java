/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart;

import reprotool.model.swproj.ConceptualObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sentence Action Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.actionpart.SentenceActionParam#getConceptualObject <em>Conceptual Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getSentenceActionParam()
 * @model
 * @generated
 */
public interface SentenceActionParam extends ActionPart {
	/**
	 * Returns the value of the '<em><b>Conceptual Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptual Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptual Object</em>' reference.
	 * @see #setConceptualObject(ConceptualObject)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getSentenceActionParam_ConceptualObject()
	 * @model required="true"
	 * @generated
	 */
	ConceptualObject getConceptualObject();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.SentenceActionParam#getConceptualObject <em>Conceptual Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptual Object</em>' reference.
	 * @see #getConceptualObject()
	 * @generated
	 */
	void setConceptualObject(ConceptualObject value);

} // SentenceActionParam
