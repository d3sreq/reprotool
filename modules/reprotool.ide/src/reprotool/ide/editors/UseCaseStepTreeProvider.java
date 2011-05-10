package reprotool.ide.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

import reprotool.model.specification.UseCase;
import reprotool.model.specification.UseCaseStep;

public class UseCaseStepTreeProvider implements ITreeContentProvider,ITableLabelProvider  {
	private HashMap<UseCaseStep, UseCaseStep> parentMap = null;
	
	// ITreeContentProvider methods
	
	private void buildParentMap(UseCase uc) {
		parentMap = new HashMap<UseCaseStep, UseCaseStep>();
		for (UseCaseStep step : uc.getUseCaseSteps()) {
			do {
				addChildren(step);
				step = step.getNextStep();
			} while (step != null);
		}
	}

	private void addChildren(UseCaseStep root) {
		Object[] children = getChildren(root);
		for (Object ch : children) {
			UseCaseStep child = (UseCaseStep)ch;
			parentMap.put(child, root);
			addChildren(child);
		}
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput != null)
			buildParentMap((UseCase)newInput);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return ((UseCase) inputElement).getUseCaseSteps().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		UseCaseStep step = (UseCaseStep)parentElement;
		List<UseCaseStep> res = new ArrayList<UseCaseStep>();
		List<UseCaseStep> children = new ArrayList<UseCaseStep>();
		children.addAll(step.getVariations());
		children.addAll(step.getExtensions());
		for (UseCaseStep child : children) {
			do {
				res.add(child);
				child = child.getNextStep();
			} while (child != null);
		}
		return res.toArray();
	}

	@Override
	public Object getParent(Object element) {
		return parentMap.get(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		UseCaseStep step = (UseCaseStep)element;
		return !(step.getExtensions().isEmpty() && step.getVariations().isEmpty());
	}
	
	// ITableLabelProvider methods
	
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		UseCaseStep step = (UseCaseStep) element;
		String result = "";
		switch (columnIndex) {
		case 0:
			result = step.getLabel();
			if (result == null)
				result = "none";
			if (!step.getVariations().isEmpty()) {
				result += " (!)";
			}
			break;
		case 1:
			result = step.getSentence();
			break;
		case 2:
			UseCaseStep parent = parentMap.get(step);
			if (parent != null) {
				if (parent.getExtensions().contains(step)) {
					result = "extension";
				}
				else if (parent.getVariations().contains(step)) {
					result = "variation";
				}
			}
			break;
		case 3:
			result = "x";
			break;
		}
		return result;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}
}
