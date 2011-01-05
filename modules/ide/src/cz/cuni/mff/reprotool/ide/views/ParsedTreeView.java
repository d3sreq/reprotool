package cz.cuni.mff.reprotool.ide.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import com.swtdesigner.SWTResourceManager;

public class ParsedTreeView extends ViewPart {

	private Graph graph;
	
	public ParsedTreeView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
        parent.setLayout(new FormLayout());
		
		// Graph will hold all other objects
        graph = new Graph(parent, SWT.NONE);
        FormData fd_graph = new FormData();
        fd_graph.left = new FormAttachment(0, 10);
        fd_graph.bottom = new FormAttachment(100, -10);
        graph.setLayoutData(fd_graph);
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
        
        Group grpToken = new Group(parent, SWT.NONE);
        fd_graph.right = new FormAttachment(grpToken, 0, SWT.RIGHT);
        grpToken.setText("Token");
        grpToken.setLayout(new FormLayout());
        FormData fd_grpToken = new FormData();
        fd_grpToken.top = new FormAttachment(0, 10);
        fd_grpToken.left = new FormAttachment(0, 10);
        fd_grpToken.bottom = new FormAttachment(0, 72);
        fd_grpToken.right = new FormAttachment(100, -10);
        grpToken.setLayoutData(fd_grpToken);
        
        Label lbltokentext = new Label(grpToken, SWT.NONE);
        lbltokentext.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
        lbltokentext.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
        FormData fd_lbltokentext = new FormData();
        fd_lbltokentext.top = new FormAttachment(0, 10);
        fd_lbltokentext.left = new FormAttachment(0, 10);
        lbltokentext.setLayoutData(fd_lbltokentext);
        lbltokentext.setText("#tokenText");
        
        Group grpAnalysisResult = new Group(parent, SWT.NONE);
        fd_graph.top = new FormAttachment(grpAnalysisResult, 6);
        grpAnalysisResult.setText("Analysis result");
        FormData fd_grpAnalysisResult = new FormData();
        fd_grpAnalysisResult.bottom = new FormAttachment(grpToken, 76, SWT.BOTTOM);
        fd_grpAnalysisResult.top = new FormAttachment(grpToken, 6);
        fd_grpAnalysisResult.right = new FormAttachment(grpToken, 0, SWT.RIGHT);
        fd_grpAnalysisResult.left = new FormAttachment(0, 10);
        grpAnalysisResult.setLayoutData(fd_grpAnalysisResult);
        
        Label lblStepIsA = new Label(grpAnalysisResult, SWT.NONE);
        lblStepIsA.setBounds(10, 26, 49, 13);
        lblStepIsA.setText("Step is a");
        
        Combo combo = new Combo(grpAnalysisResult, SWT.NONE);
        combo.setBounds(65, 23, 92, 21);
        combo.setText("internal");
        
        Label lblAction = new Label(grpAnalysisResult, SWT.NONE);
        lblAction.setBounds(163, 26, 49, 13);
        lblAction.setText("action");

        TreeLayoutAlgorithm tla = new TreeLayoutAlgorithm();
        
        graph.setLayoutAlgorithm(tla, true);
        
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
