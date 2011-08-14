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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.SentenceNode;
import reprotool.model.linguistic.SentencePart;
import reprotool.model.swproj.Requirement;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
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
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getParsedSentence <em>Parsed Sentence</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getID <em>ID</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getSentenceNodes <em>Sentence Nodes</em>}</li>
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
	 * The cached value of the '{@link #getParsedSentence() <em>Parsed Sentence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedSentence()
	 * @generated
	 * @ordered
	 */
	protected SentenceNode parsedSentence;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSentenceNodes() <em>Sentence Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentenceNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SentencePart> sentenceNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected UseCaseStepImpl() {
		super();
		setID(EcoreUtil.generateUUID());
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
	 * @generated NOT
	 */
	public String getSentence() {
		if (getSentenceNodes().isEmpty())
			return sentence;
		StringBuffer s = new StringBuffer();
		for (SentencePart p : getSentenceNodes()) {
			s.append(p.getContent());
			s.append(' ');
		}
		s.deleteCharAt(s.length()-1);
		return s.toString();
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
	 * @generated NOT
	 */
	public String getLabel() {
		return getLabel(this);
	}
	
	/** @generated NOT */
	private String getLabel(EObject item) {
		if (item.eContainer() instanceof UseCase)
			return "";
		StringBuffer s = new StringBuffer(getLabel(item.eContainer()));
		if (item instanceof Scenario) {
			UseCaseStep parent = (UseCaseStep)item.eContainer();
			int idx;
			if (parent.getVariation().contains(item))
				idx = parent.getVariation().indexOf(item);
			else
				idx = parent.getVariation().size() + parent.getExtension().indexOf(item);
			s.append((char)('a'+idx));
		} else if (item instanceof UseCaseStep) {
			Scenario parent = (Scenario)item.eContainer();
			int idx = parent.getSteps().indexOf(item);
			if (idx != 0 || parent.eContainer() instanceof UseCase)
				s.append(idx+1);
		}
		return s.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode getParsedSentence() {
		return parsedSentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParsedSentence(SentenceNode newParsedSentence, NotificationChain msgs) {
		SentenceNode oldParsedSentence = parsedSentence;
		parsedSentence = newParsedSentence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE, oldParsedSentence, newParsedSentence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParsedSentence(SentenceNode newParsedSentence) {
		if (newParsedSentence != parsedSentence) {
			NotificationChain msgs = null;
			if (parsedSentence != null)
				msgs = ((InternalEObject)parsedSentence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE, null, msgs);
			if (newParsedSentence != null)
				msgs = ((InternalEObject)newParsedSentence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE, null, msgs);
			msgs = basicSetParsedSentence(newParsedSentence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE, newParsedSentence, newParsedSentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		String oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SentencePart> getSentenceNodes() {
		if (sentenceNodes == null) {
			sentenceNodes = new EObjectContainmentEList<SentencePart>(SentencePart.class, this, UsecasePackage.USE_CASE_STEP__SENTENCE_NODES);
		}
		return sentenceNodes;
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				return basicSetParsedSentence(null, msgs);
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				return ((InternalEList<?>)getSentenceNodes()).basicRemove(otherEnd, msgs);
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				return getParsedSentence();
			case UsecasePackage.USE_CASE_STEP__ID:
				return getID();
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				return getSentenceNodes();
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				setParsedSentence((SentenceNode)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__ID:
				setID((String)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				getSentenceNodes().clear();
				getSentenceNodes().addAll((Collection<? extends SentencePart>)newValue);
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				setParsedSentence((SentenceNode)null);
				return;
			case UsecasePackage.USE_CASE_STEP__ID:
				setID(ID_EDEFAULT);
				return;
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				getSentenceNodes().clear();
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				return parsedSentence != null;
			case UsecasePackage.USE_CASE_STEP__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				return sentenceNodes != null && !sentenceNodes.isEmpty();
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
		result.append(", ID: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //UseCaseStepImpl
