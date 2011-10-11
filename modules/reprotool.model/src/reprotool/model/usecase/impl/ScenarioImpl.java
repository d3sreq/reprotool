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
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.usecase.Condition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.impl.ScenarioImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ScenarioImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ScenarioImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ScenarioImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ScenarioImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.ScenarioImpl#getScenarioGuard <em>Scenario Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScenarioImpl extends EObjectImpl implements Scenario {
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
	 * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCaseStep> steps;

	/**
	 * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition> preconditions;

	/**
	 * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition> postconditions;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScenarioGuard() <em>Scenario Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarioGuard()
	 * @generated
	 * @ordered
	 */
	protected Condition scenarioGuard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		EObject scenarioParent = this.eContainer();
		if (!(scenarioParent instanceof UseCaseStep)) {
			return "";
		}
		
		UseCaseStep parentUseCaseStep = (UseCaseStep)scenarioParent;
		
		int labelIndex = -1;

		// find scenario among extensions 
		int extensionIndex = parentUseCaseStep.getExtensions().indexOf(this);
		if (extensionIndex != -1) {
			labelIndex = extensionIndex;
		} else {
			// find scenario among variations
			int variationsIndex = parentUseCaseStep.getVariations().indexOf(this);
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
	public EList<UseCaseStep> getSteps() {
		if (steps == null) {
			steps = new EObjectContainmentEList<UseCaseStep>(UseCaseStep.class, this, UsecasePackage.SCENARIO__STEPS);
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition> getPreconditions() {
		if (preconditions == null) {
			preconditions = new EObjectContainmentEList<Condition>(Condition.class, this, UsecasePackage.SCENARIO__PRECONDITIONS);
		}
		return preconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition> getPostconditions() {
		if (postconditions == null) {
			postconditions = new EObjectContainmentEList<Condition>(Condition.class, this, UsecasePackage.SCENARIO__POSTCONDITIONS);
		}
		return postconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.SCENARIO__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getScenarioGuard() {
		return scenarioGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenarioGuard(Condition newScenarioGuard, NotificationChain msgs) {
		Condition oldScenarioGuard = scenarioGuard;
		scenarioGuard = newScenarioGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsecasePackage.SCENARIO__SCENARIO_GUARD, oldScenarioGuard, newScenarioGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenarioGuard(Condition newScenarioGuard) {
		if (newScenarioGuard != scenarioGuard) {
			NotificationChain msgs = null;
			if (scenarioGuard != null)
				msgs = ((InternalEObject)scenarioGuard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.SCENARIO__SCENARIO_GUARD, null, msgs);
			if (newScenarioGuard != null)
				msgs = ((InternalEObject)newScenarioGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.SCENARIO__SCENARIO_GUARD, null, msgs);
			msgs = basicSetScenarioGuard(newScenarioGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.SCENARIO__SCENARIO_GUARD, newScenarioGuard, newScenarioGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.SCENARIO__STEPS:
				return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
			case UsecasePackage.SCENARIO__PRECONDITIONS:
				return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
			case UsecasePackage.SCENARIO__POSTCONDITIONS:
				return ((InternalEList<?>)getPostconditions()).basicRemove(otherEnd, msgs);
			case UsecasePackage.SCENARIO__SCENARIO_GUARD:
				return basicSetScenarioGuard(null, msgs);
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
			case UsecasePackage.SCENARIO__LABEL:
				return getLabel();
			case UsecasePackage.SCENARIO__STEPS:
				return getSteps();
			case UsecasePackage.SCENARIO__PRECONDITIONS:
				return getPreconditions();
			case UsecasePackage.SCENARIO__POSTCONDITIONS:
				return getPostconditions();
			case UsecasePackage.SCENARIO__COMMENT:
				return getComment();
			case UsecasePackage.SCENARIO__SCENARIO_GUARD:
				return getScenarioGuard();
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
			case UsecasePackage.SCENARIO__STEPS:
				getSteps().clear();
				getSteps().addAll((Collection<? extends UseCaseStep>)newValue);
				return;
			case UsecasePackage.SCENARIO__PRECONDITIONS:
				getPreconditions().clear();
				getPreconditions().addAll((Collection<? extends Condition>)newValue);
				return;
			case UsecasePackage.SCENARIO__POSTCONDITIONS:
				getPostconditions().clear();
				getPostconditions().addAll((Collection<? extends Condition>)newValue);
				return;
			case UsecasePackage.SCENARIO__COMMENT:
				setComment((String)newValue);
				return;
			case UsecasePackage.SCENARIO__SCENARIO_GUARD:
				setScenarioGuard((Condition)newValue);
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
			case UsecasePackage.SCENARIO__STEPS:
				getSteps().clear();
				return;
			case UsecasePackage.SCENARIO__PRECONDITIONS:
				getPreconditions().clear();
				return;
			case UsecasePackage.SCENARIO__POSTCONDITIONS:
				getPostconditions().clear();
				return;
			case UsecasePackage.SCENARIO__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case UsecasePackage.SCENARIO__SCENARIO_GUARD:
				setScenarioGuard((Condition)null);
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
			case UsecasePackage.SCENARIO__LABEL:
				return LABEL_EDEFAULT == null ? getLabel() != null : !LABEL_EDEFAULT.equals(getLabel());
			case UsecasePackage.SCENARIO__STEPS:
				return steps != null && !steps.isEmpty();
			case UsecasePackage.SCENARIO__PRECONDITIONS:
				return preconditions != null && !preconditions.isEmpty();
			case UsecasePackage.SCENARIO__POSTCONDITIONS:
				return postconditions != null && !postconditions.isEmpty();
			case UsecasePackage.SCENARIO__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case UsecasePackage.SCENARIO__SCENARIO_GUARD:
				return scenarioGuard != null;
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //ScenarioImpl
