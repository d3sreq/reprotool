/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.ling.LingPackage;
import reprotool.ling.Word;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.ling.impl.WordImpl#getWordStr <em>Word Str</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WordImpl extends EObjectImpl implements Word {
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
		return LingPackage.Literals.WORD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__WORD_STR, oldWordStr, wordStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LingPackage.WORD__WORD_STR:
				return getWordStr();
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
			case LingPackage.WORD__WORD_STR:
				setWordStr((String)newValue);
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
			case LingPackage.WORD__WORD_STR:
				setWordStr(WORD_STR_EDEFAULT);
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
			case LingPackage.WORD__WORD_STR:
				return WORD_STR_EDEFAULT == null ? wordStr != null : !WORD_STR_EDEFAULT.equals(wordStr);
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
		result.append(')');
		return result.toString();
	}

} //WordImpl
