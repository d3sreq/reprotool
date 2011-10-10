/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lts2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transitional State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link lts2.TransitionalState#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see lts2.Lts2Package#getTransitionalState()
 * @model
 * @generated
 */
public interface TransitionalState extends State {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link lts2.Transition}.
	 * It is bidirectional and its opposite is '{@link lts2.Transition#getSourceState <em>Source State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see lts2.Lts2Package#getTransitionalState_Transitions()
	 * @see lts2.Transition#getSourceState
	 * @model opposite="sourceState" containment="true" required="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // TransitionalState
