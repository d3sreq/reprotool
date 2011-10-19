package reprotool.model.linguistic.action.impl;

public class GotoImplCustom extends GotoImpl {
	@Override
	public String getSummary() {
		try {
			return getGotoTarget().getLabel();
		} catch (NullPointerException e) {
			return "Unknown step";
		}
	}
}