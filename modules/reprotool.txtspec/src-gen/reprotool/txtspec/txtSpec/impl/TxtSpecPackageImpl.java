/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.txtspec.txtSpec.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.txtspec.txtSpec.Block;
import reprotool.txtspec.txtSpec.Document;
import reprotool.txtspec.txtSpec.ModelElementBlock;
import reprotool.txtspec.txtSpec.ModelElementBlockContent;
import reprotool.txtspec.txtSpec.TextBlock;
import reprotool.txtspec.txtSpec.TxtSpecFactory;
import reprotool.txtspec.txtSpec.TxtSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TxtSpecPackageImpl extends EPackageImpl implements TxtSpecPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelElementBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelElementBlockContentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass textBlockEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see reprotool.txtspec.txtSpec.TxtSpecPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TxtSpecPackageImpl()
  {
    super(eNS_URI, TxtSpecFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TxtSpecPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TxtSpecPackage init()
  {
    if (isInited) return (TxtSpecPackage)EPackage.Registry.INSTANCE.getEPackage(TxtSpecPackage.eNS_URI);

    // Obtain or create and register package
    TxtSpecPackageImpl theTxtSpecPackage = (TxtSpecPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TxtSpecPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TxtSpecPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTxtSpecPackage.createPackageContents();

    // Initialize created meta-data
    theTxtSpecPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTxtSpecPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TxtSpecPackage.eNS_URI, theTxtSpecPackage);
    return theTxtSpecPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocument()
  {
    return documentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocument_Blocks()
  {
    return (EReference)documentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlock()
  {
    return blockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelElementBlock()
  {
    return modelElementBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelElementBlock_Url()
  {
    return (EAttribute)modelElementBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelElementBlock_Content()
  {
    return (EReference)modelElementBlockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelElementBlockContent()
  {
    return modelElementBlockContentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelElementBlockContent_Blocks()
  {
    return (EReference)modelElementBlockContentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTextBlock()
  {
    return textBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTextBlock_Words()
  {
    return (EAttribute)textBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TxtSpecFactory getTxtSpecFactory()
  {
    return (TxtSpecFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    documentEClass = createEClass(DOCUMENT);
    createEReference(documentEClass, DOCUMENT__BLOCKS);

    blockEClass = createEClass(BLOCK);

    modelElementBlockEClass = createEClass(MODEL_ELEMENT_BLOCK);
    createEAttribute(modelElementBlockEClass, MODEL_ELEMENT_BLOCK__URL);
    createEReference(modelElementBlockEClass, MODEL_ELEMENT_BLOCK__CONTENT);

    modelElementBlockContentEClass = createEClass(MODEL_ELEMENT_BLOCK_CONTENT);
    createEReference(modelElementBlockContentEClass, MODEL_ELEMENT_BLOCK_CONTENT__BLOCKS);

    textBlockEClass = createEClass(TEXT_BLOCK);
    createEAttribute(textBlockEClass, TEXT_BLOCK__WORDS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    modelElementBlockEClass.getESuperTypes().add(this.getBlock());
    textBlockEClass.getESuperTypes().add(this.getBlock());

    // Initialize classes and features; add operations and parameters
    initEClass(documentEClass, Document.class, "Document", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDocument_Blocks(), this.getBlock(), null, "blocks", null, 0, -1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(modelElementBlockEClass, ModelElementBlock.class, "ModelElementBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelElementBlock_Url(), ecorePackage.getEString(), "url", null, 0, 1, ModelElementBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelElementBlock_Content(), this.getModelElementBlockContent(), null, "content", null, 0, 1, ModelElementBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelElementBlockContentEClass, ModelElementBlockContent.class, "ModelElementBlockContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelElementBlockContent_Blocks(), this.getBlock(), null, "blocks", null, 0, -1, ModelElementBlockContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(textBlockEClass, TextBlock.class, "TextBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTextBlock_Words(), ecorePackage.getEString(), "words", null, 0, -1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TxtSpecPackageImpl
