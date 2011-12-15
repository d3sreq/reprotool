/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FormalParameterImpl#getParamId <em>Param Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalParameterImpl extends MinimalEObjectImpl.Container implements FormalParameter
{
  /**
   * The default value of the '{@link #getParamId() <em>Param Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamId()
   * @generated
   * @ordered
   */
  protected static final String PARAM_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParamId() <em>Param Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamId()
   * @generated
   * @ordered
   */
  protected String paramId = PARAM_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FormalParameterImpl()
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
    return NuSmvLangPackage.Literals.FORMAL_PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParamId()
  {
    return paramId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParamId(String newParamId)
  {
    String oldParamId = paramId;
    paramId = newParamId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.FORMAL_PARAMETER__PARAM_ID, oldParamId, paramId));
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
      case NuSmvLangPackage.FORMAL_PARAMETER__PARAM_ID:
        return getParamId();
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
      case NuSmvLangPackage.FORMAL_PARAMETER__PARAM_ID:
        setParamId((String)newValue);
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
      case NuSmvLangPackage.FORMAL_PARAMETER__PARAM_ID:
        setParamId(PARAM_ID_EDEFAULT);
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
      case NuSmvLangPackage.FORMAL_PARAMETER__PARAM_ID:
        return PARAM_ID_EDEFAULT == null ? paramId != null : !PARAM_ID_EDEFAULT.equals(paramId);
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
    result.append(" (paramId: ");
    result.append(paramId);
    result.append(')');
    return result.toString();
  }

} //FormalParameterImpl
