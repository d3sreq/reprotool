/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.LinguisticPackage;
import reprotool.model.linguistic.ParseNode;
import reprotool.model.linguistic.PrepositionalPhraseNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prepositional Phrase Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.impl.PrepositionalPhraseNodeImpl#getChildNodes <em>Child Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrepositionalPhraseNodeImpl extends EObjectImpl implements PrepositionalPhraseNode {
	/**
	 * The cached value of the '{@link #getChildNodes() <em>Child Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ParseNode> childNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrepositionalPhraseNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinguisticPackage.Literals.PREPOSITIONAL_PHRASE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParseNode> getChildNodes() {
		if (childNodes == null) {
			childNodes = new EObjectContainmentEList<ParseNode>(ParseNode.class, this, LinguisticPackage.PREPOSITIONAL_PHRASE_NODE__CHILD_NODES);
		}
		return childNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LinguisticPackage.PREPOSITIONAL_PHRASE_NODE__CHILD_NODES:
				return ((InternalEList<?>)getChildNodes()).basicRemove(otherEnd, msgs);
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
			case LinguisticPackage.PREPOSITIONAL_PHRASE_NODE__CHILD_NODES:
				return getChildNodes();
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
			case LinguisticPackage.PREPOSITIONAL_PHRASE_NODE__CHILD_NODES:
				getChildNodes().clear();
				getChildNodes().addAll((Collection<? extends ParseNode>)newValue);
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
			case LinguisticPackage.PREPOSITIONAL_PHRASE_NODE__CHILD_NODES:
				getChildNodes().clear();
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
			case LinguisticPackage.PREPOSITIONAL_PHRASE_NODE__CHILD_NODES:
				return childNodes != null && !childNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PrepositionalPhraseNodeImpl
