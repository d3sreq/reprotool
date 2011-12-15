/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constants Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration#getConstants <em>Constants</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getConstantsDeclaration()
 * @model
 * @generated
 */
public interface ConstantsDeclaration extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Constants</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constants</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' attribute list.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getConstantsDeclaration_Constants()
   * @model unique="false"
   * @generated
   */
  EList<String> getConstants();

} // ConstantsDeclaration
