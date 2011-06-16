package reprotool.lts.editor;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;

import reprotool.model.lts.State;
import reprotool.model.lts.StateMachine;

public class FigureProvider {
	private StateMachine machine;
	
	public void setMachine(StateMachine m) {
		machine = m;
	}
	
	public Image getImage() {
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
	
	public Image getSelImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(25, 25, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 200));
		gc.setBackground(new Color(Display.getDefault(), 200, 200, 200));
		gc.fillOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.drawOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
			
		return image;
	}
	
	private Image getInitialImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(25, 25, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.setBackground(new Color(Display.getDefault(), 50, 50, 255));
		gc.fillOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
			
		return image;
	}
	
	private Image getInitialSelImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(25, 25, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.setBackground(new Color(Display.getDefault(), 0, 0, 150));
		gc.fillOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
			
		return image;
	}
	
	private Image getSuccessImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(25, 25, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.setBackground(new Color(Display.getDefault(), 0, 200, 0));
		gc.fillOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
			
		return image;
	}
	
	private Image getSuccessSelImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(25, 25, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.setBackground(new Color(Display.getDefault(), 20, 150, 20));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 200));
		gc.fillOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.drawOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
			
		return image;
	}
	
	private Image getAbortImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(25, 25, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.setBackground(new Color(Display.getDefault(), 200, 0, 0));
		gc.fillOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
			
		return image;
	}
	
	public Image getImage(State s) {
		if (s == machine.getInitialState()) {
			return getInitialImage();
			
		} else if (s == machine.getAbortState()) {
			return getAbortImage();
			
		} else if (s == machine.getSuccessState()) {
			return getSuccessImage();
			
		} else {
			return getImage();
			
		}
	}
	
	public Image getSelImage(State s) {
		if (s == machine.getInitialState()) {
			return getInitialSelImage();
			
		} else if (s == machine.getAbortState()) {
			return getAbortImage();
			
		} else if (s == machine.getSuccessState()) {
			return getSuccessSelImage();
			
		} else {
			return getSelImage();
			
		}
	}
	
	public Figure getFigure(State s) {

		ImageFigure figure = new ImageFigure();
		Image img = null;
		
		if (s == machine.getInitialState()) {
			img = getInitialImage();
			
		} else if (s == machine.getAbortState()) {
			img = getAbortImage();
			
		} else if (s == machine.getSuccessState()) {
			img = getSuccessImage();
			
		} else {
			img = getImage();
			
		}
		
		figure.setImage(img);
		figure.setSize(img.getBounds().width, img.getBounds().height);
		
		return figure;	
	}
}
