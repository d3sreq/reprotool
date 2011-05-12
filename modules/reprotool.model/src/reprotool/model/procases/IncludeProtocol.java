/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.procases;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.procases.IncludeProtocol#getIncludedProtocol <em>Included Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.procases.ProcasesPackage#getIncludeProtocol()
 * @model
 * @generated
 */
public interface IncludeProtocol extends SpecialAction {
	/**
	 * Returns the value of the '<em><b>Included Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Protocol</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Protocol</em>' reference.
	 * @see #setIncludedProtocol(BehaviourProtocol)
	 * @see reprotool.model.procases.ProcasesPackage#getIncludeProtocol_IncludedProtocol()
	 * @model
	 * @generated
	 */
	BehaviourProtocol getIncludedProtocol();

	/**
	 * Sets the value of the '{@link reprotool.model.procases.IncludeProtocol#getIncludedProtocol <em>Included Protocol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Included Protocol</em>' reference.
	 * @see #getIncludedProtocol()
	 * @generated
	 */
	void setIncludedProtocol(BehaviourProtocol value);

} // IncludeProtocol
