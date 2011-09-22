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
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.ActionImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.SendImpl <em>Send</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.SendImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getSend()
	 * @generated
	 */
	int SEND = 0;

	/**
	 * The feature id for the '<em><b>Verb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__VERB = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__SUBJECT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Representative Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__REPRESENTATIVE_OBJECT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Indirect Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__INDIRECT_OBJECT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_FEATURE_COUNT = ACTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.ReceiveImpl <em>Receive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.ReceiveImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getReceive()
	 * @generated
	 */
	int RECEIVE = 2;

	/**
	 * The feature id for the '<em><b>Verb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__VERB = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__SUBJECT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Representative Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__REPRESENTATIVE_OBJECT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Receive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.InternalImpl <em>Internal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.InternalImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getInternal()
	 * @generated
	 */
	int INTERNAL = 3;

	/**
	 * The feature id for the '<em><b>Verb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL__VERB = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Representative Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL__REPRESENTATIVE_OBJECT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Internal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.GotoImpl <em>Goto</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.GotoImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getGoto()
	 * @generated
	 */
	int GOTO = 4;

	/**
	 * The feature id for the '<em><b>Goto Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__GOTO_TARGET = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.UnknownImpl <em>Unknown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.UnknownImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getUnknown()
	 * @generated
	 */
	int UNKNOWN = 5;

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
	int USE_CASE_INCLUDE = 6;

	/**
	 * The feature id for the '<em><b>Include</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE__INCLUDE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Use Case Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.TerminateUseCaseImpl <em>Terminate Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.TerminateUseCaseImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getTerminateUseCase()
	 * @generated
	 */
	int TERMINATE_USE_CASE = 7;

	/**
	 * The number of structural features of the '<em>Terminate Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_USE_CASE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.action.impl.TerminateBranchImpl <em>Terminate Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.action.impl.TerminateBranchImpl
	 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getTerminateBranch()
	 * @generated
	 */
	int TERMINATE_BRANCH = 8;

	/**
	 * The number of structural features of the '<em>Terminate Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_BRANCH_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.Send <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send</em>'.
	 * @see reprotool.model.linguistic.action.Send
	 * @generated
	 */
	EClass getSend();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Send#getVerb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Verb</em>'.
	 * @see reprotool.model.linguistic.action.Send#getVerb()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Verb();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Send#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subject</em>'.
	 * @see reprotool.model.linguistic.action.Send#getSubject()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Subject();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Send#getRepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Representative Object</em>'.
	 * @see reprotool.model.linguistic.action.Send#getRepresentativeObject()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_RepresentativeObject();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Send#getIndirectObject <em>Indirect Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Indirect Object</em>'.
	 * @see reprotool.model.linguistic.action.Send#getIndirectObject()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_IndirectObject();

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
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.Receive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive</em>'.
	 * @see reprotool.model.linguistic.action.Receive
	 * @generated
	 */
	EClass getReceive();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Receive#getVerb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Verb</em>'.
	 * @see reprotool.model.linguistic.action.Receive#getVerb()
	 * @see #getReceive()
	 * @generated
	 */
	EReference getReceive_Verb();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Receive#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subject</em>'.
	 * @see reprotool.model.linguistic.action.Receive#getSubject()
	 * @see #getReceive()
	 * @generated
	 */
	EReference getReceive_Subject();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Receive#getRepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Representative Object</em>'.
	 * @see reprotool.model.linguistic.action.Receive#getRepresentativeObject()
	 * @see #getReceive()
	 * @generated
	 */
	EReference getReceive_RepresentativeObject();

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
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Internal#getVerb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Verb</em>'.
	 * @see reprotool.model.linguistic.action.Internal#getVerb()
	 * @see #getInternal()
	 * @generated
	 */
	EReference getInternal_Verb();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Internal#getRepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Representative Object</em>'.
	 * @see reprotool.model.linguistic.action.Internal#getRepresentativeObject()
	 * @see #getInternal()
	 * @generated
	 */
	EReference getInternal_RepresentativeObject();

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
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.Goto#getGotoTarget <em>Goto Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goto Target</em>'.
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
	 * Returns the meta object for the containment reference '{@link reprotool.model.linguistic.action.UseCaseInclude#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Include</em>'.
	 * @see reprotool.model.linguistic.action.UseCaseInclude#getInclude()
	 * @see #getUseCaseInclude()
	 * @generated
	 */
	EReference getUseCaseInclude_Include();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.TerminateUseCase <em>Terminate Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminate Use Case</em>'.
	 * @see reprotool.model.linguistic.action.TerminateUseCase
	 * @generated
	 */
	EClass getTerminateUseCase();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.action.TerminateBranch <em>Terminate Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminate Branch</em>'.
	 * @see reprotool.model.linguistic.action.TerminateBranch
	 * @generated
	 */
	EClass getTerminateBranch();

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
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.SendImpl <em>Send</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.SendImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getSend()
		 * @generated
		 */
		EClass SEND = eINSTANCE.getSend();

		/**
		 * The meta object literal for the '<em><b>Verb</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__VERB = eINSTANCE.getSend_Verb();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__SUBJECT = eINSTANCE.getSend_Subject();

		/**
		 * The meta object literal for the '<em><b>Representative Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__REPRESENTATIVE_OBJECT = eINSTANCE.getSend_RepresentativeObject();

		/**
		 * The meta object literal for the '<em><b>Indirect Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__INDIRECT_OBJECT = eINSTANCE.getSend_IndirectObject();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.ActionImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.ReceiveImpl <em>Receive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.ReceiveImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getReceive()
		 * @generated
		 */
		EClass RECEIVE = eINSTANCE.getReceive();

		/**
		 * The meta object literal for the '<em><b>Verb</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE__VERB = eINSTANCE.getReceive_Verb();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE__SUBJECT = eINSTANCE.getReceive_Subject();

		/**
		 * The meta object literal for the '<em><b>Representative Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE__REPRESENTATIVE_OBJECT = eINSTANCE.getReceive_RepresentativeObject();

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
		 * The meta object literal for the '<em><b>Verb</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL__VERB = eINSTANCE.getInternal_Verb();

		/**
		 * The meta object literal for the '<em><b>Representative Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL__REPRESENTATIVE_OBJECT = eINSTANCE.getInternal_RepresentativeObject();

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
		 * The meta object literal for the '<em><b>Goto Target</b></em>' containment reference feature.
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
		 * The meta object literal for the '<em><b>Include</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_INCLUDE__INCLUDE = eINSTANCE.getUseCaseInclude_Include();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.TerminateUseCaseImpl <em>Terminate Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.TerminateUseCaseImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getTerminateUseCase()
		 * @generated
		 */
		EClass TERMINATE_USE_CASE = eINSTANCE.getTerminateUseCase();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.action.impl.TerminateBranchImpl <em>Terminate Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.action.impl.TerminateBranchImpl
		 * @see reprotool.model.linguistic.action.impl.ActionPackageImpl#getTerminateBranch()
		 * @generated
		 */
		EClass TERMINATE_BRANCH = eINSTANCE.getTerminateBranch();

	}

} //ActionPackage
