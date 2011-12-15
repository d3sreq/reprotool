/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint#getInitExpr <em>Init Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getInitConstraint()
 * @model
 * @generated
 */
public interface InitConstraint extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Init Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Expr</em>' attribute.
   * @see #setInitExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getInitConstraint_InitExpr()
   * @model
   * @generated
   */
  String getInitExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint#getInitExpr <em>Init Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Expr</em>' attribute.
   * @see #getInitExpr()
   * @generated
   */
  void setInitExpr(String value);

} // InitConstraint
