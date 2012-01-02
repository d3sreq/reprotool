package reprotool.model.linguistic.actionpart.impl;

import org.eclipse.core.runtime.Assert;

import reprotool.model.linguistic.actionpart.impl.TextRangeImpl;
import reprotool.model.usecase.ParseableElement;

public class TextRangeImplCustom extends TextRangeImpl {

	@Override
	public String getContent() {
		if (eContainer == null) {
			return "";
		}
		
		Assert.isTrue(eContainer() instanceof ParseableElement, "Parent of the TextRange node must be ParseableElement");
		ParseableElement parseableElement = (ParseableElement)eContainer();
		
		return parseableElement.getContent().substring(getStartPosition(), getStartPosition() + getLength());
	}
	
}
