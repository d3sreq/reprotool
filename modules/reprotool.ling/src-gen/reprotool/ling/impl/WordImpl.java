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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.ling.LingPackage;
import reprotool.ling.POSType;
import reprotool.ling.ParseTreeNode;
import reprotool.ling.Word;
import reprotool.ling.WordType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.ling.impl.WordImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getText <em>Text</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getLemma <em>Lemma</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getPOS <em>POS</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getID <em>ID</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#getType <em>Type</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#isInterpunction <em>Interpunction</em>}</li>
 *   <li>{@link reprotool.ling.impl.WordImpl#isNumeral <em>Numeral</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WordImpl extends EObjectImpl implements Word
{
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected ParseTreeNode parent;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ParseTreeNode> children;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLemma() <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemma()
	 * @generated
	 * @ordered
	 */
	protected static final String LEMMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLemma() <em>Lemma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLemma()
	 * @generated
	 * @ordered
	 */
	protected String lemma = LEMMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getPOS() <em>POS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPOS()
	 * @generated
	 * @ordered
	 */
	protected static final POSType POS_EDEFAULT = POSType.UNDEFINED;

	/**
	 * The cached value of the '{@link #getPOS() <em>POS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPOS()
	 * @generated
	 * @ordered
	 */
	protected POSType pos = POS_EDEFAULT;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final WordType TYPE_EDEFAULT = WordType.SUBJECT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected WordType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInterpunction() <em>Interpunction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterpunction()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERPUNCTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInterpunction() <em>Interpunction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterpunction()
	 * @generated
	 * @ordered
	 */
	protected boolean interpunction = INTERPUNCTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isNumeral() <em>Numeral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNumeral()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NUMERAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNumeral() <em>Numeral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNumeral()
	 * @generated
	 * @ordered
	 */
	protected boolean numeral = NUMERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WordImpl()
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
		return LingPackage.Literals.WORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParseTreeNode getParent()
	{
		if (parent != null && parent.eIsProxy())
		{
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (ParseTreeNode)eResolveProxy(oldParent);
			if (parent != oldParent)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LingPackage.WORD__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParseTreeNode basicGetParent()
	{
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(ParseTreeNode newParent)
	{
		ParseTreeNode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParseTreeNode> getChildren()
	{
		if (children == null)
		{
			children = new EObjectContainmentEList<ParseTreeNode>(ParseTreeNode.class, this, LingPackage.WORD__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText)
	{
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLemma()
	{
		return lemma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLemma(String newLemma)
	{
		String oldLemma = lemma;
		lemma = newLemma;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__LEMMA, oldLemma, lemma));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public POSType getPOS()
	{
		return pos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPOS(POSType newPOS)
	{
		POSType oldPOS = pos;
		pos = newPOS == null ? POS_EDEFAULT : newPOS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__POS, oldPOS, pos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getID()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(int newID)
	{
		int oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WordType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(WordType newType)
	{
		WordType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterpunction()
	{
		return interpunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpunction(boolean newInterpunction)
	{
		boolean oldInterpunction = interpunction;
		interpunction = newInterpunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__INTERPUNCTION, oldInterpunction, interpunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNumeral()
	{
		return numeral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumeral(boolean newNumeral)
	{
		boolean oldNumeral = numeral;
		numeral = newNumeral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LingPackage.WORD__NUMERAL, oldNumeral, numeral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean parseString(String wordString)
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case LingPackage.WORD__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case LingPackage.WORD__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case LingPackage.WORD__CHILDREN:
				return getChildren();
			case LingPackage.WORD__TEXT:
				return getText();
			case LingPackage.WORD__LEMMA:
				return getLemma();
			case LingPackage.WORD__POS:
				return getPOS();
			case LingPackage.WORD__ID:
				return getID();
			case LingPackage.WORD__TYPE:
				return getType();
			case LingPackage.WORD__INTERPUNCTION:
				return isInterpunction();
			case LingPackage.WORD__NUMERAL:
				return isNumeral();
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
			case LingPackage.WORD__PARENT:
				setParent((ParseTreeNode)newValue);
				return;
			case LingPackage.WORD__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends ParseTreeNode>)newValue);
				return;
			case LingPackage.WORD__TEXT:
				setText((String)newValue);
				return;
			case LingPackage.WORD__LEMMA:
				setLemma((String)newValue);
				return;
			case LingPackage.WORD__POS:
				setPOS((POSType)newValue);
				return;
			case LingPackage.WORD__ID:
				setID((Integer)newValue);
				return;
			case LingPackage.WORD__TYPE:
				setType((WordType)newValue);
				return;
			case LingPackage.WORD__INTERPUNCTION:
				setInterpunction((Boolean)newValue);
				return;
			case LingPackage.WORD__NUMERAL:
				setNumeral((Boolean)newValue);
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
			case LingPackage.WORD__PARENT:
				setParent((ParseTreeNode)null);
				return;
			case LingPackage.WORD__CHILDREN:
				getChildren().clear();
				return;
			case LingPackage.WORD__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case LingPackage.WORD__LEMMA:
				setLemma(LEMMA_EDEFAULT);
				return;
			case LingPackage.WORD__POS:
				setPOS(POS_EDEFAULT);
				return;
			case LingPackage.WORD__ID:
				setID(ID_EDEFAULT);
				return;
			case LingPackage.WORD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case LingPackage.WORD__INTERPUNCTION:
				setInterpunction(INTERPUNCTION_EDEFAULT);
				return;
			case LingPackage.WORD__NUMERAL:
				setNumeral(NUMERAL_EDEFAULT);
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
			case LingPackage.WORD__PARENT:
				return parent != null;
			case LingPackage.WORD__CHILDREN:
				return children != null && !children.isEmpty();
			case LingPackage.WORD__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case LingPackage.WORD__LEMMA:
				return LEMMA_EDEFAULT == null ? lemma != null : !LEMMA_EDEFAULT.equals(lemma);
			case LingPackage.WORD__POS:
				return pos != POS_EDEFAULT;
			case LingPackage.WORD__ID:
				return id != ID_EDEFAULT;
			case LingPackage.WORD__TYPE:
				return type != TYPE_EDEFAULT;
			case LingPackage.WORD__INTERPUNCTION:
				return interpunction != INTERPUNCTION_EDEFAULT;
			case LingPackage.WORD__NUMERAL:
				return numeral != NUMERAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(", lemma: ");
		result.append(lemma);
		result.append(", POS: ");
		result.append(pos);
		result.append(", ID: ");
		result.append(id);
		result.append(", type: ");
		result.append(type);
		result.append(", interpunction: ");
		result.append(interpunction);
		result.append(", numeral: ");
		result.append(numeral);
		result.append(')');
		return result.toString();
	}

} //WordImpl
