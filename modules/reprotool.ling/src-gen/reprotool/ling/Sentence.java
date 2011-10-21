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
 * A representation of the model object '<em><b>Sentence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.ling.Sentence#getWords <em>Words</em>}</li>
 *   <li>{@link reprotool.ling.Sentence#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link reprotool.ling.Sentence#getSentenceTree <em>Sentence Tree</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.ling.LingPackage#getSentence()
 * @model
 * @generated
 */
public interface Sentence extends EObject {
	/**
	 * Returns the value of the '<em><b>Words</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.ling.Word}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Words</em>' containment reference list.
	 * @see reprotool.ling.LingPackage#getSentence_Words()
	 * @model containment="true"
	 * @generated
	 */
	EList<Word> getWords();

	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(SentenceNode)
	 * @see reprotool.ling.LingPackage#getSentence_EReference0()
	 * @model
	 * @generated
	 */
	SentenceNode getEReference0();

	/**
	 * Sets the value of the '{@link reprotool.ling.Sentence#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(SentenceNode value);

	/**
	 * Returns the value of the '<em><b>Sentence Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentence Tree</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentence Tree</em>' reference.
	 * @see #setSentenceTree(SentenceNode)
	 * @see reprotool.ling.LingPackage#getSentence_SentenceTree()
	 * @model
	 * @generated
	 */
	SentenceNode getSentenceTree();

	/**
	 * Sets the value of the '{@link reprotool.ling.Sentence#getSentenceTree <em>Sentence Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence Tree</em>' reference.
	 * @see #getSentenceTree()
	 * @generated
	 */
	void setSentenceTree(SentenceNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void parseString(String inputString);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Sentence getNegatedString();

} // Sentence
