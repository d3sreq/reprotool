/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.structure.doc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.linguistic.ILinguisticPackage;

import reprotool.model.linguistic.impl.LinguisticPackage;

import reprotool.model.specification.ISpecificationPackage;

import reprotool.model.specification.impl.SpecificationPackage;

import reprotool.model.structure.ast.IAstPackage;

import reprotool.model.structure.ast.impl.AstPackage;

import reprotool.model.structure.doc.IDocFactory;
import reprotool.model.structure.doc.IDocPackage;
import reprotool.model.structure.doc.IDocument;
import reprotool.model.structure.doc.IParagraph;
import reprotool.model.structure.doc.ISection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DocPackage extends EPackageImpl implements IDocPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paragraphEClass = null;

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
	 * @see reprotool.model.structure.doc.IDocPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DocPackage() {
		super(eNS_URI, IDocFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link IDocPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IDocPackage init() {
		if (isInited) return (IDocPackage)EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI);

		// Obtain or create and register package
		DocPackage theDocPackage = (DocPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DocPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DocPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		LinguisticPackage theLinguisticPackage = (LinguisticPackage)(EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) instanceof LinguisticPackage ? EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) : ILinguisticPackage.eINSTANCE);
		SpecificationPackage theSpecificationPackage = (SpecificationPackage)(EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) instanceof SpecificationPackage ? EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) : ISpecificationPackage.eINSTANCE);
		AstPackage theAstPackage = (AstPackage)(EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) : IAstPackage.eINSTANCE);

		// Create package meta-data objects
		theDocPackage.createPackageContents();
		theLinguisticPackage.createPackageContents();
		theSpecificationPackage.createPackageContents();
		theAstPackage.createPackageContents();

		// Initialize created meta-data
		theDocPackage.initializePackageContents();
		theLinguisticPackage.initializePackageContents();
		theSpecificationPackage.initializePackageContents();
		theAstPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDocPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IDocPackage.eNS_URI, theDocPackage);
		return theDocPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocument() {
		return documentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocument_Sections() {
		return (EReference)documentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSection() {
		return sectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_Paragraphs() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParagraph() {
		return paragraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDocFactory getDocFactory() {
		return (IDocFactory)getEFactoryInstance();
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
		documentEClass = createEClass(DOCUMENT);
		createEReference(documentEClass, DOCUMENT__SECTIONS);

		sectionEClass = createEClass(SECTION);
		createEReference(sectionEClass, SECTION__PARAGRAPHS);

		paragraphEClass = createEClass(PARAGRAPH);
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
		initEClass(documentEClass, IDocument.class, "Document", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocument_Sections(), this.getSection(), null, "sections", null, 0, -1, IDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sectionEClass, ISection.class, "Section", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSection_Paragraphs(), this.getParagraph(), null, "paragraphs", null, 0, -1, ISection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paragraphEClass, IParagraph.class, "Paragraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DocPackage
