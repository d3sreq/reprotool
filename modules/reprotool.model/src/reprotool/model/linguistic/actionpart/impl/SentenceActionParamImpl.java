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

import reprotool.model.linguistic.actionpart.ActionpartPackage;
import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.Text;

import reprotool.model.swproj.ConceptualObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sentence Action Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.actionpart.impl.SentenceActionParamImpl#getText <em>Text</em>}</li>
 *   <li>{@link reprotool.model.linguistic.actionpart.impl.SentenceActionParamImpl#getConceptualObject <em>Conceptual Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SentenceActionParamImpl extends EObjectImpl implements SentenceActionParam {
	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected Text text;

	/**
	 * The cached value of the '{@link #getConceptualObject() <em>Conceptual Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptualObject()
	 * @generated
	 * @ordered
	 */
	protected ConceptualObject conceptualObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SentenceActionParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionpartPackage.Literals.SENTENCE_ACTION_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text getText() {
		if (text != null && text.eIsProxy()) {
			InternalEObject oldText = (InternalEObject)text;
			text = (Text)eResolveProxy(oldText);
			if (text != oldText) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT, oldText, text));
			}
		}
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text basicGetText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetText(Text newText, NotificationChain msgs) {
		Text oldText = text;
		text = newText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT, oldText, newText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(Text newText) {
		if (newText != text) {
			NotificationChain msgs = null;
			if (text != null)
				msgs = ((InternalEObject)text).eInverseRemove(this, ActionpartPackage.TEXT__ACTION_PART, Text.class, msgs);
			if (newText != null)
				msgs = ((InternalEObject)newText).eInverseAdd(this, ActionpartPackage.TEXT__ACTION_PART, Text.class, msgs);
			msgs = basicSetText(newText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT, newText, newText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualObject getConceptualObject() {
		if (conceptualObject != null && conceptualObject.eIsProxy()) {
			InternalEObject oldConceptualObject = (InternalEObject)conceptualObject;
			conceptualObject = (ConceptualObject)eResolveProxy(oldConceptualObject);
			if (conceptualObject != oldConceptualObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionpartPackage.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT, oldConceptualObject, conceptualObject));
			}
		}
		return conceptualObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualObject basicGetConceptualObject() {
		return conceptualObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptualObject(ConceptualObject newConceptualObject) {
		ConceptualObject oldConceptualObject = conceptualObject;
		conceptualObject = newConceptualObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionpartPackage.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT, oldConceptualObject, conceptualObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT:
				if (text != null)
					msgs = ((InternalEObject)text).eInverseRemove(this, ActionpartPackage.TEXT__ACTION_PART, Text.class, msgs);
				return basicSetText((Text)otherEnd, msgs);
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
			case ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT:
				return basicSetText(null, msgs);
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
			case ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT:
				if (resolve) return getText();
				return basicGetText();
			case ActionpartPackage.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT:
				if (resolve) return getConceptualObject();
				return basicGetConceptualObject();
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
			case ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT:
				setText((Text)newValue);
				return;
			case ActionpartPackage.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT:
				setConceptualObject((ConceptualObject)newValue);
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
			case ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT:
				setText((Text)null);
				return;
			case ActionpartPackage.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT:
				setConceptualObject((ConceptualObject)null);
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
			case ActionpartPackage.SENTENCE_ACTION_PARAM__TEXT:
				return text != null;
			case ActionpartPackage.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT:
				return conceptualObject != null;
		}
		return super.eIsSet(featureID);
	}

} //SentenceActionParamImpl
