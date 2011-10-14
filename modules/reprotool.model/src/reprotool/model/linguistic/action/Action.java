/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.Action#getSummary <em>Summary</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getAction()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Action extends EObject {

	/**
	 * Returns the value of the '<em><b>Summary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Summary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Summary</em>' attribute.
	 * @see reprotool.model.linguistic.action.ActionPackage#getAction_Summary()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getSummary();
} // Action
