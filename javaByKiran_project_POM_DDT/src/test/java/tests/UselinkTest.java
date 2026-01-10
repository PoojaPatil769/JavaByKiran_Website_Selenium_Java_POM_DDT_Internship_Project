package tests;

	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import base.common;
import pages.DashboardPage;
    import pages.UsefullinkPage;
    import utils.ExcelUtil;

	public class UselinkTest  extends common {

	    @Test(priority = 6,dataProvider = "usefulLinksData")
	    public void verifyUsefulLinksPage(String tcId,
	                                      String pageTitle,
	                                      String linkText,
	                                      String expectedResult) {

	        // Navigate to Useful Links
	        DashboardPage dp = new DashboardPage(driver);
	        dp.goToUsefulLinksPage();

	        UsefullinkPage ulp = new UsefullinkPage(driver);

	        // Verify page loaded
	        Assert.assertTrue(
	                ulp.isUsefulLinksPageDisplayed(),
	                tcId + " : Useful Links page not displayed"
	        );

	        // Verify link present
	        Assert.assertTrue(
	                ulp.isLinkPresent(linkText),
	                tcId + " : Link not found -> " + linkText
	        );

	        // Click Go button
	        ulp.clickGoButton(linkText);

	        // Simple validation (URL should change)
	        Assert.assertTrue(
	                driver.getCurrentUrl().length() > 0,
	                tcId + " : Link navigation failed"
	        );
	    }

	    @DataProvider
	    public Object[][] usefulLinksData() throws Exception {
	        return ExcelUtil.getData("usefulLinks");
	    }
	}
