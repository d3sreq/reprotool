/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.ArrayType;
import reprotool.fm.nusmv.lang.nuSmvLang.AssignBody;
import reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.AsyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvLang.BooleanType;
import reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.DefineBody;
import reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.EnumType;
import reprotool.fm.nusmv.lang.nuSmvLang.FairnessConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter;
import reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.IVariableDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.InitBody;
import reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.MainModule;
import reprotool.fm.nusmv.lang.nuSmvLang.Model;
import reprotool.fm.nusmv.lang.nuSmvLang.Module;
import reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement;
import reprotool.fm.nusmv.lang.nuSmvLang.ModuleType;
import reprotool.fm.nusmv.lang.nuSmvLang.NextBody;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;
import reprotool.fm.nusmv.lang.nuSmvLang.OtherModule;
import reprotool.fm.nusmv.lang.nuSmvLang.RangeType;
import reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType;
import reprotool.fm.nusmv.lang.nuSmvLang.SimpleType;
import reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.TypeSpecifier;
import reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBody;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign;
import reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.WordType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NuSmvLangPackageImpl extends EPackageImpl implements NuSmvLangPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mainModuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass otherModuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iVariableDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass frozenVariableDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantsDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varBodyAssignEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nextBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invarConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fairnessConstraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fairnessExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass justiceExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compassionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invarSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ctlSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ltlSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wordTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unsignedWordTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signedWordTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rangeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asyncrProcessTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass syncrProcessTypeEClass = null;

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
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private NuSmvLangPackageImpl()
  {
    super(eNS_URI, NuSmvLangFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link NuSmvLangPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static NuSmvLangPackage init()
  {
    if (isInited) return (NuSmvLangPackage)EPackage.Registry.INSTANCE.getEPackage(NuSmvLangPackage.eNS_URI);

    // Obtain or create and register package
    NuSmvLangPackageImpl theNuSmvLangPackage = (NuSmvLangPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NuSmvLangPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NuSmvLangPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theNuSmvLangPackage.createPackageContents();

    // Initialize created meta-data
    theNuSmvLangPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theNuSmvLangPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(NuSmvLangPackage.eNS_URI, theNuSmvLangPackage);
    return theNuSmvLangPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Modules()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_ModuleElement()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Name()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMainModule()
  {
    return mainModuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOtherModule()
  {
    return otherModuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOtherModule_Params()
  {
    return (EReference)otherModuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleElement()
  {
    return moduleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDeclaration()
  {
    return variableDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclaration_Vars()
  {
    return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIVariableDeclaration()
  {
    return iVariableDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIVariableDeclaration_Vars()
  {
    return (EReference)iVariableDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFrozenVariableDeclaration()
  {
    return frozenVariableDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFrozenVariableDeclaration_Vars()
  {
    return (EReference)frozenVariableDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarBody()
  {
    return varBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarBody_VarId()
  {
    return (EAttribute)varBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarBody_Type()
  {
    return (EReference)varBodyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefineDeclaration()
  {
    return defineDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefineDeclaration_DefineBodies()
  {
    return (EReference)defineDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefineBody()
  {
    return defineBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefineBody_VarId()
  {
    return (EAttribute)defineBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefineBody_Assignment()
  {
    return (EAttribute)defineBodyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantsDeclaration()
  {
    return constantsDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstantsDeclaration_Constants()
  {
    return (EAttribute)constantsDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignConstraint()
  {
    return assignConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignConstraint_Bodies()
  {
    return (EReference)assignConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignBody()
  {
    return assignBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignBody_VarId()
  {
    return (EAttribute)assignBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarBodyAssign()
  {
    return varBodyAssignEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarBodyAssign_Assignment()
  {
    return (EAttribute)varBodyAssignEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitBody()
  {
    return initBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInitBody_InitExpr()
  {
    return (EAttribute)initBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNextBody()
  {
    return nextBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNextBody_NextExpr()
  {
    return (EAttribute)nextBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransConstraint()
  {
    return transConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransConstraint_TransExpr()
  {
    return (EAttribute)transConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitConstraint()
  {
    return initConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInitConstraint_InitExpr()
  {
    return (EAttribute)initConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvarConstraint()
  {
    return invarConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInvarConstraint_InvarExpr()
  {
    return (EAttribute)invarConstraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFairnessConstraint()
  {
    return fairnessConstraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFairnessExpression()
  {
    return fairnessExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFairnessExpression_FairnessExpr()
  {
    return (EAttribute)fairnessExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJusticeExpression()
  {
    return justiceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJusticeExpression_JusticeExpr()
  {
    return (EAttribute)justiceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompassionExpression()
  {
    return compassionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCompassionExpression_FirstCompassionExpr()
  {
    return (EAttribute)compassionExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCompassionExpression_SecondCompassionExpr()
  {
    return (EAttribute)compassionExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvarSpecification()
  {
    return invarSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInvarSpecification_Name()
  {
    return (EAttribute)invarSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInvarSpecification_InvarExpr()
  {
    return (EAttribute)invarSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCtlSpecification()
  {
    return ctlSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCtlSpecification_NameKeyWord()
  {
    return (EAttribute)ctlSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCtlSpecification_Name()
  {
    return (EAttribute)ctlSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCtlSpecification_CtlExpr()
  {
    return (EAttribute)ctlSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLtlSpecification()
  {
    return ltlSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLtlSpecification_NameId()
  {
    return (EAttribute)ltlSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLtlSpecification_Name()
  {
    return (EAttribute)ltlSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLtlSpecification_LtlExpr()
  {
    return (EAttribute)ltlSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSpecifier()
  {
    return typeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleType()
  {
    return simpleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleType()
  {
    return moduleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModuleType_Module()
  {
    return (EReference)moduleTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModuleType_Params()
  {
    return (EAttribute)moduleTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameter()
  {
    return formalParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_ParamId()
  {
    return (EAttribute)formalParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanType()
  {
    return booleanTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWordType()
  {
    return wordTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWordType_WordNumber()
  {
    return (EAttribute)wordTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnsignedWordType()
  {
    return unsignedWordTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnsignedWordType_UWordNumber()
  {
    return (EAttribute)unsignedWordTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignedWordType()
  {
    return signedWordTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSignedWordType_SignedNumber()
  {
    return (EAttribute)signedWordTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumType()
  {
    return enumTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumType_Value()
  {
    return (EAttribute)enumTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRangeType()
  {
    return rangeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRangeType_Low()
  {
    return (EAttribute)rangeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRangeType_High()
  {
    return (EAttribute)rangeTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayType()
  {
    return arrayTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getArrayType_Bounds()
  {
    return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayType_Type()
  {
    return (EReference)arrayTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsyncrProcessType()
  {
    return asyncrProcessTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSyncrProcessType()
  {
    return syncrProcessTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NuSmvLangFactory getNuSmvLangFactory()
  {
    return (NuSmvLangFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__MODULES);

    moduleEClass = createEClass(MODULE);
    createEReference(moduleEClass, MODULE__MODULE_ELEMENT);
    createEAttribute(moduleEClass, MODULE__NAME);

    mainModuleEClass = createEClass(MAIN_MODULE);

    otherModuleEClass = createEClass(OTHER_MODULE);
    createEReference(otherModuleEClass, OTHER_MODULE__PARAMS);

    moduleElementEClass = createEClass(MODULE_ELEMENT);

    variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
    createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__VARS);

    iVariableDeclarationEClass = createEClass(IVARIABLE_DECLARATION);
    createEReference(iVariableDeclarationEClass, IVARIABLE_DECLARATION__VARS);

    frozenVariableDeclarationEClass = createEClass(FROZEN_VARIABLE_DECLARATION);
    createEReference(frozenVariableDeclarationEClass, FROZEN_VARIABLE_DECLARATION__VARS);

    varBodyEClass = createEClass(VAR_BODY);
    createEAttribute(varBodyEClass, VAR_BODY__VAR_ID);
    createEReference(varBodyEClass, VAR_BODY__TYPE);

    defineDeclarationEClass = createEClass(DEFINE_DECLARATION);
    createEReference(defineDeclarationEClass, DEFINE_DECLARATION__DEFINE_BODIES);

    defineBodyEClass = createEClass(DEFINE_BODY);
    createEAttribute(defineBodyEClass, DEFINE_BODY__VAR_ID);
    createEAttribute(defineBodyEClass, DEFINE_BODY__ASSIGNMENT);

    constantsDeclarationEClass = createEClass(CONSTANTS_DECLARATION);
    createEAttribute(constantsDeclarationEClass, CONSTANTS_DECLARATION__CONSTANTS);

    assignConstraintEClass = createEClass(ASSIGN_CONSTRAINT);
    createEReference(assignConstraintEClass, ASSIGN_CONSTRAINT__BODIES);

    assignBodyEClass = createEClass(ASSIGN_BODY);
    createEAttribute(assignBodyEClass, ASSIGN_BODY__VAR_ID);

    varBodyAssignEClass = createEClass(VAR_BODY_ASSIGN);
    createEAttribute(varBodyAssignEClass, VAR_BODY_ASSIGN__ASSIGNMENT);

    initBodyEClass = createEClass(INIT_BODY);
    createEAttribute(initBodyEClass, INIT_BODY__INIT_EXPR);

    nextBodyEClass = createEClass(NEXT_BODY);
    createEAttribute(nextBodyEClass, NEXT_BODY__NEXT_EXPR);

    transConstraintEClass = createEClass(TRANS_CONSTRAINT);
    createEAttribute(transConstraintEClass, TRANS_CONSTRAINT__TRANS_EXPR);

    initConstraintEClass = createEClass(INIT_CONSTRAINT);
    createEAttribute(initConstraintEClass, INIT_CONSTRAINT__INIT_EXPR);

    invarConstraintEClass = createEClass(INVAR_CONSTRAINT);
    createEAttribute(invarConstraintEClass, INVAR_CONSTRAINT__INVAR_EXPR);

    fairnessConstraintEClass = createEClass(FAIRNESS_CONSTRAINT);

    fairnessExpressionEClass = createEClass(FAIRNESS_EXPRESSION);
    createEAttribute(fairnessExpressionEClass, FAIRNESS_EXPRESSION__FAIRNESS_EXPR);

    justiceExpressionEClass = createEClass(JUSTICE_EXPRESSION);
    createEAttribute(justiceExpressionEClass, JUSTICE_EXPRESSION__JUSTICE_EXPR);

    compassionExpressionEClass = createEClass(COMPASSION_EXPRESSION);
    createEAttribute(compassionExpressionEClass, COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR);
    createEAttribute(compassionExpressionEClass, COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR);

    invarSpecificationEClass = createEClass(INVAR_SPECIFICATION);
    createEAttribute(invarSpecificationEClass, INVAR_SPECIFICATION__NAME);
    createEAttribute(invarSpecificationEClass, INVAR_SPECIFICATION__INVAR_EXPR);

    ctlSpecificationEClass = createEClass(CTL_SPECIFICATION);
    createEAttribute(ctlSpecificationEClass, CTL_SPECIFICATION__NAME_KEY_WORD);
    createEAttribute(ctlSpecificationEClass, CTL_SPECIFICATION__NAME);
    createEAttribute(ctlSpecificationEClass, CTL_SPECIFICATION__CTL_EXPR);

    ltlSpecificationEClass = createEClass(LTL_SPECIFICATION);
    createEAttribute(ltlSpecificationEClass, LTL_SPECIFICATION__NAME_ID);
    createEAttribute(ltlSpecificationEClass, LTL_SPECIFICATION__NAME);
    createEAttribute(ltlSpecificationEClass, LTL_SPECIFICATION__LTL_EXPR);

    typeSpecifierEClass = createEClass(TYPE_SPECIFIER);

    simpleTypeEClass = createEClass(SIMPLE_TYPE);

    moduleTypeEClass = createEClass(MODULE_TYPE);
    createEReference(moduleTypeEClass, MODULE_TYPE__MODULE);
    createEAttribute(moduleTypeEClass, MODULE_TYPE__PARAMS);

    formalParameterEClass = createEClass(FORMAL_PARAMETER);
    createEAttribute(formalParameterEClass, FORMAL_PARAMETER__PARAM_ID);

    booleanTypeEClass = createEClass(BOOLEAN_TYPE);

    wordTypeEClass = createEClass(WORD_TYPE);
    createEAttribute(wordTypeEClass, WORD_TYPE__WORD_NUMBER);

    unsignedWordTypeEClass = createEClass(UNSIGNED_WORD_TYPE);
    createEAttribute(unsignedWordTypeEClass, UNSIGNED_WORD_TYPE__UWORD_NUMBER);

    signedWordTypeEClass = createEClass(SIGNED_WORD_TYPE);
    createEAttribute(signedWordTypeEClass, SIGNED_WORD_TYPE__SIGNED_NUMBER);

    enumTypeEClass = createEClass(ENUM_TYPE);
    createEAttribute(enumTypeEClass, ENUM_TYPE__VALUE);

    rangeTypeEClass = createEClass(RANGE_TYPE);
    createEAttribute(rangeTypeEClass, RANGE_TYPE__LOW);
    createEAttribute(rangeTypeEClass, RANGE_TYPE__HIGH);

    arrayTypeEClass = createEClass(ARRAY_TYPE);
    createEAttribute(arrayTypeEClass, ARRAY_TYPE__BOUNDS);
    createEReference(arrayTypeEClass, ARRAY_TYPE__TYPE);

    asyncrProcessTypeEClass = createEClass(ASYNCR_PROCESS_TYPE);

    syncrProcessTypeEClass = createEClass(SYNCR_PROCESS_TYPE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    mainModuleEClass.getESuperTypes().add(this.getModule());
    otherModuleEClass.getESuperTypes().add(this.getModule());
    variableDeclarationEClass.getESuperTypes().add(this.getModuleElement());
    iVariableDeclarationEClass.getESuperTypes().add(this.getModuleElement());
    frozenVariableDeclarationEClass.getESuperTypes().add(this.getModuleElement());
    defineDeclarationEClass.getESuperTypes().add(this.getModuleElement());
    constantsDeclarationEClass.getESuperTypes().add(this.getModuleElement());
    assignConstraintEClass.getESuperTypes().add(this.getModuleElement());
    varBodyAssignEClass.getESuperTypes().add(this.getAssignBody());
    initBodyEClass.getESuperTypes().add(this.getAssignBody());
    nextBodyEClass.getESuperTypes().add(this.getAssignBody());
    transConstraintEClass.getESuperTypes().add(this.getModuleElement());
    initConstraintEClass.getESuperTypes().add(this.getModuleElement());
    invarConstraintEClass.getESuperTypes().add(this.getModuleElement());
    fairnessConstraintEClass.getESuperTypes().add(this.getModuleElement());
    fairnessExpressionEClass.getESuperTypes().add(this.getFairnessConstraint());
    justiceExpressionEClass.getESuperTypes().add(this.getFairnessConstraint());
    compassionExpressionEClass.getESuperTypes().add(this.getFairnessConstraint());
    invarSpecificationEClass.getESuperTypes().add(this.getModuleElement());
    ctlSpecificationEClass.getESuperTypes().add(this.getModuleElement());
    ltlSpecificationEClass.getESuperTypes().add(this.getModuleElement());
    simpleTypeEClass.getESuperTypes().add(this.getTypeSpecifier());
    moduleTypeEClass.getESuperTypes().add(this.getTypeSpecifier());
    booleanTypeEClass.getESuperTypes().add(this.getSimpleType());
    wordTypeEClass.getESuperTypes().add(this.getSimpleType());
    unsignedWordTypeEClass.getESuperTypes().add(this.getSimpleType());
    signedWordTypeEClass.getESuperTypes().add(this.getSimpleType());
    enumTypeEClass.getESuperTypes().add(this.getSimpleType());
    rangeTypeEClass.getESuperTypes().add(this.getSimpleType());
    arrayTypeEClass.getESuperTypes().add(this.getSimpleType());
    asyncrProcessTypeEClass.getESuperTypes().add(this.getModuleType());
    syncrProcessTypeEClass.getESuperTypes().add(this.getModuleType());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Modules(), this.getModule(), null, "modules", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModule_ModuleElement(), this.getModuleElement(), null, "moduleElement", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mainModuleEClass, MainModule.class, "MainModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(otherModuleEClass, OtherModule.class, "OtherModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOtherModule_Params(), this.getFormalParameter(), null, "params", null, 0, -1, OtherModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleElementEClass, ModuleElement.class, "ModuleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableDeclaration_Vars(), this.getVarBody(), null, "vars", null, 0, -1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iVariableDeclarationEClass, IVariableDeclaration.class, "IVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIVariableDeclaration_Vars(), this.getVarBody(), null, "vars", null, 0, -1, IVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(frozenVariableDeclarationEClass, FrozenVariableDeclaration.class, "FrozenVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFrozenVariableDeclaration_Vars(), this.getVarBody(), null, "vars", null, 0, -1, FrozenVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varBodyEClass, VarBody.class, "VarBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVarBody_VarId(), ecorePackage.getEString(), "varId", null, 0, 1, VarBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVarBody_Type(), this.getTypeSpecifier(), null, "type", null, 0, 1, VarBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineDeclarationEClass, DefineDeclaration.class, "DefineDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefineDeclaration_DefineBodies(), this.getDefineBody(), null, "defineBodies", null, 0, -1, DefineDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineBodyEClass, DefineBody.class, "DefineBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDefineBody_VarId(), ecorePackage.getEString(), "varId", null, 0, 1, DefineBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDefineBody_Assignment(), ecorePackage.getEString(), "assignment", null, 0, 1, DefineBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantsDeclarationEClass, ConstantsDeclaration.class, "ConstantsDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstantsDeclaration_Constants(), ecorePackage.getEString(), "constants", null, 0, -1, ConstantsDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignConstraintEClass, AssignConstraint.class, "AssignConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignConstraint_Bodies(), this.getAssignBody(), null, "bodies", null, 0, -1, AssignConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignBodyEClass, AssignBody.class, "AssignBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssignBody_VarId(), ecorePackage.getEString(), "varId", null, 0, 1, AssignBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varBodyAssignEClass, VarBodyAssign.class, "VarBodyAssign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVarBodyAssign_Assignment(), ecorePackage.getEString(), "assignment", null, 0, 1, VarBodyAssign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initBodyEClass, InitBody.class, "InitBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInitBody_InitExpr(), ecorePackage.getEString(), "initExpr", null, 0, 1, InitBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nextBodyEClass, NextBody.class, "NextBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNextBody_NextExpr(), ecorePackage.getEString(), "nextExpr", null, 0, 1, NextBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transConstraintEClass, TransConstraint.class, "TransConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransConstraint_TransExpr(), ecorePackage.getEString(), "transExpr", null, 0, 1, TransConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initConstraintEClass, InitConstraint.class, "InitConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInitConstraint_InitExpr(), ecorePackage.getEString(), "initExpr", null, 0, 1, InitConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invarConstraintEClass, InvarConstraint.class, "InvarConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInvarConstraint_InvarExpr(), ecorePackage.getEString(), "invarExpr", null, 0, 1, InvarConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fairnessConstraintEClass, FairnessConstraint.class, "FairnessConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fairnessExpressionEClass, FairnessExpression.class, "FairnessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFairnessExpression_FairnessExpr(), ecorePackage.getEString(), "fairnessExpr", null, 0, 1, FairnessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(justiceExpressionEClass, JusticeExpression.class, "JusticeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJusticeExpression_JusticeExpr(), ecorePackage.getEString(), "justiceExpr", null, 0, 1, JusticeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compassionExpressionEClass, CompassionExpression.class, "CompassionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCompassionExpression_FirstCompassionExpr(), ecorePackage.getEString(), "firstCompassionExpr", null, 0, 1, CompassionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCompassionExpression_SecondCompassionExpr(), ecorePackage.getEString(), "secondCompassionExpr", null, 0, 1, CompassionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invarSpecificationEClass, InvarSpecification.class, "InvarSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInvarSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, InvarSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInvarSpecification_InvarExpr(), ecorePackage.getEString(), "invarExpr", null, 0, 1, InvarSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ctlSpecificationEClass, CtlSpecification.class, "CtlSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCtlSpecification_NameKeyWord(), ecorePackage.getEBoolean(), "nameKeyWord", null, 0, 1, CtlSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCtlSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, CtlSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCtlSpecification_CtlExpr(), ecorePackage.getEString(), "ctlExpr", null, 0, 1, CtlSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ltlSpecificationEClass, LtlSpecification.class, "LtlSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLtlSpecification_NameId(), ecorePackage.getEBoolean(), "nameId", null, 0, 1, LtlSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLtlSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, LtlSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLtlSpecification_LtlExpr(), ecorePackage.getEString(), "ltlExpr", null, 0, 1, LtlSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeSpecifierEClass, TypeSpecifier.class, "TypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simpleTypeEClass, SimpleType.class, "SimpleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(moduleTypeEClass, ModuleType.class, "ModuleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModuleType_Module(), this.getModule(), null, "module", null, 0, 1, ModuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModuleType_Params(), ecorePackage.getEString(), "params", null, 0, -1, ModuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalParameterEClass, FormalParameter.class, "FormalParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFormalParameter_ParamId(), ecorePackage.getEString(), "paramId", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(wordTypeEClass, WordType.class, "WordType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWordType_WordNumber(), ecorePackage.getEString(), "wordNumber", null, 0, 1, WordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unsignedWordTypeEClass, UnsignedWordType.class, "UnsignedWordType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnsignedWordType_UWordNumber(), ecorePackage.getEString(), "uWordNumber", null, 0, 1, UnsignedWordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(signedWordTypeEClass, SignedWordType.class, "SignedWordType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSignedWordType_SignedNumber(), ecorePackage.getEString(), "signedNumber", null, 0, 1, SignedWordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumTypeEClass, EnumType.class, "EnumType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumType_Value(), ecorePackage.getEString(), "value", null, 0, -1, EnumType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rangeTypeEClass, RangeType.class, "RangeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRangeType_Low(), ecorePackage.getEString(), "low", null, 0, 1, RangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRangeType_High(), ecorePackage.getEString(), "high", null, 0, 1, RangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayTypeEClass, ArrayType.class, "ArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getArrayType_Bounds(), ecorePackage.getEString(), "bounds", null, 0, 1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrayType_Type(), this.getSimpleType(), null, "type", null, 0, 1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asyncrProcessTypeEClass, AsyncrProcessType.class, "AsyncrProcessType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(syncrProcessTypeEClass, SyncrProcessType.class, "SyncrProcessType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //NuSmvLangPackageImpl
