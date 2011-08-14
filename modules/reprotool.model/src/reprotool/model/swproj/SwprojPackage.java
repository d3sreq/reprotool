/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.swproj;

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
 * @see reprotool.model.swproj.SwprojFactory
 * @model kind="package"
 * @generated
 */
public interface SwprojPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "swproj";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/swproj";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "swproj";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SwprojPackage eINSTANCE = reprotool.model.swproj.impl.SwprojPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.swproj.impl.SoftwareProjectImpl <em>Software Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.swproj.impl.SoftwareProjectImpl
	 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getSoftwareProject()
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
	 * The feature id for the '<em><b>Srs Documents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__SRS_DOCUMENTS = 4;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT__USE_CASES = 5;

	/**
	 * The number of structural features of the '<em>Software Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_PROJECT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link reprotool.model.swproj.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.swproj.impl.ActorImpl
	 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 1;

	/**
	 * The feature id for the '<em><b>Children Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CHILDREN_ACTORS = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PARENT_ACTOR = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DESCRIPTION = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = TraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link reprotool.model.swproj.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.swproj.impl.RequirementImpl
	 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 2;

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
	 * The meta object id for the '{@link reprotool.model.swproj.impl.NFRequirementImpl <em>NF Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.swproj.impl.NFRequirementImpl
	 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getNFRequirement()
	 * @generated
	 */
	int NF_REQUIREMENT = 3;

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
	 * The meta object id for the '{@link reprotool.model.swproj.ReqCover <em>Req Cover</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.swproj.ReqCover
	 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getReqCover()
	 * @generated
	 */
	int REQ_COVER = 4;

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
	 * Returns the meta object for class '{@link reprotool.model.swproj.SoftwareProject <em>Software Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Project</em>'.
	 * @see reprotool.model.swproj.SoftwareProject
	 * @generated
	 */
	EClass getSoftwareProject();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.swproj.SoftwareProject#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see reprotool.model.swproj.SoftwareProject#getActors()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_Actors();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.swproj.SoftwareProject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.swproj.SoftwareProject#getName()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EAttribute getSoftwareProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.swproj.SoftwareProject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see reprotool.model.swproj.SoftwareProject#getDescription()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EAttribute getSoftwareProject_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.swproj.SoftwareProject#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see reprotool.model.swproj.SoftwareProject#getRequirements()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_Requirements();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.swproj.SoftwareProject#getSrsDocuments <em>Srs Documents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Srs Documents</em>'.
	 * @see reprotool.model.swproj.SoftwareProject#getSrsDocuments()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_SrsDocuments();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.swproj.SoftwareProject#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases</em>'.
	 * @see reprotool.model.swproj.SoftwareProject#getUseCases()
	 * @see #getSoftwareProject()
	 * @generated
	 */
	EReference getSoftwareProject_UseCases();

	/**
	 * Returns the meta object for class '{@link reprotool.model.swproj.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see reprotool.model.swproj.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.swproj.Actor#getChildrenActors <em>Children Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children Actors</em>'.
	 * @see reprotool.model.swproj.Actor#getChildrenActors()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_ChildrenActors();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.swproj.Actor#getParentActor <em>Parent Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Actor</em>'.
	 * @see reprotool.model.swproj.Actor#getParentActor()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_ParentActor();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.swproj.Actor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see reprotool.model.swproj.Actor#getName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Name();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.swproj.Actor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see reprotool.model.swproj.Actor#getDescription()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Description();

	/**
	 * Returns the meta object for class '{@link reprotool.model.swproj.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see reprotool.model.swproj.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.swproj.Requirement#getOriginalText <em>Original Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Text</em>'.
	 * @see reprotool.model.swproj.Requirement#getOriginalText()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_OriginalText();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.swproj.Requirement#getOriginalId <em>Original Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Id</em>'.
	 * @see reprotool.model.swproj.Requirement#getOriginalId()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_OriginalId();

	/**
	 * Returns the meta object for class '{@link reprotool.model.swproj.NFRequirement <em>NF Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NF Requirement</em>'.
	 * @see reprotool.model.swproj.NFRequirement
	 * @generated
	 */
	EClass getNFRequirement();

	/**
	 * Returns the meta object for class '{@link reprotool.model.swproj.ReqCover <em>Req Cover</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Req Cover</em>'.
	 * @see reprotool.model.swproj.ReqCover
	 * @generated
	 */
	EClass getReqCover();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.swproj.ReqCover#getRelatedRequirements <em>Related Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Related Requirements</em>'.
	 * @see reprotool.model.swproj.ReqCover#getRelatedRequirements()
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
	SwprojFactory getSwprojFactory();

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
		 * The meta object literal for the '{@link reprotool.model.swproj.impl.SoftwareProjectImpl <em>Software Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.swproj.impl.SoftwareProjectImpl
		 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getSoftwareProject()
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
		 * The meta object literal for the '<em><b>Srs Documents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__SRS_DOCUMENTS = eINSTANCE.getSoftwareProject_SrsDocuments();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_PROJECT__USE_CASES = eINSTANCE.getSoftwareProject_UseCases();

		/**
		 * The meta object literal for the '{@link reprotool.model.swproj.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.swproj.impl.ActorImpl
		 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getActor()
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
		 * The meta object literal for the '<em><b>Parent Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__PARENT_ACTOR = eINSTANCE.getActor_ParentActor();

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
		 * The meta object literal for the '{@link reprotool.model.swproj.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.swproj.impl.RequirementImpl
		 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getRequirement()
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
		 * The meta object literal for the '{@link reprotool.model.swproj.impl.NFRequirementImpl <em>NF Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.swproj.impl.NFRequirementImpl
		 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getNFRequirement()
		 * @generated
		 */
		EClass NF_REQUIREMENT = eINSTANCE.getNFRequirement();

		/**
		 * The meta object literal for the '{@link reprotool.model.swproj.ReqCover <em>Req Cover</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.swproj.ReqCover
		 * @see reprotool.model.swproj.impl.SwprojPackageImpl#getReqCover()
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

} //SwprojPackage
