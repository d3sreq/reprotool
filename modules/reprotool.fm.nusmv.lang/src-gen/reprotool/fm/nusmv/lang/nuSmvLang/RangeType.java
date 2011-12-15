/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getLow <em>Low</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getHigh <em>High</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getRangeType()
 * @model
 * @generated
 */
public interface RangeType extends SimpleType
{
  /**
   * Returns the value of the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Low</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Low</em>' attribute.
   * @see #setLow(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getRangeType_Low()
   * @model
   * @generated
   */
  String getLow();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getLow <em>Low</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Low</em>' attribute.
   * @see #getLow()
   * @generated
   */
  void setLow(String value);

  /**
   * Returns the value of the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>High</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>High</em>' attribute.
   * @see #setHigh(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getRangeType_High()
   * @model
   * @generated
   */
  String getHigh();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getHigh <em>High</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>High</em>' attribute.
   * @see #getHigh()
   * @generated
   */
  void setHigh(String value);

} // RangeType
