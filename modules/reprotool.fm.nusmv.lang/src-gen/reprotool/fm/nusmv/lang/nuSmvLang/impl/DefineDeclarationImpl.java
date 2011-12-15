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

import reprotool.fm.nusmv.lang.nuSmvLang.DefineBody;
import reprotool.fm.nusmv.lang.nuSmvLang.DefineDeclaration;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Define Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineDeclarationImpl#getDefineBodies <em>Define Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefineDeclarationImpl extends ModuleElementImpl implements DefineDeclaration
{
  /**
   * The cached value of the '{@link #getDefineBodies() <em>Define Bodies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefineBodies()
   * @generated
   * @ordered
   */
  protected EList<DefineBody> defineBodies;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefineDeclarationImpl()
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
    return NuSmvLangPackage.Literals.DEFINE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefineBody> getDefineBodies()
  {
    if (defineBodies == null)
    {
      defineBodies = new EObjectContainmentEList<DefineBody>(DefineBody.class, this, NuSmvLangPackage.DEFINE_DECLARATION__DEFINE_BODIES);
    }
    return defineBodies;
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
      case NuSmvLangPackage.DEFINE_DECLARATION__DEFINE_BODIES:
        return ((InternalEList<?>)getDefineBodies()).basicRemove(otherEnd, msgs);
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
      case NuSmvLangPackage.DEFINE_DECLARATION__DEFINE_BODIES:
        return getDefineBodies();
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
      case NuSmvLangPackage.DEFINE_DECLARATION__DEFINE_BODIES:
        getDefineBodies().clear();
        getDefineBodies().addAll((Collection<? extends DefineBody>)newValue);
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
      case NuSmvLangPackage.DEFINE_DECLARATION__DEFINE_BODIES:
        getDefineBodies().clear();
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
      case NuSmvLangPackage.DEFINE_DECLARATION__DEFINE_BODIES:
        return defineBodies != null && !defineBodies.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DefineDeclarationImpl
