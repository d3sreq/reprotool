/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.txtspec.txtSpec;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.txtspec.txtSpec.TxtSpecPackage
 * @generated
 */
public interface TxtSpecFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TxtSpecFactory eINSTANCE = reprotool.txtspec.txtSpec.impl.TxtSpecFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Document</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document</em>'.
   * @generated
   */
  Document createDocument();

  /**
   * Returns a new object of class '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block</em>'.
   * @generated
   */
  Block createBlock();

  /**
   * Returns a new object of class '<em>Model Element Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Element Block</em>'.
   * @generated
   */
  ModelElementBlock createModelElementBlock();

  /**
   * Returns a new object of class '<em>Model Element Block Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Element Block Content</em>'.
   * @generated
   */
  ModelElementBlockContent createModelElementBlockContent();

  /**
   * Returns a new object of class '<em>Text Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Text Block</em>'.
   * @generated
   */
  TextBlock createTextBlock();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TxtSpecPackage getTxtSpecPackage();

} //TxtSpecFactory
