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
import reprotool.model.procases.BehaviourProtocol;
import reprotool.model.procases.IncludeProtocol;
import reprotool.model.procases.ProcasesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.procases.impl.IncludeProtocolImpl#getNextAction <em>Next Action</em>}</li>
 *   <li>{@link reprotool.model.procases.impl.IncludeProtocolImpl#getIncludedProtocol <em>Included Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IncludeProtocolImpl extends EObjectImpl implements IncludeProtocol {
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
	 * The cached value of the '{@link #getIncludedProtocol() <em>Included Protocol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedProtocol()
	 * @generated
	 * @ordered
	 */
	protected BehaviourProtocol includedProtocol;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IncludeProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcasesPackage.Literals.INCLUDE_PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getNextAction() {
		if (nextAction == null) {
			nextAction = new EObjectResolvingEList<Action>(Action.class, this, ProcasesPackage.INCLUDE_PROTOCOL__NEXT_ACTION);
		}
		return nextAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviourProtocol getIncludedProtocol() {
		if (includedProtocol != null && includedProtocol.eIsProxy()) {
			InternalEObject oldIncludedProtocol = (InternalEObject)includedProtocol;
			includedProtocol = (BehaviourProtocol)eResolveProxy(oldIncludedProtocol);
			if (includedProtocol != oldIncludedProtocol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcasesPackage.INCLUDE_PROTOCOL__INCLUDED_PROTOCOL, oldIncludedProtocol, includedProtocol));
			}
		}
		return includedProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviourProtocol basicGetIncludedProtocol() {
		return includedProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludedProtocol(BehaviourProtocol newIncludedProtocol) {
		BehaviourProtocol oldIncludedProtocol = includedProtocol;
		includedProtocol = newIncludedProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcasesPackage.INCLUDE_PROTOCOL__INCLUDED_PROTOCOL, oldIncludedProtocol, includedProtocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcasesPackage.INCLUDE_PROTOCOL__NEXT_ACTION:
				return getNextAction();
			case ProcasesPackage.INCLUDE_PROTOCOL__INCLUDED_PROTOCOL:
				if (resolve) return getIncludedProtocol();
				return basicGetIncludedProtocol();
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
			case ProcasesPackage.INCLUDE_PROTOCOL__NEXT_ACTION:
				getNextAction().clear();
				getNextAction().addAll((Collection<? extends Action>)newValue);
				return;
			case ProcasesPackage.INCLUDE_PROTOCOL__INCLUDED_PROTOCOL:
				setIncludedProtocol((BehaviourProtocol)newValue);
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
			case ProcasesPackage.INCLUDE_PROTOCOL__NEXT_ACTION:
				getNextAction().clear();
				return;
			case ProcasesPackage.INCLUDE_PROTOCOL__INCLUDED_PROTOCOL:
				setIncludedProtocol((BehaviourProtocol)null);
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
			case ProcasesPackage.INCLUDE_PROTOCOL__NEXT_ACTION:
				return nextAction != null && !nextAction.isEmpty();
			case ProcasesPackage.INCLUDE_PROTOCOL__INCLUDED_PROTOCOL:
				return includedProtocol != null;
		}
		return super.eIsSet(featureID);
	}

} //IncludeProtocolImpl
