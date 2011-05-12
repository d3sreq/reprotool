/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.procases.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.procases.ProcasesPackage
 * @generated
 */
public class ProcasesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcasesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcasesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ProcasesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcasesSwitch<Adapter> modelSwitch =
		new ProcasesSwitch<Adapter>() {
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseRequestReceiving(RequestReceiving object) {
				return createRequestReceivingAdapter();
			}
			@Override
			public Adapter caseRequestSending(RequestSending object) {
				return createRequestSendingAdapter();
			}
			@Override
			public Adapter caseInternalAction(InternalAction object) {
				return createInternalActionAdapter();
			}
			@Override
			public Adapter caseSpecialAction(SpecialAction object) {
				return createSpecialActionAdapter();
			}
			@Override
			public Adapter caseAbortAction(AbortAction object) {
				return createAbortActionAdapter();
			}
			@Override
			public Adapter caseTerminateProtocol(TerminateProtocol object) {
				return createTerminateProtocolAdapter();
			}
			@Override
			public Adapter caseGotoAction(GotoAction object) {
				return createGotoActionAdapter();
			}
			@Override
			public Adapter caseTerminateBranch(TerminateBranch object) {
				return createTerminateBranchAdapter();
			}
			@Override
			public Adapter caseIncludeProtocol(IncludeProtocol object) {
				return createIncludeProtocolAdapter();
			}
			@Override
			public Adapter caseRequestAction(RequestAction object) {
				return createRequestActionAdapter();
			}
			@Override
			public Adapter caseUnknownAction(UnknownAction object) {
				return createUnknownActionAdapter();
			}
			@Override
			public Adapter caseBehaviourProtocol(BehaviourProtocol object) {
				return createBehaviourProtocolAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.RequestReceiving <em>Request Receiving</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.RequestReceiving
	 * @generated
	 */
	public Adapter createRequestReceivingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.RequestSending <em>Request Sending</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.RequestSending
	 * @generated
	 */
	public Adapter createRequestSendingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.InternalAction <em>Internal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.InternalAction
	 * @generated
	 */
	public Adapter createInternalActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.SpecialAction <em>Special Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.SpecialAction
	 * @generated
	 */
	public Adapter createSpecialActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.AbortAction <em>Abort Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.AbortAction
	 * @generated
	 */
	public Adapter createAbortActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.TerminateProtocol <em>Terminate Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.TerminateProtocol
	 * @generated
	 */
	public Adapter createTerminateProtocolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.GotoAction <em>Goto Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.GotoAction
	 * @generated
	 */
	public Adapter createGotoActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.TerminateBranch <em>Terminate Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.TerminateBranch
	 * @generated
	 */
	public Adapter createTerminateBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.IncludeProtocol <em>Include Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.IncludeProtocol
	 * @generated
	 */
	public Adapter createIncludeProtocolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.RequestAction <em>Request Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.RequestAction
	 * @generated
	 */
	public Adapter createRequestActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.UnknownAction <em>Unknown Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.UnknownAction
	 * @generated
	 */
	public Adapter createUnknownActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.procases.BehaviourProtocol <em>Behaviour Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.procases.BehaviourProtocol
	 * @generated
	 */
	public Adapter createBehaviourProtocolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ProcasesAdapterFactory
