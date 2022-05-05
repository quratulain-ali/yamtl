/**
 */
package DB;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DB.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link DB.Table#getPrimaryKeys <em>Primary Keys</em>}</li>
 * </ul>
 *
 * @see DB.DBPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends DatabaseElement {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link DB.Column}.
	 * It is bidirectional and its opposite is '{@link DB.Column#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see DB.DBPackage#getTable_Columns()
	 * @see DB.Column#getTable
	 * @model opposite="table" containment="true"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Primary Keys</b></em>' reference list.
	 * The list contents are of type {@link DB.Column}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Keys</em>' reference list.
	 * @see DB.DBPackage#getTable_PrimaryKeys()
	 * @model
	 * @generated
	 */
	EList<Column> getPrimaryKeys();

} // Table
