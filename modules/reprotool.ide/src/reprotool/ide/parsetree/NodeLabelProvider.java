package reprotool.ide.parsetree;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;

import reprotool.model.linguistic.NounPhraseNode;
import reprotool.model.linguistic.PrepositionalPhraseNode;
import reprotool.model.linguistic.SentenceNode;
import reprotool.model.linguistic.VerbPhraseNode;
import reprotool.model.linguistic.Word;

public class NodeLabelProvider extends LabelProvider {
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof Word)
			return null;
		if (element instanceof SentenceNode)
			return "Sentence";
		if(element instanceof NounPhraseNode)
			return "Noun phrase";
		if(element instanceof VerbPhraseNode)
			return "Verb phrase";
		if(element instanceof PrepositionalPhraseNode)
			return "Prep. phrase";
		
		if (element instanceof EntityConnectionData) {
			return null;
		}
		
		throw new RuntimeException("Type not supported");
	}
	
	public int countNodeWidth(Word w) {
		int strLen = "wordType".length();
		if (strLen < w.getWordStr().length()) {
			strLen = w.getWordStr().length();
		}
		
		int width = strLen * 7;
		if (strLen > 14) {
			width -= 16;
		}
		
		if (
				("wordType".length() <= 7) &&
				(w.getWordStr().length() <= "wordType".length())
		) {
			width += 7;
		}
		
		return width;
	}
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof Word) {
			Word word = (Word) element;
			
			int width = countNodeWidth(word);
			
			String offset = "";
			if (
					("wordType".length() <= 7) &&
					(word.getWordStr().length() <= "wordType".length())
			) {	
				offset = " ";
			}
			
			PaletteData pData = new PaletteData(255, 255, 255);
			ImageData sourceData = new ImageData(width, 30, 8, pData);
			sourceData.transparentPixel = 0xFFFFFF;
			
			Image image = new Image(Display.getDefault(), sourceData);
			GC gc = new GC(image);
			gc.setAdvanced(true);
			gc.setAntialias(SWT.ON);
			gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
			gc.setForeground(new Color(Display.getDefault(), 1, 70, 122));
			gc.fillRectangle(image.getBounds());
			gc.drawLine(0, 15, 110, 15);
			gc.setFont(new Font(Display.getDefault(), "Arial", 8, SWT.BOLD | SWT.ITALIC));
			gc.drawText("wordType" + offset, 0, 0);
			gc.setForeground(new Color(Display.getDefault(), 255, 0, 0));
			gc.setFont(new Font(Display.getDefault(), "Arial", 8, SWT.BOLD));
			gc.drawText(word.getWordStr(), 0, 18);
			
			gc.setForeground(new Color(Display.getDefault(), 1, 70, 122));
			gc.drawPolygon(new int[] {width - 7, 4, width - 4, 7, width - 1, 4});
			gc.dispose();
			
			return image;
		}
		
		return null;
	}
	
	
}
