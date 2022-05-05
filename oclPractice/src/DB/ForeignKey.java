/**
 */
package DB;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DB.ForeignKey#getParent <em>Parent</em>}</li>
 *   <li>{@link DB.ForeignKey#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see DB.DBPackage#getForeignKey()
 * @model
 * @generated
 */
public interface ForeignKey extends DatabaseElement {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Column)
	 * @see DB.DBPackage#getForeignKey_Parent()
	 * @model
	 * @generated
	 */
	Column getParent();

	/**
	 * Sets the value of the '{@link DB.ForeignKey#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Column value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' reference.
	 * @see #setChild(Column)
	 * @see DB.DBPackage#getForeignKey_Child()
	 * @model
	 * @generated
	 */
	Column getChild();

	/**
	 * Sets the value of the '{@link DB.ForeignKey#getChild <em>Child</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(Column value);

} // ForeignKey
