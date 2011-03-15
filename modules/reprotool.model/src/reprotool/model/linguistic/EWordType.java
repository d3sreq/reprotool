/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EWord Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see reprotool.model.linguistic.LinguisticPackage#getEWordType()
 * @model
 * @generated
 */
public enum EWordType implements Enumerator {
	/**
	 * The '<em><b>Not Important</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_IMPORTANT_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_IMPORTANT(0, "NotImportant", "NotImportant"),

	/**
	 * The '<em><b>Subject</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	SUBJECT(1, "Subject", "Subject"),

	/**
	 * The '<em><b>Indirect Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECT_OBJECT(2, "IndirectObject", "IndirectObject"),

	/**
	 * The '<em><b>Verb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERB_VALUE
	 * @generated
	 * @ordered
	 */
	VERB(3, "Verb", "Verb"),

	/**
	 * The '<em><b>Representative Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPRESENTATIVE_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	REPRESENTATIVE_OBJECT(4, "RepresentativeObject", "RepresentativeObject"),

	/**
	 * The '<em><b>Goto Target</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOTO_TARGET_VALUE
	 * @generated
	 * @ordered
	 */
	GOTO_TARGET(5, "GotoTarget", "GotoTarget"),

	/**
	 * The '<em><b>Condition Label</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONDITION_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	CONDITION_LABEL(6, "ConditionLabel", "ConditionLabel");

	/**
	 * The '<em><b>Not Important</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Important</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_IMPORTANT
	 * @model name="NotImportant"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_IMPORTANT_VALUE = 0;

	/**
	 * The '<em><b>Subject</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Subject</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBJECT
	 * @model name="Subject"
	 * @generated
	 * @ordered
	 */
	public static final int SUBJECT_VALUE = 1;

	/**
	 * The '<em><b>Indirect Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Indirect Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_OBJECT
	 * @model name="IndirectObject"
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECT_OBJECT_VALUE = 2;

	/**
	 * The '<em><b>Verb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERB
	 * @model name="Verb"
	 * @generated
	 * @ordered
	 */
	public static final int VERB_VALUE = 3;

	/**
	 * The '<em><b>Representative Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Representative Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPRESENTATIVE_OBJECT
	 * @model name="RepresentativeObject"
	 * @generated
	 * @ordered
	 */
	public static final int REPRESENTATIVE_OBJECT_VALUE = 4;

	/**
	 * The '<em><b>Goto Target</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Goto Target</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GOTO_TARGET
	 * @model name="GotoTarget"
	 * @generated
	 * @ordered
	 */
	public static final int GOTO_TARGET_VALUE = 5;

	/**
	 * The '<em><b>Condition Label</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Condition Label</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONDITION_LABEL
	 * @model name="ConditionLabel"
	 * @generated
	 * @ordered
	 */
	public static final int CONDITION_LABEL_VALUE = 6;

	/**
	 * An array of all the '<em><b>EWord Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EWordType[] VALUES_ARRAY =
		new EWordType[] {
			NOT_IMPORTANT,
			SUBJECT,
			INDIRECT_OBJECT,
			VERB,
			REPRESENTATIVE_OBJECT,
			GOTO_TARGET,
			CONDITION_LABEL,
		};

	/**
	 * A public read-only list of all the '<em><b>EWord Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EWordType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EWord Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EWordType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EWordType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EWord Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EWordType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EWordType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EWord Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EWordType get(int value) {
		switch (value) {
			case NOT_IMPORTANT_VALUE: return NOT_IMPORTANT;
			case SUBJECT_VALUE: return SUBJECT;
			case INDIRECT_OBJECT_VALUE: return INDIRECT_OBJECT;
			case VERB_VALUE: return VERB;
			case REPRESENTATIVE_OBJECT_VALUE: return REPRESENTATIVE_OBJECT;
			case GOTO_TARGET_VALUE: return GOTO_TARGET;
			case CONDITION_LABEL_VALUE: return CONDITION_LABEL;
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
	private EWordType(int value, String name, String literal) {
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
	
} //EWordType
