/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.common.util.EList;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.ReqCover;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.traceability.TraceableEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.UseCase#getPrimaryActor <em>Primary Actor</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCase#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCase#getMainScenario <em>Main Scenario</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCase#getPrecedesUseCases <em>Precedes Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.UsecasePackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends ReqCover, TraceableEntity {
	/**
	 * Returns the value of the '<em><b>Primary Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Actor</em>' reference.
	 * @see #setPrimaryActor(Actor)
	 * @see reprotool.model.usecase.UsecasePackage#getUseCase_PrimaryActor()
	 * @model required="true"
	 * @generated
	 */
	Actor getPrimaryActor();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.UseCase#getPrimaryActor <em>Primary Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Actor</em>' reference.
	 * @see #getPrimaryActor()
	 * @generated
	 */
	void setPrimaryActor(Actor value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see reprotool.model.usecase.UsecasePackage#getUseCase_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.UseCase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Main Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Scenario</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Scenario</em>' containment reference.
	 * @see #setMainScenario(Scenario)
	 * @see reprotool.model.usecase.UsecasePackage#getUseCase_MainScenario()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Scenario getMainScenario();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.UseCase#getMainScenario <em>Main Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Scenario</em>' containment reference.
	 * @see #getMainScenario()
	 * @generated
	 */
	void setMainScenario(Scenario value);

	/**
	 * Returns the value of the '<em><b>Precedes Use Cases</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.usecase.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedes Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedes Use Cases</em>' reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getUseCase_PrecedesUseCases()
	 * @model ordered="false"
	 * @generated
	 */
	EList<UseCase> getPrecedesUseCases();

} // UseCase
