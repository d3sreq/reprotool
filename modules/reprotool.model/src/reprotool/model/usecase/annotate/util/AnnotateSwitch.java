/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import reprotool.model.usecase.annotate.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see reprotool.model.usecase.annotate.AnnotatePackage
 * @generated
 */
public class AnnotateSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnnotatePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotateSwitch() {
		if (modelPackage == null) {
			modelPackage = AnnotatePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AnnotatePackage.STEP_ANNOTATION: {
				StepAnnotation stepAnnotation = (StepAnnotation)theEObject;
				T result = caseStepAnnotation(stepAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.STEP_ANNOTATION_TYPE: {
				StepAnnotationType stepAnnotationType = (StepAnnotationType)theEObject;
				T result = caseStepAnnotationType(stepAnnotationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.TEMPORAL_ANNOTATION: {
				TemporalAnnotation temporalAnnotation = (TemporalAnnotation)theEObject;
				T result = caseTemporalAnnotation(temporalAnnotation);
				if (result == null) result = caseStepAnnotationType(temporalAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.SPECIAL_ANNOTATION: {
				SpecialAnnotation specialAnnotation = (SpecialAnnotation)theEObject;
				T result = caseSpecialAnnotation(specialAnnotation);
				if (result == null) result = caseStepAnnotationType(specialAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.ANNOTATION_SET: {
				AnnotationSet annotationSet = (AnnotationSet)theEObject;
				T result = caseAnnotationSet(annotationSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.LTL_ANNOTATION_SET: {
				LTLAnnotationSet ltlAnnotationSet = (LTLAnnotationSet)theEObject;
				T result = caseLTLAnnotationSet(ltlAnnotationSet);
				if (result == null) result = caseAnnotationSet(ltlAnnotationSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.SPECIAL_ANNOTATION_SET: {
				SpecialAnnotationSet specialAnnotationSet = (SpecialAnnotationSet)theEObject;
				T result = caseSpecialAnnotationSet(specialAnnotationSet);
				if (result == null) result = caseAnnotationSet(specialAnnotationSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.TRACE_ANNOTATION: {
				TraceAnnotation traceAnnotation = (TraceAnnotation)theEObject;
				T result = caseTraceAnnotation(traceAnnotation);
				if (result == null) result = caseAnnotationSet(traceAnnotation);
				if (result == null) result = caseSpecialAnnotation(traceAnnotation);
				if (result == null) result = caseStepAnnotationType(traceAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.ON_ANNOTATION: {
				OnAnnotation onAnnotation = (OnAnnotation)theEObject;
				T result = caseOnAnnotation(onAnnotation);
				if (result == null) result = caseAnnotationSet(onAnnotation);
				if (result == null) result = caseSpecialAnnotation(onAnnotation);
				if (result == null) result = caseStepAnnotationType(onAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotatePackage.CTL_ANNOTATION_SET: {
				CTLAnnotationSet ctlAnnotationSet = (CTLAnnotationSet)theEObject;
				T result = caseCTLAnnotationSet(ctlAnnotationSet);
				if (result == null) result = caseAnnotationSet(ctlAnnotationSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepAnnotation(StepAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step Annotation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step Annotation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepAnnotationType(StepAnnotationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Temporal Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Temporal Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemporalAnnotation(TemporalAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Special Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Special Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecialAnnotation(SpecialAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationSet(AnnotationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LTL Annotation Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LTL Annotation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLTLAnnotationSet(LTLAnnotationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Special Annotation Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Special Annotation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecialAnnotationSet(SpecialAnnotationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceAnnotation(TraceAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnAnnotation(OnAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CTL Annotation Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CTL Annotation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCTLAnnotationSet(CTLAnnotationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AnnotateSwitch
