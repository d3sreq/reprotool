/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ltl Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#isNameId <em>Name Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getLtlExpr <em>Ltl Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getLtlSpecification()
 * @model
 * @generated
 */
public interface LtlSpecification extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Name Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Id</em>' attribute.
   * @see #setNameId(boolean)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getLtlSpecification_NameId()
   * @model
   * @generated
   */
  boolean isNameId();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#isNameId <em>Name Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Id</em>' attribute.
   * @see #isNameId()
   * @generated
   */
  void setNameId(boolean value);

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
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getLtlSpecification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Ltl Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ltl Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ltl Expr</em>' attribute.
   * @see #setLtlExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getLtlSpecification_LtlExpr()
   * @model
   * @generated
   */
  String getLtlExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getLtlExpr <em>Ltl Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ltl Expr</em>' attribute.
   * @see #getLtlExpr()
   * @generated
   */
  void setLtlExpr(String value);

} // LtlSpecification
