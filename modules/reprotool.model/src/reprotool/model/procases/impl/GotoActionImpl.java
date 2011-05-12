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
import reprotool.model.procases.GotoAction;
import reprotool.model.procases.ProcasesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goto Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.procases.impl.GotoActionImpl#getNextAction <em>Next Action</em>}</li>
 *   <li>{@link reprotool.model.procases.impl.GotoActionImpl#getTargetAction <em>Target Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GotoActionImpl extends EObjectImpl implements GotoAction {
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
	 * The cached value of the '{@link #getTargetAction() <em>Target Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAction()
	 * @generated
	 * @ordered
	 */
	protected Action targetAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GotoActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcasesPackage.Literals.GOTO_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getNextAction() {
		if (nextAction == null) {
			nextAction = new EObjectResolvingEList<Action>(Action.class, this, ProcasesPackage.GOTO_ACTION__NEXT_ACTION);
		}
		return nextAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getTargetAction() {
		if (targetAction != null && targetAction.eIsProxy()) {
			InternalEObject oldTargetAction = (InternalEObject)targetAction;
			targetAction = (Action)eResolveProxy(oldTargetAction);
			if (targetAction != oldTargetAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcasesPackage.GOTO_ACTION__TARGET_ACTION, oldTargetAction, targetAction));
			}
		}
		return targetAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetTargetAction() {
		return targetAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAction(Action newTargetAction) {
		Action oldTargetAction = targetAction;
		targetAction = newTargetAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcasesPackage.GOTO_ACTION__TARGET_ACTION, oldTargetAction, targetAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcasesPackage.GOTO_ACTION__NEXT_ACTION:
				return getNextAction();
			case ProcasesPackage.GOTO_ACTION__TARGET_ACTION:
				if (resolve) return getTargetAction();
				return basicGetTargetAction();
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
			case ProcasesPackage.GOTO_ACTION__NEXT_ACTION:
				getNextAction().clear();
				getNextAction().addAll((Collection<? extends Action>)newValue);
				return;
			case ProcasesPackage.GOTO_ACTION__TARGET_ACTION:
				setTargetAction((Action)newValue);
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
			case ProcasesPackage.GOTO_ACTION__NEXT_ACTION:
				getNextAction().clear();
				return;
			case ProcasesPackage.GOTO_ACTION__TARGET_ACTION:
				setTargetAction((Action)null);
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
			case ProcasesPackage.GOTO_ACTION__NEXT_ACTION:
				return nextAction != null && !nextAction.isEmpty();
			case ProcasesPackage.GOTO_ACTION__TARGET_ACTION:
				return targetAction != null;
		}
		return super.eIsSet(featureID);
	}

} //GotoActionImpl
