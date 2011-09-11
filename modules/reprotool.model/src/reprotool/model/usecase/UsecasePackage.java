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
	 * The meta object id for the '{@link reprotool.model.usecase.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.UseCaseStepImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getUseCaseStep()
	 * @generated
	 */
	int USE_CASE_STEP = 1;

	/**
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__RELATED_REQUIREMENTS = SwprojPackage.REQ_COVER__RELATED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Parsed Sentence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__PARSED_SENTENCE = SwprojPackage.REQ_COVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sentence Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__SENTENCE_NODES = SwprojPackage.REQ_COVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__EXTENSIONS = SwprojPackage.REQ_COVER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__VARIATIONS = SwprojPackage.REQ_COVER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__ACTION = SwprojPackage.REQ_COVER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__ANNOTATIONS = SwprojPackage.REQ_COVER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Use Case Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP_FEATURE_COUNT = SwprojPackage.REQ_COVER_FEATURE_COUNT + 6;

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
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.Condition <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.Condition
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 5;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__SENTENCE = 0;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.impl.PreconditionImpl <em>Precondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.PreconditionImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getPrecondition()
	 * @generated
	 */
	int PRECONDITION = 3;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION__SENTENCE = CONDITION__SENTENCE;

	/**
	 * The number of structural features of the '<em>Precondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.usecase.impl.PostconditionImpl <em>Postcondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.PostconditionImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getPostcondition()
	 * @generated
	 */
	int POSTCONDITION = 4;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION__SENTENCE = CONDITION__SENTENCE;

	/**
	 * The number of structural features of the '<em>Postcondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link reprotool.model.usecase.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.usecase.impl.GuardImpl
	 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 6;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__SENTENCE = 0;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__SCENARIO = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__ANNOTATIONS = 2;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = 3;


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
	 * Returns the meta object for class '{@link reprotool.model.usecase.UseCaseStep <em>Use Case Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Step</em>'.
	 * @see reprotool.model.usecase.UseCaseStep
	 * @generated
	 */
	EClass getUseCaseStep();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.usecase.UseCaseStep#getParsedSentence <em>Parsed Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parsed Sentence</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getParsedSentence()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_ParsedSentence();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.UseCaseStep#getSentenceNodes <em>Sentence Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sentence Nodes</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getSentenceNodes()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_SentenceNodes();

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
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.UseCaseStep#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getAnnotations()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Annotations();

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
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.Scenario#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see reprotool.model.usecase.Scenario#getDescription()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Description();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.Precondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precondition</em>'.
	 * @see reprotool.model.usecase.Precondition
	 * @generated
	 */
	EClass getPrecondition();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.Postcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postcondition</em>'.
	 * @see reprotool.model.usecase.Postcondition
	 * @generated
	 */
	EClass getPostcondition();

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
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.Condition#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sentence</em>'.
	 * @see reprotool.model.usecase.Condition#getSentence()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Sentence();

	/**
	 * Returns the meta object for class '{@link reprotool.model.usecase.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see reprotool.model.usecase.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.Guard#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sentence</em>'.
	 * @see reprotool.model.usecase.Guard#getSentence()
	 * @see #getGuard()
	 * @generated
	 */
	EAttribute getGuard_Sentence();

	/**
	 * Returns the meta object for the containment reference '{@link reprotool.model.usecase.Guard#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scenario</em>'.
	 * @see reprotool.model.usecase.Guard#getScenario()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_Scenario();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.Guard#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see reprotool.model.usecase.Guard#getAnnotations()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_Annotations();

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
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.UseCaseStepImpl <em>Use Case Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.UseCaseStepImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getUseCaseStep()
		 * @generated
		 */
		EClass USE_CASE_STEP = eINSTANCE.getUseCaseStep();

		/**
		 * The meta object literal for the '<em><b>Parsed Sentence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__PARSED_SENTENCE = eINSTANCE.getUseCaseStep_ParsedSentence();

		/**
		 * The meta object literal for the '<em><b>Sentence Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__SENTENCE_NODES = eINSTANCE.getUseCaseStep_SentenceNodes();

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
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__ANNOTATIONS = eINSTANCE.getUseCaseStep_Annotations();

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
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__DESCRIPTION = eINSTANCE.getScenario_Description();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.PreconditionImpl <em>Precondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.PreconditionImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getPrecondition()
		 * @generated
		 */
		EClass PRECONDITION = eINSTANCE.getPrecondition();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.PostconditionImpl <em>Postcondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.PostconditionImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getPostcondition()
		 * @generated
		 */
		EClass POSTCONDITION = eINSTANCE.getPostcondition();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.Condition <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.Condition
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__SENTENCE = eINSTANCE.getCondition_Sentence();

		/**
		 * The meta object literal for the '{@link reprotool.model.usecase.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.usecase.impl.GuardImpl
		 * @see reprotool.model.usecase.impl.UsecasePackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD__SENTENCE = eINSTANCE.getGuard_Sentence();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__SCENARIO = eINSTANCE.getGuard_Scenario();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__ANNOTATIONS = eINSTANCE.getGuard_Annotations();

	}

} //UsecasePackage
