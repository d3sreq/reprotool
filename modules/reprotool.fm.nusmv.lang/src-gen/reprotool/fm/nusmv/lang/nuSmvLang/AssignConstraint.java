/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getAssignConstraint()
 * @model
 * @generated
 */
public interface AssignConstraint extends ModuleElement
{
  /**
   * Returns the value of the '<em><b>Bodies</b></em>' containment reference list.
   * The list contents are of type {@link reprotool.fm.nusmv.lang.nuSmvLang.AssignBody}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bodies</em>' containment reference list.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getAssignConstraint_Bodies()
   * @model containment="true"
   * @generated
   */
  EList<AssignBody> getBodies();

} // AssignConstraint
