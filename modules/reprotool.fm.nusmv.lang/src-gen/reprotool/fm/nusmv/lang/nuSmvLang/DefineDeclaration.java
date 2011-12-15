/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Define Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration#getDefineBodies <em>Define Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getDefineDeclaration()
 * @model
 * @generated
 */
public interface DefineDeclaration extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Define Bodies</b></em>' containment reference list.
   * The list contents are of type {@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Define Bodies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Define Bodies</em>' containment reference list.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getDefineDeclaration_DefineBodies()
   * @model containment="true"
   * @generated
   */
  EList<DefineBody> getDefineBodies();

} // DefineDeclaration
