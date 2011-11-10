/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.ling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parse Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.ling.ParseTreeNode#getParent <em>Parent</em>}</li>
 *   <li>{@link reprotool.ling.ParseTreeNode#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.ling.LingPackage#getParseTreeNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ParseTreeNode extends EObject
{
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(ParseTreeNode)
	 * @see reprotool.ling.LingPackage#getParseTreeNode_Parent()
	 * @model
	 * @generated
	 */
	ParseTreeNode getParent();

	/**
	 * Sets the value of the '{@link reprotool.ling.ParseTreeNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ParseTreeNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.ling.ParseTreeNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see reprotool.ling.LingPackage#getParseTreeNode_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParseTreeNode> getChildren();

} // ParseTreeNode
