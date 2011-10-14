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
import reprotool.fm.nusmv.State;

import reprotool.model.usecase.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.impl.ModuleImpl#getAdjacentUseCase <em>Adjacent Use Case</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.impl.ModuleImpl#getModuleId <em>Module Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.impl.ModuleImpl#getProcessId <em>Process Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.impl.ModuleImpl#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends EObjectImpl implements Module {
	/**
	 * The cached value of the '{@link #getAdjacentUseCase() <em>Adjacent Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdjacentUseCase()
	 * @generated
	 * @ordered
	 */
	protected UseCase adjacentUseCase;

	/**
	 * The default value of the '{@link #getModuleId() <em>Module Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleId()
	 * @generated
	 * @ordered
	 */
	protected static final String MODULE_ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getProcessId() <em>Process Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessId()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESS_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessId() <em>Process Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessId()
	 * @generated
	 * @ordered
	 */
	protected String processId = PROCESS_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NusmvPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getAdjacentUseCase() {
		if (adjacentUseCase != null && adjacentUseCase.eIsProxy()) {
			InternalEObject oldAdjacentUseCase = (InternalEObject)adjacentUseCase;
			adjacentUseCase = (UseCase)eResolveProxy(oldAdjacentUseCase);
			if (adjacentUseCase != oldAdjacentUseCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NusmvPackage.MODULE__ADJACENT_USE_CASE, oldAdjacentUseCase, adjacentUseCase));
			}
		}
		return adjacentUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase basicGetAdjacentUseCase() {
		return adjacentUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdjacentUseCase(UseCase newAdjacentUseCase) {
		UseCase oldAdjacentUseCase = adjacentUseCase;
		adjacentUseCase = newAdjacentUseCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NusmvPackage.MODULE__ADJACENT_USE_CASE, oldAdjacentUseCase, adjacentUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModuleId() {
		// TODO: implement this method to return the 'Module Id' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetModuleId() {
		// TODO: implement this method to return whether the 'Module Id' attribute is set
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, NusmvPackage.MODULE__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NusmvPackage.MODULE__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
			case NusmvPackage.MODULE__ADJACENT_USE_CASE:
				if (resolve) return getAdjacentUseCase();
				return basicGetAdjacentUseCase();
			case NusmvPackage.MODULE__MODULE_ID:
				return getModuleId();
			case NusmvPackage.MODULE__PROCESS_ID:
				return getProcessId();
			case NusmvPackage.MODULE__STATES:
				return getStates();
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
			case NusmvPackage.MODULE__ADJACENT_USE_CASE:
				setAdjacentUseCase((UseCase)newValue);
				return;
			case NusmvPackage.MODULE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
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
			case NusmvPackage.MODULE__ADJACENT_USE_CASE:
				setAdjacentUseCase((UseCase)null);
				return;
			case NusmvPackage.MODULE__STATES:
				getStates().clear();
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
			case NusmvPackage.MODULE__ADJACENT_USE_CASE:
				return adjacentUseCase != null;
			case NusmvPackage.MODULE__MODULE_ID:
				return isSetModuleId();
			case NusmvPackage.MODULE__PROCESS_ID:
				return PROCESS_ID_EDEFAULT == null ? processId != null : !PROCESS_ID_EDEFAULT.equals(processId);
			case NusmvPackage.MODULE__STATES:
				return states != null && !states.isEmpty();
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
		result.append(" (processId: ");
		result.append(processId);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
