/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getBounds <em>Bounds</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends SimpleType
{
  /**
   * Returns the value of the '<em><b>Bounds</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bounds</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bounds</em>' attribute.
   * @see #setBounds(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getArrayType_Bounds()
   * @model
   * @generated
   */
  String getBounds();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getBounds <em>Bounds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bounds</em>' attribute.
   * @see #getBounds()
   * @generated
   */
  void setBounds(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(SimpleType)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getArrayType_Type()
   * @model containment="true"
   * @generated
   */
  SimpleType getType();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(SimpleType value);

} // ArrayType
