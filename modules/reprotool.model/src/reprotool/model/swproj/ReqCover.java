/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.swproj;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Req Cover</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.swproj.ReqCover#getRelatedRequirements <em>Related Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.swproj.SwprojPackage#getReqCover()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ReqCover extends EObject {
	/**
	 * Returns the value of the '<em><b>Related Requirements</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.swproj.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Requirements</em>' reference list.
	 * @see reprotool.model.swproj.SwprojPackage#getReqCover_RelatedRequirements()
	 * @model
	 * @generated
	 */
	EList<Requirement> getRelatedRequirements();

} // ReqCover
