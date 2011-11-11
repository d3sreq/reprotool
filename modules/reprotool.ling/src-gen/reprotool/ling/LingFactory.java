/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.ling;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.ling.LingPackage
 * @generated
 */
public interface LingFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LingFactory eINSTANCE = reprotool.ling.impl.LingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sentence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sentence</em>'.
	 * @generated
	 */
	Sentence createSentence();

	/**
	 * Returns a new object of class '<em>Word</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Word</em>'.
	 * @generated
	 */
	Word createWord();

	/**
	 * Returns a new object of class '<em>Sentence Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sentence Node</em>'.
	 * @generated
	 */
	SentenceNode createSentenceNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LingPackage getLingPackage();

} //LingFactory
