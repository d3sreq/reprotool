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
 *   <li>{@link lts2.LTSGenerator#getGotoTransitions <em>Goto Transitions</em>}</li>
 *   <li>{@link lts2.LTSGenerator#getLabelTransitionSystem <em>Label Transition System</em>}</li>
 *   <li>{@link lts2.LTSGenerator#getStepToTransitionMap <em>Step To Transition Map</em>}</li>
 *   <li>{@link lts2.LTSGenerator#getRegisterExtClosure <em>Register Ext Closure</em>}</li>
 * </ul>
 * </p>
 *
 * @see lts2.Lts2Package#getLTSGenerator()
 * @model
 * @generated
 */
public interface LTSGenerator extends EObject {
	/**
	 * Returns the value of the '<em><b>Goto Transitions</b></em>' reference list.
	 * The list contents are of type {@link lts2.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * We can not process the goto steps while processing the scenario because at that time some goto targets may not be known yet.
	 * Thus we process the goto steps only after all steps have been visited.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Goto Transitions</em>' reference list.
	 * @see #isSetGotoTransitions()
	 * @see lts2.Lts2Package#getLTSGenerator_GotoTransitions()
	 * @model unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Transition> getGotoTransitions();

	/**
	 * Returns whether the value of the '{@link lts2.LTSGenerator#getGotoTransitions <em>Goto Transitions</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Goto Transitions</em>' reference list is set.
	 * @see #getGotoTransitions()
	 * @generated
	 */
	boolean isSetGotoTransitions();

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
	 * Returns the value of the '<em><b>Step To Transition Map</b></em>' map.
	 * The key is of type {@link reprotool.model.usecase.UseCaseStep},
	 * and the value is of type {@link lts2.Transition},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step To Transition Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step To Transition Map</em>' map.
	 * @see lts2.Lts2Package#getLTSGenerator_StepToTransitionMap()
	 * @model mapType="lts2.StepToTransitionMap<reprotool.model.usecase.UseCaseStep, lts2.Transition>" transient="true"
	 * @generated
	 */
	EMap<UseCaseStep, Transition> getStepToTransitionMap();

	/**
	 * Returns the value of the '<em><b>Register Ext Closure</b></em>' map.
	 * The key is of type {@link lts2.State},
	 * and the value is of type list of {@link lts2.State},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Register Ext Closure</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * I process the graph from upside down. That means whenever I process an
	 * extension, I cannot add to the LST the edge leading from the last state
	 * of the extension to the state following the extension. This is because
	 * the state following the extension has not yet been created - it will be
	 * created in the next iteration.
	 * 
	 * Therefore, whenever I finish an extension, I save the last state of that
	 * extension. Then in the next iteration, when the new state is already
	 * created I add the edge.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Register Ext Closure</em>' map.
	 * @see lts2.Lts2Package#getLTSGenerator_RegisterExtClosure()
	 * @model mapType="lts2.RegisterExtClosure<lts2.State, lts2.State>" transient="true"
	 * @generated
	 */
	EMap<State, EList<State>> getRegisterExtClosure();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void processUseCase(UseCase useCase);

} // LTSGenerator
