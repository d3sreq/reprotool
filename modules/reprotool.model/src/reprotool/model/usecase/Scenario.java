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
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.UsecasePackage#getScenario()
 * @model extendedMetaData="name='Use Case Scenario'"
 * @generated
 */
public interface Scenario extends EObject {
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

} // Scenario
