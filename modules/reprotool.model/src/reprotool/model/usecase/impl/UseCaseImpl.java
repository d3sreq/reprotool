/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.model.swproj.Actor;
import reprotool.model.swproj.Requirement;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseImpl#getRelatedRequirements <em>Related Requirements</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseImpl#getPrimaryActor <em>Primary Actor</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseImpl#getMainScenario <em>Main Scenario</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseImpl#getPrecedesUseCases <em>Precedes Use Cases</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseImpl#getEnclosingProject <em>Enclosing Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends EObjectImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getRelatedRequirements() <em>Related Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> relatedRequirements;

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
	 * The cached value of the '{@link #getMainScenario() <em>Main Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainScenario()
	 * @generated
	 * @ordered
	 */
	protected Scenario mainScenario;

	/**
	 * The cached value of the '{@link #getPrecedesUseCases() <em>Precedes Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecedesUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> precedesUseCases;

	/**
	 * The cached value of the '{@link #getEnclosingProject() <em>Enclosing Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingProject()
	 * @generated
	 * @ordered
	 */
	protected SoftwareProject enclosingProject;

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
		return UsecasePackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRelatedRequirements() {
		if (relatedRequirements == null) {
			relatedRequirements = new EObjectResolvingEList<Requirement>(Requirement.class, this, UsecasePackage.USE_CASE__RELATED_REQUIREMENTS);
		}
		return relatedRequirements;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.USE_CASE__PRIMARY_ACTOR, oldPrimaryActor, primaryActor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__PRIMARY_ACTOR, oldPrimaryActor, primaryActor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario getMainScenario() {
		return mainScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMainScenario(Scenario newMainScenario, NotificationChain msgs) {
		Scenario oldMainScenario = mainScenario;
		mainScenario = newMainScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__MAIN_SCENARIO, oldMainScenario, newMainScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainScenario(Scenario newMainScenario) {
		if (newMainScenario != mainScenario) {
			NotificationChain msgs = null;
			if (mainScenario != null)
				msgs = ((InternalEObject)mainScenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE__MAIN_SCENARIO, null, msgs);
			if (newMainScenario != null)
				msgs = ((InternalEObject)newMainScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE__MAIN_SCENARIO, null, msgs);
			msgs = basicSetMainScenario(newMainScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__MAIN_SCENARIO, newMainScenario, newMainScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getPrecedesUseCases() {
		if (precedesUseCases == null) {
			precedesUseCases = new EObjectResolvingEList<UseCase>(UseCase.class, this, UsecasePackage.USE_CASE__PRECEDES_USE_CASES);
		}
		return precedesUseCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareProject getEnclosingProject() {
		if (enclosingProject != null && enclosingProject.eIsProxy()) {
			InternalEObject oldEnclosingProject = (InternalEObject)enclosingProject;
			enclosingProject = (SoftwareProject)eResolveProxy(oldEnclosingProject);
			if (enclosingProject != oldEnclosingProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.USE_CASE__ENCLOSING_PROJECT, oldEnclosingProject, enclosingProject));
			}
		}
		return enclosingProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareProject basicGetEnclosingProject() {
		return enclosingProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnclosingProject(SoftwareProject newEnclosingProject, NotificationChain msgs) {
		SoftwareProject oldEnclosingProject = enclosingProject;
		enclosingProject = newEnclosingProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__ENCLOSING_PROJECT, oldEnclosingProject, newEnclosingProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosingProject(SoftwareProject newEnclosingProject) {
		if (newEnclosingProject != enclosingProject) {
			NotificationChain msgs = null;
			if (enclosingProject != null)
				msgs = ((InternalEObject)enclosingProject).eInverseRemove(this, SwprojPackage.SOFTWARE_PROJECT__USE_CASES, SoftwareProject.class, msgs);
			if (newEnclosingProject != null)
				msgs = ((InternalEObject)newEnclosingProject).eInverseAdd(this, SwprojPackage.SOFTWARE_PROJECT__USE_CASES, SoftwareProject.class, msgs);
			msgs = basicSetEnclosingProject(newEnclosingProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE__ENCLOSING_PROJECT, newEnclosingProject, newEnclosingProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.USE_CASE__ENCLOSING_PROJECT:
				if (enclosingProject != null)
					msgs = ((InternalEObject)enclosingProject).eInverseRemove(this, SwprojPackage.SOFTWARE_PROJECT__USE_CASES, SoftwareProject.class, msgs);
				return basicSetEnclosingProject((SoftwareProject)otherEnd, msgs);
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
			case UsecasePackage.USE_CASE__MAIN_SCENARIO:
				return basicSetMainScenario(null, msgs);
			case UsecasePackage.USE_CASE__ENCLOSING_PROJECT:
				return basicSetEnclosingProject(null, msgs);
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
			case UsecasePackage.USE_CASE__RELATED_REQUIREMENTS:
				return getRelatedRequirements();
			case UsecasePackage.USE_CASE__PRIMARY_ACTOR:
				if (resolve) return getPrimaryActor();
				return basicGetPrimaryActor();
			case UsecasePackage.USE_CASE__NAME:
				return getName();
			case UsecasePackage.USE_CASE__MAIN_SCENARIO:
				return getMainScenario();
			case UsecasePackage.USE_CASE__PRECEDES_USE_CASES:
				return getPrecedesUseCases();
			case UsecasePackage.USE_CASE__ENCLOSING_PROJECT:
				if (resolve) return getEnclosingProject();
				return basicGetEnclosingProject();
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
			case UsecasePackage.USE_CASE__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				getRelatedRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case UsecasePackage.USE_CASE__PRIMARY_ACTOR:
				setPrimaryActor((Actor)newValue);
				return;
			case UsecasePackage.USE_CASE__NAME:
				setName((String)newValue);
				return;
			case UsecasePackage.USE_CASE__MAIN_SCENARIO:
				setMainScenario((Scenario)newValue);
				return;
			case UsecasePackage.USE_CASE__PRECEDES_USE_CASES:
				getPrecedesUseCases().clear();
				getPrecedesUseCases().addAll((Collection<? extends UseCase>)newValue);
				return;
			case UsecasePackage.USE_CASE__ENCLOSING_PROJECT:
				setEnclosingProject((SoftwareProject)newValue);
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
			case UsecasePackage.USE_CASE__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				return;
			case UsecasePackage.USE_CASE__PRIMARY_ACTOR:
				setPrimaryActor((Actor)null);
				return;
			case UsecasePackage.USE_CASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE__MAIN_SCENARIO:
				setMainScenario((Scenario)null);
				return;
			case UsecasePackage.USE_CASE__PRECEDES_USE_CASES:
				getPrecedesUseCases().clear();
				return;
			case UsecasePackage.USE_CASE__ENCLOSING_PROJECT:
				setEnclosingProject((SoftwareProject)null);
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
			case UsecasePackage.USE_CASE__RELATED_REQUIREMENTS:
				return relatedRequirements != null && !relatedRequirements.isEmpty();
			case UsecasePackage.USE_CASE__PRIMARY_ACTOR:
				return primaryActor != null;
			case UsecasePackage.USE_CASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UsecasePackage.USE_CASE__MAIN_SCENARIO:
				return mainScenario != null;
			case UsecasePackage.USE_CASE__PRECEDES_USE_CASES:
				return precedesUseCases != null && !precedesUseCases.isEmpty();
			case UsecasePackage.USE_CASE__ENCLOSING_PROJECT:
				return enclosingProject != null;
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
