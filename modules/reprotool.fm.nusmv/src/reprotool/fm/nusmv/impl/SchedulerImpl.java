/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.fm.nusmv.impl;

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

import reprotool.fm.nusmv.Module;
import reprotool.fm.nusmv.NusmvPackage;
import reprotool.fm.nusmv.Scheduler;
import reprotool.fm.nusmv.TemporalVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.impl.SchedulerImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.impl.SchedulerImpl#getTempVars <em>Temp Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulerImpl extends EObjectImpl implements Scheduler {
	/**
	 * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModules()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> modules;

	/**
	 * The cached value of the '{@link #getTempVars() <em>Temp Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempVars()
	 * @generated
	 * @ordered
	 */
	protected EList<TemporalVar> tempVars;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NusmvPackage.Literals.SCHEDULER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getModules() {
		if (modules == null) {
			modules = new EObjectContainmentEList<Module>(Module.class, this, NusmvPackage.SCHEDULER__MODULES);
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemporalVar> getTempVars() {
		if (tempVars == null) {
			tempVars = new EObjectContainmentEList<TemporalVar>(TemporalVar.class, this, NusmvPackage.SCHEDULER__TEMP_VARS);
		}
		return tempVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NusmvPackage.SCHEDULER__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
			case NusmvPackage.SCHEDULER__TEMP_VARS:
				return ((InternalEList<?>)getTempVars()).basicRemove(otherEnd, msgs);
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
			case NusmvPackage.SCHEDULER__MODULES:
				return getModules();
			case NusmvPackage.SCHEDULER__TEMP_VARS:
				return getTempVars();
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
			case NusmvPackage.SCHEDULER__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends Module>)newValue);
				return;
			case NusmvPackage.SCHEDULER__TEMP_VARS:
				getTempVars().clear();
				getTempVars().addAll((Collection<? extends TemporalVar>)newValue);
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
			case NusmvPackage.SCHEDULER__MODULES:
				getModules().clear();
				return;
			case NusmvPackage.SCHEDULER__TEMP_VARS:
				getTempVars().clear();
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
			case NusmvPackage.SCHEDULER__MODULES:
				return modules != null && !modules.isEmpty();
			case NusmvPackage.SCHEDULER__TEMP_VARS:
				return tempVars != null && !tempVars.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SchedulerImpl
