/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart;

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
 * @see reprotool.model.linguistic.actionpart.ActionpartFactory
 * @model kind="package"
 * @generated
 */
public interface ActionpartPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actionpart";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/linguistic/actionpart";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "actionpart";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionpartPackage eINSTANCE = reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.TextImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Action Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__ACTION_PART = 1;

	/**
	 * The feature id for the '<em><b>Lemma Form</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__LEMMA_FORM = 2;

	/**
	 * The feature id for the '<em><b>Pos Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__POS_TAG = 3;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.ActionPart <em>Action Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.ActionPart
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getActionPart()
	 * @generated
	 */
	int ACTION_PART = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_PART__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Action Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.SentenceActorImpl <em>Sentence Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.SentenceActorImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSentenceActor()
	 * @generated
	 */
	int SENTENCE_ACTOR = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_ACTOR__TEXT = ACTION_PART__TEXT;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_ACTOR__ACTOR = ACTION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sentence Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_ACTOR_FEATURE_COUNT = ACTION_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.SentenceActionParamImpl <em>Sentence Action Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.SentenceActionParamImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSentenceActionParam()
	 * @generated
	 */
	int SENTENCE_ACTION_PARAM = 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_ACTION_PARAM__TEXT = ACTION_PART__TEXT;

	/**
	 * The feature id for the '<em><b>Conceptual Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT = ACTION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sentence Action Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_ACTION_PARAM_FEATURE_COUNT = ACTION_PART_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see reprotool.model.linguistic.actionpart.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.actionpart.Text#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see reprotool.model.linguistic.actionpart.Text#getContent()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Content();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.Text#getActionPart <em>Action Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action Part</em>'.
	 * @see reprotool.model.linguistic.actionpart.Text#getActionPart()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_ActionPart();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.actionpart.Text#getLemmaForm <em>Lemma Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lemma Form</em>'.
	 * @see reprotool.model.linguistic.actionpart.Text#getLemmaForm()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_LemmaForm();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.actionpart.Text#getPosTag <em>Pos Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos Tag</em>'.
	 * @see reprotool.model.linguistic.actionpart.Text#getPosTag()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_PosTag();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.SentenceActor <em>Sentence Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Actor</em>'.
	 * @see reprotool.model.linguistic.actionpart.SentenceActor
	 * @generated
	 */
	EClass getSentenceActor();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.SentenceActor#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see reprotool.model.linguistic.actionpart.SentenceActor#getActor()
	 * @see #getSentenceActor()
	 * @generated
	 */
	EReference getSentenceActor_Actor();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.SentenceActionParam <em>Sentence Action Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Action Param</em>'.
	 * @see reprotool.model.linguistic.actionpart.SentenceActionParam
	 * @generated
	 */
	EClass getSentenceActionParam();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.SentenceActionParam#getConceptualObject <em>Conceptual Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conceptual Object</em>'.
	 * @see reprotool.model.linguistic.actionpart.SentenceActionParam#getConceptualObject()
	 * @see #getSentenceActionParam()
	 * @generated
	 */
	EReference getSentenceActionParam_ConceptualObject();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.ActionPart <em>Action Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Part</em>'.
	 * @see reprotool.model.linguistic.actionpart.ActionPart
	 * @generated
	 */
	EClass getActionPart();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.ActionPart#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Text</em>'.
	 * @see reprotool.model.linguistic.actionpart.ActionPart#getText()
	 * @see #getActionPart()
	 * @generated
	 */
	EReference getActionPart_Text();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionpartFactory getActionpartFactory();

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
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.TextImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__CONTENT = eINSTANCE.getText_Content();

		/**
		 * The meta object literal for the '<em><b>Action Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__ACTION_PART = eINSTANCE.getText_ActionPart();

		/**
		 * The meta object literal for the '<em><b>Lemma Form</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__LEMMA_FORM = eINSTANCE.getText_LemmaForm();

		/**
		 * The meta object literal for the '<em><b>Pos Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__POS_TAG = eINSTANCE.getText_PosTag();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.SentenceActorImpl <em>Sentence Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.SentenceActorImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSentenceActor()
		 * @generated
		 */
		EClass SENTENCE_ACTOR = eINSTANCE.getSentenceActor();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE_ACTOR__ACTOR = eINSTANCE.getSentenceActor_Actor();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.SentenceActionParamImpl <em>Sentence Action Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.SentenceActionParamImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSentenceActionParam()
		 * @generated
		 */
		EClass SENTENCE_ACTION_PARAM = eINSTANCE.getSentenceActionParam();

		/**
		 * The meta object literal for the '<em><b>Conceptual Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT = eINSTANCE.getSentenceActionParam_ConceptualObject();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.ActionPart <em>Action Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.ActionPart
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getActionPart()
		 * @generated
		 */
		EClass ACTION_PART = eINSTANCE.getActionPart();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_PART__TEXT = eINSTANCE.getActionPart_Text();

	}

} //ActionpartPackage
