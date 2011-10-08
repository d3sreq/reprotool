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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.action.Action;

import reprotool.model.linguistic.actionpart.Text;

import reprotool.model.swproj.Requirement;
import reprotool.model.swproj.SoftwareProject;

import reprotool.model.usecase.ParseableElement;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

import reprotool.model.usecase.annotate.StepAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getRelatedRequirements <em>Related Requirements</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getTextNodes <em>Text Nodes</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getVariations <em>Variations</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getAction <em>Action</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getSoftwareProject <em>Software Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseStepImpl extends EObjectImpl implements UseCaseStep {
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
	 * The cached value of the '{@link #getTextNodes() <em>Text Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Text> textNodes;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<StepAnnotation> annotations;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> extensions;

	/**
	 * The cached value of the '{@link #getVariations() <em>Variations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> variations;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.USE_CASE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRelatedRequirements() {
		if (relatedRequirements == null) {
			relatedRequirements = new EObjectResolvingEList<Requirement>(Requirement.class, this, UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS);
		}
		return relatedRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Text> getTextNodes() {
		if (textNodes == null) {
			textNodes = new EObjectContainmentEList<Text>(Text.class, this, UsecasePackage.USE_CASE_STEP__TEXT_NODES);
		}
		return textNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StepAnnotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<StepAnnotation>(StepAnnotation.class, this, UsecasePackage.USE_CASE_STEP__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		EObject useCaseParent = this.eContainer();
		if (!(useCaseParent instanceof Scenario)) {
			return "";
		}
		
		Scenario scenario = (Scenario)useCaseParent;
		String toReturn = Integer.toString(scenario.getSteps().indexOf(this) + 1);
		
		EObject scenarioParent = scenario.eContainer();
		if (scenarioParent instanceof ParseableElement) {
			ParseableElement parseableElement = (ParseableElement)scenarioParent;
			toReturn = parseableElement.getLabel() + "." + toReturn;
		}
		
		return toReturn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Scenario>(Scenario.class, this, UsecasePackage.USE_CASE_STEP__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getVariations() {
		if (variations == null) {
			variations = new EObjectContainmentEList<Scenario>(Scenario.class, this, UsecasePackage.USE_CASE_STEP__VARIATIONS);
		}
		return variations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAction(Action newAction, NotificationChain msgs) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__ACTION, oldAction, newAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		if (newAction != action) {
			NotificationChain msgs = null;
			if (action != null)
				msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE_STEP__ACTION, null, msgs);
			if (newAction != null)
				msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE_STEP__ACTION, null, msgs);
			msgs = basicSetAction(newAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__ACTION, newAction, newAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareProject getSoftwareProject() {
		SoftwareProject softwareProject = basicGetSoftwareProject();
		return softwareProject != null && softwareProject.eIsProxy() ? (SoftwareProject)eResolveProxy((InternalEObject)softwareProject) : softwareProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SoftwareProject basicGetSoftwareProject() {
		UseCaseStep useCaseStep = this;
		while (true) {
			Scenario scenario = (Scenario)useCaseStep.eContainer();
			if (scenario == null) {
				return null;
			}
			
			EObject container = scenario.eContainer();
			if (container == null) {
				return null;
			}
			
			if (container instanceof UseCase) {
				break;
			} else { // container instanceof UseCaseStep
				useCaseStep = (UseCaseStep)container;
			}
		}
		
		Scenario scenario = (Scenario)useCaseStep.eContainer();
		UseCase useCase = (UseCase)scenario.eContainer();
		if (useCase == null) {
			return null;
		}
		
		SoftwareProject softwareProject = (SoftwareProject)useCase.eContainer();
		return softwareProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.USE_CASE_STEP__TEXT_NODES:
				return ((InternalEList<?>)getTextNodes()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				return ((InternalEList<?>)getVariations()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__ACTION:
				return basicSetAction(null, msgs);
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
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				return getRelatedRequirements();
			case UsecasePackage.USE_CASE_STEP__TEXT_NODES:
				return getTextNodes();
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				return getAnnotations();
			case UsecasePackage.USE_CASE_STEP__LABEL:
				return getLabel();
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				return getExtensions();
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				return getVariations();
			case UsecasePackage.USE_CASE_STEP__ACTION:
				return getAction();
			case UsecasePackage.USE_CASE_STEP__SOFTWARE_PROJECT:
				if (resolve) return getSoftwareProject();
				return basicGetSoftwareProject();
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
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				getRelatedRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__TEXT_NODES:
				getTextNodes().clear();
				getTextNodes().addAll((Collection<? extends Text>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends StepAnnotation>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Scenario>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				getVariations().addAll((Collection<? extends Scenario>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__ACTION:
				setAction((Action)newValue);
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
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__TEXT_NODES:
				getTextNodes().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__ACTION:
				setAction((Action)null);
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
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				return relatedRequirements != null && !relatedRequirements.isEmpty();
			case UsecasePackage.USE_CASE_STEP__TEXT_NODES:
				return textNodes != null && !textNodes.isEmpty();
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UsecasePackage.USE_CASE_STEP__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				return variations != null && !variations.isEmpty();
			case UsecasePackage.USE_CASE_STEP__ACTION:
				return action != null;
			case UsecasePackage.USE_CASE_STEP__SOFTWARE_PROJECT:
				return basicGetSoftwareProject() != null;
		}
		return super.eIsSet(featureID);
	}

} //UseCaseStepImpl
