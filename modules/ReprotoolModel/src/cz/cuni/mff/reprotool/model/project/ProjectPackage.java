/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cz.cuni.mff.reprotool.model.project;

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
 * @see cz.cuni.mff.reprotool.model.project.ProjectFactory
 * @model kind="package"
 * @generated
 */
public interface ProjectPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "project";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://project/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "project";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProjectPackage eINSTANCE = cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl.init();

	/**
	 * The meta object id for the '{@link cz.cuni.mff.reprotool.model.project.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectImpl
	 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__USE_CASES = 0;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ACTORS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 2;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.reprotool.model.project.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.reprotool.model.project.impl.UseCaseImpl
	 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 1;

	/**
	 * The feature id for the '<em><b>Primary Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PRIMARY_ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Use Case Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__USE_CASE_STEPS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.reprotool.model.project.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.reprotool.model.project.impl.ActorImpl
	 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 2;

	/**
	 * The feature id for the '<em><b>Compound Actor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__COMPOUND_ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PARENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = 2;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.reprotool.model.project.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.reprotool.model.project.impl.UseCaseStepImpl
	 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getUseCaseStep()
	 * @generated
	 */
	int USE_CASE_STEP = 3;

	/**
	 * The number of structural features of the '<em>Use Case Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.reprotool.model.project.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.cuni.mff.reprotool.model.project.Project#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Project#getUseCases()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_UseCases();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.cuni.mff.reprotool.model.project.Project#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Project#getActors()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Actors();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.reprotool.model.project.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.reprotool.model.project.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the reference '{@link cz.cuni.mff.reprotool.model.project.UseCase#getPrimaryActor <em>Primary Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Actor</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.UseCase#getPrimaryActor()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_PrimaryActor();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.cuni.mff.reprotool.model.project.UseCase#getUseCaseSteps <em>Use Case Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Case Steps</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.UseCase#getUseCaseSteps()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_UseCaseSteps();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.reprotool.model.project.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.reprotool.model.project.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link cz.cuni.mff.reprotool.model.project.Actor#getCompoundActor <em>Compound Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Compound Actor</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Actor#getCompoundActor()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_CompoundActor();

	/**
	 * Returns the meta object for the reference '{@link cz.cuni.mff.reprotool.model.project.Actor#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Actor#getParent()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Parent();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.reprotool.model.project.Actor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.Actor#getName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Name();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.reprotool.model.project.UseCaseStep <em>Use Case Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Step</em>'.
	 * @see cz.cuni.mff.reprotool.model.project.UseCaseStep
	 * @generated
	 */
	EClass getUseCaseStep();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProjectFactory getProjectFactory();

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
		 * The meta object literal for the '{@link cz.cuni.mff.reprotool.model.project.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectImpl
		 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__USE_CASES = eINSTANCE.getProject_UseCases();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__ACTORS = eINSTANCE.getProject_Actors();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.reprotool.model.project.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.reprotool.model.project.impl.UseCaseImpl
		 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Primary Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__PRIMARY_ACTOR = eINSTANCE.getUseCase_PrimaryActor();

		/**
		 * The meta object literal for the '<em><b>Use Case Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__USE_CASE_STEPS = eINSTANCE.getUseCase_UseCaseSteps();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__NAME = eINSTANCE.getUseCase_Name();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.reprotool.model.project.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.reprotool.model.project.impl.ActorImpl
		 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Compound Actor</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__COMPOUND_ACTOR = eINSTANCE.getActor_CompoundActor();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__PARENT = eINSTANCE.getActor_Parent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NAME = eINSTANCE.getActor_Name();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.reprotool.model.project.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.reprotool.model.project.impl.UseCaseStepImpl
		 * @see cz.cuni.mff.reprotool.model.project.impl.ProjectPackageImpl#getUseCaseStep()
		 * @generated
		 */
		EClass USE_CASE_STEP = eINSTANCE.getUseCaseStep();

	}

} //ProjectPackage
