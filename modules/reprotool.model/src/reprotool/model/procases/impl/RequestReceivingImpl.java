/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.model.procases.Action;
import reprotool.model.procases.ProcasesPackage;
import reprotool.model.procases.RequestReceiving;

import reprotool.model.swproj.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Request Receiving</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.procases.impl.RequestReceivingImpl#getNextAction <em>Next Action</em>}</li>
 *   <li>{@link reprotool.model.procases.impl.RequestReceivingImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link reprotool.model.procases.impl.RequestReceivingImpl#getActionName <em>Action Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequestReceivingImpl extends EObjectImpl implements RequestReceiving {
	/**
	 * The cached value of the '{@link #getNextAction() <em>Next Action</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> nextAction;

	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected Actor actor;

	/**
	 * The default value of the '{@link #getActionName() <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionName()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionName() <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionName()
	 * @generated
	 * @ordered
	 */
	protected String actionName = ACTION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequestReceivingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcasesPackage.Literals.REQUEST_RECEIVING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getNextAction() {
		if (nextAction == null) {
			nextAction = new EObjectResolvingEList<Action>(Action.class, this, ProcasesPackage.REQUEST_RECEIVING__NEXT_ACTION);
		}
		return nextAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getActor() {
		if (actor != null && actor.eIsProxy()) {
			InternalEObject oldActor = (InternalEObject)actor;
			actor = (Actor)eResolveProxy(oldActor);
			if (actor != oldActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcasesPackage.REQUEST_RECEIVING__ACTOR, oldActor, actor));
			}
		}
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetActor() {
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActor(Actor newActor) {
		Actor oldActor = actor;
		actor = newActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcasesPackage.REQUEST_RECEIVING__ACTOR, oldActor, actor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionName(String newActionName) {
		String oldActionName = actionName;
		actionName = newActionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcasesPackage.REQUEST_RECEIVING__ACTION_NAME, oldActionName, actionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcasesPackage.REQUEST_RECEIVING__NEXT_ACTION:
				return getNextAction();
			case ProcasesPackage.REQUEST_RECEIVING__ACTOR:
				if (resolve) return getActor();
				return basicGetActor();
			case ProcasesPackage.REQUEST_RECEIVING__ACTION_NAME:
				return getActionName();
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
			case ProcasesPackage.REQUEST_RECEIVING__NEXT_ACTION:
				getNextAction().clear();
				getNextAction().addAll((Collection<? extends Action>)newValue);
				return;
			case ProcasesPackage.REQUEST_RECEIVING__ACTOR:
				setActor((Actor)newValue);
				return;
			case ProcasesPackage.REQUEST_RECEIVING__ACTION_NAME:
				setActionName((String)newValue);
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
			case ProcasesPackage.REQUEST_RECEIVING__NEXT_ACTION:
				getNextAction().clear();
				return;
			case ProcasesPackage.REQUEST_RECEIVING__ACTOR:
				setActor((Actor)null);
				return;
			case ProcasesPackage.REQUEST_RECEIVING__ACTION_NAME:
				setActionName(ACTION_NAME_EDEFAULT);
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
			case ProcasesPackage.REQUEST_RECEIVING__NEXT_ACTION:
				return nextAction != null && !nextAction.isEmpty();
			case ProcasesPackage.REQUEST_RECEIVING__ACTOR:
				return actor != null;
			case ProcasesPackage.REQUEST_RECEIVING__ACTION_NAME:
				return ACTION_NAME_EDEFAULT == null ? actionName != null : !ACTION_NAME_EDEFAULT.equals(actionName);
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
		result.append(" (actionName: ");
		result.append(actionName);
		result.append(')');
		return result.toString();
	}

} //RequestReceivingImpl
