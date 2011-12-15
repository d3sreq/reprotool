/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invar Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getInvarExpr <em>Invar Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getInvarSpecification()
 * @model
 * @generated
 */
public interface InvarSpecification extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getInvarSpecification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getInvarSpecification_InvarExpr()
   * @model
   * @generated
   */
  String getInvarExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getInvarExpr <em>Invar Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invar Expr</em>' attribute.
   * @see #getInvarExpr()
   * @generated
   */
  void setInvarExpr(String value);

} // InvarSpecification
