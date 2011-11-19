package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledTextContent;
import org.eclipse.swt.custom.TextChangeListener;
import org.eclipse.swt.custom.TextChangedEvent;
import org.eclipse.swt.custom.TextChangingEvent;

import reprotool.ide.utils.Utils;
import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.Communication;
import reprotool.model.linguistic.action.FromSystem;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.ActionpartPackage;
import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.SentenceActivity;
import reprotool.model.linguistic.actionpart.SentenceActor;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * Some methods copied from org.eclipse.swt.custom.DefaultContent class
 * TODO jvinarek - use default implementation and add textrange support only by listeners ?
 * 
 * @author jvinarek
 *
 */
public class UseCaseStepStyledTextContent implements StyledTextContent {

	private List<TextChangeListener> listenerList = new ArrayList<TextChangeListener>();
	private UseCaseStep useCaseStep;
	
	public UseCaseStepStyledTextContent(UseCaseStep useCaseStep) {
		this.useCaseStep = useCaseStep;
	}

	/**
	 * Adds a <code>TextChangeListener</code> listening for 
	 * <code>TextChangingEvent</code> and <code>TextChangedEvent</code>. A 
	 * <code>TextChangingEvent</code> is sent before changes to the text occur.
	 * A <code>TextChangedEvent</code> is sent after changes to the text 
	 * occurred.
	 * <p>
	 *
	 * @param listener the listener
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT when listener is null</li>
	 * </ul>
	 */
	@Override
	public void addTextChangeListener(TextChangeListener listener) {
		if (listener == null) {
			error(SWT.ERROR_NULL_ARGUMENT);
		}
		listenerList.add(listener);
	}
	
	/**	 
	 * Reports an SWT error.
	 * <p>
	 *
	 * @param code the error code
	 */
	void error (int code) {
		SWT.error(code);
	}

	@Override
	public int getCharCount() {
		return useCaseStep.getContent().length();
	}

	@Override
	public String getLine(int lineIndex) {		
		return useCaseStep.getContent();
	}

	@Override
	public int getLineAtOffset(int offset) {
		// use only single line
		return 0;
	}

	@Override
	public int getLineCount() {
		// use only single line
		return 1;
	}

	@Override
	public String getLineDelimiter() {
		return System.getProperty("line.separator");
	}

	@Override
	public int getOffsetAtLine(int lineIndex) {
		// use only single line
		return 0;
	}

	@Override
	public String getTextRange(int start, int length) {
		return useCaseStep.getContent().substring(start, start + length); 
	}

	/**
	 * Removes the specified <code>TextChangeListener</code>.
	 * <p>
	 *
	 * @param listener the listener which should no longer be notified
	 * 
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT when listener is null</li>
	 * </ul>
	 */
	@Override
	public void removeTextChangeListener(TextChangeListener listener) {
		if (listener == null) {
			error(SWT.ERROR_NULL_ARGUMENT);
		}
		listenerList.remove(listener);
	}

	@Override
	public void replaceTextRange(int start, int replaceLength, String text) {
		// TODO - jvinarek - detect and implement paste across more than one Text node.
		// TODO - jvinarek - add copy & paste
		Command command = changeUseCaseStep(start, replaceLength, text);
		
		executeWithNotification(command);
	}
	
	private void executeWithNotification(Command command) {
		// inform listeners
		TextChangingEvent textChangingEvent = new TextChangingEvent(this);
		for (TextChangeListener listener : listenerList) {
			listener.textChanging(textChangingEvent);
		}
		
		// execute command
		Utils.getEditingDomain(useCaseStep).getCommandStack().execute(command);
		
		// inform listeners
		TextChangedEvent textChangedEvent = new TextChangedEvent(this);
		for (TextChangeListener listener : listenerList) {
			listener.textChanged(textChangedEvent);
		}
	}
	
	/**
	 * Looks for {@link TextRange} node which should be affected by text change at "start" 
	 * position.
	 * 
	 * @param textNodeList
	 * @param start
	 * @param replaceLength
	 * @param text
	 * @return
	 */
	private Command changeUseCaseStep(final int start, final int replaceLength, final String text) {
		
		EditingDomain editingDomain = Utils.getEditingDomain(useCaseStep);
		CompoundCommand compoundCommand = new CompoundCommand();
		
		// command changing text of the step
		String oldContent = useCaseStep.getContent();
		String before = oldContent.substring(0, start);
		// empty text means delete - skip deleted char(s)
		int afterStart = text.isEmpty() ? start + replaceLength : start;
		String after = oldContent.substring(afterStart);
		
		String newContent = before + text + after; 
		compoundCommand.append(SetCommand.create(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__CONTENT, newContent));
		
		// commands changing marking text ranges
		if (text.isEmpty()) {
			// delete

			// erase will take care of remove of the ranges in selection
			compoundCommand.append(createEraseCommand(start, replaceLength));
			
			// shift ranges after delete
			for (TextRange textRange : useCaseStep.getTextNodes()) {
				if (changeDeletesTextRangeStart(textRange, start, replaceLength)) {
					// text range with deleted start
					SetCommand setPositionCommand = new SetCommand(editingDomain, textRange, ActionpartPackage.Literals.TEXT_RANGE__START_POSITION, start);
					compoundCommand.append(setPositionCommand);
					
				} else if (changeBeforeTextRange(textRange, start, replaceLength, text)) {
					// text range after deleted text
					int newStartPosition = textRange.getStartPosition() - replaceLength;
					SetCommand setCommand = new SetCommand(editingDomain, textRange, ActionpartPackage.Literals.TEXT_RANGE__START_POSITION, newStartPosition);
					compoundCommand.append(setCommand);
				}
			}
		} else {
			// insert 
			// shift ranges after insert
			for (TextRange textRange : useCaseStep.getTextNodes()) {

				if (changeStartsInsideTextRange(textRange, start)) {
					int newLength = textRange.getLength() + text.length();
					SetCommand setCommand = new SetCommand(editingDomain, textRange, ActionpartPackage.Literals.TEXT_RANGE__LENGTH, newLength);
					compoundCommand.append(setCommand);
					
				} else if (changeBeforeTextRange(textRange, start, replaceLength, text)) {
					// node after added text
					int newStartPosition = textRange.getStartPosition() + text.length();
					SetCommand setCommand = new SetCommand(editingDomain, textRange, ActionpartPackage.Literals.TEXT_RANGE__START_POSITION, newStartPosition);
					compoundCommand.append(setCommand);
				}
			}
		}
		
		if (compoundCommand.isEmpty()) {
			// encountered problems when CompoundCommand was empty
			return new IdentityCommand();
		}
		
		return compoundCommand;
	}
	
	/**
	 * Change deletes the node start. For example:
	 * <pre>
	 * {@code
	 * "^" means start of the delete, "$" end of the delete
	 * 
	 *   |C l e r k|
	 * ^ ^  
	 * }
	 * </pre> 
	 * 
	 * @param textNode
	 * @param start
	 * @param replaceLength
	 * @param text
	 * @return
	 */
	private boolean changeBeforeTextRange(TextRange textNode, int start, int replaceLength, String text) {
		return start <= textNode.getStartPosition();
	}

	/**
	 * Change deletes the node start. For example:
	 * <pre>
	 * {@code
	 * "^" means start of the delete, "$" end of the delete
	 * 
	 *   |C l e r k|
	 * ^ ^ $ $ $ $     
	 * }
	 * </pre> 
	 * 
	 * @param textNode
	 * @param start
	 * @param replaceLength
	 * @param text
	 * @return
	 */
	private boolean changeDeletesTextRangeStart(TextRange textNode, int start, int replaceLength) {
		return start + replaceLength > textNode.getStartPosition()
				&& start + replaceLength < textNode.getStartPosition() + textNode.getLength();
	}

	/**
	 * Change deletes the node. For example:
	 * <pre>
	 * {@code
	 * "^" means start of the delete, "$" end of the delete
	 * 
	 *   |C l e r k|
	 * ^ ^         $ $ 
	 * }
	 * </pre>
	 * 
	 * @param textNode
	 * @param start
	 * @param replaceLength
	 * @return
	 */
	private boolean changeDeletesWholeTextRange(TextRange textNode, int start, int replaceLength) {
		return start <= textNode.getStartPosition()
				&& start + replaceLength >= textNode.getStartPosition() + textNode.getLength();
	}

	/**
	 * Change occurs inside the given node:
	 * <pre>
	 * {@code
	 * "^" means start of the insert/delete
	 * 
	 * |C l e r k|
	 *   ^ ^ ^ ^ ^
	 * }
	 * </pre>
	 * 
	 * @param textNode
	 * @param changeStart
	 * @return
	 */
	private boolean changeStartsInsideTextRange(TextRange textNode, int changeStart) {		 
		return changeStart > textNode.getStartPosition() 
				&& changeStart <= textNode.getStartPosition() + textNode.getLength(); 
	}

	@Override
	public void setText(String text) {
		// TODO jvinarek - add xreal implementation
	}

	//
	// methods for text marking
	//
	
	/**
	 * TODO - add documentation
	 * @param length 
	 * @param start 
	 */
	void markCommon(int start, int length, MarkingService.EMarkAction markAction) {
		EditingDomain editingDomain = Utils.getEditingDomain(useCaseStep);
		CompoundCommand compoundCommand = new CompoundCommand();
	
		// erase selected text
		compoundCommand.append(createEraseCommand(start, length));
		
		// create marked text
		TextRange textRange = createTextRange(start, length);
		
		// command to add marked text to use case
		compoundCommand.append(new AddCommand(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, textRange));
		
		// call specific action (call markSender, markReceiver etc)
		markAction.markSpecific(this, editingDomain, compoundCommand, textRange);
		
		executeWithNotification(compoundCommand);
	}
	
	void markSender(EditingDomain editingDomain, CompoundCommand compoundCommand, TextRange textRange) {
		// command to bind marked text to the sentence actor
		Assert.isTrue(useCaseStep.getAction() instanceof ToSystem, "Use case step type must be already set to 'ToSystem' when setting Sender");
		ToSystem toSystem = (ToSystem)useCaseStep.getAction();
		SentenceActor sentenceActor = toSystem.getSender(); 
		Assert.isTrue(sentenceActor != null, "SentenceActor object must not be null when setting Sender");
		compoundCommand.append(new SetCommand(editingDomain, sentenceActor, ActionpartPackage.Literals.ACTION_PART__TEXT, textRange)); 		
		
		// TODO jvinarek - solve situation when sender is already specified
	}
	
	void markActivity(EditingDomain editingDomain, CompoundCommand compoundCommand, TextRange textRange) {
		// command to bind marked text to the activity
		Assert.isTrue(useCaseStep.getAction() instanceof Communication, "Use case step Action type must be 'Communication' implementation when setting Activity");
		Communication communication = (Communication)useCaseStep.getAction();
		SentenceActivity sentenceActivity = communication.getSentenceActivity();
		Assert.isTrue(sentenceActivity != null, "SentenceActivity object must not be null when setting Activity");
		compoundCommand.append(new SetCommand(editingDomain, sentenceActivity, ActionpartPackage.Literals.ACTION_PART__TEXT, textRange)); 		
		
		// TODO jvinarek - solve situation when activity is already specified
	}
	
	void markReceiver(EditingDomain editingDomain, CompoundCommand compoundCommand, TextRange textRange) {
		// command to bind marked text to the sentence actor
		Assert.isTrue(useCaseStep.getAction() instanceof FromSystem, "Use case step Action type must be 'FromSystem' implementation when setting Receiver");
		FromSystem fromSystem = (FromSystem)useCaseStep.getAction();
		SentenceActor sentenceActor = fromSystem.getReceiver();
		Assert.isTrue(sentenceActor != null, "SentenceActor object must not be null when setting Receiver");
		compoundCommand.append(new SetCommand(editingDomain, sentenceActor, ActionpartPackage.Literals.ACTION_PART__TEXT, textRange));
		
		// TODO jvinarek - solve situation when activity is already specified
	}

	void markParam(EditingDomain editingDomain, CompoundCommand compoundCommand, TextRange textRange) {
		// command add new action param
		Assert.isTrue(useCaseStep.getAction() instanceof Communication, "Use case step Action type must be 'Communication' implementation when setting Param");
		Communication communication = (Communication)useCaseStep.getAction();
		
		// create new action param, set text into it.
		// TODO jvinarek - is setting OK or set with command ?
		SentenceActionParam actionParam = ActionpartFactory.eINSTANCE.createSentenceActionParam();
		actionParam.setText(textRange);
		
		compoundCommand.append(new AddCommand(editingDomain, communication, ActionPackage.Literals.COMMUNICATION__ACTION_PARAM, actionParam));		
	}

	void markIncludeUseCase(EditingDomain editingDomain, CompoundCommand compoundCommand, TextRange textRange) {
		// command to bind marked text to the goto text
		Assert.isTrue(useCaseStep.getAction() instanceof UseCaseInclude, "Use case step Action type must be 'UseCaseInclude' implementation when setting use case include");
		UseCaseInclude useCaseInclude = (UseCaseInclude)useCaseStep.getAction();
		compoundCommand.append(new SetCommand(editingDomain, useCaseInclude, ActionpartPackage.Literals.ACTION_PART__TEXT, textRange));
		
		// TODO jvinarek - solve situation when activity is already specified
	}

	void markGoto(EditingDomain editingDomain, CompoundCommand compoundCommand, TextRange textRange) {
		// command to bind marked text to the goto text
		Assert.isTrue(useCaseStep.getAction() instanceof Goto, "Use case step Action type must be 'Goto' implementation when setting goto target");
		Goto gotoAction = (Goto)useCaseStep.getAction();
		compoundCommand.append(new SetCommand(editingDomain, gotoAction, ActionpartPackage.Literals.ACTION_PART__TEXT, textRange));
		
		// TODO jvinarek - solve situation when activity is already specified
		
	}

	void erase(int unmarkStart, int unmarkLength) {
		Command eraseCommand = createEraseCommand(unmarkStart, unmarkLength);
		
		// execute
		executeWithNotification(eraseCommand);
	}

	private Command createEraseCommand(int unmarkStart, int unmarkLength) {
		EditingDomain editingDomain = Utils.getEditingDomain(useCaseStep);
		CompoundCommand compoundCommand = new CompoundCommand();
		
		for (TextRange textRange : useCaseStep.getTextNodes()) {
			
			if (changeStartsInsideTextRange(textRange, unmarkStart)) {
				// make textRange shorter
				int newLength = unmarkStart - textRange.getStartPosition(); 
				SetCommand setCommand = new SetCommand(editingDomain, textRange, ActionpartPackage.Literals.TEXT_RANGE__LENGTH, newLength);
				compoundCommand.append(setCommand);
				
			} else if (changeDeletesWholeTextRange(textRange, unmarkStart, unmarkLength)) {
				// set action part linked from text to null
				SetCommand setCommand = new SetCommand(editingDomain, textRange.getActionPart(), ActionpartPackage.Literals.ACTION_PART__TEXT, null);
				compoundCommand.append(setCommand);
	
				// TODO jvinarek - remove action part ? Only for params ?
				
				// remove text range
				RemoveCommand removeCommand = new RemoveCommand(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, textRange);
				compoundCommand.append(removeCommand);
				
			} else if (changeDeletesTextRangeStart(textRange, unmarkStart, unmarkLength)) {
				int newStart = unmarkStart + unmarkLength;
				int newLength = textRange.getStartPosition() + textRange.getLength() - newStart;
				SetCommand setLengthCommand = new SetCommand(editingDomain, textRange, ActionpartPackage.Literals.TEXT_RANGE__LENGTH, newLength);
				compoundCommand.append(setLengthCommand);
				
				SetCommand setPositionCommand = new SetCommand(editingDomain, textRange, ActionpartPackage.Literals.TEXT_RANGE__START_POSITION, newStart);
				compoundCommand.append(setPositionCommand);
			}
		}
		if (compoundCommand.isEmpty()) {
			// encountered problems when CompoundCommand was empty
			return new IdentityCommand();
		}
		
		return compoundCommand;
	}

	private TextRange createTextRange(int start, int length) {
		TextRange textRange = ActionpartFactory.eINSTANCE.createTextRange();
		textRange.setStartPosition(start);
		textRange.setLength(length);
		return textRange;
	}
	
}
