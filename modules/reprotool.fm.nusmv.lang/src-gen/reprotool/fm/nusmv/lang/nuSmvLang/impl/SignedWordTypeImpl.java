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
import reprotool.fm.nusmv.lang.nuSmvLang.SignedWordType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signed Word Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link reprotool.fm.nusmv.lang.nuSmvLang.impl.SignedWordTypeImpl#getSignedNumber <em>Signed Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignedWordTypeImpl extends SimpleTypeImpl implements SignedWordType
{
  /**
   * The default value of the '{@link #getSignedNumber() <em>Signed Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignedNumber()
   * @generated
   * @ordered
   */
  protected static final String SIGNED_NUMBER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSignedNumber() <em>Signed Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignedNumber()
   * @generated
   * @ordered
   */
  protected String signedNumber = SIGNED_NUMBER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SignedWordTypeImpl()
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
    return NuSmvLangPackage.Literals.SIGNED_WORD_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSignedNumber()
  {
    return signedNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignedNumber(String newSignedNumber)
  {
    String oldSignedNumber = signedNumber;
    signedNumber = newSignedNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NuSmvLangPackage.SIGNED_WORD_TYPE__SIGNED_NUMBER, oldSignedNumber, signedNumber));
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
      case NuSmvLangPackage.SIGNED_WORD_TYPE__SIGNED_NUMBER:
        return getSignedNumber();
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
      case NuSmvLangPackage.SIGNED_WORD_TYPE__SIGNED_NUMBER:
        setSignedNumber((String)newValue);
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
      case NuSmvLangPackage.SIGNED_WORD_TYPE__SIGNED_NUMBER:
        setSignedNumber(SIGNED_NUMBER_EDEFAULT);
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
      case NuSmvLangPackage.SIGNED_WORD_TYPE__SIGNED_NUMBER:
        return SIGNED_NUMBER_EDEFAULT == null ? signedNumber != null : !SIGNED_NUMBER_EDEFAULT.equals(signedNumber);
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
    result.append(" (signedNumber: ");
    result.append(signedNumber);
    result.append(')');
    return result.toString();
  }

} //SignedWordTypeImpl
