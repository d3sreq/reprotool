/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.action;

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
 * @see reprotool.model.linguistic.action.ActionFactory
 * @model kind="package"
 * @generated
 */
public interface ActionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "action";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/linguistic/action";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "action";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionPackage eINSTANCE = reprotool.model.linguistic.action.impl.ActionPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.Action <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.Action
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.Communication <em>Communication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.Communication
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getCommunication()
	 * @generated
	 */
	int COMMUNICATION = 8;

	/**
	 * The feature id for the '<em><b>Action Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__ACTION_PARAM = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__ACTION_NAME = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Communication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.FromSystemImpl <em>From System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.FromSystemImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getFromSystem()
	 * @generated
	 */
	int FROM_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Action Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_SYSTEM__ACTION_PARAM = COMMUNICATION__ACTION_PARAM;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_SYSTEM__ACTION_NAME = COMMUNICATION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_SYSTEM__RECEIVER = COMMUNICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>From System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_SYSTEM_FEATURE_COUNT = COMMUNICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.InternalImpl <em>Internal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.InternalImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getInternal()
	 * @generated
	 */
	int INTERNAL = 2;

	/**
	 * The feature id for the '<em><b>Action Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL__ACTION_PARAM = COMMUNICATION__ACTION_PARAM;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL__ACTION_NAME = COMMUNICATION__ACTION_NAME;

	/**
	 * The number of structural features of the '<em>Internal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FEATURE_COUNT = COMMUNICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.GotoImpl <em>Goto</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.GotoImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getGoto()
	 * @generated
	 */
	int GOTO = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__TEXT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Goto Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__GOTO_TARGET = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Goto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.UnknownImpl <em>Unknown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.UnknownImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getUnknown()
	 * @generated
	 */
	int UNKNOWN = 4;

	/**
	 * The number of structural features of the '<em>Unknown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.UseCaseIncludeImpl <em>Use Case Include</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.UseCaseIncludeImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getUseCaseInclude()
	 * @generated
	 */
	int USE_CASE_INCLUDE = 5;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE__TEXT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Include Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE__INCLUDE_TARGET = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Use Case Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.AbortUseCaseImpl <em>Abort Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.AbortUseCaseImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getAbortUseCase()
	 * @generated
	 */
	int ABORT_USE_CASE = 6;

	/**
	 * The number of structural features of the '<em>Abort Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_USE_CASE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.ToSystemImpl <em>To System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.ToSystemImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getToSystem()
	 * @generated
	 */
	int TO_SYSTEM = 7;

	/**
	 * The feature id for the '<em><b>Action Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_SYSTEM__ACTION_PARAM = COMMUNICATION__ACTION_PARAM;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_SYSTEM__ACTION_NAME = COMMUNICATION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_SYSTEM__SENDER = COMMUNICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>To System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_SYSTEM_FEATURE_COUNT = COMMUNICATION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see reprotool.model.linguistic.action.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.FromSystem <em>From System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From System</em>'.
	 * @see reprotool.model.linguistic.action.FromSystem
	 * @generated
	 */
	EClass getFromSystem();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.FromSystem#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receiver</em>'.
	 * @see reprotool.model.linguistic.action.FromSystem#getReceiver()
	 * @see #getFromSystem()
	 * @generated
	 */
	EReference getFromSystem_Receiver();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.Internal <em>Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal</em>'.
	 * @see reprotool.model.linguistic.action.Internal
	 * @generated
	 */
	EClass getInternal();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.Goto <em>Goto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto</em>'.
	 * @see reprotool.model.linguistic.action.Goto
	 * @generated
	 */
	EClass getGoto();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.action.Goto#getGotoTarget <em>Goto Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Goto Target</em>'.
	 * @see reprotool.model.linguistic.action.Goto#getGotoTarget()
	 * @see #getGoto()
	 * @generated
	 */
	EReference getGoto_GotoTarget();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.Unknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown</em>'.
	 * @see reprotool.model.linguistic.action.Unknown
	 * @generated
	 */
	EClass getUnknown();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.UseCaseInclude <em>Use Case Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Include</em>'.
	 * @see reprotool.model.linguistic.action.UseCaseInclude
	 * @generated
	 */
	EClass getUseCaseInclude();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.action.UseCaseInclude#getIncludeTarget <em>Include Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Include Target</em>'.
	 * @see reprotool.model.linguistic.action.UseCaseInclude#getIncludeTarget()
	 * @see #getUseCaseInclude()
	 * @generated
	 */
	EReference getUseCaseInclude_IncludeTarget();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.AbortUseCase <em>Abort Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abort Use Case</em>'.
	 * @see reprotool.model.linguistic.action.AbortUseCase
	 * @generated
	 */
	EClass getAbortUseCase();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.ToSystem <em>To System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To System</em>'.
	 * @see reprotool.model.linguistic.action.ToSystem
	 * @generated
	 */
	EClass getToSystem();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.ToSystem#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sender</em>'.
	 * @see reprotool.model.linguistic.action.ToSystem#getSender()
	 * @see #getToSystem()
	 * @generated
	 */
	EReference getToSystem_Sender();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.Communication <em>Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication</em>'.
	 * @see reprotool.model.linguistic.action.Communication
	 * @generated
	 */
	EClass getCommunication();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.linguistic.action.Communication#getActionParam <em>Action Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action Param</em>'.
	 * @see reprotool.model.linguistic.action.Communication#getActionParam()
	 * @see #getCommunication()
	 * @generated
	 */
	EReference getCommunication_ActionParam();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.action.Communication#getActionName <em>Action Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action Name</em>'.
	 * @see reprotool.model.linguistic.action.Communication#getActionName()
	 * @see #getCommunication()
	 * @generated
	 */
	EReference getCommunication_ActionName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionFactory getActionFactory();

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
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.Action <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.Action
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.FromSystemImpl <em>From System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.FromSystemImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getFromSystem()
		 * @generated
		 */
		EClass FROM_SYSTEM = eINSTANCE.getFromSystem();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_SYSTEM__RECEIVER = eINSTANCE.getFromSystem_Receiver();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.InternalImpl <em>Internal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.InternalImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getInternal()
		 * @generated
		 */
		EClass INTERNAL = eINSTANCE.getInternal();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.GotoImpl <em>Goto</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.GotoImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getGoto()
		 * @generated
		 */
		EClass GOTO = eINSTANCE.getGoto();

		/**
		 * The meta object literal for the '<em><b>Goto Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOTO__GOTO_TARGET = eINSTANCE.getGoto_GotoTarget();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.UnknownImpl <em>Unknown</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.UnknownImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getUnknown()
		 * @generated
		 */
		EClass UNKNOWN = eINSTANCE.getUnknown();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.UseCaseIncludeImpl <em>Use Case Include</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.UseCaseIncludeImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getUseCaseInclude()
		 * @generated
		 */
		EClass USE_CASE_INCLUDE = eINSTANCE.getUseCaseInclude();

		/**
		 * The meta object literal for the '<em><b>Include Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_INCLUDE__INCLUDE_TARGET = eINSTANCE.getUseCaseInclude_IncludeTarget();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.AbortUseCaseImpl <em>Abort Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.AbortUseCaseImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getAbortUseCase()
		 * @generated
		 */
		EClass ABORT_USE_CASE = eINSTANCE.getAbortUseCase();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.ToSystemImpl <em>To System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.ToSystemImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getToSystem()
		 * @generated
		 */
		EClass TO_SYSTEM = eINSTANCE.getToSystem();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_SYSTEM__SENDER = eINSTANCE.getToSystem_Sender();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.Communication <em>Communication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.Communication
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getCommunication()
		 * @generated
		 */
		EClass COMMUNICATION = eINSTANCE.getCommunication();

		/**
		 * The meta object literal for the '<em><b>Action Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION__ACTION_PARAM = eINSTANCE.getCommunication_ActionParam();

		/**
		 * The meta object literal for the '<em><b>Action Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION__ACTION_NAME = eINSTANCE.getCommunication_ActionName();

	}

} //ActionPackage
