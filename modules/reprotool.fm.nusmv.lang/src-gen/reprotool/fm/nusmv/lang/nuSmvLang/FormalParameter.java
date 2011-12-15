/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter#getParamId <em>Param Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getFormalParameter()
 * @model
 * @generated
 */
public interface FormalParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Param Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Id</em>' attribute.
   * @see #setParamId(String)
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#getFormalParameter_ParamId()
   * @model
   * @generated
   */
  String getParamId();

  /**
   * Sets the value of the '{@link reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter#getParamId <em>Param Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param Id</em>' attribute.
   * @see #getParamId()
   * @generated
   */
  void setParamId(String value);

} // FormalParameter
