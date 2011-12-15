/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.JusticeExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Justice Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.JusticeExpressionImpl#getJusticeExpr <em>Justice Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JusticeExpressionImpl extends FairnessConstraintImpl implements JusticeExpression
{
  /**
   * The default value of the '{@link #getJusticeExpr() <em>Justice Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJusticeExpr()
   * @generated
   * @ordered
   */
  protected static final String JUSTICE_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJusticeExpr() <em>Justice Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJusticeExpr()
   * @generated
   * @ordered
   */
  protected String justiceExpr = JUSTICE_EXPR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JusticeExpressionImpl()
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
    return NuSmvLangPackage.Literals.JUSTICE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJusticeExpr()
  {
    return justiceExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJusticeExpr(String newJusticeExpr)
  {
    String oldJusticeExpr = justiceExpr;
    justiceExpr = newJusticeExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.JUSTICE_EXPRESSION__JUSTICE_EXPR, oldJusticeExpr, justiceExpr));
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
      case NuSmvLangPackage.JUSTICE_EXPRESSION__JUSTICE_EXPR:
        return getJusticeExpr();
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
      case NuSmvLangPackage.JUSTICE_EXPRESSION__JUSTICE_EXPR:
        setJusticeExpr((String)newValue);
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
      case NuSmvLangPackage.JUSTICE_EXPRESSION__JUSTICE_EXPR:
        setJusticeExpr(JUSTICE_EXPR_EDEFAULT);
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
      case NuSmvLangPackage.JUSTICE_EXPRESSION__JUSTICE_EXPR:
        return JUSTICE_EXPR_EDEFAULT == null ? justiceExpr != null : !JUSTICE_EXPR_EDEFAULT.equals(justiceExpr);
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
    result.append(" (justiceExpr: ");
    result.append(justiceExpr);
    result.append(')');
    return result.toString();
  }

} //JusticeExpressionImpl
