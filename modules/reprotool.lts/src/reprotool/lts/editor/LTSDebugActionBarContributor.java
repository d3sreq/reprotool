package reprotool.lts.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import reprotool.model.lts.State;
import reprotool.model.lts.Transition;
import reprotool.model.lts.presentation.LtsActionBarContributor;
import reprotool.model.usecase.UseCaseStep;


public class LTSDebugActionBarContributor extends LtsActionBarContributor {	
	protected Collection<IAction> createReprotoolActions;
	
	protected Transition selectedTransition;
	protected State selectedState;
	protected UseCaseStep selectedSentence;
	
	private final int SEL_STATE_TRANSITION = 1;
	private final int SEL_UCASE_TRANSITION = 2;
	
	private boolean dirty = false;

	
	public boolean isSaveNeeded() {
		return dirty;
	}
	
	
	public void clearDirty() {
		dirty = false;
	}
	
	
	private void refreshGraph() {
		((LTSDebugEditor)getActiveEditor()).showGraph();
	}

	
	private Collection<IAction> generateReprotoolActions(int selection) {
		Collection<IAction >actions = new ArrayList<IAction>();
		
		switch (selection) {
		
		case SEL_STATE_TRANSITION:
			actions.add(
				new Action("Set state as action source") {
					
					@Override
					public void run() {
						selectedTransition.setSource(selectedState);
						dirty = true;
						((LTSDebugEditor)getActiveEditor()).fireChange();
						refreshGraph();
					}
				}
			);
			
			actions.add(
				new Action("Set state as action target") {

					@Override
					public void run() {
						selectedTransition.setTarget(selectedState);
						dirty = true;
						((LTSDebugEditor)getActiveEditor()).fireChange();
						refreshGraph();
					}
				}
			);
			break;
		
		case SEL_UCASE_TRANSITION:
			actions.add(
				new Action("Set action transition sentence") {
						
					@Override
					public void run() {
						selectedTransition.setSentence(selectedSentence);
						dirty = true;
						((LTSDebugEditor)getActiveEditor()).fireChange();
						refreshGraph();
					}
				}
			);
			break;
		}
		
		return actions;
	}

	
	public void selectionChanged(SelectionChangedEvent event) {
		super.selectionChanged(event);
		
		refreshGraph();
		
		createReprotoolActions = new ArrayList<IAction>();
		ISelection selection = event.getSelection();

		if (
				selection instanceof IStructuredSelection && 
				((IStructuredSelection)selection).size() == 2
		) {			
			Iterator itr = ((IStructuredSelection)selection).iterator();
			
			Object obj1 = itr.next();
			Object obj2 = itr.next();
			
			if ((obj1 instanceof Transition) && (obj2 instanceof State)) {
				selectedTransition = (Transition) obj1;
				selectedState = (State) obj2;
				createReprotoolActions = generateReprotoolActions(SEL_STATE_TRANSITION);
			}
			
			else if ((obj1 instanceof Transition) && (obj2 instanceof UseCaseStep)) {
				selectedTransition = (Transition) obj1;
				selectedSentence = (UseCaseStep) obj2;
				createReprotoolActions = generateReprotoolActions(SEL_UCASE_TRANSITION);
			}
		}
	}


	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		super.menuAboutToShow(menuManager);
		
		MenuManager submenuManager = new MenuManager("Reprotool");
		populateManager(submenuManager, createReprotoolActions, null);
		menuManager.insertBefore("edit", submenuManager);
	}
}