package reprotool.ide.editors.project.action;


public class RemoveActorAction extends AbstractAddAction {

	public RemoveActorAction() {
		super("Add actor");
	}

	@Override
	public void run() {
		System.out.println("Removed");
	}
}
