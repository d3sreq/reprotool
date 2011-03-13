/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.comp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see reprotool.model.comp.ICompFactory
 * @model kind="package"
 * @generated
 */
public interface ICompPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "comp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://d3s.mff.cuni.cz/reprotool/model/comp";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "comp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ICompPackage eINSTANCE = reprotool.model.comp.impl.CompPackage.init();

	/**
	 * The meta object id for the '{@link reprotool.model.comp.impl.Component <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.comp.impl.Component
	 * @see reprotool.model.comp.impl.CompPackage#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Provided Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROVIDED_INTERFACES = 0;

	/**
	 * The feature id for the '<em><b>Required Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REQUIRED_INTERFACES = 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link reprotool.model.comp.impl.CompInterface <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.comp.impl.CompInterface
	 * @see reprotool.model.comp.impl.CompPackage#getCompInterface()
	 * @generated
	 */
	int COMP_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Interface Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMP_INTERFACE__INTERFACE_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMP_INTERFACE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link reprotool.model.comp.impl.CompInterfaceType <em>Interface Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see reprotool.model.comp.impl.CompInterfaceType
	 * @see reprotool.model.comp.impl.CompPackage#getCompInterfaceType()
	 * @generated
	 */
	int COMP_INTERFACE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMP_INTERFACE_TYPE__SIGNATURE = 0;

	/**
	 * The number of structural features of the '<em>Interface Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMP_INTERFACE_TYPE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link reprotool.model.comp.IComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see reprotool.model.comp.IComponent
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.comp.IComponent#getProvidedInterfaces <em>Provided Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provided Interfaces</em>'.
	 * @see reprotool.model.comp.IComponent#getProvidedInterfaces()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ProvidedInterfaces();

	/**
	 * Returns the meta object for the reference list '{@link reprotool.model.comp.IComponent#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Interfaces</em>'.
	 * @see reprotool.model.comp.IComponent#getRequiredInterfaces()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_RequiredInterfaces();

	/**
	 * Returns the meta object for class '{@link reprotool.model.comp.ICompInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see reprotool.model.comp.ICompInterface
	 * @generated
	 */
	EClass getCompInterface();

	/**
	 * Returns the meta object for the reference '{@link reprotool.model.comp.ICompInterface#getInterfaceType <em>Interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interface Type</em>'.
	 * @see reprotool.model.comp.ICompInterface#getInterfaceType()
	 * @see #getCompInterface()
	 * @generated
	 */
	EReference getCompInterface_InterfaceType();

	/**
	 * Returns the meta object for class '{@link reprotool.model.comp.ICompInterfaceType <em>Interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Type</em>'.
	 * @see reprotool.model.comp.ICompInterfaceType
	 * @generated
	 */
	EClass getCompInterfaceType();

	/**
	 * Returns the meta object for the attribute '{@link reprotool.model.comp.ICompInterfaceType#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signature</em>'.
	 * @see reprotool.model.comp.ICompInterfaceType#getSignature()
	 * @see #getCompInterfaceType()
	 * @generated
	 */
	EAttribute getCompInterfaceType_Signature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ICompFactory getCompFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link reprotool.model.comp.impl.Component <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.comp.impl.Component
		 * @see reprotool.model.comp.impl.CompPackage#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Provided Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PROVIDED_INTERFACES = eINSTANCE.getComponent_ProvidedInterfaces();

		/**
		 * The meta object literal for the '<em><b>Required Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__REQUIRED_INTERFACES = eINSTANCE.getComponent_RequiredInterfaces();

		/**
		 * The meta object literal for the '{@link reprotool.model.comp.impl.CompInterface <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.comp.impl.CompInterface
		 * @see reprotool.model.comp.impl.CompPackage#getCompInterface()
		 * @generated
		 */
		EClass COMP_INTERFACE = eINSTANCE.getCompInterface();

		/**
		 * The meta object literal for the '<em><b>Interface Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMP_INTERFACE__INTERFACE_TYPE = eINSTANCE.getCompInterface_InterfaceType();

		/**
		 * The meta object literal for the '{@link reprotool.model.comp.impl.CompInterfaceType <em>Interface Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see reprotool.model.comp.impl.CompInterfaceType
		 * @see reprotool.model.comp.impl.CompPackage#getCompInterfaceType()
		 * @generated
		 */
		EClass COMP_INTERFACE_TYPE = eINSTANCE.getCompInterfaceType();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMP_INTERFACE_TYPE__SIGNATURE = eINSTANCE.getCompInterfaceType_Signature();

	}

} //ICompPackage
