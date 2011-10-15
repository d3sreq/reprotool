/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.linguistic.actionpart.ActionPart;
import reprotool.model.linguistic.actionpart.ActionpartPackage;
import reprotool.model.linguistic.actionpart.Text;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.actionpart.impl.TextImpl#getContent <em>Content</em>}</li>
 *   <li>{@link reprotool.model.linguistic.actionpart.impl.TextImpl#getActionPart <em>Action Part</em>}</li>
 *   <li>{@link reprotool.model.linguistic.actionpart.impl.TextImpl#getLemmaForm <em>Lemma Form</em>}</li>
 *   <li>{@link reprotool.model.linguistic.actionpart.impl.TextImpl#getPosTag <em>Pos Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextImpl extends EObjectImpl implements Text {
	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActionPart() <em>Action Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionPart()
	 * @generated
	 * @ordered
	 */
	protected ActionPart actionPart;

	/**
	 * The default value of the '{@link #getLemmaForm() <em>Lemma Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemmaForm()
	 * @generated
	 * @ordered
	 */
	protected static final String LEMMA_FORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLemmaForm() <em>Lemma Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemmaForm()
	 * @generated
	 * @ordered
	 */
	protected String lemmaForm = LEMMA_FORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosTag() <em>Pos Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosTag()
	 * @generated
	 * @ordered
	 */
	protected static final String POS_TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosTag() <em>Pos Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosTag()
	 * @generated
	 * @ordered
	 */
	protected String posTag = POS_TAG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionpartPackage.Literals.TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionpartPackage.TEXT__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionPart getActionPart() {
		if (actionPart != null && actionPart.eIsProxy()) {
			InternalEObject oldActionPart = (InternalEObject)actionPart;
			actionPart = (ActionPart)eResolveProxy(oldActionPart);
			if (actionPart != oldActionPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionpartPackage.TEXT__ACTION_PART, oldActionPart, actionPart));
			}
		}
		return actionPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionPart basicGetActionPart() {
		return actionPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionPart(ActionPart newActionPart, NotificationChain msgs) {
		ActionPart oldActionPart = actionPart;
		actionPart = newActionPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionpartPackage.TEXT__ACTION_PART, oldActionPart, newActionPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionPart(ActionPart newActionPart) {
		if (newActionPart != actionPart) {
			NotificationChain msgs = null;
			if (actionPart != null)
				msgs = ((InternalEObject)actionPart).eInverseRemove(this, ActionpartPackage.ACTION_PART__TEXT, ActionPart.class, msgs);
			if (newActionPart != null)
				msgs = ((InternalEObject)newActionPart).eInverseAdd(this, ActionpartPackage.ACTION_PART__TEXT, ActionPart.class, msgs);
			msgs = basicSetActionPart(newActionPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionpartPackage.TEXT__ACTION_PART, newActionPart, newActionPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLemmaForm() {
		return lemmaForm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLemmaForm(String newLemmaForm) {
		String oldLemmaForm = lemmaForm;
		lemmaForm = newLemmaForm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionpartPackage.TEXT__LEMMA_FORM, oldLemmaForm, lemmaForm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPosTag() {
		return posTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosTag(String newPosTag) {
		String oldPosTag = posTag;
		posTag = newPosTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionpartPackage.TEXT__POS_TAG, oldPosTag, posTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionpartPackage.TEXT__ACTION_PART:
				if (actionPart != null)
					msgs = ((InternalEObject)actionPart).eInverseRemove(this, ActionpartPackage.ACTION_PART__TEXT, ActionPart.class, msgs);
				return basicSetActionPart((ActionPart)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionpartPackage.TEXT__ACTION_PART:
				return basicSetActionPart(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionpartPackage.TEXT__CONTENT:
				return getContent();
			case ActionpartPackage.TEXT__ACTION_PART:
				if (resolve) return getActionPart();
				return basicGetActionPart();
			case ActionpartPackage.TEXT__LEMMA_FORM:
				return getLemmaForm();
			case ActionpartPackage.TEXT__POS_TAG:
				return getPosTag();
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
			case ActionpartPackage.TEXT__CONTENT:
				setContent((String)newValue);
				return;
			case ActionpartPackage.TEXT__ACTION_PART:
				setActionPart((ActionPart)newValue);
				return;
			case ActionpartPackage.TEXT__LEMMA_FORM:
				setLemmaForm((String)newValue);
				return;
			case ActionpartPackage.TEXT__POS_TAG:
				setPosTag((String)newValue);
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
			case ActionpartPackage.TEXT__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case ActionpartPackage.TEXT__ACTION_PART:
				setActionPart((ActionPart)null);
				return;
			case ActionpartPackage.TEXT__LEMMA_FORM:
				setLemmaForm(LEMMA_FORM_EDEFAULT);
				return;
			case ActionpartPackage.TEXT__POS_TAG:
				setPosTag(POS_TAG_EDEFAULT);
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
			case ActionpartPackage.TEXT__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case ActionpartPackage.TEXT__ACTION_PART:
				return actionPart != null;
			case ActionpartPackage.TEXT__LEMMA_FORM:
				return LEMMA_FORM_EDEFAULT == null ? lemmaForm != null : !LEMMA_FORM_EDEFAULT.equals(lemmaForm);
			case ActionpartPackage.TEXT__POS_TAG:
				return POS_TAG_EDEFAULT == null ? posTag != null : !POS_TAG_EDEFAULT.equals(posTag);
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
		result.append(" (content: ");
		result.append(content);
		result.append(", lemmaForm: ");
		result.append(lemmaForm);
		result.append(", posTag: ");
		result.append(posTag);
		result.append(')');
		return result.toString();
	}

} //TextImpl
