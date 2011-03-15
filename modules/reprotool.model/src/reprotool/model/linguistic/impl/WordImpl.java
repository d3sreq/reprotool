/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.model.linguistic.EWordType;
import reprotool.model.linguistic.LinguisticPackage;
import reprotool.model.linguistic.Word;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.impl.WordImpl#getWordStr <em>Word Str</em>}</li>
 *   <li>{@link reprotool.model.linguistic.impl.WordImpl#getWordType <em>Word Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WordImpl extends SentenceNodeImpl implements Word {
	/**
	 * The default value of the '{@link #getWordStr() <em>Word Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordStr()
	 * @generated
	 * @ordered
	 */
	protected static final String WORD_STR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWordStr() <em>Word Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordStr()
	 * @generated
	 * @ordered
	 */
	protected String wordStr = WORD_STR_EDEFAULT;

	/**
	 * The default value of the '{@link #getWordType() <em>Word Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordType()
	 * @generated
	 * @ordered
	 */
	protected static final EWordType WORD_TYPE_EDEFAULT = EWordType.NOT_IMPORTANT;

	/**
	 * The cached value of the '{@link #getWordType() <em>Word Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordType()
	 * @generated
	 * @ordered
	 */
	protected EWordType wordType = WORD_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinguisticPackage.Literals.WORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWordStr() {
		return wordStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWordStr(String newWordStr) {
		String oldWordStr = wordStr;
		wordStr = newWordStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinguisticPackage.WORD__WORD_STR, oldWordStr, wordStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EWordType getWordType() {
		return wordType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWordType(EWordType newWordType) {
		EWordType oldWordType = wordType;
		wordType = newWordType == null ? WORD_TYPE_EDEFAULT : newWordType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinguisticPackage.WORD__WORD_TYPE, oldWordType, wordType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LinguisticPackage.WORD__WORD_STR:
				return getWordStr();
			case LinguisticPackage.WORD__WORD_TYPE:
				return getWordType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LinguisticPackage.WORD__WORD_STR:
				setWordStr((String)newValue);
				return;
			case LinguisticPackage.WORD__WORD_TYPE:
				setWordType((EWordType)newValue);
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
			case LinguisticPackage.WORD__WORD_STR:
				setWordStr(WORD_STR_EDEFAULT);
				return;
			case LinguisticPackage.WORD__WORD_TYPE:
				setWordType(WORD_TYPE_EDEFAULT);
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
			case LinguisticPackage.WORD__WORD_STR:
				return WORD_STR_EDEFAULT == null ? wordStr != null : !WORD_STR_EDEFAULT.equals(wordStr);
			case LinguisticPackage.WORD__WORD_TYPE:
				return wordType != WORD_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (wordStr: ");
		result.append(wordStr);
		result.append(", wordType: ");
		result.append(wordType);
		result.append(')');
		return result.toString();
	}

} //WordImpl
