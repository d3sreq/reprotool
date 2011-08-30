/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.parsetree.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import reprotool.model.linguistic.parsetree.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see reprotool.model.linguistic.parsetree.ParsetreePackage
 * @generated
 */
public class ParsetreeSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ParsetreePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParsetreeSwitch() {
		if (modelPackage == null) {
			modelPackage = ParsetreePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ParsetreePackage.SENTENCE_NODE: {
				SentenceNode sentenceNode = (SentenceNode)theEObject;
				T result = caseSentenceNode(sentenceNode);
				if (result == null) result = caseInnerParseNode(sentenceNode);
				if (result == null) result = caseParseNode(sentenceNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParsetreePackage.WORD: {
				Word word = (Word)theEObject;
				T result = caseWord(word);
				if (result == null) result = caseParseNode(word);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParsetreePackage.PARSE_NODE: {
				ParseNode parseNode = (ParseNode)theEObject;
				T result = caseParseNode(parseNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParsetreePackage.NOUN_PHRASE_NODE: {
				NounPhraseNode nounPhraseNode = (NounPhraseNode)theEObject;
				T result = caseNounPhraseNode(nounPhraseNode);
				if (result == null) result = caseInnerParseNode(nounPhraseNode);
				if (result == null) result = caseParseNode(nounPhraseNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParsetreePackage.VERB_PHRASE_NODE: {
				VerbPhraseNode verbPhraseNode = (VerbPhraseNode)theEObject;
				T result = caseVerbPhraseNode(verbPhraseNode);
				if (result == null) result = caseInnerParseNode(verbPhraseNode);
				if (result == null) result = caseParseNode(verbPhraseNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParsetreePackage.PREPOSITIONAL_PHRASE_NODE: {
				PrepositionalPhraseNode prepositionalPhraseNode = (PrepositionalPhraseNode)theEObject;
				T result = casePrepositionalPhraseNode(prepositionalPhraseNode);
				if (result == null) result = caseInnerParseNode(prepositionalPhraseNode);
				if (result == null) result = caseParseNode(prepositionalPhraseNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParsetreePackage.INNER_PARSE_NODE: {
				InnerParseNode innerParseNode = (InnerParseNode)theEObject;
				T result = caseInnerParseNode(innerParseNode);
				if (result == null) result = caseParseNode(innerParseNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sentence Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sentence Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSentenceNode(SentenceNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Word</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Word</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWord(Word object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parse Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parse Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParseNode(ParseNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Noun Phrase Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Noun Phrase Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNounPhraseNode(NounPhraseNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verb Phrase Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verb Phrase Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerbPhraseNode(VerbPhraseNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prepositional Phrase Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prepositional Phrase Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrepositionalPhraseNode(PrepositionalPhraseNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inner Parse Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inner Parse Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInnerParseNode(InnerParseNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ParsetreeSwitch
