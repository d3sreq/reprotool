/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trans Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint#getTransExpr <em>Trans Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getTransConstraint()
 * @model
 * @generated
 */
public interface TransConstraint extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Trans Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trans Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trans Expr</em>' attribute.
   * @see #setTransExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getTransConstraint_TransExpr()
   * @model
   * @generated
   */
  String getTransExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint#getTransExpr <em>Trans Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trans Expr</em>' attribute.
   * @see #getTransExpr()
   * @generated
   */
  void setTransExpr(String value);

} // TransConstraint
