/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.specification.ISpecificationPackage
 * @generated
 */
public interface ISpecificationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ISpecificationFactory eINSTANCE = reprotool.model.specification.impl.SpecificationFactory.init();

	/**
	 * Returns a new object of class '<em>Software Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Project</em>'.
	 * @generated
	 */
	ISoftwareProject createSoftwareProject();

	/**
	 * Returns a new object of class '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case</em>'.
	 * @generated
	 */
	IUseCase createUseCase();

	/**
	 * Returns a new object of class '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor</em>'.
	 * @generated
	 */
	IActor createActor();

	/**
	 * Returns a new object of class '<em>Use Case Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case Step</em>'.
	 * @generated
	 */
	IUseCaseStep createUseCaseStep();

	/**
	 * Returns a new object of class '<em>Generic Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Requirement</em>'.
	 * @generated
	 */
	IGenericRequirement createGenericRequirement();

	/**
	 * Returns a new object of class '<em>Non Functional Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Functional Requirement</em>'.
	 * @generated
	 */
	INonFunctionalRequirement createNonFunctionalRequirement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ISpecificationPackage getSpecificationPackage();

} //ISpecificationFactory
