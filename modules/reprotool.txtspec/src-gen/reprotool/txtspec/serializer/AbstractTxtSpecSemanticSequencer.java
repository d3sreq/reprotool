package reprotool.txtspec.serializer;

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
import reprotool.txtspec.services.TxtSpecGrammarAccess;
import reprotool.txtspec.txtSpec.Document;
import reprotool.txtspec.txtSpec.ModelElementBlock;
import reprotool.txtspec.txtSpec.ModelElementBlockContent;
import reprotool.txtspec.txtSpec.TextBlock;
import reprotool.txtspec.txtSpec.TxtSpecPackage;

@SuppressWarnings("restriction")
public class AbstractTxtSpecSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected TxtSpecGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == TxtSpecPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TxtSpecPackage.DOCUMENT:
				if(context == grammarAccess.getDocumentRule()) {
					sequence_Document(context, (Document) semanticObject); 
					return; 
				}
				else break;
			case TxtSpecPackage.MODEL_ELEMENT_BLOCK:
				if(context == grammarAccess.getBlockRule() ||
				   context == grammarAccess.getModelElementBlockRule()) {
					sequence_ModelElementBlock(context, (ModelElementBlock) semanticObject); 
					return; 
				}
				else break;
			case TxtSpecPackage.MODEL_ELEMENT_BLOCK_CONTENT:
				if(context == grammarAccess.getModelElementBlockContentRule()) {
					sequence_ModelElementBlockContent(context, (ModelElementBlockContent) semanticObject); 
					return; 
				}
				else break;
			case TxtSpecPackage.TEXT_BLOCK:
				if(context == grammarAccess.getBlockRule() ||
				   context == grammarAccess.getTextBlockRule()) {
					sequence_TextBlock(context, (TextBlock) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     blocks+=Block*
	 */
	protected void sequence_Document(EObject context, Document semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (blocks+=Block*)
	 */
	protected void sequence_ModelElementBlockContent(EObject context, ModelElementBlockContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (url=UrlParam content=ModelElementBlockContent)
	 */
	protected void sequence_ModelElementBlock(EObject context, ModelElementBlock semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TxtSpecPackage.Literals.MODEL_ELEMENT_BLOCK__URL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TxtSpecPackage.Literals.MODEL_ELEMENT_BLOCK__URL));
			if(transientValues.isValueTransient(semanticObject, TxtSpecPackage.Literals.MODEL_ELEMENT_BLOCK__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TxtSpecPackage.Literals.MODEL_ELEMENT_BLOCK__CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelElementBlockAccess().getUrlUrlParamParserRuleCall_1_0(), semanticObject.getUrl());
		feeder.accept(grammarAccess.getModelElementBlockAccess().getContentModelElementBlockContentParserRuleCall_2_0(), semanticObject.getContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     words+=WORD+
	 */
	protected void sequence_TextBlock(EObject context, TextBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
