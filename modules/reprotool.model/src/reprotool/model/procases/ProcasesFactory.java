/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.procases.ProcasesPackage
 * @generated
 */
public interface ProcasesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcasesFactory eINSTANCE = reprotool.model.procases.impl.ProcasesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Request Receiving</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Receiving</em>'.
	 * @generated
	 */
	RequestReceiving createRequestReceiving();

	/**
	 * Returns a new object of class '<em>Request Sending</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Sending</em>'.
	 * @generated
	 */
	RequestSending createRequestSending();

	/**
	 * Returns a new object of class '<em>Internal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Action</em>'.
	 * @generated
	 */
	InternalAction createInternalAction();

	/**
	 * Returns a new object of class '<em>Abort Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abort Action</em>'.
	 * @generated
	 */
	AbortAction createAbortAction();

	/**
	 * Returns a new object of class '<em>Terminate Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminate Protocol</em>'.
	 * @generated
	 */
	TerminateProtocol createTerminateProtocol();

	/**
	 * Returns a new object of class '<em>Goto Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Goto Action</em>'.
	 * @generated
	 */
	GotoAction createGotoAction();

	/**
	 * Returns a new object of class '<em>Terminate Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminate Branch</em>'.
	 * @generated
	 */
	TerminateBranch createTerminateBranch();

	/**
	 * Returns a new object of class '<em>Include Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Include Protocol</em>'.
	 * @generated
	 */
	IncludeProtocol createIncludeProtocol();

	/**
	 * Returns a new object of class '<em>Unknown Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown Action</em>'.
	 * @generated
	 */
	UnknownAction createUnknownAction();

	/**
	 * Returns a new object of class '<em>Behaviour Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behaviour Protocol</em>'.
	 * @generated
	 */
	BehaviourProtocol createBehaviourProtocol();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProcasesPackage getProcasesPackage();

} //ProcasesFactory
