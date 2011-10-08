/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.annotate.impl;

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

import reprotool.model.usecase.annotate.AnnotatePackage;
import reprotool.model.usecase.annotate.LTLAnnotationSet;
import reprotool.model.usecase.annotate.TemporalAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LTL Annotation Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl#getContains <em>Contains</em>}</li>
 *   <li>{@link reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl#getLtlFormula <em>Ltl Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LTLAnnotationSetImpl extends EObjectImpl implements LTLAnnotationSet {
	/**
	 * The cached value of the '{@link #getContains() <em>Contains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContains()
	 * @generated
	 * @ordered
	 */
	protected EList<TemporalAnnotation> contains;

	/**
	 * The default value of the '{@link #getLtlFormula() <em>Ltl Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLtlFormula()
	 * @generated
	 * @ordered
	 */
	protected static final String LTL_FORMULA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLtlFormula() <em>Ltl Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLtlFormula()
	 * @generated
	 * @ordered
	 */
	protected String ltlFormula = LTL_FORMULA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LTLAnnotationSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotatePackage.Literals.LTL_ANNOTATION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemporalAnnotation> getContains() {
		if (contains == null) {
			contains = new EObjectContainmentEList<TemporalAnnotation>(TemporalAnnotation.class, this, AnnotatePackage.LTL_ANNOTATION_SET__CONTAINS);
		}
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLtlFormula() {
		return ltlFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLtlFormula(String newLtlFormula) {
		String oldLtlFormula = ltlFormula;
		ltlFormula = newLtlFormula;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotatePackage.LTL_ANNOTATION_SET__LTL_FORMULA, oldLtlFormula, ltlFormula));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnnotatePackage.LTL_ANNOTATION_SET__CONTAINS:
				return ((InternalEList<?>)getContains()).basicRemove(otherEnd, msgs);
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
			case AnnotatePackage.LTL_ANNOTATION_SET__CONTAINS:
				return getContains();
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL_FORMULA:
				return getLtlFormula();
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
			case AnnotatePackage.LTL_ANNOTATION_SET__CONTAINS:
				getContains().clear();
				getContains().addAll((Collection<? extends TemporalAnnotation>)newValue);
				return;
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL_FORMULA:
				setLtlFormula((String)newValue);
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
			case AnnotatePackage.LTL_ANNOTATION_SET__CONTAINS:
				getContains().clear();
				return;
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL_FORMULA:
				setLtlFormula(LTL_FORMULA_EDEFAULT);
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
			case AnnotatePackage.LTL_ANNOTATION_SET__CONTAINS:
				return contains != null && !contains.isEmpty();
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL_FORMULA:
				return LTL_FORMULA_EDEFAULT == null ? ltlFormula != null : !LTL_FORMULA_EDEFAULT.equals(ltlFormula);
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
		result.append(" (ltlFormula: ");
		result.append(ltlFormula);
		result.append(')');
		return result.toString();
	}

} //LTLAnnotationSetImpl
