/**
 * <copyright>
 * </copyright>
 *

 */
package reprotool.fm.nusmv.lang.nuSmvLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import reprotool.fm.nusmv.lang.nuSmvLang.FrozenVariableDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Frozen Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.FrozenVariableDeclarationImpl#getVars <em>Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FrozenVariableDeclarationImpl extends ModuleElementImpl implements FrozenVariableDeclaration
{
  /**
   * The cached value of the '{@link #getVars() <em>Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVars()
   * @generated
   * @ordered
   */
  protected EList<VarBody> vars;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FrozenVariableDeclarationImpl()
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
    return NuSmvLangPackage.Literals.FROZEN_VARIABLE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VarBody> getVars()
  {
    if (vars == null)
    {
      vars = new EObjectContainmentEList<VarBody>(VarBody.class, this, NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION__VARS);
    }
    return vars;
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
      case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION__VARS:
        return ((InternalEList<?>)getVars()).basicRemove(otherEnd, msgs);
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
      case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION__VARS:
        return getVars();
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
      case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION__VARS:
        getVars().clear();
        getVars().addAll((Collection<? extends VarBody>)newValue);
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
      case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION__VARS:
        getVars().clear();
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
      case NuSmvLangPackage.FROZEN_VARIABLE_DECLARATION__VARS:
        return vars != null && !vars.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FrozenVariableDeclarationImpl
