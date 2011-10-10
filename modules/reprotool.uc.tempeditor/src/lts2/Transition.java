/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lts2;

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
 *   <li>{@link lts2.Transition#getTargetState <em>Target State</em>}</li>
 *   <li>{@link lts2.Transition#getRelatedStep <em>Related Step</em>}</li>
 *   <li>{@link lts2.Transition#getSourceState <em>Source State</em>}</li>
 * </ul>
 * </p>
 *
 * @see lts2.Lts2Package#getTransition()
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
	 * @see lts2.Lts2Package#getTransition_TargetState()
	 * @model required="true"
	 * @generated
	 */
	State getTargetState();

	/**
	 * Sets the value of the '{@link lts2.Transition#getTargetState <em>Target State</em>}' reference.
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
	 * @see lts2.Lts2Package#getTransition_RelatedStep()
	 * @model required="true"
	 * @generated
	 */
	UseCaseStep getRelatedStep();

	/**
	 * Sets the value of the '{@link lts2.Transition#getRelatedStep <em>Related Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Step</em>' reference.
	 * @see #getRelatedStep()
	 * @generated
	 */
	void setRelatedStep(UseCaseStep value);

	/**
	 * Returns the value of the '<em><b>Source State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link lts2.TransitionalState#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source State</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source State</em>' container reference.
	 * @see #setSourceState(TransitionalState)
	 * @see lts2.Lts2Package#getTransition_SourceState()
	 * @see lts2.TransitionalState#getTransitions
	 * @model opposite="transitions" required="true" transient="false"
	 * @generated
	 */
	TransitionalState getSourceState();

	/**
	 * Sets the value of the '{@link lts2.Transition#getSourceState <em>Source State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source State</em>' container reference.
	 * @see #getSourceState()
	 * @generated
	 */
	void setSourceState(TransitionalState value);

} // Transition
