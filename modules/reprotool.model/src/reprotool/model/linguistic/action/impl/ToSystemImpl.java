/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.ToSystem;

import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.SentenceActor;
import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.swproj.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.ToSystemImpl#getSummary <em>Summary</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.ToSystemImpl#getActionParam <em>Action Param</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.ToSystemImpl#getActionName <em>Action Name</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.ToSystemImpl#getSender <em>Sender</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToSystemImpl extends EObjectImpl implements ToSystem {
	/**
	 * The default value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected static final String SUMMARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionParam() <em>Action Param</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionParam()
	 * @generated
	 * @ordered
	 */
	protected EList<SentenceActionParam> actionParam;

	/**
	 * The cached value of the '{@link #getActionName() <em>Action Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionName()
	 * @generated
	 * @ordered
	 */
	protected Text actionName;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected SentenceActor sender;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.TO_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SentenceActionParam> getActionParam() {
		if (actionParam == null) {
			actionParam = new EObjectContainmentEList<SentenceActionParam>(SentenceActionParam.class, this, ActionPackage.TO_SYSTEM__ACTION_PARAM);
		}
		return actionParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text getActionName() {
		if (actionName != null && actionName.eIsProxy()) {
			InternalEObject oldActionName = (InternalEObject)actionName;
			actionName = (Text)eResolveProxy(oldActionName);
			if (actionName != oldActionName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionPackage.TO_SYSTEM__ACTION_NAME, oldActionName, actionName));
			}
		}
		return actionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text basicGetActionName() {
		return actionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionName(Text newActionName) {
		Text oldActionName = actionName;
		actionName = newActionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.TO_SYSTEM__ACTION_NAME, oldActionName, actionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSummary() {
		
		String senderName;
		
		try {
			senderName = getSender().getActor().getName();
		} catch (NullPointerException e) {
			senderName = "<Unknown Actor>";
		}
		
		return "Request sent by " + senderName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceActor getSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSender(SentenceActor newSender, NotificationChain msgs) {
		SentenceActor oldSender = sender;
		sender = newSender;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.TO_SYSTEM__SENDER, oldSender, newSender);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(SentenceActor newSender) {
		if (newSender != sender) {
			NotificationChain msgs = null;
			if (sender != null)
				msgs = ((InternalEObject)sender).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.TO_SYSTEM__SENDER, null, msgs);
			if (newSender != null)
				msgs = ((InternalEObject)newSender).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.TO_SYSTEM__SENDER, null, msgs);
			msgs = basicSetSender(newSender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.TO_SYSTEM__SENDER, newSender, newSender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionPackage.TO_SYSTEM__ACTION_PARAM:
				return ((InternalEList<?>)getActionParam()).basicRemove(otherEnd, msgs);
			case ActionPackage.TO_SYSTEM__SENDER:
				return basicSetSender(null, msgs);
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
			case ActionPackage.TO_SYSTEM__SUMMARY:
				return getSummary();
			case ActionPackage.TO_SYSTEM__ACTION_PARAM:
				return getActionParam();
			case ActionPackage.TO_SYSTEM__ACTION_NAME:
				if (resolve) return getActionName();
				return basicGetActionName();
			case ActionPackage.TO_SYSTEM__SENDER:
				return getSender();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionPackage.TO_SYSTEM__ACTION_PARAM:
				getActionParam().clear();
				getActionParam().addAll((Collection<? extends SentenceActionParam>)newValue);
				return;
			case ActionPackage.TO_SYSTEM__ACTION_NAME:
				setActionName((Text)newValue);
				return;
			case ActionPackage.TO_SYSTEM__SENDER:
				setSender((SentenceActor)newValue);
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
			case ActionPackage.TO_SYSTEM__ACTION_PARAM:
				getActionParam().clear();
				return;
			case ActionPackage.TO_SYSTEM__ACTION_NAME:
				setActionName((Text)null);
				return;
			case ActionPackage.TO_SYSTEM__SENDER:
				setSender((SentenceActor)null);
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
			case ActionPackage.TO_SYSTEM__SUMMARY:
				return SUMMARY_EDEFAULT == null ? getSummary() != null : !SUMMARY_EDEFAULT.equals(getSummary());
			case ActionPackage.TO_SYSTEM__ACTION_PARAM:
				return actionParam != null && !actionParam.isEmpty();
			case ActionPackage.TO_SYSTEM__ACTION_NAME:
				return actionName != null;
			case ActionPackage.TO_SYSTEM__SENDER:
				return sender != null;
		}
		return super.eIsSet(featureID);
	}

} //ToSystemImpl
