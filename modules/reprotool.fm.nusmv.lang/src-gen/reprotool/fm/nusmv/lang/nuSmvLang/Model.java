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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.Model#getModules <em>Modules</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
   * The list contents are of type {@link reprotool.fm.nusmv.lang.nuSmvLang.Module}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' containment reference list.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getModel_Modules()
   * @model containment="true"
   * @generated
   */
  EList<Module> getModules();

} // Model
