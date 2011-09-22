package reprotool.lts.editor;

import java.util.Comparator;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.part.Page;

import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.swt.SWT;

import reprotool.model.lts.StateMachine;

public class LTSContentOutlinePage extends Page implements IContentOutlinePage {
	
	private GraphViewer viewer;
	private StateMachine machine;
	
	protected LTSContentOutlinePage(StateMachine machine) {
		super();
		this.machine = machine;
	}
	
	/**
	 * @param graphParent
	 *            Where to paint the graph
	 * @param machine
	 *            Which StateMachine to show
	 */
	private void createLtsGraph(final Composite graphParent, StateMachine machine) {
		
		// Create a new graph
		viewer = new GraphViewer(graphParent, SWT.NONE);
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		viewer.getGraphControl().getLightweightSystem().setEventDispatcher(
				new SWTEventDispatcher() {
					@Override
					public void dispatchMouseMoved(org.eclipse.swt.events.MouseEvent me) {
						// Do nothing. This disables nodes replacing with mouse.
					}
				}
		);
		
		
		viewer.setContentProvider(new NodeContentProvider());
		viewer.setLabelProvider( new NodeLabelProvider(machine) );

		// layout algorithm
		LayoutAlgorithm la = new GXTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		la.setComparator(new Comparator<Object>() {
			
			@Override
			public int compare (Object node1, Object node2) {
				return 0;
			}
			
		});
		viewer.setLayoutAlgorithm(la, false);

		// popup menu
		final Menu menu = new Menu(graphParent);
		MenuItem saveItem = new MenuItem(menu, SWT.PUSH);
		saveItem.setText("save image");
		
		saveItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell s = graphParent.getShell();
				FileDialog fd = new FileDialog(s, SWT.SAVE);
				fd.setFilterExtensions(new String[] {"*.png"});
				fd.setText("Save");
				String selected = fd.open();
			        
				Graph g = viewer.getGraphControl();
				Point size = new Point(g.getContents().getSize().width, g.getContents().getSize().height);
				final Image image = new Image(null, size.x, size.y);
				GC gc = new GC(image);
				SWTGraphics swtGraphics = new SWTGraphics(gc);
				g.getViewport().paint(swtGraphics);
				gc.dispose();

				ImageLoader loader = new ImageLoader();
				loader.data = new ImageData[] {image.getImageData()};
				loader.save(selected, SWT.IMAGE_PNG);
			}
			
		});
		
		viewer.getGraphControl().addMouseListener(new MouseAdapter() {
			
			public void mouseDown(MouseEvent e) {
				if (e.button == 3) {
					menu.setVisible(true);
				}
			}
			
		});
	}
	
	private void showGraph(StateMachine machine) {
		viewer.setInput(machine);
		viewer.getGraphControl().setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
		viewer.applyLayout();
	}
	
	
	@Override
	public void createControl(Composite parent) {
		createLtsGraph(parent, machine);
		showGraph(machine);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Control getControl() {
		// TODO Auto-generated method stub
		return viewer.getControl();
		//return graph.getGraph();
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelection(ISelection selection) {
		// TODO Auto-generated method stub

	}

}
