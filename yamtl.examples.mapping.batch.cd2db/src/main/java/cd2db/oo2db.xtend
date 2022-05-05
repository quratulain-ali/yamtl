package cd2db

import yamtl.core.YAMTLModule
import OO.Attribute
import OO.Class
import OO.OOPackage
import DB.DBPackage
import yamtl.dsl.Rule
import DB.Table
import DB.Column
import DB.ForeignKey
import java.util.List
import OO.Reference

class oo2db extends YAMTLModule {
	
	val OO = OOPackage.eINSTANCE  
	val DB = DBPackage.eINSTANCE 
	
	new () {
		header().in('oo', OO).out('db', DB)
		ruleStore( newArrayList(
			
			
			new Rule('ClassToTable')
				.in('c', OO.class_).build()
				.out('out', DB.table,  [
					// environment vbles 
					val c = 'c'.fetch as Class
					val out = 'out'.fetch as Table
					val pk = 'pk'.fetch as Column
					// bindings
					out.name = c.name
					out.columns.add(pk)
					out.primaryKeys.add(pk)
					val rList  = c.features.filter(a|a instanceof Reference).fetch as List<Column>
					val list  = c.features.filter(a|a instanceof Attribute).fetch as List<Column>
					out.columns.addAll(list)
					
				]).build()
				
				.out('pk', DB.column, [
					// environment vbles 
					val c = 'c'.fetch as Class
					val pk = 'pk'.fetch as Column
					val out = 'out'.fetch as Table
					// bindings
					pk.name = out.primaryKeyName
					pk.type = 'INT'
				]).build()
				.build(),
				
				new Rule('SingleValuedAttributeToColumn')
				.in('a', OO.attribute).filter([
					val a = 'a'.fetch as Attribute
					!a.isMany
					
				]).build()
				.out('foreignKey', DB.column,  [
					// environment vbles 
					val a = 'a'.fetch as Attribute
					val foreignKey = 'foreignKey'.fetch as Column
					// bindings
					foreignKey.name = a.name
					foreignKey.table = a.owner.fetch('ClassToTable')  as Table
					foreignKey.type = a.type.name.toDbType
				]).build()
				.build(),
				
				new Rule('MultiValuedAttribute2Column')
				.in('a', OO.attribute).filter([
					val att = 'a'.fetch as Attribute
					att.isMany
				]).build()
				.out('t', DB.table,  [
					// environment vbles 
					val a = 'a'.fetch as Attribute
					val t = 't'.fetch as Table
					// bindings
					t.name = a.valuesTableName
				]).build()
				.out('pkCol', DB.column, [
					// environment vbles 
					val a = 'a'.fetch as Attribute
					val pkCol = 'pkCol'.fetch as Column
					val t = 't'.fetch as Table
					// bindings
					pkCol.name = a.name + 'Id'
					pkCol.table = t
					pkCol.type = 'INT' 
					
				]).build()
				.out('valueCol', DB.column, [
					// environment vbles 
					val a = 'a'.fetch as Attribute
					val valueCol = 'valueCol'.fetch as Column
					val t = 't'.fetch as Table
					// bindings
					valueCol.name = 'value'
					valueCol.table = t
					valueCol.type = a.type.name.toDbType
				]).build()
				
				.out('fkCol', DB.column, [
					// environment vbles 
					val a = 'a'.fetch as Attribute
					val fkCol = 'fkCol'.fetch as Column
					// bindings
					fkCol.name = a.name + 'Id'
					fkCol.table = a.owner as Table
					fkCol.type = 'INT'
				]).build()
				.out('fk', DB.foreignKey, [
					// environment vbles 
					val a = 'a'.fetch as Attribute
					val fk = 'fk'.fetch as ForeignKey
					val fkCol = 'fkCol'.fetch as Column
					val pkCol = 'pkCol'.fetch as Column
					// bindings
					fk.parent = pkCol
					fk.child = fkCol
				]).build()
				.build(),
				new Rule('Reference2ForeignKey')
				.in('r', OO.reference).build()
				.out('fk', DB.foreignKey,  [
					// environment vbles 
					val r = 'r'.fetch as OO.Reference
					val fk = 'fk'.fetch as ForeignKey
					val fkCol = 'fkCol'.fetch as Column
					val tab = r.owner.fetch as Table
					if(!tab.primaryKeys.isEmpty)
					fk.parent = tab.primaryKeys.get(0)
					fk.child = fkCol
					fk.name = r.name
				]).build()
				.out('fkCol', DB.column, [
					// environment vbles 
					val r = 'r'.fetch as OO.Reference
					val fkCol = 'fkCol'.fetch as Column
					fkCol.type = 'INT' 
					fkCol.name = r.name + 'Id'
					fkCol.table = r.type.fetch as Table
				]).build()
				
				.build()
				))
		}
	
	def String valuesTableName(Attribute attribute) {
		attribute.owner.name + '_' + attribute.name.toFirstUpper + 'Values'
	}
	
	def String primaryKeyName(Table table) {
		table.name  + 'Id'
	}
	
	def toDbType(String string) {
		if (string.equals('String'))
			'NVARCHAR'
			else if (string.equals('Boolean'))
			'BIT'
			else if (string.equals('Integer'))
			'INT'
			else if (string.equals('Real'))
			'NUMBER'
			else
			'NVARCHAR'
			
		
	}
	
}