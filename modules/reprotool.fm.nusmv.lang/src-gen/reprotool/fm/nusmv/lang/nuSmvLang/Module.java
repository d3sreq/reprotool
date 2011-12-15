/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.Module#getModuleElement <em>Module Element</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.Module#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject
{
  /**
   * Returns the value of the '<em><b>Module Element</b></em>' containment reference list.
   * The list contents are of type {@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module Element</em>' containment reference list.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModule_ModuleElement()
   * @model containment="true"
   * @generated
   */
  EList<ModuleElement> getModuleElement();

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
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.Module#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Module
