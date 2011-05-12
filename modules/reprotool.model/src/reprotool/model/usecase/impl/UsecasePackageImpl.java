/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.ast.AstPackage;

import reprotool.model.ast.impl.AstPackageImpl;

import reprotool.model.comp.CompPackage;

import reprotool.model.comp.impl.CompPackageImpl;

import reprotool.model.doc.DocPackage;

import reprotool.model.doc.impl.DocPackageImpl;

import reprotool.model.linguistic.LinguisticPackage;

import reprotool.model.linguistic.impl.LinguisticPackageImpl;

import reprotool.model.lts.LtsPackage;

import reprotool.model.lts.impl.LtsPackageImpl;

import reprotool.model.procases.ProcasesPackage;

import reprotool.model.procases.impl.ProcasesPackageImpl;

import reprotool.model.swproj.SwprojPackage;

import reprotool.model.swproj.impl.SwprojPackageImpl;

import reprotool.model.traceability.TraceabilityPackage;

import reprotool.model.traceability.impl.TraceabilityPackageImpl;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UsecasePackageImpl extends EPackageImpl implements UsecasePackage {
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
	private EClass useCaseStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioEClass = null;

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
	 * @see reprotool.model.usecase.UsecasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UsecasePackageImpl() {
		super(eNS_URI, UsecaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UsecasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UsecasePackage init() {
		if (isInited) return (UsecasePackage)EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI);

		// Obtain or create and register package
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UsecasePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		LtsPackageImpl theLtsPackage = (LtsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) instanceof LtsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) : LtsPackage.eINSTANCE);
		SwprojPackageImpl theSwprojPackage = (SwprojPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) instanceof SwprojPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) : SwprojPackage.eINSTANCE);
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) : TraceabilityPackage.eINSTANCE);
		LinguisticPackageImpl theLinguisticPackage = (LinguisticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LinguisticPackage.eNS_URI) instanceof LinguisticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LinguisticPackage.eNS_URI) : LinguisticPackage.eINSTANCE);
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		CompPackageImpl theCompPackage = (CompPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) instanceof CompPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) : CompPackage.eINSTANCE);
		DocPackageImpl theDocPackage = (DocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) instanceof DocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) : DocPackage.eINSTANCE);
		ProcasesPackageImpl theProcasesPackage = (ProcasesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcasesPackage.eNS_URI) instanceof ProcasesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcasesPackage.eNS_URI) : ProcasesPackage.eINSTANCE);

		// Create package meta-data objects
		theUsecasePackage.createPackageContents();
		theLtsPackage.createPackageContents();
		theSwprojPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();
		theLinguisticPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theCompPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theProcasesPackage.createPackageContents();

		// Initialize created meta-data
		theUsecasePackage.initializePackageContents();
		theLtsPackage.initializePackageContents();
		theSwprojPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();
		theLinguisticPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theCompPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theProcasesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUsecasePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UsecasePackage.eNS_URI, theUsecasePackage);
		return theUsecasePackage;
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
	public EAttribute getUseCase_Name() {
		return (EAttribute)useCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_MainScenario() {
		return (EReference)useCaseEClass.getEStructuralFeatures().get(2);
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
	public EReference getUseCaseStep_Extension() {
		return (EReference)useCaseStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseStep_Variation() {
		return (EReference)useCaseStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCaseStep_Sentence() {
		return (EAttribute)useCaseStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCaseStep_Label() {
		return (EAttribute)useCaseStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseStep_ParsedSentence() {
		return (EReference)useCaseStepEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Steps() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsecaseFactory getUsecaseFactory() {
		return (UsecaseFactory)getEFactoryInstance();
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
		useCaseEClass = createEClass(USE_CASE);
		createEReference(useCaseEClass, USE_CASE__PRIMARY_ACTOR);
		createEAttribute(useCaseEClass, USE_CASE__NAME);
		createEReference(useCaseEClass, USE_CASE__MAIN_SCENARIO);

		useCaseStepEClass = createEClass(USE_CASE_STEP);
		createEReference(useCaseStepEClass, USE_CASE_STEP__EXTENSION);
		createEReference(useCaseStepEClass, USE_CASE_STEP__VARIATION);
		createEAttribute(useCaseStepEClass, USE_CASE_STEP__SENTENCE);
		createEAttribute(useCaseStepEClass, USE_CASE_STEP__LABEL);
		createEReference(useCaseStepEClass, USE_CASE_STEP__PARSED_SENTENCE);

		scenarioEClass = createEClass(SCENARIO);
		createEReference(scenarioEClass, SCENARIO__STEPS);
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
		SwprojPackage theSwprojPackage = (SwprojPackage)EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI);
		TraceabilityPackage theTraceabilityPackage = (TraceabilityPackage)EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI);
		LinguisticPackage theLinguisticPackage = (LinguisticPackage)EPackage.Registry.INSTANCE.getEPackage(LinguisticPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		useCaseEClass.getESuperTypes().add(theSwprojPackage.getReqCover());
		useCaseEClass.getESuperTypes().add(theTraceabilityPackage.getTraceableEntity());
		useCaseStepEClass.getESuperTypes().add(theSwprojPackage.getReqCover());

		// Initialize classes and features; add operations and parameters
		initEClass(useCaseEClass, UseCase.class, "UseCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCase_PrimaryActor(), theSwprojPackage.getActor(), null, "primaryActor", null, 1, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCase_Name(), ecorePackage.getEString(), "Name", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCase_MainScenario(), this.getScenario(), null, "mainScenario", null, 1, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(useCaseStepEClass, UseCaseStep.class, "UseCaseStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCaseStep_Extension(), this.getScenario(), null, "extension", null, 0, -1, UseCaseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseStep_Variation(), this.getScenario(), null, "variation", null, 0, -1, UseCaseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCaseStep_Sentence(), ecorePackage.getEString(), "Sentence", null, 0, 1, UseCaseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCaseStep_Label(), ecorePackage.getEString(), "Label", null, 0, 1, UseCaseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseStep_ParsedSentence(), theLinguisticPackage.getSentenceNode(), null, "parsedSentence", null, 0, 1, UseCaseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_Steps(), this.getUseCaseStep(), null, "steps", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
		addAnnotation
		  (scenarioEClass, 
		   source, 
		   new String[] {
			 "name", "Use Case Scenario"
		   });
	}

} //UsecasePackageImpl
