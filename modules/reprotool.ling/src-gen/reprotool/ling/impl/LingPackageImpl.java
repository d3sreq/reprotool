/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.ling.LingFactory;
import reprotool.ling.LingPackage;
import reprotool.ling.Node;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.SentenceType;
import reprotool.ling.Word;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LingPackageImpl extends EPackageImpl implements LingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sentenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sentenceNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sentenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nodeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see reprotool.ling.LingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LingPackageImpl() {
		super(eNS_URI, LingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link LingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LingPackage init() {
		if (isInited) return (LingPackage)EPackage.Registry.INSTANCE.getEPackage(LingPackage.eNS_URI);

		// Obtain or create and register package
		LingPackageImpl theLingPackage = (LingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LingPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theLingPackage.createPackageContents();

		// Initialize created meta-data
		theLingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LingPackage.eNS_URI, theLingPackage);
		return theLingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSentence() {
		return sentenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSentence_Words() {
		return (EReference)sentenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSentence_EReference0() {
		return (EReference)sentenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSentence_SentenceTree() {
		return (EReference)sentenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWord() {
		return wordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWord_WordStr() {
		return (EAttribute)wordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWord_Text() {
		return (EAttribute)wordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWord_Lemma() {
		return (EAttribute)wordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWord_POS() {
		return (EAttribute)wordEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWord_ID() {
		return (EAttribute)wordEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSentenceNode() {
		return sentenceNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSentenceNode_Children() {
		return (EReference)sentenceNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSentenceNode_Type() {
		return (EAttribute)sentenceNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSentenceNode_Word() {
		return (EReference)sentenceNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSentenceNode_Parent() {
		return (EReference)sentenceNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSentenceType() {
		return sentenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNode() {
		return nodeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LingFactory getLingFactory() {
		return (LingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sentenceEClass = createEClass(SENTENCE);
		createEReference(sentenceEClass, SENTENCE__WORDS);
		createEReference(sentenceEClass, SENTENCE__EREFERENCE0);
		createEReference(sentenceEClass, SENTENCE__SENTENCE_TREE);

		wordEClass = createEClass(WORD);
		createEAttribute(wordEClass, WORD__WORD_STR);
		createEAttribute(wordEClass, WORD__TEXT);
		createEAttribute(wordEClass, WORD__LEMMA);
		createEAttribute(wordEClass, WORD__POS);
		createEAttribute(wordEClass, WORD__ID);

		sentenceNodeEClass = createEClass(SENTENCE_NODE);
		createEReference(sentenceNodeEClass, SENTENCE_NODE__CHILDREN);
		createEAttribute(sentenceNodeEClass, SENTENCE_NODE__TYPE);
		createEReference(sentenceNodeEClass, SENTENCE_NODE__WORD);
		createEReference(sentenceNodeEClass, SENTENCE_NODE__PARENT);

		// Create enums
		sentenceTypeEEnum = createEEnum(SENTENCE_TYPE);
		nodeEEnum = createEEnum(NODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(sentenceEClass, Sentence.class, "Sentence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSentence_Words(), this.getWord(), null, "words", null, 0, -1, Sentence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSentence_EReference0(), this.getSentenceNode(), null, "EReference0", null, 0, 1, Sentence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSentence_SentenceTree(), this.getSentenceNode(), null, "sentenceTree", null, 0, 1, Sentence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sentenceEClass, null, "parseString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "inputString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sentenceEClass, this.getSentence(), "getNegatedString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(wordEClass, Word.class, "Word", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWord_WordStr(), ecorePackage.getEString(), "wordStr", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWord_Text(), ecorePackage.getEString(), "text", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWord_Lemma(), ecorePackage.getEString(), "lemma", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWord_POS(), ecorePackage.getEString(), "POS", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWord_ID(), ecorePackage.getEInt(), "ID", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sentenceNodeEClass, SentenceNode.class, "SentenceNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSentenceNode_Children(), this.getSentenceNode(), null, "children", null, 0, -1, SentenceNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSentenceNode_Type(), this.getSentenceType(), "type", null, 0, 1, SentenceNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSentenceNode_Word(), this.getWord(), null, "word", null, 0, 1, SentenceNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSentenceNode_Parent(), this.getSentenceNode(), null, "parent", null, 0, 1, SentenceNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sentenceTypeEEnum, SentenceType.class, "SentenceType");
		addEEnumLiteral(sentenceTypeEEnum, SentenceType.NOUN_PHRASE);
		addEEnumLiteral(sentenceTypeEEnum, SentenceType.VERB_PHRASE);
		addEEnumLiteral(sentenceTypeEEnum, SentenceType.PREPOSITION_PHRASE);
		addEEnumLiteral(sentenceTypeEEnum, SentenceType.UNDEFINED);
		addEEnumLiteral(sentenceTypeEEnum, SentenceType.SENTENCE_PHRASE);

		initEEnum(nodeEEnum, Node.class, "Node");
		addEEnumLiteral(nodeEEnum, Node.NP);
		addEEnumLiteral(nodeEEnum, Node.VP);
		addEEnumLiteral(nodeEEnum, Node.PP);
		addEEnumLiteral(nodeEEnum, Node.FRAG);
		addEEnumLiteral(nodeEEnum, Node.X);

		// Create resource
		createResource(eNS_URI);
	}

} //LingPackageImpl
