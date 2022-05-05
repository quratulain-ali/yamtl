/**
 */
package DB;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DB.Database#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see DB.DBPackage#getDatabase()
 * @model
 * @generated
 */
public interface Database extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link DB.DatabaseElement}.
	 * It is bidirectional and its opposite is '{@link DB.DatabaseElement#getDatabase <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see DB.DBPackage#getDatabase_Contents()
	 * @see DB.DatabaseElement#getDatabase
	 * @model opposite="database" containment="true"
	 * @generated
	 */
	EList<DatabaseElement> getContents();

} // Database
