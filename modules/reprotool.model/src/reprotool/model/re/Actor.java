/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.re;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.re.Actor#getCompoundActor <em>Compound Actor</em>}</li>
 *   <li>{@link reprotool.model.re.Actor#getParent <em>Parent</em>}</li>
 *   <li>{@link reprotool.model.re.Actor#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.re.RePackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends EObject {
	/**
	 * Returns the value of the '<em><b>Compound Actor</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.re.Actor}.
	 * It is bidirectional and its opposite is '{@link reprotool.model.re.Actor#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compound Actor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compound Actor</em>' reference list.
	 * @see reprotool.model.re.RePackage#getActor_CompoundActor()
	 * @see reprotool.model.re.Actor#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<Actor> getCompoundActor();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link reprotool.model.re.Actor#getCompoundActor <em>Compound Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Actor)
	 * @see reprotool.model.re.RePackage#getActor_Parent()
	 * @see reprotool.model.re.Actor#getCompoundActor
	 * @model opposite="compoundActor"
	 * @generated
	 */
	Actor getParent();

	/**
	 * Sets the value of the '{@link reprotool.model.re.Actor#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Actor value);

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
	 * @see reprotool.model.re.RePackage#getActor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link reprotool.model.re.Actor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Actor
