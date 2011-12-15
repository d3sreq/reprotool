/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import reprotool.fm.nusmv.lang.nuSmvLang.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage
 * @generated
 */
public class NuSmvLangAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static NuSmvLangPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NuSmvLangAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = NuSmvLangPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NuSmvLangSwitch<Adapter> modelSwitch =
    new NuSmvLangSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseModule(Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseMainModule(MainModule object)
      {
        return createMainModuleAdapter();
      }
      @Override
      public Adapter caseOtherModule(OtherModule object)
      {
        return createOtherModuleAdapter();
      }
      @Override
      public Adapter caseModuleElement(ModuleElement object)
      {
        return createModuleElementAdapter();
      }
      @Override
      public Adapter caseVariableDeclaration(VariableDeclaration object)
      {
        return createVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseIVariableDeclaration(IVariableDeclaration object)
      {
        return createIVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseFrozenVariableDeclaration(FrozenVariableDeclaration object)
      {
        return createFrozenVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseVarBody(VarBody object)
      {
        return createVarBodyAdapter();
      }
      @Override
      public Adapter caseDefineDeclaration(DefineDeclaration object)
      {
        return createDefineDeclarationAdapter();
      }
      @Override
      public Adapter caseDefineBody(DefineBody object)
      {
        return createDefineBodyAdapter();
      }
      @Override
      public Adapter caseConstantsDeclaration(ConstantsDeclaration object)
      {
        return createConstantsDeclarationAdapter();
      }
      @Override
      public Adapter caseAssignConstraint(AssignConstraint object)
      {
        return createAssignConstraintAdapter();
      }
      @Override
      public Adapter caseAssignBody(AssignBody object)
      {
        return createAssignBodyAdapter();
      }
      @Override
      public Adapter caseVarBodyAssign(VarBodyAssign object)
      {
        return createVarBodyAssignAdapter();
      }
      @Override
      public Adapter caseInitBody(InitBody object)
      {
        return createInitBodyAdapter();
      }
      @Override
      public Adapter caseNextBody(NextBody object)
      {
        return createNextBodyAdapter();
      }
      @Override
      public Adapter caseTransConstraint(TransConstraint object)
      {
        return createTransConstraintAdapter();
      }
      @Override
      public Adapter caseInitConstraint(InitConstraint object)
      {
        return createInitConstraintAdapter();
      }
      @Override
      public Adapter caseInvarConstraint(InvarConstraint object)
      {
        return createInvarConstraintAdapter();
      }
      @Override
      public Adapter caseFairnessConstraint(FairnessConstraint object)
      {
        return createFairnessConstraintAdapter();
      }
      @Override
      public Adapter caseFairnessExpression(FairnessExpression object)
      {
        return createFairnessExpressionAdapter();
      }
      @Override
      public Adapter caseJusticeExpression(JusticeExpression object)
      {
        return createJusticeExpressionAdapter();
      }
      @Override
      public Adapter caseCompassionExpression(CompassionExpression object)
      {
        return createCompassionExpressionAdapter();
      }
      @Override
      public Adapter caseInvarSpecification(InvarSpecification object)
      {
        return createInvarSpecificationAdapter();
      }
      @Override
      public Adapter caseCtlSpecification(CtlSpecification object)
      {
        return createCtlSpecificationAdapter();
      }
      @Override
      public Adapter caseLtlSpecification(LtlSpecification object)
      {
        return createLtlSpecificationAdapter();
      }
      @Override
      public Adapter caseTypeSpecifier(TypeSpecifier object)
      {
        return createTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseSimpleType(SimpleType object)
      {
        return createSimpleTypeAdapter();
      }
      @Override
      public Adapter caseModuleType(ModuleType object)
      {
        return createModuleTypeAdapter();
      }
      @Override
      public Adapter caseFormalParameter(FormalParameter object)
      {
        return createFormalParameterAdapter();
      }
      @Override
      public Adapter caseBooleanType(BooleanType object)
      {
        return createBooleanTypeAdapter();
      }
      @Override
      public Adapter caseWordType(WordType object)
      {
        return createWordTypeAdapter();
      }
      @Override
      public Adapter caseUnsignedWordType(UnsignedWordType object)
      {
        return createUnsignedWordTypeAdapter();
      }
      @Override
      public Adapter caseSignedWordType(SignedWordType object)
      {
        return createSignedWordTypeAdapter();
      }
      @Override
      public Adapter caseEnumType(EnumType object)
      {
        return createEnumTypeAdapter();
      }
      @Override
      public Adapter caseRangeType(RangeType object)
      {
        return createRangeTypeAdapter();
      }
      @Override
      public Adapter caseArrayType(ArrayType object)
      {
        return createArrayTypeAdapter();
      }
      @Override
      public Adapter caseAsyncrProcessType(AsyncrProcessType object)
      {
        return createAsyncrProcessTypeAdapter();
      }
      @Override
      public Adapter caseSyncrProcessType(SyncrProcessType object)
      {
        return createSyncrProcessTypeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.MainModule <em>Main Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.MainModule
   * @generated
   */
  public Adapter createMainModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.OtherModule <em>Other Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.OtherModule
   * @generated
   */
  public Adapter createOtherModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement <em>Module Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement
   * @generated
   */
  public Adapter createModuleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration
   * @generated
   */
  public Adapter createVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.IVariableDeclaration <em>IVariable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.IVariableDeclaration
   * @generated
   */
  public Adapter createIVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration <em>Frozen Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration
   * @generated
   */
  public Adapter createFrozenVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBody <em>Var Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VarBody
   * @generated
   */
  public Adapter createVarBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration <em>Define Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration
   * @generated
   */
  public Adapter createDefineDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.DefineBody <em>Define Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.DefineBody
   * @generated
   */
  public Adapter createDefineBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration <em>Constants Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration
   * @generated
   */
  public Adapter createConstantsDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint <em>Assign Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint
   * @generated
   */
  public Adapter createAssignConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.AssignBody <em>Assign Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AssignBody
   * @generated
   */
  public Adapter createAssignBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign <em>Var Body Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign
   * @generated
   */
  public Adapter createVarBodyAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InitBody <em>Init Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InitBody
   * @generated
   */
  public Adapter createInitBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.NextBody <em>Next Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.NextBody
   * @generated
   */
  public Adapter createNextBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint <em>Trans Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint
   * @generated
   */
  public Adapter createTransConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint <em>Init Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint
   * @generated
   */
  public Adapter createInitConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint <em>Invar Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InvarConstraint
   * @generated
   */
  public Adapter createInvarConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FairnessConstraint <em>Fairness Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FairnessConstraint
   * @generated
   */
  public Adapter createFairnessConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression <em>Fairness Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression
   * @generated
   */
  public Adapter createFairnessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression <em>Justice Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression
   * @generated
   */
  public Adapter createJusticeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression <em>Compassion Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression
   * @generated
   */
  public Adapter createCompassionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification <em>Invar Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification
   * @generated
   */
  public Adapter createInvarSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification <em>Ctl Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification
   * @generated
   */
  public Adapter createCtlSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification <em>Ltl Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification
   * @generated
   */
  public Adapter createLtlSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.TypeSpecifier <em>Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.TypeSpecifier
   * @generated
   */
  public Adapter createTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.SimpleType <em>Simple Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.SimpleType
   * @generated
   */
  public Adapter createSimpleTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ModuleType <em>Module Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ModuleType
   * @generated
   */
  public Adapter createModuleTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter
   * @generated
   */
  public Adapter createFormalParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.BooleanType
   * @generated
   */
  public Adapter createBooleanTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.WordType <em>Word Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.WordType
   * @generated
   */
  public Adapter createWordTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType <em>Unsigned Word Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType
   * @generated
   */
  public Adapter createUnsignedWordTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType <em>Signed Word Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType
   * @generated
   */
  public Adapter createSignedWordTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.EnumType
   * @generated
   */
  public Adapter createEnumTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.RangeType <em>Range Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.RangeType
   * @generated
   */
  public Adapter createRangeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.ArrayType <em>Array Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.ArrayType
   * @generated
   */
  public Adapter createArrayTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.AsyncrProcessType <em>Asyncr Process Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.AsyncrProcessType
   * @generated
   */
  public Adapter createAsyncrProcessTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType <em>Syncr Process Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType
   * @generated
   */
  public Adapter createSyncrProcessTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //NuSmvLangAdapterFactory
