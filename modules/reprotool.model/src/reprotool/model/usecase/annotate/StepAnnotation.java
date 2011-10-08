/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.annotate.StepAnnotation#getId <em>Id</em>}</li>
 *   <li>{@link reprotool.model.usecase.annotate.StepAnnotation#getAnnotationType <em>Annotation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.annotate.AnnotatePackage#getStepAnnotation()
 * @model
 * @generated
 */
public interface StepAnnotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see reprotool.model.usecase.annotate.AnnotatePackage#getStepAnnotation_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.annotate.StepAnnotation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Annotation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Type</em>' reference.
	 * @see #setAnnotationType(StepAnnotationType)
	 * @see reprotool.model.usecase.annotate.AnnotatePackage#getStepAnnotation_AnnotationType()
	 * @model required="true"
	 * @generated
	 */
	StepAnnotationType getAnnotationType();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.annotate.StepAnnotation#getAnnotationType <em>Annotation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Type</em>' reference.
	 * @see #getAnnotationType()
	 * @generated
	 */
	void setAnnotationType(StepAnnotationType value);

} // StepAnnotation
