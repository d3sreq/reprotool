/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.usecase.annotate.AnnotatePackage
 * @generated
 */
public interface AnnotateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotateFactory eINSTANCE = reprotool.model.usecase.annotate.impl.AnnotateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Step Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step Annotation</em>'.
	 * @generated
	 */
	StepAnnotation createStepAnnotation();

	/**
	 * Returns a new object of class '<em>Temporal Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Temporal Annotation</em>'.
	 * @generated
	 */
	TemporalAnnotation createTemporalAnnotation();

	/**
	 * Returns a new object of class '<em>LTL Annotation Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LTL Annotation Set</em>'.
	 * @generated
	 */
	LTLAnnotationSet createLTLAnnotationSet();

	/**
	 * Returns a new object of class '<em>Special Annotation Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Special Annotation Set</em>'.
	 * @generated
	 */
	SpecialAnnotationSet createSpecialAnnotationSet();

	/**
	 * Returns a new object of class '<em>Trace Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Annotation</em>'.
	 * @generated
	 */
	TraceAnnotation createTraceAnnotation();

	/**
	 * Returns a new object of class '<em>On Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Annotation</em>'.
	 * @generated
	 */
	OnAnnotation createOnAnnotation();

	/**
	 * Returns a new object of class '<em>CTL Annotation Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CTL Annotation Set</em>'.
	 * @generated
	 */
	CTLAnnotationSet createCTLAnnotationSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnnotatePackage getAnnotatePackage();

} //AnnotateFactory
