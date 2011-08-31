/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.Goto;

import reprotool.model.linguistic.actionpart.GotoTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goto</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.GotoImpl#getGotoTarget <em>Goto Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GotoImpl extends ActionImpl implements Goto {
	/**
	 * The cached value of the '{@link #getGotoTarget() <em>Goto Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGotoTarget()
	 * @generated
	 * @ordered
	 */
	protected GotoTarget gotoTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GotoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.GOTO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GotoTarget getGotoTarget() {
		return gotoTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGotoTarget(GotoTarget newGotoTarget, NotificationChain msgs) {
		GotoTarget oldGotoTarget = gotoTarget;
		gotoTarget = newGotoTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.GOTO__GOTO_TARGET, oldGotoTarget, newGotoTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGotoTarget(GotoTarget newGotoTarget) {
		if (newGotoTarget != gotoTarget) {
			NotificationChain msgs = null;
			if (gotoTarget != null)
				msgs = ((InternalEObject)gotoTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.GOTO__GOTO_TARGET, null, msgs);
			if (newGotoTarget != null)
				msgs = ((InternalEObject)newGotoTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.GOTO__GOTO_TARGET, null, msgs);
			msgs = basicSetGotoTarget(newGotoTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.GOTO__GOTO_TARGET, newGotoTarget, newGotoTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionPackage.GOTO__GOTO_TARGET:
				return basicSetGotoTarget(null, msgs);
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
			case ActionPackage.GOTO__GOTO_TARGET:
				return getGotoTarget();
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
			case ActionPackage.GOTO__GOTO_TARGET:
				setGotoTarget((GotoTarget)newValue);
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
			case ActionPackage.GOTO__GOTO_TARGET:
				setGotoTarget((GotoTarget)null);
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
			case ActionPackage.GOTO__GOTO_TARGET:
				return gotoTarget != null;
		}
		return super.eIsSet(featureID);
	}

} //GotoImpl
