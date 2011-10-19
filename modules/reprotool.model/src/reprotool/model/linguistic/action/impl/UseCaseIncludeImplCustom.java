package reprotool.model.linguistic.action.impl;

public class UseCaseIncludeImplCustom extends UseCaseIncludeImpl {
	
	@Override
	public String getSummary() {
		try {
			return getIncludeTarget().getName();
		} catch (NullPointerException e) {
			return "Unknown Use Case";
		}
	}
}
