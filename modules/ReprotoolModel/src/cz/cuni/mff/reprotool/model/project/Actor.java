/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cz.cuni.mff.reprotool.model.project;

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
 *   <li>{@link cz.cuni.mff.reprotool.model.project.Actor#getCompoundActor <em>Compound Actor</em>}</li>
 *   <li>{@link cz.cuni.mff.reprotool.model.project.Actor#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.cuni.mff.reprotool.model.project.Actor#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.cuni.mff.reprotool.model.project.ProjectPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends EObject {
	/**
	 * Returns the value of the '<em><b>Compound Actor</b></em>' reference list.
	 * The list contents are of type {@link cz.cuni.mff.reprotool.model.project.Actor}.
	 * It is bidirectional and its opposite is '{@link cz.cuni.mff.reprotool.model.project.Actor#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compound Actor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compound Actor</em>' reference list.
	 * @see cz.cuni.mff.reprotool.model.project.ProjectPackage#getActor_CompoundActor()
	 * @see cz.cuni.mff.reprotool.model.project.Actor#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<Actor> getCompoundActor();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cz.cuni.mff.reprotool.model.project.Actor#getCompoundActor <em>Compound Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Actor)
	 * @see cz.cuni.mff.reprotool.model.project.ProjectPackage#getActor_Parent()
	 * @see cz.cuni.mff.reprotool.model.project.Actor#getCompoundActor
	 * @model opposite="compoundActor"
	 * @generated
	 */
	Actor getParent();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.reprotool.model.project.Actor#getParent <em>Parent</em>}' reference.
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
	 * @see cz.cuni.mff.reprotool.model.project.ProjectPackage#getActor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.reprotool.model.project.Actor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Actor
