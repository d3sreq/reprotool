/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.InvarSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invar Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.InvarSpecificationImpl#getInvarExpr <em>Invar Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvarSpecificationImpl extends ModuleElementImpl implements InvarSpecification
{
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
   * The default value of the '{@link #getInvarExpr() <em>Invar Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvarExpr()
   * @generated
   * @ordered
   */
  protected static final String INVAR_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInvarExpr() <em>Invar Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvarExpr()
   * @generated
   * @ordered
   */
  protected String invarExpr = INVAR_EXPR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvarSpecificationImpl()
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
    return NuSmvLangPackage.Literals.INVAR_SPECIFICATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.INVAR_SPECIFICATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInvarExpr()
  {
    return invarExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvarExpr(String newInvarExpr)
  {
    String oldInvarExpr = invarExpr;
    invarExpr = newInvarExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.INVAR_SPECIFICATION__INVAR_EXPR, oldInvarExpr, invarExpr));
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
      case NuSmvLangPackage.INVAR_SPECIFICATION__NAME:
        return getName();
      case NuSmvLangPackage.INVAR_SPECIFICATION__INVAR_EXPR:
        return getInvarExpr();
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
      case NuSmvLangPackage.INVAR_SPECIFICATION__NAME:
        setName((String)newValue);
        return;
      case NuSmvLangPackage.INVAR_SPECIFICATION__INVAR_EXPR:
        setInvarExpr((String)newValue);
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
      case NuSmvLangPackage.INVAR_SPECIFICATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case NuSmvLangPackage.INVAR_SPECIFICATION__INVAR_EXPR:
        setInvarExpr(INVAR_EXPR_EDEFAULT);
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
      case NuSmvLangPackage.INVAR_SPECIFICATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case NuSmvLangPackage.INVAR_SPECIFICATION__INVAR_EXPR:
        return INVAR_EXPR_EDEFAULT == null ? invarExpr != null : !INVAR_EXPR_EDEFAULT.equals(invarExpr);
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
    result.append(" (name: ");
    result.append(name);
    result.append(", invarExpr: ");
    result.append(invarExpr);
    result.append(')');
    return result.toString();
  }

} //InvarSpecificationImpl
