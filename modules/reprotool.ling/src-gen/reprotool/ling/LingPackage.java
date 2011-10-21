/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling;

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
 * @see reprotool.ling.LingFactory
 * @model kind="package"
 * @generated
 */
public interface LingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/ling";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LingPackage eINSTANCE = reprotool.ling.impl.LingPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.ling.impl.SentenceImpl <em>Sentence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.ling.impl.SentenceImpl
	 * @see reprotool.ling.impl.LingPackageImpl#getSentence()
	 * @generated
	 */
	int SENTENCE = 0;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__WORDS = 0;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__EREFERENCE0 = 1;

	/**
	 * The feature id for the '<em><b>Sentence Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__SENTENCE_TREE = 2;

	/**
	 * The number of structural features of the '<em>Sentence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link reprotool.ling.impl.WordImpl <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.ling.impl.WordImpl
	 * @see reprotool.ling.impl.LingPackageImpl#getWord()
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
	int WORD__WORD_STR = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__TEXT = 1;

	/**
	 * The feature id for the '<em><b>Lemma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__LEMMA = 2;

	/**
	 * The feature id for the '<em><b>POS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__POS = 3;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__ACTOR = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__ID = 5;

	/**
	 * The number of structural features of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link reprotool.ling.impl.SentenceNodeImpl <em>Sentence Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.ling.impl.SentenceNodeImpl
	 * @see reprotool.ling.impl.LingPackageImpl#getSentenceNode()
	 * @generated
	 */
	int SENTENCE_NODE = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Word</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE__WORD = 2;

	/**
	 * The number of structural features of the '<em>Sentence Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link reprotool.ling.SentenceType <em>Sentence Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.ling.SentenceType
	 * @see reprotool.ling.impl.LingPackageImpl#getSentenceType()
	 * @generated
	 */
	int SENTENCE_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link reprotool.ling.Sentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence</em>'.
	 * @see reprotool.ling.Sentence
	 * @generated
	 */
	EClass getSentence();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.ling.Sentence#getWords <em>Words</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Words</em>'.
	 * @see reprotool.ling.Sentence#getWords()
	 * @see #getSentence()
	 * @generated
	 */
	EReference getSentence_Words();

	/**
	 * Returns the meta object for the reference '{@link reprotool.ling.Sentence#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see reprotool.ling.Sentence#getEReference0()
	 * @see #getSentence()
	 * @generated
	 */
	EReference getSentence_EReference0();

	/**
	 * Returns the meta object for the reference '{@link reprotool.ling.Sentence#getSentenceTree <em>Sentence Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sentence Tree</em>'.
	 * @see reprotool.ling.Sentence#getSentenceTree()
	 * @see #getSentence()
	 * @generated
	 */
	EReference getSentence_SentenceTree();

	/**
	 * Returns the meta object for class '{@link reprotool.ling.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word</em>'.
	 * @see reprotool.ling.Word
	 * @generated
	 */
	EClass getWord();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.ling.Word#getWordStr <em>Word Str</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Str</em>'.
	 * @see reprotool.ling.Word#getWordStr()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_WordStr();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.ling.Word#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see reprotool.ling.Word#getText()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_Text();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.ling.Word#getLemma <em>Lemma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lemma</em>'.
	 * @see reprotool.ling.Word#getLemma()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_Lemma();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.ling.Word#getPOS <em>POS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>POS</em>'.
	 * @see reprotool.ling.Word#getPOS()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_POS();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.ling.Word#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actor</em>'.
	 * @see reprotool.ling.Word#getActor()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_Actor();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.ling.Word#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see reprotool.ling.Word#getID()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_ID();

	/**
	 * Returns the meta object for class '{@link reprotool.ling.SentenceNode <em>Sentence Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Node</em>'.
	 * @see reprotool.ling.SentenceNode
	 * @generated
	 */
	EClass getSentenceNode();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.ling.SentenceNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see reprotool.ling.SentenceNode#getChildren()
	 * @see #getSentenceNode()
	 * @generated
	 */
	EReference getSentenceNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.ling.SentenceNode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see reprotool.ling.SentenceNode#getType()
	 * @see #getSentenceNode()
	 * @generated
	 */
	EAttribute getSentenceNode_Type();

	/**
	 * Returns the meta object for the reference '{@link reprotool.ling.SentenceNode#getWord <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Word</em>'.
	 * @see reprotool.ling.SentenceNode#getWord()
	 * @see #getSentenceNode()
	 * @generated
	 */
	EReference getSentenceNode_Word();

	/**
	 * Returns the meta object for enum '{@link reprotool.ling.SentenceType <em>Sentence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sentence Type</em>'.
	 * @see reprotool.ling.SentenceType
	 * @generated
	 */
	EEnum getSentenceType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LingFactory getLingFactory();

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
		 * The meta object literal for the '{@link reprotool.ling.impl.SentenceImpl <em>Sentence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.ling.impl.SentenceImpl
		 * @see reprotool.ling.impl.LingPackageImpl#getSentence()
		 * @generated
		 */
		EClass SENTENCE = eINSTANCE.getSentence();

		/**
		 * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE__WORDS = eINSTANCE.getSentence_Words();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE__EREFERENCE0 = eINSTANCE.getSentence_EReference0();

		/**
		 * The meta object literal for the '<em><b>Sentence Tree</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE__SENTENCE_TREE = eINSTANCE.getSentence_SentenceTree();

		/**
		 * The meta object literal for the '{@link reprotool.ling.impl.WordImpl <em>Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.ling.impl.WordImpl
		 * @see reprotool.ling.impl.LingPackageImpl#getWord()
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
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__TEXT = eINSTANCE.getWord_Text();

		/**
		 * The meta object literal for the '<em><b>Lemma</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__LEMMA = eINSTANCE.getWord_Lemma();

		/**
		 * The meta object literal for the '<em><b>POS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__POS = eINSTANCE.getWord_POS();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__ACTOR = eINSTANCE.getWord_Actor();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORD__ID = eINSTANCE.getWord_ID();

		/**
		 * The meta object literal for the '{@link reprotool.ling.impl.SentenceNodeImpl <em>Sentence Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.ling.impl.SentenceNodeImpl
		 * @see reprotool.ling.impl.LingPackageImpl#getSentenceNode()
		 * @generated
		 */
		EClass SENTENCE_NODE = eINSTANCE.getSentenceNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE_NODE__CHILDREN = eINSTANCE.getSentenceNode_Children();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENTENCE_NODE__TYPE = eINSTANCE.getSentenceNode_Type();

		/**
		 * The meta object literal for the '<em><b>Word</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE_NODE__WORD = eINSTANCE.getSentenceNode_Word();

		/**
		 * The meta object literal for the '{@link reprotool.ling.SentenceType <em>Sentence Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.ling.SentenceType
		 * @see reprotool.ling.impl.LingPackageImpl#getSentenceType()
		 * @generated
		 */
		EEnum SENTENCE_TYPE = eINSTANCE.getSentenceType();

	}

} //LingPackage
