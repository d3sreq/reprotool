/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart;

import reprotool.model.usecase.UseCase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Include Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.actionpart.UseCaseIncludePart#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getUseCaseIncludePart()
 * @model
 * @generated
 */
public interface UseCaseIncludePart extends ActionPart {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(UseCase)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getUseCaseIncludePart_Target()
	 * @model
	 * @generated
	 */
	UseCase getTarget();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.UseCaseIncludePart#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(UseCase value);

} // UseCaseIncludePart
