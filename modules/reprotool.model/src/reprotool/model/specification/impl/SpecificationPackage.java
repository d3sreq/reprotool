/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.comp.ICompPackage;

import reprotool.model.comp.impl.CompPackage;

import reprotool.model.linguistic.ILinguisticPackage;

import reprotool.model.linguistic.impl.LinguisticPackage;

import reprotool.model.specification.IActor;
import reprotool.model.specification.IGenericRequirement;
import reprotool.model.specification.INonFunctionalRequirement;
import reprotool.model.specification.ISoftwareProject;
import reprotool.model.specification.ISpecificationFactory;
import reprotool.model.specification.ISpecificationPackage;
import reprotool.model.specification.IUseCase;
import reprotool.model.specification.IUseCaseStep;

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
public class SpecificationPackage extends EPackageImpl implements ISpecificationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonFunctionalRequirementEClass = null;

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
	 * @see reprotool.model.specification.ISpecificationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpecificationPackage() {
		super(eNS_URI, ISpecificationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ISpecificationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ISpecificationPackage init() {
		if (isInited) return (ISpecificationPackage)EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI);

		// Obtain or create and register package
		SpecificationPackage theSpecificationPackage = (SpecificationPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SpecificationPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SpecificationPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		LinguisticPackage theLinguisticPackage = (LinguisticPackage)(EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) instanceof LinguisticPackage ? EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) : ILinguisticPackage.eINSTANCE);
		DocPackage theDocPackage = (DocPackage)(EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) instanceof DocPackage ? EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) : IDocPackage.eINSTANCE);
		AstPackage theAstPackage = (AstPackage)(EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI) : IAstPackage.eINSTANCE);
		CompPackage theCompPackage = (CompPackage)(EPackage.Registry.INSTANCE.getEPackage(ICompPackage.eNS_URI) instanceof CompPackage ? EPackage.Registry.INSTANCE.getEPackage(ICompPackage.eNS_URI) : ICompPackage.eINSTANCE);
		TraceabilityPackage theTraceabilityPackage = (TraceabilityPackage)(EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI) instanceof TraceabilityPackage ? EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI) : ITraceabilityPackage.eINSTANCE);

		// Create package meta-data objects
		theSpecificationPackage.createPackageContents();
		theLinguisticPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theCompPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();

		// Initialize created meta-data
		theSpecificationPackage.initializePackageContents();
		theLinguisticPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theCompPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpecificationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ISpecificationPackage.eNS_URI, theSpecificationPackage);
		return theSpecificationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareProject() {
		return softwareProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftwareProject_UseCases() {
		return (EReference)softwareProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftwareProject_Actors() {
		return (EReference)softwareProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareProject_Name() {
		return (EAttribute)softwareProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoftwareProject_Description() {
		return (EAttribute)softwareProjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCase() {
		return useCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_PrimaryActor() {
		return (EReference)useCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_UseCaseSteps() {
		return (EReference)useCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCase_Name() {
		return (EAttribute)useCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_ChildrenActors() {
		return (EReference)actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Parent() {
		return (EReference)actorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActor_Name() {
		return (EAttribute)actorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCaseStep() {
		return useCaseStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericRequirement() {
		return genericRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonFunctionalRequirement() {
		return nonFunctionalRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISpecificationFactory getSpecificationFactory() {
		return (ISpecificationFactory)getEFactoryInstance();
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
		softwareProjectEClass = createEClass(SOFTWARE_PROJECT);
		createEReference(softwareProjectEClass, SOFTWARE_PROJECT__USE_CASES);
		createEReference(softwareProjectEClass, SOFTWARE_PROJECT__ACTORS);
		createEAttribute(softwareProjectEClass, SOFTWARE_PROJECT__NAME);
		createEAttribute(softwareProjectEClass, SOFTWARE_PROJECT__DESCRIPTION);

		useCaseEClass = createEClass(USE_CASE);
		createEReference(useCaseEClass, USE_CASE__PRIMARY_ACTOR);
		createEReference(useCaseEClass, USE_CASE__USE_CASE_STEPS);
		createEAttribute(useCaseEClass, USE_CASE__NAME);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__CHILDREN_ACTORS);
		createEReference(actorEClass, ACTOR__PARENT);
		createEAttribute(actorEClass, ACTOR__NAME);

		useCaseStepEClass = createEClass(USE_CASE_STEP);

		genericRequirementEClass = createEClass(GENERIC_REQUIREMENT);

		nonFunctionalRequirementEClass = createEClass(NON_FUNCTIONAL_REQUIREMENT);
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
		ITraceabilityPackage theTraceabilityPackage = (ITraceabilityPackage)EPackage.Registry.INSTANCE.getEPackage(ITraceabilityPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		useCaseEClass.getESuperTypes().add(this.getGenericRequirement());
		genericRequirementEClass.getESuperTypes().add(theTraceabilityPackage.getTraceableEntity());
		nonFunctionalRequirementEClass.getESuperTypes().add(this.getGenericRequirement());

		// Initialize classes and features; add operations and parameters
		initEClass(softwareProjectEClass, ISoftwareProject.class, "SoftwareProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSoftwareProject_UseCases(), this.getUseCase(), null, "useCases", null, 0, -1, ISoftwareProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSoftwareProject_Actors(), this.getActor(), null, "actors", null, 0, -1, ISoftwareProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoftwareProject_Name(), ecorePackage.getEString(), "Name", null, 0, 1, ISoftwareProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoftwareProject_Description(), ecorePackage.getEString(), "Description", null, 0, 1, ISoftwareProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(useCaseEClass, IUseCase.class, "UseCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCase_PrimaryActor(), this.getActor(), null, "primaryActor", null, 1, 1, IUseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCase_UseCaseSteps(), this.getUseCaseStep(), null, "useCaseSteps", null, 0, -1, IUseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCase_Name(), ecorePackage.getEString(), "Name", null, 0, 1, IUseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorEClass, IActor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_ChildrenActors(), this.getActor(), this.getActor_Parent(), "childrenActors", null, 0, -1, IActor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_Parent(), this.getActor(), this.getActor_ChildrenActors(), "parent", null, 0, 1, IActor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActor_Name(), ecorePackage.getEString(), "Name", null, 0, 1, IActor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(useCaseStepEClass, IUseCaseStep.class, "UseCaseStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(genericRequirementEClass, IGenericRequirement.class, "GenericRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nonFunctionalRequirementEClass, INonFunctionalRequirement.class, "NonFunctionalRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SpecificationPackage
