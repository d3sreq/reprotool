/**
 * <copyright>
 * </copyright>
 *
 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fairness Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FairnessExpressionImpl#getFairnessExpr <em>Fairness Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FairnessExpressionImpl extends FairnessConstraintImpl implements FairnessExpression
{
  /**
   * The default value of the '{@link #getFairnessExpr() <em>Fairness Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFairnessExpr()
   * @generated
   * @ordered
   */
  protected static final String FAIRNESS_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFairnessExpr() <em>Fairness Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFairnessExpr()
   * @generated
   * @ordered
   */
  protected String fairnessExpr = FAIRNESS_EXPR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FairnessExpressionImpl()
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
    return NuSmvLangPackage.Literals.FAIRNESS_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFairnessExpr()
  {
    return fairnessExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFairnessExpr(String newFairnessExpr)
  {
    String oldFairnessExpr = fairnessExpr;
    fairnessExpr = newFairnessExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.FAIRNESS_EXPRESSION__FAIRNESS_EXPR, oldFairnessExpr, fairnessExpr));
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
      case NuSmvLangPackage.FAIRNESS_EXPRESSION__FAIRNESS_EXPR:
        return getFairnessExpr();
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
      case NuSmvLangPackage.FAIRNESS_EXPRESSION__FAIRNESS_EXPR:
        setFairnessExpr((String)newValue);
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
      case NuSmvLangPackage.FAIRNESS_EXPRESSION__FAIRNESS_EXPR:
        setFairnessExpr(FAIRNESS_EXPR_EDEFAULT);
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
      case NuSmvLangPackage.FAIRNESS_EXPRESSION__FAIRNESS_EXPR:
        return FAIRNESS_EXPR_EDEFAULT == null ? fairnessExpr != null : !FAIRNESS_EXPR_EDEFAULT.equals(fairnessExpr);
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
    result.append(" (fairnessExpr: ");
    result.append(fairnessExpr);
    result.append(')');
    return result.toString();
  }

} //FairnessExpressionImpl
