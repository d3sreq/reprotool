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

import reprotool.model.traceability.TraceabilityPackage;

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
 * @see reprotool.model.specification.SpecificationFactory
 * @model kind="package"
 * @generated
 */
public interface SpecificationPackage extends EPackage {
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
	SpecificationPackage eINSTANCE = reprotool.model.specification.impl.SpecificationPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.SoftwareProjectImpl <em>Software Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.SoftwareProjectImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getSoftwareProject()
	 * @generated
	 */
	int SOFTWARE_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__REQUIREMENTS = 3;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__USE_CASES = 4;

	/**
	 * The number of structural features of the '<em>Software Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.GenericRequirementImpl <em>Generic Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.GenericRequirementImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getGenericRequirement()
	 * @generated
	 */
	int GENERIC_REQUIREMENT = 4;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_REQUIREMENT__ORIGINAL_TEXT = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_REQUIREMENT__ORIGINAL_ID = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Generic Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_REQUIREMENT_FEATURE_COUNT = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.UseCaseImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 1;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ORIGINAL_TEXT = GENERIC_REQUIREMENT__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Original Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ORIGINAL_ID = GENERIC_REQUIREMENT__ORIGINAL_ID;

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
	 * The meta object id for the '{@link reprotool.model.specification.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.ActorImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getActor()
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
	 * The meta object id for the '{@link reprotool.model.specification.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.UseCaseStepImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getUseCaseStep()
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
	 * The meta object id for the '{@link reprotool.model.specification.impl.NonFunctionalRequirementImpl <em>Non Functional Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.NonFunctionalRequirementImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getNonFunctionalRequirement()
	 * @generated
	 */
	int NON_FUNCTIONAL_REQUIREMENT = 5;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__ORIGINAL_TEXT = GENERIC_REQUIREMENT__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Original Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT__ORIGINAL_ID = GENERIC_REQUIREMENT__ORIGINAL_ID;

	/**
	 * The number of structural features of the '<em>Non Functional Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_FUNCTIONAL_REQUIREMENT_FEATURE_COUNT = GENERIC_REQUIREMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.SoftwareProject <em>Software Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Project</em>'.
	 * @see reprotool.model.specification.SoftwareProject
	 * @generated
	 */
	EClass getSoftwareProject();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.SoftwareProject#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see reprotool.model.specification.SoftwareProject#getActors()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_Actors();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.SoftwareProject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.specification.SoftwareProject#getName()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EAttribute getSoftwareProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.SoftwareProject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see reprotool.model.specification.SoftwareProject#getDescription()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EAttribute getSoftwareProject_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.SoftwareProject#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see reprotool.model.specification.SoftwareProject#getRequirements()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_Requirements();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.SoftwareProject#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases</em>'.
	 * @see reprotool.model.specification.SoftwareProject#getUseCases()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_UseCases();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see reprotool.model.specification.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.UseCase#getPrimaryActor <em>Primary Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Actor</em>'.
	 * @see reprotool.model.specification.UseCase#getPrimaryActor()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_PrimaryActor();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.UseCase#getUseCaseSteps <em>Use Case Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Case Steps</em>'.
	 * @see reprotool.model.specification.UseCase#getUseCaseSteps()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_UseCaseSteps();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.specification.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see reprotool.model.specification.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.specification.Actor#getChildrenActors <em>Children Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children Actors</em>'.
	 * @see reprotool.model.specification.Actor#getChildrenActors()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_ChildrenActors();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.Actor#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see reprotool.model.specification.Actor#getParent()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Parent();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.Actor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.specification.Actor#getName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Name();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.UseCaseStep <em>Use Case Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Step</em>'.
	 * @see reprotool.model.specification.UseCaseStep
	 * @generated
	 */
	EClass getUseCaseStep();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.GenericRequirement <em>Generic Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Requirement</em>'.
	 * @see reprotool.model.specification.GenericRequirement
	 * @generated
	 */
	EClass getGenericRequirement();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.GenericRequirement#getOriginalText <em>Original Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Text</em>'.
	 * @see reprotool.model.specification.GenericRequirement#getOriginalText()
	 * @see #getGenericRequirement()
	 * @generated
	 */
	EAttribute getGenericRequirement_OriginalText();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.GenericRequirement#getOriginalId <em>Original Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Id</em>'.
	 * @see reprotool.model.specification.GenericRequirement#getOriginalId()
	 * @see #getGenericRequirement()
	 * @generated
	 */
	EAttribute getGenericRequirement_OriginalId();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.NonFunctionalRequirement <em>Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Functional Requirement</em>'.
	 * @see reprotool.model.specification.NonFunctionalRequirement
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
	SpecificationFactory getSpecificationFactory();

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
		 * The meta object literal for the '{@link reprotool.model.specification.impl.SoftwareProjectImpl <em>Software Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.SoftwareProjectImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getSoftwareProject()
		 * @generated
		 */
		EClass SOFTWARE_PROJECT = eINSTANCE.getSoftwareProject();

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
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__REQUIREMENTS = eINSTANCE.getSoftwareProject_Requirements();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__USE_CASES = eINSTANCE.getSoftwareProject_UseCases();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.UseCaseImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getUseCase()
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
		 * The meta object literal for the '{@link reprotool.model.specification.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.ActorImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getActor()
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
		 * The meta object literal for the '{@link reprotool.model.specification.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.UseCaseStepImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getUseCaseStep()
		 * @generated
		 */
		EClass USE_CASE_STEP = eINSTANCE.getUseCaseStep();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.GenericRequirementImpl <em>Generic Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.GenericRequirementImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getGenericRequirement()
		 * @generated
		 */
		EClass GENERIC_REQUIREMENT = eINSTANCE.getGenericRequirement();

		/**
		 * The meta object literal for the '<em><b>Original Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_REQUIREMENT__ORIGINAL_TEXT = eINSTANCE.getGenericRequirement_OriginalText();

		/**
		 * The meta object literal for the '<em><b>Original Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_REQUIREMENT__ORIGINAL_ID = eINSTANCE.getGenericRequirement_OriginalId();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.NonFunctionalRequirementImpl <em>Non Functional Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.NonFunctionalRequirementImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getNonFunctionalRequirement()
		 * @generated
		 */
		EClass NON_FUNCTIONAL_REQUIREMENT = eINSTANCE.getNonFunctionalRequirement();

	}

} //SpecificationPackage
