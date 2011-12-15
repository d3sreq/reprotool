/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ctl Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CtlSpecificationImpl#isNameKeyWord <em>Name Key Word</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CtlSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CtlSpecificationImpl#getCtlExpr <em>Ctl Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CtlSpecificationImpl extends ModuleElementImpl implements CtlSpecification
{
  /**
   * The default value of the '{@link #isNameKeyWord() <em>Name Key Word</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNameKeyWord()
   * @generated
   * @ordered
   */
  protected static final boolean NAME_KEY_WORD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNameKeyWord() <em>Name Key Word</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNameKeyWord()
   * @generated
   * @ordered
   */
  protected boolean nameKeyWord = NAME_KEY_WORD_EDEFAULT;

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
   * The default value of the '{@link #getCtlExpr() <em>Ctl Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCtlExpr()
   * @generated
   * @ordered
   */
  protected static final String CTL_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCtlExpr() <em>Ctl Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCtlExpr()
   * @generated
   * @ordered
   */
  protected String ctlExpr = CTL_EXPR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CtlSpecificationImpl()
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
    return NuSmvLangPackage.Literals.CTL_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNameKeyWord()
  {
    return nameKeyWord;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameKeyWord(boolean newNameKeyWord)
  {
    boolean oldNameKeyWord = nameKeyWord;
    nameKeyWord = newNameKeyWord;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.CTL_SPECIFICATION__NAME_KEY_WORD, oldNameKeyWord, nameKeyWord));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.CTL_SPECIFICATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCtlExpr()
  {
    return ctlExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCtlExpr(String newCtlExpr)
  {
    String oldCtlExpr = ctlExpr;
    ctlExpr = newCtlExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.CTL_SPECIFICATION__CTL_EXPR, oldCtlExpr, ctlExpr));
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
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME_KEY_WORD:
        return isNameKeyWord();
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME:
        return getName();
      case NuSmvLangPackage.CTL_SPECIFICATION__CTL_EXPR:
        return getCtlExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME_KEY_WORD:
        setNameKeyWord((Boolean)newValue);
        return;
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME:
        setName((String)newValue);
        return;
      case NuSmvLangPackage.CTL_SPECIFICATION__CTL_EXPR:
        setCtlExpr((String)newValue);
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
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME_KEY_WORD:
        setNameKeyWord(NAME_KEY_WORD_EDEFAULT);
        return;
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case NuSmvLangPackage.CTL_SPECIFICATION__CTL_EXPR:
        setCtlExpr(CTL_EXPR_EDEFAULT);
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
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME_KEY_WORD:
        return nameKeyWord != NAME_KEY_WORD_EDEFAULT;
      case NuSmvLangPackage.CTL_SPECIFICATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case NuSmvLangPackage.CTL_SPECIFICATION__CTL_EXPR:
        return CTL_EXPR_EDEFAULT == null ? ctlExpr != null : !CTL_EXPR_EDEFAULT.equals(ctlExpr);
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
    result.append(" (nameKeyWord: ");
    result.append(nameKeyWord);
    result.append(", name: ");
    result.append(name);
    result.append(", ctlExpr: ");
    result.append(ctlExpr);
    result.append(')');
    return result.toString();
  }

} //CtlSpecificationImpl
