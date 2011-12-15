/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import reprotool.fm.nusmv.lang.nuSmvLang.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage
 * @generated
 */
public class NuSmvLangSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static NuSmvLangPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NuSmvLangSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = NuSmvLangPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case NuSmvLangPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.MAIN_MODULE:
      {
        MainModule mainModule = (MainModule)theEObject;
        T result = caseMainModule(mainModule);
        if (result == null) result = caseModule(mainModule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.OTHER_MODULE:
      {
        OtherModule otherModule = (OtherModule)theEObject;
        T result = caseOtherModule(otherModule);
        if (result == null) result = caseModule(otherModule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.MODULE_ELEMENT:
      {
        ModuleElement moduleElement = (ModuleElement)theEObject;
        T result = caseModuleElement(moduleElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.VARIABLE_DECLARATION:
      {
        VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
        T result = caseVariableDeclaration(variableDeclaration);
        if (result == null) result = caseModuleElement(variableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.IVARIABLE_DECLARATION:
      {
        IVariableDeclaration iVariableDeclaration = (IVariableDeclaration)theEObject;
        T result = caseIVariableDeclaration(iVariableDeclaration);
        if (result == null) result = caseModuleElement(iVariableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION:
      {
        FrozenVariableDeclaration frozenVariableDeclaration = (FrozenVariableDeclaration)theEObject;
        T result = caseFrozenVariableDeclaration(frozenVariableDeclaration);
        if (result == null) result = caseModuleElement(frozenVariableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.VAR_BODY:
      {
        VarBody varBody = (VarBody)theEObject;
        T result = caseVarBody(varBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.DEFINE_DECLARATION:
      {
        DefineDeclaration defineDeclaration = (DefineDeclaration)theEObject;
        T result = caseDefineDeclaration(defineDeclaration);
        if (result == null) result = caseModuleElement(defineDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.DEFINE_BODY:
      {
        DefineBody defineBody = (DefineBody)theEObject;
        T result = caseDefineBody(defineBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.CONSTANTS_DECLARATION:
      {
        ConstantsDeclaration constantsDeclaration = (ConstantsDeclaration)theEObject;
        T result = caseConstantsDeclaration(constantsDeclaration);
        if (result == null) result = caseModuleElement(constantsDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.ASSIGN_CONSTRAINT:
      {
        AssignConstraint assignConstraint = (AssignConstraint)theEObject;
        T result = caseAssignConstraint(assignConstraint);
        if (result == null) result = caseModuleElement(assignConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.ASSIGN_BODY:
      {
        AssignBody assignBody = (AssignBody)theEObject;
        T result = caseAssignBody(assignBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.VAR_BODY_ASSIGN:
      {
        VarBodyAssign varBodyAssign = (VarBodyAssign)theEObject;
        T result = caseVarBodyAssign(varBodyAssign);
        if (result == null) result = caseAssignBody(varBodyAssign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.INIT_BODY:
      {
        InitBody initBody = (InitBody)theEObject;
        T result = caseInitBody(initBody);
        if (result == null) result = caseAssignBody(initBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.NEXT_BODY:
      {
        NextBody nextBody = (NextBody)theEObject;
        T result = caseNextBody(nextBody);
        if (result == null) result = caseAssignBody(nextBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.TRANS_CONSTRAINT:
      {
        TransConstraint transConstraint = (TransConstraint)theEObject;
        T result = caseTransConstraint(transConstraint);
        if (result == null) result = caseModuleElement(transConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.INIT_CONSTRAINT:
      {
        InitConstraint initConstraint = (InitConstraint)theEObject;
        T result = caseInitConstraint(initConstraint);
        if (result == null) result = caseModuleElement(initConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.INVAR_CONSTRAINT:
      {
        InvarConstraint invarConstraint = (InvarConstraint)theEObject;
        T result = caseInvarConstraint(invarConstraint);
        if (result == null) result = caseModuleElement(invarConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.FAIRNESS_CONSTRAINT:
      {
        FairnessConstraint fairnessConstraint = (FairnessConstraint)theEObject;
        T result = caseFairnessConstraint(fairnessConstraint);
        if (result == null) result = caseModuleElement(fairnessConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.FAIRNESS_EXPRESSION:
      {
        FairnessExpression fairnessExpression = (FairnessExpression)theEObject;
        T result = caseFairnessExpression(fairnessExpression);
        if (result == null) result = caseFairnessConstraint(fairnessExpression);
        if (result == null) result = caseModuleElement(fairnessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.JUSTICE_EXPRESSION:
      {
        JusticeExpression justiceExpression = (JusticeExpression)theEObject;
        T result = caseJusticeExpression(justiceExpression);
        if (result == null) result = caseFairnessConstraint(justiceExpression);
        if (result == null) result = caseModuleElement(justiceExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.COMPASSION_EXPRESSION:
      {
        CompassionExpression compassionExpression = (CompassionExpression)theEObject;
        T result = caseCompassionExpression(compassionExpression);
        if (result == null) result = caseFairnessConstraint(compassionExpression);
        if (result == null) result = caseModuleElement(compassionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.INVAR_SPECIFICATION:
      {
        InvarSpecification invarSpecification = (InvarSpecification)theEObject;
        T result = caseInvarSpecification(invarSpecification);
        if (result == null) result = caseModuleElement(invarSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.CTL_SPECIFICATION:
      {
        CtlSpecification ctlSpecification = (CtlSpecification)theEObject;
        T result = caseCtlSpecification(ctlSpecification);
        if (result == null) result = caseModuleElement(ctlSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.LTL_SPECIFICATION:
      {
        LtlSpecification ltlSpecification = (LtlSpecification)theEObject;
        T result = caseLtlSpecification(ltlSpecification);
        if (result == null) result = caseModuleElement(ltlSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.TYPE_SPECIFIER:
      {
        TypeSpecifier typeSpecifier = (TypeSpecifier)theEObject;
        T result = caseTypeSpecifier(typeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.SIMPLE_TYPE:
      {
        SimpleType simpleType = (SimpleType)theEObject;
        T result = caseSimpleType(simpleType);
        if (result == null) result = caseTypeSpecifier(simpleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.MODULE_TYPE:
      {
        ModuleType moduleType = (ModuleType)theEObject;
        T result = caseModuleType(moduleType);
        if (result == null) result = caseTypeSpecifier(moduleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.FORMAL_PARAMETER:
      {
        FormalParameter formalParameter = (FormalParameter)theEObject;
        T result = caseFormalParameter(formalParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.BOOLEAN_TYPE:
      {
        BooleanType booleanType = (BooleanType)theEObject;
        T result = caseBooleanType(booleanType);
        if (result == null) result = caseSimpleType(booleanType);
        if (result == null) result = caseTypeSpecifier(booleanType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.WORD_TYPE:
      {
        WordType wordType = (WordType)theEObject;
        T result = caseWordType(wordType);
        if (result == null) result = caseSimpleType(wordType);
        if (result == null) result = caseTypeSpecifier(wordType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.UNSIGNED_WORD_TYPE:
      {
        UnsignedWordType unsignedWordType = (UnsignedWordType)theEObject;
        T result = caseUnsignedWordType(unsignedWordType);
        if (result == null) result = caseSimpleType(unsignedWordType);
        if (result == null) result = caseTypeSpecifier(unsignedWordType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.SIGNED_WORD_TYPE:
      {
        SignedWordType signedWordType = (SignedWordType)theEObject;
        T result = caseSignedWordType(signedWordType);
        if (result == null) result = caseSimpleType(signedWordType);
        if (result == null) result = caseTypeSpecifier(signedWordType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.ENUM_TYPE:
      {
        EnumType enumType = (EnumType)theEObject;
        T result = caseEnumType(enumType);
        if (result == null) result = caseSimpleType(enumType);
        if (result == null) result = caseTypeSpecifier(enumType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.RANGE_TYPE:
      {
        RangeType rangeType = (RangeType)theEObject;
        T result = caseRangeType(rangeType);
        if (result == null) result = caseSimpleType(rangeType);
        if (result == null) result = caseTypeSpecifier(rangeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.ARRAY_TYPE:
      {
        ArrayType arrayType = (ArrayType)theEObject;
        T result = caseArrayType(arrayType);
        if (result == null) result = caseSimpleType(arrayType);
        if (result == null) result = caseTypeSpecifier(arrayType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.ASYNCR_PROCESS_TYPE:
      {
        AsyncrProcessType asyncrProcessType = (AsyncrProcessType)theEObject;
        T result = caseAsyncrProcessType(asyncrProcessType);
        if (result == null) result = caseModuleType(asyncrProcessType);
        if (result == null) result = caseTypeSpecifier(asyncrProcessType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NuSmvLangPackage.SYNCR_PROCESS_TYPE:
      {
        SyncrProcessType syncrProcessType = (SyncrProcessType)theEObject;
        T result = caseSyncrProcessType(syncrProcessType);
        if (result == null) result = caseModuleType(syncrProcessType);
        if (result == null) result = caseTypeSpecifier(syncrProcessType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModule(Module object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Main Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Main Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMainModule(MainModule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Other Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Other Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOtherModule(OtherModule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleElement(ModuleElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDeclaration(VariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IVariable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IVariable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIVariableDeclaration(IVariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Frozen Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Frozen Variable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFrozenVariableDeclaration(FrozenVariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarBody(VarBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Define Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Define Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefineDeclaration(DefineDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Define Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Define Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefineBody(DefineBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constants Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constants Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantsDeclaration(ConstantsDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assign Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assign Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignConstraint(AssignConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assign Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assign Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignBody(AssignBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Body Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Body Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarBodyAssign(VarBodyAssign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitBody(InitBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Next Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Next Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNextBody(NextBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trans Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trans Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransConstraint(TransConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitConstraint(InitConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invar Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invar Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvarConstraint(InvarConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fairness Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fairness Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFairnessConstraint(FairnessConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fairness Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fairness Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFairnessExpression(FairnessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Justice Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Justice Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJusticeExpression(JusticeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compassion Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compassion Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompassionExpression(CompassionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invar Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invar Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvarSpecification(InvarSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ctl Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ctl Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCtlSpecification(CtlSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ltl Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ltl Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLtlSpecification(LtlSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeSpecifier(TypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleType(SimpleType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleType(ModuleType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalParameter(FormalParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanType(BooleanType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Word Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Word Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWordType(WordType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unsigned Word Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unsigned Word Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnsignedWordType(UnsignedWordType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signed Word Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signed Word Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignedWordType(SignedWordType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumType(EnumType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRangeType(RangeType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayType(ArrayType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asyncr Process Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asyncr Process Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAsyncrProcessType(AsyncrProcessType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Syncr Process Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Syncr Process Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSyncrProcessType(SyncrProcessType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //NuSmvLangSwitch
