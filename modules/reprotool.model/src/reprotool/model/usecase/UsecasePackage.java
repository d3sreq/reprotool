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
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__EXTENSION = SwprojPackage.REQ_COVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__VARIATION = SwprojPackage.REQ_COVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__SENTENCE = SwprojPackage.REQ_COVER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__LABEL = SwprojPackage.REQ_COVER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parsed Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__PARSED_SENTENCE = SwprojPackage.REQ_COVER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Use Case Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP_FEATURE_COUNT = SwprojPackage.REQ_COVER_FEATURE_COUNT + 5;

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
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = 1;


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
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.UseCaseStep#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getExtension()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Extension();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.usecase.UseCaseStep#getVariation <em>Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variation</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getVariation()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Variation();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.UseCaseStep#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sentence</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getSentence()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EAttribute getUseCaseStep_Sentence();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.usecase.UseCaseStep#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getLabel()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EAttribute getUseCaseStep_Label();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.usecase.UseCaseStep#getParsedSentence <em>Parsed Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parsed Sentence</em>'.
	 * @see reprotool.model.usecase.UseCaseStep#getParsedSentence()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_ParsedSentence();

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
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__EXTENSION = eINSTANCE.getUseCaseStep_Extension();

		/**
		 * The meta object literal for the '<em><b>Variation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__VARIATION = eINSTANCE.getUseCaseStep_Variation();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE_STEP__SENTENCE = eINSTANCE.getUseCaseStep_Sentence();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE_STEP__LABEL = eINSTANCE.getUseCaseStep_Label();

		/**
		 * The meta object literal for the '<em><b>Parsed Sentence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__PARSED_SENTENCE = eINSTANCE.getUseCaseStep_ParsedSentence();

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

	}

} //UsecasePackage
