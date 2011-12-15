/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.txtspec.txtSpec.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.txtspec.txtSpec.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TxtSpecFactoryImpl extends EFactoryImpl implements TxtSpecFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TxtSpecFactory init()
  {
    try
    {
      TxtSpecFactory theTxtSpecFactory = (TxtSpecFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipselabs.org/reprotool/txtspec"); 
      if (theTxtSpecFactory != null)
      {
        return theTxtSpecFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TxtSpecFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TxtSpecFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TxtSpecPackage.DOCUMENT: return createDocument();
      case TxtSpecPackage.BLOCK: return createBlock();
      case TxtSpecPackage.MODEL_ELEMENT_BLOCK: return createModelElementBlock();
      case TxtSpecPackage.MODEL_ELEMENT_BLOCK_CONTENT: return createModelElementBlockContent();
      case TxtSpecPackage.TEXT_BLOCK: return createTextBlock();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Document createDocument()
  {
    DocumentImpl document = new DocumentImpl();
    return document;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElementBlock createModelElementBlock()
  {
    ModelElementBlockImpl modelElementBlock = new ModelElementBlockImpl();
    return modelElementBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElementBlockContent createModelElementBlockContent()
  {
    ModelElementBlockContentImpl modelElementBlockContent = new ModelElementBlockContentImpl();
    return modelElementBlockContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextBlock createTextBlock()
  {
    TextBlockImpl textBlock = new TextBlockImpl();
    return textBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TxtSpecPackage getTxtSpecPackage()
  {
    return (TxtSpecPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TxtSpecPackage getPackage()
  {
    return TxtSpecPackage.eINSTANCE;
  }

} //TxtSpecFactoryImpl
