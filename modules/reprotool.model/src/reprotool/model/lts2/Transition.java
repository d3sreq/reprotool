/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts2;

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
 *   <li>{@link reprotool.model.lts2.Transition#getTargetState <em>Target State</em>}</li>
 *   <li>{@link reprotool.model.lts2.Transition#getRelatedStep <em>Related Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.lts2.Lts2Package#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target State</em>' reference.
	 * @see #setTargetState(State)
	 * @see reprotool.model.lts2.Lts2Package#getTransition_TargetState()
	 * @model required="true"
	 * @generated
	 */
	State getTargetState();

	/**
	 * Sets the value of the '{@link reprotool.model.lts2.Transition#getTargetState <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target State</em>' reference.
	 * @see #getTargetState()
	 * @generated
	 */
	void setTargetState(State value);

	/**
	 * Returns the value of the '<em><b>Related Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Step</em>' reference.
	 * @see #setRelatedStep(UseCaseStep)
	 * @see reprotool.model.lts2.Lts2Package#getTransition_RelatedStep()
	 * @model required="true"
	 * @generated
	 */
	UseCaseStep getRelatedStep();

	/**
	 * Sets the value of the '{@link reprotool.model.lts2.Transition#getRelatedStep <em>Related Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Step</em>' reference.
	 * @see #getRelatedStep()
	 * @generated
	 */
	void setRelatedStep(UseCaseStep value);

} // Transition
