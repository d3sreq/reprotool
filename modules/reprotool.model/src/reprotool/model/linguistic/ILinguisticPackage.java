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
 * @see reprotool.model.linguistic.ILinguisticFactory
 * @model kind="package"
 * @generated
 */
public interface ILinguisticPackage extends EPackage {
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
	ILinguisticPackage eINSTANCE = reprotool.model.linguistic.impl.LinguisticPackage.init();

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.SentenceNode <em>Sentence Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.SentenceNode
	 * @see reprotool.model.linguistic.impl.LinguisticPackage#getSentenceNode()
	 * @generated
	 */
	int SENTENCE_NODE = 0;

	/**
	 * The feature id for the '<em><b>Child Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE__CHILD_FRAGMENTS = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Sentence Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.Word <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.Word
	 * @see reprotool.model.linguistic.impl.LinguisticPackage#getWord()
	 * @generated
	 */
	int WORD = 1;

	/**
	 * The feature id for the '<em><b>Child Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__CHILD_FRAGMENTS = SENTENCE_NODE__CHILD_FRAGMENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__TYPE = SENTENCE_NODE__TYPE;

	/**
	 * The feature id for the '<em><b>Word Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__WORD_STR = SENTENCE_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Word Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD__WORD_TYPE = SENTENCE_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_FEATURE_COUNT = SENTENCE_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.EWordType <em>EWord Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.EWordType
	 * @see reprotool.model.linguistic.impl.LinguisticPackage#getEWordType()
	 * @generated
	 */
	int EWORD_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.ISentenceNode <em>Sentence Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Node</em>'.
	 * @see reprotool.model.linguistic.ISentenceNode
	 * @generated
	 */
	EClass getSentenceNode();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.linguistic.ISentenceNode#getChildFragments <em>Child Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child Fragments</em>'.
	 * @see reprotool.model.linguistic.ISentenceNode#getChildFragments()
	 * @see #getSentenceNode()
	 * @generated
	 */
	EReference getSentenceNode_ChildFragments();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.ISentenceNode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see reprotool.model.linguistic.ISentenceNode#getType()
	 * @see #getSentenceNode()
	 * @generated
	 */
	EAttribute getSentenceNode_Type();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.IWord <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word</em>'.
	 * @see reprotool.model.linguistic.IWord
	 * @generated
	 */
	EClass getWord();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.IWord#getWordStr <em>Word Str</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Str</em>'.
	 * @see reprotool.model.linguistic.IWord#getWordStr()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_WordStr();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.IWord#getWordType <em>Word Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Type</em>'.
	 * @see reprotool.model.linguistic.IWord#getWordType()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_WordType();

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
	ILinguisticFactory getLinguisticFactory();

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
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.SentenceNode <em>Sentence Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.SentenceNode
		 * @see reprotool.model.linguistic.impl.LinguisticPackage#getSentenceNode()
		 * @generated
		 */
		EClass SENTENCE_NODE = eINSTANCE.getSentenceNode();

		/**
		 * The meta object literal for the '<em><b>Child Fragments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE_NODE__CHILD_FRAGMENTS = eINSTANCE.getSentenceNode_ChildFragments();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENTENCE_NODE__TYPE = eINSTANCE.getSentenceNode_Type();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.Word <em>Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.Word
		 * @see reprotool.model.linguistic.impl.LinguisticPackage#getWord()
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
		 * The meta object literal for the '{@link reprotool.model.linguistic.EWordType <em>EWord Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.EWordType
		 * @see reprotool.model.linguistic.impl.LinguisticPackage#getEWordType()
		 * @generated
		 */
		EEnum EWORD_TYPE = eINSTANCE.getEWordType();

	}

} //ILinguisticPackage
