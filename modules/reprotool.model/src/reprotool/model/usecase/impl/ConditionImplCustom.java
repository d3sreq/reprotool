package reprotool.model.usecase.impl;

public class ConditionImplCustom extends ConditionImpl {
	
	@Override
	public String getContent() {
		return Utils.getContent(this);
	}
	
}
