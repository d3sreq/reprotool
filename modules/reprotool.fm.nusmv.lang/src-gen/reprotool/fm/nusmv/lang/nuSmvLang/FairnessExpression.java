/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fairness Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression#getFairnessExpr <em>Fairness Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getFairnessExpression()
 * @model
 * @generated
 */
public interface FairnessExpression extends FairnessConstraint
{
  /**
   * Returns the value of the '<em><b>Fairness Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fairness Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fairness Expr</em>' attribute.
   * @see #setFairnessExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getFairnessExpression_FairnessExpr()
   * @model
   * @generated
   */
  String getFairnessExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression#getFairnessExpr <em>Fairness Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fairness Expr</em>' attribute.
   * @see #getFairnessExpr()
   * @generated
   */
  void setFairnessExpr(String value);

} // FairnessExpression
