/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.model.linguistic.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinguisticFactoryImpl extends EFactoryImpl implements LinguisticFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LinguisticFactory init() {
		try {
			LinguisticFactory theLinguisticFactory = (LinguisticFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/model/linguistic"); 
			if (theLinguisticFactory != null) {
				return theLinguisticFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LinguisticFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinguisticFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LinguisticPackage.SENTENCE_NODE: return createSentenceNode();
			case LinguisticPackage.WORD: return createWord();
			case LinguisticPackage.NOUN_PHRASE_NODE: return createNounPhraseNode();
			case LinguisticPackage.VERB_PHRASE_NODE: return createVerbPhraseNode();
			case LinguisticPackage.PREPOSITIONAL_PHRASE_NODE: return createPrepositionalPhraseNode();
			case LinguisticPackage.TEXT: return createText();
			case LinguisticPackage.SUBJECT: return createSubject();
			case LinguisticPackage.GOTO_TARGET: return createGotoTarget();
			case LinguisticPackage.REPRESENTATIVE_OBJECT: return createRepresentativeObject();
			case LinguisticPackage.INDIRECT_OBJECT: return createIndirectObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LinguisticPackage.EWORD_TYPE:
				return createEWordTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LinguisticPackage.EWORD_TYPE:
				return convertEWordTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode createSentenceNode() {
		SentenceNodeImpl sentenceNode = new SentenceNodeImpl();
		return sentenceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word createWord() {
		WordImpl word = new WordImpl();
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NounPhraseNode createNounPhraseNode() {
		NounPhraseNodeImpl nounPhraseNode = new NounPhraseNodeImpl();
		return nounPhraseNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerbPhraseNode createVerbPhraseNode() {
		VerbPhraseNodeImpl verbPhraseNode = new VerbPhraseNodeImpl();
		return verbPhraseNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrepositionalPhraseNode createPrepositionalPhraseNode() {
		PrepositionalPhraseNodeImpl prepositionalPhraseNode = new PrepositionalPhraseNodeImpl();
		return prepositionalPhraseNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject createSubject() {
		SubjectImpl subject = new SubjectImpl();
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GotoTarget createGotoTarget() {
		GotoTargetImpl gotoTarget = new GotoTargetImpl();
		return gotoTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentativeObject createRepresentativeObject() {
		RepresentativeObjectImpl representativeObject = new RepresentativeObjectImpl();
		return representativeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndirectObject createIndirectObject() {
		IndirectObjectImpl indirectObject = new IndirectObjectImpl();
		return indirectObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EWordType createEWordTypeFromString(EDataType eDataType, String initialValue) {
		EWordType result = EWordType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEWordTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinguisticPackage getLinguisticPackage() {
		return (LinguisticPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LinguisticPackage getPackage() {
		return LinguisticPackage.eINSTANCE;
	}

} //LinguisticFactoryImpl
