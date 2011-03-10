package reprotool.ide.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutStyles;


import reprotool.ide.parsetree.NodeContentProvider;
import reprotool.ide.parsetree.NodeLabelProvider;
import reprotool.ide.parsetree.NodeModelContentProvider;
import reprotool.ide.parsetree.ParsedTreeLayoutAlgorithm;

public class ParsedTreeView extends ViewPart {

	private GraphViewer viewer;
	
	public ParsedTreeView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
        
		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new NodeContentProvider());
		viewer.setLabelProvider(new NodeLabelProvider());
		NodeModelContentProvider model = new NodeModelContentProvider();
		viewer.setInput(model.getNodes());

		ParsedTreeLayoutAlgorithm tla = 
			new ParsedTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		
		viewer.setLayoutAlgorithm(tla, true);
		viewer.applyLayout();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
