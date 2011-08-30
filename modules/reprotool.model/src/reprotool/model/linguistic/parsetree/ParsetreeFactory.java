/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.parsetree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.linguistic.parsetree.ParsetreePackage
 * @generated
 */
public interface ParsetreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParsetreeFactory eINSTANCE = reprotool.model.linguistic.parsetree.impl.ParsetreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sentence Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sentence Node</em>'.
	 * @generated
	 */
	SentenceNode createSentenceNode();

	/**
	 * Returns a new object of class '<em>Word</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Word</em>'.
	 * @generated
	 */
	Word createWord();

	/**
	 * Returns a new object of class '<em>Noun Phrase Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Noun Phrase Node</em>'.
	 * @generated
	 */
	NounPhraseNode createNounPhraseNode();

	/**
	 * Returns a new object of class '<em>Verb Phrase Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verb Phrase Node</em>'.
	 * @generated
	 */
	VerbPhraseNode createVerbPhraseNode();

	/**
	 * Returns a new object of class '<em>Prepositional Phrase Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prepositional Phrase Node</em>'.
	 * @generated
	 */
	PrepositionalPhraseNode createPrepositionalPhraseNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ParsetreePackage getParsetreePackage();

} //ParsetreeFactory
