package reprotool.ide.parsetree;


import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import reprotool.model.linguistic.SentenceNode;

public class NodeContentProvider extends ArrayContentProvider implements
		IGraphEntityContentProvider {

	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof SentenceNode) {
			SentenceNode sentence = (SentenceNode) entity;
			
			return sentence.getChildFragments().toArray();
		}
		
		throw new RuntimeException("Type not supported");
	}

}
