/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getVariations <em>Variations</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getParentStep <em>Parent Step</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getDesc <em>Desc</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep()
 * @model
 * @generated
 */
public interface UseCaseStep extends EObject {

	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.specification.UseCaseStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCaseStep> getExtensions();

	/**
	 * Returns the value of the '<em><b>Variations</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.specification.UseCaseStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variations</em>' containment reference list.
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_Variations()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCaseStep> getVariations();

	/**
	 * Returns the value of the '<em><b>Parent Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Step</em>' reference.
	 * @see #setParentStep(UseCaseStep)
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_ParentStep()
	 * @model derived="true"
	 * @generated
	 */
	UseCaseStep getParentStep();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.UseCaseStep#getParentStep <em>Parent Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Step</em>' reference.
	 * @see #getParentStep()
	 * @generated
	 */
	void setParentStep(UseCaseStep value);

	/**
	 * Returns the value of the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Desc</em>' attribute.
	 * @see #setDesc(String)
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_Desc()
	 * @model
	 * @generated
	 */
	String getDesc();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.UseCaseStep#getDesc <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc</em>' attribute.
	 * @see #getDesc()
	 * @generated
	 */
	void setDesc(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getLabel();
} // UseCaseStep
