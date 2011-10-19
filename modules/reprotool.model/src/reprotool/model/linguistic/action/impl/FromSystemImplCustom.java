package reprotool.model.linguistic.action.impl;

public class FromSystemImplCustom extends FromSystemImpl {

	@Override
	public String getSummary() {
		
		String receiverName;
		
		try {
			receiverName = getReceiver().getActor().getName();
		} catch (NullPointerException e) {
			receiverName = "<Unknown Actor>";
		}
		
		return "Request received by " + receiverName;
	}
}