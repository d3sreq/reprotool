/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage
 * @generated
 */
public interface NuSmvLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NuSmvLangFactory eINSTANCE = reprotool.fm.nusmv.lang.nuSmvLang.impl.NuSmvLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Main Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Main Module</em>'.
   * @generated
   */
  MainModule createMainModule();

  /**
   * Returns a new object of class '<em>Other Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Other Module</em>'.
   * @generated
   */
  OtherModule createOtherModule();

  /**
   * Returns a new object of class '<em>Module Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Element</em>'.
   * @generated
   */
  ModuleElement createModuleElement();

  /**
   * Returns a new object of class '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Declaration</em>'.
   * @generated
   */
  VariableDeclaration createVariableDeclaration();

  /**
   * Returns a new object of class '<em>IVariable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IVariable Declaration</em>'.
   * @generated
   */
  IVariableDeclaration createIVariableDeclaration();

  /**
   * Returns a new object of class '<em>Frozen Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Frozen Variable Declaration</em>'.
   * @generated
   */
  FrozenVariableDeclaration createFrozenVariableDeclaration();

  /**
   * Returns a new object of class '<em>Var Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Body</em>'.
   * @generated
   */
  VarBody createVarBody();

  /**
   * Returns a new object of class '<em>Define Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Declaration</em>'.
   * @generated
   */
  DefineDeclaration createDefineDeclaration();

  /**
   * Returns a new object of class '<em>Define Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Body</em>'.
   * @generated
   */
  DefineBody createDefineBody();

  /**
   * Returns a new object of class '<em>Constants Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constants Declaration</em>'.
   * @generated
   */
  ConstantsDeclaration createConstantsDeclaration();

  /**
   * Returns a new object of class '<em>Assign Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assign Constraint</em>'.
   * @generated
   */
  AssignConstraint createAssignConstraint();

  /**
   * Returns a new object of class '<em>Assign Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assign Body</em>'.
   * @generated
   */
  AssignBody createAssignBody();

  /**
   * Returns a new object of class '<em>Var Body Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Body Assign</em>'.
   * @generated
   */
  VarBodyAssign createVarBodyAssign();

  /**
   * Returns a new object of class '<em>Init Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Init Body</em>'.
   * @generated
   */
  InitBody createInitBody();

  /**
   * Returns a new object of class '<em>Next Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Next Body</em>'.
   * @generated
   */
  NextBody createNextBody();

  /**
   * Returns a new object of class '<em>Trans Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trans Constraint</em>'.
   * @generated
   */
  TransConstraint createTransConstraint();

  /**
   * Returns a new object of class '<em>Init Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Init Constraint</em>'.
   * @generated
   */
  InitConstraint createInitConstraint();

  /**
   * Returns a new object of class '<em>Invar Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invar Constraint</em>'.
   * @generated
   */
  InvarConstraint createInvarConstraint();

  /**
   * Returns a new object of class '<em>Fairness Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fairness Constraint</em>'.
   * @generated
   */
  FairnessConstraint createFairnessConstraint();

  /**
   * Returns a new object of class '<em>Fairness Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fairness Expression</em>'.
   * @generated
   */
  FairnessExpression createFairnessExpression();

  /**
   * Returns a new object of class '<em>Justice Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Justice Expression</em>'.
   * @generated
   */
  JusticeExpression createJusticeExpression();

  /**
   * Returns a new object of class '<em>Compassion Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compassion Expression</em>'.
   * @generated
   */
  CompassionExpression createCompassionExpression();

  /**
   * Returns a new object of class '<em>Invar Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invar Specification</em>'.
   * @generated
   */
  InvarSpecification createInvarSpecification();

  /**
   * Returns a new object of class '<em>Ctl Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ctl Specification</em>'.
   * @generated
   */
  CtlSpecification createCtlSpecification();

  /**
   * Returns a new object of class '<em>Ltl Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ltl Specification</em>'.
   * @generated
   */
  LtlSpecification createLtlSpecification();

  /**
   * Returns a new object of class '<em>Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Specifier</em>'.
   * @generated
   */
  TypeSpecifier createTypeSpecifier();

  /**
   * Returns a new object of class '<em>Simple Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Type</em>'.
   * @generated
   */
  SimpleType createSimpleType();

  /**
   * Returns a new object of class '<em>Module Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Type</em>'.
   * @generated
   */
  ModuleType createModuleType();

  /**
   * Returns a new object of class '<em>Formal Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameter</em>'.
   * @generated
   */
  FormalParameter createFormalParameter();

  /**
   * Returns a new object of class '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Type</em>'.
   * @generated
   */
  BooleanType createBooleanType();

  /**
   * Returns a new object of class '<em>Word Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word Type</em>'.
   * @generated
   */
  WordType createWordType();

  /**
   * Returns a new object of class '<em>Unsigned Word Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unsigned Word Type</em>'.
   * @generated
   */
  UnsignedWordType createUnsignedWordType();

  /**
   * Returns a new object of class '<em>Signed Word Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signed Word Type</em>'.
   * @generated
   */
  SignedWordType createSignedWordType();

  /**
   * Returns a new object of class '<em>Enum Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Type</em>'.
   * @generated
   */
  EnumType createEnumType();

  /**
   * Returns a new object of class '<em>Range Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range Type</em>'.
   * @generated
   */
  RangeType createRangeType();

  /**
   * Returns a new object of class '<em>Array Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Type</em>'.
   * @generated
   */
  ArrayType createArrayType();

  /**
   * Returns a new object of class '<em>Asyncr Process Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asyncr Process Type</em>'.
   * @generated
   */
  AsyncrProcessType createAsyncrProcessType();

  /**
   * Returns a new object of class '<em>Syncr Process Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Syncr Process Type</em>'.
   * @generated
   */
  SyncrProcessType createSyncrProcessType();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  NuSmvLangPackage getNuSmvLangPackage();

} //NuSmvLangFactory
