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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import reprotool.model.specification.SpecificationPackage;
import reprotool.model.specification.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getVariations <em>Variations</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getParentStep <em>Parent Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseStepImpl extends EObjectImpl implements UseCaseStep {
	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCaseStep> extensions;
	/**
	 * The cached value of the '{@link #getVariations() <em>Variations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCaseStep> variations;
	/**
	 * The cached value of the '{@link #getParentStep() <em>Parent Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentStep()
	 * @generated
	 * @ordered
	 */
	protected UseCaseStep parentStep;
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
		return SpecificationPackage.Literals.USE_CASE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCaseStep> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<UseCaseStep>(UseCaseStep.class, this, SpecificationPackage.USE_CASE_STEP__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCaseStep> getVariations() {
		if (variations == null) {
			variations = new EObjectContainmentEList<UseCaseStep>(UseCaseStep.class, this, SpecificationPackage.USE_CASE_STEP__VARIATIONS);
		}
		return variations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep getParentStep() {
		if (parentStep != null && parentStep.eIsProxy()) {
			InternalEObject oldParentStep = (InternalEObject)parentStep;
			parentStep = (UseCaseStep)eResolveProxy(oldParentStep);
			if (parentStep != oldParentStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpecificationPackage.USE_CASE_STEP__PARENT_STEP, oldParentStep, parentStep));
			}
		}
		return parentStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep basicGetParentStep() {
		return parentStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStep(UseCaseStep newParentStep) {
		UseCaseStep oldParentStep = parentStep;
		parentStep = newParentStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.USE_CASE_STEP__PARENT_STEP, oldParentStep, parentStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		return "TODO";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				return ((InternalEList<?>)getVariations()).basicRemove(otherEnd, msgs);
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				return getExtensions();
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				return getVariations();
			case SpecificationPackage.USE_CASE_STEP__PARENT_STEP:
				if (resolve) return getParentStep();
				return basicGetParentStep();
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends UseCaseStep>)newValue);
				return;
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				getVariations().addAll((Collection<? extends UseCaseStep>)newValue);
				return;
			case SpecificationPackage.USE_CASE_STEP__PARENT_STEP:
				setParentStep((UseCaseStep)newValue);
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				return;
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				return;
			case SpecificationPackage.USE_CASE_STEP__PARENT_STEP:
				setParentStep((UseCaseStep)null);
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				return variations != null && !variations.isEmpty();
			case SpecificationPackage.USE_CASE_STEP__PARENT_STEP:
				return parentStep != null;
		}
		return super.eIsSet(featureID);
	}

} //UseCaseStepImpl
