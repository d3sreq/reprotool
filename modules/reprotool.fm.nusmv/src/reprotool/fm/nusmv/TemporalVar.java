/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.fm.nusmv;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Temporal Var</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.TemporalVar#getVarStates <em>Var States</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.TemporalVar#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.NusmvPackage#getTemporalVar()
 * @model
 * @generated
 */
public interface TemporalVar extends EObject {
	/**
	 * Returns the value of the '<em><b>Var States</b></em>' reference list.
	 * The list contents are of type {@link reprotool.fm.nusmv.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var States</em>' reference list.
	 * @see reprotool.fm.nusmv.NusmvPackage#getTemporalVar_VarStates()
	 * @model
	 * @generated
	 */
	EList<State> getVarStates();

	/**
	 * Returns the value of the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Name</em>' attribute.
	 * @see #setVarName(String)
	 * @see reprotool.fm.nusmv.NusmvPackage#getTemporalVar_VarName()
	 * @model
	 * @generated
	 */
	String getVarName();

	/**
	 * Sets the value of the '{@link reprotool.fm.nusmv.TemporalVar#getVarName <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' attribute.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(String value);

} // TemporalVar
