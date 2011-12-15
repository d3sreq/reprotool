package reprotool.fm.nusmv.lang.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import reprotool.fm.nusmv.lang.services.NuSmvLangGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractNuSmvLangSyntacticSequencer extends AbstractSyntacticSequencer {

	protected NuSmvLangGrammarAccess grammarAccess;
	protected AbstractElementAlias match_CompassionExpression_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_CtlSpecification_CTLSPECKeyword_0_0_or_SPECKeyword_0_1;
	protected AbstractElementAlias match_CtlSpecification_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_FairnessExpression_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_InitConstraint_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_InvarConstraint_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_InvarSpecification_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_JusticeExpression_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_LtlSpecification_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_TransConstraint_SemicolonKeyword_2_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (NuSmvLangGrammarAccess) access;
		match_CompassionExpression_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getCompassionExpressionAccess().getSemicolonKeyword_5());
		match_CtlSpecification_CTLSPECKeyword_0_0_or_SPECKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getCtlSpecificationAccess().getCTLSPECKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getCtlSpecificationAccess().getSPECKeyword_0_1()));
		match_CtlSpecification_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getCtlSpecificationAccess().getSemicolonKeyword_3());
		match_FairnessExpression_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getFairnessExpressionAccess().getSemicolonKeyword_2());
		match_InitConstraint_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getInitConstraintAccess().getSemicolonKeyword_2());
		match_InvarConstraint_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getInvarConstraintAccess().getSemicolonKeyword_2());
		match_InvarSpecification_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getInvarSpecificationAccess().getSemicolonKeyword_3());
		match_JusticeExpression_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getJusticeExpressionAccess().getSemicolonKeyword_2());
		match_LtlSpecification_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getLtlSpecificationAccess().getSemicolonKeyword_3());
		match_TransConstraint_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getTransConstraintAccess().getSemicolonKeyword_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_CompassionExpression_SemicolonKeyword_5_q.equals(syntax))
				emit_CompassionExpression_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CtlSpecification_CTLSPECKeyword_0_0_or_SPECKeyword_0_1.equals(syntax))
				emit_CtlSpecification_CTLSPECKeyword_0_0_or_SPECKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CtlSpecification_SemicolonKeyword_3_q.equals(syntax))
				emit_CtlSpecification_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FairnessExpression_SemicolonKeyword_2_q.equals(syntax))
				emit_FairnessExpression_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InitConstraint_SemicolonKeyword_2_q.equals(syntax))
				emit_InitConstraint_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InvarConstraint_SemicolonKeyword_2_q.equals(syntax))
				emit_InvarConstraint_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InvarSpecification_SemicolonKeyword_3_q.equals(syntax))
				emit_InvarSpecification_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_JusticeExpression_SemicolonKeyword_2_q.equals(syntax))
				emit_JusticeExpression_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LtlSpecification_SemicolonKeyword_3_q.equals(syntax))
				emit_LtlSpecification_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TransConstraint_SemicolonKeyword_2_q.equals(syntax))
				emit_TransConstraint_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_CompassionExpression_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'CTLSPEC' | 'SPEC'
	 */
	protected void emit_CtlSpecification_CTLSPECKeyword_0_0_or_SPECKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_CtlSpecification_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_FairnessExpression_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_InitConstraint_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_InvarConstraint_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_InvarSpecification_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_JusticeExpression_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_LtlSpecification_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_TransConstraint_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
