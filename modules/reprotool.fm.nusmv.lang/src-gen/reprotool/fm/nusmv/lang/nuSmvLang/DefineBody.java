/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Define Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getVarId <em>Var Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getDefineBody()
 * @model
 * @generated
 */
public interface DefineBody extends EObject
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
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getDefineBody_VarId()
   * @model
   * @generated
   */
  String getVarId();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getVarId <em>Var Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Id</em>' attribute.
   * @see #getVarId()
   * @generated
   */
  void setVarId(String value);

  /**
   * Returns the value of the '<em><b>Assignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment</em>' attribute.
   * @see #setAssignment(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getDefineBody_Assignment()
   * @model
   * @generated
   */
  String getAssignment();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getAssignment <em>Assignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignment</em>' attribute.
   * @see #getAssignment()
   * @generated
   */
  void setAssignment(String value);

} // DefineBody
