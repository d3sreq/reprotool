/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.txtspec.txtSpec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.txtspec.txtSpec.ModelElementBlock#getUrl <em>Url</em>}</li>
 *   <li>{@link reprotool.txtspec.txtSpec.ModelElementBlock#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.txtspec.txtSpec.TxtSpecPackage#getModelElementBlock()
 * @model
 * @generated
 */
public interface ModelElementBlock extends Block
{
  /**
   * Returns the value of the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Url</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Url</em>' attribute.
   * @see #setUrl(String)
   * @see reprotool.txtspec.txtSpec.TxtSpecPackage#getModelElementBlock_Url()
   * @model
   * @generated
   */
  String getUrl();

  /**
   * Sets the value of the '{@link reprotool.txtspec.txtSpec.ModelElementBlock#getUrl <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Url</em>' attribute.
   * @see #getUrl()
   * @generated
   */
  void setUrl(String value);

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference.
   * @see #setContent(ModelElementBlockContent)
   * @see reprotool.txtspec.txtSpec.TxtSpecPackage#getModelElementBlock_Content()
   * @model containment="true"
   * @generated
   */
  ModelElementBlockContent getContent();

  /**
   * Sets the value of the '{@link reprotool.txtspec.txtSpec.ModelElementBlock#getContent <em>Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' containment reference.
   * @see #getContent()
   * @generated
   */
  void setContent(ModelElementBlockContent value);

} // ModelElementBlock
