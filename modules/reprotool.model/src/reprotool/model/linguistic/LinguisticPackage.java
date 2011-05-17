/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see reprotool.model.linguistic.LinguisticFactory
 * @model kind="package"
 * @generated
 */
public interface LinguisticPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "linguistic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/linguistic";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "linguistic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LinguisticPackage eINSTANCE = reprotool.model.linguistic.impl.LinguisticPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.ParseNode <em>Parse Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.ParseNode
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getParseNode()
	 * @generated
	 */
	int PARSE_NODE = 2;

	/**
	 * The number of structural features of the '<em>Parse Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_NODE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.InnerParseNode <em>Inner Parse Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.InnerParseNode
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getInnerParseNode()
	 * @generated
	 */
	int INNER_PARSE_NODE = 6;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_PARSE_NODE__CHILD_NODES = PARSE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inner Parse Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_PARSE_NODE_FEATURE_COUNT = PARSE_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.SentenceNodeImpl <em>Sentence Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.SentenceNodeImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSentenceNode()
	 * @generated
	 */
	int SENTENCE_NODE = 0;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE__CHILD_NODES = INNER_PARSE_NODE__CHILD_NODES;

	/**
	 * The number of structural features of the '<em>Sentence Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE_FEATURE_COUNT = INNER_PARSE_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.WordImpl <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.WordImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getWord()
	 * @generated
	 */
	int WORD = 1;

	/**
	 * The feature id for the '<em><b>Word Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__WORD_STR = PARSE_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Word Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__WORD_TYPE = PARSE_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_FEATURE_COUNT = PARSE_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.NounPhraseNodeImpl <em>Noun Phrase Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.NounPhraseNodeImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getNounPhraseNode()
	 * @generated
	 */
	int NOUN_PHRASE_NODE = 3;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOUN_PHRASE_NODE__CHILD_NODES = INNER_PARSE_NODE__CHILD_NODES;

	/**
	 * The number of structural features of the '<em>Noun Phrase Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOUN_PHRASE_NODE_FEATURE_COUNT = INNER_PARSE_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.VerbPhraseNodeImpl <em>Verb Phrase Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.VerbPhraseNodeImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getVerbPhraseNode()
	 * @generated
	 */
	int VERB_PHRASE_NODE = 4;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB_PHRASE_NODE__CHILD_NODES = INNER_PARSE_NODE__CHILD_NODES;

	/**
	 * The number of structural features of the '<em>Verb Phrase Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB_PHRASE_NODE_FEATURE_COUNT = INNER_PARSE_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.PrepositionalPhraseNodeImpl <em>Prepositional Phrase Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.PrepositionalPhraseNodeImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getPrepositionalPhraseNode()
	 * @generated
	 */
	int PREPOSITIONAL_PHRASE_NODE = 5;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPOSITIONAL_PHRASE_NODE__CHILD_NODES = INNER_PARSE_NODE__CHILD_NODES;

	/**
	 * The number of structural features of the '<em>Prepositional Phrase Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPOSITIONAL_PHRASE_NODE_FEATURE_COUNT = INNER_PARSE_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.EWordType <em>EWord Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.EWordType
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getEWordType()
	 * @generated
	 */
	int EWORD_TYPE = 7;


	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.SentenceNode <em>Sentence Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Node</em>'.
	 * @see reprotool.model.linguistic.SentenceNode
	 * @generated
	 */
	EClass getSentenceNode();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word</em>'.
	 * @see reprotool.model.linguistic.Word
	 * @generated
	 */
	EClass getWord();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.Word#getWordStr <em>Word Str</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Str</em>'.
	 * @see reprotool.model.linguistic.Word#getWordStr()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_WordStr();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.Word#getWordType <em>Word Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Type</em>'.
	 * @see reprotool.model.linguistic.Word#getWordType()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_WordType();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.ParseNode <em>Parse Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parse Node</em>'.
	 * @see reprotool.model.linguistic.ParseNode
	 * @generated
	 */
	EClass getParseNode();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.NounPhraseNode <em>Noun Phrase Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Noun Phrase Node</em>'.
	 * @see reprotool.model.linguistic.NounPhraseNode
	 * @generated
	 */
	EClass getNounPhraseNode();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.VerbPhraseNode <em>Verb Phrase Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verb Phrase Node</em>'.
	 * @see reprotool.model.linguistic.VerbPhraseNode
	 * @generated
	 */
	EClass getVerbPhraseNode();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.PrepositionalPhraseNode <em>Prepositional Phrase Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prepositional Phrase Node</em>'.
	 * @see reprotool.model.linguistic.PrepositionalPhraseNode
	 * @generated
	 */
	EClass getPrepositionalPhraseNode();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.InnerParseNode <em>Inner Parse Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inner Parse Node</em>'.
	 * @see reprotool.model.linguistic.InnerParseNode
	 * @generated
	 */
	EClass getInnerParseNode();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.linguistic.InnerParseNode#getChildNodes <em>Child Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Nodes</em>'.
	 * @see reprotool.model.linguistic.InnerParseNode#getChildNodes()
	 * @see #getInnerParseNode()
	 * @generated
	 */
	EReference getInnerParseNode_ChildNodes();

	/**
	 * Returns the meta object for enum '{@link reprotool.model.linguistic.EWordType <em>EWord Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EWord Type</em>'.
	 * @see reprotool.model.linguistic.EWordType
	 * @generated
	 */
	EEnum getEWordType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LinguisticFactory getLinguisticFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.SentenceNodeImpl <em>Sentence Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.SentenceNodeImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSentenceNode()
		 * @generated
		 */
		EClass SENTENCE_NODE = eINSTANCE.getSentenceNode();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.WordImpl <em>Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.WordImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getWord()
		 * @generated
		 */
		EClass WORD = eINSTANCE.getWord();

		/**
		 * The meta object literal for the '<em><b>Word Str</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__WORD_STR = eINSTANCE.getWord_WordStr();

		/**
		 * The meta object literal for the '<em><b>Word Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__WORD_TYPE = eINSTANCE.getWord_WordType();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.ParseNode <em>Parse Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.ParseNode
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getParseNode()
		 * @generated
		 */
		EClass PARSE_NODE = eINSTANCE.getParseNode();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.NounPhraseNodeImpl <em>Noun Phrase Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.NounPhraseNodeImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getNounPhraseNode()
		 * @generated
		 */
		EClass NOUN_PHRASE_NODE = eINSTANCE.getNounPhraseNode();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.VerbPhraseNodeImpl <em>Verb Phrase Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.VerbPhraseNodeImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getVerbPhraseNode()
		 * @generated
		 */
		EClass VERB_PHRASE_NODE = eINSTANCE.getVerbPhraseNode();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.PrepositionalPhraseNodeImpl <em>Prepositional Phrase Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.PrepositionalPhraseNodeImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getPrepositionalPhraseNode()
		 * @generated
		 */
		EClass PREPOSITIONAL_PHRASE_NODE = eINSTANCE.getPrepositionalPhraseNode();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.InnerParseNode <em>Inner Parse Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.InnerParseNode
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getInnerParseNode()
		 * @generated
		 */
		EClass INNER_PARSE_NODE = eINSTANCE.getInnerParseNode();

		/**
		 * The meta object literal for the '<em><b>Child Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INNER_PARSE_NODE__CHILD_NODES = eINSTANCE.getInnerParseNode_ChildNodes();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.EWordType <em>EWord Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.EWordType
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getEWordType()
		 * @generated
		 */
		EEnum EWORD_TYPE = eINSTANCE.getEWordType();

	}

} //LinguisticPackage
