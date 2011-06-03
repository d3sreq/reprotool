package reprotool.lts.editor;

import java.util.Comparator;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;

import reprotool.model.lts.StateMachine;
import reprotool.model.lts.presentation.LtsEditor;

/**
 * This is extended LTS editor build upon the generated LtsEditor
 */
public class ExtendedLtsEditor extends LtsEditor {

	private GraphViewer viewer;
	
	public void showGraph(StateMachine machine) {
		viewer.setInput(machine);
		viewer.getGraphControl().setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
		viewer.applyLayout();
	}
	
	@Override
	public void createPages() {
		// Creates the model from the editor input
		createModel();

		// Only creates the other pages if there is something that can be edited
		if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			// Create a page for the selection tree view.
			{
				ViewerPane viewerPane = new ViewerPane(getSite().getPage(),
						ExtendedLtsEditor.this) {
					@Override
					public Viewer createViewer(Composite composite) {
						Tree tree = new Tree(composite, SWT.MULTI);
						TreeViewer newTreeViewer = new TreeViewer(tree);
						return newTreeViewer;
					}

					@Override
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
				viewerPane.createControl(getContainer());

				selectionViewer = (TreeViewer)viewerPane.getViewer();
				selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

				selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
				selectionViewer.setInput(editingDomain.getResourceSet());
				selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
				viewerPane.setTitle(editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

				createContextMenuFor(selectionViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Selection");
			}

			// Create a page for the Graph view.
			{
				Resource resource = editingDomain.getResourceSet().getResources().get(0);
				Object obj = resource.getContents().get(0);

				StateMachine machine = (StateMachine) obj;
				createLtsGraph(getContainer(), machine);
				showGraph(machine);
			}

			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					setActivePage(0);
				}
			});
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(new ControlAdapter() {
			boolean guard = false;

			@Override
			public void controlResized(ControlEvent event) {
				if (!guard) {
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});

		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				updateProblemIndication();
			}
		});
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
			
			/* We just keep the original order */
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
				/* TODO there must be a nicer way how to do this :-) */
				if (e.button == 3) {
					menu.setVisible(true);
				}
			}
			
		});
		
		int pageIndex = addPage(viewer.getGraphControl());
		setPageText(pageIndex, "Graph view");
	}
}
