/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.traceability;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.traceability.TraceLink#getSource <em>Source</em>}</li>
 *   <li>{@link reprotool.model.traceability.TraceLink#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.traceability.TraceabilityPackage#getTraceLink()
 * @model
 * @generated
 */
public interface TraceLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.traceability.TraceableEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see reprotool.model.traceability.TraceabilityPackage#getTraceLink_Source()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<TraceableEntity> getSource();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.traceability.TraceableEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see reprotool.model.traceability.TraceabilityPackage#getTraceLink_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<TraceableEntity> getTarget();

} // TraceLink
