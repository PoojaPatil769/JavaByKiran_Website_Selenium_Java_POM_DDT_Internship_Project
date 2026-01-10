package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.common;
import pages.DashboardPage;
import utils.ExcelUtil;

	public class DashboardTest extends common {

	    @Test(priority = 3,dataProvider = "dashboardData")
	    public void verifyDashboard(String tcId,
	    		                        String expectedTitle,
	    		                        String MenuCount,
	    		                        String courseCount,
	    		                        String MenuName,
	    		                        String CourseName ) throws InterruptedException {
	    	
	        //  Step 2 Wait for Dashboard to load
	        DashboardPage d = new DashboardPage(driver);
	        
	       
	        Assert.assertEquals(
	                d.getDashboardTitle(),
	                expectedTitle,
	                "Dashboard title mismatch"
	        );

	        // Validate course count
	        Assert.assertEquals(
	                d.getCoursesCount(),
	                Integer.parseInt(courseCount),
	                "Course count mismatch"
	        );	        
	               d.printCourseNames();
	        
	         // Validate menu count
	        Assert.assertEquals(
	                d.getLeftMenuCount(),
	                Integer.parseInt(MenuCount),
	                "menu count mismatch"
            );
	           // Print Menu Names
	            d.PrintMenuNames();
	        System.out.println(driver.getTitle());
	    } 
	    @DataProvider
        public Object[][] dashboardData() throws Exception {
            return ExcelUtil.getData("dashboard");
        }
	    }
	   	    
