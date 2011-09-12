/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.linguistic.parsetree.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.model.linguistic.parsetree.InnerParseNode;
import reprotool.model.linguistic.parsetree.ParseNode;
import reprotool.model.linguistic.parsetree.ParsetreePackage;
import reprotool.model.linguistic.parsetree.SentenceNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sentence Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.model.linguistic.parsetree.impl.SentenceNodeImpl#getChildNodes <em>Child Nodes</em>}</li>
 *   <li>{@link reprotool.model.linguistic.parsetree.impl.SentenceNodeImpl#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SentenceNodeImpl extends EObjectImpl implements SentenceNode {
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
	 * The cached value of the '{@link #getParentNode() <em>Parent Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentNode()
	 * @generated
	 * @ordered
	 */
	protected InnerParseNode parentNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SentenceNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParsetreePackage.Literals.SENTENCE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParseNode> getChildNodes() {
		if (childNodes == null) {
			childNodes = new EObjectContainmentEList<ParseNode>(ParseNode.class, this, ParsetreePackage.SENTENCE_NODE__CHILD_NODES);
		}
		return childNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InnerParseNode getParentNode() {
		return parentNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentNode(InnerParseNode newParentNode, NotificationChain msgs) {
		InnerParseNode oldParentNode = parentNode;
		parentNode = newParentNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParsetreePackage.SENTENCE_NODE__PARENT_NODE, oldParentNode, newParentNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentNode(InnerParseNode newParentNode) {
		if (newParentNode != parentNode) {
			NotificationChain msgs = null;
			if (parentNode != null)
				msgs = ((InternalEObject)parentNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParsetreePackage.SENTENCE_NODE__PARENT_NODE, null, msgs);
			if (newParentNode != null)
				msgs = ((InternalEObject)newParentNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParsetreePackage.SENTENCE_NODE__PARENT_NODE, null, msgs);
			msgs = basicSetParentNode(newParentNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.SENTENCE_NODE__PARENT_NODE, newParentNode, newParentNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsetreePackage.SENTENCE_NODE__CHILD_NODES:
				return ((InternalEList<?>)getChildNodes()).basicRemove(otherEnd, msgs);
			case ParsetreePackage.SENTENCE_NODE__PARENT_NODE:
				return basicSetParentNode(null, msgs);
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
			case ParsetreePackage.SENTENCE_NODE__CHILD_NODES:
				return getChildNodes();
			case ParsetreePackage.SENTENCE_NODE__PARENT_NODE:
				return getParentNode();
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
			case ParsetreePackage.SENTENCE_NODE__CHILD_NODES:
				getChildNodes().clear();
				getChildNodes().addAll((Collection<? extends ParseNode>)newValue);
				return;
			case ParsetreePackage.SENTENCE_NODE__PARENT_NODE:
				setParentNode((InnerParseNode)newValue);
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
			case ParsetreePackage.SENTENCE_NODE__CHILD_NODES:
				getChildNodes().clear();
				return;
			case ParsetreePackage.SENTENCE_NODE__PARENT_NODE:
				setParentNode((InnerParseNode)null);
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
			case ParsetreePackage.SENTENCE_NODE__CHILD_NODES:
				return childNodes != null && !childNodes.isEmpty();
			case ParsetreePackage.SENTENCE_NODE__PARENT_NODE:
				return parentNode != null;
		}
		return super.eIsSet(featureID);
	}

} //SentenceNodeImpl
