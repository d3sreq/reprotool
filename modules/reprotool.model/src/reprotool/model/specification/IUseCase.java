/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.specification.IUseCase#getPrimaryActor <em>Primary Actor</em>}</li>
 *   <li>{@link reprotool.model.specification.IUseCase#getUseCaseSteps <em>Use Case Steps</em>}</li>
 *   <li>{@link reprotool.model.specification.IUseCase#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.specification.ISpecificationPackage#getUseCase()
 * @model
 * @generated
 */
public interface IUseCase extends IGenericRequirement {
	/**
	 * Returns the value of the '<em><b>Primary Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Actor</em>' reference.
	 * @see #setPrimaryActor(IActor)
	 * @see reprotool.model.specification.ISpecificationPackage#getUseCase_PrimaryActor()
	 * @model required="true"
	 * @generated
	 */
	IActor getPrimaryActor();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.IUseCase#getPrimaryActor <em>Primary Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Actor</em>' reference.
	 * @see #getPrimaryActor()
	 * @generated
	 */
	void setPrimaryActor(IActor value);

	/**
	 * Returns the value of the '<em><b>Use Case Steps</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.specification.IUseCaseStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case Steps</em>' containment reference list.
	 * @see reprotool.model.specification.ISpecificationPackage#getUseCase_UseCaseSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<IUseCaseStep> getUseCaseSteps();

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
	 * @see reprotool.model.specification.ISpecificationPackage#getUseCase_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.IUseCase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // IUseCase
