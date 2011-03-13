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

import reprotool.model.comp.ICompFactory;
import reprotool.model.comp.ICompInterface;
import reprotool.model.comp.ICompInterfaceType;
import reprotool.model.comp.ICompPackage;
import reprotool.model.comp.IComponent;

import reprotool.model.linguistic.ILinguisticPackage;

import reprotool.model.linguistic.impl.LinguisticPackage;

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
public class CompPackage extends EPackageImpl implements ICompPackage {
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
	 * @see reprotool.model.comp.ICompPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompPackage() {
		super(eNS_URI, ICompFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ICompPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ICompPackage init() {
		if (isInited) return (ICompPackage)EPackage.Registry.INSTANCE.getEPackage(ICompPackage.eNS_URI);

		// Obtain or create and register package
		CompPackage theCompPackage = (CompPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		LinguisticPackage theLinguisticPackage = (LinguisticPackage)(EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) instanceof LinguisticPackage ? EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) : ILinguisticPackage.eINSTANCE);
		SpecificationPackage theSpecificationPackage = (SpecificationPackage)(EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) instanceof SpecificationPackage ? EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) : ISpecificationPackage.eINSTANCE);
		DocPackage theDocPackage = (DocPackage)(EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) instanceof DocPackage ? EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) : IDocPackage.eINSTANCE);
		AstPackage theAstPackage = (AstPackage)(EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) : IAstPackage.eINSTANCE);
		TraceabilityPackage theTraceabilityPackage = (TraceabilityPackage)(EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI) instanceof TraceabilityPackage ? EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI) : ITraceabilityPackage.eINSTANCE);

		// Create package meta-data objects
		theCompPackage.createPackageContents();
		theLinguisticPackage.createPackageContents();
		theSpecificationPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();

		// Initialize created meta-data
		theCompPackage.initializePackageContents();
		theLinguisticPackage.initializePackageContents();
		theSpecificationPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ICompPackage.eNS_URI, theCompPackage);
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
	public ICompFactory getCompFactory() {
		return (ICompFactory)getEFactoryInstance();
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
		initEClass(componentEClass, IComponent.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_ProvidedInterfaces(), this.getCompInterface(), null, "providedInterfaces", null, 0, -1, IComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_RequiredInterfaces(), this.getCompInterface(), null, "requiredInterfaces", null, 0, -1, IComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compInterfaceEClass, ICompInterface.class, "CompInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompInterface_InterfaceType(), this.getCompInterfaceType(), null, "interfaceType", null, 0, 1, ICompInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compInterfaceTypeEClass, ICompInterfaceType.class, "CompInterfaceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompInterfaceType_Signature(), ecorePackage.getEString(), "signature", null, 0, 1, ICompInterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompPackage
