/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sentence Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.ling.SentenceNode#getChildren <em>Children</em>}</li>
 *   <li>{@link reprotool.ling.SentenceNode#getType <em>Type</em>}</li>
 *   <li>{@link reprotool.ling.SentenceNode#getWord <em>Word</em>}</li>
 *   <li>{@link reprotool.ling.SentenceNode#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.ling.LingPackage#getSentenceNode()
 * @model
 * @generated
 */
public interface SentenceNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link reprotool.ling.SentenceNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see reprotool.ling.LingPackage#getSentenceNode_Children()
	 * @model
	 * @generated
	 */
	EList<SentenceNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link reprotool.ling.SentenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see reprotool.ling.SentenceType
	 * @see #setType(SentenceType)
	 * @see reprotool.ling.LingPackage#getSentenceNode_Type()
	 * @model
	 * @generated
	 */
	SentenceType getType();

	/**
	 * Sets the value of the '{@link reprotool.ling.SentenceNode#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see reprotool.ling.SentenceType
	 * @see #getType()
	 * @generated
	 */
	void setType(SentenceType value);

	/**
	 * Returns the value of the '<em><b>Word</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word</em>' reference.
	 * @see #setWord(Word)
	 * @see reprotool.ling.LingPackage#getSentenceNode_Word()
	 * @model
	 * @generated
	 */
	Word getWord();

	/**
	 * Sets the value of the '{@link reprotool.ling.SentenceNode#getWord <em>Word</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word</em>' reference.
	 * @see #getWord()
	 * @generated
	 */
	void setWord(Word value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(SentenceNode)
	 * @see reprotool.ling.LingPackage#getSentenceNode_Parent()
	 * @model
	 * @generated
	 */
	SentenceNode getParent();

	/**
	 * Sets the value of the '{@link reprotool.ling.SentenceNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(SentenceNode value);

} // SentenceNode
