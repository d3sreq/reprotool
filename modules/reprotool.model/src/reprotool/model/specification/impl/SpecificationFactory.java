/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.model.specification.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificationFactory extends EFactoryImpl implements ISpecificationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ISpecificationFactory init() {
		try {
			ISpecificationFactory theSpecificationFactory = (ISpecificationFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/model/specification"); 
			if (theSpecificationFactory != null) {
				return theSpecificationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpecificationFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificationFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ISpecificationPackage.SOFTWARE_PROJECT: return createSoftwareProject();
			case ISpecificationPackage.USE_CASE: return createUseCase();
			case ISpecificationPackage.ACTOR: return createActor();
			case ISpecificationPackage.USE_CASE_STEP: return createUseCaseStep();
			case ISpecificationPackage.GENERIC_REQUIREMENT: return createGenericRequirement();
			case ISpecificationPackage.NON_FUNCTIONAL_REQUIREMENT: return createNonFunctionalRequirement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISoftwareProject createSoftwareProject() {
		SoftwareProject softwareProject = new SoftwareProject();
		return softwareProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUseCase createUseCase() {
		UseCase useCase = new UseCase();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActor createActor() {
		Actor actor = new Actor();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUseCaseStep createUseCaseStep() {
		UseCaseStep useCaseStep = new UseCaseStep();
		return useCaseStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IGenericRequirement createGenericRequirement() {
		GenericRequirement genericRequirement = new GenericRequirement();
		return genericRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public INonFunctionalRequirement createNonFunctionalRequirement() {
		NonFunctionalRequirement nonFunctionalRequirement = new NonFunctionalRequirement();
		return nonFunctionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISpecificationPackage getSpecificationPackage() {
		return (ISpecificationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ISpecificationPackage getPackage() {
		return ISpecificationPackage.eINSTANCE;
	}

} //SpecificationFactory
