/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.common.util.EList;

import reprotool.model.linguistic.action.Action;

import reprotool.model.swproj.SoftwareProject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getVariations <em>Variations</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getAction <em>Action</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getSoftwareProject <em>Software Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep()
 * @model
 * @generated
 */
public interface UseCaseStep extends ParseableElement {
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario> getExtensions();

	/**
	 * Returns the value of the '<em><b>Variations</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variations</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_Variations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario> getVariations();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference.
	 * @see #setAction(Action)
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_Action()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.UseCaseStep#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Software Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Software Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Software Project</em>' reference.
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_SoftwareProject()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	SoftwareProject getSoftwareProject();

} // UseCaseStep
