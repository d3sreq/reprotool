/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goto Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.procases.GotoAction#getTargetAction <em>Target Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.procases.ProcasesPackage#getGotoAction()
 * @model
 * @generated
 */
public interface GotoAction extends SpecialAction {
	/**
	 * Returns the value of the '<em><b>Target Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Action</em>' reference.
	 * @see #setTargetAction(Action)
	 * @see reprotool.model.procases.ProcasesPackage#getGotoAction_TargetAction()
	 * @model
	 * @generated
	 */
	Action getTargetAction();

	/**
	 * Sets the value of the '{@link reprotool.model.procases.GotoAction#getTargetAction <em>Target Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Action</em>' reference.
	 * @see #getTargetAction()
	 * @generated
	 */
	void setTargetAction(Action value);

} // GotoAction
