package reprotool.lts.editor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;


import reprotool.model.lts.State;
import reprotool.model.lts.StateMachine;
import reprotool.model.lts.Transition;
import reprotool.model.lts.presentation.LtsEditor;

public class LTSDebugEditor extends LtsEditor {
	
	private StateMachine machine;
	private GraphViewer viewer;
	private Composite graphParent;
	private LayoutAlgorithm la;
	
	@Override
	public boolean isDirty() {
		return 
			super.isDirty() ||
			((LTSDebugActionBarContributor)getActionBarContributor()).isSaveNeeded();
	}
	

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		((LTSDebugActionBarContributor)getActionBarContributor()).clearDirty();
		super.doSave(progressMonitor);
	}
	
	
	public void fireChange() {
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}
		
	
	public void showGraph() {
		//viewer.setInput(machine);
		viewer.getGraphControl().setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
		viewer.applyLayout();
	}
	
	/**
	 * Selects the region in the GraphView that contains graph nodes.
	 * When we save the GraphView into file, we save only this region.
	 * @param shift Current coordinates shift
	 * @return Rectangle containing the graph nodes.
	 */
	private Rectangle getGraphRegion(Point shift, org.eclipse.swt.graphics.Rectangle bounds) {
		List graphNodes = viewer.getGraphControl().getNodes();
		Iterator it = graphNodes.iterator();
		
		if (!it.hasNext()) {
			return null;
		}
		
		GraphNode g1 = (GraphNode) it.next();
		
		int x0 = g1.getLocation().x;
		int y0 = g1.getLocation().y;
		int x1 = x0 + g1.getSize().width;
		int y1 = y0 + g1.getSize().height;
		
		Rectangle rect = new Rectangle(x0, y0, x1, y1);
		
		while (it.hasNext()) {
			GraphNode gNode = (GraphNode) it.next();
			
			x0 = gNode.getLocation().x;
			y0 = gNode.getLocation().y;
			
			x1 = x0 + gNode.getSize().width;
			y1 = y0 + gNode.getSize().height;
			
			if (x0 < rect.x)
				rect.x = x0;
			if (y0 < rect.y)
				rect.y = y0;
			if (x1 > rect.x + rect.width)
				rect.width = x1 - rect.x;
			if (y1 > rect.y + rect.height)
				rect.height = y1 - rect.y;
		}
		
		rect.x = rect.x - viewer.getGraphControl().getViewport().getClientArea().x + shift.x;
		rect.y = rect.y - viewer.getGraphControl().getViewport().getClientArea().y + shift.y;
		
		final int border = 15;
		
		rect.x = (rect.x - border > bounds.x ? rect.x - border : bounds.x);
		rect.y = (rect.y - border > bounds.y ? rect.y - border : bounds.y);
		
		if (rect.x + rect.width + 2 * border < bounds.width) {
			rect.width += 2 * border;
		} else {
			rect.width = bounds.width - rect.x;
		}
		
		if (rect.y + rect.height + 2 * border < bounds.height) {
			rect.height += 2 * border;
		} else {
			rect.height = bounds.height - rect.y;
		}
				
		return rect;
	}
	
	/**
	 * Find the graph node under the cursor.
	 * 
	 * @param x The x mouse cursor coordinate
	 * @param y The y mouse cursor coordinate
	 * @return If there is a graph node in the given position, it is returned. 
	 */
	private GraphNode getNodeUnderCursor(int x, int y) {
		List graphNodes = viewer.getGraphControl().getNodes();
		Iterator it = graphNodes.iterator();
		
		while (it.hasNext()) {
			GraphNode gNode = (GraphNode) it.next();
			int x0 = gNode.getLocation().x;
			int y0 = gNode.getLocation().y;
			int x1 = x0 + gNode.getSize().width;
			int y1 = y0 + gNode.getSize().height;
			
			if (
					(x0 <= x) && (x <= x1) &&
					(y0 <= y) && (y <= y1)
			) {
				return gNode;
			}
		}
		
		return null;
	}
	
	/**
	 * Find out how the view port is shifted with the scroll bars
	 * 
	 * @return Point that defines the horizontal and the vertical shift.
	 */
	private Point getShiftPoint() {
		int scrollX = 0;
		int scrollY = 0;
		
		if (viewer.getGraphControl().getHorizontalBar() != null) {
			scrollX = viewer.getGraphControl().getHorizontalBar().getSelection();
		}
		
		if (viewer.getGraphControl().getVerticalBar() != null) {
			scrollY = viewer.getGraphControl().getVerticalBar().getSelection();
		}
		
		return new Point(scrollX, scrollY);
	}
	
	
	@Override
	public void createPages() {
		createModel();

		if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), LTSDebugEditor.this) {
					
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
				selectionViewer
						.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

				selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
				selectionViewer.setInput(editingDomain.getResourceSet());
				selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
				viewerPane.setTitle(editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

				createContextMenuFor(selectionViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Selection");
			}
			
			{
				Resource resource = editingDomain.getResourceSet().getResources().get(0);
				Object obj = resource.getContents().get(0);
				
				machine = (StateMachine) obj;				
				graphParent = getContainer();
				
				la = new GXTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
				la.setComparator(new Comparator() {
					
					/* We just keep the original order */
					@Override
					public int compare (Object node1, Object node2) {
						return 0;
					}
					
				});
				
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
				
				
				final FigureProvider figureProvider = new FigureProvider();
				figureProvider.setMachine(machine);
							
		
				Map<State, GraphNode> map = new HashMap<State, GraphNode>();

				// draw the states
				for (State s : machine.getAllStates()) {
					if (
						(s == machine.getAbortState()) ||
						(s == machine.getSuccessState())
					) {
						continue;
					}

					GraphNode gNode = new CGraphNode(viewer.getGraphControl(), SWT.NONE, figureProvider.getFigure(s)); 
					gNode.setData(s);
					map.put(s, gNode);
				}

				// now connect the states with transitions
				for (Transition t : machine.getAllTransitions()) {
					GraphNode node1 = map.get(t.getSource());
					GraphNode node2 = map.get(t.getTarget());

					if (node1 != null && node2 != null) {
						GraphConnection conn = new GraphConnection(viewer.getGraphControl(),
						ZestStyles.CONNECTIONS_DIRECTED, node1, node2);

						if (t.getSentence() != null) {
							String transitionLabel = t.getSentence().getLabel();
							if(transitionLabel != null) {
								conn.setText(transitionLabel);
							}
						}
					}


					if (
						(node1 != null) && (node2 == null) &&
						(
							(t.getTarget() == machine.getAbortState()) ||
							(t.getTarget() == machine.getSuccessState())
						)
					) {
						GraphNode gNode = new CGraphNode(viewer.getGraphControl(), SWT.NONE,
						figureProvider.getFigure(t.getTarget()));

						gNode.setData(t.getTarget());

						GraphConnection conn = new GraphConnection(viewer.getGraphControl(),
						ZestStyles.CONNECTIONS_DIRECTED, node1, gNode);

						if (t.getSentence() != null) {
							String transitionLabel = t.getSentence().getLabel();
							if(transitionLabel != null) {
								conn.setText(transitionLabel);
							}
						}
					}
				}


				viewer.setLayoutAlgorithm(la, false);
				
				final Menu menu = new Menu(graphParent);
				MenuItem saveItem = new MenuItem(menu, SWT.PUSH);
				saveItem.setText("save image");
				
				saveItem.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						Display d = Display.getDefault();
						Shell s = graphParent.getShell();
						FileDialog fd = new FileDialog(s, SWT.SAVE);
						fd.setFilterExtensions(new String[] {"*.png"});
						fd.setText("Save");
						String selected = fd.open();
					        
						Graph g = viewer.getGraphControl();
						Point size = new Point(g.getContents().getSize().width, g.getContents().getSize().height);
						Image image = new Image(Display.getDefault(), size.x, size.y);
						GC gc = new GC(image);
						SWTGraphics swtGraphics = new SWTGraphics(gc);
						Point shiftPoint = getShiftPoint();
						
						g.getViewport().setLocation(shiftPoint);
						g.getViewport().paint(swtGraphics);
						gc.dispose();
						
						Rectangle graphRegion = getGraphRegion(shiftPoint, image.getBounds());
						Image trimmedImg = new Image(Display.getDefault(), graphRegion.width, graphRegion.height);
						gc = new GC(trimmedImg);
						gc.drawImage(image, graphRegion.x, graphRegion.y, graphRegion.width, graphRegion.height,
								0, 0, graphRegion.width, graphRegion.height);
						gc.dispose();

						ImageLoader loader = new ImageLoader();
						loader.data = new ImageData[] {trimmedImg.getImageData()};
						loader.save(selected, SWT.IMAGE_PNG);
						
						image.dispose();
						trimmedImg.dispose();
					}
					
				});
				
				viewer.getGraphControl().addMouseListener(new MouseAdapter() {
					List<ImageFigure> selectedFigures = new Vector<ImageFigure>();
					Map<ImageFigure, GraphItem> figure2Item = new HashMap<ImageFigure, GraphItem>();
					
					public void mouseDown(MouseEvent e) {
						/* TODO there must be a nicer way how to do this :-) */
						if (e.button == 3) {
							menu.setVisible(true);
						}
						
						if (e.button == 1) {
							List selectedItems = viewer.getGraphControl().getSelection();
							
							Point mousePoint = new Point(e.x, e.y);
							viewer.getGraphControl().getRootLayer().translateToRelative(mousePoint);
							
							GraphNode gNode = getNodeUnderCursor(mousePoint.x, mousePoint.y);
					
							if (gNode != null) {
								IFigure f = viewer.getGraphControl().getFigureAt(mousePoint.x, mousePoint.y);
							
								if (f instanceof ImageFigure) {
									ImageFigure imgF = (ImageFigure) f;
									imgF.setImage(figureProvider.getSelImage((State) gNode.getData()));
									selectedFigures.add(imgF);
									figure2Item.put(imgF, gNode);
								}
							}
							
							Set<ImageFigure> removedFigures = new HashSet<ImageFigure>();	
							for (ImageFigure imgF: selectedFigures) {
								if (!selectedItems.contains(figure2Item.get(imgF))) {
									imgF.setImage(figureProvider.getImage((State) ((figure2Item.get(imgF)).getData())));
									removedFigures.add(imgF);
								}
							}
							
							for (ImageFigure imgF: removedFigures) {
								selectedFigures.remove(imgF);
							}
							removedFigures.clear();
						}
					}
					
				});
				
				showGraph();

				int pageIndex = addPage(viewer.getGraphControl());
				setPageText(pageIndex, "Graph view");
			}	
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(
			
			new ControlAdapter() {
				boolean guard = false;
				
				@Override
				public void controlResized(ControlEvent event) {
					if (!guard) {
						guard = true;
						hideTabs();
						guard = false;
					}
				}
			}
		);

		getSite().getShell().getDisplay().asyncExec(
			
			new Runnable() {
				public void run() {
					updateProblemIndication();
				}
			}
			
		);
	}
}
