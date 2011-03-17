package reprotool.ide.views;

import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import reprotool.ide.parsetree.NodeContentProvider;
import reprotool.ide.parsetree.NodeLabelProvider;
import reprotool.ide.parsetree.NodeModelContentProvider;
import reprotool.model.linguistic.EWordType;
import reprotool.model.linguistic.SentenceNode;
import reprotool.model.linguistic.Word;

import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.jface.viewers.LabelProvider;


public class ParsedTreeView extends ViewPart {

	private GraphViewer viewer;
	
	public ParsedTreeView() {
		// TODO Auto-generated constructor stub
	}
	
	private void mapGraphNodes2EMF(SentenceNode modelRootNode) {
		Graph g = viewer.getGraphControl();
		List graphNodes = g.getNodes();
		
		// Find the root graph node.
		GraphNode root = (GraphNode) graphNodes.get(0);
		while (root.getTargetConnections().size() != 0) {
			root =  ((GraphConnection) root.getTargetConnections().get(0)).getSource();
		}
		
		createGraph2EMFMapping(root, modelRootNode);
	}
	
	private Menu createMenu(Composite parent) {
		Menu menu = new Menu(parent);
		
		MenuItem notImpItem = new MenuItem(menu, SWT.PUSH);
		notImpItem.setText("Not important");
		
		notImpItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = viewer.getGraphControl().getSelection();
				GraphNode node = (GraphNode) selection.get(0);
				Word word = (Word) node.getData();
				word.setWordType(EWordType.NOT_IMPORTANT);
				word.setType("Not important");
				node.setImage(((LabelProvider) viewer.getLabelProvider()).getImage(word));
			}
			
		});
		
		
		MenuItem subjectItem = new MenuItem(menu, SWT.PUSH);
		subjectItem.setText("Subject");
		
		subjectItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = viewer.getGraphControl().getSelection();
				GraphNode node = (GraphNode) selection.get(0);
				Word word = (Word) node.getData();
				word.setWordType(EWordType.SUBJECT);
				word.setType("Subject");
				node.setImage(((LabelProvider) viewer.getLabelProvider()).getImage(word));
			}
			
		});
		
		
		MenuItem indirectObjItem = new MenuItem(menu, SWT.PUSH);
		indirectObjItem.setText("Indirect o.");
		
		indirectObjItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = viewer.getGraphControl().getSelection();
				GraphNode node = (GraphNode) selection.get(0);
				Word word = (Word) node.getData();
				word.setWordType(EWordType.INDIRECT_OBJECT);
				word.setType("Indirect o.");
				node.setImage(((LabelProvider) viewer.getLabelProvider()).getImage(word));
			}
			
		});
		
		
		MenuItem verbItem = new MenuItem(menu, SWT.PUSH);
		verbItem.setText("verb");
		
		verbItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = viewer.getGraphControl().getSelection();
				GraphNode node = (GraphNode) selection.get(0);
				Word word = (Word) node.getData();
				word.setWordType(EWordType.VERB);
				word.setType("verb");
				node.setImage(((LabelProvider) viewer.getLabelProvider()).getImage(word));
			}
			
		});
		
		
		MenuItem repObjItem = new MenuItem(menu, SWT.PUSH);
		repObjItem.setText("Representative o.");
		
		repObjItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = viewer.getGraphControl().getSelection();
				GraphNode node = (GraphNode) selection.get(0);
				Word word = (Word) node.getData();
				word.setWordType(EWordType.REPRESENTATIVE_OBJECT);
				word.setType("Representative o.");
				node.setImage(((LabelProvider) viewer.getLabelProvider()).getImage(word));
			}
		});
		
		MenuItem gotoItem = new MenuItem(menu, SWT.PUSH);
		gotoItem.setText("Goto target");
		
		gotoItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = viewer.getGraphControl().getSelection();
				GraphNode node = (GraphNode) selection.get(0);
				Word word = (Word) node.getData();
				word.setWordType(EWordType.GOTO_TARGET);
				word.setType("Goto target");
				node.setImage(((LabelProvider) viewer.getLabelProvider()).getImage(word));
			}
		});
		
		
		MenuItem condItem = new MenuItem(menu, SWT.PUSH);
		condItem.setText("Condition label");
		
		condItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = viewer.getGraphControl().getSelection();
				GraphNode node = (GraphNode) selection.get(0);
				Word word = (Word) node.getData();
				word.setWordType(EWordType.CONDITION_LABEL);
				word.setType("Condition label");
				node.setImage(((LabelProvider) viewer.getLabelProvider()).getImage(word));
			}
		});
		
		return menu;
	}
	
	private void initGraphNode(GraphNode gNode, SentenceNode mNode) {
		gNode.setData(mNode);
		gNode.setBackgroundColor(new Color(Display.getDefault(), 255, 255, 255));
		gNode.setHighlightColor(new Color(Display.getDefault(), 255, 255, 255));
		
		if (mNode instanceof Word) {
			Word word = (Word) mNode;
			IFigure toolTip = new Label();
			((Label) toolTip).setText(word.getWordStr());
			gNode.setTooltip(toolTip);
		}
	}
	
	private void createGraph2EMFMapping(GraphNode gNode, SentenceNode mNode) {
		initGraphNode(gNode, mNode);
		
		for (int i = 0; i < gNode.getSourceConnections().size(); i++) {
			GraphConnection con = (GraphConnection) gNode.getSourceConnections().get(i);
			GraphNode gChild = con.getDestination();			
			SentenceNode mChild = mNode.getChildFragments().get(i);
			
			createGraph2EMFMapping(gChild, mChild);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
        
		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new NodeContentProvider());
		
		final NodeLabelProvider labelProvider = new NodeLabelProvider();
		viewer.setLabelProvider(labelProvider);
				
		NodeModelContentProvider model = new NodeModelContentProvider();
		viewer.setInput(model.getNodes());
		
		final Menu menu = createMenu(parent);
				
		mapGraphNodes2EMF(model.getRootNode());

		TreeLayoutAlgorithm tla = 
			new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		
		tla.setComparator(new Comparator() {
			
			/* We just keep the original order */
			@Override
			public int compare (Object node1, Object node2) {
				return 0;
			}
			
		});
				
		viewer.getGraphControl().addMouseListener(new MouseAdapter() {
			
			public void mouseDown(MouseEvent e) {
				List selection = ((Graph) e.widget).getSelection();
				
				/* Nothing is selected. */
				if (selection.size() == 0) {
					return;
				}
				
				/* We are only interested if a graph node has been selected. */
				if (!(selection.get(0) instanceof GraphNode)){
					return;
				}
				
				GraphNode node = (GraphNode) selection.get(0);
					
				int dx = e.x - node.getLocation().x;
				int dy = e.y - node.getLocation().y;
				
				int scrollX = 0;
				int scrollY = 0;
				
				if (viewer.getGraphControl().getHorizontalBar() != null) {
					scrollX = viewer.getGraphControl().getHorizontalBar().getSelection();
				}
				
				if (viewer.getGraphControl().getVerticalBar() != null) {
					scrollY = viewer.getGraphControl().getVerticalBar().getSelection();
				}
												
				SentenceNode modelNode = (SentenceNode) node.getData();
				Word wordNode = null;
				if (modelNode instanceof Word) {
					wordNode = (Word) modelNode;
				}
				
				if (wordNode != null) {
					
					if ((dx + scrollX > 105) && (dy + scrollY < 17)) {
						menu.setVisible(true);
					}
				}
			}
			
		});
		
		viewer.setLayoutAlgorithm(tla, true);
		viewer.applyLayout();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
