/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

import reprotool.model.linguistic.actionpart.ActionPart;
import reprotool.model.usecase.UseCase;
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
 *   <li>{@link reprotool.model.linguistic.action.UseCaseInclude#getIncludeTarget <em>Include Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.action.ActionPackage#getUseCaseInclude()
 * @model
 * @generated
 */
public interface UseCaseInclude extends Action, ActionPart {
	/**
	 * Returns the value of the '<em><b>Include Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Target</em>' reference.
	 * @see #setIncludeTarget(UseCase)
	 * @see reprotool.model.linguistic.action.ActionPackage#getUseCaseInclude_IncludeTarget()
	 * @model required="true"
	 * @generated
	 */
	UseCase getIncludeTarget();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.action.UseCaseInclude#getIncludeTarget <em>Include Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Target</em>' reference.
	 * @see #getIncludeTarget()
	 * @generated
	 */
	void setIncludeTarget(UseCase value);

} // UseCaseInclude
