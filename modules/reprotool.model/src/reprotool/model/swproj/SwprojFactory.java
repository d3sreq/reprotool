/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.swproj;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.swproj.SwprojPackage
 * @generated
 */
public interface SwprojFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SwprojFactory eINSTANCE = reprotool.model.swproj.impl.SwprojFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Software Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Project</em>'.
	 * @generated
	 */
	SoftwareProject createSoftwareProject();

	/**
	 * Returns a new object of class '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor</em>'.
	 * @generated
	 */
	Actor createActor();

	/**
	 * Returns a new object of class '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement</em>'.
	 * @generated
	 */
	Requirement createRequirement();

	/**
	 * Returns a new object of class '<em>NF Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NF Requirement</em>'.
	 * @generated
	 */
	NFRequirement createNFRequirement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SwprojPackage getSwprojPackage();

} //SwprojFactory
