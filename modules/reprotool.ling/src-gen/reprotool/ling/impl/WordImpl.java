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
 *   <li>{@link reprotool.ling.impl.WordImpl#getText <em>Text</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getLemma <em>Lemma</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getPOS <em>POS</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getID <em>ID</em>}</li>
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
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;
	/**
	 * The default value of the '{@link #getLemma() <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemma()
	 * @generated
	 * @ordered
	 */
	protected static final String LEMMA_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLemma() <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemma()
	 * @generated
	 * @ordered
	 */
	protected String lemma = LEMMA_EDEFAULT;
	/**
	 * The default value of the '{@link #getPOS() <em>POS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPOS()
	 * @generated
	 * @ordered
	 */
	protected static final String POS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPOS() <em>POS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPOS()
	 * @generated
	 * @ordered
	 */
	protected String pos = POS_EDEFAULT;
	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

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
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLemma() {
		return lemma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLemma(String newLemma) {
		String oldLemma = lemma;
		lemma = newLemma;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__LEMMA, oldLemma, lemma));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPOS() {
		return pos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPOS(String newPOS) {
		String oldPOS = pos;
		pos = newPOS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__POS, oldPOS, pos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(int newID) {
		int oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__ID, oldID, id));
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
			case LingPackage.WORD__TEXT:
				return getText();
			case LingPackage.WORD__LEMMA:
				return getLemma();
			case LingPackage.WORD__POS:
				return getPOS();
			case LingPackage.WORD__ID:
				return getID();
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
			case LingPackage.WORD__TEXT:
				setText((String)newValue);
				return;
			case LingPackage.WORD__LEMMA:
				setLemma((String)newValue);
				return;
			case LingPackage.WORD__POS:
				setPOS((String)newValue);
				return;
			case LingPackage.WORD__ID:
				setID((Integer)newValue);
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
			case LingPackage.WORD__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case LingPackage.WORD__LEMMA:
				setLemma(LEMMA_EDEFAULT);
				return;
			case LingPackage.WORD__POS:
				setPOS(POS_EDEFAULT);
				return;
			case LingPackage.WORD__ID:
				setID(ID_EDEFAULT);
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
			case LingPackage.WORD__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case LingPackage.WORD__LEMMA:
				return LEMMA_EDEFAULT == null ? lemma != null : !LEMMA_EDEFAULT.equals(lemma);
			case LingPackage.WORD__POS:
				return POS_EDEFAULT == null ? pos != null : !POS_EDEFAULT.equals(pos);
			case LingPackage.WORD__ID:
				return id != ID_EDEFAULT;
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
		result.append(", text: ");
		result.append(text);
		result.append(", lemma: ");
		result.append(lemma);
		result.append(", POS: ");
		result.append(pos);
		result.append(", ID: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //WordImpl
