/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see reprotool.model.procases.ProcasesFactory
 * @model kind="package"
 * @generated
 */
public interface ProcasesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "procases";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/procases";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "procases";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcasesPackage eINSTANCE = reprotool.model.procases.impl.ProcasesPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.procases.Action <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.Action
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 0;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NEXT_ACTION = 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.RequestAction <em>Request Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.RequestAction
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getRequestAction()
	 * @generated
	 */
	int REQUEST_ACTION = 10;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_ACTION__NEXT_ACTION = ACTION__NEXT_ACTION;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_ACTION__ACTOR = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_ACTION__ACTION_NAME = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Request Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.RequestReceivingImpl <em>Request Receiving</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.RequestReceivingImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getRequestReceiving()
	 * @generated
	 */
	int REQUEST_RECEIVING = 1;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_RECEIVING__NEXT_ACTION = REQUEST_ACTION__NEXT_ACTION;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_RECEIVING__ACTOR = REQUEST_ACTION__ACTOR;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_RECEIVING__ACTION_NAME = REQUEST_ACTION__ACTION_NAME;

	/**
	 * The number of structural features of the '<em>Request Receiving</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_RECEIVING_FEATURE_COUNT = REQUEST_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.RequestSendingImpl <em>Request Sending</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.RequestSendingImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getRequestSending()
	 * @generated
	 */
	int REQUEST_SENDING = 2;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SENDING__NEXT_ACTION = REQUEST_ACTION__NEXT_ACTION;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SENDING__ACTOR = REQUEST_ACTION__ACTOR;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SENDING__ACTION_NAME = REQUEST_ACTION__ACTION_NAME;

	/**
	 * The number of structural features of the '<em>Request Sending</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SENDING_FEATURE_COUNT = REQUEST_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.InternalActionImpl <em>Internal Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.InternalActionImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getInternalAction()
	 * @generated
	 */
	int INTERNAL_ACTION = 3;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION__NEXT_ACTION = ACTION__NEXT_ACTION;

	/**
	 * The number of structural features of the '<em>Internal Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.SpecialAction <em>Special Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.SpecialAction
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getSpecialAction()
	 * @generated
	 */
	int SPECIAL_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ACTION__NEXT_ACTION = ACTION__NEXT_ACTION;

	/**
	 * The number of structural features of the '<em>Special Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.AbortActionImpl <em>Abort Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.AbortActionImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getAbortAction()
	 * @generated
	 */
	int ABORT_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_ACTION__NEXT_ACTION = SPECIAL_ACTION__NEXT_ACTION;

	/**
	 * The number of structural features of the '<em>Abort Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_ACTION_FEATURE_COUNT = SPECIAL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.TerminateProtocolImpl <em>Terminate Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.TerminateProtocolImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getTerminateProtocol()
	 * @generated
	 */
	int TERMINATE_PROTOCOL = 6;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_PROTOCOL__NEXT_ACTION = SPECIAL_ACTION__NEXT_ACTION;

	/**
	 * The number of structural features of the '<em>Terminate Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_PROTOCOL_FEATURE_COUNT = SPECIAL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.GotoActionImpl <em>Goto Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.GotoActionImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getGotoAction()
	 * @generated
	 */
	int GOTO_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_ACTION__NEXT_ACTION = SPECIAL_ACTION__NEXT_ACTION;

	/**
	 * The feature id for the '<em><b>Target Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_ACTION__TARGET_ACTION = SPECIAL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goto Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_ACTION_FEATURE_COUNT = SPECIAL_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.TerminateBranchImpl <em>Terminate Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.TerminateBranchImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getTerminateBranch()
	 * @generated
	 */
	int TERMINATE_BRANCH = 8;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_BRANCH__NEXT_ACTION = SPECIAL_ACTION__NEXT_ACTION;

	/**
	 * The number of structural features of the '<em>Terminate Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_BRANCH_FEATURE_COUNT = SPECIAL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.IncludeProtocolImpl <em>Include Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.IncludeProtocolImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getIncludeProtocol()
	 * @generated
	 */
	int INCLUDE_PROTOCOL = 9;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_PROTOCOL__NEXT_ACTION = SPECIAL_ACTION__NEXT_ACTION;

	/**
	 * The feature id for the '<em><b>Included Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_PROTOCOL__INCLUDED_PROTOCOL = SPECIAL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Include Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_PROTOCOL_FEATURE_COUNT = SPECIAL_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.UnknownActionImpl <em>Unknown Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.UnknownActionImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getUnknownAction()
	 * @generated
	 */
	int UNKNOWN_ACTION = 11;

	/**
	 * The feature id for the '<em><b>Next Action</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_ACTION__NEXT_ACTION = SPECIAL_ACTION__NEXT_ACTION;

	/**
	 * The number of structural features of the '<em>Unknown Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_ACTION_FEATURE_COUNT = SPECIAL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.procases.impl.BehaviourProtocolImpl <em>Behaviour Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.procases.impl.BehaviourProtocolImpl
	 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getBehaviourProtocol()
	 * @generated
	 */
	int BEHAVIOUR_PROTOCOL = 12;

	/**
	 * The feature id for the '<em><b>Begin Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOUR_PROTOCOL__BEGIN_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Enclosing Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE = 1;

	/**
	 * The number of structural features of the '<em>Behaviour Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOUR_PROTOCOL_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see reprotool.model.procases.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.procases.Action#getNextAction <em>Next Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Next Action</em>'.
	 * @see reprotool.model.procases.Action#getNextAction()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_NextAction();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.RequestReceiving <em>Request Receiving</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Receiving</em>'.
	 * @see reprotool.model.procases.RequestReceiving
	 * @generated
	 */
	EClass getRequestReceiving();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.RequestSending <em>Request Sending</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Sending</em>'.
	 * @see reprotool.model.procases.RequestSending
	 * @generated
	 */
	EClass getRequestSending();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.InternalAction <em>Internal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Action</em>'.
	 * @see reprotool.model.procases.InternalAction
	 * @generated
	 */
	EClass getInternalAction();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.SpecialAction <em>Special Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Action</em>'.
	 * @see reprotool.model.procases.SpecialAction
	 * @generated
	 */
	EClass getSpecialAction();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.AbortAction <em>Abort Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abort Action</em>'.
	 * @see reprotool.model.procases.AbortAction
	 * @generated
	 */
	EClass getAbortAction();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.TerminateProtocol <em>Terminate Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminate Protocol</em>'.
	 * @see reprotool.model.procases.TerminateProtocol
	 * @generated
	 */
	EClass getTerminateProtocol();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.GotoAction <em>Goto Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto Action</em>'.
	 * @see reprotool.model.procases.GotoAction
	 * @generated
	 */
	EClass getGotoAction();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.procases.GotoAction#getTargetAction <em>Target Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Action</em>'.
	 * @see reprotool.model.procases.GotoAction#getTargetAction()
	 * @see #getGotoAction()
	 * @generated
	 */
	EReference getGotoAction_TargetAction();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.TerminateBranch <em>Terminate Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminate Branch</em>'.
	 * @see reprotool.model.procases.TerminateBranch
	 * @generated
	 */
	EClass getTerminateBranch();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.IncludeProtocol <em>Include Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include Protocol</em>'.
	 * @see reprotool.model.procases.IncludeProtocol
	 * @generated
	 */
	EClass getIncludeProtocol();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.procases.IncludeProtocol#getIncludedProtocol <em>Included Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Included Protocol</em>'.
	 * @see reprotool.model.procases.IncludeProtocol#getIncludedProtocol()
	 * @see #getIncludeProtocol()
	 * @generated
	 */
	EReference getIncludeProtocol_IncludedProtocol();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.RequestAction <em>Request Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Action</em>'.
	 * @see reprotool.model.procases.RequestAction
	 * @generated
	 */
	EClass getRequestAction();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.procases.RequestAction#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see reprotool.model.procases.RequestAction#getActor()
	 * @see #getRequestAction()
	 * @generated
	 */
	EReference getRequestAction_Actor();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.procases.RequestAction#getActionName <em>Action Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Name</em>'.
	 * @see reprotool.model.procases.RequestAction#getActionName()
	 * @see #getRequestAction()
	 * @generated
	 */
	EAttribute getRequestAction_ActionName();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.UnknownAction <em>Unknown Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Action</em>'.
	 * @see reprotool.model.procases.UnknownAction
	 * @generated
	 */
	EClass getUnknownAction();

	/**
	 * Returns the meta object for class '{@link reprotool.model.procases.BehaviourProtocol <em>Behaviour Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behaviour Protocol</em>'.
	 * @see reprotool.model.procases.BehaviourProtocol
	 * @generated
	 */
	EClass getBehaviourProtocol();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.procases.BehaviourProtocol#getBeginAction <em>Begin Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Begin Action</em>'.
	 * @see reprotool.model.procases.BehaviourProtocol#getBeginAction()
	 * @see #getBehaviourProtocol()
	 * @generated
	 */
	EReference getBehaviourProtocol_BeginAction();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.procases.BehaviourProtocol#getEnclosingUseCase <em>Enclosing Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enclosing Use Case</em>'.
	 * @see reprotool.model.procases.BehaviourProtocol#getEnclosingUseCase()
	 * @see #getBehaviourProtocol()
	 * @generated
	 */
	EReference getBehaviourProtocol_EnclosingUseCase();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProcasesFactory getProcasesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link reprotool.model.procases.Action <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.Action
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Next Action</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__NEXT_ACTION = eINSTANCE.getAction_NextAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.RequestReceivingImpl <em>Request Receiving</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.RequestReceivingImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getRequestReceiving()
		 * @generated
		 */
		EClass REQUEST_RECEIVING = eINSTANCE.getRequestReceiving();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.RequestSendingImpl <em>Request Sending</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.RequestSendingImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getRequestSending()
		 * @generated
		 */
		EClass REQUEST_SENDING = eINSTANCE.getRequestSending();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.InternalActionImpl <em>Internal Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.InternalActionImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getInternalAction()
		 * @generated
		 */
		EClass INTERNAL_ACTION = eINSTANCE.getInternalAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.SpecialAction <em>Special Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.SpecialAction
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getSpecialAction()
		 * @generated
		 */
		EClass SPECIAL_ACTION = eINSTANCE.getSpecialAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.AbortActionImpl <em>Abort Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.AbortActionImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getAbortAction()
		 * @generated
		 */
		EClass ABORT_ACTION = eINSTANCE.getAbortAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.TerminateProtocolImpl <em>Terminate Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.TerminateProtocolImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getTerminateProtocol()
		 * @generated
		 */
		EClass TERMINATE_PROTOCOL = eINSTANCE.getTerminateProtocol();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.GotoActionImpl <em>Goto Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.GotoActionImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getGotoAction()
		 * @generated
		 */
		EClass GOTO_ACTION = eINSTANCE.getGotoAction();

		/**
		 * The meta object literal for the '<em><b>Target Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOTO_ACTION__TARGET_ACTION = eINSTANCE.getGotoAction_TargetAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.TerminateBranchImpl <em>Terminate Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.TerminateBranchImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getTerminateBranch()
		 * @generated
		 */
		EClass TERMINATE_BRANCH = eINSTANCE.getTerminateBranch();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.IncludeProtocolImpl <em>Include Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.IncludeProtocolImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getIncludeProtocol()
		 * @generated
		 */
		EClass INCLUDE_PROTOCOL = eINSTANCE.getIncludeProtocol();

		/**
		 * The meta object literal for the '<em><b>Included Protocol</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE_PROTOCOL__INCLUDED_PROTOCOL = eINSTANCE.getIncludeProtocol_IncludedProtocol();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.RequestAction <em>Request Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.RequestAction
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getRequestAction()
		 * @generated
		 */
		EClass REQUEST_ACTION = eINSTANCE.getRequestAction();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST_ACTION__ACTOR = eINSTANCE.getRequestAction_Actor();

		/**
		 * The meta object literal for the '<em><b>Action Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_ACTION__ACTION_NAME = eINSTANCE.getRequestAction_ActionName();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.UnknownActionImpl <em>Unknown Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.UnknownActionImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getUnknownAction()
		 * @generated
		 */
		EClass UNKNOWN_ACTION = eINSTANCE.getUnknownAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.procases.impl.BehaviourProtocolImpl <em>Behaviour Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.procases.impl.BehaviourProtocolImpl
		 * @see reprotool.model.procases.impl.ProcasesPackageImpl#getBehaviourProtocol()
		 * @generated
		 */
		EClass BEHAVIOUR_PROTOCOL = eINSTANCE.getBehaviourProtocol();

		/**
		 * The meta object literal for the '<em><b>Begin Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOUR_PROTOCOL__BEGIN_ACTION = eINSTANCE.getBehaviourProtocol_BeginAction();

		/**
		 * The meta object literal for the '<em><b>Enclosing Use Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOUR_PROTOCOL__ENCLOSING_USE_CASE = eINSTANCE.getBehaviourProtocol_EnclosingUseCase();

	}

} //ProcasesPackage
