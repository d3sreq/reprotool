/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.specification.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.SentenceNode;

import reprotool.model.specification.SpecificationPackage;
import reprotool.model.specification.UseCaseStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getVariations <em>Variations</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getSentence <em>Sentence</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getNextStep <em>Next Step</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link reprotool.model.specification.impl.UseCaseStepImpl#getParsedSentence <em>Parsed Sentence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseStepImpl extends ReqCoverImpl implements UseCaseStep {
	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCaseStep> extensions;

	/**
	 * The cached value of the '{@link #getVariations() <em>Variations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCaseStep> variations;

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
	 * The cached value of the '{@link #getNextStep() <em>Next Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextStep()
	 * @generated
	 * @ordered
	 */
	protected UseCaseStep nextStep;

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
		return SpecificationPackage.Literals.USE_CASE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCaseStep> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<UseCaseStep>(UseCaseStep.class, this, SpecificationPackage.USE_CASE_STEP__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCaseStep> getVariations() {
		if (variations == null) {
			variations = new EObjectContainmentEList<UseCaseStep>(UseCaseStep.class, this, SpecificationPackage.USE_CASE_STEP__VARIATIONS);
		}
		return variations;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.USE_CASE_STEP__SENTENCE, oldSentence, sentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep getNextStep() {
		if (nextStep != null && nextStep.eIsProxy()) {
			InternalEObject oldNextStep = (InternalEObject)nextStep;
			nextStep = (UseCaseStep)eResolveProxy(oldNextStep);
			if (nextStep != oldNextStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpecificationPackage.USE_CASE_STEP__NEXT_STEP, oldNextStep, nextStep));
			}
		}
		return nextStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseStep basicGetNextStep() {
		return nextStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextStep(UseCaseStep newNextStep) {
		UseCaseStep oldNextStep = nextStep;
		nextStep = newNextStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.USE_CASE_STEP__NEXT_STEP, oldNextStep, nextStep));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.USE_CASE_STEP__LABEL, oldLabel, label));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpecificationPackage.USE_CASE_STEP__PARSED_SENTENCE, oldParsedSentence, parsedSentence));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpecificationPackage.USE_CASE_STEP__PARSED_SENTENCE, oldParsedSentence, parsedSentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				return ((InternalEList<?>)getVariations()).basicRemove(otherEnd, msgs);
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				return getExtensions();
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				return getVariations();
			case SpecificationPackage.USE_CASE_STEP__SENTENCE:
				return getSentence();
			case SpecificationPackage.USE_CASE_STEP__NEXT_STEP:
				if (resolve) return getNextStep();
				return basicGetNextStep();
			case SpecificationPackage.USE_CASE_STEP__LABEL:
				return getLabel();
			case SpecificationPackage.USE_CASE_STEP__PARSED_SENTENCE:
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends UseCaseStep>)newValue);
				return;
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				getVariations().addAll((Collection<? extends UseCaseStep>)newValue);
				return;
			case SpecificationPackage.USE_CASE_STEP__SENTENCE:
				setSentence((String)newValue);
				return;
			case SpecificationPackage.USE_CASE_STEP__NEXT_STEP:
				setNextStep((UseCaseStep)newValue);
				return;
			case SpecificationPackage.USE_CASE_STEP__LABEL:
				setLabel((String)newValue);
				return;
			case SpecificationPackage.USE_CASE_STEP__PARSED_SENTENCE:
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				return;
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				return;
			case SpecificationPackage.USE_CASE_STEP__SENTENCE:
				setSentence(SENTENCE_EDEFAULT);
				return;
			case SpecificationPackage.USE_CASE_STEP__NEXT_STEP:
				setNextStep((UseCaseStep)null);
				return;
			case SpecificationPackage.USE_CASE_STEP__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case SpecificationPackage.USE_CASE_STEP__PARSED_SENTENCE:
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
			case SpecificationPackage.USE_CASE_STEP__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case SpecificationPackage.USE_CASE_STEP__VARIATIONS:
				return variations != null && !variations.isEmpty();
			case SpecificationPackage.USE_CASE_STEP__SENTENCE:
				return SENTENCE_EDEFAULT == null ? sentence != null : !SENTENCE_EDEFAULT.equals(sentence);
			case SpecificationPackage.USE_CASE_STEP__NEXT_STEP:
				return nextStep != null;
			case SpecificationPackage.USE_CASE_STEP__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case SpecificationPackage.USE_CASE_STEP__PARSED_SENTENCE:
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
