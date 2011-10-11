/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.Scenario#getSteps <em>Steps</em>}</li>
 *   <li>{@link reprotool.model.usecase.Scenario#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link reprotool.model.usecase.Scenario#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link reprotool.model.usecase.Scenario#getComment <em>Comment</em>}</li>
 *   <li>{@link reprotool.model.usecase.Scenario#getScenarioGuard <em>Scenario Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.UsecasePackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends LabelledElement {
	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.UseCaseStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getScenario_Steps()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCaseStep> getSteps();

	/**
	 * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preconditions</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getScenario_Preconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Condition> getPreconditions();

	/**
	 * Returns the value of the '<em><b>Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postconditions</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getScenario_Postconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Condition> getPostconditions();

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see reprotool.model.usecase.UsecasePackage#getScenario_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.Scenario#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Scenario Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario Guard</em>' containment reference.
	 * @see #setScenarioGuard(Condition)
	 * @see reprotool.model.usecase.UsecasePackage#getScenario_ScenarioGuard()
	 * @model containment="true"
	 * @generated
	 */
	Condition getScenarioGuard();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.Scenario#getScenarioGuard <em>Scenario Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario Guard</em>' containment reference.
	 * @see #getScenarioGuard()
	 * @generated
	 */
	void setScenarioGuard(Condition value);

} // Scenario
