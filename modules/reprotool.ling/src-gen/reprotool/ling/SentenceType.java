/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Sentence Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see reprotool.ling.LingPackage#getSentenceType()
 * @model
 * @generated
 */
public enum SentenceType implements Enumerator {
	/**
	 * The '<em><b>Noun Phrase</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOUN_PHRASE_VALUE
	 * @generated
	 * @ordered
	 */
	NOUN_PHRASE(1, "NounPhrase", "NounPhrase"),

	/**
	 * The '<em><b>Verb Phrase</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_PHRASE_VALUE
	 * @generated
	 * @ordered
	 */
	VERB_PHRASE(2, "VerbPhrase", "VerbPhrase"),

	/**
	 * The '<em><b>Preposition Phrase</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREPOSITION_PHRASE_VALUE
	 * @generated
	 * @ordered
	 */
	PREPOSITION_PHRASE(3, "PrepositionPhrase", "PrepositionPhrase"),

	/**
	 * The '<em><b>Undefined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEFINED(4, "Undefined", "Undefined"),

	/**
	 * The '<em><b>Sentence Phrase</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SENTENCE_PHRASE_VALUE
	 * @generated
	 * @ordered
	 */
	SENTENCE_PHRASE(0, "SentencePhrase", "SentencePhrase");

	/**
	 * The '<em><b>Noun Phrase</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Noun Phrase</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOUN_PHRASE
	 * @model name="NounPhrase"
	 * @generated
	 * @ordered
	 */
	public static final int NOUN_PHRASE_VALUE = 1;

	/**
	 * The '<em><b>Verb Phrase</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb Phrase</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB_PHRASE
	 * @model name="VerbPhrase"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_PHRASE_VALUE = 2;

	/**
	 * The '<em><b>Preposition Phrase</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Preposition Phrase</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREPOSITION_PHRASE
	 * @model name="PrepositionPhrase"
	 * @generated
	 * @ordered
	 */
	public static final int PREPOSITION_PHRASE_VALUE = 3;

	/**
	 * The '<em><b>Undefined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undefined</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @model name="Undefined"
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 4;

	/**
	 * The '<em><b>Sentence Phrase</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sentence Phrase</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SENTENCE_PHRASE
	 * @model name="SentencePhrase"
	 * @generated
	 * @ordered
	 */
	public static final int SENTENCE_PHRASE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Sentence Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SentenceType[] VALUES_ARRAY =
		new SentenceType[] {
			NOUN_PHRASE,
			VERB_PHRASE,
			PREPOSITION_PHRASE,
			UNDEFINED,
			SENTENCE_PHRASE,
		};

	/**
	 * A public read-only list of all the '<em><b>Sentence Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SentenceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Sentence Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SentenceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SentenceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sentence Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SentenceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SentenceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sentence Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SentenceType get(int value) {
		switch (value) {
			case NOUN_PHRASE_VALUE: return NOUN_PHRASE;
			case VERB_PHRASE_VALUE: return VERB_PHRASE;
			case PREPOSITION_PHRASE_VALUE: return PREPOSITION_PHRASE;
			case UNDEFINED_VALUE: return UNDEFINED;
			case SENTENCE_PHRASE_VALUE: return SENTENCE_PHRASE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SentenceType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SentenceType
