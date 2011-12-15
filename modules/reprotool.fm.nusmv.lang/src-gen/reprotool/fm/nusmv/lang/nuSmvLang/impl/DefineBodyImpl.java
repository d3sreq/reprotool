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

import reprotool.fm.nusmv.lang.nuSmvLang.DefineBody;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Define Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineBodyImpl#getVarId <em>Var Id</em>}</li>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.DefineBodyImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefineBodyImpl extends MinimalEObjectImpl.Container implements DefineBody
{
  /**
   * The default value of the '{@link #getVarId() <em>Var Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarId()
   * @generated
   * @ordered
   */
  protected static final String VAR_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVarId() <em>Var Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarId()
   * @generated
   * @ordered
   */
  protected String varId = VAR_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getAssignment() <em>Assignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignment()
   * @generated
   * @ordered
   */
  protected static final String ASSIGNMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignment()
   * @generated
   * @ordered
   */
  protected String assignment = ASSIGNMENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefineBodyImpl()
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
    return NuSmvLangPackage.Literals.DEFINE_BODY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVarId()
  {
    return varId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarId(String newVarId)
  {
    String oldVarId = varId;
    varId = newVarId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.DEFINE_BODY__VAR_ID, oldVarId, varId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAssignment()
  {
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignment(String newAssignment)
  {
    String oldAssignment = assignment;
    assignment = newAssignment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.DEFINE_BODY__ASSIGNMENT, oldAssignment, assignment));
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
      case NuSmvLangPackage.DEFINE_BODY__VAR_ID:
        return getVarId();
      case NuSmvLangPackage.DEFINE_BODY__ASSIGNMENT:
        return getAssignment();
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
      case NuSmvLangPackage.DEFINE_BODY__VAR_ID:
        setVarId((String)newValue);
        return;
      case NuSmvLangPackage.DEFINE_BODY__ASSIGNMENT:
        setAssignment((String)newValue);
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
      case NuSmvLangPackage.DEFINE_BODY__VAR_ID:
        setVarId(VAR_ID_EDEFAULT);
        return;
      case NuSmvLangPackage.DEFINE_BODY__ASSIGNMENT:
        setAssignment(ASSIGNMENT_EDEFAULT);
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
      case NuSmvLangPackage.DEFINE_BODY__VAR_ID:
        return VAR_ID_EDEFAULT == null ? varId != null : !VAR_ID_EDEFAULT.equals(varId);
      case NuSmvLangPackage.DEFINE_BODY__ASSIGNMENT:
        return ASSIGNMENT_EDEFAULT == null ? assignment != null : !ASSIGNMENT_EDEFAULT.equals(assignment);
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
    result.append(" (varId: ");
    result.append(varId);
    result.append(", assignment: ");
    result.append(assignment);
    result.append(')');
    return result.toString();
  }

} //DefineBodyImpl
