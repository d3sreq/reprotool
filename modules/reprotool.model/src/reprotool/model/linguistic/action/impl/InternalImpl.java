/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.Internal;

import reprotool.model.linguistic.actionpart.RepresentativeObject;
import reprotool.model.linguistic.actionpart.Verb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.InternalImpl#getVerb <em>Verb</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.InternalImpl#getRepresentativeObjects <em>Representative Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalImpl extends ActionImpl implements Internal {
	/**
	 * The cached value of the '{@link #getVerb() <em>Verb</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerb()
	 * @generated
	 * @ordered
	 */
	protected Verb verb;

	/**
	 * The cached value of the '{@link #getRepresentativeObjects() <em>Representative Objects</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentativeObjects()
	 * @generated
	 * @ordered
	 */
	protected RepresentativeObject representativeObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.INTERNAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verb getVerb() {
		return verb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVerb(Verb newVerb, NotificationChain msgs) {
		Verb oldVerb = verb;
		verb = newVerb;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.INTERNAL__VERB, oldVerb, newVerb);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerb(Verb newVerb) {
		if (newVerb != verb) {
			NotificationChain msgs = null;
			if (verb != null)
				msgs = ((InternalEObject)verb).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.INTERNAL__VERB, null, msgs);
			if (newVerb != null)
				msgs = ((InternalEObject)newVerb).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.INTERNAL__VERB, null, msgs);
			msgs = basicSetVerb(newVerb, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.INTERNAL__VERB, newVerb, newVerb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentativeObject getRepresentativeObjects() {
		return representativeObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentativeObjects(RepresentativeObject newRepresentativeObjects, NotificationChain msgs) {
		RepresentativeObject oldRepresentativeObjects = representativeObjects;
		representativeObjects = newRepresentativeObjects;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS, oldRepresentativeObjects, newRepresentativeObjects);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentativeObjects(RepresentativeObject newRepresentativeObjects) {
		if (newRepresentativeObjects != representativeObjects) {
			NotificationChain msgs = null;
			if (representativeObjects != null)
				msgs = ((InternalEObject)representativeObjects).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS, null, msgs);
			if (newRepresentativeObjects != null)
				msgs = ((InternalEObject)newRepresentativeObjects).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS, null, msgs);
			msgs = basicSetRepresentativeObjects(newRepresentativeObjects, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS, newRepresentativeObjects, newRepresentativeObjects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionPackage.INTERNAL__VERB:
				return basicSetVerb(null, msgs);
			case ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS:
				return basicSetRepresentativeObjects(null, msgs);
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
			case ActionPackage.INTERNAL__VERB:
				return getVerb();
			case ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS:
				return getRepresentativeObjects();
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
			case ActionPackage.INTERNAL__VERB:
				setVerb((Verb)newValue);
				return;
			case ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS:
				setRepresentativeObjects((RepresentativeObject)newValue);
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
			case ActionPackage.INTERNAL__VERB:
				setVerb((Verb)null);
				return;
			case ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS:
				setRepresentativeObjects((RepresentativeObject)null);
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
			case ActionPackage.INTERNAL__VERB:
				return verb != null;
			case ActionPackage.INTERNAL__REPRESENTATIVE_OBJECTS:
				return representativeObjects != null;
		}
		return super.eIsSet(featureID);
	}

} //InternalImpl
