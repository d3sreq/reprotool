/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.ling.LingPackage;
import reprotool.ling.Sentence;
import reprotool.ling.Word;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sentence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.ling.impl.SentenceImpl#getWords <em>Words</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SentenceImpl extends EObjectImpl implements Sentence {
	/**
	 * The cached value of the '{@link #getWords() <em>Words</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWords()
	 * @generated
	 * @ordered
	 */
	protected EList<Word> words;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SentenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LingPackage.Literals.SENTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Word> getWords() {
		if (words == null) {
			words = new EObjectContainmentEList<Word>(Word.class, this, LingPackage.SENTENCE__WORDS);
		}
		return words;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void parseString(String inputString) {
    	if ( !inputString.isEmpty() ){
    		getWords().clear();
	    	for (String wordStr : inputString.split("\\s+")) {
	    		Word eword = LingFactoryImpl.eINSTANCE.createWord();
	    		eword.setWordStr(wordStr);
	    		getWords().add(eword);
	    	}
    	}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Sentence getNegatedString() {
    	Sentence negation = this;
    	int count_not = 0;
    	int count_no = 0;
    	//int count_vv = 0;
    	int has_neg = 0;
    	       
//    	// preprocessing
//        for (Iterator<WordLing> iword = negation.words.iterator(); iword.hasNext();) {
//        	WordLing word = iword.next();
//    		if(word.text.equals("n't")||word.text.equals("not")){        	
//    			count_not++;
//    		}
//    		if(word.text.equals("no")){        	
//    			count_no++;
//    		}
//    		if(word.negation.isEmpty()){        	
//    			has_neg++;
//    		}
//        	//JOptionPane.showMessageDialog(null, word.text,"Text Message",0);
//        }
//        if((count_not + count_no) > 0){
//        	// removing
//            for (Iterator<WordLing> iword = negation.words.iterator(); iword.hasNext();) {
//            	WordLing word = iword.next();
//        		if(word.text.equals("n't")||word.text.equals("not")||word.text.equals("no")){   
//        			iword.remove();
//        		}
//            }       	
//        } else {
//        	// positive sentence -> creating negative
//        	Iterator<WordLing> iword = negation.words.iterator();
//        	Boolean goon = true;
//        	int i = 0;
//        	for(i = 0; (goon && i<negation.words.size()); i++){
//        		if(negation.words.get(i).POS.contains("VBP")){ 
//        			goon = false;
//        		}       		
//        	}       	
//        	if(!goon){
//        		negation.words.add(i, new WordLing("not_RB"));
//        	} else {
//        		// last - logic negation (antonyms)
//	        	if (has_neg > 0){
//		        	iword = negation.words.iterator();
//		        	goon = true;
//		        	while(iword.hasNext() && goon){
//		        		WordLing word = iword.next();
//		        		
//		        		if(!word.negation.isEmpty()){ 
//		        			word.negate();
//		        			goon = false;
//		        		}       		
//		        	}
//	        	}
//        	}
//        }
    	return negation;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LingPackage.SENTENCE__WORDS:
				return ((InternalEList<?>)getWords()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LingPackage.SENTENCE__WORDS:
				return getWords();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LingPackage.SENTENCE__WORDS:
				getWords().clear();
				getWords().addAll((Collection<? extends Word>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LingPackage.SENTENCE__WORDS:
				getWords().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LingPackage.SENTENCE__WORDS:
				return words != null && !words.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		for (Word eword : getWords()) {
			buf.append( eword.getWordStr() );
			buf.append(" ");
		}
		
    	return buf.toString();
	}
} //SentenceImpl
