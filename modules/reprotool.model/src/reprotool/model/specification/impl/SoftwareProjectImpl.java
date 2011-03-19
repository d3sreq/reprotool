/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.specification.Actor;
import reprotool.model.specification.GenericRequirement;
import reprotool.model.specification.SoftwareProject;
import reprotool.model.specification.SpecificationPackage;
import reprotool.model.specification.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.specification.impl.SoftwareProjectImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.SoftwareProjectImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.SoftwareProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.SoftwareProjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.SoftwareProjectImpl#getRequirements <em>Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareProjectImpl extends EObjectImpl implements SoftwareProject {
	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCases;

	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

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
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected GenericRequirement requirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecificationPackage.Literals.SOFTWARE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectResolvingEList<UseCase>(UseCase.class, this, SpecificationPackage.SOFTWARE_PROJECT__USE_CASES);
		}
		return useCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectResolvingEList<Actor>(Actor.class, this, SpecificationPackage.SOFTWARE_PROJECT__ACTORS);
		}
		return actors;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.SOFTWARE_PROJECT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.SOFTWARE_PROJECT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericRequirement getRequirements() {
		if (requirements != null && requirements.eIsProxy()) {
			InternalEObject oldRequirements = (InternalEObject)requirements;
			requirements = (GenericRequirement)eResolveProxy(oldRequirements);
			if (requirements != oldRequirements) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpecificationPackage.SOFTWARE_PROJECT__REQUIREMENTS, oldRequirements, requirements));
			}
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericRequirement basicGetRequirements() {
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirements(GenericRequirement newRequirements) {
		GenericRequirement oldRequirements = requirements;
		requirements = newRequirements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.SOFTWARE_PROJECT__REQUIREMENTS, oldRequirements, requirements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpecificationPackage.SOFTWARE_PROJECT__USE_CASES:
				return getUseCases();
			case SpecificationPackage.SOFTWARE_PROJECT__ACTORS:
				return getActors();
			case SpecificationPackage.SOFTWARE_PROJECT__NAME:
				return getName();
			case SpecificationPackage.SOFTWARE_PROJECT__DESCRIPTION:
				return getDescription();
			case SpecificationPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				if (resolve) return getRequirements();
				return basicGetRequirements();
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
			case SpecificationPackage.SOFTWARE_PROJECT__USE_CASES:
				getUseCases().clear();
				getUseCases().addAll((Collection<? extends UseCase>)newValue);
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__NAME:
				setName((String)newValue);
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				setRequirements((GenericRequirement)newValue);
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
			case SpecificationPackage.SOFTWARE_PROJECT__USE_CASES:
				getUseCases().clear();
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__ACTORS:
				getActors().clear();
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SpecificationPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				setRequirements((GenericRequirement)null);
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
			case SpecificationPackage.SOFTWARE_PROJECT__USE_CASES:
				return useCases != null && !useCases.isEmpty();
			case SpecificationPackage.SOFTWARE_PROJECT__ACTORS:
				return actors != null && !actors.isEmpty();
			case SpecificationPackage.SOFTWARE_PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SpecificationPackage.SOFTWARE_PROJECT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SpecificationPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				return requirements != null;
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

} //SoftwareProjectImpl
