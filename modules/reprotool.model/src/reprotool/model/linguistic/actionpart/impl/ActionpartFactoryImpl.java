/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.actionpart.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reprotool.model.linguistic.actionpart.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionpartFactoryImpl extends EFactoryImpl implements ActionpartFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActionpartFactory init() {
		try {
			ActionpartFactory theActionpartFactory = (ActionpartFactory)EPackage.Registry.INSTANCE.getEFactory("http://d3s.mff.cuni.cz/reprotool/model/linguistic/actionpart"); 
			if (theActionpartFactory != null) {
				return theActionpartFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActionpartFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionpartFactoryImpl() {
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
			case ActionpartPackage.TEXT: return createText();
			case ActionpartPackage.SUBJECT: return createSubject();
			case ActionpartPackage.GOTO_TARGET: return createGotoTarget();
			case ActionpartPackage.VERB: return createVerb();
			case ActionpartPackage.REPRESENTATIVE_OBJECT: return createRepresentativeObject();
			case ActionpartPackage.INDIRECT_OBJECT: return createIndirectObject();
			case ActionpartPackage.USE_CASE_INCLUDE_PART: return createUseCaseIncludePart();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject createSubject() {
		SubjectImpl subject = new SubjectImpl();
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GotoTarget createGotoTarget() {
		GotoTargetImpl gotoTarget = new GotoTargetImpl();
		return gotoTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verb createVerb() {
		VerbImpl verb = new VerbImpl();
		return verb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentativeObject createRepresentativeObject() {
		RepresentativeObjectImpl representativeObject = new RepresentativeObjectImpl();
		return representativeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndirectObject createIndirectObject() {
		IndirectObjectImpl indirectObject = new IndirectObjectImpl();
		return indirectObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseIncludePart createUseCaseIncludePart() {
		UseCaseIncludePartImpl useCaseIncludePart = new UseCaseIncludePartImpl();
		return useCaseIncludePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionpartPackage getActionpartPackage() {
		return (ActionpartPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActionpartPackage getPackage() {
		return ActionpartPackage.eINSTANCE;
	}

} //ActionpartFactoryImpl
