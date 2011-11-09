/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.ling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.ling.LingPackage;
import reprotool.ling.SentenceNode;
import reprotool.ling.SentenceType;
import reprotool.ling.Word;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sentence Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.ling.impl.SentenceNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link reprotool.ling.impl.SentenceNodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link reprotool.ling.impl.SentenceNodeImpl#getWord <em>Word</em>}</li>
 *   <li>{@link reprotool.ling.impl.SentenceNodeImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SentenceNodeImpl extends EObjectImpl implements SentenceNode {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SentenceNode> children;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SentenceType TYPE_EDEFAULT = SentenceType.NOUN_PHRASE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SentenceType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWord() <em>Word</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWord()
	 * @generated
	 * @ordered
	 */
	protected Word word;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected SentenceNode parent;

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
		return LingPackage.Literals.SENTENCE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SentenceNode> getChildren() {
		if (children == null) {
			children = new EObjectResolvingEList<SentenceNode>(SentenceNode.class, this, LingPackage.SENTENCE_NODE__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SentenceType newType) {
		SentenceType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.SENTENCE_NODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word getWord() {
		if (word != null && word.eIsProxy()) {
			InternalEObject oldWord = (InternalEObject)word;
			word = (Word)eResolveProxy(oldWord);
			if (word != oldWord) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LingPackage.SENTENCE_NODE__WORD, oldWord, word));
			}
		}
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word basicGetWord() {
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWord(Word newWord) {
		Word oldWord = word;
		word = newWord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.SENTENCE_NODE__WORD, oldWord, word));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (SentenceNode)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LingPackage.SENTENCE_NODE__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(SentenceNode newParent) {
		SentenceNode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.SENTENCE_NODE__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LingPackage.SENTENCE_NODE__CHILDREN:
				return getChildren();
			case LingPackage.SENTENCE_NODE__TYPE:
				return getType();
			case LingPackage.SENTENCE_NODE__WORD:
				if (resolve) return getWord();
				return basicGetWord();
			case LingPackage.SENTENCE_NODE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
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
			case LingPackage.SENTENCE_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SentenceNode>)newValue);
				return;
			case LingPackage.SENTENCE_NODE__TYPE:
				setType((SentenceType)newValue);
				return;
			case LingPackage.SENTENCE_NODE__WORD:
				setWord((Word)newValue);
				return;
			case LingPackage.SENTENCE_NODE__PARENT:
				setParent((SentenceNode)newValue);
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
			case LingPackage.SENTENCE_NODE__CHILDREN:
				getChildren().clear();
				return;
			case LingPackage.SENTENCE_NODE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case LingPackage.SENTENCE_NODE__WORD:
				setWord((Word)null);
				return;
			case LingPackage.SENTENCE_NODE__PARENT:
				setParent((SentenceNode)null);
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
			case LingPackage.SENTENCE_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case LingPackage.SENTENCE_NODE__TYPE:
				return type != TYPE_EDEFAULT;
			case LingPackage.SENTENCE_NODE__WORD:
				return word != null;
			case LingPackage.SENTENCE_NODE__PARENT:
				return parent != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //SentenceNodeImpl
