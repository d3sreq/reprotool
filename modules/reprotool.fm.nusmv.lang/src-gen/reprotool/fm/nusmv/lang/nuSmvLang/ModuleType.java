/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleType#getModule <em>Module</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleType#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModuleType()
 * @model
 * @generated
 */
public interface ModuleType extends TypeSpecifier
{
  /**
   * Returns the value of the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module</em>' reference.
   * @see #setModule(Module)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModuleType_Module()
   * @model
   * @generated
   */
  Module getModule();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleType#getModule <em>Module</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' reference.
   * @see #getModule()
   * @generated
   */
  void setModule(Module value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' attribute list.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModuleType_Params()
   * @model unique="false"
   * @generated
   */
  EList<String> getParams();

} // ModuleType
