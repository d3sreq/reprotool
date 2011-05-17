package reprotool.ide.parsetree;


import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import reprotool.model.linguistic.InnerParseNode;
import reprotool.model.linguistic.ParseNode;

public class NodeContentProvider extends ArrayContentProvider implements
		IGraphEntityContentProvider {

	@Override
	public Object[] getConnectedTo(Object entity) {
		
		if(! (entity instanceof ParseNode) )
			throw new RuntimeException("Type not supported");
		
		if (entity instanceof InnerParseNode) {
			InnerParseNode sentence = (InnerParseNode) entity;
			
			return sentence.getChildNodes().toArray();
		}
		
		return null;
	}

}
