/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.procases.Action#getNextAction <em>Next Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.procases.ProcasesPackage#getAction()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Action extends EObject {
	/**
	 * Returns the value of the '<em><b>Next Action</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.procases.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Action</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Action</em>' reference list.
	 * @see reprotool.model.procases.ProcasesPackage#getAction_NextAction()
	 * @model
	 * @generated
	 */
	EList<Action> getNextAction();

} // Action
