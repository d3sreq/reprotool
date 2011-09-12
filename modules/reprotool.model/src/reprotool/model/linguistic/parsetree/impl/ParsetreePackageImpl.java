/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.parsetree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.ast.AstPackage;

import reprotool.model.ast.impl.AstPackageImpl;

import reprotool.model.comp.CompPackage;

import reprotool.model.comp.impl.CompPackageImpl;

import reprotool.model.doc.DocPackage;

import reprotool.model.doc.impl.DocPackageImpl;

import reprotool.model.linguistic.action.ActionPackage;

import reprotool.model.linguistic.action.impl.ActionPackageImpl;

import reprotool.model.linguistic.actionpart.ActionpartPackage;

import reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl;

import reprotool.model.linguistic.parsetree.EWordType;
import reprotool.model.linguistic.parsetree.InnerParseNode;
import reprotool.model.linguistic.parsetree.NounPhraseNode;
import reprotool.model.linguistic.parsetree.ParseNode;
import reprotool.model.linguistic.parsetree.ParsetreeFactory;
import reprotool.model.linguistic.parsetree.ParsetreePackage;
import reprotool.model.linguistic.parsetree.PrepositionalPhraseNode;
import reprotool.model.linguistic.parsetree.SentenceNode;
import reprotool.model.linguistic.parsetree.VerbPhraseNode;
import reprotool.model.linguistic.parsetree.Word;

import reprotool.model.lts.LtsPackage;

import reprotool.model.lts.impl.LtsPackageImpl;

import reprotool.model.procases.ProcasesPackage;

import reprotool.model.procases.impl.ProcasesPackageImpl;

import reprotool.model.swproj.SwprojPackage;

import reprotool.model.swproj.impl.SwprojPackageImpl;

import reprotool.model.traceability.TraceabilityPackage;

import reprotool.model.traceability.impl.TraceabilityPackageImpl;

import reprotool.model.usecase.UsecasePackage;

import reprotool.model.usecase.annotate.AnnotatePackage;
import reprotool.model.usecase.annotate.impl.AnnotatePackageImpl;
import reprotool.model.usecase.impl.UsecasePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParsetreePackageImpl extends EPackageImpl implements ParsetreePackage {
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
	private EClass wordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parseNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nounPhraseNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verbPhraseNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prepositionalPhraseNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass innerParseNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eWordTypeEEnum = null;

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
	 * @see reprotool.model.linguistic.parsetree.ParsetreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ParsetreePackageImpl() {
		super(eNS_URI, ParsetreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ParsetreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ParsetreePackage init() {
		if (isInited) return (ParsetreePackage)EPackage.Registry.INSTANCE.getEPackage(ParsetreePackage.eNS_URI);

		// Obtain or create and register package
		ParsetreePackageImpl theParsetreePackage = (ParsetreePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ParsetreePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ParsetreePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		LtsPackageImpl theLtsPackage = (LtsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) instanceof LtsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) : LtsPackage.eINSTANCE);
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI) : UsecasePackage.eINSTANCE);
		AnnotatePackageImpl theAnnotatePackage = (AnnotatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotatePackage.eNS_URI) instanceof AnnotatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotatePackage.eNS_URI) : AnnotatePackage.eINSTANCE);
		SwprojPackageImpl theSwprojPackage = (SwprojPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) instanceof SwprojPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) : SwprojPackage.eINSTANCE);
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) : TraceabilityPackage.eINSTANCE);
		ActionpartPackageImpl theActionpartPackage = (ActionpartPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionpartPackage.eNS_URI) instanceof ActionpartPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionpartPackage.eNS_URI) : ActionpartPackage.eINSTANCE);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI) instanceof ActionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI) : ActionPackage.eINSTANCE);
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		CompPackageImpl theCompPackage = (CompPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) instanceof CompPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) : CompPackage.eINSTANCE);
		DocPackageImpl theDocPackage = (DocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) instanceof DocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) : DocPackage.eINSTANCE);
		ProcasesPackageImpl theProcasesPackage = (ProcasesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcasesPackage.eNS_URI) instanceof ProcasesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcasesPackage.eNS_URI) : ProcasesPackage.eINSTANCE);

		// Create package meta-data objects
		theParsetreePackage.createPackageContents();
		theLtsPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theAnnotatePackage.createPackageContents();
		theSwprojPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();
		theActionpartPackage.createPackageContents();
		theActionPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theCompPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theProcasesPackage.createPackageContents();

		// Initialize created meta-data
		theParsetreePackage.initializePackageContents();
		theLtsPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theAnnotatePackage.initializePackageContents();
		theSwprojPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();
		theActionpartPackage.initializePackageContents();
		theActionPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theCompPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theProcasesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theParsetreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ParsetreePackage.eNS_URI, theParsetreePackage);
		return theParsetreePackage;
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
	public EAttribute getWord_WordType() {
		return (EAttribute)wordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWord_WordPOS() {
		return (EAttribute)wordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParseNode() {
		return parseNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNounPhraseNode() {
		return nounPhraseNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVerbPhraseNode() {
		return verbPhraseNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrepositionalPhraseNode() {
		return prepositionalPhraseNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInnerParseNode() {
		return innerParseNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInnerParseNode_ChildNodes() {
		return (EReference)innerParseNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInnerParseNode_ParentNode() {
		return (EReference)innerParseNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEWordType() {
		return eWordTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsetreeFactory getParsetreeFactory() {
		return (ParsetreeFactory)getEFactoryInstance();
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
		sentenceNodeEClass = createEClass(SENTENCE_NODE);

		wordEClass = createEClass(WORD);
		createEAttribute(wordEClass, WORD__WORD_STR);
		createEAttribute(wordEClass, WORD__WORD_TYPE);
		createEAttribute(wordEClass, WORD__WORD_POS);

		parseNodeEClass = createEClass(PARSE_NODE);

		nounPhraseNodeEClass = createEClass(NOUN_PHRASE_NODE);

		verbPhraseNodeEClass = createEClass(VERB_PHRASE_NODE);

		prepositionalPhraseNodeEClass = createEClass(PREPOSITIONAL_PHRASE_NODE);

		innerParseNodeEClass = createEClass(INNER_PARSE_NODE);
		createEReference(innerParseNodeEClass, INNER_PARSE_NODE__CHILD_NODES);
		createEReference(innerParseNodeEClass, INNER_PARSE_NODE__PARENT_NODE);

		// Create enums
		eWordTypeEEnum = createEEnum(EWORD_TYPE);
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
		sentenceNodeEClass.getESuperTypes().add(this.getInnerParseNode());
		wordEClass.getESuperTypes().add(this.getParseNode());
		nounPhraseNodeEClass.getESuperTypes().add(this.getInnerParseNode());
		verbPhraseNodeEClass.getESuperTypes().add(this.getInnerParseNode());
		prepositionalPhraseNodeEClass.getESuperTypes().add(this.getInnerParseNode());
		innerParseNodeEClass.getESuperTypes().add(this.getParseNode());

		// Initialize classes and features; add operations and parameters
		initEClass(sentenceNodeEClass, SentenceNode.class, "SentenceNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wordEClass, Word.class, "Word", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWord_WordStr(), ecorePackage.getEString(), "wordStr", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWord_WordType(), this.getEWordType(), "wordType", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWord_WordPOS(), ecorePackage.getEString(), "wordPOS", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parseNodeEClass, ParseNode.class, "ParseNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nounPhraseNodeEClass, NounPhraseNode.class, "NounPhraseNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(verbPhraseNodeEClass, VerbPhraseNode.class, "VerbPhraseNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(prepositionalPhraseNodeEClass, PrepositionalPhraseNode.class, "PrepositionalPhraseNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(innerParseNodeEClass, InnerParseNode.class, "InnerParseNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInnerParseNode_ChildNodes(), this.getParseNode(), null, "childNodes", null, 0, -1, InnerParseNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInnerParseNode_ParentNode(), this.getInnerParseNode(), null, "parentNode", null, 0, 1, InnerParseNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eWordTypeEEnum, EWordType.class, "EWordType");
		addEEnumLiteral(eWordTypeEEnum, EWordType.NOT_IMPORTANT);
		addEEnumLiteral(eWordTypeEEnum, EWordType.SUBJECT);
		addEEnumLiteral(eWordTypeEEnum, EWordType.INDIRECT_OBJECT);
		addEEnumLiteral(eWordTypeEEnum, EWordType.VERB);
		addEEnumLiteral(eWordTypeEEnum, EWordType.REPRESENTATIVE_OBJECT);
		addEEnumLiteral(eWordTypeEEnum, EWordType.GOTO_TARGET);
		addEEnumLiteral(eWordTypeEEnum, EWordType.CONDITION_LABEL);

		// Create resource
		createResource(eNS_URI);
	}

} //ParsetreePackageImpl
