/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.common.util.EList;

import reprotool.model.linguistic.SentenceNode;

import reprotool.model.linguistic.SentencePart;
import reprotool.model.swproj.ReqCover;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getExtension <em>Extension</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getVariation <em>Variation</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getParsedSentence <em>Parsed Sentence</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getID <em>ID</em>}</li>
 *   <li>{@link reprotool.model.usecase.UseCaseStep#getSentenceNodes <em>Sentence Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep()
 * @model
 * @generated
 */
public interface UseCaseStep extends ReqCover {
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_Extension()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario> getExtension();

	/**
	 * Returns the value of the '<em><b>Variation</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.usecase.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_Variation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario> getVariation();

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
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_Sentence()
	 * @model
	 * @generated
	 */
	String getSentence();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.UseCaseStep#getSentence <em>Sentence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence</em>' attribute.
	 * @see #getSentence()
	 * @generated
	 */
	void setSentence(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>Parsed Sentence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parsed Sentence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parsed Sentence</em>' containment reference.
	 * @see #setParsedSentence(SentenceNode)
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_ParsedSentence()
	 * @model containment="true"
	 * @generated
	 */
	SentenceNode getParsedSentence();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.UseCaseStep#getParsedSentence <em>Parsed Sentence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parsed Sentence</em>' containment reference.
	 * @see #getParsedSentence()
	 * @generated
	 */
	void setParsedSentence(SentenceNode value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_ID()
	 * @model id="true"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link reprotool.model.usecase.UseCaseStep#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Sentence Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.linguistic.SentencePart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentence Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentence Nodes</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getUseCaseStep_SentenceNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SentencePart> getSentenceNodes();

} // UseCaseStep
