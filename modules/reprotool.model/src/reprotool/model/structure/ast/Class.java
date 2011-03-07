/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.structure.ast;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.structure.ast.Class#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.structure.ast.AstPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends EObject {
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.structure.ast.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' reference list.
	 * @see reprotool.model.structure.ast.AstPackage#getClass_Methods()
	 * @model
	 * @generated
	 */
	EList<Method> getMethods();

} // Class
