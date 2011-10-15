/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.actionpart.Text#getContent <em>Content</em>}</li>
 *   <li>{@link reprotool.model.linguistic.actionpart.Text#getActionPart <em>Action Part</em>}</li>
 *   <li>{@link reprotool.model.linguistic.actionpart.Text#getLemmaForm <em>Lemma Form</em>}</li>
 *   <li>{@link reprotool.model.linguistic.actionpart.Text#getPosTag <em>Pos Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getText()
 * @model
 * @generated
 */
public interface Text extends EObject {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getText_Content()
	 * @model required="true"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.Text#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Action Part</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link reprotool.model.linguistic.actionpart.ActionPart#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Part</em>' reference.
	 * @see #setActionPart(ActionPart)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getText_ActionPart()
	 * @see reprotool.model.linguistic.actionpart.ActionPart#getText
	 * @model opposite="text"
	 * @generated
	 */
	ActionPart getActionPart();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.Text#getActionPart <em>Action Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Part</em>' reference.
	 * @see #getActionPart()
	 * @generated
	 */
	void setActionPart(ActionPart value);

	/**
	 * Returns the value of the '<em><b>Lemma Form</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lemma Form</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lemma Form</em>' attribute.
	 * @see #setLemmaForm(String)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getText_LemmaForm()
	 * @model
	 * @generated
	 */
	String getLemmaForm();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.Text#getLemmaForm <em>Lemma Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lemma Form</em>' attribute.
	 * @see #getLemmaForm()
	 * @generated
	 */
	void setLemmaForm(String value);

	/**
	 * Returns the value of the '<em><b>Pos Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos Tag</em>' attribute.
	 * @see #setPosTag(String)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getText_PosTag()
	 * @model
	 * @generated
	 */
	String getPosTag();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.Text#getPosTag <em>Pos Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos Tag</em>' attribute.
	 * @see #getPosTag()
	 * @generated
	 */
	void setPosTag(String value);

} // Text
