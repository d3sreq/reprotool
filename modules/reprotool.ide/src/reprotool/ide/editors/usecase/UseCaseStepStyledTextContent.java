package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
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
import reprotool.model.linguistic.action.Communication;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.ActionpartPackage;
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
	private Command changeUseCaseStep(int start, int replaceLength, String text) {
		
		EditingDomain editingDomain = Utils.getEditingDomain(useCaseStep);
		
		// command changing text of the step
		String oldContent = useCaseStep.getContent();
		String before = oldContent.substring(0, start);
		// empty text means delete - skip deleted char(s)
		int afterStart = text.isEmpty() ? start + replaceLength : start;
		String after = oldContent.substring(afterStart);
		
		String newContent = before + text + after; 
		Command changeTextCommand = SetCommand.create(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__CONTENT, newContent);
		
		// commands (re)moving ranges of the nodes
		List<Command> rangeCommands = new ArrayList<Command>();		
		for (TextRange textNode : useCaseStep.getTextNodes()) {

			if (changeStartsInsideNode(textNode, start)) {
				int lengthChange = text.isEmpty() ? -replaceLength : text.length();
				int newLength = textNode.getLength() + lengthChange;
				SetCommand setCommand = new SetCommand(editingDomain, textNode, ActionpartPackage.Literals.TEXT_RANGE__LENGTH, newLength);
				rangeCommands.add(setCommand);
				
			} else if (changeDeletesWholeNode(textNode, start, replaceLength, text)) {
				// set action part linked from text to null
				SetCommand setCommand = new SetCommand(editingDomain, textNode.getActionPart(), ActionpartPackage.Literals.ACTION_PART__TEXT, null);
				rangeCommands.add(setCommand);
				
				// remove text range
				RemoveCommand removeCommand = new RemoveCommand(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, textNode);
				rangeCommands.add(removeCommand);
				
			} else if (changeDeletesNodeStart(textNode, start, replaceLength, text)) {
				int newLength = textNode.getStartPosition() + textNode.getLength() - (start + replaceLength);
				SetCommand setLengthCommand = new SetCommand(editingDomain, textNode, ActionpartPackage.Literals.TEXT_RANGE__LENGTH, newLength);
				rangeCommands.add(setLengthCommand);
				
				SetCommand setPositionCommand = new SetCommand(editingDomain, textNode, ActionpartPackage.Literals.TEXT_RANGE__START_POSITION, start);
				rangeCommands.add(setPositionCommand);
				
			} else if (changeBeforeNode(textNode, start, replaceLength, text)) {
				// node after added/deleted text
				int positionChange = text.isEmpty() ? -replaceLength : text.length();
				int newStartPosition = textNode.getStartPosition() + positionChange;
				SetCommand setCommand = new SetCommand(editingDomain, textNode, ActionpartPackage.Literals.TEXT_RANGE__START_POSITION, newStartPosition);
				rangeCommands.add(setCommand);
			}
		}
		
		if (!rangeCommands.isEmpty()) {
			CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.append(changeTextCommand);
			
			for (Command command : rangeCommands) {
				compoundCommand.append(command);
			}
			changeTextCommand = compoundCommand;
		}
		
		return changeTextCommand;
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
	private boolean changeBeforeNode(TextRange textNode, int start, int replaceLength, String text) {
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
	private boolean changeDeletesNodeStart(TextRange textNode, int start, int replaceLength, String text) {
		return text.isEmpty()
				&& start + replaceLength > textNode.getStartPosition()
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
	 * @param text
	 * @return
	 */
	private boolean changeDeletesWholeNode(TextRange textNode, int start, int replaceLength, String text) {
		return text.isEmpty() 
				&& start <= textNode.getStartPosition()
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
	private boolean changeStartsInsideNode(TextRange textNode, int changeStart) {		 
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
	public void markSender(int start, int length) {
		// TODO - test only
		// TODO - log
//		System.out.println(useCaseStep.getContent().substring(start, start + length));
		
		EditingDomain editingDomain = Utils.getEditingDomain(useCaseStep);
		
		// create marked text
		TextRange textRange = createTextRange(start, length);		
		
		// TODO jvinarek - solve situation when text is already marked
		// TODO jvinarek - solve situation when sender is already specified
		// command to add marked text to use case
		AddCommand addTextRangeCommand = new AddCommand(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, textRange);
		
		// command to bind marked text to the sentence actor
		Assert.isTrue(useCaseStep.getAction() instanceof ToSystem, "Use case step type must be already set to 'ToSystem' when setting Sender");
		ToSystem toSystem = (ToSystem)useCaseStep.getAction();
		
		SentenceActor sentenceActor = toSystem.getSender(); 
		Assert.isTrue(sentenceActor != null, "SentenceActor object must not be null when setting Sender");
		
		SetCommand setSenderTextCommand = new SetCommand(editingDomain, sentenceActor, ActionpartPackage.Literals.ACTION_PART__TEXT, textRange); 		
		
		// wrap both commands to compound command
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.append(addTextRangeCommand);
		compoundCommand.append(setSenderTextCommand);
		
		executeWithNotification(compoundCommand);
	}
	
	public void markActivity(int start, int length) {
		// TODO - test only
		// TODO - log
//		System.out.println(useCaseStep.getContent().substring(start, start + length));
		
		EditingDomain editingDomain = Utils.getEditingDomain(useCaseStep);
		
		// create marked text
		TextRange textRange = createTextRange(start, length);		
		
		// TODO jvinarek - solve situation when text is already marked
		// TODO jvinarek - solve situation when activity is already specified
		// command to add marked text to use case
		AddCommand addTextRangeCommand = new AddCommand(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, textRange);
		
		// command to bind marked text to the activity
		Assert.isTrue(useCaseStep.getAction() instanceof Communication, "Use case step Action type must be 'Communication' implementation when setting Activity");
		Communication communication = (Communication)useCaseStep.getAction();
		
		SentenceActivity sentenceActivity = communication.getSentenceActivity();
		Assert.isTrue(sentenceActivity != null, "SentenceActivity object must not be null when setting Activity");
		
		SetCommand setActivityTextCommand = new SetCommand(editingDomain, sentenceActivity, ActionpartPackage.Literals.ACTION_PART__TEXT, textRange); 		
		
		// wrap both commands to compound command
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.append(addTextRangeCommand);
		compoundCommand.append(setActivityTextCommand);
		
		executeWithNotification(compoundCommand);
	}
	
	public void markReceiver(int start, int length) {
		// TODO Auto-generated method stub
		
	}

	public void markActionParam(int start, int length) {
		// TODO Auto-generated method stub
		
	}

	public void markIncludeUseCase(int start, int length) {
		// TODO Auto-generated method stub
		
	}

	public void markGoto(int start, int length) {
		// TODO Auto-generated method stub
		
	}

	private TextRange createTextRange(int start, int length) {
		TextRange textRange = ActionpartFactory.eINSTANCE.createTextRange();
		textRange.setStartPosition(start);
		textRange.setLength(length);
		return textRange;
	}
	
}
