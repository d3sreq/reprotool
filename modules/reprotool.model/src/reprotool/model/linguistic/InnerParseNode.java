/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inner Parse Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.InnerParseNode#getChildNodes <em>Child Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.LinguisticPackage#getInnerParseNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InnerParseNode extends ParseNode {
	/**
	 * Returns the value of the '<em><b>Child Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.linguistic.ParseNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Nodes</em>' containment reference list.
	 * @see reprotool.model.linguistic.LinguisticPackage#getInnerParseNode_ChildNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParseNode> getChildNodes();

} // InnerParseNode
