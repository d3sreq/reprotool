/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.structure.doc;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.structure.doc.Section#getParagraphs <em>Paragraphs</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.structure.doc.DocPackage#getSection()
 * @model
 * @generated
 */
public interface Section extends EObject {
	/**
	 * Returns the value of the '<em><b>Paragraphs</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.structure.doc.Paragraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paragraphs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paragraphs</em>' reference list.
	 * @see reprotool.model.structure.doc.DocPackage#getSection_Paragraphs()
	 * @model
	 * @generated
	 */
	EList<Paragraph> getParagraphs();

} // Section
