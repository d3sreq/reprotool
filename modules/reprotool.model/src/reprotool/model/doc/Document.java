/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.doc;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.doc.Document#getSections <em>Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.doc.DocPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
	/**
	 * Returns the value of the '<em><b>Sections</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.doc.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' containment reference list.
	 * @see reprotool.model.doc.DocPackage#getDocument_Sections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getSections();

} // Document
