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

import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.linguistic.parsetree.SentenceNode;
import reprotool.model.swproj.Requirement;
import reprotool.model.usecase.Guard;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;
import reprotool.model.usecase.annotate.StepAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getRelatedRequirements <em>Related Requirements</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getParsedSentence <em>Parsed Sentence</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getSentenceNodes <em>Sentence Nodes</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getVariations <em>Variations</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getAction <em>Action</em>}</li>
 *   <li>{@link reprotool.model.usecase.impl.UseCaseStepImpl#getAnnotations <em>Annotations</em>}</li>
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
	 * The cached value of the '{@link #getParsedSentence() <em>Parsed Sentence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParsedSentence()
	 * @generated
	 * @ordered
	 */
	protected SentenceNode parsedSentence;

	/**
	 * The cached value of the '{@link #getSentenceNodes() <em>Sentence Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentenceNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Text> sentenceNodes;

	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Guard> extensions;

	/**
	 * The cached value of the '{@link #getVariations() <em>Variations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<Guard> variations;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<StepAnnotation> annotations;

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
	 * @generated NOT
	 */
	public String getLabel() {
		return getLabel(this);
	}
	
	/** @generated NOT */
	private String getLabel(EObject item) {
//		if (item.eContainer() instanceof UseCase) {
//			return "";
//		}
//		
//		StringBuffer s = new StringBuffer(getLabel(item.eContainer()));
//		
//		if (item instanceof Scenario) {
//			UseCaseStep parent = (UseCaseStep)item.eContainer();
//			int idx;
//			if (parent.getvagetVariation().contains(item)) {
//				idx = parent.getVariation().indexOf(item);
//			}
//			else {
//				idx = parent.getVariation().size() + parent.getExtension().indexOf(item);
//			}
//			s.append((char)('a' + idx));
//		} else if (item instanceof UseCaseStep) {
//			Scenario parent = (Scenario)item.eContainer();
//			int idx = parent.getSteps().indexOf(item);
//			
//			if (idx != 0 || parent.eContainer() instanceof UseCase) {
//				s.append(idx + 1);
//			}
//		}
//		return s.toString();
		return "";
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
	public EList<Text> getSentenceNodes() {
		if (sentenceNodes == null) {
			sentenceNodes = new EObjectContainmentEList<Text>(Text.class, this, UsecasePackage.USE_CASE_STEP__SENTENCE_NODES);
		}
		return sentenceNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Guard> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Guard>(Guard.class, this, UsecasePackage.USE_CASE_STEP__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Guard> getVariations() {
		if (variations == null) {
			variations = new EObjectContainmentEList<Guard>(Guard.class, this, UsecasePackage.USE_CASE_STEP__VARIATIONS);
		}
		return variations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAction(Action newAction, NotificationChain msgs) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__ACTION, oldAction, newAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		if (newAction != action) {
			NotificationChain msgs = null;
			if (action != null)
				msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE_STEP__ACTION, null, msgs);
			if (newAction != null)
				msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsecasePackage.USE_CASE_STEP__ACTION, null, msgs);
			msgs = basicSetAction(newAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USE_CASE_STEP__ACTION, newAction, newAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StepAnnotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<StepAnnotation>(StepAnnotation.class, this, UsecasePackage.USE_CASE_STEP__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				return basicSetParsedSentence(null, msgs);
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				return ((InternalEList<?>)getSentenceNodes()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				return ((InternalEList<?>)getVariations()).basicRemove(otherEnd, msgs);
			case UsecasePackage.USE_CASE_STEP__ACTION:
				return basicSetAction(null, msgs);
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				return getParsedSentence();
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				return getSentenceNodes();
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				return getExtensions();
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				return getVariations();
			case UsecasePackage.USE_CASE_STEP__ACTION:
				return getAction();
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				return getAnnotations();
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				setParsedSentence((SentenceNode)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				getSentenceNodes().clear();
				getSentenceNodes().addAll((Collection<? extends Text>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Guard>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				getVariations().addAll((Collection<? extends Guard>)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__ACTION:
				setAction((Action)newValue);
				return;
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends StepAnnotation>)newValue);
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				setParsedSentence((SentenceNode)null);
				return;
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				getSentenceNodes().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				getExtensions().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				getVariations().clear();
				return;
			case UsecasePackage.USE_CASE_STEP__ACTION:
				setAction((Action)null);
				return;
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				getAnnotations().clear();
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
			case UsecasePackage.USE_CASE_STEP__PARSED_SENTENCE:
				return parsedSentence != null;
			case UsecasePackage.USE_CASE_STEP__SENTENCE_NODES:
				return sentenceNodes != null && !sentenceNodes.isEmpty();
			case UsecasePackage.USE_CASE_STEP__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case UsecasePackage.USE_CASE_STEP__VARIATIONS:
				return variations != null && !variations.isEmpty();
			case UsecasePackage.USE_CASE_STEP__ACTION:
				return action != null;
			case UsecasePackage.USE_CASE_STEP__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UseCaseStepImpl
