/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import reprotool.model.swproj.SwprojPackage;

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
 * @see reprotool.model.usecase.UsecaseFactory
 * @model kind="package"
 * @generated
 */
public interface UsecasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "usecase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/usecase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "usecase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsecasePackage eINSTANCE = reprotool.model.usecase.impl.UsecasePackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.UseCaseImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 0;

	/**
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__RELATED_REQUIREMENTS = SwprojPackage.REQ_COVER__RELATED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Primary Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PRIMARY_ACTOR = SwprojPackage.REQ_COVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = SwprojPackage.REQ_COVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Main Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__MAIN_SCENARIO = SwprojPackage.REQ_COVER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = SwprojPackage.REQ_COVER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.ParseableElement <em>Parseable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.ParseableElement
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getParseableElement()
	 * @generated
	 */
	int PARSEABLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSEABLE_ELEMENT__RELATED_REQUIREMENTS = SwprojPackage.REQ_COVER__RELATED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Text Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSEABLE_ELEMENT__TEXT_NODES = SwprojPackage.REQ_COVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSEABLE_ELEMENT__ANNOTATIONS = SwprojPackage.REQ_COVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSEABLE_ELEMENT__LABEL = SwprojPackage.REQ_COVER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Parseable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSEABLE_ELEMENT_FEATURE_COUNT = SwprojPackage.REQ_COVER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.ScenarioImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 2;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__STEPS = 0;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__PRECONDITIONS = 1;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__POSTCONDITIONS = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__COMMENT = 3;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.ConditionImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 3;

	/**
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__RELATED_REQUIREMENTS = PARSEABLE_ELEMENT__RELATED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Text Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__TEXT_NODES = PARSEABLE_ELEMENT__TEXT_NODES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__ANNOTATIONS = PARSEABLE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__LABEL = PARSEABLE_ELEMENT__LABEL;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = PARSEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.UseCaseStepImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getUseCaseStep()
	 * @generated
	 */
	int USE_CASE_STEP = 4;

	/**
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__RELATED_REQUIREMENTS = PARSEABLE_ELEMENT__RELATED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Text Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__TEXT_NODES = PARSEABLE_ELEMENT__TEXT_NODES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__ANNOTATIONS = PARSEABLE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__LABEL = PARSEABLE_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__EXTENSIONS = PARSEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__VARIATIONS = PARSEABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__ACTION = PARSEABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Software Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__SOFTWARE_PROJECT = PARSEABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Use Case Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP_FEATURE_COUNT = PARSEABLE_ELEMENT_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see reprotool.model.usecase.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.usecase.UseCase#getPrimaryActor <em>Primary Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Actor</em>'.
	 * @see reprotool.model.usecase.UseCase#getPrimaryActor()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_PrimaryActor();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.usecase.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.usecase.UseCase#getMainScenario <em>Main Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main Scenario</em>'.
	 * @see reprotool.model.usecase.UseCase#getMainScenario()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_MainScenario();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.ParseableElement <em>Parseable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parseable Element</em>'.
	 * @see reprotool.model.usecase.ParseableElement
	 * @generated
	 */
	EClass getParseableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.ParseableElement#getTextNodes <em>Text Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Text Nodes</em>'.
	 * @see reprotool.model.usecase.ParseableElement#getTextNodes()
	 * @see #getParseableElement()
	 * @generated
	 */
	EReference getParseableElement_TextNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.ParseableElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see reprotool.model.usecase.ParseableElement#getAnnotations()
	 * @see #getParseableElement()
	 * @generated
	 */
	EReference getParseableElement_Annotations();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.ParseableElement#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see reprotool.model.usecase.ParseableElement#getLabel()
	 * @see #getParseableElement()
	 * @generated
	 */
	EAttribute getParseableElement_Label();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see reprotool.model.usecase.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.Scenario#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see reprotool.model.usecase.Scenario#getSteps()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Steps();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.Scenario#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see reprotool.model.usecase.Scenario#getPreconditions()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Preconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.Scenario#getPostconditions <em>Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postconditions</em>'.
	 * @see reprotool.model.usecase.Scenario#getPostconditions()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Postconditions();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.Scenario#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see reprotool.model.usecase.Scenario#getComment()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Comment();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see reprotool.model.usecase.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.UseCaseStep <em>Use Case Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Step</em>'.
	 * @see reprotool.model.usecase.UseCaseStep
	 * @generated
	 */
	EClass getUseCaseStep();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.UseCaseStep#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getExtensions()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Extensions();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.UseCaseStep#getVariations <em>Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variations</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getVariations()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Variations();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.usecase.UseCaseStep#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getAction()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Action();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.usecase.UseCaseStep#getSoftwareProject <em>Software Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Software Project</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getSoftwareProject()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_SoftwareProject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsecaseFactory getUsecaseFactory();

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
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.UseCaseImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getUseCase()
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__NAME = eINSTANCE.getUseCase_Name();

		/**
		 * The meta object literal for the '<em><b>Main Scenario</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__MAIN_SCENARIO = eINSTANCE.getUseCase_MainScenario();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.ParseableElement <em>Parseable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.ParseableElement
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getParseableElement()
		 * @generated
		 */
		EClass PARSEABLE_ELEMENT = eINSTANCE.getParseableElement();

		/**
		 * The meta object literal for the '<em><b>Text Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARSEABLE_ELEMENT__TEXT_NODES = eINSTANCE.getParseableElement_TextNodes();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARSEABLE_ELEMENT__ANNOTATIONS = eINSTANCE.getParseableElement_Annotations();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARSEABLE_ELEMENT__LABEL = eINSTANCE.getParseableElement_Label();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.ScenarioImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__STEPS = eINSTANCE.getScenario_Steps();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__PRECONDITIONS = eINSTANCE.getScenario_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__POSTCONDITIONS = eINSTANCE.getScenario_Postconditions();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__COMMENT = eINSTANCE.getScenario_Comment();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.ConditionImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.UseCaseStepImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getUseCaseStep()
		 * @generated
		 */
		EClass USE_CASE_STEP = eINSTANCE.getUseCaseStep();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__EXTENSIONS = eINSTANCE.getUseCaseStep_Extensions();

		/**
		 * The meta object literal for the '<em><b>Variations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__VARIATIONS = eINSTANCE.getUseCaseStep_Variations();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__ACTION = eINSTANCE.getUseCaseStep_Action();

		/**
		 * The meta object literal for the '<em><b>Software Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__SOFTWARE_PROJECT = eINSTANCE.getUseCaseStep_SoftwareProject();

	}

} //UsecasePackage
