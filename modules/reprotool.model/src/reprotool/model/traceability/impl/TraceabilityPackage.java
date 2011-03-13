/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.traceability.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.comp.ICompPackage;

import reprotool.model.comp.impl.CompPackage;

import reprotool.model.linguistic.ILinguisticPackage;

import reprotool.model.linguistic.impl.LinguisticPackage;

import reprotool.model.specification.ISpecificationPackage;

import reprotool.model.specification.impl.SpecificationPackage;

import reprotool.model.structure.ast.IAstPackage;

import reprotool.model.structure.ast.impl.AstPackage;

import reprotool.model.structure.doc.IDocPackage;

import reprotool.model.structure.doc.impl.DocPackage;

import reprotool.model.traceability.ITraceLink;
import reprotool.model.traceability.ITraceabilityFactory;
import reprotool.model.traceability.ITraceabilityPackage;
import reprotool.model.traceability.ITraceableEntity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceabilityPackage extends EPackageImpl implements ITraceabilityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceableEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceLinkEClass = null;

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
	 * @see reprotool.model.traceability.ITraceabilityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TraceabilityPackage() {
		super(eNS_URI, ITraceabilityFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ITraceabilityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ITraceabilityPackage init() {
		if (isInited) return (ITraceabilityPackage)EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI);

		// Obtain or create and register package
		TraceabilityPackage theTraceabilityPackage = (TraceabilityPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TraceabilityPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TraceabilityPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		LinguisticPackage theLinguisticPackage = (LinguisticPackage)(EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) instanceof LinguisticPackage ? EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) : ILinguisticPackage.eINSTANCE);
		SpecificationPackage theSpecificationPackage = (SpecificationPackage)(EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) instanceof SpecificationPackage ? EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) : ISpecificationPackage.eINSTANCE);
		DocPackage theDocPackage = (DocPackage)(EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) instanceof DocPackage ? EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) : IDocPackage.eINSTANCE);
		AstPackage theAstPackage = (AstPackage)(EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) : IAstPackage.eINSTANCE);
		CompPackage theCompPackage = (CompPackage)(EPackage.Registry.INSTANCE.getEPackage(ICompPackage.eNS_URI) instanceof CompPackage ? EPackage.Registry.INSTANCE.getEPackage(ICompPackage.eNS_URI) : ICompPackage.eINSTANCE);

		// Create package meta-data objects
		theTraceabilityPackage.createPackageContents();
		theLinguisticPackage.createPackageContents();
		theSpecificationPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theCompPackage.createPackageContents();

		// Initialize created meta-data
		theTraceabilityPackage.initializePackageContents();
		theLinguisticPackage.initializePackageContents();
		theSpecificationPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theCompPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTraceabilityPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ITraceabilityPackage.eNS_URI, theTraceabilityPackage);
		return theTraceabilityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceableEntity() {
		return traceableEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceLink() {
		return traceLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceLink_Source() {
		return (EReference)traceLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceLink_Target() {
		return (EReference)traceLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITraceabilityFactory getTraceabilityFactory() {
		return (ITraceabilityFactory)getEFactoryInstance();
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
		traceableEntityEClass = createEClass(TRACEABLE_ENTITY);

		traceLinkEClass = createEClass(TRACE_LINK);
		createEReference(traceLinkEClass, TRACE_LINK__SOURCE);
		createEReference(traceLinkEClass, TRACE_LINK__TARGET);
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
		initEClass(traceableEntityEClass, ITraceableEntity.class, "TraceableEntity", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(traceLinkEClass, ITraceLink.class, "TraceLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceLink_Source(), this.getTraceableEntity(), null, "source", null, 1, -1, ITraceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTraceLink_Target(), this.getTraceableEntity(), null, "target", null, 1, -1, ITraceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TraceabilityPackage
