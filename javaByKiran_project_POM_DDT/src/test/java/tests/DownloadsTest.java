package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.common;
import pages.DashboardPage;
import pages.DownloadsPage;
import utils.ExcelUtil;

public class DownloadsTest extends common {
	
	 DownloadsPage dp1;
    @Test(priority = 7,dataProvider = "downloadsData")
    public void verifyDownloadsPage(String tcId,
                                    String softwareName,
                                    String expectedResult) {

        // Navigate to Downloads page
 	   DashboardPage dp  = new DashboardPage(driver);
        dp.goTodownloadPage();

       dp1 = new DownloadsPage(driver);
      
        // Verify Downloads page
        Assert.assertTrue(dp1.isDownloadsPageDisplayed(),
                "Downloads page not loaded");


        boolean actual = dp1.isSoftwarePresent(softwareName);

        if (expectedResult.equalsIgnoreCase("PASS")) {
            Assert.assertTrue(actual,
                tcId + " : Software not found -> " + softwareName);
        } else {
            Assert.assertFalse(actual,
                tcId + " : Software should not be present -> " + softwareName);
        }
 
    }
     
    @DataProvider
    public Object[][] downloadsData() throws Exception {
        return ExcelUtil.getData("downloads");
    }
}

	
	
	
	