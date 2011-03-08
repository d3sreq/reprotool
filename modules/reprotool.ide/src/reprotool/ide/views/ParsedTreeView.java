package reprotool.ide.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

public class ParsedTreeView extends ViewPart {

	private Graph graph;
	
	public ParsedTreeView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
        parent.setLayout(new FillLayout());
		
		// Graph will hold all other objects
        graph = new Graph(parent, SWT.NONE);
        
        // Now a few nodes
        GraphNode n1 = new GraphNode(graph, SWT.NONE, "one");
        GraphNode n2 = new GraphNode(graph, SWT.NONE, "two");
        GraphNode n3 = new GraphNode(graph, SWT.NONE, "three");
        GraphNode n4 = new GraphNode(graph, SWT.NONE, "four");
        GraphNode n5 = new GraphNode(graph, SWT.NONE, "five");
        GraphNode n6 = new GraphNode(graph, SWT.NONE, "six");

        // Lets have a directed connection
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, n1, n2);
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, n1, n3);
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, n1, n4);
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, n3, n5);
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, n3, n6);
         
        TreeLayoutAlgorithm tla = new TreeLayoutAlgorithm();
        
        graph.setLayoutAlgorithm(tla, true);
        
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
