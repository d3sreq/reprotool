/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compassion Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getFirstCompassionExpr <em>First Compassion Expr</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getSecondCompassionExpr <em>Second Compassion Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getCompassionExpression()
 * @model
 * @generated
 */
public interface CompassionExpression extends FairnessConstraint
{
  /**
   * Returns the value of the '<em><b>First Compassion Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Compassion Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Compassion Expr</em>' attribute.
   * @see #setFirstCompassionExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getCompassionExpression_FirstCompassionExpr()
   * @model
   * @generated
   */
  String getFirstCompassionExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getFirstCompassionExpr <em>First Compassion Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Compassion Expr</em>' attribute.
   * @see #getFirstCompassionExpr()
   * @generated
   */
  void setFirstCompassionExpr(String value);

  /**
   * Returns the value of the '<em><b>Second Compassion Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Compassion Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Compassion Expr</em>' attribute.
   * @see #setSecondCompassionExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getCompassionExpression_SecondCompassionExpr()
   * @model
   * @generated
   */
  String getSecondCompassionExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getSecondCompassionExpr <em>Second Compassion Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second Compassion Expr</em>' attribute.
   * @see #getSecondCompassionExpr()
   * @generated
   */
  void setSecondCompassionExpr(String value);

} // CompassionExpression
