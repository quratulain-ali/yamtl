/**
 */
package OO;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OO.Reference#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see OO.OOPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends StructuralFeature {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(OO.Class)
	 * @see OO.OOPackage#getReference_Type()
	 * @model
	 * @generated
	 */
	OO.Class getType();

	/**
	 * Sets the value of the '{@link OO.Reference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(OO.Class value);

} // Reference
