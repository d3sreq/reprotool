/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.specification.GenericRequirement;
import reprotool.model.specification.SpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.specification.impl.GenericRequirementImpl#getOriginalText <em>Original Text</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.GenericRequirementImpl#getOriginalId <em>Original Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericRequirementImpl extends EObjectImpl implements GenericRequirement {
	/**
	 * The default value of the '{@link #getOriginalText() <em>Original Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalText()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalText() <em>Original Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalText()
	 * @generated
	 * @ordered
	 */
	protected String originalText = ORIGINAL_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOriginalId() <em>Original Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalId()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalId() <em>Original Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalId()
	 * @generated
	 * @ordered
	 */
	protected String originalId = ORIGINAL_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecificationPackage.Literals.GENERIC_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginalText() {
		return originalText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalText(String newOriginalText) {
		String oldOriginalText = originalText;
		originalText = newOriginalText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_TEXT, oldOriginalText, originalText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginalId() {
		return originalId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalId(String newOriginalId) {
		String oldOriginalId = originalId;
		originalId = newOriginalId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_ID, oldOriginalId, originalId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_TEXT:
				return getOriginalText();
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_ID:
				return getOriginalId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_TEXT:
				setOriginalText((String)newValue);
				return;
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_ID:
				setOriginalId((String)newValue);
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
		switch (featureID)
		{
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_TEXT:
				setOriginalText(ORIGINAL_TEXT_EDEFAULT);
				return;
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_ID:
				setOriginalId(ORIGINAL_ID_EDEFAULT);
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
		switch (featureID)
		{
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_TEXT:
				return ORIGINAL_TEXT_EDEFAULT == null ? originalText != null : !ORIGINAL_TEXT_EDEFAULT.equals(originalText);
			case SpecificationPackage.GENERIC_REQUIREMENT__ORIGINAL_ID:
				return ORIGINAL_ID_EDEFAULT == null ? originalId != null : !ORIGINAL_ID_EDEFAULT.equals(originalId);
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
		result.append(" (originalText: ");
		result.append(originalText);
		result.append(", originalId: ");
		result.append(originalId);
		result.append(')');
		return result.toString();
	}

} //GenericRequirementImpl
