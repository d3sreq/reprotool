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
import reprotool.model.linguistic.action.FromSystem;

import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.SentenceActor;
import reprotool.model.linguistic.actionpart.Text;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.FromSystemImpl#getActionParam <em>Action Param</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.FromSystemImpl#getActionName <em>Action Name</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.FromSystemImpl#getReceiver <em>Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FromSystemImpl extends EObjectImpl implements FromSystem {
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
	 * The cached value of the '{@link #getReceiver() <em>Receiver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiver()
	 * @generated
	 * @ordered
	 */
	protected SentenceActor receiver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.FROM_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SentenceActionParam> getActionParam() {
		if (actionParam == null) {
			actionParam = new EObjectContainmentEList<SentenceActionParam>(SentenceActionParam.class, this, ActionPackage.FROM_SYSTEM__ACTION_PARAM);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionPackage.FROM_SYSTEM__ACTION_NAME, oldActionName, actionName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.FROM_SYSTEM__ACTION_NAME, oldActionName, actionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceActor getReceiver() {
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReceiver(SentenceActor newReceiver, NotificationChain msgs) {
		SentenceActor oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.FROM_SYSTEM__RECEIVER, oldReceiver, newReceiver);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiver(SentenceActor newReceiver) {
		if (newReceiver != receiver) {
			NotificationChain msgs = null;
			if (receiver != null)
				msgs = ((InternalEObject)receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.FROM_SYSTEM__RECEIVER, null, msgs);
			if (newReceiver != null)
				msgs = ((InternalEObject)newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.FROM_SYSTEM__RECEIVER, null, msgs);
			msgs = basicSetReceiver(newReceiver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.FROM_SYSTEM__RECEIVER, newReceiver, newReceiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionPackage.FROM_SYSTEM__ACTION_PARAM:
				return ((InternalEList<?>)getActionParam()).basicRemove(otherEnd, msgs);
			case ActionPackage.FROM_SYSTEM__RECEIVER:
				return basicSetReceiver(null, msgs);
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
			case ActionPackage.FROM_SYSTEM__ACTION_PARAM:
				return getActionParam();
			case ActionPackage.FROM_SYSTEM__ACTION_NAME:
				if (resolve) return getActionName();
				return basicGetActionName();
			case ActionPackage.FROM_SYSTEM__RECEIVER:
				return getReceiver();
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
			case ActionPackage.FROM_SYSTEM__ACTION_PARAM:
				getActionParam().clear();
				getActionParam().addAll((Collection<? extends SentenceActionParam>)newValue);
				return;
			case ActionPackage.FROM_SYSTEM__ACTION_NAME:
				setActionName((Text)newValue);
				return;
			case ActionPackage.FROM_SYSTEM__RECEIVER:
				setReceiver((SentenceActor)newValue);
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
			case ActionPackage.FROM_SYSTEM__ACTION_PARAM:
				getActionParam().clear();
				return;
			case ActionPackage.FROM_SYSTEM__ACTION_NAME:
				setActionName((Text)null);
				return;
			case ActionPackage.FROM_SYSTEM__RECEIVER:
				setReceiver((SentenceActor)null);
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
			case ActionPackage.FROM_SYSTEM__ACTION_PARAM:
				return actionParam != null && !actionParam.isEmpty();
			case ActionPackage.FROM_SYSTEM__ACTION_NAME:
				return actionName != null;
			case ActionPackage.FROM_SYSTEM__RECEIVER:
				return receiver != null;
		}
		return super.eIsSet(featureID);
	}

} //FromSystemImpl
