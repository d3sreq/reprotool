/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.actionpart.Text;

import reprotool.model.swproj.Requirement;

import reprotool.model.usecase.Condition;
import reprotool.model.usecase.ParseableElement;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

import reprotool.model.usecase.annotate.StepAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.impl.ConditionImpl#getRelatedRequirements <em>Related Requirements</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ConditionImpl#getTextNodes <em>Text Nodes</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ConditionImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ConditionImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionImpl extends EObjectImpl implements Condition {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRelatedRequirements() {
		if (relatedRequirements == null) {
			relatedRequirements = new EObjectResolvingEList<Requirement>(Requirement.class, this, UsecasePackage.CONDITION__RELATED_REQUIREMENTS);
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
			textNodes = new EObjectContainmentEList<Text>(Text.class, this, UsecasePackage.CONDITION__TEXT_NODES);
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
			annotations = new EObjectContainmentEList<StepAnnotation>(StepAnnotation.class, this, UsecasePackage.CONDITION__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		EObject conditionParent = this.eContainer();
		if (!(conditionParent instanceof Scenario)) {
			return "";
		}
		
		Scenario scenario = (Scenario)conditionParent;
		EObject scenarioParent = scenario.eContainer();
		if (!(scenarioParent instanceof UseCaseStep)) {
			return "";
		}
		
		UseCaseStep parentUseCaseStep = (UseCaseStep)scenarioParent;
		
		int labelIndex = -1;
		int extensionIndex = parentUseCaseStep.getExtensions().indexOf(scenario);
		
		if (extensionIndex != -1) {
			labelIndex = extensionIndex;
		} else {
			int variationsIndex = parentUseCaseStep.getVariations().indexOf(scenario);
			if (variationsIndex != -1) {
				labelIndex = parentUseCaseStep.getExtensions().size() + variationsIndex;
			}
		}
		
		String toReturn = "";
		if (labelIndex != -1) {
			toReturn = parentUseCaseStep.getLabel() + String.valueOf((char)('a' + labelIndex));
		}

		return toReturn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.CONDITION__TEXT_NODES:
				return ((InternalEList<?>)getTextNodes()).basicRemove(otherEnd, msgs);
			case UsecasePackage.CONDITION__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
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
			case UsecasePackage.CONDITION__RELATED_REQUIREMENTS:
				return getRelatedRequirements();
			case UsecasePackage.CONDITION__TEXT_NODES:
				return getTextNodes();
			case UsecasePackage.CONDITION__ANNOTATIONS:
				return getAnnotations();
			case UsecasePackage.CONDITION__LABEL:
				return getLabel();
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
			case UsecasePackage.CONDITION__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				getRelatedRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case UsecasePackage.CONDITION__TEXT_NODES:
				getTextNodes().clear();
				getTextNodes().addAll((Collection<? extends Text>)newValue);
				return;
			case UsecasePackage.CONDITION__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends StepAnnotation>)newValue);
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
			case UsecasePackage.CONDITION__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				return;
			case UsecasePackage.CONDITION__TEXT_NODES:
				getTextNodes().clear();
				return;
			case UsecasePackage.CONDITION__ANNOTATIONS:
				getAnnotations().clear();
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
			case UsecasePackage.CONDITION__RELATED_REQUIREMENTS:
				return relatedRequirements != null && !relatedRequirements.isEmpty();
			case UsecasePackage.CONDITION__TEXT_NODES:
				return textNodes != null && !textNodes.isEmpty();
			case UsecasePackage.CONDITION__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UsecasePackage.CONDITION__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
		}
		return super.eIsSet(featureID);
	}

} //ConditionImpl
