/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.comp.ICompPackage;

import reprotool.model.comp.impl.CompPackage;

import reprotool.model.linguistic.EWordType;
import reprotool.model.linguistic.ILinguisticFactory;
import reprotool.model.linguistic.ILinguisticPackage;
import reprotool.model.linguistic.ISentenceNode;
import reprotool.model.linguistic.IWord;

import reprotool.model.specification.ISpecificationPackage;

import reprotool.model.specification.impl.SpecificationPackage;

import reprotool.model.structure.ast.IAstPackage;

import reprotool.model.structure.ast.impl.AstPackage;

import reprotool.model.structure.doc.IDocPackage;

import reprotool.model.structure.doc.impl.DocPackage;

import reprotool.model.traceability.ITraceabilityPackage;

import reprotool.model.traceability.impl.TraceabilityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinguisticPackage extends EPackageImpl implements ILinguisticPackage {
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
	 * @see reprotool.model.linguistic.ILinguisticPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LinguisticPackage() {
		super(eNS_URI, ILinguisticFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ILinguisticPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ILinguisticPackage init() {
		if (isInited) return (ILinguisticPackage)EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI);

		// Obtain or create and register package
		LinguisticPackage theLinguisticPackage = (LinguisticPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LinguisticPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LinguisticPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		SpecificationPackage theSpecificationPackage = (SpecificationPackage)(EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) instanceof SpecificationPackage ? EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) : ISpecificationPackage.eINSTANCE);
		DocPackage theDocPackage = (DocPackage)(EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) instanceof DocPackage ? EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) : IDocPackage.eINSTANCE);
		AstPackage theAstPackage = (AstPackage)(EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) : IAstPackage.eINSTANCE);
		CompPackage theCompPackage = (CompPackage)(EPackage.Registry.INSTANCE.getEPackage(ICompPackage.eNS_URI) instanceof CompPackage ? EPackage.Registry.INSTANCE.getEPackage(ICompPackage.eNS_URI) : ICompPackage.eINSTANCE);
		TraceabilityPackage theTraceabilityPackage = (TraceabilityPackage)(EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI) instanceof TraceabilityPackage ? EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI) : ITraceabilityPackage.eINSTANCE);

		// Create package meta-data objects
		theLinguisticPackage.createPackageContents();
		theSpecificationPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theCompPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();

		// Initialize created meta-data
		theLinguisticPackage.initializePackageContents();
		theSpecificationPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theCompPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLinguisticPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ILinguisticPackage.eNS_URI, theLinguisticPackage);
		return theLinguisticPackage;
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
	public EReference getSentenceNode_ChildFragments() {
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
	public EEnum getEWordType() {
		return eWordTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILinguisticFactory getLinguisticFactory() {
		return (ILinguisticFactory)getEFactoryInstance();
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
		createEReference(sentenceNodeEClass, SENTENCE_NODE__CHILD_FRAGMENTS);
		createEAttribute(sentenceNodeEClass, SENTENCE_NODE__TYPE);

		wordEClass = createEClass(WORD);
		createEAttribute(wordEClass, WORD__WORD_STR);
		createEAttribute(wordEClass, WORD__WORD_TYPE);

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
		wordEClass.getESuperTypes().add(this.getSentenceNode());

		// Initialize classes and features; add operations and parameters
		initEClass(sentenceNodeEClass, ISentenceNode.class, "SentenceNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSentenceNode_ChildFragments(), this.getSentenceNode(), null, "childFragments", null, 0, -1, ISentenceNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSentenceNode_Type(), ecorePackage.getEString(), "type", null, 0, 1, ISentenceNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wordEClass, IWord.class, "Word", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWord_WordStr(), ecorePackage.getEString(), "wordStr", null, 0, 1, IWord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWord_WordType(), this.getEWordType(), "wordType", null, 0, 1, IWord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

} //LinguisticPackage
