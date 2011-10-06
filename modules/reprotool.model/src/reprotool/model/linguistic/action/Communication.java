/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import org.eclipse.emf.common.util.EList;

import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.Text;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.Communication#getActionParam <em>Action Param</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.Communication#getActionName <em>Action Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getCommunication()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Communication extends Action {
	/**
	 * Returns the value of the '<em><b>Action Param</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.linguistic.actionpart.SentenceActionParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Param</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Param</em>' containment reference list.
	 * @see reprotool.model.linguistic.action.ActionPackage#getCommunication_ActionParam()
	 * @model containment="true"
	 * @generated
	 */
	EList<SentenceActionParam> getActionParam();

	/**
	 * Returns the value of the '<em><b>Action Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Name</em>' reference.
	 * @see #setActionName(Text)
	 * @see reprotool.model.linguistic.action.ActionPackage#getCommunication_ActionName()
	 * @model required="true"
	 * @generated
	 */
	Text getActionName();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Communication#getActionName <em>Action Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Name</em>' reference.
	 * @see #getActionName()
	 * @generated
	 */
	void setActionName(Text value);

} // Communication
