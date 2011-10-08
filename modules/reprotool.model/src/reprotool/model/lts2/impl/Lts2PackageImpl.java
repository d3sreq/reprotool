/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts2.impl;

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

import reprotool.model.linguistic.action.ActionPackage;

import reprotool.model.linguistic.action.impl.ActionPackageImpl;

import reprotool.model.linguistic.actionpart.ActionpartPackage;

import reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl;

import reprotool.model.lts.LtsPackage;

import reprotool.model.lts.impl.LtsPackageImpl;

import reprotool.model.lts2.AbortState;
import reprotool.model.lts2.FinalState;
import reprotool.model.lts2.InitialState;
import reprotool.model.lts2.Lts2Factory;
import reprotool.model.lts2.Lts2Package;
import reprotool.model.lts2.State;
import reprotool.model.lts2.StateMachine;
import reprotool.model.lts2.Transition;
import reprotool.model.lts2.TransitionalState;

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
public class Lts2PackageImpl extends EPackageImpl implements Lts2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finalStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionalStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abortStateEClass = null;

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
	 * @see reprotool.model.lts2.Lts2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Lts2PackageImpl() {
		super(eNS_URI, Lts2Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Lts2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Lts2Package init() {
		if (isInited) return (Lts2Package)EPackage.Registry.INSTANCE.getEPackage(Lts2Package.eNS_URI);

		// Obtain or create and register package
		Lts2PackageImpl theLts2Package = (Lts2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Lts2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Lts2PackageImpl());

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

		// Create package meta-data objects
		theLts2Package.createPackageContents();
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

		// Initialize created meta-data
		theLts2Package.initializePackageContents();
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

		// Mark meta-data to indicate it can't be changed
		theLts2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Lts2Package.eNS_URI, theLts2Package);
		return theLts2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMachine() {
		return stateMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_InitialState() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_TransitionalStates() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_FinalState() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitialState() {
		return initialStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinalState() {
		return finalStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionalState() {
		return transitionalStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionalState_Transitions() {
		return (EReference)transitionalStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_TargetState() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_RelatedStep() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbortState() {
		return abortStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lts2Factory getLts2Factory() {
		return (Lts2Factory)getEFactoryInstance();
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
		stateMachineEClass = createEClass(STATE_MACHINE);
		createEReference(stateMachineEClass, STATE_MACHINE__INITIAL_STATE);
		createEReference(stateMachineEClass, STATE_MACHINE__TRANSITIONAL_STATES);
		createEReference(stateMachineEClass, STATE_MACHINE__FINAL_STATE);

		initialStateEClass = createEClass(INITIAL_STATE);

		finalStateEClass = createEClass(FINAL_STATE);

		stateEClass = createEClass(STATE);

		transitionalStateEClass = createEClass(TRANSITIONAL_STATE);
		createEReference(transitionalStateEClass, TRANSITIONAL_STATE__TRANSITIONS);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__TARGET_STATE);
		createEReference(transitionEClass, TRANSITION__RELATED_STEP);

		abortStateEClass = createEClass(ABORT_STATE);
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
		UsecasePackage theUsecasePackage = (UsecasePackage)EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		initialStateEClass.getESuperTypes().add(this.getTransitionalState());
		finalStateEClass.getESuperTypes().add(this.getState());
		transitionalStateEClass.getESuperTypes().add(this.getState());
		abortStateEClass.getESuperTypes().add(this.getFinalState());

		// Initialize classes and features; add operations and parameters
		initEClass(stateMachineEClass, StateMachine.class, "StateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachine_InitialState(), this.getInitialState(), null, "initialState", null, 1, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_TransitionalStates(), this.getTransitionalState(), null, "transitionalStates", null, 0, -1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_FinalState(), this.getFinalState(), null, "finalState", null, 1, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initialStateEClass, InitialState.class, "InitialState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(finalStateEClass, FinalState.class, "FinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateEClass, State.class, "State", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transitionalStateEClass, TransitionalState.class, "TransitionalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionalState_Transitions(), this.getTransition(), null, "transitions", null, 1, -1, TransitionalState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_TargetState(), this.getState(), null, "targetState", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_RelatedStep(), theUsecasePackage.getUseCaseStep(), null, "relatedStep", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abortStateEClass, AbortState.class, "AbortState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Lts2PackageImpl
