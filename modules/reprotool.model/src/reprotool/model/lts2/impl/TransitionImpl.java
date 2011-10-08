/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts2.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.lts2.Lts2Package;
import reprotool.model.lts2.State;
import reprotool.model.lts2.Transition;

import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.lts2.impl.TransitionImpl#getTargetState <em>Target State</em>}</li>
 *   <li>{@link reprotool.model.lts2.impl.TransitionImpl#getRelatedStep <em>Related Step</em>}</li>
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Lts2Package.TRANSITION__TARGET_STATE:
				if (resolve) return getTargetState();
				return basicGetTargetState();
			case Lts2Package.TRANSITION__RELATED_STEP:
				if (resolve) return getRelatedStep();
				return basicGetRelatedStep();
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
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
