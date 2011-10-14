/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.ActionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abort Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.action.impl.AbortUseCaseImpl#getSummary <em>Summary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbortUseCaseImpl extends EObjectImpl implements AbortUseCase {
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
	protected AbortUseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionPackage.Literals.ABORT_USE_CASE;
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
			case ActionPackage.ABORT_USE_CASE__SUMMARY:
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
			case ActionPackage.ABORT_USE_CASE__SUMMARY:
				return SUMMARY_EDEFAULT == null ? getSummary() != null : !SUMMARY_EDEFAULT.equals(getSummary());
		}
		return super.eIsSet(featureID);
	}

} //AbortUseCaseImpl
