/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.doc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.ast.AstPackage;

import reprotool.model.ast.impl.AstPackageImpl;

import reprotool.model.comp.CompPackage;

import reprotool.model.comp.impl.CompPackageImpl;

import reprotool.model.doc.DocFactory;
import reprotool.model.doc.DocPackage;
import reprotool.model.doc.Document;
import reprotool.model.doc.Paragraph;
import reprotool.model.doc.Section;

import reprotool.model.linguistic.action.ActionPackage;

import reprotool.model.linguistic.action.impl.ActionPackageImpl;

import reprotool.model.linguistic.actionpart.ActionpartPackage;

import reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl;

import reprotool.model.lts.LtsPackage;

import reprotool.model.lts.impl.LtsPackageImpl;

import reprotool.model.lts2.Lts2Package;
import reprotool.model.lts2.impl.Lts2PackageImpl;
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
public class DocPackageImpl extends EPackageImpl implements DocPackage {
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
	 * @see reprotool.model.doc.DocPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DocPackageImpl() {
		super(eNS_URI, DocFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DocPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DocPackage init() {
		if (isInited) return (DocPackage)EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI);

		// Obtain or create and register package
		DocPackageImpl theDocPackage = (DocPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DocPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DocPackageImpl());

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
		Lts2PackageImpl theLts2Package = (Lts2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Lts2Package.eNS_URI) instanceof Lts2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Lts2Package.eNS_URI) : Lts2Package.eINSTANCE);

		// Create package meta-data objects
		theDocPackage.createPackageContents();
		theLtsPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theAnnotatePackage.createPackageContents();
		theSwprojPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();
		theActionpartPackage.createPackageContents();
		theActionPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theCompPackage.createPackageContents();
		theLts2Package.createPackageContents();

		// Initialize created meta-data
		theDocPackage.initializePackageContents();
		theLtsPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theAnnotatePackage.initializePackageContents();
		theSwprojPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();
		theActionpartPackage.initializePackageContents();
		theActionPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theCompPackage.initializePackageContents();
		theLts2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDocPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DocPackage.eNS_URI, theDocPackage);
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
	public DocFactory getDocFactory() {
		return (DocFactory)getEFactoryInstance();
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

		// Obtain other dependent packages
		TraceabilityPackage theTraceabilityPackage = (TraceabilityPackage)EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		paragraphEClass.getESuperTypes().add(theTraceabilityPackage.getTraceableEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(documentEClass, Document.class, "Document", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocument_Sections(), this.getSection(), null, "sections", null, 0, -1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sectionEClass, Section.class, "Section", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSection_Paragraphs(), this.getParagraph(), null, "paragraphs", null, 0, -1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paragraphEClass, Paragraph.class, "Paragraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DocPackageImpl
