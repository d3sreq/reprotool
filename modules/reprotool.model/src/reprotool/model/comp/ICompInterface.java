/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.comp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.comp.ICompInterface#getInterfaceType <em>Interface Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.comp.ICompPackage#getCompInterface()
 * @model
 * @generated
 */
public interface ICompInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Interface Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Type</em>' reference.
	 * @see #setInterfaceType(ICompInterfaceType)
	 * @see reprotool.model.comp.ICompPackage#getCompInterface_InterfaceType()
	 * @model
	 * @generated
	 */
	ICompInterfaceType getInterfaceType();

	/**
	 * Sets the value of the '{@link reprotool.model.comp.ICompInterface#getInterfaceType <em>Interface Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Type</em>' reference.
	 * @see #getInterfaceType()
	 * @generated
	 */
	void setInterfaceType(ICompInterfaceType value);

} // ICompInterface
