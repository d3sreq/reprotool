/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.txtspec.txtSpec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.txtspec.txtSpec.TextBlock#getWords <em>Words</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.txtspec.txtSpec.TxtSpecPackage#getTextBlock()
 * @model
 * @generated
 */
public interface TextBlock extends Block
{
  /**
   * Returns the value of the '<em><b>Words</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Words</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Words</em>' attribute list.
   * @see reprotool.txtspec.txtSpec.TxtSpecPackage#getTextBlock_Words()
   * @model unique="false"
   * @generated
   */
  EList<String> getWords();

} // TextBlock
