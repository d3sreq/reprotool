/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.model.procases.AbortAction;
import reprotool.model.procases.Action;
import reprotool.model.procases.ProcasesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abort Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.procases.impl.AbortActionImpl#getNextAction <em>Next Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbortActionImpl extends EObjectImpl implements AbortAction {
	/**
	 * The cached value of the '{@link #getNextAction() <em>Next Action</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> nextAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbortActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcasesPackage.Literals.ABORT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getNextAction() {
		if (nextAction == null) {
			nextAction = new EObjectResolvingEList<Action>(Action.class, this, ProcasesPackage.ABORT_ACTION__NEXT_ACTION);
		}
		return nextAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcasesPackage.ABORT_ACTION__NEXT_ACTION:
				return getNextAction();
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
			case ProcasesPackage.ABORT_ACTION__NEXT_ACTION:
				getNextAction().clear();
				getNextAction().addAll((Collection<? extends Action>)newValue);
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
			case ProcasesPackage.ABORT_ACTION__NEXT_ACTION:
				getNextAction().clear();
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
			case ProcasesPackage.ABORT_ACTION__NEXT_ACTION:
				return nextAction != null && !nextAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbortActionImpl
