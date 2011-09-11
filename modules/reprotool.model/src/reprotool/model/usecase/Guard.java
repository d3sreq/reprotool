/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import reprotool.model.usecase.annotate.StepAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.Guard#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.usecase.Guard#getScenario <em>Scenario</em>}</li>
 *   <li>{@link reprotool.model.usecase.Guard#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.UsecasePackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends EObject {
	/**
	 * Returns the value of the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentence</em>' attribute.
	 * @see #setSentence(String)
	 * @see reprotool.model.usecase.UsecasePackage#getGuard_Sentence()
	 * @model
	 * @generated
	 */
	String getSentence();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.Guard#getSentence <em>Sentence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence</em>' attribute.
	 * @see #getSentence()
	 * @generated
	 */
	void setSentence(String value);

	/**
	 * Returns the value of the '<em><b>Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario</em>' containment reference.
	 * @see #setScenario(Scenario)
	 * @see reprotool.model.usecase.UsecasePackage#getGuard_Scenario()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Scenario getScenario();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.Guard#getScenario <em>Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario</em>' containment reference.
	 * @see #getScenario()
	 * @generated
	 */
	void setScenario(Scenario value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.annotate.StepAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getGuard_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<StepAnnotation> getAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getLabel();

} // Guard
