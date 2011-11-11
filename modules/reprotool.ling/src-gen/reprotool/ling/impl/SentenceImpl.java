/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.ling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import reprotool.ling.LingPackage;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sentence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.ling.impl.SentenceImpl#getWords <em>Words</em>}</li>
 *   <li>{@link reprotool.ling.impl.SentenceImpl#getSentenceTree <em>Sentence Tree</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SentenceImpl extends EObjectImpl implements Sentence
{
	/**
	 * The cached value of the '{@link #getWords() <em>Words</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWords()
	 * @generated
	 * @ordered
	 */
	protected EList<Word> words;

	/**
	 * The cached value of the '{@link #getSentenceTree() <em>Sentence Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentenceTree()
	 * @generated
	 * @ordered
	 */
	protected SentenceNode sentenceTree;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SentenceImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return LingPackage.Literals.SENTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Word> getWords()
	{
		if (words == null)
		{
			words = new EObjectResolvingEList<Word>(Word.class, this, LingPackage.SENTENCE__WORDS);
		}
		return words;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceNode getSentenceTree()
	{
		return sentenceTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSentenceTree(SentenceNode newSentenceTree, NotificationChain msgs)
	{
		SentenceNode oldSentenceTree = sentenceTree;
		sentenceTree = newSentenceTree;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LingPackage.SENTENCE__SENTENCE_TREE, oldSentenceTree, newSentenceTree);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentenceTree(SentenceNode newSentenceTree)
	{
		if (newSentenceTree != sentenceTree)
		{
			NotificationChain msgs = null;
			if (sentenceTree != null)
				msgs = ((InternalEObject)sentenceTree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LingPackage.SENTENCE__SENTENCE_TREE, null, msgs);
			if (newSentenceTree != null)
				msgs = ((InternalEObject)newSentenceTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LingPackage.SENTENCE__SENTENCE_TREE, null, msgs);
			msgs = basicSetSentenceTree(newSentenceTree, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.SENTENCE__SENTENCE_TREE, newSentenceTree, newSentenceTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case LingPackage.SENTENCE__SENTENCE_TREE:
				return basicSetSentenceTree(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case LingPackage.SENTENCE__WORDS:
				return getWords();
			case LingPackage.SENTENCE__SENTENCE_TREE:
				return getSentenceTree();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case LingPackage.SENTENCE__WORDS:
				getWords().clear();
				getWords().addAll((Collection<? extends Word>)newValue);
				return;
			case LingPackage.SENTENCE__SENTENCE_TREE:
				setSentenceTree((SentenceNode)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case LingPackage.SENTENCE__WORDS:
				getWords().clear();
				return;
			case LingPackage.SENTENCE__SENTENCE_TREE:
				setSentenceTree((SentenceNode)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case LingPackage.SENTENCE__WORDS:
				return words != null && !words.isEmpty();
			case LingPackage.SENTENCE__SENTENCE_TREE:
				return sentenceTree != null;
		}
		return super.eIsSet(featureID);
	}

} //SentenceImpl
