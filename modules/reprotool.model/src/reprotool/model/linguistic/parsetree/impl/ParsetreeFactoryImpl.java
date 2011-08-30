/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.parsetree.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.model.linguistic.parsetree.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParsetreeFactoryImpl extends EFactoryImpl implements ParsetreeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParsetreeFactory init() {
		try {
			ParsetreeFactory theParsetreeFactory = (ParsetreeFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/model/linguistic/parsetree"); 
			if (theParsetreeFactory != null) {
				return theParsetreeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParsetreeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsetreeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ParsetreePackage.SENTENCE_NODE: return createSentenceNode();
			case ParsetreePackage.WORD: return createWord();
			case ParsetreePackage.NOUN_PHRASE_NODE: return createNounPhraseNode();
			case ParsetreePackage.VERB_PHRASE_NODE: return createVerbPhraseNode();
			case ParsetreePackage.PREPOSITIONAL_PHRASE_NODE: return createPrepositionalPhraseNode();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode createSentenceNode() {
		SentenceNodeImpl sentenceNode = new SentenceNodeImpl();
		return sentenceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word createWord() {
		WordImpl word = new WordImpl();
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NounPhraseNode createNounPhraseNode() {
		NounPhraseNodeImpl nounPhraseNode = new NounPhraseNodeImpl();
		return nounPhraseNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerbPhraseNode createVerbPhraseNode() {
		VerbPhraseNodeImpl verbPhraseNode = new VerbPhraseNodeImpl();
		return verbPhraseNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrepositionalPhraseNode createPrepositionalPhraseNode() {
		PrepositionalPhraseNodeImpl prepositionalPhraseNode = new PrepositionalPhraseNodeImpl();
		return prepositionalPhraseNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsetreePackage getParsetreePackage() {
		return (ParsetreePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ParsetreePackage getPackage() {
		return ParsetreePackage.eINSTANCE;
	}

} //ParsetreeFactoryImpl
