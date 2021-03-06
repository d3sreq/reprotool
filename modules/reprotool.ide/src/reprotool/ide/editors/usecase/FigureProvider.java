package reprotool.ide.editors.usecase;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;

import lts2.State;
import lts2.StateMachine;

public class FigureProvider {
	private static final int STATE_NODE_DIAMETER = 16;
	private static final int SIGN_SIZE = 6;
	private StateMachine machine;
	
	private ImageFigure drawInitialStateFigure() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(STATE_NODE_DIAMETER, STATE_NODE_DIAMETER, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);

		gc.setBackground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillOval(0, 0, image.getBounds().width, image.getBounds().height);

		gc.dispose();
		
		ImageFigure fig = new ImageFigure();
		fig.setImage(image);
		fig.setSize(image.getBounds().width, image.getBounds().height);
		
		return fig;
	}
	
	private ImageFigure drawAbortStateFigure() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(STATE_NODE_DIAMETER, STATE_NODE_DIAMETER, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);

		gc.setBackground(new Color(Display.getDefault(), 255, 0, 0));
		gc.fillOval(0, 0, image.getBounds().width, image.getBounds().height);

		gc.dispose();
		
		ImageFigure fig = new ImageFigure();
		fig.setImage(image);
		fig.setSize(image.getBounds().width, image.getBounds().height);
		
		return fig;
	}
	
	private ImageFigure drawSuccessStateFigure() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(STATE_NODE_DIAMETER, STATE_NODE_DIAMETER, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);

		gc.setBackground(new Color(Display.getDefault(), 0, 255, 0));
		gc.fillOval(0, 0, image.getBounds().width, image.getBounds().height);

		gc.dispose();
		
		ImageFigure fig = new ImageFigure();
		fig.setImage(image);
		fig.setSize(image.getBounds().width, image.getBounds().height);
		
		return fig;
	}
	
	private IFigure drawNormalStateFigure() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(STATE_NODE_DIAMETER, STATE_NODE_DIAMETER, 8, pData);

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.setForeground(new Color(Display.getDefault(), 0, 0, 0));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);
		gc.drawOval(0, 0, image.getBounds().width - 2, image.getBounds().height - 2);
		gc.dispose();
		
		ImageFigure fig = new ImageFigure();
		fig.setImage(image);
		fig.setSize(image.getBounds().width, image.getBounds().height);
		
		return fig;
	}
	
	public void setMachine(StateMachine m) {
		machine = m;
	}
	
	public Image getSignImage() {
		PaletteData pData = new PaletteData(255, 255, 255);
		ImageData sourceData = new ImageData(SIGN_SIZE + 1, SIGN_SIZE + 1, 8, pData);
		sourceData.transparentPixel = 0xFFFFFF;

		Image image = new Image(Display.getDefault(), sourceData);
		GC gc = new GC(image);
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		
		gc.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		gc.fillRectangle(0, 0, image.getBounds().width, image.getBounds().height);

		gc.setForeground(new Color(Display.getDefault(), 150, 0, 200));
		gc.drawRectangle(0, 0, SIGN_SIZE, SIGN_SIZE);
		gc.dispose();
		
		return image;
	}
	
	public IFigure getFigure(State s) {
		if (s == machine.getInitialState()) {
			return drawInitialStateFigure();
		} else if (s == machine.getAbortState()) {
			return drawAbortStateFigure();
		} else if (s == machine.getFinalState()) {
			return drawSuccessStateFigure();
		} else {
			return drawNormalStateFigure();
		}
	}

}
