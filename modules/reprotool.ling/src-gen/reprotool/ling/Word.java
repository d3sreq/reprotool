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
} // Word
