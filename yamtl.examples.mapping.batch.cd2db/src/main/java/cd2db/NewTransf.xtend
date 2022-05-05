package cd2db

import yamtl.core.YAMTLModule
import OO.OOPackage
import DB.DBPackage
import yamtl.dsl.Rule
import DB.Table
import OO.Attribute
import DB.Column
import OO.Datatype

class NewTransf extends YAMTLModule {
	val OO = OOPackage.eINSTANCE  
	val DB = DBPackage.eINSTANCE  
	new () {
		header().in('oo', OO).out('db', DB)
		
		ruleStore( newArrayList(
			new Rule('ClassToTable')
				.in('c', OO.class_).build()
				.out('out', DB.table, [
					// environment vbles 
					val c = 'c'.fetch as OO.Class
					val out = 'out'.fetch as Table
					//print(c.name)
				]).build()
				.build(),
				new Rule('SingleValuedAttributeToColumn')
				.in('a', OO.datatype).build()
				.out('tb', DB.table,  [
					// environment vbles 
					val a = 'a'.fetch as Datatype
					val tb = 'tb'.fetch as Table
					// bindings
					print(a.name)
//					foreignKey.name = a.name
//					foreignKey.table = a.owner as Table
//					foreignKey.type = a.type.name.toDbType
				]).build()
				.build()
				))
}
}