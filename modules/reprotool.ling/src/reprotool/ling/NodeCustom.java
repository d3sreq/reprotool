package reprotool.ling;

public class NodeCustom extends Node {
	
	@Override
	public static Node fromString(String text) {
		if (text != null) {
			for (Node node : Node.values()) {
				if (text.equalsIgnoreCase(node.toString())) {
					return node;
				}
			}
		}
		return Node.X;
	}	
}
