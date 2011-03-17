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
import reprotool.model.linguistic.SentenceNode;
import reprotool.model.linguistic.Word;

public class NodeLabelProvider extends LabelProvider {
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof Word) {
			return null;
		}
		
		if (element instanceof SentenceNode) {
			SentenceNode sentence = (SentenceNode) element;
			return sentence.getType();
		}
		
		if (element instanceof EntityConnectionData) {
			return null;
		}
		
		throw new RuntimeException("Type not supported");
	}
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof Word) {
			Word word = (Word) element;
			
			PaletteData pData = new PaletteData(255, 255, 255);
			ImageData sourceData = new ImageData(110, 30, 8, pData);
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
			gc.drawText(word.getType(), 0, 0);
			gc.setForeground(new Color(Display.getDefault(), 255, 0, 0));
			gc.setFont(new Font(Display.getDefault(), "Arial", 8, SWT.BOLD));
			gc.drawText(word.getWordStr(), 0, 18);
			
			gc.setForeground(new Color(Display.getDefault(), 1, 70, 122));
			gc.drawPolygon(new int[] {100, 4, 103, 7, 106, 4});
			gc.dispose();
			
			return image;
		}
		
		return null;
	}
	
	
}
