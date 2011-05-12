/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.model.lts.GuardTransition;
import reprotool.model.lts.LtsPackage;
import reprotool.model.lts.State;

import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.lts.impl.GuardTransitionImpl#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.lts.impl.GuardTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link reprotool.model.lts.impl.GuardTransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link reprotool.model.lts.impl.GuardTransitionImpl#getNegatedGuards <em>Negated Guards</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardTransitionImpl extends EObjectImpl implements GuardTransition {
	/**
	 * The cached value of the '{@link #getSentence() <em>Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentence()
	 * @generated
	 * @ordered
	 */
	protected UseCaseStep sentence;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected State source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected State target;

	/**
	 * The cached value of the '{@link #getNegatedGuards() <em>Negated Guards</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNegatedGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<GuardTransition> negatedGuards;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LtsPackage.Literals.GUARD_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep getSentence() {
		if (sentence != null && sentence.eIsProxy()) {
			InternalEObject oldSentence = (InternalEObject)sentence;
			sentence = (UseCaseStep)eResolveProxy(oldSentence);
			if (sentence != oldSentence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LtsPackage.GUARD_TRANSITION__SENTENCE, oldSentence, sentence));
			}
		}
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep basicGetSentence() {
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentence(UseCaseStep newSentence) {
		UseCaseStep oldSentence = sentence;
		sentence = newSentence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LtsPackage.GUARD_TRANSITION__SENTENCE, oldSentence, sentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (State)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LtsPackage.GUARD_TRANSITION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(State newSource) {
		State oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LtsPackage.GUARD_TRANSITION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (State)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LtsPackage.GUARD_TRANSITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(State newTarget) {
		State oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LtsPackage.GUARD_TRANSITION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GuardTransition> getNegatedGuards() {
		if (negatedGuards == null) {
			negatedGuards = new EObjectResolvingEList<GuardTransition>(GuardTransition.class, this, LtsPackage.GUARD_TRANSITION__NEGATED_GUARDS);
		}
		return negatedGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LtsPackage.GUARD_TRANSITION__SENTENCE:
				if (resolve) return getSentence();
				return basicGetSentence();
			case LtsPackage.GUARD_TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case LtsPackage.GUARD_TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case LtsPackage.GUARD_TRANSITION__NEGATED_GUARDS:
				return getNegatedGuards();
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
			case LtsPackage.GUARD_TRANSITION__SENTENCE:
				setSentence((UseCaseStep)newValue);
				return;
			case LtsPackage.GUARD_TRANSITION__SOURCE:
				setSource((State)newValue);
				return;
			case LtsPackage.GUARD_TRANSITION__TARGET:
				setTarget((State)newValue);
				return;
			case LtsPackage.GUARD_TRANSITION__NEGATED_GUARDS:
				getNegatedGuards().clear();
				getNegatedGuards().addAll((Collection<? extends GuardTransition>)newValue);
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
			case LtsPackage.GUARD_TRANSITION__SENTENCE:
				setSentence((UseCaseStep)null);
				return;
			case LtsPackage.GUARD_TRANSITION__SOURCE:
				setSource((State)null);
				return;
			case LtsPackage.GUARD_TRANSITION__TARGET:
				setTarget((State)null);
				return;
			case LtsPackage.GUARD_TRANSITION__NEGATED_GUARDS:
				getNegatedGuards().clear();
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
			case LtsPackage.GUARD_TRANSITION__SENTENCE:
				return sentence != null;
			case LtsPackage.GUARD_TRANSITION__SOURCE:
				return source != null;
			case LtsPackage.GUARD_TRANSITION__TARGET:
				return target != null;
			case LtsPackage.GUARD_TRANSITION__NEGATED_GUARDS:
				return negatedGuards != null && !negatedGuards.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GuardTransitionImpl
