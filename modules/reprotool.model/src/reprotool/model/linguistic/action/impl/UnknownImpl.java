/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.Unknown;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unknown</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.UnknownImpl#getSummary <em>Summary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnknownImpl extends EObjectImpl implements Unknown {
	/**
	 * The default value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected static final String SUMMARY_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnknownImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.UNKNOWN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSummary() {
		return "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionPackage.UNKNOWN__SUMMARY:
				return getSummary();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActionPackage.UNKNOWN__SUMMARY:
				return SUMMARY_EDEFAULT == null ? getSummary() != null : !SUMMARY_EDEFAULT.equals(getSummary());
		}
		return super.eIsSet(featureID);
	}

} //UnknownImpl
