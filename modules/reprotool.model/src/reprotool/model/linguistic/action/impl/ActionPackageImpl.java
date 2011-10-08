/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action.impl;

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

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.ActionFactory;
import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.Communication;
import reprotool.model.linguistic.action.FromSystem;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.Internal;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.action.Unknown;
import reprotool.model.linguistic.action.UseCaseInclude;

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
public class ActionPackageImpl extends EPackageImpl implements ActionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gotoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseIncludeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abortUseCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationEClass = null;

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
	 * @see reprotool.model.linguistic.action.ActionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActionPackageImpl() {
		super(eNS_URI, ActionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ActionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActionPackage init() {
		if (isInited) return (ActionPackage)EPackage.Registry.INSTANCE.getEPackage(ActionPackage.eNS_URI);

		// Obtain or create and register package
		ActionPackageImpl theActionPackage = (ActionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActionPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		LtsPackageImpl theLtsPackage = (LtsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) instanceof LtsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) : LtsPackage.eINSTANCE);
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI) : UsecasePackage.eINSTANCE);
		AnnotatePackageImpl theAnnotatePackage = (AnnotatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotatePackage.eNS_URI) instanceof AnnotatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotatePackage.eNS_URI) : AnnotatePackage.eINSTANCE);
		SwprojPackageImpl theSwprojPackage = (SwprojPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) instanceof SwprojPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SwprojPackage.eNS_URI) : SwprojPackage.eINSTANCE);
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) : TraceabilityPackage.eINSTANCE);
		ActionpartPackageImpl theActionpartPackage = (ActionpartPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionpartPackage.eNS_URI) instanceof ActionpartPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionpartPackage.eNS_URI) : ActionpartPackage.eINSTANCE);
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		CompPackageImpl theCompPackage = (CompPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) instanceof CompPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompPackage.eNS_URI) : CompPackage.eINSTANCE);
		DocPackageImpl theDocPackage = (DocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) instanceof DocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DocPackage.eNS_URI) : DocPackage.eINSTANCE);
		Lts2PackageImpl theLts2Package = (Lts2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Lts2Package.eNS_URI) instanceof Lts2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Lts2Package.eNS_URI) : Lts2Package.eINSTANCE);

		// Create package meta-data objects
		theActionPackage.createPackageContents();
		theLtsPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theAnnotatePackage.createPackageContents();
		theSwprojPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();
		theActionpartPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theCompPackage.createPackageContents();
		theDocPackage.createPackageContents();
		theLts2Package.createPackageContents();

		// Initialize created meta-data
		theActionPackage.initializePackageContents();
		theLtsPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theAnnotatePackage.initializePackageContents();
		theSwprojPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();
		theActionpartPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theCompPackage.initializePackageContents();
		theDocPackage.initializePackageContents();
		theLts2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActionPackage.eNS_URI, theActionPackage);
		return theActionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromSystem() {
		return fromSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromSystem_Receiver() {
		return (EReference)fromSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternal() {
		return internalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoto() {
		return gotoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGoto_GotoTarget() {
		return (EReference)gotoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknown() {
		return unknownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCaseInclude() {
		return useCaseIncludeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseInclude_IncludeTarget() {
		return (EReference)useCaseIncludeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbortUseCase() {
		return abortUseCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToSystem() {
		return toSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToSystem_Sender() {
		return (EReference)toSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunication() {
		return communicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunication_ActionParam() {
		return (EReference)communicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunication_ActionName() {
		return (EReference)communicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionFactory getActionFactory() {
		return (ActionFactory)getEFactoryInstance();
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
		actionEClass = createEClass(ACTION);

		fromSystemEClass = createEClass(FROM_SYSTEM);
		createEReference(fromSystemEClass, FROM_SYSTEM__RECEIVER);

		internalEClass = createEClass(INTERNAL);

		gotoEClass = createEClass(GOTO);
		createEReference(gotoEClass, GOTO__GOTO_TARGET);

		unknownEClass = createEClass(UNKNOWN);

		useCaseIncludeEClass = createEClass(USE_CASE_INCLUDE);
		createEReference(useCaseIncludeEClass, USE_CASE_INCLUDE__INCLUDE_TARGET);

		abortUseCaseEClass = createEClass(ABORT_USE_CASE);

		toSystemEClass = createEClass(TO_SYSTEM);
		createEReference(toSystemEClass, TO_SYSTEM__SENDER);

		communicationEClass = createEClass(COMMUNICATION);
		createEReference(communicationEClass, COMMUNICATION__ACTION_PARAM);
		createEReference(communicationEClass, COMMUNICATION__ACTION_NAME);
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
		ActionpartPackage theActionpartPackage = (ActionpartPackage)EPackage.Registry.INSTANCE.getEPackage(ActionpartPackage.eNS_URI);
		UsecasePackage theUsecasePackage = (UsecasePackage)EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fromSystemEClass.getESuperTypes().add(this.getCommunication());
		internalEClass.getESuperTypes().add(this.getCommunication());
		gotoEClass.getESuperTypes().add(this.getAction());
		gotoEClass.getESuperTypes().add(theActionpartPackage.getActionPart());
		unknownEClass.getESuperTypes().add(this.getAction());
		useCaseIncludeEClass.getESuperTypes().add(this.getAction());
		useCaseIncludeEClass.getESuperTypes().add(theActionpartPackage.getActionPart());
		abortUseCaseEClass.getESuperTypes().add(this.getAction());
		toSystemEClass.getESuperTypes().add(this.getCommunication());
		communicationEClass.getESuperTypes().add(this.getAction());

		// Initialize classes and features; add operations and parameters
		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fromSystemEClass, FromSystem.class, "FromSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromSystem_Receiver(), theActionpartPackage.getSentenceActor(), null, "receiver", null, 1, 1, FromSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalEClass, Internal.class, "Internal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gotoEClass, Goto.class, "Goto", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGoto_GotoTarget(), theUsecasePackage.getUseCaseStep(), null, "gotoTarget", null, 1, 1, Goto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unknownEClass, Unknown.class, "Unknown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(useCaseIncludeEClass, UseCaseInclude.class, "UseCaseInclude", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCaseInclude_IncludeTarget(), theUsecasePackage.getUseCase(), null, "includeTarget", null, 1, 1, UseCaseInclude.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abortUseCaseEClass, AbortUseCase.class, "AbortUseCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(toSystemEClass, ToSystem.class, "ToSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToSystem_Sender(), theActionpartPackage.getSentenceActor(), null, "sender", null, 1, 1, ToSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(communicationEClass, Communication.class, "Communication", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommunication_ActionParam(), theActionpartPackage.getSentenceActionParam(), null, "actionParam", null, 0, -1, Communication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommunication_ActionName(), theActionpartPackage.getText(), null, "actionName", null, 1, 1, Communication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ActionPackageImpl
