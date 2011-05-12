/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.procases.Action;
import reprotool.model.procases.BehaviourProtocol;
import reprotool.model.procases.ProcasesPackage;

import reprotool.model.usecase.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaviour Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.procases.impl.BehaviourProtocolImpl#getBeginAction <em>Begin Action</em>}</li>
 *   <li>{@link reprotool.model.procases.impl.BehaviourProtocolImpl#getEnclosingUseCase <em>Enclosing Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviourProtocolImpl extends EObjectImpl implements BehaviourProtocol {
	/**
	 * The cached value of the '{@link #getBeginAction() <em>Begin Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginAction()
	 * @generated
	 * @ordered
	 */
	protected Action beginAction;

	/**
	 * The cached value of the '{@link #getEnclosingUseCase() <em>Enclosing Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingUseCase()
	 * @generated
	 * @ordered
	 */
	protected UseCase enclosingUseCase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviourProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcasesPackage.Literals.BEHAVIOUR_PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getBeginAction() {
		if (beginAction != null && beginAction.eIsProxy()) {
			InternalEObject oldBeginAction = (InternalEObject)beginAction;
			beginAction = (Action)eResolveProxy(oldBeginAction);
			if (beginAction != oldBeginAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcasesPackage.BEHAVIOUR_PROTOCOL__BEGIN_ACTION, oldBeginAction, beginAction));
			}
		}
		return beginAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetBeginAction() {
		return beginAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeginAction(Action newBeginAction) {
		Action oldBeginAction = beginAction;
		beginAction = newBeginAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcasesPackage.BEHAVIOUR_PROTOCOL__BEGIN_ACTION, oldBeginAction, beginAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getEnclosingUseCase() {
		if (enclosingUseCase != null && enclosingUseCase.eIsProxy()) {
			InternalEObject oldEnclosingUseCase = (InternalEObject)enclosingUseCase;
			enclosingUseCase = (UseCase)eResolveProxy(oldEnclosingUseCase);
			if (enclosingUseCase != oldEnclosingUseCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcasesPackage.BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE, oldEnclosingUseCase, enclosingUseCase));
			}
		}
		return enclosingUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase basicGetEnclosingUseCase() {
		return enclosingUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosingUseCase(UseCase newEnclosingUseCase) {
		UseCase oldEnclosingUseCase = enclosingUseCase;
		enclosingUseCase = newEnclosingUseCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcasesPackage.BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE, oldEnclosingUseCase, enclosingUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__BEGIN_ACTION:
				if (resolve) return getBeginAction();
				return basicGetBeginAction();
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE:
				if (resolve) return getEnclosingUseCase();
				return basicGetEnclosingUseCase();
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
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__BEGIN_ACTION:
				setBeginAction((Action)newValue);
				return;
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE:
				setEnclosingUseCase((UseCase)newValue);
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
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__BEGIN_ACTION:
				setBeginAction((Action)null);
				return;
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE:
				setEnclosingUseCase((UseCase)null);
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
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__BEGIN_ACTION:
				return beginAction != null;
			case ProcasesPackage.BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE:
				return enclosingUseCase != null;
		}
		return super.eIsSet(featureID);
	}

} //BehaviourProtocolImpl
