/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.model.procases.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcasesFactoryImpl extends EFactoryImpl implements ProcasesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcasesFactory init() {
		try {
			ProcasesFactory theProcasesFactory = (ProcasesFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/model/procases"); 
			if (theProcasesFactory != null) {
				return theProcasesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProcasesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcasesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProcasesPackage.REQUEST_RECEIVING: return createRequestReceiving();
			case ProcasesPackage.REQUEST_SENDING: return createRequestSending();
			case ProcasesPackage.INTERNAL_ACTION: return createInternalAction();
			case ProcasesPackage.ABORT_ACTION: return createAbortAction();
			case ProcasesPackage.TERMINATE_PROTOCOL: return createTerminateProtocol();
			case ProcasesPackage.GOTO_ACTION: return createGotoAction();
			case ProcasesPackage.TERMINATE_BRANCH: return createTerminateBranch();
			case ProcasesPackage.INCLUDE_PROTOCOL: return createIncludeProtocol();
			case ProcasesPackage.UNKNOWN_ACTION: return createUnknownAction();
			case ProcasesPackage.BEHAVIOUR_PROTOCOL: return createBehaviourProtocol();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestReceiving createRequestReceiving() {
		RequestReceivingImpl requestReceiving = new RequestReceivingImpl();
		return requestReceiving;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestSending createRequestSending() {
		RequestSendingImpl requestSending = new RequestSendingImpl();
		return requestSending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalAction createInternalAction() {
		InternalActionImpl internalAction = new InternalActionImpl();
		return internalAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbortAction createAbortAction() {
		AbortActionImpl abortAction = new AbortActionImpl();
		return abortAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminateProtocol createTerminateProtocol() {
		TerminateProtocolImpl terminateProtocol = new TerminateProtocolImpl();
		return terminateProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GotoAction createGotoAction() {
		GotoActionImpl gotoAction = new GotoActionImpl();
		return gotoAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminateBranch createTerminateBranch() {
		TerminateBranchImpl terminateBranch = new TerminateBranchImpl();
		return terminateBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncludeProtocol createIncludeProtocol() {
		IncludeProtocolImpl includeProtocol = new IncludeProtocolImpl();
		return includeProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownAction createUnknownAction() {
		UnknownActionImpl unknownAction = new UnknownActionImpl();
		return unknownAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviourProtocol createBehaviourProtocol() {
		BehaviourProtocolImpl behaviourProtocol = new BehaviourProtocolImpl();
		return behaviourProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcasesPackage getProcasesPackage() {
		return (ProcasesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProcasesPackage getPackage() {
		return ProcasesPackage.eINSTANCE;
	}

} //ProcasesFactoryImpl
