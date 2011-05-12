/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.lts.Transition#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.lts.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link reprotool.model.lts.Transition#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.lts.LtsPackage#getTransition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentence</em>' reference.
	 * @see #setSentence(UseCaseStep)
	 * @see reprotool.model.lts.LtsPackage#getTransition_Sentence()
	 * @model transient="true"
	 * @generated
	 */
	UseCaseStep getSentence();

	/**
	 * Sets the value of the '{@link reprotool.model.lts.Transition#getSentence <em>Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence</em>' reference.
	 * @see #getSentence()
	 * @generated
	 */
	void setSentence(UseCaseStep value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see reprotool.model.lts.LtsPackage#getTransition_Source()
	 * @model required="true"
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link reprotool.model.lts.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see reprotool.model.lts.LtsPackage#getTransition_Target()
	 * @model required="true"
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link reprotool.model.lts.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

} // Transition
