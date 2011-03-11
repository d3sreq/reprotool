/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.structure.ast.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.model.linguistic.ILinguisticPackage;

import reprotool.model.linguistic.impl.LinguisticPackage;

import reprotool.model.specification.ISpecificationPackage;

import reprotool.model.specification.impl.SpecificationPackage;

import reprotool.model.structure.ast.IAstFactory;
import reprotool.model.structure.ast.IAstPackage;
import reprotool.model.structure.ast.IClass;
import reprotool.model.structure.ast.ICodeElement;
import reprotool.model.structure.ast.IMethod;
import reprotool.model.structure.ast.MethodVisibility;

import reprotool.model.structure.doc.IDocPackage;

import reprotool.model.structure.doc.impl.DocPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AstPackage extends EPackageImpl implements IAstPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum methodVisibilityEEnum = null;

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
	 * @see reprotool.model.structure.ast.IAstPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AstPackage() {
		super(eNS_URI, IAstFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link IAstPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IAstPackage init() {
		if (isInited) return (IAstPackage)EPackage.Registry.INSTANCE.getEPackage(IAstPackage.eNS_URI);

		// Obtain or create and register package
		AstPackage theAstPackage = (AstPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AstPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		LinguisticPackage theLinguisticPackage = (LinguisticPackage)(EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) instanceof LinguisticPackage ? EPackage.Registry.INSTANCE.getEPackage(ILinguisticPackage.eNS_URI) : ILinguisticPackage.eINSTANCE);
		SpecificationPackage theSpecificationPackage = (SpecificationPackage)(EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) instanceof SpecificationPackage ? EPackage.Registry.INSTANCE.getEPackage(ISpecificationPackage.eNS_URI) : ISpecificationPackage.eINSTANCE);
		DocPackage theDocPackage = (DocPackage)(EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) instanceof DocPackage ? EPackage.Registry.INSTANCE.getEPackage(IDocPackage.eNS_URI) : IDocPackage.eINSTANCE);

		// Create package meta-data objects
		theAstPackage.createPackageContents();
		theLinguisticPackage.createPackageContents();
		theSpecificationPackage.createPackageContents();
		theDocPackage.createPackageContents();

		// Initialize created meta-data
		theAstPackage.initializePackageContents();
		theLinguisticPackage.initializePackageContents();
		theSpecificationPackage.initializePackageContents();
		theDocPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAstPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IAstPackage.eNS_URI, theAstPackage);
		return theAstPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod() {
		return methodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_Visibility() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Methods() {
		return (EReference)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeElement() {
		return codeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeElement_Comment() {
		return (EAttribute)codeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeElement_Name() {
		return (EAttribute)codeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMethodVisibility() {
		return methodVisibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAstFactory getAstFactory() {
		return (IAstFactory)getEFactoryInstance();
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
		methodEClass = createEClass(METHOD);
		createEAttribute(methodEClass, METHOD__VISIBILITY);

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__METHODS);

		codeElementEClass = createEClass(CODE_ELEMENT);
		createEAttribute(codeElementEClass, CODE_ELEMENT__COMMENT);
		createEAttribute(codeElementEClass, CODE_ELEMENT__NAME);

		// Create enums
		methodVisibilityEEnum = createEEnum(METHOD_VISIBILITY);
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
		methodEClass.getESuperTypes().add(this.getCodeElement());
		classEClass.getESuperTypes().add(this.getCodeElement());

		// Initialize classes and features; add operations and parameters
		initEClass(methodEClass, IMethod.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethod_Visibility(), this.getMethodVisibility(), "visibility", null, 0, 1, IMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classEClass, IClass.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_Methods(), this.getMethod(), null, "methods", null, 0, -1, IClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeElementEClass, ICodeElement.class, "CodeElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeElement_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, ICodeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ICodeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(methodVisibilityEEnum, MethodVisibility.class, "MethodVisibility");
		addEEnumLiteral(methodVisibilityEEnum, MethodVisibility.PRIVATE);
		addEEnumLiteral(methodVisibilityEEnum, MethodVisibility.PUBLIC);

		// Create resource
		createResource(eNS_URI);
	}

} //AstPackage
