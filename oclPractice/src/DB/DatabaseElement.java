/**
 */
package DB;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DB.DatabaseElement#getDatabase <em>Database</em>}</li>
 * </ul>
 *
 * @see DB.DBPackage#getDatabaseElement()
 * @model abstract="true"
 * @generated
 */
public interface DatabaseElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Database</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link DB.Database#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database</em>' container reference.
	 * @see #setDatabase(Database)
	 * @see DB.DBPackage#getDatabaseElement_Database()
	 * @see DB.Database#getContents
	 * @model opposite="contents" transient="false"
	 * @generated
	 */
	Database getDatabase();

	/**
	 * Sets the value of the '{@link DB.DatabaseElement#getDatabase <em>Database</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database</em>' container reference.
	 * @see #getDatabase()
	 * @generated
	 */
	void setDatabase(Database value);

} // DatabaseElement
