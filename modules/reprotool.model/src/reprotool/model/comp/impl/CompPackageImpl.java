/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.comp.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.comp.CompFactory;
import reprotool.model.comp.CompInterface;
import reprotool.model.comp.CompInterfaceType;
import reprotool.model.comp.CompPackage;
import reprotool.model.comp.Component;

import reprotool.model.linguistic.LinguisticPackage;

import reprotool.model.linguistic.impl.LinguisticPackageImpl;

import reprotool.model.specification.SpecificationPackage;

import reprotool.model.specification.impl.SpecificationPackageImpl;

import reprotool.model.structure.ast.AstPackage;

import reprotool.model.structure.ast.impl.AstPackageImpl;

import reprotool.model.structure.doc.DocPackage;

import reprotool.model.structure.doc.impl.DocPackageImpl;

import reprotool.model.traceability.TraceabilityPackage;

import reprotool.model.traceability.impl.TraceabilityPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompPackageImpl extends EPackageImpl implements CompPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compInterfaceTypeEClass = null;

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
	 * @see reprotool.model.comp.CompPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompPackageImpl() {
		super(eNS_URI, CompFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompPackage init() {
		if (isInited) return (CompPackage)EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI);

		// Obtain or create and register package
		CompPackageImpl theCompPackage = (CompPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		DocPackageImpl theDocPackage = (DocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) instanceof DocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) : DocPackage.eINSTANCE);
		LinguisticPackageImpl theLinguisticPackage = (LinguisticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LinguisticPackage.eNS_URI) instanceof LinguisticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LinguisticPackage.eNS_URI) : LinguisticPackage.eINSTANCE);
		SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpecificationPackage.eNS_URI) instanceof SpecificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpecificationPackage.eNS_URI) : SpecificationPackage.eINSTANCE);
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) : TraceabilityPackage.eINSTANCE);

		// Create package meta-data objects
		theCompPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theLinguisticPackage.createPackageContents();
		theSpecificationPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();

		// Initialize created meta-data
		theCompPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theLinguisticPackage.initializePackageContents();
		theSpecificationPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompPackage.eNS_URI, theCompPackage);
		return theCompPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ProvidedInterfaces() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_RequiredInterfaces() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompInterface() {
		return compInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompInterface_InterfaceType() {
		return (EReference)compInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompInterfaceType() {
		return compInterfaceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompInterfaceType_Signature() {
		return (EAttribute)compInterfaceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompFactory getCompFactory() {
		return (CompFactory)getEFactoryInstance();
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
		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__PROVIDED_INTERFACES);
		createEReference(componentEClass, COMPONENT__REQUIRED_INTERFACES);

		compInterfaceEClass = createEClass(COMP_INTERFACE);
		createEReference(compInterfaceEClass, COMP_INTERFACE__INTERFACE_TYPE);

		compInterfaceTypeEClass = createEClass(COMP_INTERFACE_TYPE);
		createEAttribute(compInterfaceTypeEClass, COMP_INTERFACE_TYPE__SIGNATURE);
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
		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_ProvidedInterfaces(), this.getCompInterface(), null, "providedInterfaces", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_RequiredInterfaces(), this.getCompInterface(), null, "requiredInterfaces", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compInterfaceEClass, CompInterface.class, "CompInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompInterface_InterfaceType(), this.getCompInterfaceType(), null, "interfaceType", null, 0, 1, CompInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compInterfaceTypeEClass, CompInterfaceType.class, "CompInterfaceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompInterfaceType_Signature(), ecorePackage.getEString(), "signature", null, 0, 1, CompInterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompPackageImpl
