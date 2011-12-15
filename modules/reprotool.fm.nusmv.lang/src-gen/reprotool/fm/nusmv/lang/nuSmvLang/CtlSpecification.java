/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ctl Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#isNameKeyWord <em>Name Key Word</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getCtlExpr <em>Ctl Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getCtlSpecification()
 * @model
 * @generated
 */
public interface CtlSpecification extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Name Key Word</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Key Word</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Key Word</em>' attribute.
   * @see #setNameKeyWord(boolean)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getCtlSpecification_NameKeyWord()
   * @model
   * @generated
   */
  boolean isNameKeyWord();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#isNameKeyWord <em>Name Key Word</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Key Word</em>' attribute.
   * @see #isNameKeyWord()
   * @generated
   */
  void setNameKeyWord(boolean value);

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
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getCtlSpecification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Ctl Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ctl Expr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ctl Expr</em>' attribute.
   * @see #setCtlExpr(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getCtlSpecification_CtlExpr()
   * @model
   * @generated
   */
  String getCtlExpr();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getCtlExpr <em>Ctl Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ctl Expr</em>' attribute.
   * @see #getCtlExpr()
   * @generated
   */
  void setCtlExpr(String value);

} // CtlSpecification
