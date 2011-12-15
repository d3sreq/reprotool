/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ltl Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.LtlSpecificationImpl#isNameId <em>Name Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.LtlSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.LtlSpecificationImpl#getLtlExpr <em>Ltl Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LtlSpecificationImpl extends ModuleElementImpl implements LtlSpecification
{
  /**
   * The default value of the '{@link #isNameId() <em>Name Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNameId()
   * @generated
   * @ordered
   */
  protected static final boolean NAME_ID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNameId() <em>Name Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNameId()
   * @generated
   * @ordered
   */
  protected boolean nameId = NAME_ID_EDEFAULT;

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
   * The default value of the '{@link #getLtlExpr() <em>Ltl Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLtlExpr()
   * @generated
   * @ordered
   */
  protected static final String LTL_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLtlExpr() <em>Ltl Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLtlExpr()
   * @generated
   * @ordered
   */
  protected String ltlExpr = LTL_EXPR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LtlSpecificationImpl()
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
    return NuSmvLangPackage.Literals.LTL_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNameId()
  {
    return nameId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameId(boolean newNameId)
  {
    boolean oldNameId = nameId;
    nameId = newNameId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.LTL_SPECIFICATION__NAME_ID, oldNameId, nameId));
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
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.LTL_SPECIFICATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLtlExpr()
  {
    return ltlExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLtlExpr(String newLtlExpr)
  {
    String oldLtlExpr = ltlExpr;
    ltlExpr = newLtlExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.LTL_SPECIFICATION__LTL_EXPR, oldLtlExpr, ltlExpr));
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
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME_ID:
        return isNameId();
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME:
        return getName();
      case NuSmvLangPackage.LTL_SPECIFICATION__LTL_EXPR:
        return getLtlExpr();
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
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME_ID:
        setNameId((Boolean)newValue);
        return;
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME:
        setName((String)newValue);
        return;
      case NuSmvLangPackage.LTL_SPECIFICATION__LTL_EXPR:
        setLtlExpr((String)newValue);
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
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME_ID:
        setNameId(NAME_ID_EDEFAULT);
        return;
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case NuSmvLangPackage.LTL_SPECIFICATION__LTL_EXPR:
        setLtlExpr(LTL_EXPR_EDEFAULT);
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
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME_ID:
        return nameId != NAME_ID_EDEFAULT;
      case NuSmvLangPackage.LTL_SPECIFICATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case NuSmvLangPackage.LTL_SPECIFICATION__LTL_EXPR:
        return LTL_EXPR_EDEFAULT == null ? ltlExpr != null : !LTL_EXPR_EDEFAULT.equals(ltlExpr);
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
    result.append(" (nameId: ");
    result.append(nameId);
    result.append(", name: ");
    result.append(name);
    result.append(", ltlExpr: ");
    result.append(ltlExpr);
    result.append(')');
    return result.toString();
  }

} //LtlSpecificationImpl
