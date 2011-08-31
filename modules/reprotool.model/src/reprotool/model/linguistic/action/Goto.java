/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import reprotool.model.linguistic.actionpart.GotoTarget;

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
public interface Goto extends Action {
	/**
	 * Returns the value of the '<em><b>Goto Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goto Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goto Target</em>' containment reference.
	 * @see #setGotoTarget(GotoTarget)
	 * @see reprotool.model.linguistic.action.ActionPackage#getGoto_GotoTarget()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GotoTarget getGotoTarget();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.Goto#getGotoTarget <em>Goto Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goto Target</em>' containment reference.
	 * @see #getGotoTarget()
	 * @generated
	 */
	void setGotoTarget(GotoTarget value);

} // Goto
