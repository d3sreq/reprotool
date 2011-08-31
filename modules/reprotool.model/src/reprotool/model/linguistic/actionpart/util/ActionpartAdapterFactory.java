/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.linguistic.actionpart.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see reprotool.model.linguistic.actionpart.ActionpartPackage
 * @generated
 */
public class ActionpartAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActionpartPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionpartAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ActionpartPackage.eINSTANCE;
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
	protected ActionpartSwitch<Adapter> modelSwitch =
		new ActionpartSwitch<Adapter>() {
			@Override
			public Adapter caseText(Text object) {
				return createTextAdapter();
			}
			@Override
			public Adapter caseSubject(Subject object) {
				return createSubjectAdapter();
			}
			@Override
			public Adapter caseGotoTarget(GotoTarget object) {
				return createGotoTargetAdapter();
			}
			@Override
			public Adapter caseSentenceObject(SentenceObject object) {
				return createSentenceObjectAdapter();
			}
			@Override
			public Adapter caseVerb(Verb object) {
				return createVerbAdapter();
			}
			@Override
			public Adapter caseRepresentativeObject(RepresentativeObject object) {
				return createRepresentativeObjectAdapter();
			}
			@Override
			public Adapter caseIndirectObject(IndirectObject object) {
				return createIndirectObjectAdapter();
			}
			@Override
			public Adapter caseUseCaseIncludePart(UseCaseIncludePart object) {
				return createUseCaseIncludePartAdapter();
			}
			@Override
			public Adapter caseActionPart(ActionPart object) {
				return createActionPartAdapter();
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
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.Text
	 * @generated
	 */
	public Adapter createTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.Subject
	 * @generated
	 */
	public Adapter createSubjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.GotoTarget <em>Goto Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.GotoTarget
	 * @generated
	 */
	public Adapter createGotoTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.SentenceObject <em>Sentence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.SentenceObject
	 * @generated
	 */
	public Adapter createSentenceObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.Verb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.Verb
	 * @generated
	 */
	public Adapter createVerbAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.RepresentativeObject <em>Representative Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.RepresentativeObject
	 * @generated
	 */
	public Adapter createRepresentativeObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.IndirectObject <em>Indirect Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.IndirectObject
	 * @generated
	 */
	public Adapter createIndirectObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.UseCaseIncludePart <em>Use Case Include Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.UseCaseIncludePart
	 * @generated
	 */
	public Adapter createUseCaseIncludePartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link reprotool.model.linguistic.actionpart.ActionPart <em>Action Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see reprotool.model.linguistic.actionpart.ActionPart
	 * @generated
	 */
	public Adapter createActionPartAdapter() {
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

} //ActionpartAdapterFactory
