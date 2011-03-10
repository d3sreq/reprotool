package reprotool.ide.views;

import java.util.Comparator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import reprotool.ide.parsetree.NodeContentProvider;
import reprotool.ide.parsetree.NodeLabelProvider;
import reprotool.ide.parsetree.NodeModelContentProvider;

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

		TreeLayoutAlgorithm tla = 
			new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		
		tla.setComparator(new Comparator() {
			
			/* We just keep the original order */
			@Override
			public int compare (Object node1, Object node2) {
				return 0;
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
