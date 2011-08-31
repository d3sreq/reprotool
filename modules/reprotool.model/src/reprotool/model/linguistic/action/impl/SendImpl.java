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
import reprotool.model.linguistic.action.Send;

import reprotool.model.linguistic.actionpart.IndirectObject;
import reprotool.model.linguistic.actionpart.RepresentativeObject;
import reprotool.model.linguistic.actionpart.Subject;
import reprotool.model.linguistic.actionpart.Verb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Send</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.SendImpl#getVerb <em>Verb</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.SendImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.SendImpl#getRepresentativeObject <em>Representative Object</em>}</li>
 *   <li>{@link reprotool.model.linguistic.action.impl.SendImpl#getIndirectObject <em>Indirect Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SendImpl extends ActionImpl implements Send {
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
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected Subject subject;

	/**
	 * The cached value of the '{@link #getRepresentativeObject() <em>Representative Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentativeObject()
	 * @generated
	 * @ordered
	 */
	protected RepresentativeObject representativeObject;

	/**
	 * The cached value of the '{@link #getIndirectObject() <em>Indirect Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndirectObject()
	 * @generated
	 * @ordered
	 */
	protected IndirectObject indirectObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SendImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.SEND;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__VERB, oldVerb, newVerb);
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
				msgs = ((InternalEObject)verb).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__VERB, null, msgs);
			if (newVerb != null)
				msgs = ((InternalEObject)newVerb).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__VERB, null, msgs);
			msgs = basicSetVerb(newVerb, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__VERB, newVerb, newVerb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubject(Subject newSubject, NotificationChain msgs) {
		Subject oldSubject = subject;
		subject = newSubject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__SUBJECT, oldSubject, newSubject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(Subject newSubject) {
		if (newSubject != subject) {
			NotificationChain msgs = null;
			if (subject != null)
				msgs = ((InternalEObject)subject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__SUBJECT, null, msgs);
			if (newSubject != null)
				msgs = ((InternalEObject)newSubject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__SUBJECT, null, msgs);
			msgs = basicSetSubject(newSubject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__SUBJECT, newSubject, newSubject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentativeObject getRepresentativeObject() {
		return representativeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentativeObject(RepresentativeObject newRepresentativeObject, NotificationChain msgs) {
		RepresentativeObject oldRepresentativeObject = representativeObject;
		representativeObject = newRepresentativeObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__REPRESENTATIVE_OBJECT, oldRepresentativeObject, newRepresentativeObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentativeObject(RepresentativeObject newRepresentativeObject) {
		if (newRepresentativeObject != representativeObject) {
			NotificationChain msgs = null;
			if (representativeObject != null)
				msgs = ((InternalEObject)representativeObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__REPRESENTATIVE_OBJECT, null, msgs);
			if (newRepresentativeObject != null)
				msgs = ((InternalEObject)newRepresentativeObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__REPRESENTATIVE_OBJECT, null, msgs);
			msgs = basicSetRepresentativeObject(newRepresentativeObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__REPRESENTATIVE_OBJECT, newRepresentativeObject, newRepresentativeObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndirectObject getIndirectObject() {
		return indirectObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIndirectObject(IndirectObject newIndirectObject, NotificationChain msgs) {
		IndirectObject oldIndirectObject = indirectObject;
		indirectObject = newIndirectObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__INDIRECT_OBJECT, oldIndirectObject, newIndirectObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndirectObject(IndirectObject newIndirectObject) {
		if (newIndirectObject != indirectObject) {
			NotificationChain msgs = null;
			if (indirectObject != null)
				msgs = ((InternalEObject)indirectObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__INDIRECT_OBJECT, null, msgs);
			if (newIndirectObject != null)
				msgs = ((InternalEObject)newIndirectObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionPackage.SEND__INDIRECT_OBJECT, null, msgs);
			msgs = basicSetIndirectObject(newIndirectObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionPackage.SEND__INDIRECT_OBJECT, newIndirectObject, newIndirectObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionPackage.SEND__VERB:
				return basicSetVerb(null, msgs);
			case ActionPackage.SEND__SUBJECT:
				return basicSetSubject(null, msgs);
			case ActionPackage.SEND__REPRESENTATIVE_OBJECT:
				return basicSetRepresentativeObject(null, msgs);
			case ActionPackage.SEND__INDIRECT_OBJECT:
				return basicSetIndirectObject(null, msgs);
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
			case ActionPackage.SEND__VERB:
				return getVerb();
			case ActionPackage.SEND__SUBJECT:
				return getSubject();
			case ActionPackage.SEND__REPRESENTATIVE_OBJECT:
				return getRepresentativeObject();
			case ActionPackage.SEND__INDIRECT_OBJECT:
				return getIndirectObject();
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
			case ActionPackage.SEND__VERB:
				setVerb((Verb)newValue);
				return;
			case ActionPackage.SEND__SUBJECT:
				setSubject((Subject)newValue);
				return;
			case ActionPackage.SEND__REPRESENTATIVE_OBJECT:
				setRepresentativeObject((RepresentativeObject)newValue);
				return;
			case ActionPackage.SEND__INDIRECT_OBJECT:
				setIndirectObject((IndirectObject)newValue);
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
			case ActionPackage.SEND__VERB:
				setVerb((Verb)null);
				return;
			case ActionPackage.SEND__SUBJECT:
				setSubject((Subject)null);
				return;
			case ActionPackage.SEND__REPRESENTATIVE_OBJECT:
				setRepresentativeObject((RepresentativeObject)null);
				return;
			case ActionPackage.SEND__INDIRECT_OBJECT:
				setIndirectObject((IndirectObject)null);
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
			case ActionPackage.SEND__VERB:
				return verb != null;
			case ActionPackage.SEND__SUBJECT:
				return subject != null;
			case ActionPackage.SEND__REPRESENTATIVE_OBJECT:
				return representativeObject != null;
			case ActionPackage.SEND__INDIRECT_OBJECT:
				return indirectObject != null;
		}
		return super.eIsSet(featureID);
	}

} //SendImpl
