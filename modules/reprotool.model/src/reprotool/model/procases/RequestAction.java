/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases;

import reprotool.model.swproj.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Request Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.procases.RequestAction#getActor <em>Actor</em>}</li>
 *   <li>{@link reprotool.model.procases.RequestAction#getActionName <em>Action Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.procases.ProcasesPackage#getRequestAction()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface RequestAction extends Action {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference.
	 * @see #setActor(Actor)
	 * @see reprotool.model.procases.ProcasesPackage#getRequestAction_Actor()
	 * @model
	 * @generated
	 */
	Actor getActor();

	/**
	 * Sets the value of the '{@link reprotool.model.procases.RequestAction#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' reference.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(Actor value);

	/**
	 * Returns the value of the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Name</em>' attribute.
	 * @see #setActionName(String)
	 * @see reprotool.model.procases.ProcasesPackage#getRequestAction_ActionName()
	 * @model
	 * @generated
	 */
	String getActionName();

	/**
	 * Sets the value of the '{@link reprotool.model.procases.RequestAction#getActionName <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Name</em>' attribute.
	 * @see #getActionName()
	 * @generated
	 */
	void setActionName(String value);

} // RequestAction
