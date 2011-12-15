/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.txtspec.txtSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.txtspec.txtSpec.Document#getBlocks <em>Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.txtspec.txtSpec.TxtSpecPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject
{
  /**
   * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
   * The list contents are of type {@link reprotool.txtspec.txtSpec.Block}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Blocks</em>' containment reference list.
   * @see reprotool.txtspec.txtSpec.TxtSpecPackage#getDocument_Blocks()
   * @model containment="true"
   * @generated
   */
  EList<Block> getBlocks();

} // Document
