/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling;

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
	 * The number of structural features of the '<em>Sentence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_FEATURE_COUNT = 1;

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
	 * The number of structural features of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_FEATURE_COUNT = 1;


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

	}

} //LingPackage
