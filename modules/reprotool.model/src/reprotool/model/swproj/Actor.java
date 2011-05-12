/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.swproj;

import org.eclipse.emf.common.util.EList;

import reprotool.model.traceability.TraceableEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.swproj.Actor#getChildrenActors <em>Children Actors</em>}</li>
 *   <li>{@link reprotool.model.swproj.Actor#getParentActor <em>Parent Actor</em>}</li>
 *   <li>{@link reprotool.model.swproj.Actor#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.model.swproj.Actor#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.swproj.SwprojPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends TraceableEntity {
	/**
	 * Returns the value of the '<em><b>Children Actors</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.swproj.Actor}.
	 * It is bidirectional and its opposite is '{@link reprotool.model.swproj.Actor#getParentActor <em>Parent Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children Actors</em>' reference list.
	 * @see reprotool.model.swproj.SwprojPackage#getActor_ChildrenActors()
	 * @see reprotool.model.swproj.Actor#getParentActor
	 * @model opposite="parentActor"
	 * @generated
	 */
	EList<Actor> getChildrenActors();

	/**
	 * Returns the value of the '<em><b>Parent Actor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link reprotool.model.swproj.Actor#getChildrenActors <em>Children Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Actor</em>' reference.
	 * @see #setParentActor(Actor)
	 * @see reprotool.model.swproj.SwprojPackage#getActor_ParentActor()
	 * @see reprotool.model.swproj.Actor#getChildrenActors
	 * @model opposite="childrenActors"
	 * @generated
	 */
	Actor getParentActor();

	/**
	 * Sets the value of the '{@link reprotool.model.swproj.Actor#getParentActor <em>Parent Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Actor</em>' reference.
	 * @see #getParentActor()
	 * @generated
	 */
	void setParentActor(Actor value);

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
	 * @see reprotool.model.swproj.SwprojPackage#getActor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link reprotool.model.swproj.Actor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see reprotool.model.swproj.SwprojPackage#getActor_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link reprotool.model.swproj.Actor#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Actor
