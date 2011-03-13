/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import reprotool.model.traceability.ITraceabilityPackage;

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
 * @see reprotool.model.specification.ISpecificationFactory
 * @model kind="package"
 * @generated
 */
public interface ISpecificationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "specification";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/specification";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "specification";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ISpecificationPackage eINSTANCE = reprotool.model.specification.impl.SpecificationPackage.init();

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.SoftwareProject <em>Software Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.SoftwareProject
	 * @see reprotool.model.specification.impl.SpecificationPackage#getSoftwareProject()
	 * @generated
	 */
	int SOFTWARE_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__USE_CASES = 0;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__ACTORS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__REQUIREMENTS = 4;

	/**
	 * The number of structural features of the '<em>Software Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.GenericRequirement <em>Generic Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.GenericRequirement
	 * @see reprotool.model.specification.impl.SpecificationPackage#getGenericRequirement()
	 * @generated
	 */
	int GENERIC_REQUIREMENT = 4;

	/**
	 * The number of structural features of the '<em>Generic Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_REQUIREMENT_FEATURE_COUNT = ITraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.UseCase <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.UseCase
	 * @see reprotool.model.specification.impl.SpecificationPackage#getUseCase()
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
	int USE_CASE__PRIMARY_ACTOR = GENERIC_REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Case Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__USE_CASE_STEPS = GENERIC_REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = GENERIC_REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = GENERIC_REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.Actor <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.Actor
	 * @see reprotool.model.specification.impl.SpecificationPackage#getActor()
	 * @generated
	 */
	int ACTOR = 2;

	/**
	 * The feature id for the '<em><b>Children Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CHILDREN_ACTORS = 0;

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
	 * The meta object id for the '{@link reprotool.model.specification.impl.UseCaseStep <em>Use Case Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.UseCaseStep
	 * @see reprotool.model.specification.impl.SpecificationPackage#getUseCaseStep()
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
	 * The meta object id for the '{@link reprotool.model.specification.impl.NonFunctionalRequirement <em>Non Functional Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.NonFunctionalRequirement
	 * @see reprotool.model.specification.impl.SpecificationPackage#getNonFunctionalRequirement()
	 * @generated
	 */
	int NON_FUNCTIONAL_REQUIREMENT = 5;

	/**
	 * The number of structural features of the '<em>Non Functional Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT_FEATURE_COUNT = GENERIC_REQUIREMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.ISoftwareProject <em>Software Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Project</em>'.
	 * @see reprotool.model.specification.ISoftwareProject
	 * @generated
	 */
	EClass getSoftwareProject();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.ISoftwareProject#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases</em>'.
	 * @see reprotool.model.specification.ISoftwareProject#getUseCases()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_UseCases();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.ISoftwareProject#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see reprotool.model.specification.ISoftwareProject#getActors()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_Actors();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.ISoftwareProject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.specification.ISoftwareProject#getName()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EAttribute getSoftwareProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.ISoftwareProject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see reprotool.model.specification.ISoftwareProject#getDescription()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EAttribute getSoftwareProject_Description();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.specification.ISoftwareProject#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requirements</em>'.
	 * @see reprotool.model.specification.ISoftwareProject#getRequirements()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_Requirements();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.IUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see reprotool.model.specification.IUseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.IUseCase#getPrimaryActor <em>Primary Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Actor</em>'.
	 * @see reprotool.model.specification.IUseCase#getPrimaryActor()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_PrimaryActor();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.IUseCase#getUseCaseSteps <em>Use Case Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Case Steps</em>'.
	 * @see reprotool.model.specification.IUseCase#getUseCaseSteps()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_UseCaseSteps();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.IUseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.specification.IUseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.IActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see reprotool.model.specification.IActor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.specification.IActor#getChildrenActors <em>Children Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children Actors</em>'.
	 * @see reprotool.model.specification.IActor#getChildrenActors()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_ChildrenActors();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.IActor#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see reprotool.model.specification.IActor#getParent()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Parent();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.IActor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.specification.IActor#getName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Name();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.IUseCaseStep <em>Use Case Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Step</em>'.
	 * @see reprotool.model.specification.IUseCaseStep
	 * @generated
	 */
	EClass getUseCaseStep();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.IGenericRequirement <em>Generic Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Requirement</em>'.
	 * @see reprotool.model.specification.IGenericRequirement
	 * @generated
	 */
	EClass getGenericRequirement();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.INonFunctionalRequirement <em>Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Functional Requirement</em>'.
	 * @see reprotool.model.specification.INonFunctionalRequirement
	 * @generated
	 */
	EClass getNonFunctionalRequirement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ISpecificationFactory getSpecificationFactory();

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
		 * The meta object literal for the '{@link reprotool.model.specification.impl.SoftwareProject <em>Software Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.SoftwareProject
		 * @see reprotool.model.specification.impl.SpecificationPackage#getSoftwareProject()
		 * @generated
		 */
		EClass SOFTWARE_PROJECT = eINSTANCE.getSoftwareProject();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__USE_CASES = eINSTANCE.getSoftwareProject_UseCases();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__ACTORS = eINSTANCE.getSoftwareProject_Actors();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE_PROJECT__NAME = eINSTANCE.getSoftwareProject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE_PROJECT__DESCRIPTION = eINSTANCE.getSoftwareProject_Description();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__REQUIREMENTS = eINSTANCE.getSoftwareProject_Requirements();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.UseCase <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.UseCase
		 * @see reprotool.model.specification.impl.SpecificationPackage#getUseCase()
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
		 * The meta object literal for the '{@link reprotool.model.specification.impl.Actor <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.Actor
		 * @see reprotool.model.specification.impl.SpecificationPackage#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Children Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__CHILDREN_ACTORS = eINSTANCE.getActor_ChildrenActors();

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
		 * The meta object literal for the '{@link reprotool.model.specification.impl.UseCaseStep <em>Use Case Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.UseCaseStep
		 * @see reprotool.model.specification.impl.SpecificationPackage#getUseCaseStep()
		 * @generated
		 */
		EClass USE_CASE_STEP = eINSTANCE.getUseCaseStep();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.GenericRequirement <em>Generic Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.GenericRequirement
		 * @see reprotool.model.specification.impl.SpecificationPackage#getGenericRequirement()
		 * @generated
		 */
		EClass GENERIC_REQUIREMENT = eINSTANCE.getGenericRequirement();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.NonFunctionalRequirement <em>Non Functional Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.NonFunctionalRequirement
		 * @see reprotool.model.specification.impl.SpecificationPackage#getNonFunctionalRequirement()
		 * @generated
		 */
		EClass NON_FUNCTIONAL_REQUIREMENT = eINSTANCE.getNonFunctionalRequirement();

	}

} //ISpecificationPackage
