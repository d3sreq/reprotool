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
import reprotool.model.usecase.annotate.CTLAnnotationSet;
import reprotool.model.usecase.annotate.TemporalAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CTL Annotation Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.annotate.impl.CTLAnnotationSetImpl#getCtlFormula <em>Ctl Formula</em>}</li>
 *   <li>{@link reprotool.model.usecase.annotate.impl.CTLAnnotationSetImpl#getContains <em>Contains</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CTLAnnotationSetImpl extends EObjectImpl implements CTLAnnotationSet {
	/**
	 * The default value of the '{@link #getCtlFormula() <em>Ctl Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCtlFormula()
	 * @generated
	 * @ordered
	 */
	protected static final String CTL_FORMULA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCtlFormula() <em>Ctl Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCtlFormula()
	 * @generated
	 * @ordered
	 */
	protected String ctlFormula = CTL_FORMULA_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CTLAnnotationSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotatePackage.Literals.CTL_ANNOTATION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCtlFormula() {
		return ctlFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCtlFormula(String newCtlFormula) {
		String oldCtlFormula = ctlFormula;
		ctlFormula = newCtlFormula;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotatePackage.CTL_ANNOTATION_SET__CTL_FORMULA, oldCtlFormula, ctlFormula));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemporalAnnotation> getContains() {
		if (contains == null) {
			contains = new EObjectContainmentEList<TemporalAnnotation>(TemporalAnnotation.class, this, AnnotatePackage.CTL_ANNOTATION_SET__CONTAINS);
		}
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnnotatePackage.CTL_ANNOTATION_SET__CONTAINS:
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
			case AnnotatePackage.CTL_ANNOTATION_SET__CTL_FORMULA:
				return getCtlFormula();
			case AnnotatePackage.CTL_ANNOTATION_SET__CONTAINS:
				return getContains();
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
			case AnnotatePackage.CTL_ANNOTATION_SET__CTL_FORMULA:
				setCtlFormula((String)newValue);
				return;
			case AnnotatePackage.CTL_ANNOTATION_SET__CONTAINS:
				getContains().clear();
				getContains().addAll((Collection<? extends TemporalAnnotation>)newValue);
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
			case AnnotatePackage.CTL_ANNOTATION_SET__CTL_FORMULA:
				setCtlFormula(CTL_FORMULA_EDEFAULT);
				return;
			case AnnotatePackage.CTL_ANNOTATION_SET__CONTAINS:
				getContains().clear();
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
			case AnnotatePackage.CTL_ANNOTATION_SET__CTL_FORMULA:
				return CTL_FORMULA_EDEFAULT == null ? ctlFormula != null : !CTL_FORMULA_EDEFAULT.equals(ctlFormula);
			case AnnotatePackage.CTL_ANNOTATION_SET__CONTAINS:
				return contains != null && !contains.isEmpty();
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
		result.append(" (ctlFormula: ");
		result.append(ctlFormula);
		result.append(')');
		return result.toString();
	}

} //CTLAnnotationSetImpl
