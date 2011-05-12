/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.usecase.UseCase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behaviour Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.procases.BehaviourProtocol#getBeginAction <em>Begin Action</em>}</li>
 *   <li>{@link reprotool.model.procases.BehaviourProtocol#getEnclosingUseCase <em>Enclosing Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.procases.ProcasesPackage#getBehaviourProtocol()
 * @model
 * @generated
 */
public interface BehaviourProtocol extends EObject {
	/**
	 * Returns the value of the '<em><b>Begin Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin Action</em>' reference.
	 * @see #setBeginAction(Action)
	 * @see reprotool.model.procases.ProcasesPackage#getBehaviourProtocol_BeginAction()
	 * @model
	 * @generated
	 */
	Action getBeginAction();

	/**
	 * Sets the value of the '{@link reprotool.model.procases.BehaviourProtocol#getBeginAction <em>Begin Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin Action</em>' reference.
	 * @see #getBeginAction()
	 * @generated
	 */
	void setBeginAction(Action value);

	/**
	 * Returns the value of the '<em><b>Enclosing Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosing Use Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enclosing Use Case</em>' reference.
	 * @see #setEnclosingUseCase(UseCase)
	 * @see reprotool.model.procases.ProcasesPackage#getBehaviourProtocol_EnclosingUseCase()
	 * @model
	 * @generated
	 */
	UseCase getEnclosingUseCase();

	/**
	 * Sets the value of the '{@link reprotool.model.procases.BehaviourProtocol#getEnclosingUseCase <em>Enclosing Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enclosing Use Case</em>' reference.
	 * @see #getEnclosingUseCase()
	 * @generated
	 */
	void setEnclosingUseCase(UseCase value);

} // BehaviourProtocol
