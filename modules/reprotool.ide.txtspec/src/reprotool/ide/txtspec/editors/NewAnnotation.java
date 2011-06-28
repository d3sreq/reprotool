package reprotool.ide.txtspec.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationPresentation;
import org.eclipse.jface.text.source.ImageUtilities;

//public class NewAnnotation extends Annotation {
//
//	public static final String TYPE= "org.eclipse.newannotation"; //$NON-NLS-1$
//	private static final int COLOR= SWT.COLOR_GRAY;
//	/**
//	 * Creates a new expanded projection annotation.
//	 */
//	public NewAnnotation() {
//		this(false);
//	}
//
//	/**
//	 * Creates a new projection annotation. When <code>isCollapsed</code>
//	 * is <code>true</code> the annotation is initially collapsed.
//	 *
//	 * @param isCollapsed <code>true</code> if the annotation should initially be collapsed, <code>false</code> otherwise
//	 */
//	public NewAnnotation(boolean isCollapsed) {
//		super(TYPE, false, null);
//	}
//
//	public NewAnnotation(String annotationType, boolean b, String string) {
//		super(annotationType,b,string);
//	}
//}

/**
 * Annotation used to represent the projection of a master document onto a
 * {@link org.eclipse.jface.text.projection.ProjectionDocument}. A projection
 * annotation can be either expanded or collapsed. If expanded it corresponds to
 * a segment of the projection document. If collapsed, it represents a region of
 * the master document that does not have a corresponding segment in the
 * projection document.
 * <p>
 * Clients may subclass or use as is.
 * </p>
 *
 * @since 3.0
 */

public class NewAnnotation extends Annotation implements IAnnotationPresentation {

	private static class DisplayDisposeRunnable implements Runnable {

		public void run() {
			if (fgCollapsedImage != null) {
				fgCollapsedImage.dispose();
				fgCollapsedImage= null;
			}
			if (fgExpandedImage != null) {
				fgExpandedImage.dispose();
				fgExpandedImage= null;
			}
		}
	}

	/**
	 * The type of projection annotations.
	 */
	public static final String TYPE= "org.eclipse.newannotation"; //$NON-NLS-1$


	private static final int COLOR= SWT.COLOR_GRAY;
	private static Image fgCollapsedImage;
	private static Image fgExpandedImage;


	/** The state of this annotation */
	private boolean fIsCollapsed= false;
	/** Indicates whether this annotation should be painted as range */
	private boolean fIsRangeIndication= false;

	/**
	 * Creates a new expanded projection annotation.
	 */
	public NewAnnotation() {
		this(false);
	}

	/**
	 * Creates a new projection annotation. When <code>isCollapsed</code>
	 * is <code>true</code> the annotation is initially collapsed.
	 *
	 * @param isCollapsed <code>true</code> if the annotation should initially be collapsed, <code>false</code> otherwise
	 */
	public NewAnnotation(boolean isCollapsed) {
		super(TYPE, false, null);
		fIsCollapsed= isCollapsed;
	}

	public NewAnnotation(String annotationType, boolean b, String string) {
		super(annotationType,b,string);
	}

	/**
	 * Enables and disables the range indication for this annotation.
	 *
	 * @param rangeIndication the enable state for the range indication
	 */
	public void setRangeIndication(boolean rangeIndication) {
		fIsRangeIndication= rangeIndication;
	}

	private void drawRangeIndication(GC gc, Canvas canvas, Rectangle r) {
		final int MARGIN= 3;

		/* cap the height - at least on GTK, large numbers are converted to
		 * negatives at some point */
		int height= Math.min(r.y + r.height - MARGIN, canvas.getSize().y);

		gc.setForeground(canvas.getDisplay().getSystemColor(COLOR));
		gc.setLineWidth(0); // NOTE: 0 means width is 1 but with optimized performance
		gc.drawLine(r.x + 4, r.y + 12, r.x + 4, height);
		gc.drawLine(r.x + 4, height, r.x + r.width - MARGIN, height);
	}

	/*
	 * @see org.eclipse.jface.text.source.IAnnotationPresentation#paint(org.eclipse.swt.graphics.GC, org.eclipse.swt.widgets.Canvas, org.eclipse.swt.graphics.Rectangle)
	 */
	public void paint(GC gc, Canvas canvas, Rectangle rectangle) {
		Image image= getImage(canvas.getDisplay());
		if (image != null) {
			ImageUtilities.drawImage(image, gc, canvas, rectangle, SWT.CENTER, SWT.TOP);
			if (fIsRangeIndication) {
				FontMetrics fontMetrics= gc.getFontMetrics();
				int delta= (fontMetrics.getHeight() - image.getBounds().height)/2;
				rectangle.y += delta;
				rectangle.height -= delta;
				drawRangeIndication(gc, canvas, rectangle);
			}
		}
	}

	/*
	 * @see org.eclipse.jface.text.source.IAnnotationPresentation#getLayer()
	 */
	public int getLayer() {
		return IAnnotationPresentation.DEFAULT_LAYER;
	}

	private Image getImage(Display display) {
		initializeImages(display);
		return isCollapsed() ? fgCollapsedImage : fgExpandedImage;
	}

	private void initializeImages(Display display) {
		if (fgCollapsedImage == null) {

			ImageDescriptor descriptor= ImageDescriptor.createFromFile(NewAnnotation.class, "images/collapsed.png"); //$NON-NLS-1$
			fgCollapsedImage= descriptor.createImage(display);
			descriptor= ImageDescriptor.createFromFile(NewAnnotation.class, "images/expanded.png"); //$NON-NLS-1$
			fgExpandedImage= descriptor.createImage(display);
			display.disposeExec(new DisplayDisposeRunnable());
		}
	}

	/**
	 * Returns the state of this annotation.
	 *
	 * @return <code>true</code> if collapsed
	 */
	public boolean isCollapsed() {
		return fIsCollapsed;
	}

	/**
	 * Marks this annotation as being collapsed.
	 */
	public void markCollapsed() {
		fIsCollapsed= true;
	}

	/**
	 * Marks this annotation as being unfolded.
	 */
	public void markExpanded() {
		fIsCollapsed= false;
	}
	 
	public void markDeleted(boolean deleted) {
		
	}
}
