/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.swproj.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.swproj.*;

import reprotool.model.traceability.TraceableEntity;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.swproj.SwprojPackage
 * @generated
 */
public class SwprojAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SwprojPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwprojAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SwprojPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwprojSwitch<Adapter> modelSwitch =
		new SwprojSwitch<Adapter>() {
			@Override
			public Adapter caseSoftwareProject(SoftwareProject object) {
				return createSoftwareProjectAdapter();
			}
			@Override
			public Adapter caseActor(Actor object) {
				return createActorAdapter();
			}
			@Override
			public Adapter caseRequirement(Requirement object) {
				return createRequirementAdapter();
			}
			@Override
			public Adapter caseNFRequirement(NFRequirement object) {
				return createNFRequirementAdapter();
			}
			@Override
			public Adapter caseReqCover(ReqCover object) {
				return createReqCoverAdapter();
			}
			@Override
			public Adapter caseTraceableEntity(TraceableEntity object) {
				return createTraceableEntityAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.swproj.SoftwareProject <em>Software Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.swproj.SoftwareProject
	 * @generated
	 */
	public Adapter createSoftwareProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.swproj.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.swproj.Actor
	 * @generated
	 */
	public Adapter createActorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.swproj.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.swproj.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.swproj.NFRequirement <em>NF Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.swproj.NFRequirement
	 * @generated
	 */
	public Adapter createNFRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.swproj.ReqCover <em>Req Cover</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.swproj.ReqCover
	 * @generated
	 */
	public Adapter createReqCoverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.traceability.TraceableEntity <em>Traceable Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.traceability.TraceableEntity
	 * @generated
	 */
	public Adapter createTraceableEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SwprojAdapterFactory
