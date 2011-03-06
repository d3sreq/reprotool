/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cz.cuni.mff.reprotool.model.project.impl;

import cz.cuni.mff.reprotool.model.project.Actor;
import cz.cuni.mff.reprotool.model.project.ProjectPackage;
import cz.cuni.mff.reprotool.model.project.UseCase;
import cz.cuni.mff.reprotool.model.project.UseCaseStep;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.cuni.mff.reprotool.model.project.impl.UseCaseImpl#getPrimaryActor <em>Primary Actor</em>}</li>
 *   <li>{@link cz.cuni.mff.reprotool.model.project.impl.UseCaseImpl#getUseCaseSteps <em>Use Case Steps</em>}</li>
 *   <li>{@link cz.cuni.mff.reprotool.model.project.impl.UseCaseImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends EObjectImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getPrimaryActor() <em>Primary Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryActor()
	 * @generated
	 * @ordered
	 */
	protected Actor primaryActor;

	/**
	 * The cached value of the '{@link #getUseCaseSteps() <em>Use Case Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCaseSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCaseStep> useCaseSteps;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProjectPackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getPrimaryActor() {
		if (primaryActor != null && primaryActor.eIsProxy()) {
			InternalEObject oldPrimaryActor = (InternalEObject)primaryActor;
			primaryActor = (Actor)eResolveProxy(oldPrimaryActor);
			if (primaryActor != oldPrimaryActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.USE_CASE__PRIMARY_ACTOR, oldPrimaryActor, primaryActor));
			}
		}
		return primaryActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetPrimaryActor() {
		return primaryActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryActor(Actor newPrimaryActor) {
		Actor oldPrimaryActor = primaryActor;
		primaryActor = newPrimaryActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.USE_CASE__PRIMARY_ACTOR, oldPrimaryActor, primaryActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCaseStep> getUseCaseSteps() {
		if (useCaseSteps == null) {
			useCaseSteps = new EObjectContainmentEList<UseCaseStep>(UseCaseStep.class, this, ProjectPackage.USE_CASE__USE_CASE_STEPS);
		}
		return useCaseSteps;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.USE_CASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProjectPackage.USE_CASE__USE_CASE_STEPS:
				return ((InternalEList<?>)getUseCaseSteps()).basicRemove(otherEnd, msgs);
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
			case ProjectPackage.USE_CASE__PRIMARY_ACTOR:
				if (resolve) return getPrimaryActor();
				return basicGetPrimaryActor();
			case ProjectPackage.USE_CASE__USE_CASE_STEPS:
				return getUseCaseSteps();
			case ProjectPackage.USE_CASE__NAME:
				return getName();
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
			case ProjectPackage.USE_CASE__PRIMARY_ACTOR:
				setPrimaryActor((Actor)newValue);
				return;
			case ProjectPackage.USE_CASE__USE_CASE_STEPS:
				getUseCaseSteps().clear();
				getUseCaseSteps().addAll((Collection<? extends UseCaseStep>)newValue);
				return;
			case ProjectPackage.USE_CASE__NAME:
				setName((String)newValue);
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
			case ProjectPackage.USE_CASE__PRIMARY_ACTOR:
				setPrimaryActor((Actor)null);
				return;
			case ProjectPackage.USE_CASE__USE_CASE_STEPS:
				getUseCaseSteps().clear();
				return;
			case ProjectPackage.USE_CASE__NAME:
				setName(NAME_EDEFAULT);
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
			case ProjectPackage.USE_CASE__PRIMARY_ACTOR:
				return primaryActor != null;
			case ProjectPackage.USE_CASE__USE_CASE_STEPS:
				return useCaseSteps != null && !useCaseSteps.isEmpty();
			case ProjectPackage.USE_CASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(')');
		return result.toString();
	}

} //UseCaseImpl
