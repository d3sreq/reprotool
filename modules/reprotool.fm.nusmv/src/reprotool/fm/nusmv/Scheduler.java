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
 * A representation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.Scheduler#getModules <em>Modules</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.Scheduler#getTempVars <em>Temp Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.fm.nusmv.NusmvPackage#getScheduler()
 * @model
 * @generated
 */
public interface Scheduler extends EObject {
	/**
	 * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.fm.nusmv.Module}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modules</em>' containment reference list.
	 * @see reprotool.fm.nusmv.NusmvPackage#getScheduler_Modules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Module> getModules();

	/**
	 * Returns the value of the '<em><b>Temp Vars</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.fm.nusmv.TemporalVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Vars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Vars</em>' containment reference list.
	 * @see reprotool.fm.nusmv.NusmvPackage#getScheduler_TempVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemporalVar> getTempVars();

} // Scheduler
