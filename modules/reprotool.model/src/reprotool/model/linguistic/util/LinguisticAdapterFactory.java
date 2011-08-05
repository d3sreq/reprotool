/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.linguistic.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.linguistic.LinguisticPackage
 * @generated
 */
public class LinguisticAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LinguisticPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinguisticAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LinguisticPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinguisticSwitch<Adapter> modelSwitch =
		new LinguisticSwitch<Adapter>() {
			@Override
			public Adapter caseSentenceNode(SentenceNode object) {
				return createSentenceNodeAdapter();
			}
			@Override
			public Adapter caseWord(Word object) {
				return createWordAdapter();
			}
			@Override
			public Adapter caseParseNode(ParseNode object) {
				return createParseNodeAdapter();
			}
			@Override
			public Adapter caseNounPhraseNode(NounPhraseNode object) {
				return createNounPhraseNodeAdapter();
			}
			@Override
			public Adapter caseVerbPhraseNode(VerbPhraseNode object) {
				return createVerbPhraseNodeAdapter();
			}
			@Override
			public Adapter casePrepositionalPhraseNode(PrepositionalPhraseNode object) {
				return createPrepositionalPhraseNodeAdapter();
			}
			@Override
			public Adapter caseInnerParseNode(InnerParseNode object) {
				return createInnerParseNodeAdapter();
			}
			@Override
			public Adapter caseSentencePart(SentencePart object) {
				return createSentencePartAdapter();
			}
			@Override
			public Adapter caseText(Text object) {
				return createTextAdapter();
			}
			@Override
			public Adapter caseSubject(Subject object) {
				return createSubjectAdapter();
			}
			@Override
			public Adapter caseGotoTarget(GotoTarget object) {
				return createGotoTargetAdapter();
			}
			@Override
			public Adapter caseSentenceObject(SentenceObject object) {
				return createSentenceObjectAdapter();
			}
			@Override
			public Adapter caseRepresentativeObject(RepresentativeObject object) {
				return createRepresentativeObjectAdapter();
			}
			@Override
			public Adapter caseIndirectObject(IndirectObject object) {
				return createIndirectObjectAdapter();
			}
			@Override
			public Adapter caseVerb(Verb object) {
				return createVerbAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.SentenceNode <em>Sentence Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.SentenceNode
	 * @generated
	 */
	public Adapter createSentenceNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.Word
	 * @generated
	 */
	public Adapter createWordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.ParseNode <em>Parse Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.ParseNode
	 * @generated
	 */
	public Adapter createParseNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.NounPhraseNode <em>Noun Phrase Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.NounPhraseNode
	 * @generated
	 */
	public Adapter createNounPhraseNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.VerbPhraseNode <em>Verb Phrase Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.VerbPhraseNode
	 * @generated
	 */
	public Adapter createVerbPhraseNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.PrepositionalPhraseNode <em>Prepositional Phrase Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.PrepositionalPhraseNode
	 * @generated
	 */
	public Adapter createPrepositionalPhraseNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.InnerParseNode <em>Inner Parse Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.InnerParseNode
	 * @generated
	 */
	public Adapter createInnerParseNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.SentencePart <em>Sentence Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.SentencePart
	 * @generated
	 */
	public Adapter createSentencePartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.Text
	 * @generated
	 */
	public Adapter createTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.Subject
	 * @generated
	 */
	public Adapter createSubjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.GotoTarget <em>Goto Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.GotoTarget
	 * @generated
	 */
	public Adapter createGotoTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.SentenceObject <em>Sentence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.SentenceObject
	 * @generated
	 */
	public Adapter createSentenceObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.RepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.RepresentativeObject
	 * @generated
	 */
	public Adapter createRepresentativeObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.IndirectObject <em>Indirect Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.IndirectObject
	 * @generated
	 */
	public Adapter createIndirectObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.Verb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.Verb
	 * @generated
	 */
	public Adapter createVerbAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LinguisticAdapterFactory
