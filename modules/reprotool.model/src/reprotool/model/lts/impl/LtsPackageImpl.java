/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts.impl;

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

import reprotool.model.linguistic.action.ActionPackage;

import reprotool.model.linguistic.action.impl.ActionPackageImpl;

import reprotool.model.linguistic.actionpart.ActionpartPackage;

import reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl;

import reprotool.model.lts.ActionTransition;
import reprotool.model.lts.LtsFactory;
import reprotool.model.lts.LtsPackage;
import reprotool.model.lts.State;
import reprotool.model.lts.StateMachine;
import reprotool.model.lts.Transition;

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
public class LtsPackageImpl extends EPackageImpl implements LtsPackage {
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
	private EClass stateEClass = null;

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
	private EClass actionTransitionEClass = null;

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
	 * @see reprotool.model.lts.LtsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LtsPackageImpl() {
		super(eNS_URI, LtsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LtsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LtsPackage init() {
		if (isInited) return (LtsPackage)EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI);

		// Obtain or create and register package
		LtsPackageImpl theLtsPackage = (LtsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LtsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LtsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI) : UsecasePackage.eINSTANCE);
		AnnotatePackageImpl theAnnotatePackage = (AnnotatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotatePackage.eNS_URI) instanceof AnnotatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotatePackage.eNS_URI) : AnnotatePackage.eINSTANCE);
		SwprojPackageImpl theSwprojPackage = (SwprojPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) instanceof SwprojPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) : SwprojPackage.eINSTANCE);
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) : TraceabilityPackage.eINSTANCE);
		ActionpartPackageImpl theActionpartPackage = (ActionpartPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionpartPackage.eNS_URI) instanceof ActionpartPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionpartPackage.eNS_URI) : ActionpartPackage.eINSTANCE);
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI) instanceof ActionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI) : ActionPackage.eINSTANCE);
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		CompPackageImpl theCompPackage = (CompPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) instanceof CompPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) : CompPackage.eINSTANCE);
		DocPackageImpl theDocPackage = (DocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) instanceof DocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) : DocPackage.eINSTANCE);
		Lts2PackageImpl theLts2Package = (Lts2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Lts2Package.eNS_URI) instanceof Lts2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Lts2Package.eNS_URI) : Lts2Package.eINSTANCE);

		// Create package meta-data objects
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
		theLts2Package.createPackageContents();

		// Initialize created meta-data
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
		theLts2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLtsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LtsPackage.eNS_URI, theLtsPackage);
		return theLtsPackage;
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
	public EReference getTransition_Sentence() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Source() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Target() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransition_Tokens() {
		return (EAttribute)transitionEClass.getEStructuralFeatures().get(3);
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
	public EReference getStateMachine_AbortState() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_SuccessState() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_AllTransitions() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_AllStates() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionTransition() {
		return actionTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtsFactory getLtsFactory() {
		return (LtsFactory)getEFactoryInstance();
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
		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__SENTENCE);
		createEReference(transitionEClass, TRANSITION__SOURCE);
		createEReference(transitionEClass, TRANSITION__TARGET);
		createEAttribute(transitionEClass, TRANSITION__TOKENS);

		stateEClass = createEClass(STATE);

		stateMachineEClass = createEClass(STATE_MACHINE);
		createEReference(stateMachineEClass, STATE_MACHINE__INITIAL_STATE);
		createEReference(stateMachineEClass, STATE_MACHINE__ABORT_STATE);
		createEReference(stateMachineEClass, STATE_MACHINE__SUCCESS_STATE);
		createEReference(stateMachineEClass, STATE_MACHINE__ALL_TRANSITIONS);
		createEReference(stateMachineEClass, STATE_MACHINE__ALL_STATES);

		actionTransitionEClass = createEClass(ACTION_TRANSITION);
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
		actionTransitionEClass.getESuperTypes().add(this.getTransition());

		// Initialize classes and features; add operations and parameters
		initEClass(transitionEClass, Transition.class, "Transition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_Sentence(), theUsecasePackage.getParseableElement(), null, "sentence", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Source(), this.getState(), null, "source", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Target(), this.getState(), null, "target", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransition_Tokens(), ecorePackage.getEString(), "tokens", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateMachineEClass, StateMachine.class, "StateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachine_InitialState(), this.getState(), null, "initialState", null, 1, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_AbortState(), this.getState(), null, "abortState", null, 0, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_SuccessState(), this.getState(), null, "successState", null, 1, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_AllTransitions(), this.getTransition(), null, "allTransitions", null, 0, -1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_AllStates(), this.getState(), null, "allStates", null, 0, -1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionTransitionEClass, ActionTransition.class, "ActionTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //LtsPackageImpl
