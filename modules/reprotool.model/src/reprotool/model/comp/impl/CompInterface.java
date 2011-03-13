/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.comp.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.comp.ICompInterface;
import reprotool.model.comp.ICompInterfaceType;
import reprotool.model.comp.ICompPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.comp.impl.CompInterface#getInterfaceType <em>Interface Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompInterface extends EObjectImpl implements ICompInterface {
	/**
	 * The cached value of the '{@link #getInterfaceType() <em>Interface Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceType()
	 * @generated
	 * @ordered
	 */
	protected ICompInterfaceType interfaceType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompInterface() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICompPackage.Literals.COMP_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICompInterfaceType getInterfaceType() {
		if (interfaceType != null && interfaceType.eIsProxy()) {
			InternalEObject oldInterfaceType = (InternalEObject)interfaceType;
			interfaceType = (ICompInterfaceType)eResolveProxy(oldInterfaceType);
			if (interfaceType != oldInterfaceType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ICompPackage.COMP_INTERFACE__INTERFACE_TYPE, oldInterfaceType, interfaceType));
			}
		}
		return interfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICompInterfaceType basicGetInterfaceType() {
		return interfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceType(ICompInterfaceType newInterfaceType) {
		ICompInterfaceType oldInterfaceType = interfaceType;
		interfaceType = newInterfaceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ICompPackage.COMP_INTERFACE__INTERFACE_TYPE, oldInterfaceType, interfaceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ICompPackage.COMP_INTERFACE__INTERFACE_TYPE:
				if (resolve) return getInterfaceType();
				return basicGetInterfaceType();
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
			case ICompPackage.COMP_INTERFACE__INTERFACE_TYPE:
				setInterfaceType((ICompInterfaceType)newValue);
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
			case ICompPackage.COMP_INTERFACE__INTERFACE_TYPE:
				setInterfaceType((ICompInterfaceType)null);
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
			case ICompPackage.COMP_INTERFACE__INTERFACE_TYPE:
				return interfaceType != null;
		}
		return super.eIsSet(featureID);
	}

} //CompInterface
