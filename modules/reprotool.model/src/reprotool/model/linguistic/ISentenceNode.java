/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sentence Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.ISentenceNode#getChildFragments <em>Child Fragments</em>}</li>
 *   <li>{@link reprotool.model.linguistic.ISentenceNode#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.ILinguisticPackage#getSentenceNode()
 * @model
 * @generated
 */
public interface ISentenceNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Child Fragments</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.linguistic.ISentenceNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Fragments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Fragments</em>' reference list.
	 * @see reprotool.model.linguistic.ILinguisticPackage#getSentenceNode_ChildFragments()
	 * @model
	 * @generated
	 */
	EList<ISentenceNode> getChildFragments();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see reprotool.model.linguistic.ILinguisticPackage#getSentenceNode_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.ISentenceNode#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // ISentenceNode
