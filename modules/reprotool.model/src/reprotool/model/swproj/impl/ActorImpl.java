/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.swproj.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SwprojPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.swproj.impl.ActorImpl#getChildrenActors <em>Children Actors</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.ActorImpl#getParentActor <em>Parent Actor</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.ActorImpl#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.ActorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorImpl extends EObjectImpl implements Actor {
	/**
	 * The cached value of the '{@link #getChildrenActors() <em>Children Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> childrenActors;

	/**
	 * The cached value of the '{@link #getParentActor() <em>Parent Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentActor()
	 * @generated
	 * @ordered
	 */
	protected Actor parentActor;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SwprojPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getChildrenActors() {
		if (childrenActors == null) {
			childrenActors = new EObjectWithInverseResolvingEList<Actor>(Actor.class, this, SwprojPackage.ACTOR__CHILDREN_ACTORS, SwprojPackage.ACTOR__PARENT_ACTOR);
		}
		return childrenActors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getParentActor() {
		if (parentActor != null && parentActor.eIsProxy()) {
			InternalEObject oldParentActor = (InternalEObject)parentActor;
			parentActor = (Actor)eResolveProxy(oldParentActor);
			if (parentActor != oldParentActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SwprojPackage.ACTOR__PARENT_ACTOR, oldParentActor, parentActor));
			}
		}
		return parentActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetParentActor() {
		return parentActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentActor(Actor newParentActor, NotificationChain msgs) {
		Actor oldParentActor = parentActor;
		parentActor = newParentActor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SwprojPackage.ACTOR__PARENT_ACTOR, oldParentActor, newParentActor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentActor(Actor newParentActor) {
		if (newParentActor != parentActor) {
			NotificationChain msgs = null;
			if (parentActor != null)
				msgs = ((InternalEObject)parentActor).eInverseRemove(this, SwprojPackage.ACTOR__CHILDREN_ACTORS, Actor.class, msgs);
			if (newParentActor != null)
				msgs = ((InternalEObject)newParentActor).eInverseAdd(this, SwprojPackage.ACTOR__CHILDREN_ACTORS, Actor.class, msgs);
			msgs = basicSetParentActor(newParentActor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwprojPackage.ACTOR__PARENT_ACTOR, newParentActor, newParentActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwprojPackage.ACTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwprojPackage.ACTOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SwprojPackage.ACTOR__CHILDREN_ACTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildrenActors()).basicAdd(otherEnd, msgs);
			case SwprojPackage.ACTOR__PARENT_ACTOR:
				if (parentActor != null)
					msgs = ((InternalEObject)parentActor).eInverseRemove(this, SwprojPackage.ACTOR__CHILDREN_ACTORS, Actor.class, msgs);
				return basicSetParentActor((Actor)otherEnd, msgs);
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
			case SwprojPackage.ACTOR__CHILDREN_ACTORS:
				return ((InternalEList<?>)getChildrenActors()).basicRemove(otherEnd, msgs);
			case SwprojPackage.ACTOR__PARENT_ACTOR:
				return basicSetParentActor(null, msgs);
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
			case SwprojPackage.ACTOR__CHILDREN_ACTORS:
				return getChildrenActors();
			case SwprojPackage.ACTOR__PARENT_ACTOR:
				if (resolve) return getParentActor();
				return basicGetParentActor();
			case SwprojPackage.ACTOR__NAME:
				return getName();
			case SwprojPackage.ACTOR__DESCRIPTION:
				return getDescription();
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
			case SwprojPackage.ACTOR__CHILDREN_ACTORS:
				getChildrenActors().clear();
				getChildrenActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case SwprojPackage.ACTOR__PARENT_ACTOR:
				setParentActor((Actor)newValue);
				return;
			case SwprojPackage.ACTOR__NAME:
				setName((String)newValue);
				return;
			case SwprojPackage.ACTOR__DESCRIPTION:
				setDescription((String)newValue);
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
			case SwprojPackage.ACTOR__CHILDREN_ACTORS:
				getChildrenActors().clear();
				return;
			case SwprojPackage.ACTOR__PARENT_ACTOR:
				setParentActor((Actor)null);
				return;
			case SwprojPackage.ACTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SwprojPackage.ACTOR__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case SwprojPackage.ACTOR__CHILDREN_ACTORS:
				return childrenActors != null && !childrenActors.isEmpty();
			case SwprojPackage.ACTOR__PARENT_ACTOR:
				return parentActor != null;
			case SwprojPackage.ACTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SwprojPackage.ACTOR__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", Description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ActorImpl
