/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.lts;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.lts.State#getToken <em>Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.lts.LtsPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {

	/**
	 * Returns the value of the '<em><b>Token</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotation token used for model checking using temporal formulas
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Token</em>' attribute list.
	 * @see reprotool.model.lts.LtsPackage#getState_Token()
	 * @model
	 * @generated
	 */
	EList<String> getToken();
} // State
