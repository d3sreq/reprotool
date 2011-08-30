/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.sentenceparts;

import reprotool.model.swproj.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sentence Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.sentenceparts.SentenceObject#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.linguistic.sentenceparts.SentencepartsPackage#getSentenceObject()
 * @model abstract="true"
 * @generated
 */
public interface SentenceObject extends SentencePart {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(Actor)
	 * @see reprotool.model.linguistic.sentenceparts.SentencepartsPackage#getSentenceObject_Object()
	 * @model
	 * @generated
	 */
	Actor getObject();

	/**
	 * Sets the value of the '{@link reprotool.model.linguistic.sentenceparts.SentenceObject#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(Actor value);

} // SentenceObject
