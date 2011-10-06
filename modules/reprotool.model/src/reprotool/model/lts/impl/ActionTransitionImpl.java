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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import reprotool.model.lts.ActionTransition;
import reprotool.model.lts.LtsPackage;
import reprotool.model.lts.State;

import reprotool.model.usecase.ParseableElement;
import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.lts.impl.ActionTransitionImpl#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.lts.impl.ActionTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link reprotool.model.lts.impl.ActionTransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link reprotool.model.lts.impl.ActionTransitionImpl#getTokens <em>Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionTransitionImpl extends EObjectImpl implements ActionTransition {
	/**
	 * The cached value of the '{@link #getSentence() <em>Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentence()
	 * @generated
	 * @ordered
	 */
	protected ParseableElement sentence;

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
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tokens;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LtsPackage.Literals.ACTION_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParseableElement getSentence() {
		if (sentence != null && sentence.eIsProxy()) {
			InternalEObject oldSentence = (InternalEObject)sentence;
			sentence = (ParseableElement)eResolveProxy(oldSentence);
			if (sentence != oldSentence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LtsPackage.ACTION_TRANSITION__SENTENCE, oldSentence, sentence));
			}
		}
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParseableElement basicGetSentence() {
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentence(ParseableElement newSentence) {
		ParseableElement oldSentence = sentence;
		sentence = newSentence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LtsPackage.ACTION_TRANSITION__SENTENCE, oldSentence, sentence));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LtsPackage.ACTION_TRANSITION__SOURCE, oldSource, source));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LtsPackage.ACTION_TRANSITION__SOURCE, oldSource, source));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LtsPackage.ACTION_TRANSITION__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LtsPackage.ACTION_TRANSITION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTokens() {
		if (tokens == null) {
			tokens = new EDataTypeUniqueEList<String>(String.class, this, LtsPackage.ACTION_TRANSITION__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LtsPackage.ACTION_TRANSITION__SENTENCE:
				if (resolve) return getSentence();
				return basicGetSentence();
			case LtsPackage.ACTION_TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case LtsPackage.ACTION_TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case LtsPackage.ACTION_TRANSITION__TOKENS:
				return getTokens();
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
			case LtsPackage.ACTION_TRANSITION__SENTENCE:
				setSentence((ParseableElement)newValue);
				return;
			case LtsPackage.ACTION_TRANSITION__SOURCE:
				setSource((State)newValue);
				return;
			case LtsPackage.ACTION_TRANSITION__TARGET:
				setTarget((State)newValue);
				return;
			case LtsPackage.ACTION_TRANSITION__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends String>)newValue);
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
			case LtsPackage.ACTION_TRANSITION__SENTENCE:
				setSentence((ParseableElement)null);
				return;
			case LtsPackage.ACTION_TRANSITION__SOURCE:
				setSource((State)null);
				return;
			case LtsPackage.ACTION_TRANSITION__TARGET:
				setTarget((State)null);
				return;
			case LtsPackage.ACTION_TRANSITION__TOKENS:
				getTokens().clear();
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
			case LtsPackage.ACTION_TRANSITION__SENTENCE:
				return sentence != null;
			case LtsPackage.ACTION_TRANSITION__SOURCE:
				return source != null;
			case LtsPackage.ACTION_TRANSITION__TARGET:
				return target != null;
			case LtsPackage.ACTION_TRANSITION__TOKENS:
				return tokens != null && !tokens.isEmpty();
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
		result.append(" (tokens: ");
		result.append(tokens);
		result.append(')');
		return result.toString();
	}

} //ActionTransitionImpl
