/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.structure.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.structure.ast.Method#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.structure.ast.AstPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends CodeElement {

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link reprotool.model.structure.ast.MethodVisibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see reprotool.model.structure.ast.MethodVisibility
	 * @see #setVisibility(MethodVisibility)
	 * @see reprotool.model.structure.ast.AstPackage#getMethod_Visibility()
	 * @model
	 * @generated
	 */
	MethodVisibility getVisibility();

	/**
	 * Sets the value of the '{@link reprotool.model.structure.ast.Method#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see reprotool.model.structure.ast.MethodVisibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(MethodVisibility value);
} // Method
