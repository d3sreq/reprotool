//package reprotool.ide.parsetree;
//
//import org.eclipse.jface.viewers.ArrayContentProvider;
//import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
//
//import reprotool.model.linguistic.parsetree.InnerParseNode;
//import reprotool.model.linguistic.parsetree.Word;
//
//public class NodeContentProvider extends ArrayContentProvider implements IGraphEntityContentProvider {
//
//	@Override
//	public Object[] getConnectedTo(Object entity) {
//		if (entity instanceof InnerParseNode) {
//			InnerParseNode sentence = (InnerParseNode) entity;
//
//			return sentence.getChildNodes().toArray();
//		}
//
//		if (entity instanceof Word) {
//			return null;
//		}
//
//		throw new RuntimeException("Type " + entity.getClass() + " not supported");
//	}
//
//}
