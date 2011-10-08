/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts2.impl;

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

import reprotool.model.lts2.FinalState;
import reprotool.model.lts2.InitialState;
import reprotool.model.lts2.Lts2Package;
import reprotool.model.lts2.StateMachine;
import reprotool.model.lts2.TransitionalState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.lts2.impl.StateMachineImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link reprotool.model.lts2.impl.StateMachineImpl#getTransitionalStates <em>Transitional States</em>}</li>
 *   <li>{@link reprotool.model.lts2.impl.StateMachineImpl#getFinalState <em>Final State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachineImpl extends EObjectImpl implements StateMachine {
	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected InitialState initialState;

	/**
	 * The cached value of the '{@link #getTransitionalStates() <em>Transitional States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionalStates()
	 * @generated
	 * @ordered
	 */
	protected EList<TransitionalState> transitionalStates;

	/**
	 * The cached value of the '{@link #getFinalState() <em>Final State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalState()
	 * @generated
	 * @ordered
	 */
	protected FinalState finalState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Lts2Package.Literals.STATE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialState getInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialState(InitialState newInitialState, NotificationChain msgs) {
		InitialState oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Lts2Package.STATE_MACHINE__INITIAL_STATE, oldInitialState, newInitialState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(InitialState newInitialState) {
		if (newInitialState != initialState) {
			NotificationChain msgs = null;
			if (initialState != null)
				msgs = ((InternalEObject)initialState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Lts2Package.STATE_MACHINE__INITIAL_STATE, null, msgs);
			if (newInitialState != null)
				msgs = ((InternalEObject)newInitialState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Lts2Package.STATE_MACHINE__INITIAL_STATE, null, msgs);
			msgs = basicSetInitialState(newInitialState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Lts2Package.STATE_MACHINE__INITIAL_STATE, newInitialState, newInitialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransitionalState> getTransitionalStates() {
		if (transitionalStates == null) {
			transitionalStates = new EObjectContainmentEList<TransitionalState>(TransitionalState.class, this, Lts2Package.STATE_MACHINE__TRANSITIONAL_STATES);
		}
		return transitionalStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalState getFinalState() {
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinalState(FinalState newFinalState, NotificationChain msgs) {
		FinalState oldFinalState = finalState;
		finalState = newFinalState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Lts2Package.STATE_MACHINE__FINAL_STATE, oldFinalState, newFinalState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinalState(FinalState newFinalState) {
		if (newFinalState != finalState) {
			NotificationChain msgs = null;
			if (finalState != null)
				msgs = ((InternalEObject)finalState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Lts2Package.STATE_MACHINE__FINAL_STATE, null, msgs);
			if (newFinalState != null)
				msgs = ((InternalEObject)newFinalState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Lts2Package.STATE_MACHINE__FINAL_STATE, null, msgs);
			msgs = basicSetFinalState(newFinalState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Lts2Package.STATE_MACHINE__FINAL_STATE, newFinalState, newFinalState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Lts2Package.STATE_MACHINE__INITIAL_STATE:
				return basicSetInitialState(null, msgs);
			case Lts2Package.STATE_MACHINE__TRANSITIONAL_STATES:
				return ((InternalEList<?>)getTransitionalStates()).basicRemove(otherEnd, msgs);
			case Lts2Package.STATE_MACHINE__FINAL_STATE:
				return basicSetFinalState(null, msgs);
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
			case Lts2Package.STATE_MACHINE__INITIAL_STATE:
				return getInitialState();
			case Lts2Package.STATE_MACHINE__TRANSITIONAL_STATES:
				return getTransitionalStates();
			case Lts2Package.STATE_MACHINE__FINAL_STATE:
				return getFinalState();
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
			case Lts2Package.STATE_MACHINE__INITIAL_STATE:
				setInitialState((InitialState)newValue);
				return;
			case Lts2Package.STATE_MACHINE__TRANSITIONAL_STATES:
				getTransitionalStates().clear();
				getTransitionalStates().addAll((Collection<? extends TransitionalState>)newValue);
				return;
			case Lts2Package.STATE_MACHINE__FINAL_STATE:
				setFinalState((FinalState)newValue);
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
			case Lts2Package.STATE_MACHINE__INITIAL_STATE:
				setInitialState((InitialState)null);
				return;
			case Lts2Package.STATE_MACHINE__TRANSITIONAL_STATES:
				getTransitionalStates().clear();
				return;
			case Lts2Package.STATE_MACHINE__FINAL_STATE:
				setFinalState((FinalState)null);
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
			case Lts2Package.STATE_MACHINE__INITIAL_STATE:
				return initialState != null;
			case Lts2Package.STATE_MACHINE__TRANSITIONAL_STATES:
				return transitionalStates != null && !transitionalStates.isEmpty();
			case Lts2Package.STATE_MACHINE__FINAL_STATE:
				return finalState != null;
		}
		return super.eIsSet(featureID);
	}

} //StateMachineImpl
