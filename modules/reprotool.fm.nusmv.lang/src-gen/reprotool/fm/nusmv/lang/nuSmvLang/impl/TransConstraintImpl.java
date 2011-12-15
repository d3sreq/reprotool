/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;
import reprotool.fm.nusmv.lang.nuSmvLang.TransConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trans Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.TransConstraintImpl#getTransExpr <em>Trans Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransConstraintImpl extends ModuleElementImpl implements TransConstraint
{
  /**
   * The default value of the '{@link #getTransExpr() <em>Trans Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransExpr()
   * @generated
   * @ordered
   */
  protected static final String TRANS_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTransExpr() <em>Trans Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransExpr()
   * @generated
   * @ordered
   */
  protected String transExpr = TRANS_EXPR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransConstraintImpl()
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
    return NuSmvLangPackage.Literals.TRANS_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTransExpr()
  {
    return transExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransExpr(String newTransExpr)
  {
    String oldTransExpr = transExpr;
    transExpr = newTransExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.TRANS_CONSTRAINT__TRANS_EXPR, oldTransExpr, transExpr));
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
      case NuSmvLangPackage.TRANS_CONSTRAINT__TRANS_EXPR:
        return getTransExpr();
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
      case NuSmvLangPackage.TRANS_CONSTRAINT__TRANS_EXPR:
        setTransExpr((String)newValue);
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
      case NuSmvLangPackage.TRANS_CONSTRAINT__TRANS_EXPR:
        setTransExpr(TRANS_EXPR_EDEFAULT);
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
      case NuSmvLangPackage.TRANS_CONSTRAINT__TRANS_EXPR:
        return TRANS_EXPR_EDEFAULT == null ? transExpr != null : !TRANS_EXPR_EDEFAULT.equals(transExpr);
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
    result.append(" (transExpr: ");
    result.append(transExpr);
    result.append(')');
    return result.toString();
  }

} //TransConstraintImpl
