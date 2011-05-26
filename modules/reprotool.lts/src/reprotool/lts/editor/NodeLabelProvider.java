package reprotool.lts.editor;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.IFigureProvider;

import reprotool.model.lts.State;
import reprotool.model.lts.Transition;

public class NodeLabelProvider extends LabelProvider implements IFigureProvider {
	
	private Image getImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(25, 25, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.drawOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
			
		return image;
	}
	
	@Override
	public IFigure getFigure(Object element) {
		ImageFigure figure = new ImageFigure();
		Image img = getImage();
		figure.setImage(img);
		figure.setSize(img.getBounds().width, img.getBounds().height);
		
		return figure;
	}
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof State) {
			return null;
		}
		
		if (element instanceof Transition) {
			return null;
		}
		
		throw new RuntimeException("Type not supported");
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof Transition) {
			Transition t = (Transition) element;
			
			if (t.getSentence() == null) {
				return null;
			}
			
			return t.getSentence().getLabel();
		}
		
		if (element instanceof State) {
			return null;
		}
		
		throw new RuntimeException("Type not supported");
	}
}
