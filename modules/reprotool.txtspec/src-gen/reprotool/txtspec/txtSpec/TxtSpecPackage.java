/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.txtspec.txtSpec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see reprotool.txtspec.txtSpec.TxtSpecFactory
 * @model kind="package"
 * @generated
 */
public interface TxtSpecPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "txtSpec";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipselabs.org/reprotool/txtspec";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "txtSpec";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TxtSpecPackage eINSTANCE = reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl.init();

  /**
   * The meta object id for the '{@link reprotool.txtspec.txtSpec.impl.DocumentImpl <em>Document</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.txtspec.txtSpec.impl.DocumentImpl
   * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getDocument()
   * @generated
   */
  int DOCUMENT = 0;

  /**
   * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT__BLOCKS = 0;

  /**
   * The number of structural features of the '<em>Document</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link reprotool.txtspec.txtSpec.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.txtspec.txtSpec.impl.BlockImpl
   * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 1;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link reprotool.txtspec.txtSpec.impl.ModelElementBlockImpl <em>Model Element Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.txtspec.txtSpec.impl.ModelElementBlockImpl
   * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getModelElementBlock()
   * @generated
   */
  int MODEL_ELEMENT_BLOCK = 2;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_BLOCK__URL = BLOCK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_BLOCK__CONTENT = BLOCK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Model Element Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_BLOCK_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link reprotool.txtspec.txtSpec.impl.ModelElementBlockContentImpl <em>Model Element Block Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.txtspec.txtSpec.impl.ModelElementBlockContentImpl
   * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getModelElementBlockContent()
   * @generated
   */
  int MODEL_ELEMENT_BLOCK_CONTENT = 3;

  /**
   * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_BLOCK_CONTENT__BLOCKS = 0;

  /**
   * The number of structural features of the '<em>Model Element Block Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_BLOCK_CONTENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link reprotool.txtspec.txtSpec.impl.TextBlockImpl <em>Text Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.txtspec.txtSpec.impl.TextBlockImpl
   * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getTextBlock()
   * @generated
   */
  int TEXT_BLOCK = 4;

  /**
   * The feature id for the '<em><b>Words</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_BLOCK__WORDS = BLOCK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Text Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_BLOCK_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link reprotool.txtspec.txtSpec.Document <em>Document</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document</em>'.
   * @see reprotool.txtspec.txtSpec.Document
   * @generated
   */
  EClass getDocument();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.txtspec.txtSpec.Document#getBlocks <em>Blocks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Blocks</em>'.
   * @see reprotool.txtspec.txtSpec.Document#getBlocks()
   * @see #getDocument()
   * @generated
   */
  EReference getDocument_Blocks();

  /**
   * Returns the meta object for class '{@link reprotool.txtspec.txtSpec.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see reprotool.txtspec.txtSpec.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for class '{@link reprotool.txtspec.txtSpec.ModelElementBlock <em>Model Element Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element Block</em>'.
   * @see reprotool.txtspec.txtSpec.ModelElementBlock
   * @generated
   */
  EClass getModelElementBlock();

  /**
   * Returns the meta object for the attribute '{@link reprotool.txtspec.txtSpec.ModelElementBlock#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see reprotool.txtspec.txtSpec.ModelElementBlock#getUrl()
   * @see #getModelElementBlock()
   * @generated
   */
  EAttribute getModelElementBlock_Url();

  /**
   * Returns the meta object for the containment reference '{@link reprotool.txtspec.txtSpec.ModelElementBlock#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see reprotool.txtspec.txtSpec.ModelElementBlock#getContent()
   * @see #getModelElementBlock()
   * @generated
   */
  EReference getModelElementBlock_Content();

  /**
   * Returns the meta object for class '{@link reprotool.txtspec.txtSpec.ModelElementBlockContent <em>Model Element Block Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element Block Content</em>'.
   * @see reprotool.txtspec.txtSpec.ModelElementBlockContent
   * @generated
   */
  EClass getModelElementBlockContent();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.txtspec.txtSpec.ModelElementBlockContent#getBlocks <em>Blocks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Blocks</em>'.
   * @see reprotool.txtspec.txtSpec.ModelElementBlockContent#getBlocks()
   * @see #getModelElementBlockContent()
   * @generated
   */
  EReference getModelElementBlockContent_Blocks();

  /**
   * Returns the meta object for class '{@link reprotool.txtspec.txtSpec.TextBlock <em>Text Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Block</em>'.
   * @see reprotool.txtspec.txtSpec.TextBlock
   * @generated
   */
  EClass getTextBlock();

  /**
   * Returns the meta object for the attribute list '{@link reprotool.txtspec.txtSpec.TextBlock#getWords <em>Words</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Words</em>'.
   * @see reprotool.txtspec.txtSpec.TextBlock#getWords()
   * @see #getTextBlock()
   * @generated
   */
  EAttribute getTextBlock_Words();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TxtSpecFactory getTxtSpecFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link reprotool.txtspec.txtSpec.impl.DocumentImpl <em>Document</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.txtspec.txtSpec.impl.DocumentImpl
     * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getDocument()
     * @generated
     */
    EClass DOCUMENT = eINSTANCE.getDocument();

    /**
     * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT__BLOCKS = eINSTANCE.getDocument_Blocks();

    /**
     * The meta object literal for the '{@link reprotool.txtspec.txtSpec.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.txtspec.txtSpec.impl.BlockImpl
     * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '{@link reprotool.txtspec.txtSpec.impl.ModelElementBlockImpl <em>Model Element Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.txtspec.txtSpec.impl.ModelElementBlockImpl
     * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getModelElementBlock()
     * @generated
     */
    EClass MODEL_ELEMENT_BLOCK = eINSTANCE.getModelElementBlock();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT_BLOCK__URL = eINSTANCE.getModelElementBlock_Url();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT_BLOCK__CONTENT = eINSTANCE.getModelElementBlock_Content();

    /**
     * The meta object literal for the '{@link reprotool.txtspec.txtSpec.impl.ModelElementBlockContentImpl <em>Model Element Block Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.txtspec.txtSpec.impl.ModelElementBlockContentImpl
     * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getModelElementBlockContent()
     * @generated
     */
    EClass MODEL_ELEMENT_BLOCK_CONTENT = eINSTANCE.getModelElementBlockContent();

    /**
     * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT_BLOCK_CONTENT__BLOCKS = eINSTANCE.getModelElementBlockContent_Blocks();

    /**
     * The meta object literal for the '{@link reprotool.txtspec.txtSpec.impl.TextBlockImpl <em>Text Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.txtspec.txtSpec.impl.TextBlockImpl
     * @see reprotool.txtspec.txtSpec.impl.TxtSpecPackageImpl#getTextBlock()
     * @generated
     */
    EClass TEXT_BLOCK = eINSTANCE.getTextBlock();

    /**
     * The meta object literal for the '<em><b>Words</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXT_BLOCK__WORDS = eINSTANCE.getTextBlock_Words();

  }

} //TxtSpecPackage
