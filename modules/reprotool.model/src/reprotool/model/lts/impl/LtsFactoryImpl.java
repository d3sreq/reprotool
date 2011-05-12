/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.model.lts.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LtsFactoryImpl extends EFactoryImpl implements LtsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LtsFactory init() {
		try {
			LtsFactory theLtsFactory = (LtsFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/model/lts"); 
			if (theLtsFactory != null) {
				return theLtsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LtsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtsFactoryImpl() {
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
			case LtsPackage.STATE: return createState();
			case LtsPackage.STATE_MACHINE: return createStateMachine();
			case LtsPackage.ACTION_TRANSITION: return createActionTransition();
			case LtsPackage.GUARD_TRANSITION: return createGuardTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine createStateMachine() {
		StateMachineImpl stateMachine = new StateMachineImpl();
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionTransition createActionTransition() {
		ActionTransitionImpl actionTransition = new ActionTransitionImpl();
		return actionTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardTransition createGuardTransition() {
		GuardTransitionImpl guardTransition = new GuardTransitionImpl();
		return guardTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtsPackage getLtsPackage() {
		return (LtsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LtsPackage getPackage() {
		return LtsPackage.eINSTANCE;
	}

} //LtsFactoryImpl
