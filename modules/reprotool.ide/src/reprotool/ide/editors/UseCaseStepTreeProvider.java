package reprotool.ide.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.graphics.Image;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseStepTreeProvider implements ITreeContentProvider, ITableLabelProvider  {
	
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
			children.addAll(parentStep.getVariation());
			children.addAll(parentStep.getExtension());

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
			return ! (step.getExtension().isEmpty() && step.getVariation().isEmpty());
		} else if (element instanceof Scenario) {
			return ! ((Scenario) element).getSteps().isEmpty();
		} else {
			assert(false);
			return false;
		}
	}
	
	// ITableLabelProvider methods
	
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}
	
	/**
	 * Used for the implementation of different row types (UseCaseStep and Scenario)
	 * @author Viliam Simko
	 */
	private interface RowRenderer {
		public void setElement(Object element);
		public String getSentenceColumn();
		public String getTypeColumn();
		public String getParsedColumn();
		public String getLabelColumn();
	}
	
	RowRenderer useCaseStepRenderer = new RowRenderer() {
		private UseCaseStep step;
		
		@Override
		public void setElement(Object element) {
			step = (UseCaseStep) element;
		}
		
		@Override
		public String getLabelColumn() {
			return step.getLabel();
		}
		
		@Override
		public String getTypeColumn() {
			return "step";
		}

		@Override
		public String getSentenceColumn() {
			if (step.getSentence().contains(UseCaseEditor.ACTOR_ESCAPE_SEQ) || step.getSentence().contains(UseCaseEditor.STEP_ESCAPE_SEQ)) {
				Document d = new Document(step.getSentence());
				UseCaseEditor.parseSentence(d, new AnnotationModel(), UseCaseEditor.getUseCase(step));
				return d.get();
			}
			else
				return step.getSentence();
		}

		@Override
		public String getParsedColumn() {
			return "x";
		}
	};
	
	RowRenderer scenarioRenderer = new RowRenderer() {
		Scenario scen;
		
		@Override
		public void setElement(Object element) {
			scen = (Scenario) element;
		}
		
		@Override
		public String getLabelColumn() {
			return "*";
		}
				
		@Override
		public String getTypeColumn() {
			UseCaseStep parentStep = (UseCaseStep) scen.eContainer();

			if (parentStep.getExtension().contains(scen))
				return "extension";

			if (parentStep.getVariation().contains(scen))
				return "variation";

			return "unknown";
		}

		@Override
		public String getSentenceColumn() {
			if (scen.getDescription() == null || scen.getDescription().isEmpty())
				return getTypeColumn();
			else
				return getTypeColumn()+": "+scen.getDescription();
		}

		@Override
		public String getParsedColumn() {
			return "";
		}
	};
	
	public String getColumnText(final Object element, int columnIndex) {
		
		RowRenderer adapter = null;
		
		if(element instanceof UseCaseStep)
			adapter = useCaseStepRenderer;
		else if(element instanceof Scenario)
			adapter = scenarioRenderer;
			
		if(adapter == null)
			return "null";
		
		adapter.setElement(element);
		
		switch (columnIndex) {
			case 0: return adapter.getLabelColumn();
			case 1: return adapter.getSentenceColumn();
			case 2: return adapter.getTypeColumn();
			case 3: return adapter.getParsedColumn();
		}
		
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
