/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lts2.impl;

import lts2.Lts2Package;
import lts2.State;
import lts2.Transition;
import lts2.TransitionalState;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link lts2.impl.TransitionImpl#getTargetState <em>Target State</em>}</li>
 *   <li>{@link lts2.impl.TransitionImpl#getRelatedStep <em>Related Step</em>}</li>
 *   <li>{@link lts2.impl.TransitionImpl#getSourceState <em>Source State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EObjectImpl implements Transition {
	/**
	 * The cached value of the '{@link #getTargetState() <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetState()
	 * @generated
	 * @ordered
	 */
	protected State targetState;

	/**
	 * The cached value of the '{@link #getRelatedStep() <em>Related Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedStep()
	 * @generated
	 * @ordered
	 */
	protected UseCaseStep relatedStep;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Lts2Package.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTargetState() {
		if (targetState != null && targetState.eIsProxy()) {
			InternalEObject oldTargetState = (InternalEObject)targetState;
			targetState = (State)eResolveProxy(oldTargetState);
			if (targetState != oldTargetState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Lts2Package.TRANSITION__TARGET_STATE, oldTargetState, targetState));
			}
		}
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTargetState() {
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetState(State newTargetState) {
		State oldTargetState = targetState;
		targetState = newTargetState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Lts2Package.TRANSITION__TARGET_STATE, oldTargetState, targetState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep getRelatedStep() {
		if (relatedStep != null && relatedStep.eIsProxy()) {
			InternalEObject oldRelatedStep = (InternalEObject)relatedStep;
			relatedStep = (UseCaseStep)eResolveProxy(oldRelatedStep);
			if (relatedStep != oldRelatedStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Lts2Package.TRANSITION__RELATED_STEP, oldRelatedStep, relatedStep));
			}
		}
		return relatedStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep basicGetRelatedStep() {
		return relatedStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedStep(UseCaseStep newRelatedStep) {
		UseCaseStep oldRelatedStep = relatedStep;
		relatedStep = newRelatedStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Lts2Package.TRANSITION__RELATED_STEP, oldRelatedStep, relatedStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionalState getSourceState() {
		if (eContainerFeatureID() != Lts2Package.TRANSITION__SOURCE_STATE) return null;
		return (TransitionalState)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceState(TransitionalState newSourceState, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourceState, Lts2Package.TRANSITION__SOURCE_STATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceState(TransitionalState newSourceState) {
		if (newSourceState != eInternalContainer() || (eContainerFeatureID() != Lts2Package.TRANSITION__SOURCE_STATE && newSourceState != null)) {
			if (EcoreUtil.isAncestor(this, newSourceState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourceState != null)
				msgs = ((InternalEObject)newSourceState).eInverseAdd(this, Lts2Package.TRANSITIONAL_STATE__TRANSITIONS, TransitionalState.class, msgs);
			msgs = basicSetSourceState(newSourceState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Lts2Package.TRANSITION__SOURCE_STATE, newSourceState, newSourceState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Lts2Package.TRANSITION__SOURCE_STATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourceState((TransitionalState)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Lts2Package.TRANSITION__SOURCE_STATE:
				return basicSetSourceState(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Lts2Package.TRANSITION__SOURCE_STATE:
				return eInternalContainer().eInverseRemove(this, Lts2Package.TRANSITIONAL_STATE__TRANSITIONS, TransitionalState.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Lts2Package.TRANSITION__TARGET_STATE:
				if (resolve) return getTargetState();
				return basicGetTargetState();
			case Lts2Package.TRANSITION__RELATED_STEP:
				if (resolve) return getRelatedStep();
				return basicGetRelatedStep();
			case Lts2Package.TRANSITION__SOURCE_STATE:
				return getSourceState();
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
			case Lts2Package.TRANSITION__TARGET_STATE:
				setTargetState((State)newValue);
				return;
			case Lts2Package.TRANSITION__RELATED_STEP:
				setRelatedStep((UseCaseStep)newValue);
				return;
			case Lts2Package.TRANSITION__SOURCE_STATE:
				setSourceState((TransitionalState)newValue);
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
			case Lts2Package.TRANSITION__TARGET_STATE:
				setTargetState((State)null);
				return;
			case Lts2Package.TRANSITION__RELATED_STEP:
				setRelatedStep((UseCaseStep)null);
				return;
			case Lts2Package.TRANSITION__SOURCE_STATE:
				setSourceState((TransitionalState)null);
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
			case Lts2Package.TRANSITION__TARGET_STATE:
				return targetState != null;
			case Lts2Package.TRANSITION__RELATED_STEP:
				return relatedStep != null;
			case Lts2Package.TRANSITION__SOURCE_STATE:
				return getSourceState() != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
