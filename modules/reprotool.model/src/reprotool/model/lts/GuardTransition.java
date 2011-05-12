/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.lts.GuardTransition#getNegatedGuards <em>Negated Guards</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.lts.LtsPackage#getGuardTransition()
 * @model
 * @generated
 */
public interface GuardTransition extends Transition {
	/**
	 * Returns the value of the '<em><b>Negated Guards</b></em>' reference list.
	 * The list contents are of type {@link reprotool.model.lts.GuardTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Negated Guards</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negated Guards</em>' reference list.
	 * @see reprotool.model.lts.LtsPackage#getGuardTransition_NegatedGuards()
	 * @model
	 * @generated
	 */
	EList<GuardTransition> getNegatedGuards();

} // GuardTransition
