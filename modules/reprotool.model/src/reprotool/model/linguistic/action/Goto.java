/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import reprotool.model.linguistic.actionpart.ActionPart;

import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goto</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.Goto#getGotoTarget <em>Goto Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getGoto()
 * @model
 * @generated
 */
public interface Goto extends Action, ActionPart {
	/**
	 * Returns the value of the '<em><b>Goto Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goto Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goto Target</em>' reference.
	 * @see #setGotoTarget(UseCaseStep)
	 * @see reprotool.model.linguistic.action.ActionPackage#getGoto_GotoTarget()
	 * @model required="true"
	 * @generated
	 */
	UseCaseStep getGotoTarget();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Goto#getGotoTarget <em>Goto Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goto Target</em>' reference.
	 * @see #getGotoTarget()
	 * @generated
	 */
	void setGotoTarget(UseCaseStep value);

} // Goto
