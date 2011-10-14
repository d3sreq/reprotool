/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.fm.nusmv;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.usecase.UseCase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.Module#getAdjacentUseCase <em>Adjacent Use Case</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.Module#getModuleId <em>Module Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.Module#getProcessId <em>Process Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.Module#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.NusmvPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject {
	/**
	 * Returns the value of the '<em><b>Adjacent Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adjacent Use Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adjacent Use Case</em>' reference.
	 * @see #setAdjacentUseCase(UseCase)
	 * @see reprotool.fm.nusmv.NusmvPackage#getModule_AdjacentUseCase()
	 * @model
	 * @generated
	 */
	UseCase getAdjacentUseCase();

	/**
	 * Sets the value of the '{@link reprotool.fm.nusmv.Module#getAdjacentUseCase <em>Adjacent Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adjacent Use Case</em>' reference.
	 * @see #getAdjacentUseCase()
	 * @generated
	 */
	void setAdjacentUseCase(UseCase value);

	/**
	 * Returns the value of the '<em><b>Module Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Id</em>' attribute.
	 * @see #isSetModuleId()
	 * @see reprotool.fm.nusmv.NusmvPackage#getModule_ModuleId()
	 * @model unsettable="true" id="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getModuleId();

	/**
	 * Returns whether the value of the '{@link reprotool.fm.nusmv.Module#getModuleId <em>Module Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Module Id</em>' attribute is set.
	 * @see #getModuleId()
	 * @generated
	 */
	boolean isSetModuleId();

	/**
	 * Returns the value of the '<em><b>Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Id</em>' attribute.
	 * @see reprotool.fm.nusmv.NusmvPackage#getModule_ProcessId()
	 * @model changeable="false" derived="true"
	 * @generated
	 */
	String getProcessId();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.fm.nusmv.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see reprotool.fm.nusmv.NusmvPackage#getModule_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

} // Module
