/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.ling.Word#getWordStr <em>Word Str</em>}</li>
 *   <li>{@link reprotool.ling.Word#getText <em>Text</em>}</li>
 *   <li>{@link reprotool.ling.Word#getLemma <em>Lemma</em>}</li>
 *   <li>{@link reprotool.ling.Word#getPOS <em>POS</em>}</li>
 *   <li>{@link reprotool.ling.Word#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.ling.LingPackage#getWord()
 * @model
 * @generated
 */
public interface Word extends EObject {

	/**
	 * Returns the value of the '<em><b>Word Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word Str</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word Str</em>' attribute.
	 * @see #setWordStr(String)
	 * @see reprotool.ling.LingPackage#getWord_WordStr()
	 * @model
	 * @generated
	 */
	String getWordStr();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#getWordStr <em>Word Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word Str</em>' attribute.
	 * @see #getWordStr()
	 * @generated
	 */
	void setWordStr(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see reprotool.ling.LingPackage#getWord_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Lemma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lemma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lemma</em>' attribute.
	 * @see #setLemma(String)
	 * @see reprotool.ling.LingPackage#getWord_Lemma()
	 * @model
	 * @generated
	 */
	String getLemma();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#getLemma <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lemma</em>' attribute.
	 * @see #getLemma()
	 * @generated
	 */
	void setLemma(String value);

	/**
	 * Returns the value of the '<em><b>POS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>POS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>POS</em>' attribute.
	 * @see #setPOS(String)
	 * @see reprotool.ling.LingPackage#getWord_POS()
	 * @model
	 * @generated
	 */
	String getPOS();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#getPOS <em>POS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>POS</em>' attribute.
	 * @see #getPOS()
	 * @generated
	 */
	void setPOS(String value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(int)
	 * @see reprotool.ling.LingPackage#getWord_ID()
	 * @model
	 * @generated
	 */
	int getID();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(int value);
} // Word
