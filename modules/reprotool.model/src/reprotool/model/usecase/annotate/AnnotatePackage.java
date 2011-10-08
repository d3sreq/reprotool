/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see reprotool.model.usecase.annotate.AnnotateFactory
 * @model kind="package"
 * @generated
 */
public interface AnnotatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "annotate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/usecase/annotate";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "annotate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotatePackage eINSTANCE = reprotool.model.usecase.annotate.impl.AnnotatePackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.impl.StepAnnotationImpl <em>Step Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.impl.StepAnnotationImpl
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getStepAnnotation()
	 * @generated
	 */
	int STEP_ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_ANNOTATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Annotation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_ANNOTATION__ANNOTATION_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Step Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.StepAnnotationType <em>Step Annotation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.StepAnnotationType
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getStepAnnotationType()
	 * @generated
	 */
	int STEP_ANNOTATION_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_ANNOTATION_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Step Annotation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_ANNOTATION_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.impl.TemporalAnnotationImpl <em>Temporal Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.impl.TemporalAnnotationImpl
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getTemporalAnnotation()
	 * @generated
	 */
	int TEMPORAL_ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_ANNOTATION__NAME = STEP_ANNOTATION_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Temporal Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_ANNOTATION_FEATURE_COUNT = STEP_ANNOTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.SpecialAnnotation <em>Special Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.SpecialAnnotation
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getSpecialAnnotation()
	 * @generated
	 */
	int SPECIAL_ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ANNOTATION__NAME = STEP_ANNOTATION_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Special Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ANNOTATION_FEATURE_COUNT = STEP_ANNOTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.AnnotationSet <em>Annotation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.AnnotationSet
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getAnnotationSet()
	 * @generated
	 */
	int ANNOTATION_SET = 4;

	/**
	 * The number of structural features of the '<em>Annotation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_SET_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl <em>LTL Annotation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getLTLAnnotationSet()
	 * @generated
	 */
	int LTL_ANNOTATION_SET = 5;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LTL_ANNOTATION_SET__CONTAINS = ANNOTATION_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ltl Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LTL_ANNOTATION_SET__LTL_FORMULA = ANNOTATION_SET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>LTL Annotation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LTL_ANNOTATION_SET_FEATURE_COUNT = ANNOTATION_SET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.impl.SpecialAnnotationSetImpl <em>Special Annotation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.impl.SpecialAnnotationSetImpl
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getSpecialAnnotationSet()
	 * @generated
	 */
	int SPECIAL_ANNOTATION_SET = 6;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ANNOTATION_SET__CONTAINS = ANNOTATION_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Special Annotation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ANNOTATION_SET_FEATURE_COUNT = ANNOTATION_SET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.impl.TraceAnnotationImpl <em>Trace Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.impl.TraceAnnotationImpl
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getTraceAnnotation()
	 * @generated
	 */
	int TRACE_ANNOTATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ANNOTATION__NAME = STEP_ANNOTATION_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Trace Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ANNOTATION_FEATURE_COUNT = STEP_ANNOTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.impl.OnAnnotationImpl <em>On Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.impl.OnAnnotationImpl
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getOnAnnotation()
	 * @generated
	 */
	int ON_ANNOTATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_ANNOTATION__NAME = STEP_ANNOTATION_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>On Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_ANNOTATION_FEATURE_COUNT = STEP_ANNOTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.annotate.impl.CTLAnnotationSetImpl <em>CTL Annotation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.annotate.impl.CTLAnnotationSetImpl
	 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getCTLAnnotationSet()
	 * @generated
	 */
	int CTL_ANNOTATION_SET = 9;

	/**
	 * The feature id for the '<em><b>Ctl Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTL_ANNOTATION_SET__CTL_FORMULA = ANNOTATION_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTL_ANNOTATION_SET__CONTAINS = ANNOTATION_SET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CTL Annotation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTL_ANNOTATION_SET_FEATURE_COUNT = ANNOTATION_SET_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.StepAnnotation <em>Step Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Annotation</em>'.
	 * @see reprotool.model.usecase.annotate.StepAnnotation
	 * @generated
	 */
	EClass getStepAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.annotate.StepAnnotation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see reprotool.model.usecase.annotate.StepAnnotation#getId()
	 * @see #getStepAnnotation()
	 * @generated
	 */
	EAttribute getStepAnnotation_Id();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.usecase.annotate.StepAnnotation#getAnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotation Type</em>'.
	 * @see reprotool.model.usecase.annotate.StepAnnotation#getAnnotationType()
	 * @see #getStepAnnotation()
	 * @generated
	 */
	EReference getStepAnnotation_AnnotationType();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.StepAnnotationType <em>Step Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Annotation Type</em>'.
	 * @see reprotool.model.usecase.annotate.StepAnnotationType
	 * @generated
	 */
	EClass getStepAnnotationType();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.annotate.StepAnnotationType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.usecase.annotate.StepAnnotationType#getName()
	 * @see #getStepAnnotationType()
	 * @generated
	 */
	EAttribute getStepAnnotationType_Name();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.TemporalAnnotation <em>Temporal Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Annotation</em>'.
	 * @see reprotool.model.usecase.annotate.TemporalAnnotation
	 * @generated
	 */
	EClass getTemporalAnnotation();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.SpecialAnnotation <em>Special Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Annotation</em>'.
	 * @see reprotool.model.usecase.annotate.SpecialAnnotation
	 * @generated
	 */
	EClass getSpecialAnnotation();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.AnnotationSet <em>Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Set</em>'.
	 * @see reprotool.model.usecase.annotate.AnnotationSet
	 * @generated
	 */
	EClass getAnnotationSet();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.LTLAnnotationSet <em>LTL Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LTL Annotation Set</em>'.
	 * @see reprotool.model.usecase.annotate.LTLAnnotationSet
	 * @generated
	 */
	EClass getLTLAnnotationSet();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.annotate.LTLAnnotationSet#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see reprotool.model.usecase.annotate.LTLAnnotationSet#getContains()
	 * @see #getLTLAnnotationSet()
	 * @generated
	 */
	EReference getLTLAnnotationSet_Contains();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.annotate.LTLAnnotationSet#getLtlFormula <em>Ltl Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ltl Formula</em>'.
	 * @see reprotool.model.usecase.annotate.LTLAnnotationSet#getLtlFormula()
	 * @see #getLTLAnnotationSet()
	 * @generated
	 */
	EAttribute getLTLAnnotationSet_LtlFormula();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.SpecialAnnotationSet <em>Special Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Annotation Set</em>'.
	 * @see reprotool.model.usecase.annotate.SpecialAnnotationSet
	 * @generated
	 */
	EClass getSpecialAnnotationSet();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.annotate.SpecialAnnotationSet#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see reprotool.model.usecase.annotate.SpecialAnnotationSet#getContains()
	 * @see #getSpecialAnnotationSet()
	 * @generated
	 */
	EReference getSpecialAnnotationSet_Contains();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.TraceAnnotation <em>Trace Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Annotation</em>'.
	 * @see reprotool.model.usecase.annotate.TraceAnnotation
	 * @generated
	 */
	EClass getTraceAnnotation();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.OnAnnotation <em>On Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On Annotation</em>'.
	 * @see reprotool.model.usecase.annotate.OnAnnotation
	 * @generated
	 */
	EClass getOnAnnotation();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.annotate.CTLAnnotationSet <em>CTL Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CTL Annotation Set</em>'.
	 * @see reprotool.model.usecase.annotate.CTLAnnotationSet
	 * @generated
	 */
	EClass getCTLAnnotationSet();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.annotate.CTLAnnotationSet#getCtlFormula <em>Ctl Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ctl Formula</em>'.
	 * @see reprotool.model.usecase.annotate.CTLAnnotationSet#getCtlFormula()
	 * @see #getCTLAnnotationSet()
	 * @generated
	 */
	EAttribute getCTLAnnotationSet_CtlFormula();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.annotate.CTLAnnotationSet#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see reprotool.model.usecase.annotate.CTLAnnotationSet#getContains()
	 * @see #getCTLAnnotationSet()
	 * @generated
	 */
	EReference getCTLAnnotationSet_Contains();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnnotateFactory getAnnotateFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.impl.StepAnnotationImpl <em>Step Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.impl.StepAnnotationImpl
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getStepAnnotation()
		 * @generated
		 */
		EClass STEP_ANNOTATION = eINSTANCE.getStepAnnotation();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP_ANNOTATION__ID = eINSTANCE.getStepAnnotation_Id();

		/**
		 * The meta object literal for the '<em><b>Annotation Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP_ANNOTATION__ANNOTATION_TYPE = eINSTANCE.getStepAnnotation_AnnotationType();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.StepAnnotationType <em>Step Annotation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.StepAnnotationType
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getStepAnnotationType()
		 * @generated
		 */
		EClass STEP_ANNOTATION_TYPE = eINSTANCE.getStepAnnotationType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP_ANNOTATION_TYPE__NAME = eINSTANCE.getStepAnnotationType_Name();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.impl.TemporalAnnotationImpl <em>Temporal Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.impl.TemporalAnnotationImpl
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getTemporalAnnotation()
		 * @generated
		 */
		EClass TEMPORAL_ANNOTATION = eINSTANCE.getTemporalAnnotation();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.SpecialAnnotation <em>Special Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.SpecialAnnotation
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getSpecialAnnotation()
		 * @generated
		 */
		EClass SPECIAL_ANNOTATION = eINSTANCE.getSpecialAnnotation();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.AnnotationSet <em>Annotation Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.AnnotationSet
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getAnnotationSet()
		 * @generated
		 */
		EClass ANNOTATION_SET = eINSTANCE.getAnnotationSet();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl <em>LTL Annotation Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getLTLAnnotationSet()
		 * @generated
		 */
		EClass LTL_ANNOTATION_SET = eINSTANCE.getLTLAnnotationSet();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LTL_ANNOTATION_SET__CONTAINS = eINSTANCE.getLTLAnnotationSet_Contains();

		/**
		 * The meta object literal for the '<em><b>Ltl Formula</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LTL_ANNOTATION_SET__LTL_FORMULA = eINSTANCE.getLTLAnnotationSet_LtlFormula();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.impl.SpecialAnnotationSetImpl <em>Special Annotation Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.impl.SpecialAnnotationSetImpl
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getSpecialAnnotationSet()
		 * @generated
		 */
		EClass SPECIAL_ANNOTATION_SET = eINSTANCE.getSpecialAnnotationSet();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIAL_ANNOTATION_SET__CONTAINS = eINSTANCE.getSpecialAnnotationSet_Contains();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.impl.TraceAnnotationImpl <em>Trace Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.impl.TraceAnnotationImpl
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getTraceAnnotation()
		 * @generated
		 */
		EClass TRACE_ANNOTATION = eINSTANCE.getTraceAnnotation();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.impl.OnAnnotationImpl <em>On Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.impl.OnAnnotationImpl
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getOnAnnotation()
		 * @generated
		 */
		EClass ON_ANNOTATION = eINSTANCE.getOnAnnotation();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.annotate.impl.CTLAnnotationSetImpl <em>CTL Annotation Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.annotate.impl.CTLAnnotationSetImpl
		 * @see reprotool.model.usecase.annotate.impl.AnnotatePackageImpl#getCTLAnnotationSet()
		 * @generated
		 */
		EClass CTL_ANNOTATION_SET = eINSTANCE.getCTLAnnotationSet();

		/**
		 * The meta object literal for the '<em><b>Ctl Formula</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CTL_ANNOTATION_SET__CTL_FORMULA = eINSTANCE.getCTLAnnotationSet_CtlFormula();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CTL_ANNOTATION_SET__CONTAINS = eINSTANCE.getCTLAnnotationSet_Contains();

	}

} //AnnotatePackage
