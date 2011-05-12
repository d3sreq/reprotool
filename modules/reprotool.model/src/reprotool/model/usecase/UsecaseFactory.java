/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.usecase.UsecasePackage
 * @generated
 */
public interface UsecaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsecaseFactory eINSTANCE = reprotool.model.usecase.impl.UsecaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case</em>'.
	 * @generated
	 */
	UseCase createUseCase();

	/**
	 * Returns a new object of class '<em>Use Case Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case Step</em>'.
	 * @generated
	 */
	UseCaseStep createUseCaseStep();

	/**
	 * Returns a new object of class '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario</em>'.
	 * @generated
	 */
	Scenario createScenario();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UsecasePackage getUsecasePackage();

} //UsecaseFactory
