/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.sentenceparts;

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
 * @see reprotool.model.linguistic.sentenceparts.SentencepartsFactory
 * @model kind="package"
 * @generated
 */
public interface SentencepartsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sentenceparts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/linguistic/sentenceparts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sentenceparts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SentencepartsPackage eINSTANCE = reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl.init();

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.SentencePartImpl <em>Sentence Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencePartImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getSentencePart()
	 * @generated
	 */
	int SENTENCE_PART = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_PART__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Sentence Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.TextImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.SubjectImpl <em>Subject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.SubjectImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getSubject()
	 * @generated
	 */
	int SUBJECT = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__ACTOR = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.GotoTargetImpl <em>Goto Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.GotoTargetImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getGotoTarget()
	 * @generated
	 */
	int GOTO_TARGET = 3;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET__TARGET = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goto Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_TARGET_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.SentenceObjectImpl <em>Sentence Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentenceObjectImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getSentenceObject()
	 * @generated
	 */
	int SENTENCE_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT__OBJECT = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sentence Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OBJECT_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.VerbImpl <em>Verb</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.VerbImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getVerb()
	 * @generated
	 */
	int VERB = 5;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB__CONTENT = SENTENCE_PART__CONTENT;

	/**
	 * The number of structural features of the '<em>Verb</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERB_FEATURE_COUNT = SENTENCE_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.RepresentativeObjectImpl <em>Representative Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.RepresentativeObjectImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getRepresentativeObject()
	 * @generated
	 */
	int REPRESENTATIVE_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATIVE_OBJECT__CONTENT = SENTENCE_OBJECT__CONTENT;

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
	 * The meta object id for the '{@link reprotool.model.linguistic.sentenceparts.impl.IndirectObjectImpl <em>Indirect Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.linguistic.sentenceparts.impl.IndirectObjectImpl
	 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getIndirectObject()
	 * @generated
	 */
	int INDIRECT_OBJECT = 7;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_OBJECT__CONTENT = SENTENCE_OBJECT__CONTENT;

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
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.SentencePart <em>Sentence Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Part</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.SentencePart
	 * @generated
	 */
	EClass getSentencePart();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.linguistic.sentenceparts.SentencePart#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.SentencePart#getContent()
	 * @see #getSentencePart()
	 * @generated
	 */
	EAttribute getSentencePart_Content();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subject</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.Subject
	 * @generated
	 */
	EClass getSubject();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.sentenceparts.Subject#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.Subject#getActor()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_Actor();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.GotoTarget <em>Goto Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto Target</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.GotoTarget
	 * @generated
	 */
	EClass getGotoTarget();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.sentenceparts.GotoTarget#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.GotoTarget#getTarget()
	 * @see #getGotoTarget()
	 * @generated
	 */
	EReference getGotoTarget_Target();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.SentenceObject <em>Sentence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence Object</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.SentenceObject
	 * @generated
	 */
	EClass getSentenceObject();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.linguistic.sentenceparts.SentenceObject#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.SentenceObject#getObject()
	 * @see #getSentenceObject()
	 * @generated
	 */
	EReference getSentenceObject_Object();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.Verb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verb</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.Verb
	 * @generated
	 */
	EClass getVerb();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.RepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Representative Object</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.RepresentativeObject
	 * @generated
	 */
	EClass getRepresentativeObject();

	/**
	 * Returns the meta object for class '{@link reprotool.model.linguistic.sentenceparts.IndirectObject <em>Indirect Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indirect Object</em>'.
	 * @see reprotool.model.linguistic.sentenceparts.IndirectObject
	 * @generated
	 */
	EClass getIndirectObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SentencepartsFactory getSentencepartsFactory();

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
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.SentencePartImpl <em>Sentence Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencePartImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getSentencePart()
		 * @generated
		 */
		EClass SENTENCE_PART = eINSTANCE.getSentencePart();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENTENCE_PART__CONTENT = eINSTANCE.getSentencePart_Content();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.TextImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.SubjectImpl <em>Subject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.SubjectImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getSubject()
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
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.GotoTargetImpl <em>Goto Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.GotoTargetImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getGotoTarget()
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
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.SentenceObjectImpl <em>Sentence Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentenceObjectImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getSentenceObject()
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
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.VerbImpl <em>Verb</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.VerbImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getVerb()
		 * @generated
		 */
		EClass VERB = eINSTANCE.getVerb();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.RepresentativeObjectImpl <em>Representative Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.RepresentativeObjectImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getRepresentativeObject()
		 * @generated
		 */
		EClass REPRESENTATIVE_OBJECT = eINSTANCE.getRepresentativeObject();

		/**
		 * The meta object literal for the '{@link reprotool.model.linguistic.sentenceparts.impl.IndirectObjectImpl <em>Indirect Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.linguistic.sentenceparts.impl.IndirectObjectImpl
		 * @see reprotool.model.linguistic.sentenceparts.impl.SentencepartsPackageImpl#getIndirectObject()
		 * @generated
		 */
		EClass INDIRECT_OBJECT = eINSTANCE.getIndirectObject();

	}

} //SentencepartsPackage
