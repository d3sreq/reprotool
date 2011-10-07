/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import reprotool.model.usecase.annotate.*;
import reprotool.model.usecase.annotate.AnnotatePackage;
import reprotool.model.usecase.annotate.AnnotationSet;
import reprotool.model.usecase.annotate.CTLAnnotationSet;
import reprotool.model.usecase.annotate.LTLAnnotationSet;
import reprotool.model.usecase.annotate.OnAnnotation;
import reprotool.model.usecase.annotate.SpecialAnnotation;
import reprotool.model.usecase.annotate.SpecialAnnotationSet;
import reprotool.model.usecase.annotate.StepAnnotation;
import reprotool.model.usecase.annotate.StepAnnotationType;
import reprotool.model.usecase.annotate.TemporalAnnotation;
import reprotool.model.usecase.annotate.TraceAnnotation;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.usecase.annotate.AnnotatePackage
 * @generated
 */
public class AnnotateAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnnotatePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotateAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AnnotatePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotateSwitch<Adapter> modelSwitch =
		new AnnotateSwitch<Adapter>() {
			@Override
			public Adapter caseStepAnnotation(StepAnnotation object) {
				return createStepAnnotationAdapter();
			}
			@Override
			public Adapter caseStepAnnotationType(StepAnnotationType object) {
				return createStepAnnotationTypeAdapter();
			}
			@Override
			public Adapter caseTemporalAnnotation(TemporalAnnotation object) {
				return createTemporalAnnotationAdapter();
			}
			@Override
			public Adapter caseSpecialAnnotation(SpecialAnnotation object) {
				return createSpecialAnnotationAdapter();
			}
			@Override
			public Adapter caseAnnotationSet(AnnotationSet object) {
				return createAnnotationSetAdapter();
			}
			@Override
			public Adapter caseLTLAnnotationSet(LTLAnnotationSet object) {
				return createLTLAnnotationSetAdapter();
			}
			@Override
			public Adapter caseSpecialAnnotationSet(SpecialAnnotationSet object) {
				return createSpecialAnnotationSetAdapter();
			}
			@Override
			public Adapter caseTraceAnnotation(TraceAnnotation object) {
				return createTraceAnnotationAdapter();
			}
			@Override
			public Adapter caseOnAnnotation(OnAnnotation object) {
				return createOnAnnotationAdapter();
			}
			@Override
			public Adapter caseCTLAnnotationSet(CTLAnnotationSet object) {
				return createCTLAnnotationSetAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.StepAnnotation <em>Step Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.StepAnnotation
	 * @generated
	 */
	public Adapter createStepAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.StepAnnotationType <em>Step Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.StepAnnotationType
	 * @generated
	 */
	public Adapter createStepAnnotationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.TemporalAnnotation <em>Temporal Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.TemporalAnnotation
	 * @generated
	 */
	public Adapter createTemporalAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.SpecialAnnotation <em>Special Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.SpecialAnnotation
	 * @generated
	 */
	public Adapter createSpecialAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.AnnotationSet <em>Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.AnnotationSet
	 * @generated
	 */
	public Adapter createAnnotationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.LTLAnnotationSet <em>LTL Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.LTLAnnotationSet
	 * @generated
	 */
	public Adapter createLTLAnnotationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.SpecialAnnotationSet <em>Special Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.SpecialAnnotationSet
	 * @generated
	 */
	public Adapter createSpecialAnnotationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.TraceAnnotation <em>Trace Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.TraceAnnotation
	 * @generated
	 */
	public Adapter createTraceAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.OnAnnotation <em>On Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.OnAnnotation
	 * @generated
	 */
	public Adapter createOnAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.usecase.annotate.CTLAnnotationSet <em>CTL Annotation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.usecase.annotate.CTLAnnotationSet
	 * @generated
	 */
	public Adapter createCTLAnnotationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AnnotateAdapterFactory
