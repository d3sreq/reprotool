package reprotool.ling.tools;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;

import reprotool.model.linguistic.parsetree.InnerParseNode;
import reprotool.model.linguistic.parsetree.NounPhraseNode;
import reprotool.model.linguistic.parsetree.ParsetreeFactory;
import reprotool.model.linguistic.parsetree.PrepositionalPhraseNode;
import reprotool.model.linguistic.parsetree.SentenceNode;
import reprotool.model.linguistic.parsetree.VerbPhraseNode;
import reprotool.model.linguistic.parsetree.Word;

import danbikel.lisp.Sexp;
import danbikel.parser.Settings;

/*
 * 
 * Parser
 * D:\Projects\ReProTool\dbparser>java -server -cp D:\Projects\ReProTool\dbparser\dbparser.jar -Dparser.settingsFile=collins.properties danbikel.parser.Parser -isD:\Projects\ReProTool\dbparser\wsj-02-21.obj.gz -sa D:\Projects\ReProTool\dbparser\test.txt
 * 
 * Trainer
 * D:\Projects\ReProTool\dbparser>java -Xms800m -Xmx800m -cp dbparser.jar -Dparser.settingsFile=collins.properties danbikel.parser.Trainer -it -l wsj-02-21.observed.gz -od wsj-02-21.obj.gz
 */

public class Parser {
	/**
	 * Parse trees of each sentence
	 *
	 * @return String parsed_tree 
	 */	
	
	/*
	 *  internal node enum
	 *  for switches 
	 */
	public enum Node {
		NP, VP, PP, FRAG,
		X;
		
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
	
    public static String getString(String originalText) {	
    	String settingsFile = "";
    	Sexp result = null;
    	String modelFile = "";
    	
		// locating external model
		try{
			modelFile = Platform.getPreferencesService().getString("reprotool.ide", "parserModel", "/wsj-02-21.obj.gz", null);
		} catch (NullPointerException e){
			String rootPath = new java.io.File(Tagger.class.getResource("/").getPath()).getParentFile().getParent();
			modelFile = rootPath + "/../tools/parser/wsj-02-21.obj.gz";
		}
		System.out.print(modelFile);
 
		// locating external settings
		try{
			settingsFile = Platform.getPreferencesService().getString("reprotool.ide", "parserSettings", "/collins.properties", null);
		} catch (NullPointerException e){
			String rootPath = new java.io.File(Tagger.class.getResource("/").getPath()).getParentFile().getParent();
			settingsFile = rootPath + "/../tools/parser/collins.properties";
		}
		System.out.print(settingsFile);
		
    	/* CMD LINE LIKE EXECUTION
    	String[] args = new String[6];
    	 	
    	
    	args[0] = "-sf";
    	args[1] = "D:\\Projects\\ReProTool\\dbparser\\collins.properties";
    	args[2] = "-is";
    	args[3] = "D:\\Projects\\ReProTool\\dbparser\\wsj-02-21.obj.gz";
    	args[4] = "-sa";
    	args[5] = "D:\\Projects\\ReProTool\\dbparser\\test.txt";
    	
		// set output stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setErr(ps);

    	// run parser
    	danbikel.parser.Parser.main(args);  
    	
    	try{
			parsedTree = baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e){}
    	*/

    	try {
			Settings.load(settingsFile);
		} catch (IOException e) {}
		
    	danbikel.parser.Parser parser = null;
    	
		try {
			//parser = new danbikel.parser.Parser("D:\\Projects\\ReProTool\\dbparser\\wsj-02-21.obj.gz");
			parser = new danbikel.parser.Parser(modelFile);
			
		} catch (RemoteException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (NoSuchMethodException e2) {
			e2.printStackTrace();
		} catch (InvocationTargetException e2) {
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		} catch (InstantiationException e2) {
			e2.printStackTrace();
		}
			
		try {
			result = parser.parse(Sexp.read(originalText).list());
		} catch (Exception e) {
			System.err.print("Invalid input string!");
		}
    	return result.toString();
    }
    
	/**
	 * Parse trees of each sentence
	 *
	 * @return SentenceNode parsed_tree 
	 */	
	
    public static SentenceNode getTree(String parsedText) {	
    	// root node    	
		ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;
		SentenceNode rootNode = factory.createSentenceNode();
		
    	if (parsedText.isEmpty()){
	    	return rootNode;
    	}

    	Word curWord = null;
    	InnerParseNode curNode = rootNode;
	   	//TODO spravny STROM - zleva uzly a uzavorkovani
				
    	// removing head S (sentence) node
    	if(parsedText.startsWith("(S") && parsedText.endsWith(")")) {
    		parsedText = parsedText.substring(2, parsedText.length()-1).trim();
    	}    	
    	
		// string preparation
		//parsedText = Pattern.compile("[(]").matcher(parsedText).replaceAll("( ");
    	parsedText = Pattern.compile("[)]").matcher(parsedText).replaceAll(" )");	
		// whitespaces cleanup
		parsedText = Pattern.compile("[\\s]+").matcher(parsedText).replaceAll(" ");
		
		//System.out.print(parsedText + "\n");
		
		boolean atWord = false;
	    for (String symbol : parsedText.split("\\s")) {
	    	
	    	if(symbol.startsWith("(")) { // start node
	    		symbol = symbol.substring(1).toUpperCase();
	    		Node node = Node.fromString(symbol);
	    		
	    		switch(node){
	    		case NP:
	    			NounPhraseNode nounPhrase = factory.createNounPhraseNode();
	    			curNode.getChildNodes().add(nounPhrase);
	    			nounPhrase.setParentNode(curNode);
	    			curNode = nounPhrase;
	    			break;
	    		case VP:
	    			VerbPhraseNode verbPhrase = factory.createVerbPhraseNode();
	    			curNode.getChildNodes().add(verbPhrase);
	    			verbPhrase.setParentNode(curNode);
	    			curNode = verbPhrase;
	    			break;	
	    		case PP:
	    			PrepositionalPhraseNode prepositionalPhrase = factory.createPrepositionalPhraseNode();
	    			curNode.getChildNodes().add(prepositionalPhrase);
	    			prepositionalPhrase.setParentNode(curNode);
	    			curNode = prepositionalPhrase;
	    			break;	
	    		case FRAG:
	    			
	    			break;
	    		default:
	    			// preparation for new word (at POS)
	    			curWord = factory.createWord();	
	    			curWord.setWordPOS(symbol);
	    			curNode.getChildNodes().add(curWord);	
	    			atWord = true;

	    			break;
	    		}
	    	} else if(symbol.startsWith(")")) { // end node
	    		
	    		if(!atWord){
	    			
	    			curNode = curNode.getParentNode();
	    		} else {
	    			atWord = false;
	    		}
	    	} else { // word
    			curWord.setWordStr(symbol);
	    	}
  		
	    }
	    	
    	return rootNode;
    }
    
}
