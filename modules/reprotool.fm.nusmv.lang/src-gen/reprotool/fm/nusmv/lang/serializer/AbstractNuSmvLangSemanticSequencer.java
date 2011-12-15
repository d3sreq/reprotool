package reprotool.fm.nusmv.lang.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import reprotool.fm.nusmv.lang.nuSmvLang.ArrayType;
import reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.AsyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvLang.BooleanType;
import reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.DefineBody;
import reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.EnumType;
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
import reprotool.fm.nusmv.lang.nuSmvLang.NextBody;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;
import reprotool.fm.nusmv.lang.nuSmvLang.OtherModule;
import reprotool.fm.nusmv.lang.nuSmvLang.RangeType;
import reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType;
import reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.UnsignedWordType;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBody;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign;
import reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.WordType;
import reprotool.fm.nusmv.lang.services.NuSmvLangGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractNuSmvLangSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected NuSmvLangGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == NuSmvLangPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case NuSmvLangPackage.ARRAY_TYPE:
				if(context == grammarAccess.getSimpleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_SimpleType(context, (ArrayType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.ASSIGN_CONSTRAINT:
				if(context == grammarAccess.getAssignConstraintRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_AssignConstraint(context, (AssignConstraint) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.ASYNCR_PROCESS_TYPE:
				if(context == grammarAccess.getModuleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_ModuleType(context, (AsyncrProcessType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.BOOLEAN_TYPE:
				if(context == grammarAccess.getSimpleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_TypeSpecifier(context, (BooleanType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.COMPASSION_EXPRESSION:
				if(context == grammarAccess.getCompassionExpressionRule() ||
				   context == grammarAccess.getFairnessConstraintRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_CompassionExpression(context, (CompassionExpression) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.CONSTANTS_DECLARATION:
				if(context == grammarAccess.getConstantsDeclarationRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_ConstantsDeclaration(context, (ConstantsDeclaration) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.CTL_SPECIFICATION:
				if(context == grammarAccess.getCtlSpecificationRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_CtlSpecification(context, (CtlSpecification) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.DEFINE_BODY:
				if(context == grammarAccess.getDefineBodyRule()) {
					sequence_DefineBody(context, (DefineBody) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.DEFINE_DECLARATION:
				if(context == grammarAccess.getDefineDeclarationRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_DefineDeclaration(context, (DefineDeclaration) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.ENUM_TYPE:
				if(context == grammarAccess.getSimpleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_SimpleType(context, (EnumType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.FAIRNESS_EXPRESSION:
				if(context == grammarAccess.getFairnessConstraintRule() ||
				   context == grammarAccess.getFairnessExpressionRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_FairnessExpression(context, (FairnessExpression) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.FORMAL_PARAMETER:
				if(context == grammarAccess.getFormalParameterRule()) {
					sequence_FormalParameter(context, (FormalParameter) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION:
				if(context == grammarAccess.getFrozenVariableDeclarationRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_FrozenVariableDeclaration(context, (FrozenVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.IVARIABLE_DECLARATION:
				if(context == grammarAccess.getIVariableDeclarationRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_IVariableDeclaration(context, (IVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.INIT_BODY:
				if(context == grammarAccess.getAssignBodyRule() ||
				   context == grammarAccess.getInitBodyRule()) {
					sequence_InitBody(context, (InitBody) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.INIT_CONSTRAINT:
				if(context == grammarAccess.getInitConstraintRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_InitConstraint(context, (InitConstraint) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.INVAR_CONSTRAINT:
				if(context == grammarAccess.getInvarConstraintRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_InvarConstraint(context, (InvarConstraint) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.INVAR_SPECIFICATION:
				if(context == grammarAccess.getInvarSpecificationRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_InvarSpecification(context, (InvarSpecification) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.JUSTICE_EXPRESSION:
				if(context == grammarAccess.getFairnessConstraintRule() ||
				   context == grammarAccess.getJusticeExpressionRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_JusticeExpression(context, (JusticeExpression) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.LTL_SPECIFICATION:
				if(context == grammarAccess.getLtlSpecificationRule() ||
				   context == grammarAccess.getModuleElementRule()) {
					sequence_LtlSpecification(context, (LtlSpecification) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.MAIN_MODULE:
				if(context == grammarAccess.getMainModuleRule()) {
					sequence_MainModule(context, (MainModule) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getModuleRule()) {
					sequence_Module(context, (MainModule) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.NEXT_BODY:
				if(context == grammarAccess.getAssignBodyRule() ||
				   context == grammarAccess.getNextBodyRule()) {
					sequence_NextBody(context, (NextBody) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.OTHER_MODULE:
				if(context == grammarAccess.getModuleRule()) {
					sequence_Module(context, (OtherModule) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOtherModuleRule()) {
					sequence_OtherModule(context, (OtherModule) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.RANGE_TYPE:
				if(context == grammarAccess.getSimpleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_SimpleType(context, (RangeType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.SIGNED_WORD_TYPE:
				if(context == grammarAccess.getSimpleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_SimpleType(context, (SignedWordType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.SYNCR_PROCESS_TYPE:
				if(context == grammarAccess.getModuleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_ModuleType(context, (SyncrProcessType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.TRANS_CONSTRAINT:
				if(context == grammarAccess.getModuleElementRule() ||
				   context == grammarAccess.getTransConstraintRule()) {
					sequence_TransConstraint(context, (TransConstraint) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.UNSIGNED_WORD_TYPE:
				if(context == grammarAccess.getSimpleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_SimpleType(context, (UnsignedWordType) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.VAR_BODY:
				if(context == grammarAccess.getVarBodyRule()) {
					sequence_VarBody(context, (VarBody) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.VAR_BODY_ASSIGN:
				if(context == grammarAccess.getAssignBodyRule() ||
				   context == grammarAccess.getVarBodyAssignRule()) {
					sequence_VarBodyAssign(context, (VarBodyAssign) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.VARIABLE_DECLARATION:
				if(context == grammarAccess.getModuleElementRule() ||
				   context == grammarAccess.getVariableDeclarationRule()) {
					sequence_VariableDeclaration(context, (VariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case NuSmvLangPackage.WORD_TYPE:
				if(context == grammarAccess.getSimpleTypeRule() ||
				   context == grammarAccess.getTypeSpecifierRule()) {
					sequence_SimpleType(context, (WordType) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     bodies+=AssignBody+
	 */
	protected void sequence_AssignConstraint(EObject context, AssignConstraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (firstCompassionExpr=SimpleExpression secondCompassionExpr=SimpleExpression)
	 */
	protected void sequence_CompassionExpression(EObject context, CompassionExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCompassionExpressionAccess().getFirstCompassionExprSimpleExpressionParserRuleCall_1_0(), semanticObject.getFirstCompassionExpr());
		feeder.accept(grammarAccess.getCompassionExpressionAccess().getSecondCompassionExprSimpleExpressionParserRuleCall_3_0(), semanticObject.getSecondCompassionExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (constants+=ID constants+=ID*)
	 */
	protected void sequence_ConstantsDeclaration(EObject context, ConstantsDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((nameKeyWord?='NAME' name=ID)? ctlExpr=SimpleExpression)
	 */
	protected void sequence_CtlSpecification(EObject context, CtlSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (varId=ID assignment=SimpleExpression)
	 */
	protected void sequence_DefineBody(EObject context, DefineBody semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.DEFINE_BODY__VAR_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.DEFINE_BODY__VAR_ID));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.DEFINE_BODY__ASSIGNMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.DEFINE_BODY__ASSIGNMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDefineBodyAccess().getVarIdIDTerminalRuleCall_0_0(), semanticObject.getVarId());
		feeder.accept(grammarAccess.getDefineBodyAccess().getAssignmentSimpleExpressionParserRuleCall_2_0(), semanticObject.getAssignment());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     defineBodies+=DefineBody+
	 */
	protected void sequence_DefineDeclaration(EObject context, DefineDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     fairnessExpr=SimpleExpression
	 */
	protected void sequence_FairnessExpression(EObject context, FairnessExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.FAIRNESS_EXPRESSION__FAIRNESS_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.FAIRNESS_EXPRESSION__FAIRNESS_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFairnessExpressionAccess().getFairnessExprSimpleExpressionParserRuleCall_1_0(), semanticObject.getFairnessExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     paramId=ID
	 */
	protected void sequence_FormalParameter(EObject context, FormalParameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.FORMAL_PARAMETER__PARAM_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.FORMAL_PARAMETER__PARAM_ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFormalParameterAccess().getParamIdIDTerminalRuleCall_0(), semanticObject.getParamId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     vars+=VarBody+
	 */
	protected void sequence_FrozenVariableDeclaration(EObject context, FrozenVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     vars+=VarBody+
	 */
	protected void sequence_IVariableDeclaration(EObject context, IVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (varId=VariableIdentifier initExpr=SimpleExpression)
	 */
	protected void sequence_InitBody(EObject context, InitBody semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.ASSIGN_BODY__VAR_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.ASSIGN_BODY__VAR_ID));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.INIT_BODY__INIT_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.INIT_BODY__INIT_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInitBodyAccess().getVarIdVariableIdentifierParserRuleCall_2_0(), semanticObject.getVarId());
		feeder.accept(grammarAccess.getInitBodyAccess().getInitExprSimpleExpressionParserRuleCall_5_0(), semanticObject.getInitExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     initExpr=SimpleExpression
	 */
	protected void sequence_InitConstraint(EObject context, InitConstraint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.INIT_CONSTRAINT__INIT_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.INIT_CONSTRAINT__INIT_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInitConstraintAccess().getInitExprSimpleExpressionParserRuleCall_1_0(), semanticObject.getInitExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     invarExpr=SimpleExpression
	 */
	protected void sequence_InvarConstraint(EObject context, InvarConstraint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.INVAR_CONSTRAINT__INVAR_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.INVAR_CONSTRAINT__INVAR_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInvarConstraintAccess().getInvarExprSimpleExpressionParserRuleCall_1_0(), semanticObject.getInvarExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? invarExpr=SimpleExpression)
	 */
	protected void sequence_InvarSpecification(EObject context, InvarSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     justiceExpr=SimpleExpression
	 */
	protected void sequence_JusticeExpression(EObject context, JusticeExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.JUSTICE_EXPRESSION__JUSTICE_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.JUSTICE_EXPRESSION__JUSTICE_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJusticeExpressionAccess().getJusticeExprSimpleExpressionParserRuleCall_1_0(), semanticObject.getJusticeExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((nameId?='NAME' name=ID)? ltlExpr=SimpleExpression)
	 */
	protected void sequence_LtlSpecification(EObject context, LtlSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name='main'
	 */
	protected void sequence_MainModule(EObject context, MainModule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     modules+=Module*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (module=[Module|ID] (params+=SimpleExpression params+=SimpleExpression*)?)
	 */
	protected void sequence_ModuleType(EObject context, AsyncrProcessType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (module=[Module|ID] (params+=SimpleExpression params+=SimpleExpression*)?)
	 */
	protected void sequence_ModuleType(EObject context, SyncrProcessType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='main' moduleElement+=ModuleElement*)
	 */
	protected void sequence_Module(EObject context, MainModule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (params+=FormalParameter params+=FormalParameter*)? moduleElement+=ModuleElement*)
	 */
	protected void sequence_Module(EObject context, OtherModule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (varId=VariableIdentifier nextExpr=SimpleExpression)
	 */
	protected void sequence_NextBody(EObject context, NextBody semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.ASSIGN_BODY__VAR_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.ASSIGN_BODY__VAR_ID));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.NEXT_BODY__NEXT_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.NEXT_BODY__NEXT_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNextBodyAccess().getVarIdVariableIdentifierParserRuleCall_2_0(), semanticObject.getVarId());
		feeder.accept(grammarAccess.getNextBodyAccess().getNextExprSimpleExpressionParserRuleCall_5_0(), semanticObject.getNextExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (params+=FormalParameter params+=FormalParameter*)?)
	 */
	protected void sequence_OtherModule(EObject context, OtherModule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bounds=Range type=SimpleType)
	 */
	protected void sequence_SimpleType(EObject context, ArrayType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.ARRAY_TYPE__BOUNDS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.ARRAY_TYPE__BOUNDS));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.ARRAY_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.ARRAY_TYPE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleTypeAccess().getBoundsRangeParserRuleCall_6_2_0(), semanticObject.getBounds());
		feeder.accept(grammarAccess.getSimpleTypeAccess().getTypeSimpleTypeParserRuleCall_6_4_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value+=Val value+=Val*)
	 */
	protected void sequence_SimpleType(EObject context, EnumType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (low=NUMBER high=NUMBER)
	 */
	protected void sequence_SimpleType(EObject context, RangeType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.RANGE_TYPE__LOW) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.RANGE_TYPE__LOW));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.RANGE_TYPE__HIGH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.RANGE_TYPE__HIGH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleTypeAccess().getLowNUMBERTerminalRuleCall_5_1_0(), semanticObject.getLow());
		feeder.accept(grammarAccess.getSimpleTypeAccess().getHighNUMBERTerminalRuleCall_5_3_0(), semanticObject.getHigh());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     signedNumber=NUMBER
	 */
	protected void sequence_SimpleType(EObject context, SignedWordType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.SIGNED_WORD_TYPE__SIGNED_NUMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.SIGNED_WORD_TYPE__SIGNED_NUMBER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleTypeAccess().getSignedNumberNUMBERTerminalRuleCall_3_1_2_0(), semanticObject.getSignedNumber());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     uWordNumber=NUMBER
	 */
	protected void sequence_SimpleType(EObject context, UnsignedWordType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.UNSIGNED_WORD_TYPE__UWORD_NUMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.UNSIGNED_WORD_TYPE__UWORD_NUMBER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleTypeAccess().getUWordNumberNUMBERTerminalRuleCall_2_1_3_0(), semanticObject.getUWordNumber());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     wordNumber=NUMBER
	 */
	protected void sequence_SimpleType(EObject context, WordType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.WORD_TYPE__WORD_NUMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.WORD_TYPE__WORD_NUMBER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleTypeAccess().getWordNumberNUMBERTerminalRuleCall_1_1_2_0(), semanticObject.getWordNumber());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     transExpr=SimpleExpression
	 */
	protected void sequence_TransConstraint(EObject context, TransConstraint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.TRANS_CONSTRAINT__TRANS_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.TRANS_CONSTRAINT__TRANS_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTransConstraintAccess().getTransExprSimpleExpressionParserRuleCall_1_0(), semanticObject.getTransExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {BooleanType}
	 */
	protected void sequence_TypeSpecifier(EObject context, BooleanType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (varId=VariableIdentifier assignment=SimpleExpression)
	 */
	protected void sequence_VarBodyAssign(EObject context, VarBodyAssign semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.ASSIGN_BODY__VAR_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.ASSIGN_BODY__VAR_ID));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.VAR_BODY_ASSIGN__ASSIGNMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.VAR_BODY_ASSIGN__ASSIGNMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVarBodyAssignAccess().getVarIdVariableIdentifierParserRuleCall_0_0(), semanticObject.getVarId());
		feeder.accept(grammarAccess.getVarBodyAssignAccess().getAssignmentSimpleExpressionParserRuleCall_2_0(), semanticObject.getAssignment());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (varId=ID type=TypeSpecifier)
	 */
	protected void sequence_VarBody(EObject context, VarBody semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.VAR_BODY__VAR_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.VAR_BODY__VAR_ID));
			if(transientValues.isValueTransient(semanticObject, NuSmvLangPackage.Literals.VAR_BODY__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NuSmvLangPackage.Literals.VAR_BODY__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVarBodyAccess().getVarIdIDTerminalRuleCall_0_0(), semanticObject.getVarId());
		feeder.accept(grammarAccess.getVarBodyAccess().getTypeTypeSpecifierParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     vars+=VarBody+
	 */
	protected void sequence_VariableDeclaration(EObject context, VariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
