package reprotool.ide.editors.usecase;

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

	private void markCommon(EMarkAction markAction) {
		// get information about selection from editor
		int[] selectionRange = styledTextCellEditor.getText().getSelectionRanges();
		if (selectionRange.length == 0) {
			return;
		}

		int start = selectionRange[0];
		int length = selectionRange[1];

		// TODO - replace with logging.
		System.out.println("Marking: " +  textContent.getTextRange(start, length));
		
		markAction.mark(start, length, textContent);
	}

	private enum EMarkAction {
		SENDER {
			@Override
			void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
				textContent.markSender(start, length);
			}
		},
		ACTIVITY {
			@Override
			void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
				textContent.markActivity(start, length);
			}
		},
		RECEIVER {
			@Override
			void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
				textContent.markReceiver(start, length);
			}
		},
		PARAM {
			@Override
			void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
				textContent.markActionParam(start, length);
			}
		},
		INCLUDE_USE_CASE {
			@Override
			void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
				textContent.markIncludeUseCase(start, length);
			}
		},
		GOTO {
			@Override
			void mark(int start, int length, UseCaseStepStyledTextContent textContent) {
				textContent.markGoto(start, length);
			}
		};

		abstract void mark(int start, int length, UseCaseStepStyledTextContent textContent);
	}
}
