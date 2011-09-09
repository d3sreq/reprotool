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
import reprotool.model.usecase.annotate.LTLAnnotation;
import reprotool.model.usecase.annotate.LTLAnnotationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LTL Annotation Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl#getContains <em>Contains</em>}</li>
 *   <li>{@link reprotool.model.usecase.annotate.impl.LTLAnnotationSetImpl#getLtl <em>Ltl</em>}</li>
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
	protected EList<LTLAnnotation> contains;

	/**
	 * The default value of the '{@link #getLtl() <em>Ltl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLtl()
	 * @generated
	 * @ordered
	 */
	protected static final String LTL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLtl() <em>Ltl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLtl()
	 * @generated
	 * @ordered
	 */
	protected String ltl = LTL_EDEFAULT;

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
	public EList<LTLAnnotation> getContains() {
		if (contains == null) {
			contains = new EObjectContainmentEList<LTLAnnotation>(LTLAnnotation.class, this, AnnotatePackage.LTL_ANNOTATION_SET__CONTAINS);
		}
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLtl() {
		return ltl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLtl(String newLtl) {
		String oldLtl = ltl;
		ltl = newLtl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotatePackage.LTL_ANNOTATION_SET__LTL, oldLtl, ltl));
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
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL:
				return getLtl();
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
				getContains().addAll((Collection<? extends LTLAnnotation>)newValue);
				return;
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL:
				setLtl((String)newValue);
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
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL:
				setLtl(LTL_EDEFAULT);
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
			case AnnotatePackage.LTL_ANNOTATION_SET__LTL:
				return LTL_EDEFAULT == null ? ltl != null : !LTL_EDEFAULT.equals(ltl);
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
		result.append(" (ltl: ");
		result.append(ltl);
		result.append(')');
		return result.toString();
	}

} //LTLAnnotationSetImpl
