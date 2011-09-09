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
 * A representation of the model object '<em><b>Special Annotation Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.annotate.SpecialAnnotationSet#getContains <em>Contains</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.annotate.AnnotatePackage#getSpecialAnnotationSet()
 * @model
 * @generated
 */
public interface SpecialAnnotationSet extends AnnotationSet {
	/**
	 * Returns the value of the '<em><b>Contains</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.annotate.SpecialAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' containment reference list.
	 * @see reprotool.model.usecase.annotate.AnnotatePackage#getSpecialAnnotationSet_Contains()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<SpecialAnnotation> getContains();

} // SpecialAnnotationSet
