/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.swproj.impl;

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

import reprotool.model.doc.Document;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.ConceptualObject;
import reprotool.model.swproj.Requirement;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.annotate.AnnotationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getSrsDocuments <em>Srs Documents</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getAnnotationSets <em>Annotation Sets</em>}</li>
 *   <li>{@link reprotool.model.swproj.impl.SoftwareProjectImpl#getConceptualObjects <em>Conceptual Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareProjectImpl extends EObjectImpl implements SoftwareProject {
	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> requirements;

	/**
	 * The cached value of the '{@link #getSrsDocuments() <em>Srs Documents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrsDocuments()
	 * @generated
	 * @ordered
	 */
	protected EList<Document> srsDocuments;

	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCases;

	/**
	 * The cached value of the '{@link #getAnnotationSets() <em>Annotation Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationSets()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationSet> annotationSets;

	/**
	 * The cached value of the '{@link #getConceptualObjects() <em>Conceptual Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptualObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptualObject> conceptualObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SwprojPackage.Literals.SOFTWARE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectContainmentEList<Actor>(Actor.class, this, SwprojPackage.SOFTWARE_PROJECT__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwprojPackage.SOFTWARE_PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwprojPackage.SOFTWARE_PROJECT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList<Requirement>(Requirement.class, this, SwprojPackage.SOFTWARE_PROJECT__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Document> getSrsDocuments() {
		if (srsDocuments == null) {
			srsDocuments = new EObjectResolvingEList<Document>(Document.class, this, SwprojPackage.SOFTWARE_PROJECT__SRS_DOCUMENTS);
		}
		return srsDocuments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectContainmentEList<UseCase>(UseCase.class, this, SwprojPackage.SOFTWARE_PROJECT__USE_CASES);
		}
		return useCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationSet> getAnnotationSets() {
		if (annotationSets == null) {
			annotationSets = new EObjectContainmentEList<AnnotationSet>(AnnotationSet.class, this, SwprojPackage.SOFTWARE_PROJECT__ANNOTATION_SETS);
		}
		return annotationSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptualObject> getConceptualObjects() {
		if (conceptualObjects == null) {
			conceptualObjects = new EObjectContainmentEList<ConceptualObject>(ConceptualObject.class, this, SwprojPackage.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS);
		}
		return conceptualObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SwprojPackage.SOFTWARE_PROJECT__ACTORS:
				return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
			case SwprojPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case SwprojPackage.SOFTWARE_PROJECT__USE_CASES:
				return ((InternalEList<?>)getUseCases()).basicRemove(otherEnd, msgs);
			case SwprojPackage.SOFTWARE_PROJECT__ANNOTATION_SETS:
				return ((InternalEList<?>)getAnnotationSets()).basicRemove(otherEnd, msgs);
			case SwprojPackage.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS:
				return ((InternalEList<?>)getConceptualObjects()).basicRemove(otherEnd, msgs);
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
			case SwprojPackage.SOFTWARE_PROJECT__ACTORS:
				return getActors();
			case SwprojPackage.SOFTWARE_PROJECT__NAME:
				return getName();
			case SwprojPackage.SOFTWARE_PROJECT__DESCRIPTION:
				return getDescription();
			case SwprojPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				return getRequirements();
			case SwprojPackage.SOFTWARE_PROJECT__SRS_DOCUMENTS:
				return getSrsDocuments();
			case SwprojPackage.SOFTWARE_PROJECT__USE_CASES:
				return getUseCases();
			case SwprojPackage.SOFTWARE_PROJECT__ANNOTATION_SETS:
				return getAnnotationSets();
			case SwprojPackage.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS:
				return getConceptualObjects();
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
			case SwprojPackage.SOFTWARE_PROJECT__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__NAME:
				setName((String)newValue);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__SRS_DOCUMENTS:
				getSrsDocuments().clear();
				getSrsDocuments().addAll((Collection<? extends Document>)newValue);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__USE_CASES:
				getUseCases().clear();
				getUseCases().addAll((Collection<? extends UseCase>)newValue);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__ANNOTATION_SETS:
				getAnnotationSets().clear();
				getAnnotationSets().addAll((Collection<? extends AnnotationSet>)newValue);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS:
				getConceptualObjects().clear();
				getConceptualObjects().addAll((Collection<? extends ConceptualObject>)newValue);
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
			case SwprojPackage.SOFTWARE_PROJECT__ACTORS:
				getActors().clear();
				return;
			case SwprojPackage.SOFTWARE_PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SwprojPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				getRequirements().clear();
				return;
			case SwprojPackage.SOFTWARE_PROJECT__SRS_DOCUMENTS:
				getSrsDocuments().clear();
				return;
			case SwprojPackage.SOFTWARE_PROJECT__USE_CASES:
				getUseCases().clear();
				return;
			case SwprojPackage.SOFTWARE_PROJECT__ANNOTATION_SETS:
				getAnnotationSets().clear();
				return;
			case SwprojPackage.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS:
				getConceptualObjects().clear();
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
			case SwprojPackage.SOFTWARE_PROJECT__ACTORS:
				return actors != null && !actors.isEmpty();
			case SwprojPackage.SOFTWARE_PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SwprojPackage.SOFTWARE_PROJECT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SwprojPackage.SOFTWARE_PROJECT__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case SwprojPackage.SOFTWARE_PROJECT__SRS_DOCUMENTS:
				return srsDocuments != null && !srsDocuments.isEmpty();
			case SwprojPackage.SOFTWARE_PROJECT__USE_CASES:
				return useCases != null && !useCases.isEmpty();
			case SwprojPackage.SOFTWARE_PROJECT__ANNOTATION_SETS:
				return annotationSets != null && !annotationSets.isEmpty();
			case SwprojPackage.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS:
				return conceptualObjects != null && !conceptualObjects.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //SoftwareProjectImpl
