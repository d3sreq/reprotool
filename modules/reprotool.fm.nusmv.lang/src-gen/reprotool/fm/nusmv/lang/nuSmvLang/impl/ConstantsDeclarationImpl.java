/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import reprotool.fm.nusmv.lang.nuSmvLang.ConstantsDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constants Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.ConstantsDeclarationImpl#getConstants <em>Constants</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantsDeclarationImpl extends ModuleElementImpl implements ConstantsDeclaration
{
  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<String> constants;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantsDeclarationImpl()
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
    return NuSmvLangPackage.Literals.CONSTANTS_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getConstants()
  {
    if (constants == null)
    {
      constants = new EDataTypeEList<String>(String.class, this, NuSmvLangPackage.CONSTANTS_DECLARATION__CONSTANTS);
    }
    return constants;
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
      case NuSmvLangPackage.CONSTANTS_DECLARATION__CONSTANTS:
        return getConstants();
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
      case NuSmvLangPackage.CONSTANTS_DECLARATION__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends String>)newValue);
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
      case NuSmvLangPackage.CONSTANTS_DECLARATION__CONSTANTS:
        getConstants().clear();
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
      case NuSmvLangPackage.CONSTANTS_DECLARATION__CONSTANTS:
        return constants != null && !constants.isEmpty();
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
    result.append(" (constants: ");
    result.append(constants);
    result.append(')');
    return result.toString();
  }

} //ConstantsDeclarationImpl
