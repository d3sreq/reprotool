/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification;

import org.eclipse.emf.common.util.EList;

import reprotool.model.linguistic.SentenceNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getVariations <em>Variations</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getNextStep <em>Next Step</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getLabel <em>Label</em>}</li>
 *   <li>{@link reprotool.model.specification.UseCaseStep#getParsedSentence <em>Parsed Sentence</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep()
 * @model
 * @generated
 */
public interface UseCaseStep extends ReqCover {
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.specification.UseCaseStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCaseStep> getExtensions();

	/**
	 * Returns the value of the '<em><b>Variations</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.specification.UseCaseStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variations</em>' containment reference list.
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_Variations()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCaseStep> getVariations();

	/**
	 * Returns the value of the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sentence</em>' attribute.
	 * @see #setSentence(String)
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_Sentence()
	 * @model
	 * @generated
	 */
	String getSentence();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.UseCaseStep#getSentence <em>Sentence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence</em>' attribute.
	 * @see #getSentence()
	 * @generated
	 */
	void setSentence(String value);

	/**
	 * Returns the value of the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Step</em>' reference.
	 * @see #setNextStep(UseCaseStep)
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_NextStep()
	 * @model
	 * @generated
	 */
	UseCaseStep getNextStep();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.UseCaseStep#getNextStep <em>Next Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Step</em>' reference.
	 * @see #getNextStep()
	 * @generated
	 */
	void setNextStep(UseCaseStep value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.UseCaseStep#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Parsed Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parsed Sentence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parsed Sentence</em>' reference.
	 * @see #setParsedSentence(SentenceNode)
	 * @see reprotool.model.specification.SpecificationPackage#getUseCaseStep_ParsedSentence()
	 * @model
	 * @generated
	 */
	SentenceNode getParsedSentence();

	/**
	 * Sets the value of the '{@link reprotool.model.specification.UseCaseStep#getParsedSentence <em>Parsed Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parsed Sentence</em>' reference.
	 * @see #getParsedSentence()
	 * @generated
	 */
	void setParsedSentence(SentenceNode value);

} // UseCaseStep
