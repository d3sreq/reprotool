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
 * A representation of the model object '<em><b>Action Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.actionpart.ActionPart#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getActionPart()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ActionPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link reprotool.model.linguistic.actionpart.Text#getActionPart <em>Action Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' reference.
	 * @see #setText(Text)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getActionPart_Text()
	 * @see reprotool.model.linguistic.actionpart.Text#getActionPart
	 * @model opposite="actionPart"
	 * @generated
	 */
	Text getText();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.ActionPart#getText <em>Text</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' reference.
	 * @see #getText()
	 * @generated
	 */
	void setText(Text value);

} // ActionPart
