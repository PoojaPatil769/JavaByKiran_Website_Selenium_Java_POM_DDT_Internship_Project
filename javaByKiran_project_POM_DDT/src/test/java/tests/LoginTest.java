package tests;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @Test(priority = 1,dataProvider = "loginData")
    public void verifyLogin(String tcId,
                            String username,
                            String password,
                            String Issucess) throws InterruptedException{
    	
    LoginPage lp = new LoginPage(driver);
      
    WebElement EmailErr =driver.findElement(By.id("email_error"));
    WebElement PassErr =driver.findElement(By.id("password_error"));

        if (Issucess.contains("1")) 
        {    
          	lp.email(username);
         	lp.password(password);
            lp.signin();
          Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
        
        } else 
        {
          	lp.email(username);
         	lp.password(password);
            lp.signin();

            if (EmailErr.isDisplayed())
            {
            	  Assert.assertTrue(true);
            } 
             else if (PassErr.isDisplayed())
            {
           	  Assert.assertTrue(true);
            } 
             else if(username.isEmpty())
             {
                 String t1 = driver.findElement(By.id("email_error")).getText();
                 Assert.assertEquals(t1, "Please enter email");
            }else if(password.isEmpty())
            {   
                String t2 = driver.findElement(By.id("password_error")).getText();
                Assert.assertEquals(t2, "Please enter password");
            }
            //  Navigate to Register page
        lp.clickRegisterLink();
    }
    }
    @DataProvider
	public Object[][] loginData() throws Exception {
		return ExcelUtil.getData("loginT");
	}
}
