/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LTL Annotation Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.annotate.LTLAnnotationSet#getContains <em>Contains</em>}</li>
 *   <li>{@link reprotool.model.usecase.annotate.LTLAnnotationSet#getLtlFormula <em>Ltl Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.annotate.AnnotatePackage#getLTLAnnotationSet()
 * @model
 * @generated
 */
public interface LTLAnnotationSet extends AnnotationSet {
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
	 * @see reprotool.model.usecase.annotate.AnnotatePackage#getLTLAnnotationSet_Contains()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TemporalAnnotation> getContains();

	/**
	 * Returns the value of the '<em><b>Ltl Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ltl Formula</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ltl Formula</em>' attribute.
	 * @see #setLtlFormula(String)
	 * @see reprotool.model.usecase.annotate.AnnotatePackage#getLTLAnnotationSet_LtlFormula()
	 * @model
	 * @generated
	 */
	String getLtlFormula();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.annotate.LTLAnnotationSet#getLtlFormula <em>Ltl Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ltl Formula</em>' attribute.
	 * @see #getLtlFormula()
	 * @generated
	 */
	void setLtlFormula(String value);

} // LTLAnnotationSet
