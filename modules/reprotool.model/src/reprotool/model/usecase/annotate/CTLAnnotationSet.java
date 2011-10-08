/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CTL Annotation Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.annotate.CTLAnnotationSet#getCtlFormula <em>Ctl Formula</em>}</li>
 *   <li>{@link reprotool.model.usecase.annotate.CTLAnnotationSet#getContains <em>Contains</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.annotate.AnnotatePackage#getCTLAnnotationSet()
 * @model
 * @generated
 */
public interface CTLAnnotationSet extends AnnotationSet {
	/**
	 * Returns the value of the '<em><b>Ctl Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ctl Formula</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ctl Formula</em>' attribute.
	 * @see #setCtlFormula(String)
	 * @see reprotool.model.usecase.annotate.AnnotatePackage#getCTLAnnotationSet_CtlFormula()
	 * @model
	 * @generated
	 */
	String getCtlFormula();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.annotate.CTLAnnotationSet#getCtlFormula <em>Ctl Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ctl Formula</em>' attribute.
	 * @see #getCtlFormula()
	 * @generated
	 */
	void setCtlFormula(String value);

	/**
	 * Returns the value of the '<em><b>Contains</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.annotate.TemporalAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' containment reference list.
	 * @see reprotool.model.usecase.annotate.AnnotatePackage#getCTLAnnotationSet_Contains()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TemporalAnnotation> getContains();

} // CTLAnnotationSet
