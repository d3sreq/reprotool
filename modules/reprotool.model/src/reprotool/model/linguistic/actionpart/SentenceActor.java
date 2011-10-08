/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart;

import reprotool.model.swproj.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sentence Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.actionpart.SentenceActor#getActor <em>Actor</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getSentenceActor()
 * @model
 * @generated
 */
public interface SentenceActor extends ActionPart {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference.
	 * @see #setActor(Actor)
	 * @see reprotool.model.linguistic.actionpart.ActionpartPackage#getSentenceActor_Actor()
	 * @model required="true"
	 * @generated
	 */
	Actor getActor();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.actionpart.SentenceActor#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' reference.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(Actor value);

} // SentenceActor
