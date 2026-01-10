	
package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.common;
import pages.DashboardPage;
import pages.OperatorsPage;
	import utils.ExcelUtil;

	public class OperatorsTest extends common {

	    @Test(priority = 5,dataProvider = "operatorsData")
	    public void verifyOperatorsPage(String tcId,
	                                    String expectedPage,
	                                    String minRows,
	                                    String expectedOperator) throws InterruptedException {
	    	
	    	
	    	
	    	DashboardPage dp = new DashboardPage(driver);
	        dp.goToOperatorsPage(); 
	    	 
	        OperatorsPage op = new OperatorsPage(driver);

	        // Page opened check
	        Assert.assertTrue(
	                op.isOperatorsPageOpened(),
	                tcId + " : Operators page not opened"
	        );

	        // Table row count validation
	        int actualRows = op.getOperatorCount();
	        Assert.assertTrue(
	                actualRows >= Integer.parseInt(minRows),
	                tcId + " : Operator table row count mismatch"
	        );

	        //  Validate specific operator exists
	        Assert.assertTrue(
	                op.isOperatorPresent(expectedOperator),
	                tcId + " : Operator not found -> " + expectedOperator
	        );

	        //  Print operators
	        op.printAllOperators();
	    }

	    @DataProvider
	    public Object[][] operatorsData() throws Exception {
	        return ExcelUtil.getData("operators");
	    }
	}
	
