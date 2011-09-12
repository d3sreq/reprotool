/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.parsetree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inner Parse Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.parsetree.InnerParseNode#getChildNodes <em>Child Nodes</em>}</li>
 *   <li>{@link reprotool.model.linguistic.parsetree.InnerParseNode#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.parsetree.ParsetreePackage#getInnerParseNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InnerParseNode extends ParseNode {
	/**
	 * Returns the value of the '<em><b>Child Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.linguistic.parsetree.ParseNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Nodes</em>' containment reference list.
	 * @see reprotool.model.linguistic.parsetree.ParsetreePackage#getInnerParseNode_ChildNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParseNode> getChildNodes();

	/**
	 * Returns the value of the '<em><b>Parent Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Node</em>' containment reference.
	 * @see #setParentNode(InnerParseNode)
	 * @see reprotool.model.linguistic.parsetree.ParsetreePackage#getInnerParseNode_ParentNode()
	 * @model containment="true"
	 * @generated
	 */
	InnerParseNode getParentNode();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.parsetree.InnerParseNode#getParentNode <em>Parent Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Node</em>' containment reference.
	 * @see #getParentNode()
	 * @generated
	 */
	void setParentNode(InnerParseNode value);

} // InnerParseNode
