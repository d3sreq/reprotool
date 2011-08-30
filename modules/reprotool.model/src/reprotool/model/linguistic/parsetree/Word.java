/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.parsetree;

import reprotool.model.linguistic.EWordType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.parsetree.Word#getWordStr <em>Word Str</em>}</li>
 *   <li>{@link reprotool.model.linguistic.parsetree.Word#getWordType <em>Word Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.parsetree.ParsetreePackage#getWord()
 * @model
 * @generated
 */
public interface Word extends ParseNode {
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
	 * @see reprotool.model.linguistic.parsetree.ParsetreePackage#getWord_WordStr()
	 * @model
	 * @generated
	 */
	String getWordStr();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.parsetree.Word#getWordStr <em>Word Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word Str</em>' attribute.
	 * @see #getWordStr()
	 * @generated
	 */
	void setWordStr(String value);

	/**
	 * Returns the value of the '<em><b>Word Type</b></em>' attribute.
	 * The literals are from the enumeration {@link reprotool.model.linguistic.EWordType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word Type</em>' attribute.
	 * @see reprotool.model.linguistic.EWordType
	 * @see #setWordType(EWordType)
	 * @see reprotool.model.linguistic.parsetree.ParsetreePackage#getWord_WordType()
	 * @model
	 * @generated
	 */
	EWordType getWordType();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.parsetree.Word#getWordType <em>Word Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word Type</em>' attribute.
	 * @see reprotool.model.linguistic.EWordType
	 * @see #getWordType()
	 * @generated
	 */
	void setWordType(EWordType value);

} // Word
