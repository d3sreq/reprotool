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
import reprotool.model.usecase.annotate.AnnotateFactory;
import reprotool.model.usecase.annotate.AnnotatePackage;
import reprotool.model.usecase.annotate.CTLAnnotationSet;
import reprotool.model.usecase.annotate.LTLAnnotationSet;
import reprotool.model.usecase.annotate.OnAnnotation;
import reprotool.model.usecase.annotate.SpecialAnnotationSet;
import reprotool.model.usecase.annotate.StepAnnotation;
import reprotool.model.usecase.annotate.TemporalAnnotation;
import reprotool.model.usecase.annotate.TraceAnnotation;

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
			case AnnotatePackage.TEMPORAL_ANNOTATION: return createTemporalAnnotation();
			case AnnotatePackage.LTL_ANNOTATION_SET: return createLTLAnnotationSet();
			case AnnotatePackage.SPECIAL_ANNOTATION_SET: return createSpecialAnnotationSet();
			case AnnotatePackage.TRACE_ANNOTATION: return createTraceAnnotation();
			case AnnotatePackage.ON_ANNOTATION: return createOnAnnotation();
			case AnnotatePackage.CTL_ANNOTATION_SET: return createCTLAnnotationSet();
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
	public TemporalAnnotation createTemporalAnnotation() {
		TemporalAnnotationImpl temporalAnnotation = new TemporalAnnotationImpl();
		return temporalAnnotation;
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
	public CTLAnnotationSet createCTLAnnotationSet() {
		CTLAnnotationSetImpl ctlAnnotationSet = new CTLAnnotationSetImpl();
		return ctlAnnotationSet;
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
