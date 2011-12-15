/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory
 * @model kind="package"
 * @generated
 */
public interface NuSmvLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "nuSmvLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/nusmv/lang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "nuSmvLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NuSmvLangPackage eINSTANCE = reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl.init();

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModelImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MODULES = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModule()
   * @generated
   */
  int MODULE = 1;

  /**
   * The feature id for the '<em><b>Module Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__MODULE_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = 1;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.MainModuleImpl <em>Main Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.MainModuleImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getMainModule()
   * @generated
   */
  int MAIN_MODULE = 2;

  /**
   * The feature id for the '<em><b>Module Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_MODULE__MODULE_ELEMENT = MODULE__MODULE_ELEMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_MODULE__NAME = MODULE__NAME;

  /**
   * The number of structural features of the '<em>Main Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_MODULE_FEATURE_COUNT = MODULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.OtherModuleImpl <em>Other Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.OtherModuleImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getOtherModule()
   * @generated
   */
  int OTHER_MODULE = 3;

  /**
   * The feature id for the '<em><b>Module Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHER_MODULE__MODULE_ELEMENT = MODULE__MODULE_ELEMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHER_MODULE__NAME = MODULE__NAME;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHER_MODULE__PARAMS = MODULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Other Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHER_MODULE_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleElementImpl <em>Module Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleElementImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModuleElement()
   * @generated
   */
  int MODULE_ELEMENT = 4;

  /**
   * The number of structural features of the '<em>Module Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.VariableDeclarationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getVariableDeclaration()
   * @generated
   */
  int VARIABLE_DECLARATION = 5;

  /**
   * The feature id for the '<em><b>Vars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__VARS = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.IVariableDeclarationImpl <em>IVariable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.IVariableDeclarationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getIVariableDeclaration()
   * @generated
   */
  int IVARIABLE_DECLARATION = 6;

  /**
   * The feature id for the '<em><b>Vars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IVARIABLE_DECLARATION__VARS = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>IVariable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IVARIABLE_DECLARATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FrozenVariableDeclarationImpl <em>Frozen Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FrozenVariableDeclarationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFrozenVariableDeclaration()
   * @generated
   */
  int FROZEN_VARIABLE_DECLARATION = 7;

  /**
   * The feature id for the '<em><b>Vars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROZEN_VARIABLE_DECLARATION__VARS = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Frozen Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROZEN_VARIABLE_DECLARATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyImpl <em>Var Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getVarBody()
   * @generated
   */
  int VAR_BODY = 8;

  /**
   * The feature id for the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_BODY__VAR_ID = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_BODY__TYPE = 1;

  /**
   * The number of structural features of the '<em>Var Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_BODY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineDeclarationImpl <em>Define Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineDeclarationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getDefineDeclaration()
   * @generated
   */
  int DEFINE_DECLARATION = 9;

  /**
   * The feature id for the '<em><b>Define Bodies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_DECLARATION__DEFINE_BODIES = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Define Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_DECLARATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineBodyImpl <em>Define Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineBodyImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getDefineBody()
   * @generated
   */
  int DEFINE_BODY = 10;

  /**
   * The feature id for the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_BODY__VAR_ID = 0;

  /**
   * The feature id for the '<em><b>Assignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_BODY__ASSIGNMENT = 1;

  /**
   * The number of structural features of the '<em>Define Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_BODY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ConstantsDeclarationImpl <em>Constants Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ConstantsDeclarationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getConstantsDeclaration()
   * @generated
   */
  int CONSTANTS_DECLARATION = 11;

  /**
   * The feature id for the '<em><b>Constants</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANTS_DECLARATION__CONSTANTS = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constants Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANTS_DECLARATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignConstraintImpl <em>Assign Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignConstraintImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getAssignConstraint()
   * @generated
   */
  int ASSIGN_CONSTRAINT = 12;

  /**
   * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_CONSTRAINT__BODIES = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Assign Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_CONSTRAINT_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignBodyImpl <em>Assign Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignBodyImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getAssignBody()
   * @generated
   */
  int ASSIGN_BODY = 13;

  /**
   * The feature id for the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_BODY__VAR_ID = 0;

  /**
   * The number of structural features of the '<em>Assign Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_BODY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyAssignImpl <em>Var Body Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyAssignImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getVarBodyAssign()
   * @generated
   */
  int VAR_BODY_ASSIGN = 14;

  /**
   * The feature id for the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_BODY_ASSIGN__VAR_ID = ASSIGN_BODY__VAR_ID;

  /**
   * The feature id for the '<em><b>Assignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_BODY_ASSIGN__ASSIGNMENT = ASSIGN_BODY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Var Body Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_BODY_ASSIGN_FEATURE_COUNT = ASSIGN_BODY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InitBodyImpl <em>Init Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InitBodyImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInitBody()
   * @generated
   */
  int INIT_BODY = 15;

  /**
   * The feature id for the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_BODY__VAR_ID = ASSIGN_BODY__VAR_ID;

  /**
   * The feature id for the '<em><b>Init Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_BODY__INIT_EXPR = ASSIGN_BODY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Init Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_BODY_FEATURE_COUNT = ASSIGN_BODY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.NextBodyImpl <em>Next Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NextBodyImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getNextBody()
   * @generated
   */
  int NEXT_BODY = 16;

  /**
   * The feature id for the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_BODY__VAR_ID = ASSIGN_BODY__VAR_ID;

  /**
   * The feature id for the '<em><b>Next Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_BODY__NEXT_EXPR = ASSIGN_BODY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Next Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_BODY_FEATURE_COUNT = ASSIGN_BODY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.TransConstraintImpl <em>Trans Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.TransConstraintImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getTransConstraint()
   * @generated
   */
  int TRANS_CONSTRAINT = 17;

  /**
   * The feature id for the '<em><b>Trans Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANS_CONSTRAINT__TRANS_EXPR = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Trans Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANS_CONSTRAINT_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InitConstraintImpl <em>Init Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InitConstraintImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInitConstraint()
   * @generated
   */
  int INIT_CONSTRAINT = 18;

  /**
   * The feature id for the '<em><b>Init Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_CONSTRAINT__INIT_EXPR = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Init Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_CONSTRAINT_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarConstraintImpl <em>Invar Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarConstraintImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInvarConstraint()
   * @generated
   */
  int INVAR_CONSTRAINT = 19;

  /**
   * The feature id for the '<em><b>Invar Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVAR_CONSTRAINT__INVAR_EXPR = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Invar Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVAR_CONSTRAINT_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessConstraintImpl <em>Fairness Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessConstraintImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFairnessConstraint()
   * @generated
   */
  int FAIRNESS_CONSTRAINT = 20;

  /**
   * The number of structural features of the '<em>Fairness Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIRNESS_CONSTRAINT_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessExpressionImpl <em>Fairness Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessExpressionImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFairnessExpression()
   * @generated
   */
  int FAIRNESS_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Fairness Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIRNESS_EXPRESSION__FAIRNESS_EXPR = FAIRNESS_CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fairness Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIRNESS_EXPRESSION_FEATURE_COUNT = FAIRNESS_CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.JusticeExpressionImpl <em>Justice Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.JusticeExpressionImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getJusticeExpression()
   * @generated
   */
  int JUSTICE_EXPRESSION = 22;

  /**
   * The feature id for the '<em><b>Justice Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTICE_EXPRESSION__JUSTICE_EXPR = FAIRNESS_CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Justice Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTICE_EXPRESSION_FEATURE_COUNT = FAIRNESS_CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CompassionExpressionImpl <em>Compassion Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.CompassionExpressionImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getCompassionExpression()
   * @generated
   */
  int COMPASSION_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>First Compassion Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR = FAIRNESS_CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second Compassion Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR = FAIRNESS_CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Compassion Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPASSION_EXPRESSION_FEATURE_COUNT = FAIRNESS_CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarSpecificationImpl <em>Invar Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarSpecificationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInvarSpecification()
   * @generated
   */
  int INVAR_SPECIFICATION = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVAR_SPECIFICATION__NAME = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invar Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVAR_SPECIFICATION__INVAR_EXPR = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Invar Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVAR_SPECIFICATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CtlSpecificationImpl <em>Ctl Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.CtlSpecificationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getCtlSpecification()
   * @generated
   */
  int CTL_SPECIFICATION = 25;

  /**
   * The feature id for the '<em><b>Name Key Word</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CTL_SPECIFICATION__NAME_KEY_WORD = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CTL_SPECIFICATION__NAME = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ctl Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CTL_SPECIFICATION__CTL_EXPR = MODULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Ctl Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CTL_SPECIFICATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.LtlSpecificationImpl <em>Ltl Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.LtlSpecificationImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getLtlSpecification()
   * @generated
   */
  int LTL_SPECIFICATION = 26;

  /**
   * The feature id for the '<em><b>Name Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTL_SPECIFICATION__NAME_ID = MODULE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTL_SPECIFICATION__NAME = MODULE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ltl Expr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTL_SPECIFICATION__LTL_EXPR = MODULE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Ltl Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTL_SPECIFICATION_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.TypeSpecifierImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getTypeSpecifier()
   * @generated
   */
  int TYPE_SPECIFIER = 27;

  /**
   * The number of structural features of the '<em>Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.SimpleTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getSimpleType()
   * @generated
   */
  int SIMPLE_TYPE = 28;

  /**
   * The number of structural features of the '<em>Simple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TYPE_FEATURE_COUNT = TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleTypeImpl <em>Module Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModuleType()
   * @generated
   */
  int MODULE_TYPE = 29;

  /**
   * The feature id for the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_TYPE__MODULE = TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Params</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_TYPE__PARAMS = TYPE_SPECIFIER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Module Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_TYPE_FEATURE_COUNT = TYPE_SPECIFIER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FormalParameterImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFormalParameter()
   * @generated
   */
  int FORMAL_PARAMETER = 30;

  /**
   * The feature id for the '<em><b>Param Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__PARAM_ID = 0;

  /**
   * The number of structural features of the '<em>Formal Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.BooleanTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 31;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.WordTypeImpl <em>Word Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.WordTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getWordType()
   * @generated
   */
  int WORD_TYPE = 32;

  /**
   * The feature id for the '<em><b>Word Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD_TYPE__WORD_NUMBER = SIMPLE_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Word Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.UnsignedWordTypeImpl <em>Unsigned Word Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.UnsignedWordTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getUnsignedWordType()
   * @generated
   */
  int UNSIGNED_WORD_TYPE = 33;

  /**
   * The feature id for the '<em><b>UWord Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSIGNED_WORD_TYPE__UWORD_NUMBER = SIMPLE_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unsigned Word Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSIGNED_WORD_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.SignedWordTypeImpl <em>Signed Word Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.SignedWordTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getSignedWordType()
   * @generated
   */
  int SIGNED_WORD_TYPE = 34;

  /**
   * The feature id for the '<em><b>Signed Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNED_WORD_TYPE__SIGNED_NUMBER = SIMPLE_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Signed Word Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNED_WORD_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.EnumTypeImpl <em>Enum Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.EnumTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getEnumType()
   * @generated
   */
  int ENUM_TYPE = 35;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__VALUE = SIMPLE_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.RangeTypeImpl <em>Range Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.RangeTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getRangeType()
   * @generated
   */
  int RANGE_TYPE = 36;

  /**
   * The feature id for the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__LOW = SIMPLE_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__HIGH = SIMPLE_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Range Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ArrayTypeImpl <em>Array Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ArrayTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getArrayType()
   * @generated
   */
  int ARRAY_TYPE = 37;

  /**
   * The feature id for the '<em><b>Bounds</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE__BOUNDS = SIMPLE_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE__TYPE = SIMPLE_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.AsyncrProcessTypeImpl <em>Asyncr Process Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.AsyncrProcessTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getAsyncrProcessType()
   * @generated
   */
  int ASYNCR_PROCESS_TYPE = 38;

  /**
   * The feature id for the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASYNCR_PROCESS_TYPE__MODULE = MODULE_TYPE__MODULE;

  /**
   * The feature id for the '<em><b>Params</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASYNCR_PROCESS_TYPE__PARAMS = MODULE_TYPE__PARAMS;

  /**
   * The number of structural features of the '<em>Asyncr Process Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASYNCR_PROCESS_TYPE_FEATURE_COUNT = MODULE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.SyncrProcessTypeImpl <em>Syncr Process Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.SyncrProcessTypeImpl
   * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getSyncrProcessType()
   * @generated
   */
  int SYNCR_PROCESS_TYPE = 39;

  /**
   * The feature id for the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYNCR_PROCESS_TYPE__MODULE = MODULE_TYPE__MODULE;

  /**
   * The feature id for the '<em><b>Params</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYNCR_PROCESS_TYPE__PARAMS = MODULE_TYPE__PARAMS;

  /**
   * The number of structural features of the '<em>Syncr Process Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYNCR_PROCESS_TYPE_FEATURE_COUNT = MODULE_TYPE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.Model#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modules</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.Model#getModules()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Modules();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.Module#getModuleElement <em>Module Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Module Element</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.Module#getModuleElement()
   * @see #getModule()
   * @generated
   */
  EReference getModule_ModuleElement();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.MainModule <em>Main Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Main Module</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.MainModule
   * @generated
   */
  EClass getMainModule();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.OtherModule <em>Other Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Other Module</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.OtherModule
   * @generated
   */
  EClass getOtherModule();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.OtherModule#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.OtherModule#getParams()
   * @see #getOtherModule()
   * @generated
   */
  EReference getOtherModule_Params();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement <em>Module Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Element</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement
   * @generated
   */
  EClass getModuleElement();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Declaration</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration
   * @generated
   */
  EClass getVariableDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration#getVars <em>Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vars</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration#getVars()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Vars();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.IVariableDeclaration <em>IVariable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IVariable Declaration</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.IVariableDeclaration
   * @generated
   */
  EClass getIVariableDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.IVariableDeclaration#getVars <em>Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vars</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.IVariableDeclaration#getVars()
   * @see #getIVariableDeclaration()
   * @generated
   */
  EReference getIVariableDeclaration_Vars();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration <em>Frozen Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Frozen Variable Declaration</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration
   * @generated
   */
  EClass getFrozenVariableDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration#getVars <em>Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vars</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration#getVars()
   * @see #getFrozenVariableDeclaration()
   * @generated
   */
  EReference getFrozenVariableDeclaration_Vars();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody <em>Var Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Body</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VarBody
   * @generated
   */
  EClass getVarBody();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getVarId <em>Var Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var Id</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getVarId()
   * @see #getVarBody()
   * @generated
   */
  EAttribute getVarBody_VarId();

  /**
   * Returns the meta object for the containment reference '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VarBody#getType()
   * @see #getVarBody()
   * @generated
   */
  EReference getVarBody_Type();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration <em>Define Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Declaration</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration
   * @generated
   */
  EClass getDefineDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration#getDefineBodies <em>Define Bodies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Define Bodies</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration#getDefineBodies()
   * @see #getDefineDeclaration()
   * @generated
   */
  EReference getDefineDeclaration_DefineBodies();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody <em>Define Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Body</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.DefineBody
   * @generated
   */
  EClass getDefineBody();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getVarId <em>Var Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var Id</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getVarId()
   * @see #getDefineBody()
   * @generated
   */
  EAttribute getDefineBody_VarId();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getAssignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assignment</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.DefineBody#getAssignment()
   * @see #getDefineBody()
   * @generated
   */
  EAttribute getDefineBody_Assignment();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration <em>Constants Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constants Declaration</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration
   * @generated
   */
  EClass getConstantsDeclaration();

  /**
   * Returns the meta object for the attribute list '{@link reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Constants</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration#getConstants()
   * @see #getConstantsDeclaration()
   * @generated
   */
  EAttribute getConstantsDeclaration_Constants();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint <em>Assign Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign Constraint</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint
   * @generated
   */
  EClass getAssignConstraint();

  /**
   * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint#getBodies <em>Bodies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bodies</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint#getBodies()
   * @see #getAssignConstraint()
   * @generated
   */
  EReference getAssignConstraint_Bodies();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.AssignBody <em>Assign Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign Body</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AssignBody
   * @generated
   */
  EClass getAssignBody();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.AssignBody#getVarId <em>Var Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var Id</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AssignBody#getVarId()
   * @see #getAssignBody()
   * @generated
   */
  EAttribute getAssignBody_VarId();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign <em>Var Body Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Body Assign</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign
   * @generated
   */
  EClass getVarBodyAssign();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign#getAssignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assignment</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign#getAssignment()
   * @see #getVarBodyAssign()
   * @generated
   */
  EAttribute getVarBodyAssign_Assignment();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InitBody <em>Init Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Body</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InitBody
   * @generated
   */
  EClass getInitBody();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.InitBody#getInitExpr <em>Init Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Init Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InitBody#getInitExpr()
   * @see #getInitBody()
   * @generated
   */
  EAttribute getInitBody_InitExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.NextBody <em>Next Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Next Body</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NextBody
   * @generated
   */
  EClass getNextBody();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.NextBody#getNextExpr <em>Next Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Next Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NextBody#getNextExpr()
   * @see #getNextBody()
   * @generated
   */
  EAttribute getNextBody_NextExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint <em>Trans Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trans Constraint</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint
   * @generated
   */
  EClass getTransConstraint();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint#getTransExpr <em>Trans Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trans Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint#getTransExpr()
   * @see #getTransConstraint()
   * @generated
   */
  EAttribute getTransConstraint_TransExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint <em>Init Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Constraint</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint
   * @generated
   */
  EClass getInitConstraint();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint#getInitExpr <em>Init Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Init Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint#getInitExpr()
   * @see #getInitConstraint()
   * @generated
   */
  EAttribute getInitConstraint_InitExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint <em>Invar Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invar Constraint</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint
   * @generated
   */
  EClass getInvarConstraint();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint#getInvarExpr <em>Invar Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Invar Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint#getInvarExpr()
   * @see #getInvarConstraint()
   * @generated
   */
  EAttribute getInvarConstraint_InvarExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FairnessConstraint <em>Fairness Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fairness Constraint</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FairnessConstraint
   * @generated
   */
  EClass getFairnessConstraint();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression <em>Fairness Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fairness Expression</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression
   * @generated
   */
  EClass getFairnessExpression();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression#getFairnessExpr <em>Fairness Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fairness Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression#getFairnessExpr()
   * @see #getFairnessExpression()
   * @generated
   */
  EAttribute getFairnessExpression_FairnessExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression <em>Justice Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Justice Expression</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression
   * @generated
   */
  EClass getJusticeExpression();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression#getJusticeExpr <em>Justice Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Justice Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression#getJusticeExpr()
   * @see #getJusticeExpression()
   * @generated
   */
  EAttribute getJusticeExpression_JusticeExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression <em>Compassion Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compassion Expression</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression
   * @generated
   */
  EClass getCompassionExpression();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getFirstCompassionExpr <em>First Compassion Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First Compassion Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getFirstCompassionExpr()
   * @see #getCompassionExpression()
   * @generated
   */
  EAttribute getCompassionExpression_FirstCompassionExpr();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getSecondCompassionExpr <em>Second Compassion Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Second Compassion Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression#getSecondCompassionExpr()
   * @see #getCompassionExpression()
   * @generated
   */
  EAttribute getCompassionExpression_SecondCompassionExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification <em>Invar Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invar Specification</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification
   * @generated
   */
  EClass getInvarSpecification();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getName()
   * @see #getInvarSpecification()
   * @generated
   */
  EAttribute getInvarSpecification_Name();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getInvarExpr <em>Invar Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Invar Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification#getInvarExpr()
   * @see #getInvarSpecification()
   * @generated
   */
  EAttribute getInvarSpecification_InvarExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification <em>Ctl Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ctl Specification</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification
   * @generated
   */
  EClass getCtlSpecification();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#isNameKeyWord <em>Name Key Word</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name Key Word</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#isNameKeyWord()
   * @see #getCtlSpecification()
   * @generated
   */
  EAttribute getCtlSpecification_NameKeyWord();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getName()
   * @see #getCtlSpecification()
   * @generated
   */
  EAttribute getCtlSpecification_Name();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getCtlExpr <em>Ctl Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ctl Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification#getCtlExpr()
   * @see #getCtlSpecification()
   * @generated
   */
  EAttribute getCtlSpecification_CtlExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification <em>Ltl Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ltl Specification</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification
   * @generated
   */
  EClass getLtlSpecification();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#isNameId <em>Name Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name Id</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#isNameId()
   * @see #getLtlSpecification()
   * @generated
   */
  EAttribute getLtlSpecification_NameId();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getName()
   * @see #getLtlSpecification()
   * @generated
   */
  EAttribute getLtlSpecification_Name();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getLtlExpr <em>Ltl Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ltl Expr</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification#getLtlExpr()
   * @see #getLtlSpecification()
   * @generated
   */
  EAttribute getLtlSpecification_LtlExpr();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.TypeSpecifier <em>Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Specifier</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.TypeSpecifier
   * @generated
   */
  EClass getTypeSpecifier();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.SimpleType <em>Simple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.SimpleType
   * @generated
   */
  EClass getSimpleType();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleType <em>Module Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ModuleType
   * @generated
   */
  EClass getModuleType();

  /**
   * Returns the meta object for the reference '{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleType#getModule <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Module</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ModuleType#getModule()
   * @see #getModuleType()
   * @generated
   */
  EReference getModuleType_Module();

  /**
   * Returns the meta object for the attribute list '{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleType#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Params</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ModuleType#getParams()
   * @see #getModuleType()
   * @generated
   */
  EAttribute getModuleType_Params();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Parameter</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter
   * @generated
   */
  EClass getFormalParameter();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter#getParamId <em>Param Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Param Id</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter#getParamId()
   * @see #getFormalParameter()
   * @generated
   */
  EAttribute getFormalParameter_ParamId();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.BooleanType
   * @generated
   */
  EClass getBooleanType();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.WordType <em>Word Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Word Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.WordType
   * @generated
   */
  EClass getWordType();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.WordType#getWordNumber <em>Word Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Word Number</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.WordType#getWordNumber()
   * @see #getWordType()
   * @generated
   */
  EAttribute getWordType_WordNumber();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType <em>Unsigned Word Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unsigned Word Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType
   * @generated
   */
  EClass getUnsignedWordType();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType#getUWordNumber <em>UWord Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UWord Number</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType#getUWordNumber()
   * @see #getUnsignedWordType()
   * @generated
   */
  EAttribute getUnsignedWordType_UWordNumber();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType <em>Signed Word Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signed Word Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType
   * @generated
   */
  EClass getSignedWordType();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType#getSignedNumber <em>Signed Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Signed Number</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType#getSignedNumber()
   * @see #getSignedWordType()
   * @generated
   */
  EAttribute getSignedWordType_SignedNumber();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.EnumType
   * @generated
   */
  EClass getEnumType();

  /**
   * Returns the meta object for the attribute list '{@link reprotool.fm.nusmv.lang.nuSmvLang.EnumType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Value</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.EnumType#getValue()
   * @see #getEnumType()
   * @generated
   */
  EAttribute getEnumType_Value();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType <em>Range Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.RangeType
   * @generated
   */
  EClass getRangeType();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getLow <em>Low</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Low</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getLow()
   * @see #getRangeType()
   * @generated
   */
  EAttribute getRangeType_Low();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getHigh <em>High</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>High</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.RangeType#getHigh()
   * @see #getRangeType()
   * @generated
   */
  EAttribute getRangeType_High();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType <em>Array Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ArrayType
   * @generated
   */
  EClass getArrayType();

  /**
   * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getBounds <em>Bounds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bounds</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getBounds()
   * @see #getArrayType()
   * @generated
   */
  EAttribute getArrayType_Bounds();

  /**
   * Returns the meta object for the containment reference '{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ArrayType#getType()
   * @see #getArrayType()
   * @generated
   */
  EReference getArrayType_Type();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.AsyncrProcessType <em>Asyncr Process Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Asyncr Process Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AsyncrProcessType
   * @generated
   */
  EClass getAsyncrProcessType();

  /**
   * Returns the meta object for class '{@link reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType <em>Syncr Process Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Syncr Process Type</em>'.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType
   * @generated
   */
  EClass getSyncrProcessType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  NuSmvLangFactory getNuSmvLangFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModelImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MODULES = eINSTANCE.getModel_Modules();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Module Element</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__MODULE_ELEMENT = eINSTANCE.getModule_ModuleElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.MainModuleImpl <em>Main Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.MainModuleImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getMainModule()
     * @generated
     */
    EClass MAIN_MODULE = eINSTANCE.getMainModule();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.OtherModuleImpl <em>Other Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.OtherModuleImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getOtherModule()
     * @generated
     */
    EClass OTHER_MODULE = eINSTANCE.getOtherModule();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OTHER_MODULE__PARAMS = eINSTANCE.getOtherModule_Params();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleElementImpl <em>Module Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleElementImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModuleElement()
     * @generated
     */
    EClass MODULE_ELEMENT = eINSTANCE.getModuleElement();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.VariableDeclarationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getVariableDeclaration()
     * @generated
     */
    EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Vars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__VARS = eINSTANCE.getVariableDeclaration_Vars();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.IVariableDeclarationImpl <em>IVariable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.IVariableDeclarationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getIVariableDeclaration()
     * @generated
     */
    EClass IVARIABLE_DECLARATION = eINSTANCE.getIVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Vars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IVARIABLE_DECLARATION__VARS = eINSTANCE.getIVariableDeclaration_Vars();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FrozenVariableDeclarationImpl <em>Frozen Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FrozenVariableDeclarationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFrozenVariableDeclaration()
     * @generated
     */
    EClass FROZEN_VARIABLE_DECLARATION = eINSTANCE.getFrozenVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Vars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FROZEN_VARIABLE_DECLARATION__VARS = eINSTANCE.getFrozenVariableDeclaration_Vars();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyImpl <em>Var Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getVarBody()
     * @generated
     */
    EClass VAR_BODY = eINSTANCE.getVarBody();

    /**
     * The meta object literal for the '<em><b>Var Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_BODY__VAR_ID = eINSTANCE.getVarBody_VarId();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_BODY__TYPE = eINSTANCE.getVarBody_Type();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineDeclarationImpl <em>Define Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineDeclarationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getDefineDeclaration()
     * @generated
     */
    EClass DEFINE_DECLARATION = eINSTANCE.getDefineDeclaration();

    /**
     * The meta object literal for the '<em><b>Define Bodies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE_DECLARATION__DEFINE_BODIES = eINSTANCE.getDefineDeclaration_DefineBodies();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineBodyImpl <em>Define Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineBodyImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getDefineBody()
     * @generated
     */
    EClass DEFINE_BODY = eINSTANCE.getDefineBody();

    /**
     * The meta object literal for the '<em><b>Var Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE_BODY__VAR_ID = eINSTANCE.getDefineBody_VarId();

    /**
     * The meta object literal for the '<em><b>Assignment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE_BODY__ASSIGNMENT = eINSTANCE.getDefineBody_Assignment();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ConstantsDeclarationImpl <em>Constants Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ConstantsDeclarationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getConstantsDeclaration()
     * @generated
     */
    EClass CONSTANTS_DECLARATION = eINSTANCE.getConstantsDeclaration();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANTS_DECLARATION__CONSTANTS = eINSTANCE.getConstantsDeclaration_Constants();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignConstraintImpl <em>Assign Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignConstraintImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getAssignConstraint()
     * @generated
     */
    EClass ASSIGN_CONSTRAINT = eINSTANCE.getAssignConstraint();

    /**
     * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGN_CONSTRAINT__BODIES = eINSTANCE.getAssignConstraint_Bodies();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignBodyImpl <em>Assign Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.AssignBodyImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getAssignBody()
     * @generated
     */
    EClass ASSIGN_BODY = eINSTANCE.getAssignBody();

    /**
     * The meta object literal for the '<em><b>Var Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGN_BODY__VAR_ID = eINSTANCE.getAssignBody_VarId();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyAssignImpl <em>Var Body Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.VarBodyAssignImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getVarBodyAssign()
     * @generated
     */
    EClass VAR_BODY_ASSIGN = eINSTANCE.getVarBodyAssign();

    /**
     * The meta object literal for the '<em><b>Assignment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_BODY_ASSIGN__ASSIGNMENT = eINSTANCE.getVarBodyAssign_Assignment();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InitBodyImpl <em>Init Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InitBodyImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInitBody()
     * @generated
     */
    EClass INIT_BODY = eINSTANCE.getInitBody();

    /**
     * The meta object literal for the '<em><b>Init Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INIT_BODY__INIT_EXPR = eINSTANCE.getInitBody_InitExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.NextBodyImpl <em>Next Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NextBodyImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getNextBody()
     * @generated
     */
    EClass NEXT_BODY = eINSTANCE.getNextBody();

    /**
     * The meta object literal for the '<em><b>Next Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEXT_BODY__NEXT_EXPR = eINSTANCE.getNextBody_NextExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.TransConstraintImpl <em>Trans Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.TransConstraintImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getTransConstraint()
     * @generated
     */
    EClass TRANS_CONSTRAINT = eINSTANCE.getTransConstraint();

    /**
     * The meta object literal for the '<em><b>Trans Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANS_CONSTRAINT__TRANS_EXPR = eINSTANCE.getTransConstraint_TransExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InitConstraintImpl <em>Init Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InitConstraintImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInitConstraint()
     * @generated
     */
    EClass INIT_CONSTRAINT = eINSTANCE.getInitConstraint();

    /**
     * The meta object literal for the '<em><b>Init Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INIT_CONSTRAINT__INIT_EXPR = eINSTANCE.getInitConstraint_InitExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarConstraintImpl <em>Invar Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarConstraintImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInvarConstraint()
     * @generated
     */
    EClass INVAR_CONSTRAINT = eINSTANCE.getInvarConstraint();

    /**
     * The meta object literal for the '<em><b>Invar Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INVAR_CONSTRAINT__INVAR_EXPR = eINSTANCE.getInvarConstraint_InvarExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessConstraintImpl <em>Fairness Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessConstraintImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFairnessConstraint()
     * @generated
     */
    EClass FAIRNESS_CONSTRAINT = eINSTANCE.getFairnessConstraint();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessExpressionImpl <em>Fairness Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessExpressionImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFairnessExpression()
     * @generated
     */
    EClass FAIRNESS_EXPRESSION = eINSTANCE.getFairnessExpression();

    /**
     * The meta object literal for the '<em><b>Fairness Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAIRNESS_EXPRESSION__FAIRNESS_EXPR = eINSTANCE.getFairnessExpression_FairnessExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.JusticeExpressionImpl <em>Justice Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.JusticeExpressionImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getJusticeExpression()
     * @generated
     */
    EClass JUSTICE_EXPRESSION = eINSTANCE.getJusticeExpression();

    /**
     * The meta object literal for the '<em><b>Justice Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUSTICE_EXPRESSION__JUSTICE_EXPR = eINSTANCE.getJusticeExpression_JusticeExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CompassionExpressionImpl <em>Compassion Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.CompassionExpressionImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getCompassionExpression()
     * @generated
     */
    EClass COMPASSION_EXPRESSION = eINSTANCE.getCompassionExpression();

    /**
     * The meta object literal for the '<em><b>First Compassion Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR = eINSTANCE.getCompassionExpression_FirstCompassionExpr();

    /**
     * The meta object literal for the '<em><b>Second Compassion Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR = eINSTANCE.getCompassionExpression_SecondCompassionExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarSpecificationImpl <em>Invar Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarSpecificationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getInvarSpecification()
     * @generated
     */
    EClass INVAR_SPECIFICATION = eINSTANCE.getInvarSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INVAR_SPECIFICATION__NAME = eINSTANCE.getInvarSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Invar Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INVAR_SPECIFICATION__INVAR_EXPR = eINSTANCE.getInvarSpecification_InvarExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CtlSpecificationImpl <em>Ctl Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.CtlSpecificationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getCtlSpecification()
     * @generated
     */
    EClass CTL_SPECIFICATION = eINSTANCE.getCtlSpecification();

    /**
     * The meta object literal for the '<em><b>Name Key Word</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CTL_SPECIFICATION__NAME_KEY_WORD = eINSTANCE.getCtlSpecification_NameKeyWord();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CTL_SPECIFICATION__NAME = eINSTANCE.getCtlSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Ctl Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CTL_SPECIFICATION__CTL_EXPR = eINSTANCE.getCtlSpecification_CtlExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.LtlSpecificationImpl <em>Ltl Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.LtlSpecificationImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getLtlSpecification()
     * @generated
     */
    EClass LTL_SPECIFICATION = eINSTANCE.getLtlSpecification();

    /**
     * The meta object literal for the '<em><b>Name Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTL_SPECIFICATION__NAME_ID = eINSTANCE.getLtlSpecification_NameId();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTL_SPECIFICATION__NAME = eINSTANCE.getLtlSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Ltl Expr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LTL_SPECIFICATION__LTL_EXPR = eINSTANCE.getLtlSpecification_LtlExpr();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.TypeSpecifierImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getTypeSpecifier()
     * @generated
     */
    EClass TYPE_SPECIFIER = eINSTANCE.getTypeSpecifier();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.SimpleTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getSimpleType()
     * @generated
     */
    EClass SIMPLE_TYPE = eINSTANCE.getSimpleType();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleTypeImpl <em>Module Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ModuleTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getModuleType()
     * @generated
     */
    EClass MODULE_TYPE = eINSTANCE.getModuleType();

    /**
     * The meta object literal for the '<em><b>Module</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_TYPE__MODULE = eINSTANCE.getModuleType_Module();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE_TYPE__PARAMS = eINSTANCE.getModuleType_Params();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.FormalParameterImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getFormalParameter()
     * @generated
     */
    EClass FORMAL_PARAMETER = eINSTANCE.getFormalParameter();

    /**
     * The meta object literal for the '<em><b>Param Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORMAL_PARAMETER__PARAM_ID = eINSTANCE.getFormalParameter_ParamId();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.BooleanTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getBooleanType()
     * @generated
     */
    EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.WordTypeImpl <em>Word Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.WordTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getWordType()
     * @generated
     */
    EClass WORD_TYPE = eINSTANCE.getWordType();

    /**
     * The meta object literal for the '<em><b>Word Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORD_TYPE__WORD_NUMBER = eINSTANCE.getWordType_WordNumber();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.UnsignedWordTypeImpl <em>Unsigned Word Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.UnsignedWordTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getUnsignedWordType()
     * @generated
     */
    EClass UNSIGNED_WORD_TYPE = eINSTANCE.getUnsignedWordType();

    /**
     * The meta object literal for the '<em><b>UWord Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNSIGNED_WORD_TYPE__UWORD_NUMBER = eINSTANCE.getUnsignedWordType_UWordNumber();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.SignedWordTypeImpl <em>Signed Word Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.SignedWordTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getSignedWordType()
     * @generated
     */
    EClass SIGNED_WORD_TYPE = eINSTANCE.getSignedWordType();

    /**
     * The meta object literal for the '<em><b>Signed Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNED_WORD_TYPE__SIGNED_NUMBER = eINSTANCE.getSignedWordType_SignedNumber();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.EnumTypeImpl <em>Enum Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.EnumTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getEnumType()
     * @generated
     */
    EClass ENUM_TYPE = eINSTANCE.getEnumType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_TYPE__VALUE = eINSTANCE.getEnumType_Value();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.RangeTypeImpl <em>Range Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.RangeTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getRangeType()
     * @generated
     */
    EClass RANGE_TYPE = eINSTANCE.getRangeType();

    /**
     * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE_TYPE__LOW = eINSTANCE.getRangeType_Low();

    /**
     * The meta object literal for the '<em><b>High</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE_TYPE__HIGH = eINSTANCE.getRangeType_High();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ArrayTypeImpl <em>Array Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.ArrayTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getArrayType()
     * @generated
     */
    EClass ARRAY_TYPE = eINSTANCE.getArrayType();

    /**
     * The meta object literal for the '<em><b>Bounds</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARRAY_TYPE__BOUNDS = eINSTANCE.getArrayType_Bounds();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE__TYPE = eINSTANCE.getArrayType_Type();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.AsyncrProcessTypeImpl <em>Asyncr Process Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.AsyncrProcessTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getAsyncrProcessType()
     * @generated
     */
    EClass ASYNCR_PROCESS_TYPE = eINSTANCE.getAsyncrProcessType();

    /**
     * The meta object literal for the '{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.SyncrProcessTypeImpl <em>Syncr Process Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.SyncrProcessTypeImpl
     * @see reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangPackageImpl#getSyncrProcessType()
     * @generated
     */
    EClass SYNCR_PROCESS_TYPE = eINSTANCE.getSyncrProcessType();

  }

} //NuSmvLangPackage
