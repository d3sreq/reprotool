/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getVarId <em>Var Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getVarBody()
 * @model
 * @generated
 */
public interface VarBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Id</em>' attribute.
   * @see #setVarId(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getVarBody_VarId()
   * @model
   * @generated
   */
  String getVarId();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getVarId <em>Var Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Id</em>' attribute.
   * @see #getVarId()
   * @generated
   */
  void setVarId(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeSpecifier)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getVarBody_Type()
   * @model containment="true"
   * @generated
   */
  TypeSpecifier getType();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeSpecifier value);

} // VarBody
