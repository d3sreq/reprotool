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
import reprotool.model.linguistic.action.InternalAction;

import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.Text;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.InternalActionImpl#getSummary <em>Summary</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.InternalActionImpl#getActionParam <em>Action Param</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.InternalActionImpl#getActionName <em>Action Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalActionImpl extends EObjectImpl implements InternalAction {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.INTERNAL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SentenceActionParam> getActionParam() {
		if (actionParam == null) {
			actionParam = new EObjectContainmentEList<SentenceActionParam>(SentenceActionParam.class, this, ActionPackage.INTERNAL_ACTION__ACTION_PARAM);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionPackage.INTERNAL_ACTION__ACTION_NAME, oldActionName, actionName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.INTERNAL_ACTION__ACTION_NAME, oldActionName, actionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSummary() {
		return "Executed within the System";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionPackage.INTERNAL_ACTION__ACTION_PARAM:
				return ((InternalEList<?>)getActionParam()).basicRemove(otherEnd, msgs);
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
			case ActionPackage.INTERNAL_ACTION__SUMMARY:
				return getSummary();
			case ActionPackage.INTERNAL_ACTION__ACTION_PARAM:
				return getActionParam();
			case ActionPackage.INTERNAL_ACTION__ACTION_NAME:
				if (resolve) return getActionName();
				return basicGetActionName();
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
			case ActionPackage.INTERNAL_ACTION__ACTION_PARAM:
				getActionParam().clear();
				getActionParam().addAll((Collection<? extends SentenceActionParam>)newValue);
				return;
			case ActionPackage.INTERNAL_ACTION__ACTION_NAME:
				setActionName((Text)newValue);
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
			case ActionPackage.INTERNAL_ACTION__ACTION_PARAM:
				getActionParam().clear();
				return;
			case ActionPackage.INTERNAL_ACTION__ACTION_NAME:
				setActionName((Text)null);
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
			case ActionPackage.INTERNAL_ACTION__SUMMARY:
				return SUMMARY_EDEFAULT == null ? getSummary() != null : !SUMMARY_EDEFAULT.equals(getSummary());
			case ActionPackage.INTERNAL_ACTION__ACTION_PARAM:
				return actionParam != null && !actionParam.isEmpty();
			case ActionPackage.INTERNAL_ACTION__ACTION_NAME:
				return actionName != null;
		}
		return super.eIsSet(featureID);
	}

} //InternalActionImpl
