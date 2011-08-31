package reprotool.ide.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.TextStyle;

import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseStepTreeProvider extends StyledCellLabelProvider implements ITreeContentProvider {
	
	@Override
	public void inputChanged(org.eclipse.jface.viewers.Viewer viewer,
			Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		// list only contents of a UseCase
		if( ! (inputElement instanceof UseCase) )
			return null;
			
		UseCase usecase = (UseCase) inputElement;
		if (usecase.getMainScenario() == null)
			return new Object[] {};
		return usecase.getMainScenario().getSteps().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof UseCaseStep) {
			
			UseCaseStep parentStep = (UseCaseStep) parentElement; 

			List<Scenario> children = new ArrayList<Scenario>();
			// TODO - jvinarek - fix
//			children.addAll(parentStep.getVariation());
//			children.addAll(parentStep.getExtension());

			return children.toArray();
			
		} else if (parentElement instanceof Scenario) {
			return ((Scenario) parentElement).getSteps().toArray();
		}
		
		return null;
	}
	
	@Override
	public Object getParent(Object element) {
		EObject obj = (EObject) element;
		return obj.eContainer();
	}

	@Override
	public boolean hasChildren(Object element) {
		//return getChildren(element).length > 0;
		if(element instanceof UseCaseStep) {
			UseCaseStep step = (UseCaseStep)element;
			return ! (step.getExtensions().isEmpty() && step.getVariations().isEmpty());
		} else if (element instanceof Scenario) {
			return ! ((Scenario) element).getSteps().isEmpty();
		} else {
			assert(false);
			return false;
		}
	}
	
	// --
	
	/**
	 * Used for the implementation of different row types (UseCaseStep and Scenario)
	 * @author Viliam Simko
	 */
	private interface RowRenderer {
		public void setElement(Object element);
		public StyledString getSentenceColumn();
		public StyledString getTypeColumn();
		public StyledString getParsedColumn();
		public StyledString getLabelColumn();
	}
	
	RowRenderer useCaseStepRenderer = new RowRenderer() {
		private UseCaseStep step;
		private Styler styler = new StyledString.Styler() {
				@Override
				public void applyStyles(TextStyle textStyle) {
					textStyle.borderStyle = SWT.BORDER_SOLID;
					textStyle.borderColor = new Color(null, 20, 200, 20);
				}
			};
		
		@Override
		public void setElement(Object element) {
			step = (UseCaseStep) element;
		}
		
		@Override
		public StyledString getLabelColumn() {
			return new StyledString(step.getLabel());
		}
		
		@Override
		public StyledString getTypeColumn() {
			return new StyledString("step");
		}

		@Override
		public StyledString getSentenceColumn() {
			// TODO - jvinarek - fix
//			StyledString res = new StyledString(step.getSentence());
			StyledString res = new StyledString("");
			if (step.getSentenceNodes().isEmpty())
				return res;
			
			int offset = 0;
			for (Text p : step.getSentenceNodes()) {
				if (p.getActionPart() == null) {
					offset += p.getContent().length();
					continue;
				}
				res.setStyle(offset, p.getContent().length(), styler);
				offset += p.getContent().length();
			}
			return res;
		}

		@Override
		public StyledString getParsedColumn() {
			return new StyledString("x");
		}
	};
	
	RowRenderer scenarioRenderer = new RowRenderer() {
		Scenario scen;
		
		@Override
		public void setElement(Object element) {
			scen = (Scenario) element;
		}
		
		@Override
		public StyledString getLabelColumn() {
			return new StyledString("*");
		}
				
		@Override
		public StyledString getTypeColumn() {
			UseCaseStep parentStep = (UseCaseStep) scen.eContainer();

			// TODO - jvinarek - fix
//			if (parentStep.getExtension().contains(scen))
//				return new StyledString("extension");
//
//			if (parentStep.getVariation().contains(scen))
//				return new StyledString("variation");

			return new StyledString("unknown");
		}

		@Override
		public StyledString getSentenceColumn() {
			if (scen.getDescription() == null || scen.getDescription().isEmpty())
				return getTypeColumn();
			else
				return new StyledString(getTypeColumn().toString()+": "+scen.getDescription());
		}

		@Override
		public StyledString getParsedColumn() {
			return new StyledString();
		}
	};
	
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		RowRenderer adapter = null;
		if(element instanceof UseCaseStep)
			adapter = useCaseStepRenderer;
		else if(element instanceof Scenario)
			adapter = scenarioRenderer;
		adapter.setElement(element);
		
		int columnIndex = cell.getColumnIndex();
		StyledString text = null;
		switch (columnIndex) {
			case 0: text = adapter.getLabelColumn(); break;
			case 1: text = adapter.getSentenceColumn(); break;
			case 2: text = adapter.getTypeColumn(); break;
			case 3: text = adapter.getParsedColumn(); break;
		}
		
		cell.setText(text.toString());
		cell.setStyleRanges(text.getStyleRanges());
		super.update(cell);
	}

	public String getColumnText(final Object element, int columnIndex) {
		return null;
	}

	@Override
	public void dispose() {}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {}
}
