/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.traceability.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.model.traceability.ITraceLink;
import reprotool.model.traceability.ITraceabilityPackage;
import reprotool.model.traceability.ITraceableEntity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.traceability.impl.TraceLink#getSource <em>Source</em>}</li>
 *   <li>{@link reprotool.model.traceability.impl.TraceLink#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceLink extends EObjectImpl implements ITraceLink {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<ITraceableEntity> source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<ITraceableEntity> target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLink() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ITraceabilityPackage.Literals.TRACE_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITraceableEntity> getSource() {
		if (source == null) {
			source = new EObjectResolvingEList<ITraceableEntity>(ITraceableEntity.class, this, ITraceabilityPackage.TRACE_LINK__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITraceableEntity> getTarget() {
		if (target == null) {
			target = new EObjectResolvingEList<ITraceableEntity>(ITraceableEntity.class, this, ITraceabilityPackage.TRACE_LINK__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ITraceabilityPackage.TRACE_LINK__SOURCE:
				return getSource();
			case ITraceabilityPackage.TRACE_LINK__TARGET:
				return getTarget();
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
			case ITraceabilityPackage.TRACE_LINK__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends ITraceableEntity>)newValue);
				return;
			case ITraceabilityPackage.TRACE_LINK__TARGET:
				getTarget().clear();
				getTarget().addAll((Collection<? extends ITraceableEntity>)newValue);
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
			case ITraceabilityPackage.TRACE_LINK__SOURCE:
				getSource().clear();
				return;
			case ITraceabilityPackage.TRACE_LINK__TARGET:
				getTarget().clear();
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
			case ITraceabilityPackage.TRACE_LINK__SOURCE:
				return source != null && !source.isEmpty();
			case ITraceabilityPackage.TRACE_LINK__TARGET:
				return target != null && !target.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TraceLink
