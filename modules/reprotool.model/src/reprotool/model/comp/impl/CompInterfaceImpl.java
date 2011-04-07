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

import reprotool.model.comp.CompInterface;
import reprotool.model.comp.CompInterfaceType;
import reprotool.model.comp.CompPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.comp.impl.CompInterfaceImpl#getInterfaceType <em>Interface Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompInterfaceImpl extends EObjectImpl implements CompInterface {
	/**
	 * The cached value of the '{@link #getInterfaceType() <em>Interface Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceType()
	 * @generated
	 * @ordered
	 */
	protected CompInterfaceType interfaceType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompPackage.Literals.COMP_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompInterfaceType getInterfaceType() {
		if (interfaceType != null && interfaceType.eIsProxy())
		{
			InternalEObject oldInterfaceType = (InternalEObject)interfaceType;
			interfaceType = (CompInterfaceType)eResolveProxy(oldInterfaceType);
			if (interfaceType != oldInterfaceType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompPackage.COMP_INTERFACE__INTERFACE_TYPE, oldInterfaceType, interfaceType));
			}
		}
		return interfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompInterfaceType basicGetInterfaceType() {
		return interfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceType(CompInterfaceType newInterfaceType) {
		CompInterfaceType oldInterfaceType = interfaceType;
		interfaceType = newInterfaceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompPackage.COMP_INTERFACE__INTERFACE_TYPE, oldInterfaceType, interfaceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case CompPackage.COMP_INTERFACE__INTERFACE_TYPE:
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
		switch (featureID)
		{
			case CompPackage.COMP_INTERFACE__INTERFACE_TYPE:
				setInterfaceType((CompInterfaceType)newValue);
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
		switch (featureID)
		{
			case CompPackage.COMP_INTERFACE__INTERFACE_TYPE:
				setInterfaceType((CompInterfaceType)null);
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
		switch (featureID)
		{
			case CompPackage.COMP_INTERFACE__INTERFACE_TYPE:
				return interfaceType != null;
		}
		return super.eIsSet(featureID);
	}

} //CompInterfaceImpl
