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
 * A representation of the literals of the enumeration '<em><b>Word Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see reprotool.ling.LingPackage#getWordType()
 * @model
 * @generated
 */
public enum WordType implements Enumerator
{
	/**
	 * The '<em><b>SUBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	SUBJECT(0, "SUBJECT", "SUBJECT"),

	/**
	 * The '<em><b>REPRESENTATIVE OBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPRESENTATIVE_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	REPRESENTATIVE_OBJECT(1, "REPRESENTATIVE_OBJECT", "REPRESENTATIVE_OBJECT"),

	/**
	 * The '<em><b>INDIRECT OBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECT_OBJECT(2, "INDIRECT_OBJECT", "INDIRECT_OBJECT"),

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(3, "UNKNOWN", "UNKNOWN");

	/**
	 * The '<em><b>SUBJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBJECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBJECT_VALUE = 0;

	/**
	 * The '<em><b>REPRESENTATIVE OBJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REPRESENTATIVE OBJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPRESENTATIVE_OBJECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REPRESENTATIVE_OBJECT_VALUE = 1;

	/**
	 * The '<em><b>INDIRECT OBJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECT OBJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_OBJECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECT_OBJECT_VALUE = 2;

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNKNOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN_VALUE = 3;

	/**
	 * An array of all the '<em><b>Word Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WordType[] VALUES_ARRAY =
		new WordType[]
		{
			SUBJECT,
			REPRESENTATIVE_OBJECT,
			INDIRECT_OBJECT,
			UNKNOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>Word Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<WordType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Word Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WordType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			WordType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Word Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WordType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			WordType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Word Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WordType get(int value)
	{
		switch (value)
		{
			case SUBJECT_VALUE: return SUBJECT;
			case REPRESENTATIVE_OBJECT_VALUE: return REPRESENTATIVE_OBJECT;
			case INDIRECT_OBJECT_VALUE: return INDIRECT_OBJECT;
			case UNKNOWN_VALUE: return UNKNOWN;
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
	private WordType(int value, String name, String literal)
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
	
} //WordType
