/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.ling;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>POS Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see reprotool.ling.LingPackage#getPOSType()
 * @model
 * @generated
 */
public enum POSType implements Enumerator
{
	/**
	 * The '<em><b>Undefined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEFINED(0, "Undefined", "X"),

	/**
	 * The '<em><b>Coordinating conjunction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COORDINATING_CONJUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	COORDINATING_CONJUNCTION(1, "Coordinating_conjunction", "CC"),

	/**
	 * The '<em><b>Cardinal number</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARDINAL_NUMBER_VALUE
	 * @generated
	 * @ordered
	 */
	CARDINAL_NUMBER(2, "Cardinal_number", "CD"),

	/**
	 * The '<em><b>Determiner</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DETERMINER_VALUE
	 * @generated
	 * @ordered
	 */
	DETERMINER(3, "Determiner", "DT"),

	/**
	 * The '<em><b>Existential there</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXISTENTIAL_THERE_VALUE
	 * @generated
	 * @ordered
	 */
	EXISTENTIAL_THERE(4, "Existential_there", "EX"),

	/**
	 * The '<em><b>Foreign word</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOREIGN_WORD_VALUE
	 * @generated
	 * @ordered
	 */
	FOREIGN_WORD(5, "Foreign_word", "FW"),

	/**
	 * The '<em><b>Preposition or subordinating conjunction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREPOSITION_OR_SUBORDINATING_CONJUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	PREPOSITION_OR_SUBORDINATING_CONJUNCTION(6, "Preposition_or_subordinating_conjunction", "IN"),

	/**
	 * The '<em><b>Adjective</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ADJECTIVE(7, "Adjective", "JJ"),

	/**
	 * The '<em><b>Adjective comparative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_COMPARATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ADJECTIVE_COMPARATIVE(8, "Adjective_comparative", "JJR"),

	/**
	 * The '<em><b>Adjective superlative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_SUPERLATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ADJECTIVE_SUPERLATIVE(9, "Adjective_superlative", "JJS"),

	/**
	 * The '<em><b>List item marker</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_ITEM_MARKER_VALUE
	 * @generated
	 * @ordered
	 */
	LIST_ITEM_MARKER(10, "List_item_marker", "LS"),

	/**
	 * The '<em><b>Modal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODAL_VALUE
	 * @generated
	 * @ordered
	 */
	MODAL(11, "Modal", "MD"),

	/**
	 * The '<em><b>Noun singular or mass</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOUN_SINGULAR_OR_MASS_VALUE
	 * @generated
	 * @ordered
	 */
	NOUN_SINGULAR_OR_MASS(12, "Noun_singular_or_mass", "NN"),

	/**
	 * The '<em><b>Noun plural</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOUN_PLURAL_VALUE
	 * @generated
	 * @ordered
	 */
	NOUN_PLURAL(13, "Noun_plural", "NNS"),

	/**
	 * The '<em><b>Proper noun singular</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROPER_NOUN_SINGULAR_VALUE
	 * @generated
	 * @ordered
	 */
	PROPER_NOUN_SINGULAR(14, "Proper_noun_singular", "NNP"),

	/**
	 * The '<em><b>Proper noun plural</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROPER_NOUN_PLURAL_VALUE
	 * @generated
	 * @ordered
	 */
	PROPER_NOUN_PLURAL(15, "Proper_noun_plural", "NNPS"),

	/**
	 * The '<em><b>Predeterminer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREDETERMINER_VALUE
	 * @generated
	 * @ordered
	 */
	PREDETERMINER(16, "Predeterminer", "PDT"),

	/**
	 * The '<em><b>Possessive ending</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSSESSIVE_ENDING_VALUE
	 * @generated
	 * @ordered
	 */
	POSSESSIVE_ENDING(17, "Possessive_ending", "POS"),

	/**
	 * The '<em><b>Personal pronoun</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERSONAL_PRONOUN_VALUE
	 * @generated
	 * @ordered
	 */
	PERSONAL_PRONOUN(18, "Personal_pronoun", "PRP"),

	/**
	 * The '<em><b>Adverb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVERB_VALUE
	 * @generated
	 * @ordered
	 */
	ADVERB(19, "Adverb", "RB"),

	/**
	 * The '<em><b>Adverb comparative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVERB_COMPARATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ADVERB_COMPARATIVE(20, "Adverb_comparative", "RBR"),

	/**
	 * The '<em><b>Adverb superlative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVERB_SUPERLATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ADVERB_SUPERLATIVE(21, "Adverb_superlative", "RBS"),

	/**
	 * The '<em><b>Particle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTICLE_VALUE
	 * @generated
	 * @ordered
	 */
	PARTICLE(22, "Particle", "RP"),

	/**
	 * The '<em><b>Symbol</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYMBOL_VALUE
	 * @generated
	 * @ordered
	 */
	SYMBOL(23, "Symbol", "SYM"),

	/**
	 * The '<em><b>To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TO_VALUE
	 * @generated
	 * @ordered
	 */
	TO(24, "to", "TO"),

	/**
	 * The '<em><b>Interjection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERJECTION_VALUE
	 * @generated
	 * @ordered
	 */
	INTERJECTION(25, "Interjection", "UH"),

	/**
	 * The '<em><b>Verb base form</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_BASE_FORM_VALUE
	 * @generated
	 * @ordered
	 */
	VERB_BASE_FORM(26, "Verb_base_form", "VB"),

	/**
	 * The '<em><b>Verb past tense</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_PAST_TENSE_VALUE
	 * @generated
	 * @ordered
	 */
	VERB_PAST_TENSE(27, "Verb_past_tense", "VBD"),

	/**
	 * The '<em><b>Verb gerund or present participle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_GERUND_OR_PRESENT_PARTICIPLE_VALUE
	 * @generated
	 * @ordered
	 */
	VERB_GERUND_OR_PRESENT_PARTICIPLE(28, "Verb_gerund_or_present_participle", "VBG"),

	/**
	 * The '<em><b>Verb past participle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_PAST_PARTICIPLE_VALUE
	 * @generated
	 * @ordered
	 */
	VERB_PAST_PARTICIPLE(29, "Verb_past_participle", "VBN"),

	/**
	 * The '<em><b>Verb non 3rd person singular present</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_NON_3RD_PERSON_SINGULAR_PRESENT_VALUE
	 * @generated
	 * @ordered
	 */
	VERB_NON_3RD_PERSON_SINGULAR_PRESENT(30, "Verb_non_3rd_person_singular_present", "VBP"),

	/**
	 * The '<em><b>Verb 3rd person singular present</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_3RD_PERSON_SINGULAR_PRESENT_VALUE
	 * @generated
	 * @ordered
	 */
	VERB_3RD_PERSON_SINGULAR_PRESENT(31, "Verb_3rd_person_singular_present", "VBZ"),

	/**
	 * The '<em><b>Wh determiner</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WH_DETERMINER_VALUE
	 * @generated
	 * @ordered
	 */
	WH_DETERMINER(32, "Wh_determiner", "WDT"),

	/**
	 * The '<em><b>Wh pronoun</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WH_PRONOUN_VALUE
	 * @generated
	 * @ordered
	 */
	WH_PRONOUN(33, "Wh_pronoun", "WP"),

	/**
	 * The '<em><b>Wh adverb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WH_ADVERB_VALUE
	 * @generated
	 * @ordered
	 */
	WH_ADVERB(34, "Wh_adverb", "WRB");

	/**
	 * The '<em><b>Undefined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undefined</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @model name="Undefined" literal="X"
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 0;

	/**
	 * The '<em><b>Coordinating conjunction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Coordinating conjunction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COORDINATING_CONJUNCTION
	 * @model name="Coordinating_conjunction" literal="CC"
	 * @generated
	 * @ordered
	 */
	public static final int COORDINATING_CONJUNCTION_VALUE = 1;

	/**
	 * The '<em><b>Cardinal number</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cardinal number</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CARDINAL_NUMBER
	 * @model name="Cardinal_number" literal="CD"
	 * @generated
	 * @ordered
	 */
	public static final int CARDINAL_NUMBER_VALUE = 2;

	/**
	 * The '<em><b>Determiner</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Determiner</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DETERMINER
	 * @model name="Determiner" literal="DT"
	 * @generated
	 * @ordered
	 */
	public static final int DETERMINER_VALUE = 3;

	/**
	 * The '<em><b>Existential there</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Existential there</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXISTENTIAL_THERE
	 * @model name="Existential_there" literal="EX"
	 * @generated
	 * @ordered
	 */
	public static final int EXISTENTIAL_THERE_VALUE = 4;

	/**
	 * The '<em><b>Foreign word</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Foreign word</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOREIGN_WORD
	 * @model name="Foreign_word" literal="FW"
	 * @generated
	 * @ordered
	 */
	public static final int FOREIGN_WORD_VALUE = 5;

	/**
	 * The '<em><b>Preposition or subordinating conjunction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Preposition or subordinating conjunction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREPOSITION_OR_SUBORDINATING_CONJUNCTION
	 * @model name="Preposition_or_subordinating_conjunction" literal="IN"
	 * @generated
	 * @ordered
	 */
	public static final int PREPOSITION_OR_SUBORDINATING_CONJUNCTION_VALUE = 6;

	/**
	 * The '<em><b>Adjective</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Adjective</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE
	 * @model name="Adjective" literal="JJ"
	 * @generated
	 * @ordered
	 */
	public static final int ADJECTIVE_VALUE = 7;

	/**
	 * The '<em><b>Adjective comparative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Adjective comparative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_COMPARATIVE
	 * @model name="Adjective_comparative" literal="JJR"
	 * @generated
	 * @ordered
	 */
	public static final int ADJECTIVE_COMPARATIVE_VALUE = 8;

	/**
	 * The '<em><b>Adjective superlative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Adjective superlative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADJECTIVE_SUPERLATIVE
	 * @model name="Adjective_superlative" literal="JJS"
	 * @generated
	 * @ordered
	 */
	public static final int ADJECTIVE_SUPERLATIVE_VALUE = 9;

	/**
	 * The '<em><b>List item marker</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>List item marker</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_ITEM_MARKER
	 * @model name="List_item_marker" literal="LS"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_ITEM_MARKER_VALUE = 10;

	/**
	 * The '<em><b>Modal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Modal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODAL
	 * @model name="Modal" literal="MD"
	 * @generated
	 * @ordered
	 */
	public static final int MODAL_VALUE = 11;

	/**
	 * The '<em><b>Noun singular or mass</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Noun singular or mass</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOUN_SINGULAR_OR_MASS
	 * @model name="Noun_singular_or_mass" literal="NN"
	 * @generated
	 * @ordered
	 */
	public static final int NOUN_SINGULAR_OR_MASS_VALUE = 12;

	/**
	 * The '<em><b>Noun plural</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Noun plural</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOUN_PLURAL
	 * @model name="Noun_plural" literal="NNS"
	 * @generated
	 * @ordered
	 */
	public static final int NOUN_PLURAL_VALUE = 13;

	/**
	 * The '<em><b>Proper noun singular</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Proper noun singular</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROPER_NOUN_SINGULAR
	 * @model name="Proper_noun_singular" literal="NNP"
	 * @generated
	 * @ordered
	 */
	public static final int PROPER_NOUN_SINGULAR_VALUE = 14;

	/**
	 * The '<em><b>Proper noun plural</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Proper noun plural</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROPER_NOUN_PLURAL
	 * @model name="Proper_noun_plural" literal="NNPS"
	 * @generated
	 * @ordered
	 */
	public static final int PROPER_NOUN_PLURAL_VALUE = 15;

	/**
	 * The '<em><b>Predeterminer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Predeterminer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREDETERMINER
	 * @model name="Predeterminer" literal="PDT"
	 * @generated
	 * @ordered
	 */
	public static final int PREDETERMINER_VALUE = 16;

	/**
	 * The '<em><b>Possessive ending</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Possessive ending</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POSSESSIVE_ENDING
	 * @model name="Possessive_ending" literal="POS"
	 * @generated
	 * @ordered
	 */
	public static final int POSSESSIVE_ENDING_VALUE = 17;

	/**
	 * The '<em><b>Personal pronoun</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Personal pronoun</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERSONAL_PRONOUN
	 * @model name="Personal_pronoun" literal="PRP"
	 * @generated
	 * @ordered
	 */
	public static final int PERSONAL_PRONOUN_VALUE = 18;

	/**
	 * The '<em><b>Adverb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Adverb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVERB
	 * @model name="Adverb" literal="RB"
	 * @generated
	 * @ordered
	 */
	public static final int ADVERB_VALUE = 19;

	/**
	 * The '<em><b>Adverb comparative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Adverb comparative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVERB_COMPARATIVE
	 * @model name="Adverb_comparative" literal="RBR"
	 * @generated
	 * @ordered
	 */
	public static final int ADVERB_COMPARATIVE_VALUE = 20;

	/**
	 * The '<em><b>Adverb superlative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Adverb superlative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVERB_SUPERLATIVE
	 * @model name="Adverb_superlative" literal="RBS"
	 * @generated
	 * @ordered
	 */
	public static final int ADVERB_SUPERLATIVE_VALUE = 21;

	/**
	 * The '<em><b>Particle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Particle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTICLE
	 * @model name="Particle" literal="RP"
	 * @generated
	 * @ordered
	 */
	public static final int PARTICLE_VALUE = 22;

	/**
	 * The '<em><b>Symbol</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Symbol</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYMBOL
	 * @model name="Symbol" literal="SYM"
	 * @generated
	 * @ordered
	 */
	public static final int SYMBOL_VALUE = 23;

	/**
	 * The '<em><b>To</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>To</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TO
	 * @model name="to" literal="TO"
	 * @generated
	 * @ordered
	 */
	public static final int TO_VALUE = 24;

	/**
	 * The '<em><b>Interjection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Interjection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERJECTION
	 * @model name="Interjection" literal="UH"
	 * @generated
	 * @ordered
	 */
	public static final int INTERJECTION_VALUE = 25;

	/**
	 * The '<em><b>Verb base form</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb base form</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB_BASE_FORM
	 * @model name="Verb_base_form" literal="VB"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_BASE_FORM_VALUE = 26;

	/**
	 * The '<em><b>Verb past tense</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb past tense</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB_PAST_TENSE
	 * @model name="Verb_past_tense" literal="VBD"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_PAST_TENSE_VALUE = 27;

	/**
	 * The '<em><b>Verb gerund or present participle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb gerund or present participle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB_GERUND_OR_PRESENT_PARTICIPLE
	 * @model name="Verb_gerund_or_present_participle" literal="VBG"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_GERUND_OR_PRESENT_PARTICIPLE_VALUE = 28;

	/**
	 * The '<em><b>Verb past participle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb past participle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB_PAST_PARTICIPLE
	 * @model name="Verb_past_participle" literal="VBN"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_PAST_PARTICIPLE_VALUE = 29;

	/**
	 * The '<em><b>Verb non 3rd person singular present</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb non 3rd person singular present</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB_NON_3RD_PERSON_SINGULAR_PRESENT
	 * @model name="Verb_non_3rd_person_singular_present" literal="VBP"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_NON_3RD_PERSON_SINGULAR_PRESENT_VALUE = 30;

	/**
	 * The '<em><b>Verb 3rd person singular present</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb 3rd person singular present</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB_3RD_PERSON_SINGULAR_PRESENT
	 * @model name="Verb_3rd_person_singular_present" literal="VBZ"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_3RD_PERSON_SINGULAR_PRESENT_VALUE = 31;

	/**
	 * The '<em><b>Wh determiner</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wh determiner</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WH_DETERMINER
	 * @model name="Wh_determiner" literal="WDT"
	 * @generated
	 * @ordered
	 */
	public static final int WH_DETERMINER_VALUE = 32;

	/**
	 * The '<em><b>Wh pronoun</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wh pronoun</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WH_PRONOUN
	 * @model name="Wh_pronoun" literal="WP"
	 * @generated
	 * @ordered
	 */
	public static final int WH_PRONOUN_VALUE = 33;

	/**
	 * The '<em><b>Wh adverb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wh adverb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WH_ADVERB
	 * @model name="Wh_adverb" literal="WRB"
	 * @generated
	 * @ordered
	 */
	public static final int WH_ADVERB_VALUE = 34;

	/**
	 * An array of all the '<em><b>POS Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final POSType[] VALUES_ARRAY =
		new POSType[]
		{
			UNDEFINED,
			COORDINATING_CONJUNCTION,
			CARDINAL_NUMBER,
			DETERMINER,
			EXISTENTIAL_THERE,
			FOREIGN_WORD,
			PREPOSITION_OR_SUBORDINATING_CONJUNCTION,
			ADJECTIVE,
			ADJECTIVE_COMPARATIVE,
			ADJECTIVE_SUPERLATIVE,
			LIST_ITEM_MARKER,
			MODAL,
			NOUN_SINGULAR_OR_MASS,
			NOUN_PLURAL,
			PROPER_NOUN_SINGULAR,
			PROPER_NOUN_PLURAL,
			PREDETERMINER,
			POSSESSIVE_ENDING,
			PERSONAL_PRONOUN,
			ADVERB,
			ADVERB_COMPARATIVE,
			ADVERB_SUPERLATIVE,
			PARTICLE,
			SYMBOL,
			TO,
			INTERJECTION,
			VERB_BASE_FORM,
			VERB_PAST_TENSE,
			VERB_GERUND_OR_PRESENT_PARTICIPLE,
			VERB_PAST_PARTICIPLE,
			VERB_NON_3RD_PERSON_SINGULAR_PRESENT,
			VERB_3RD_PERSON_SINGULAR_PRESENT,
			WH_DETERMINER,
			WH_PRONOUN,
			WH_ADVERB,
		};

	/**
	 * A public read-only list of all the '<em><b>POS Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<POSType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>POS Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static POSType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			POSType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>POS Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static POSType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			POSType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>POS Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static POSType get(int value)
	{
		switch (value)
		{
			case UNDEFINED_VALUE: return UNDEFINED;
			case COORDINATING_CONJUNCTION_VALUE: return COORDINATING_CONJUNCTION;
			case CARDINAL_NUMBER_VALUE: return CARDINAL_NUMBER;
			case DETERMINER_VALUE: return DETERMINER;
			case EXISTENTIAL_THERE_VALUE: return EXISTENTIAL_THERE;
			case FOREIGN_WORD_VALUE: return FOREIGN_WORD;
			case PREPOSITION_OR_SUBORDINATING_CONJUNCTION_VALUE: return PREPOSITION_OR_SUBORDINATING_CONJUNCTION;
			case ADJECTIVE_VALUE: return ADJECTIVE;
			case ADJECTIVE_COMPARATIVE_VALUE: return ADJECTIVE_COMPARATIVE;
			case ADJECTIVE_SUPERLATIVE_VALUE: return ADJECTIVE_SUPERLATIVE;
			case LIST_ITEM_MARKER_VALUE: return LIST_ITEM_MARKER;
			case MODAL_VALUE: return MODAL;
			case NOUN_SINGULAR_OR_MASS_VALUE: return NOUN_SINGULAR_OR_MASS;
			case NOUN_PLURAL_VALUE: return NOUN_PLURAL;
			case PROPER_NOUN_SINGULAR_VALUE: return PROPER_NOUN_SINGULAR;
			case PROPER_NOUN_PLURAL_VALUE: return PROPER_NOUN_PLURAL;
			case PREDETERMINER_VALUE: return PREDETERMINER;
			case POSSESSIVE_ENDING_VALUE: return POSSESSIVE_ENDING;
			case PERSONAL_PRONOUN_VALUE: return PERSONAL_PRONOUN;
			case ADVERB_VALUE: return ADVERB;
			case ADVERB_COMPARATIVE_VALUE: return ADVERB_COMPARATIVE;
			case ADVERB_SUPERLATIVE_VALUE: return ADVERB_SUPERLATIVE;
			case PARTICLE_VALUE: return PARTICLE;
			case SYMBOL_VALUE: return SYMBOL;
			case TO_VALUE: return TO;
			case INTERJECTION_VALUE: return INTERJECTION;
			case VERB_BASE_FORM_VALUE: return VERB_BASE_FORM;
			case VERB_PAST_TENSE_VALUE: return VERB_PAST_TENSE;
			case VERB_GERUND_OR_PRESENT_PARTICIPLE_VALUE: return VERB_GERUND_OR_PRESENT_PARTICIPLE;
			case VERB_PAST_PARTICIPLE_VALUE: return VERB_PAST_PARTICIPLE;
			case VERB_NON_3RD_PERSON_SINGULAR_PRESENT_VALUE: return VERB_NON_3RD_PERSON_SINGULAR_PRESENT;
			case VERB_3RD_PERSON_SINGULAR_PRESENT_VALUE: return VERB_3RD_PERSON_SINGULAR_PRESENT;
			case WH_DETERMINER_VALUE: return WH_DETERMINER;
			case WH_PRONOUN_VALUE: return WH_PRONOUN;
			case WH_ADVERB_VALUE: return WH_ADVERB;
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
	private POSType(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //POSType
