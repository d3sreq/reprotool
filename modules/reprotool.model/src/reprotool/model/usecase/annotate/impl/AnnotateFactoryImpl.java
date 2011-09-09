/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.model.usecase.annotate.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnnotateFactoryImpl extends EFactoryImpl implements AnnotateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotateFactory init() {
		try {
			AnnotateFactory theAnnotateFactory = (AnnotateFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/model/usecase/annotate"); 
			if (theAnnotateFactory != null) {
				return theAnnotateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnnotateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AnnotatePackage.STEP_ANNOTATION: return createStepAnnotation();
			case AnnotatePackage.LTL_ANNOTATION: return createLTLAnnotation();
			case AnnotatePackage.LTL_ANNOTATION_SET: return createLTLAnnotationSet();
			case AnnotatePackage.SPECIAL_ANNOTATION_SET: return createSpecialAnnotationSet();
			case AnnotatePackage.TRACE_ANNOTATION: return createTraceAnnotation();
			case AnnotatePackage.ON_ANNOTATION: return createOnAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepAnnotation createStepAnnotation() {
		StepAnnotationImpl stepAnnotation = new StepAnnotationImpl();
		return stepAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LTLAnnotation createLTLAnnotation() {
		LTLAnnotationImpl ltlAnnotation = new LTLAnnotationImpl();
		return ltlAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LTLAnnotationSet createLTLAnnotationSet() {
		LTLAnnotationSetImpl ltlAnnotationSet = new LTLAnnotationSetImpl();
		return ltlAnnotationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialAnnotationSet createSpecialAnnotationSet() {
		SpecialAnnotationSetImpl specialAnnotationSet = new SpecialAnnotationSetImpl();
		return specialAnnotationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceAnnotation createTraceAnnotation() {
		TraceAnnotationImpl traceAnnotation = new TraceAnnotationImpl();
		return traceAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAnnotation createOnAnnotation() {
		OnAnnotationImpl onAnnotation = new OnAnnotationImpl();
		return onAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatePackage getAnnotatePackage() {
		return (AnnotatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnnotatePackage getPackage() {
		return AnnotatePackage.eINSTANCE;
	}

} //AnnotateFactoryImpl
