/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.model.linguistic.ILinguisticPackage;
import reprotool.model.linguistic.ISentenceFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sentence Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.impl.SentenceFragment#getChildFragments <em>Child Fragments</em>}</li>
 *   <li>{@link reprotool.model.linguistic.impl.SentenceFragment#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SentenceFragment extends EObjectImpl implements ISentenceFragment {
	/**
	 * The cached value of the '{@link #getChildFragments() <em>Child Fragments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<ISentenceFragment> childFragments;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SentenceFragment() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ILinguisticPackage.Literals.SENTENCE_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ISentenceFragment> getChildFragments() {
		if (childFragments == null) {
			childFragments = new EObjectResolvingEList<ISentenceFragment>(ISentenceFragment.class, this, ILinguisticPackage.SENTENCE_FRAGMENT__CHILD_FRAGMENTS);
		}
		return childFragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ILinguisticPackage.SENTENCE_FRAGMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ILinguisticPackage.SENTENCE_FRAGMENT__CHILD_FRAGMENTS:
				return getChildFragments();
			case ILinguisticPackage.SENTENCE_FRAGMENT__TYPE:
				return getType();
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
			case ILinguisticPackage.SENTENCE_FRAGMENT__CHILD_FRAGMENTS:
				getChildFragments().clear();
				getChildFragments().addAll((Collection<? extends ISentenceFragment>)newValue);
				return;
			case ILinguisticPackage.SENTENCE_FRAGMENT__TYPE:
				setType((String)newValue);
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
			case ILinguisticPackage.SENTENCE_FRAGMENT__CHILD_FRAGMENTS:
				getChildFragments().clear();
				return;
			case ILinguisticPackage.SENTENCE_FRAGMENT__TYPE:
				setType(TYPE_EDEFAULT);
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
			case ILinguisticPackage.SENTENCE_FRAGMENT__CHILD_FRAGMENTS:
				return childFragments != null && !childFragments.isEmpty();
			case ILinguisticPackage.SENTENCE_FRAGMENT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //SentenceFragment
