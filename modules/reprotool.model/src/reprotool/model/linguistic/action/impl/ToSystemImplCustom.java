package reprotool.model.linguistic.action.impl;

public class ToSystemImplCustom extends ToSystemImpl {
	
	@Override
	public String getSummary() {
		
		String senderName;
		
		try {
			senderName = getSender().getActor().getName();
		} catch (NullPointerException e) {
			senderName = "<Unknown Actor>";
		}
		
		return "Request sent by " + senderName;
	}
}
