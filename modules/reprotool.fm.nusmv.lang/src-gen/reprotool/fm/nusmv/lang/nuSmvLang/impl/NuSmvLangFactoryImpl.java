/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.fm.nusmv.lang.nuSmvLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NuSmvLangFactoryImpl extends EFactoryImpl implements NuSmvLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NuSmvLangFactory init()
  {
    try
    {
      NuSmvLangFactory theNuSmvLangFactory = (NuSmvLangFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/nusmv/lang"); 
      if (theNuSmvLangFactory != null)
      {
        return theNuSmvLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new NuSmvLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NuSmvLangFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case NuSmvLangPackage.MODEL: return createModel();
      case NuSmvLangPackage.MODULE: return createModule();
      case NuSmvLangPackage.MAIN_MODULE: return createMainModule();
      case NuSmvLangPackage.OTHER_MODULE: return createOtherModule();
      case NuSmvLangPackage.MODULE_ELEMENT: return createModuleElement();
      case NuSmvLangPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
      case NuSmvLangPackage.IVARIABLE_DECLARATION: return createIVariableDeclaration();
      case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION: return createFrozenVariableDeclaration();
      case NuSmvLangPackage.VAR_BODY: return createVarBody();
      case NuSmvLangPackage.DEFINE_DECLARATION: return createDefineDeclaration();
      case NuSmvLangPackage.DEFINE_BODY: return createDefineBody();
      case NuSmvLangPackage.CONSTANTS_DECLARATION: return createConstantsDeclaration();
      case NuSmvLangPackage.ASSIGN_CONSTRAINT: return createAssignConstraint();
      case NuSmvLangPackage.ASSIGN_BODY: return createAssignBody();
      case NuSmvLangPackage.VAR_BODY_ASSIGN: return createVarBodyAssign();
      case NuSmvLangPackage.INIT_BODY: return createInitBody();
      case NuSmvLangPackage.NEXT_BODY: return createNextBody();
      case NuSmvLangPackage.TRANS_CONSTRAINT: return createTransConstraint();
      case NuSmvLangPackage.INIT_CONSTRAINT: return createInitConstraint();
      case NuSmvLangPackage.INVAR_CONSTRAINT: return createInvarConstraint();
      case NuSmvLangPackage.FAIRNESS_CONSTRAINT: return createFairnessConstraint();
      case NuSmvLangPackage.FAIRNESS_EXPRESSION: return createFairnessExpression();
      case NuSmvLangPackage.JUSTICE_EXPRESSION: return createJusticeExpression();
      case NuSmvLangPackage.COMPASSION_EXPRESSION: return createCompassionExpression();
      case NuSmvLangPackage.INVAR_SPECIFICATION: return createInvarSpecification();
      case NuSmvLangPackage.CTL_SPECIFICATION: return createCtlSpecification();
      case NuSmvLangPackage.LTL_SPECIFICATION: return createLtlSpecification();
      case NuSmvLangPackage.TYPE_SPECIFIER: return createTypeSpecifier();
      case NuSmvLangPackage.SIMPLE_TYPE: return createSimpleType();
      case NuSmvLangPackage.MODULE_TYPE: return createModuleType();
      case NuSmvLangPackage.FORMAL_PARAMETER: return createFormalParameter();
      case NuSmvLangPackage.BOOLEAN_TYPE: return createBooleanType();
      case NuSmvLangPackage.WORD_TYPE: return createWordType();
      case NuSmvLangPackage.UNSIGNED_WORD_TYPE: return createUnsignedWordType();
      case NuSmvLangPackage.SIGNED_WORD_TYPE: return createSignedWordType();
      case NuSmvLangPackage.ENUM_TYPE: return createEnumType();
      case NuSmvLangPackage.RANGE_TYPE: return createRangeType();
      case NuSmvLangPackage.ARRAY_TYPE: return createArrayType();
      case NuSmvLangPackage.ASYNCR_PROCESS_TYPE: return createAsyncrProcessType();
      case NuSmvLangPackage.SYNCR_PROCESS_TYPE: return createSyncrProcessType();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MainModule createMainModule()
  {
    MainModuleImpl mainModule = new MainModuleImpl();
    return mainModule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OtherModule createOtherModule()
  {
    OtherModuleImpl otherModule = new OtherModuleImpl();
    return otherModule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleElement createModuleElement()
  {
    ModuleElementImpl moduleElement = new ModuleElementImpl();
    return moduleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclaration createVariableDeclaration()
  {
    VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
    return variableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IVariableDeclaration createIVariableDeclaration()
  {
    IVariableDeclarationImpl iVariableDeclaration = new IVariableDeclarationImpl();
    return iVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FrozenVariableDeclaration createFrozenVariableDeclaration()
  {
    FrozenVariableDeclarationImpl frozenVariableDeclaration = new FrozenVariableDeclarationImpl();
    return frozenVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarBody createVarBody()
  {
    VarBodyImpl varBody = new VarBodyImpl();
    return varBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineDeclaration createDefineDeclaration()
  {
    DefineDeclarationImpl defineDeclaration = new DefineDeclarationImpl();
    return defineDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineBody createDefineBody()
  {
    DefineBodyImpl defineBody = new DefineBodyImpl();
    return defineBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantsDeclaration createConstantsDeclaration()
  {
    ConstantsDeclarationImpl constantsDeclaration = new ConstantsDeclarationImpl();
    return constantsDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignConstraint createAssignConstraint()
  {
    AssignConstraintImpl assignConstraint = new AssignConstraintImpl();
    return assignConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignBody createAssignBody()
  {
    AssignBodyImpl assignBody = new AssignBodyImpl();
    return assignBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarBodyAssign createVarBodyAssign()
  {
    VarBodyAssignImpl varBodyAssign = new VarBodyAssignImpl();
    return varBodyAssign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitBody createInitBody()
  {
    InitBodyImpl initBody = new InitBodyImpl();
    return initBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NextBody createNextBody()
  {
    NextBodyImpl nextBody = new NextBodyImpl();
    return nextBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransConstraint createTransConstraint()
  {
    TransConstraintImpl transConstraint = new TransConstraintImpl();
    return transConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitConstraint createInitConstraint()
  {
    InitConstraintImpl initConstraint = new InitConstraintImpl();
    return initConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvarConstraint createInvarConstraint()
  {
    InvarConstraintImpl invarConstraint = new InvarConstraintImpl();
    return invarConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FairnessConstraint createFairnessConstraint()
  {
    FairnessConstraintImpl fairnessConstraint = new FairnessConstraintImpl();
    return fairnessConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FairnessExpression createFairnessExpression()
  {
    FairnessExpressionImpl fairnessExpression = new FairnessExpressionImpl();
    return fairnessExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JusticeExpression createJusticeExpression()
  {
    JusticeExpressionImpl justiceExpression = new JusticeExpressionImpl();
    return justiceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompassionExpression createCompassionExpression()
  {
    CompassionExpressionImpl compassionExpression = new CompassionExpressionImpl();
    return compassionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvarSpecification createInvarSpecification()
  {
    InvarSpecificationImpl invarSpecification = new InvarSpecificationImpl();
    return invarSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CtlSpecification createCtlSpecification()
  {
    CtlSpecificationImpl ctlSpecification = new CtlSpecificationImpl();
    return ctlSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LtlSpecification createLtlSpecification()
  {
    LtlSpecificationImpl ltlSpecification = new LtlSpecificationImpl();
    return ltlSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSpecifier createTypeSpecifier()
  {
    TypeSpecifierImpl typeSpecifier = new TypeSpecifierImpl();
    return typeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleType createSimpleType()
  {
    SimpleTypeImpl simpleType = new SimpleTypeImpl();
    return simpleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleType createModuleType()
  {
    ModuleTypeImpl moduleType = new ModuleTypeImpl();
    return moduleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameter createFormalParameter()
  {
    FormalParameterImpl formalParameter = new FormalParameterImpl();
    return formalParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanType createBooleanType()
  {
    BooleanTypeImpl booleanType = new BooleanTypeImpl();
    return booleanType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WordType createWordType()
  {
    WordTypeImpl wordType = new WordTypeImpl();
    return wordType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnsignedWordType createUnsignedWordType()
  {
    UnsignedWordTypeImpl unsignedWordType = new UnsignedWordTypeImpl();
    return unsignedWordType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignedWordType createSignedWordType()
  {
    SignedWordTypeImpl signedWordType = new SignedWordTypeImpl();
    return signedWordType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumType createEnumType()
  {
    EnumTypeImpl enumType = new EnumTypeImpl();
    return enumType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RangeType createRangeType()
  {
    RangeTypeImpl rangeType = new RangeTypeImpl();
    return rangeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayType createArrayType()
  {
    ArrayTypeImpl arrayType = new ArrayTypeImpl();
    return arrayType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AsyncrProcessType createAsyncrProcessType()
  {
    AsyncrProcessTypeImpl asyncrProcessType = new AsyncrProcessTypeImpl();
    return asyncrProcessType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyncrProcessType createSyncrProcessType()
  {
    SyncrProcessTypeImpl syncrProcessType = new SyncrProcessTypeImpl();
    return syncrProcessType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NuSmvLangPackage getNuSmvLangPackage()
  {
    return (NuSmvLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static NuSmvLangPackage getPackage()
  {
    return NuSmvLangPackage.eINSTANCE;
  }

} //NuSmvLangFactoryImpl
