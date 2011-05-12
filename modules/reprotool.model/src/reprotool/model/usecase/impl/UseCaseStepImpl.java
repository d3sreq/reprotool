/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.SentenceNode;

import reprotool.model.swproj.Requirement;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getRelatedRequirements <em>Related Requirements</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getVariation <em>Variation</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getParsedSentence <em>Parsed Sentence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseStepImpl extends EObjectImpl implements UseCaseStep {
	/**
	 * The cached value of the '{@link #getRelatedRequirements() <em>Related Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> relatedRequirements;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> extension;

	/**
	 * The cached value of the '{@link #getVariation() <em>Variation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariation()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> variation;

	/**
	 * The default value of the '{@link #getSentence() <em>Sentence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentence()
	 * @generated
	 * @ordered
	 */
	protected static final String SENTENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSentence() <em>Sentence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentence()
	 * @generated
	 * @ordered
	 */
	protected String sentence = SENTENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParsedSentence() <em>Parsed Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedSentence()
	 * @generated
	 * @ordered
	 */
	protected SentenceNode parsedSentence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.USE_CASE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRelatedRequirements() {
		if (relatedRequirements == null) {
			relatedRequirements = new EObjectResolvingEList<Requirement>(Requirement.class, this, UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS);
		}
		return relatedRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getExtension() {
		if (extension == null) {
			extension = new EObjectContainmentEList<Scenario>(Scenario.class, this, UsecasePackage.USE_CASE_STEP__EXTENSION);
		}
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getVariation() {
		if (variation == null) {
			variation = new EObjectContainmentEList<Scenario>(Scenario.class, this, UsecasePackage.USE_CASE_STEP__VARIATION);
		}
		return variation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSentence() {
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentence(String newSentence) {
		String oldSentence = sentence;
		sentence = newSentence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__SENTENCE, oldSentence, sentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode getParsedSentence() {
		if (parsedSentence != null && parsedSentence.eIsProxy()) {
			InternalEObject oldParsedSentence = (InternalEObject)parsedSentence;
			parsedSentence = (SentenceNode)eResolveProxy(oldParsedSentence);
			if (parsedSentence != oldParsedSentence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE, oldParsedSentence, parsedSentence));
			}
		}
		return parsedSentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode basicGetParsedSentence() {
		return parsedSentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParsedSentence(SentenceNode newParsedSentence) {
		SentenceNode oldParsedSentence = parsedSentence;
		parsedSentence = newParsedSentence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE, oldParsedSentence, parsedSentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.USE_CASE_STEP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__VARIATION:
				return ((InternalEList<?>)getVariation()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				return getRelatedRequirements();
			case UsecasePackage.USE_CASE_STEP__EXTENSION:
				return getExtension();
			case UsecasePackage.USE_CASE_STEP__VARIATION:
				return getVariation();
			case UsecasePackage.USE_CASE_STEP__SENTENCE:
				return getSentence();
			case UsecasePackage.USE_CASE_STEP__LABEL:
				return getLabel();
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				if (resolve) return getParsedSentence();
				return basicGetParsedSentence();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				getRelatedRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends Scenario>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__VARIATION:
				getVariation().clear();
				getVariation().addAll((Collection<? extends Scenario>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__SENTENCE:
				setSentence((String)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__LABEL:
				setLabel((String)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				setParsedSentence((SentenceNode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				getRelatedRequirements().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__EXTENSION:
				getExtension().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__VARIATION:
				getVariation().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__SENTENCE:
				setSentence(SENTENCE_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE_STEP__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				setParsedSentence((SentenceNode)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UsecasePackage.USE_CASE_STEP__RELATED_REQUIREMENTS:
				return relatedRequirements != null && !relatedRequirements.isEmpty();
			case UsecasePackage.USE_CASE_STEP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case UsecasePackage.USE_CASE_STEP__VARIATION:
				return variation != null && !variation.isEmpty();
			case UsecasePackage.USE_CASE_STEP__SENTENCE:
				return SENTENCE_EDEFAULT == null ? sentence != null : !SENTENCE_EDEFAULT.equals(sentence);
			case UsecasePackage.USE_CASE_STEP__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				return parsedSentence != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Sentence: ");
		result.append(sentence);
		result.append(", Label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //UseCaseStepImpl
