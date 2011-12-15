/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invar Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint#getInvarExpr <em>Invar Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getInvarConstraint()
 * @model
 * @generated
 */
public interface InvarConstraint extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Invar Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invar Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invar Expr</em>' attribute.
   * @see #setInvarExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getInvarConstraint_InvarExpr()
   * @model
   * @generated
   */
  String getInvarExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint#getInvarExpr <em>Invar Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invar Expr</em>' attribute.
   * @see #getInvarExpr()
   * @generated
   */
  void setInvarExpr(String value);

} // InvarConstraint
