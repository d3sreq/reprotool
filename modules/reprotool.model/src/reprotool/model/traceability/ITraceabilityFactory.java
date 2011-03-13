/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.traceability;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.traceability.ITraceabilityPackage
 * @generated
 */
public interface ITraceabilityFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ITraceabilityFactory eINSTANCE = reprotool.model.traceability.impl.TraceabilityFactory.init();

	/**
	 * Returns a new object of class '<em>Trace Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Link</em>'.
	 * @generated
	 */
	ITraceLink createTraceLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ITraceabilityPackage getTraceabilityPackage();

} //ITraceabilityFactory
