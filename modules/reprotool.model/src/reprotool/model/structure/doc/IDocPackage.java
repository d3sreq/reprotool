/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.structure.doc;

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
 * @see reprotool.model.structure.doc.IDocFactory
 * @model kind="package"
 * @generated
 */
public interface IDocPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "doc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/structure/doc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "doc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IDocPackage eINSTANCE = reprotool.model.structure.doc.impl.DocPackage.init();

	/**
	 * The meta object id for the '{@link reprotool.model.structure.doc.impl.Document <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.structure.doc.impl.Document
	 * @see reprotool.model.structure.doc.impl.DocPackage#getDocument()
	 * @generated
	 */
	int DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__SECTIONS = 0;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.structure.doc.impl.Section <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.structure.doc.impl.Section
	 * @see reprotool.model.structure.doc.impl.DocPackage#getSection()
	 * @generated
	 */
	int SECTION = 1;

	/**
	 * The feature id for the '<em><b>Paragraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__PARAGRAPHS = 0;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.structure.doc.impl.Paragraph <em>Paragraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.structure.doc.impl.Paragraph
	 * @see reprotool.model.structure.doc.impl.DocPackage#getParagraph()
	 * @generated
	 */
	int PARAGRAPH = 2;

	/**
	 * The number of structural features of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_FEATURE_COUNT = ITraceabilityPackage.TRACEABLE_ENTITY_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link reprotool.model.structure.doc.IDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see reprotool.model.structure.doc.IDocument
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.structure.doc.IDocument#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see reprotool.model.structure.doc.IDocument#getSections()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Sections();

	/**
	 * Returns the meta object for class '{@link reprotool.model.structure.doc.ISection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see reprotool.model.structure.doc.ISection
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the containment reference list '{@link reprotool.model.structure.doc.ISection#getParagraphs <em>Paragraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paragraphs</em>'.
	 * @see reprotool.model.structure.doc.ISection#getParagraphs()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Paragraphs();

	/**
	 * Returns the meta object for class '{@link reprotool.model.structure.doc.IParagraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paragraph</em>'.
	 * @see reprotool.model.structure.doc.IParagraph
	 * @generated
	 */
	EClass getParagraph();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IDocFactory getDocFactory();

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
		 * The meta object literal for the '{@link reprotool.model.structure.doc.impl.Document <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.structure.doc.impl.Document
		 * @see reprotool.model.structure.doc.impl.DocPackage#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__SECTIONS = eINSTANCE.getDocument_Sections();

		/**
		 * The meta object literal for the '{@link reprotool.model.structure.doc.impl.Section <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.structure.doc.impl.Section
		 * @see reprotool.model.structure.doc.impl.DocPackage#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Paragraphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__PARAGRAPHS = eINSTANCE.getSection_Paragraphs();

		/**
		 * The meta object literal for the '{@link reprotool.model.structure.doc.impl.Paragraph <em>Paragraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.structure.doc.impl.Paragraph
		 * @see reprotool.model.structure.doc.impl.DocPackage#getParagraph()
		 * @generated
		 */
		EClass PARAGRAPH = eINSTANCE.getParagraph();

	}

} //IDocPackage
