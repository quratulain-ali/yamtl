package cd2db

import yamtl.core.YAMTLModule.ExecutionMode

class Runner {
	def public static void main(String[] args) {
		var String inputModelPath = '''src/main/java/cd2db/generated_10k.xmi'''
		
		val xform = new oo2db
		xform.executionMode = ExecutionMode.INCREMENTAL
		val start = memoryUsageInMBs
		// PREPARE MODELS
		xform.loadInputModels(#{'oo' -> inputModelPath})
		val startTime = System.currentTimeMillis
		// EXECUTE TRAFO 
		xform.execute()
		//
		val stopTime = System.currentTimeMillis
		
		println("Time : "+ (stopTime-startTime)+ " ms")
		val stop = memoryUsageInMBs
		
		println("Memory : "+ (stop-start))
		// STORE MODELS
		var String outputModelPath = '''src/main/java/cd2db/target.xmi'''
		xform.saveOutputModels(#{'db' -> outputModelPath})
		
		// PRINT STATS
		//println(xform.toStringStats)
	}
	
		def private static long memoryUsageInMBs() {
		System.gc();
		System.gc();
		System.gc();
		
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			
		}
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024/1024;
	}
}