/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import reprotool.model.procases.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see reprotool.model.procases.ProcasesPackage
 * @generated
 */
public class ProcasesSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcasesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcasesSwitch() {
		if (modelPackage == null) {
			modelPackage = ProcasesPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ProcasesPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.REQUEST_RECEIVING: {
				RequestReceiving requestReceiving = (RequestReceiving)theEObject;
				T result = caseRequestReceiving(requestReceiving);
				if (result == null) result = caseRequestAction(requestReceiving);
				if (result == null) result = caseAction(requestReceiving);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.REQUEST_SENDING: {
				RequestSending requestSending = (RequestSending)theEObject;
				T result = caseRequestSending(requestSending);
				if (result == null) result = caseRequestAction(requestSending);
				if (result == null) result = caseAction(requestSending);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.INTERNAL_ACTION: {
				InternalAction internalAction = (InternalAction)theEObject;
				T result = caseInternalAction(internalAction);
				if (result == null) result = caseAction(internalAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.SPECIAL_ACTION: {
				SpecialAction specialAction = (SpecialAction)theEObject;
				T result = caseSpecialAction(specialAction);
				if (result == null) result = caseAction(specialAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.ABORT_ACTION: {
				AbortAction abortAction = (AbortAction)theEObject;
				T result = caseAbortAction(abortAction);
				if (result == null) result = caseSpecialAction(abortAction);
				if (result == null) result = caseAction(abortAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.TERMINATE_PROTOCOL: {
				TerminateProtocol terminateProtocol = (TerminateProtocol)theEObject;
				T result = caseTerminateProtocol(terminateProtocol);
				if (result == null) result = caseSpecialAction(terminateProtocol);
				if (result == null) result = caseAction(terminateProtocol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.GOTO_ACTION: {
				GotoAction gotoAction = (GotoAction)theEObject;
				T result = caseGotoAction(gotoAction);
				if (result == null) result = caseSpecialAction(gotoAction);
				if (result == null) result = caseAction(gotoAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.TERMINATE_BRANCH: {
				TerminateBranch terminateBranch = (TerminateBranch)theEObject;
				T result = caseTerminateBranch(terminateBranch);
				if (result == null) result = caseSpecialAction(terminateBranch);
				if (result == null) result = caseAction(terminateBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.INCLUDE_PROTOCOL: {
				IncludeProtocol includeProtocol = (IncludeProtocol)theEObject;
				T result = caseIncludeProtocol(includeProtocol);
				if (result == null) result = caseSpecialAction(includeProtocol);
				if (result == null) result = caseAction(includeProtocol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.REQUEST_ACTION: {
				RequestAction requestAction = (RequestAction)theEObject;
				T result = caseRequestAction(requestAction);
				if (result == null) result = caseAction(requestAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.UNKNOWN_ACTION: {
				UnknownAction unknownAction = (UnknownAction)theEObject;
				T result = caseUnknownAction(unknownAction);
				if (result == null) result = caseSpecialAction(unknownAction);
				if (result == null) result = caseAction(unknownAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcasesPackage.BEHAVIOUR_PROTOCOL: {
				BehaviourProtocol behaviourProtocol = (BehaviourProtocol)theEObject;
				T result = caseBehaviourProtocol(behaviourProtocol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Request Receiving</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Request Receiving</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequestReceiving(RequestReceiving object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Request Sending</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Request Sending</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequestSending(RequestSending object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalAction(InternalAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Special Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Special Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecialAction(SpecialAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abort Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abort Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbortAction(AbortAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminate Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminate Protocol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminateProtocol(TerminateProtocol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goto Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goto Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGotoAction(GotoAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminate Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminate Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminateBranch(TerminateBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Include Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Include Protocol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncludeProtocol(IncludeProtocol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Request Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Request Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequestAction(RequestAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownAction(UnknownAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behaviour Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behaviour Protocol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviourProtocol(BehaviourProtocol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ProcasesSwitch
