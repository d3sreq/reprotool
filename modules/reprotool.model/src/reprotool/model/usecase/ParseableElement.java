/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase;

import org.eclipse.emf.common.util.EList;

import reprotool.model.linguistic.actionpart.Text;

import reprotool.model.swproj.ReqCover;

import reprotool.model.usecase.annotate.StepAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parseable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link reprotool.model.usecase.ParseableElement#getTextNodes <em>Text Nodes</em>}</li>
 *   <li>{@link reprotool.model.usecase.ParseableElement#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link reprotool.model.usecase.ParseableElement#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see reprotool.model.usecase.UsecasePackage#getParseableElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ParseableElement extends ReqCover {
	/**
	 * Returns the value of the '<em><b>Text Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link reprotool.model.linguistic.actionpart.Text}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Nodes</em>' containment reference list.
	 * @see reprotool.model.usecase.UsecasePackage#getParseableElement_TextNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Text> getTextNodes();

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
	 * @see reprotool.model.usecase.UsecasePackage#getParseableElement_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<StepAnnotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see reprotool.model.usecase.UsecasePackage#getParseableElement_Label()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getLabel();

} // ParseableElement
