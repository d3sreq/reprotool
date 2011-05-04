/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification;

import reprotool.model.traceability.TraceableEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.specification.Requirement#getOriginalText <em>Original Text</em>}</li>
 *   <li>{@link reprotool.model.specification.Requirement#getOriginalId <em>Original Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.specification.SpecificationPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends TraceableEntity {
	/**
	 * Returns the value of the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Text</em>' attribute.
	 * @see #setOriginalText(String)
	 * @see reprotool.model.specification.SpecificationPackage#getRequirement_OriginalText()
	 * @model
	 * @generated
	 */
	String getOriginalText();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.Requirement#getOriginalText <em>Original Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Text</em>' attribute.
	 * @see #getOriginalText()
	 * @generated
	 */
	void setOriginalText(String value);

	/**
	 * Returns the value of the '<em><b>Original Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Id</em>' attribute.
	 * @see #setOriginalId(String)
	 * @see reprotool.model.specification.SpecificationPackage#getRequirement_OriginalId()
	 * @model
	 * @generated
	 */
	String getOriginalId();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.Requirement#getOriginalId <em>Original Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Id</em>' attribute.
	 * @see #getOriginalId()
	 * @generated
	 */
	void setOriginalId(String value);

} // Requirement
