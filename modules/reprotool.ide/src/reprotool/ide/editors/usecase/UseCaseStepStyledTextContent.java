package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledTextContent;
import org.eclipse.swt.custom.TextChangeListener;
import org.eclipse.swt.custom.TextChangedEvent;
import org.eclipse.swt.custom.TextChangingEvent;

import reprotool.model.linguistic.actionpart.ActionpartPackage;
import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.usecase.UseCaseStep;

/**
 * Some methods copied from org.eclipse.swt.custom.DefaultContent class
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
		TextChange textChange = textNodeOnPosition(useCaseStep.getTextNodes(), start, replaceLength, text);
		
		// inform listeners
		TextChangingEvent textChangingEvent = new TextChangingEvent(this);
		for (TextChangeListener listener : listenerList) {
			listener.textChanging(textChangingEvent);
		}
		
		EditingDomain editingDomain = getEditingDomain(textChange.getTextNode());
		Command command = SetCommand.create(editingDomain, textChange.getTextNode(), ActionpartPackage.Literals.TEXT__CONTENT, textChange.getNewTextNodeContent());
		
		// execute command
		editingDomain.getCommandStack().execute(command);
		
		// inform listeners
		TextChangedEvent textChangedEvent = new TextChangedEvent(this);
		for (TextChangeListener listener : listenerList) {
			listener.textChanged(textChangedEvent);
		}
	}
	
	/**
	 * Looks for {@link Text} node which should be affected by text change at "start" 
	 * position.
	 * 
	 * @param textNodeList
	 * @param start
	 * @param replaceLength
	 * @param text
	 * @return
	 */
	private TextChange textNodeOnPosition(List<Text> textNodeList, int start, int replaceLength, String text) {
		
		// skip nodes with text before "start"
		// TODO jvinarek - ensure that list has at least one node
		int lenghtBeforeSelected = 0;
		Text selectedTextNode = null;

		for (Text textNode : textNodeList) {
			selectedTextNode = textNode;
			// TODO jvinarek - ensure that content is not null
			if (start <= lenghtBeforeSelected + textNode.getContent().length()) {
				break;
			}
			lenghtBeforeSelected += textNode.getContent().length();
		}
		
		int changeOffset = start - lenghtBeforeSelected;

		String oldContent = selectedTextNode.getContent();
		String before = oldContent.substring(0, changeOffset);
		// empty text means delete - skip deleted char(s)
		int afterStart = text.equals("") ? changeOffset + replaceLength : changeOffset;
		String after = oldContent.substring(afterStart);
		
		String newContent = before + text + after; 

		TextChange textChange = new TextChange(selectedTextNode, newContent);
		return textChange;
	}

	private EditingDomain getEditingDomain(Text textNode) {
		ResourceSet resourceSet = textNode.eResource().getResourceSet();
		// TODO - jvinarek - use guava validation ?
		assert(resourceSet instanceof IEditingDomainProvider);
		EditingDomain editingDomain = ((IEditingDomainProvider)resourceSet).getEditingDomain(); 
        return editingDomain; 
	}

	@Override
	public void setText(String text) {
		// TODO jvinarek - add xreal implementation
	}
	
	private static class TextChange {
		private final Text textNode;
		private final String newTextNodeContent;

		public TextChange(Text textNode, String newTextNodeContent) {
			this.textNode = textNode;
			this.newTextNodeContent = newTextNodeContent;
		}

		public Text getTextNode() {
			return textNode;
		}

		public String getNewTextNodeContent() {
			return newTextNodeContent;
		}
	}

}
