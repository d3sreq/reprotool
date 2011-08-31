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
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.ActionPartImpl <em>Action Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.ActionPartImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getActionPart()
	 * @generated
	 */
	int ACTION_PART = 8;

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
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.SubjectImpl <em>Subject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.SubjectImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSubject()
	 * @generated
	 */
	int SUBJECT = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__TEXT = ACTION_PART__TEXT;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__ACTOR = ACTION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT_FEATURE_COUNT = ACTION_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.GotoTargetImpl <em>Goto Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.GotoTargetImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getGotoTarget()
	 * @generated
	 */
	int GOTO_TARGET = 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET__TEXT = ACTION_PART__TEXT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET__TARGET = ACTION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goto Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET_FEATURE_COUNT = ACTION_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.SentenceObjectImpl <em>Sentence Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.SentenceObjectImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSentenceObject()
	 * @generated
	 */
	int SENTENCE_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT__TEXT = ACTION_PART__TEXT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT__OBJECT = ACTION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sentence Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT_FEATURE_COUNT = ACTION_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.VerbImpl <em>Verb</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.VerbImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getVerb()
	 * @generated
	 */
	int VERB = 4;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB__TEXT = ACTION_PART__TEXT;

	/**
	 * The number of structural features of the '<em>Verb</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB_FEATURE_COUNT = ACTION_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.RepresentativeObjectImpl <em>Representative Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.RepresentativeObjectImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getRepresentativeObject()
	 * @generated
	 */
	int REPRESENTATIVE_OBJECT = 5;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATIVE_OBJECT__TEXT = SENTENCE_OBJECT__TEXT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATIVE_OBJECT__OBJECT = SENTENCE_OBJECT__OBJECT;

	/**
	 * The number of structural features of the '<em>Representative Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATIVE_OBJECT_FEATURE_COUNT = SENTENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.IndirectObjectImpl <em>Indirect Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.IndirectObjectImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getIndirectObject()
	 * @generated
	 */
	int INDIRECT_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_OBJECT__TEXT = SENTENCE_OBJECT__TEXT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_OBJECT__OBJECT = SENTENCE_OBJECT__OBJECT;

	/**
	 * The number of structural features of the '<em>Indirect Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_OBJECT_FEATURE_COUNT = SENTENCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.actionpart.impl.UseCaseIncludePartImpl <em>Use Case Include Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.actionpart.impl.UseCaseIncludePartImpl
	 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getUseCaseIncludePart()
	 * @generated
	 */
	int USE_CASE_INCLUDE_PART = 7;

	/**
	 * The feature id for the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE_PART__TEXT = ACTION_PART__TEXT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE_PART__TARGET = ACTION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Use Case Include Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_INCLUDE_PART_FEATURE_COUNT = ACTION_PART_FEATURE_COUNT + 1;


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
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subject</em>'.
	 * @see reprotool.model.linguistic.actionpart.Subject
	 * @generated
	 */
	EClass getSubject();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.Subject#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see reprotool.model.linguistic.actionpart.Subject#getActor()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_Actor();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.GotoTarget <em>Goto Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto Target</em>'.
	 * @see reprotool.model.linguistic.actionpart.GotoTarget
	 * @generated
	 */
	EClass getGotoTarget();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.GotoTarget#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see reprotool.model.linguistic.actionpart.GotoTarget#getTarget()
	 * @see #getGotoTarget()
	 * @generated
	 */
	EReference getGotoTarget_Target();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.SentenceObject <em>Sentence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Object</em>'.
	 * @see reprotool.model.linguistic.actionpart.SentenceObject
	 * @generated
	 */
	EClass getSentenceObject();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.SentenceObject#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see reprotool.model.linguistic.actionpart.SentenceObject#getObject()
	 * @see #getSentenceObject()
	 * @generated
	 */
	EReference getSentenceObject_Object();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.Verb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verb</em>'.
	 * @see reprotool.model.linguistic.actionpart.Verb
	 * @generated
	 */
	EClass getVerb();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.RepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Representative Object</em>'.
	 * @see reprotool.model.linguistic.actionpart.RepresentativeObject
	 * @generated
	 */
	EClass getRepresentativeObject();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.IndirectObject <em>Indirect Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indirect Object</em>'.
	 * @see reprotool.model.linguistic.actionpart.IndirectObject
	 * @generated
	 */
	EClass getIndirectObject();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.actionpart.UseCaseIncludePart <em>Use Case Include Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Include Part</em>'.
	 * @see reprotool.model.linguistic.actionpart.UseCaseIncludePart
	 * @generated
	 */
	EClass getUseCaseIncludePart();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.actionpart.UseCaseIncludePart#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see reprotool.model.linguistic.actionpart.UseCaseIncludePart#getTarget()
	 * @see #getUseCaseIncludePart()
	 * @generated
	 */
	EReference getUseCaseIncludePart_Target();

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
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.SubjectImpl <em>Subject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.SubjectImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSubject()
		 * @generated
		 */
		EClass SUBJECT = eINSTANCE.getSubject();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBJECT__ACTOR = eINSTANCE.getSubject_Actor();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.GotoTargetImpl <em>Goto Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.GotoTargetImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getGotoTarget()
		 * @generated
		 */
		EClass GOTO_TARGET = eINSTANCE.getGotoTarget();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOTO_TARGET__TARGET = eINSTANCE.getGotoTarget_Target();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.SentenceObjectImpl <em>Sentence Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.SentenceObjectImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getSentenceObject()
		 * @generated
		 */
		EClass SENTENCE_OBJECT = eINSTANCE.getSentenceObject();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE_OBJECT__OBJECT = eINSTANCE.getSentenceObject_Object();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.VerbImpl <em>Verb</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.VerbImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getVerb()
		 * @generated
		 */
		EClass VERB = eINSTANCE.getVerb();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.RepresentativeObjectImpl <em>Representative Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.RepresentativeObjectImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getRepresentativeObject()
		 * @generated
		 */
		EClass REPRESENTATIVE_OBJECT = eINSTANCE.getRepresentativeObject();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.IndirectObjectImpl <em>Indirect Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.IndirectObjectImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getIndirectObject()
		 * @generated
		 */
		EClass INDIRECT_OBJECT = eINSTANCE.getIndirectObject();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.UseCaseIncludePartImpl <em>Use Case Include Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.UseCaseIncludePartImpl
		 * @see reprotool.model.linguistic.actionpart.impl.ActionpartPackageImpl#getUseCaseIncludePart()
		 * @generated
		 */
		EClass USE_CASE_INCLUDE_PART = eINSTANCE.getUseCaseIncludePart();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_INCLUDE_PART__TARGET = eINSTANCE.getUseCaseIncludePart_Target();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.actionpart.impl.ActionPartImpl <em>Action Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.actionpart.impl.ActionPartImpl
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
