/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.ling;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sentence Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.ling.SentenceNode#getType <em>Type</em>}</li>
 *   <li>{@link reprotool.ling.SentenceNode#getWord <em>Word</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.ling.LingPackage#getSentenceNode()
 * @model
 * @generated
 */
public interface SentenceNode extends ParseTreeNode
{
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

} // SentenceNode
