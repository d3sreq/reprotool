/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.CompassionExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compassion Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CompassionExpressionImpl#getFirstCompassionExpr <em>First Compassion Expr</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.CompassionExpressionImpl#getSecondCompassionExpr <em>Second Compassion Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompassionExpressionImpl extends FairnessConstraintImpl implements CompassionExpression
{
  /**
   * The default value of the '{@link #getFirstCompassionExpr() <em>First Compassion Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstCompassionExpr()
   * @generated
   * @ordered
   */
  protected static final String FIRST_COMPASSION_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFirstCompassionExpr() <em>First Compassion Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstCompassionExpr()
   * @generated
   * @ordered
   */
  protected String firstCompassionExpr = FIRST_COMPASSION_EXPR_EDEFAULT;

  /**
   * The default value of the '{@link #getSecondCompassionExpr() <em>Second Compassion Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondCompassionExpr()
   * @generated
   * @ordered
   */
  protected static final String SECOND_COMPASSION_EXPR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSecondCompassionExpr() <em>Second Compassion Expr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondCompassionExpr()
   * @generated
   * @ordered
   */
  protected String secondCompassionExpr = SECOND_COMPASSION_EXPR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompassionExpressionImpl()
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
    return NuSmvLangPackage.Literals.COMPASSION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFirstCompassionExpr()
  {
    return firstCompassionExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstCompassionExpr(String newFirstCompassionExpr)
  {
    String oldFirstCompassionExpr = firstCompassionExpr;
    firstCompassionExpr = newFirstCompassionExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR, oldFirstCompassionExpr, firstCompassionExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSecondCompassionExpr()
  {
    return secondCompassionExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecondCompassionExpr(String newSecondCompassionExpr)
  {
    String oldSecondCompassionExpr = secondCompassionExpr;
    secondCompassionExpr = newSecondCompassionExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR, oldSecondCompassionExpr, secondCompassionExpr));
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
      case NuSmvLangPackage.COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR:
        return getFirstCompassionExpr();
      case NuSmvLangPackage.COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR:
        return getSecondCompassionExpr();
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
      case NuSmvLangPackage.COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR:
        setFirstCompassionExpr((String)newValue);
        return;
      case NuSmvLangPackage.COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR:
        setSecondCompassionExpr((String)newValue);
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
      case NuSmvLangPackage.COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR:
        setFirstCompassionExpr(FIRST_COMPASSION_EXPR_EDEFAULT);
        return;
      case NuSmvLangPackage.COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR:
        setSecondCompassionExpr(SECOND_COMPASSION_EXPR_EDEFAULT);
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
      case NuSmvLangPackage.COMPASSION_EXPRESSION__FIRST_COMPASSION_EXPR:
        return FIRST_COMPASSION_EXPR_EDEFAULT == null ? firstCompassionExpr != null : !FIRST_COMPASSION_EXPR_EDEFAULT.equals(firstCompassionExpr);
      case NuSmvLangPackage.COMPASSION_EXPRESSION__SECOND_COMPASSION_EXPR:
        return SECOND_COMPASSION_EXPR_EDEFAULT == null ? secondCompassionExpr != null : !SECOND_COMPASSION_EXPR_EDEFAULT.equals(secondCompassionExpr);
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
    result.append(" (firstCompassionExpr: ");
    result.append(firstCompassionExpr);
    result.append(", secondCompassionExpr: ");
    result.append(secondCompassionExpr);
    result.append(')');
    return result.toString();
  }

} //CompassionExpressionImpl
