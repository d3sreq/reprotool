/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transitional State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.lts2.TransitionalState#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.lts2.Lts2Package#getTransitionalState()
 * @model
 * @generated
 */
public interface TransitionalState extends State {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.lts2.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see reprotool.model.lts2.Lts2Package#getTransitionalState_Transitions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // TransitionalState
