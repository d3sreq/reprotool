package reprotool.ide.editors.usecase;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.model.linguistic.actionpart.TextRange;

/**
 * Serves as mediator between Actions and editor content.
 * <p>
 * Actions should call marking methods on this service (i.e. #markSender) and
 * this class will pass the execution to the appropriate editor content
 * 
 * @author jvinarek
 */
public class MarkingService {
	// TODO - make this class eclipse service instead of singleton.

	private static MarkingService instance = new MarkingService();

	public static MarkingService getInstance() {
		return instance;
	}

	private StyledTextCellEditor styledTextCellEditor;
	private UseCaseStepStyledTextContent textContent;

	private MarkingService() {
	}

	// TODO - jvinarek - add marking service as selection listener ?
	public void setEditorAndContent(UseCaseStepStyledTextContent textContent, StyledTextCellEditor styledTextCellEditor) {
		this.textContent = textContent;
		this.styledTextCellEditor = styledTextCellEditor;
	}

	public void markSender() {
		markCommon(EMarkAction.SENDER);
	}

	public void markActivity() {
		markCommon(EMarkAction.ACTIVITY);
	}

	public void markReceiver() {
		markCommon(EMarkAction.RECEIVER);
	}

	public void markParam() {
		markCommon(EMarkAction.PARAM);
	}

	public void markGoto() {
		markCommon(EMarkAction.GOTO);
	}

	public void markIncludeUseCase() {
		markCommon(EMarkAction.INCLUDE_USE_CASE);
	}
	
	public void erase() {
		markCommon(EMarkAction.ERASE);
	}

	private void markCommon(EMarkAction markAction) {
		// get information about selection from editor
		int[] selectionRange = styledTextCellEditor.getText().getSelectionRanges();
		if (selectionRange.length == 0) {
			return;
		}

		int start = selectionRange[0];
		int length = selectionRange[1];

		markAction.mark(start, length, textContent);
	}

	enum EMarkAction {
		SENDER {
			
			@Override
			void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain,
					CompoundCommand compoundCommand, TextRange textRange) {
				useCaseStepStyledTextContent.markSender(editingDomain, compoundCommand, textRange);
			}
		},
		ACTIVITY {

			@Override
			void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain,
					CompoundCommand compoundCommand, TextRange textRange) {
				useCaseStepStyledTextContent.markActivity(editingDomain, compoundCommand, textRange);
			}
		},
		RECEIVER {

			@Override
			void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain,
					CompoundCommand compoundCommand, TextRange textRange) {
				useCaseStepStyledTextContent.markReceiver(editingDomain, compoundCommand, textRange);
			}
			
		},
		PARAM {

			@Override
			void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain,
					CompoundCommand compoundCommand, TextRange textRange) {
				useCaseStepStyledTextContent.markParam(editingDomain, compoundCommand, textRange);
			}
			
		},
		INCLUDE_USE_CASE {

			@Override
			void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain,
					CompoundCommand compoundCommand, TextRange textRange) {
				useCaseStepStyledTextContent.markIncludeUseCase(editingDomain, compoundCommand, textRange);
			}
			
		},
		GOTO {

			@Override
			void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain,
					CompoundCommand compoundCommand, TextRange textRange) {
				useCaseStepStyledTextContent.markGoto(editingDomain, compoundCommand, textRange);
			}
			
		},
		ERASE {
			@Override
			void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
				textContent.erase(start, length);
			}

			@Override
			void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain,
					CompoundCommand compoundCommand, TextRange textRange) {
				// empty, will not be called becouse #mark method is overriden 
			}
		};

		void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
			textContent.markCommon(start, length, this);
		}
		
		abstract void markSpecific(UseCaseStepStyledTextContent useCaseStepStyledTextContent, EditingDomain editingDomain, CompoundCommand compoundCommand, TextRange textRange);
	}
}
