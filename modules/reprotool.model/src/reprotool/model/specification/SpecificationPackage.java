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
	 * The feature id for the '<em><b>Srs Documents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__SRS_DOCUMENTS = 5;

	/**
	 * The number of structural features of the '<em>Software Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.RequirementImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 4;

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
	 * The meta object id for the '{@link reprotool.model.specification.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.ActorImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 2;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.ReqCoverImpl <em>Req Cover</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.ReqCoverImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getReqCover()
	 * @generated
	 */
	int REQ_COVER = 6;

	/**
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_COVER__RELATED_REQUIREMENTS = 0;

	/**
	 * The number of structural features of the '<em>Req Cover</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_COVER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__RELATED_REQUIREMENTS = REQ_COVER__RELATED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Primary Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PRIMARY_ACTOR = REQ_COVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Case Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__USE_CASE_STEPS = REQ_COVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = REQ_COVER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = REQ_COVER_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = 4;

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
	 * The feature id for the '<em><b>Related Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__RELATED_REQUIREMENTS = REQ_COVER__RELATED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__EXTENSIONS = REQ_COVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__VARIATIONS = REQ_COVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__SENTENCE = REQ_COVER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP__NEXT_STEP = REQ_COVER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Use Case Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_STEP_FEATURE_COUNT = REQ_COVER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ORIGINAL_TEXT = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ORIGINAL_ID = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link reprotool.model.specification.impl.NFRequirementImpl <em>NF Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.specification.impl.NFRequirementImpl
	 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getNFRequirement()
	 * @generated
	 */
	int NF_REQUIREMENT = 5;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NF_REQUIREMENT__ORIGINAL_TEXT = REQUIREMENT__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Original Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NF_REQUIREMENT__ORIGINAL_ID = REQUIREMENT__ORIGINAL_ID;

	/**
	 * The number of structural features of the '<em>NF Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NF_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 0;


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
	 * Returns the meta object for the reference list '{@link reprotool.model.specification.SoftwareProject#getSrsDocuments <em>Srs Documents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Srs Documents</em>'.
	 * @see reprotool.model.specification.SoftwareProject#getSrsDocuments()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_SrsDocuments();

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
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.Actor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see reprotool.model.specification.Actor#getDescription()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Description();

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
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.UseCaseStep#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see reprotool.model.specification.UseCaseStep#getExtensions()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Extensions();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.specification.UseCaseStep#getVariations <em>Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variations</em>'.
	 * @see reprotool.model.specification.UseCaseStep#getVariations()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_Variations();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.UseCaseStep#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sentence</em>'.
	 * @see reprotool.model.specification.UseCaseStep#getSentence()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EAttribute getUseCaseStep_Sentence();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.specification.UseCaseStep#getNextStep <em>Next Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Step</em>'.
	 * @see reprotool.model.specification.UseCaseStep#getNextStep()
	 * @see #getUseCaseStep()
	 * @generated
	 */
	EReference getUseCaseStep_NextStep();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see reprotool.model.specification.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.Requirement#getOriginalText <em>Original Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Text</em>'.
	 * @see reprotool.model.specification.Requirement#getOriginalText()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_OriginalText();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.specification.Requirement#getOriginalId <em>Original Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Id</em>'.
	 * @see reprotool.model.specification.Requirement#getOriginalId()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_OriginalId();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.NFRequirement <em>NF Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NF Requirement</em>'.
	 * @see reprotool.model.specification.NFRequirement
	 * @generated
	 */
	EClass getNFRequirement();

	/**
	 * Returns the meta object for class '{@link reprotool.model.specification.ReqCover <em>Req Cover</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Req Cover</em>'.
	 * @see reprotool.model.specification.ReqCover
	 * @generated
	 */
	EClass getReqCover();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.specification.ReqCover#getRelatedRequirements <em>Related Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Related Requirements</em>'.
	 * @see reprotool.model.specification.ReqCover#getRelatedRequirements()
	 * @see #getReqCover()
	 * @generated
	 */
	EReference getReqCover_RelatedRequirements();

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
		 * The meta object literal for the '<em><b>Srs Documents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__SRS_DOCUMENTS = eINSTANCE.getSoftwareProject_SrsDocuments();

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
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__DESCRIPTION = eINSTANCE.getActor_Description();

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
		 * The meta object literal for the '<em><b>Sentence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE_STEP__SENTENCE = eINSTANCE.getUseCaseStep_Sentence();

		/**
		 * The meta object literal for the '<em><b>Next Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_STEP__NEXT_STEP = eINSTANCE.getUseCaseStep_NextStep();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.RequirementImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Original Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__ORIGINAL_TEXT = eINSTANCE.getRequirement_OriginalText();

		/**
		 * The meta object literal for the '<em><b>Original Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__ORIGINAL_ID = eINSTANCE.getRequirement_OriginalId();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.NFRequirementImpl <em>NF Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.NFRequirementImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getNFRequirement()
		 * @generated
		 */
		EClass NF_REQUIREMENT = eINSTANCE.getNFRequirement();

		/**
		 * The meta object literal for the '{@link reprotool.model.specification.impl.ReqCoverImpl <em>Req Cover</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.specification.impl.ReqCoverImpl
		 * @see reprotool.model.specification.impl.SpecificationPackageImpl#getReqCover()
		 * @generated
		 */
		EClass REQ_COVER = eINSTANCE.getReqCover();

		/**
		 * The meta object literal for the '<em><b>Related Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQ_COVER__RELATED_REQUIREMENTS = eINSTANCE.getReqCover_RelatedRequirements();

	}

} //SpecificationPackage
