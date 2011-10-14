/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.fm.nusmv;

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
 * @see reprotool.fm.nusmv.NusmvFactory
 * @model kind="package"
 * @generated
 */
public interface NusmvPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nusmv";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/nusmv";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nusmv";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NusmvPackage eINSTANCE = reprotool.fm.nusmv.impl.NusmvPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.fm.nusmv.impl.SchedulerImpl <em>Scheduler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.fm.nusmv.impl.SchedulerImpl
	 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getScheduler()
	 * @generated
	 */
	int SCHEDULER = 0;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__MODULES = 0;

	/**
	 * The feature id for the '<em><b>Temp Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__TEMP_VARS = 1;

	/**
	 * The number of structural features of the '<em>Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link reprotool.fm.nusmv.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.fm.nusmv.impl.ModuleImpl
	 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 1;

	/**
	 * The feature id for the '<em><b>Adjacent Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ADJACENT_USE_CASE = 0;

	/**
	 * The feature id for the '<em><b>Module Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_ID = 1;

	/**
	 * The feature id for the '<em><b>Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__PROCESS_ID = 2;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__STATES = 3;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link reprotool.fm.nusmv.impl.TemporalVarImpl <em>Temporal Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.fm.nusmv.impl.TemporalVarImpl
	 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getTemporalVar()
	 * @generated
	 */
	int TEMPORAL_VAR = 2;

	/**
	 * The feature id for the '<em><b>Var States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_VAR__VAR_STATES = 0;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_VAR__VAR_NAME = 1;

	/**
	 * The number of structural features of the '<em>Temporal Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_VAR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link reprotool.fm.nusmv.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.fm.nusmv.impl.StateImpl
	 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getState()
	 * @generated
	 */
	int STATE = 3;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link reprotool.fm.nusmv.Scheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler</em>'.
	 * @see reprotool.fm.nusmv.Scheduler
	 * @generated
	 */
	EClass getScheduler();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.Scheduler#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see reprotool.fm.nusmv.Scheduler#getModules()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_Modules();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.Scheduler#getTempVars <em>Temp Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Temp Vars</em>'.
	 * @see reprotool.fm.nusmv.Scheduler#getTempVars()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_TempVars();

	/**
	 * Returns the meta object for class '{@link reprotool.fm.nusmv.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see reprotool.fm.nusmv.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the reference '{@link reprotool.fm.nusmv.Module#getAdjacentUseCase <em>Adjacent Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Adjacent Use Case</em>'.
	 * @see reprotool.fm.nusmv.Module#getAdjacentUseCase()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_AdjacentUseCase();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.Module#getModuleId <em>Module Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Id</em>'.
	 * @see reprotool.fm.nusmv.Module#getModuleId()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_ModuleId();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.Module#getProcessId <em>Process Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Id</em>'.
	 * @see reprotool.fm.nusmv.Module#getProcessId()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_ProcessId();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.fm.nusmv.Module#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see reprotool.fm.nusmv.Module#getStates()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_States();

	/**
	 * Returns the meta object for class '{@link reprotool.fm.nusmv.TemporalVar <em>Temporal Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Var</em>'.
	 * @see reprotool.fm.nusmv.TemporalVar
	 * @generated
	 */
	EClass getTemporalVar();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.fm.nusmv.TemporalVar#getVarStates <em>Var States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Var States</em>'.
	 * @see reprotool.fm.nusmv.TemporalVar#getVarStates()
	 * @see #getTemporalVar()
	 * @generated
	 */
	EReference getTemporalVar_VarStates();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.fm.nusmv.TemporalVar#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see reprotool.fm.nusmv.TemporalVar#getVarName()
	 * @see #getTemporalVar()
	 * @generated
	 */
	EAttribute getTemporalVar_VarName();

	/**
	 * Returns the meta object for class '{@link reprotool.fm.nusmv.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see reprotool.fm.nusmv.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NusmvFactory getNusmvFactory();

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
		 * The meta object literal for the '{@link reprotool.fm.nusmv.impl.SchedulerImpl <em>Scheduler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.fm.nusmv.impl.SchedulerImpl
		 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getScheduler()
		 * @generated
		 */
		EClass SCHEDULER = eINSTANCE.getScheduler();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__MODULES = eINSTANCE.getScheduler_Modules();

		/**
		 * The meta object literal for the '<em><b>Temp Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__TEMP_VARS = eINSTANCE.getScheduler_TempVars();

		/**
		 * The meta object literal for the '{@link reprotool.fm.nusmv.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.fm.nusmv.impl.ModuleImpl
		 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Adjacent Use Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__ADJACENT_USE_CASE = eINSTANCE.getModule_AdjacentUseCase();

		/**
		 * The meta object literal for the '<em><b>Module Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__MODULE_ID = eINSTANCE.getModule_ModuleId();

		/**
		 * The meta object literal for the '<em><b>Process Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__PROCESS_ID = eINSTANCE.getModule_ProcessId();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__STATES = eINSTANCE.getModule_States();

		/**
		 * The meta object literal for the '{@link reprotool.fm.nusmv.impl.TemporalVarImpl <em>Temporal Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.fm.nusmv.impl.TemporalVarImpl
		 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getTemporalVar()
		 * @generated
		 */
		EClass TEMPORAL_VAR = eINSTANCE.getTemporalVar();

		/**
		 * The meta object literal for the '<em><b>Var States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORAL_VAR__VAR_STATES = eINSTANCE.getTemporalVar_VarStates();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORAL_VAR__VAR_NAME = eINSTANCE.getTemporalVar_VarName();

		/**
		 * The meta object literal for the '{@link reprotool.fm.nusmv.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.fm.nusmv.impl.StateImpl
		 * @see reprotool.fm.nusmv.impl.NusmvPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

	}

} //NusmvPackage
