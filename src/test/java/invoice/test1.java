package invoice;

import junit.framework.TestCase;

public class test1 extends TestCase {
	
	public void testCase() {
		
		//count the number of test cases
	      System.out.println("No of Test Case = "+ this.countTestCases());
	      
	    //test getName 
	      String name = this.getName();
	      System.out.println("Test Case Name = "+ name);
	      
	      
	      
	      
	      
	}
	
	//tearDown used to close the connection or clean up activities
	   public void tearDown(  ) {
	   }
	
}
