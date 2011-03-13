/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.comp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.comp.IComponent#getProvidedInterfaces <em>Provided Interfaces</em>}</li>
 *   <li>{@link reprotool.model.comp.IComponent#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.comp.ICompPackage#getComponent()
 * @model
 * @generated
 */
public interface IComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>Provided Interfaces</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.comp.ICompInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interfaces</em>' reference list.
	 * @see reprotool.model.comp.ICompPackage#getComponent_ProvidedInterfaces()
	 * @model
	 * @generated
	 */
	EList<ICompInterface> getProvidedInterfaces();

	/**
	 * Returns the value of the '<em><b>Required Interfaces</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.comp.ICompInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interfaces</em>' reference list.
	 * @see reprotool.model.comp.ICompPackage#getComponent_RequiredInterfaces()
	 * @model
	 * @generated
	 */
	EList<ICompInterface> getRequiredInterfaces();

} // IComponent
