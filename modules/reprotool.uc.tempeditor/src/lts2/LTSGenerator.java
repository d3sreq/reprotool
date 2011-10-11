/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lts2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LTS Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link lts2.LTSGenerator#getLabelTransitionSystem <em>Label Transition System</em>}</li>
 * </ul>
 * </p>
 *
 * @see lts2.Lts2Package#getLTSGenerator()
 * @model
 * @generated
 */
public interface LTSGenerator extends EObject {
	/**
	 * Returns the value of the '<em><b>Label Transition System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Transition System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Transition System</em>' containment reference.
	 * @see lts2.Lts2Package#getLTSGenerator_LabelTransitionSystem()
	 * @model containment="true" required="true" changeable="false"
	 * @generated
	 */
	StateMachine getLabelTransitionSystem();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void processUseCase(UseCase useCase);

} // LTSGenerator
