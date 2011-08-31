/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.linguistic.actionpart.UseCaseIncludePart;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Include</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.UseCaseInclude#getInclude <em>Include</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getUseCaseInclude()
 * @model
 * @generated
 */
public interface UseCaseInclude extends Action {
	/**
	 * Returns the value of the '<em><b>Include</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include</em>' containment reference.
	 * @see #setInclude(UseCaseIncludePart)
	 * @see reprotool.model.linguistic.action.ActionPackage#getUseCaseInclude_Include()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UseCaseIncludePart getInclude();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.UseCaseInclude#getInclude <em>Include</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include</em>' containment reference.
	 * @see #getInclude()
	 * @generated
	 */
	void setInclude(UseCaseIncludePart value);

} // UseCaseInclude
