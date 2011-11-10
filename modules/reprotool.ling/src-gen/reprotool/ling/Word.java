/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.ling;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.ling.Word#getText <em>Text</em>}</li>
 *   <li>{@link reprotool.ling.Word#getLemma <em>Lemma</em>}</li>
 *   <li>{@link reprotool.ling.Word#getPOS <em>POS</em>}</li>
 *   <li>{@link reprotool.ling.Word#getID <em>ID</em>}</li>
 *   <li>{@link reprotool.ling.Word#getType <em>Type</em>}</li>
 *   <li>{@link reprotool.ling.Word#isInterpunction <em>Interpunction</em>}</li>
 *   <li>{@link reprotool.ling.Word#isNumeral <em>Numeral</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.ling.LingPackage#getWord()
 * @model
 * @generated
 */
public interface Word extends ParseTreeNode
{
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
	 * The literals are from the enumeration {@link reprotool.ling.POSType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>POS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>POS</em>' attribute.
	 * @see reprotool.ling.POSType
	 * @see #setPOS(POSType)
	 * @see reprotool.ling.LingPackage#getWord_POS()
	 * @model
	 * @generated
	 */
	POSType getPOS();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#getPOS <em>POS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>POS</em>' attribute.
	 * @see reprotool.ling.POSType
	 * @see #getPOS()
	 * @generated
	 */
	void setPOS(POSType value);

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

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link reprotool.ling.WordType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see reprotool.ling.WordType
	 * @see #setType(WordType)
	 * @see reprotool.ling.LingPackage#getWord_Type()
	 * @model
	 * @generated
	 */
	WordType getType();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see reprotool.ling.WordType
	 * @see #getType()
	 * @generated
	 */
	void setType(WordType value);

	/**
	 * Returns the value of the '<em><b>Interpunction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpunction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpunction</em>' attribute.
	 * @see #setInterpunction(boolean)
	 * @see reprotool.ling.LingPackage#getWord_Interpunction()
	 * @model
	 * @generated
	 */
	boolean isInterpunction();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#isInterpunction <em>Interpunction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpunction</em>' attribute.
	 * @see #isInterpunction()
	 * @generated
	 */
	void setInterpunction(boolean value);

	/**
	 * Returns the value of the '<em><b>Numeral</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numeral</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeral</em>' attribute.
	 * @see #setNumeral(boolean)
	 * @see reprotool.ling.LingPackage#getWord_Numeral()
	 * @model
	 * @generated
	 */
	boolean isNumeral();

	/**
	 * Sets the value of the '{@link reprotool.ling.Word#isNumeral <em>Numeral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numeral</em>' attribute.
	 * @see #isNumeral()
	 * @generated
	 */
	void setNumeral(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean parseString(String wordString);

} // Word
