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
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.SentencePartImpl <em>Sentence Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.SentencePartImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSentencePart()
	 * @generated
	 */
	int SENTENCE_PART = 7;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_PART__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Sentence Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.TextImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 8;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.SubjectImpl <em>Subject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.SubjectImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSubject()
	 * @generated
	 */
	int SUBJECT = 9;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__ACTOR = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.GotoTargetImpl <em>Goto Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.GotoTargetImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getGotoTarget()
	 * @generated
	 */
	int GOTO_TARGET = 10;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET__TARGET = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goto Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.SentenceObjectImpl <em>Sentence Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.SentenceObjectImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSentenceObject()
	 * @generated
	 */
	int SENTENCE_OBJECT = 11;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT__OBJECT = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sentence Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.RepresentativeObjectImpl <em>Representative Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.RepresentativeObjectImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getRepresentativeObject()
	 * @generated
	 */
	int REPRESENTATIVE_OBJECT = 12;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATIVE_OBJECT__CONTENT = SENTENCE_OBJECT__CONTENT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATIVE_OBJECT__OBJECT = SENTENCE_OBJECT__OBJECT;

	/**
	 * The number of structural features of the '<em>Representative Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATIVE_OBJECT_FEATURE_COUNT = SENTENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.IndirectObjectImpl <em>Indirect Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.IndirectObjectImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getIndirectObject()
	 * @generated
	 */
	int INDIRECT_OBJECT = 13;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_OBJECT__CONTENT = SENTENCE_OBJECT__CONTENT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_OBJECT__OBJECT = SENTENCE_OBJECT__OBJECT;

	/**
	 * The number of structural features of the '<em>Indirect Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_OBJECT_FEATURE_COUNT = SENTENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.impl.VerbImpl <em>Verb</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.impl.VerbImpl
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getVerb()
	 * @generated
	 */
	int VERB = 14;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The number of structural features of the '<em>Verb</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.EWordType <em>EWord Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.EWordType
	 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getEWordType()
	 * @generated
	 */
	int EWORD_TYPE = 15;


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
	 * Returns the meta object for class '{@link reprotool.model.linguistic.SentencePart <em>Sentence Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Part</em>'.
	 * @see reprotool.model.linguistic.SentencePart
	 * @generated
	 */
	EClass getSentencePart();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.SentencePart#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see reprotool.model.linguistic.SentencePart#getContent()
	 * @see #getSentencePart()
	 * @generated
	 */
	EAttribute getSentencePart_Content();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see reprotool.model.linguistic.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subject</em>'.
	 * @see reprotool.model.linguistic.Subject
	 * @generated
	 */
	EClass getSubject();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.Subject#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see reprotool.model.linguistic.Subject#getActor()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_Actor();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.GotoTarget <em>Goto Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto Target</em>'.
	 * @see reprotool.model.linguistic.GotoTarget
	 * @generated
	 */
	EClass getGotoTarget();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.GotoTarget#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see reprotool.model.linguistic.GotoTarget#getTarget()
	 * @see #getGotoTarget()
	 * @generated
	 */
	EReference getGotoTarget_Target();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.SentenceObject <em>Sentence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Object</em>'.
	 * @see reprotool.model.linguistic.SentenceObject
	 * @generated
	 */
	EClass getSentenceObject();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.SentenceObject#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see reprotool.model.linguistic.SentenceObject#getObject()
	 * @see #getSentenceObject()
	 * @generated
	 */
	EReference getSentenceObject_Object();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.RepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Representative Object</em>'.
	 * @see reprotool.model.linguistic.RepresentativeObject
	 * @generated
	 */
	EClass getRepresentativeObject();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.IndirectObject <em>Indirect Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indirect Object</em>'.
	 * @see reprotool.model.linguistic.IndirectObject
	 * @generated
	 */
	EClass getIndirectObject();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.Verb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verb</em>'.
	 * @see reprotool.model.linguistic.Verb
	 * @generated
	 */
	EClass getVerb();

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
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.SentencePartImpl <em>Sentence Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.SentencePartImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSentencePart()
		 * @generated
		 */
		EClass SENTENCE_PART = eINSTANCE.getSentencePart();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENTENCE_PART__CONTENT = eINSTANCE.getSentencePart_Content();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.TextImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.SubjectImpl <em>Subject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.SubjectImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSubject()
		 * @generated
		 */
		EClass SUBJECT = eINSTANCE.getSubject();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBJECT__ACTOR = eINSTANCE.getSubject_Actor();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.GotoTargetImpl <em>Goto Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.GotoTargetImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getGotoTarget()
		 * @generated
		 */
		EClass GOTO_TARGET = eINSTANCE.getGotoTarget();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOTO_TARGET__TARGET = eINSTANCE.getGotoTarget_Target();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.SentenceObjectImpl <em>Sentence Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.SentenceObjectImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getSentenceObject()
		 * @generated
		 */
		EClass SENTENCE_OBJECT = eINSTANCE.getSentenceObject();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE_OBJECT__OBJECT = eINSTANCE.getSentenceObject_Object();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.RepresentativeObjectImpl <em>Representative Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.RepresentativeObjectImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getRepresentativeObject()
		 * @generated
		 */
		EClass REPRESENTATIVE_OBJECT = eINSTANCE.getRepresentativeObject();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.IndirectObjectImpl <em>Indirect Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.IndirectObjectImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getIndirectObject()
		 * @generated
		 */
		EClass INDIRECT_OBJECT = eINSTANCE.getIndirectObject();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.impl.VerbImpl <em>Verb</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.impl.VerbImpl
		 * @see reprotool.model.linguistic.impl.LinguisticPackageImpl#getVerb()
		 * @generated
		 */
		EClass VERB = eINSTANCE.getVerb();

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
