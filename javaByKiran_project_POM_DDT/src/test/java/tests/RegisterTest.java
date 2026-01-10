package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ExcelUtil;

public class RegisterTest extends BaseTest {

	    @Test(priority = 2,dataProvider = "registerData")
	    public void verifyRegister(String tcId,
	                               String name,
	                               String mobile,
	                               String email,
	                               String password,
	                               String ISsuccess) throws InterruptedException {

	        // go to Register page
	        LoginPage lp = new LoginPage(driver);
	        lp.clickRegisterLink();
	        
	        RegisterPage rp = new RegisterPage(driver);
        
	        WebElement nameErr =driver.findElement(By.id("name_error"));
	        WebElement moErr =driver.findElement(By.id("mobile_error"));
	        WebElement EmailErr =driver.findElement(By.id("email_error"));	        
	        WebElement PassErr =driver.findElement(By.id("password_error"));

	        if (ISsuccess.contains("1")) 
	        {    
	          	rp.name(name);
	         	rp.mobile(mobile);
	            rp.email(email);
	            rp.pass(password); 
	            
	            Thread.sleep(1200);

	          Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
	        
	        } else 
	        {   
	          	rp.name(name);
	         	rp.mobile(mobile);
	            rp.email(email);
	            rp.pass(password);  
	            Thread.sleep(1900);

	            if (nameErr.isDisplayed())
	            {
	            	  Assert.assertTrue(true);
	            } 
	             else if (moErr.isDisplayed())
	            {
	           	  Assert.assertTrue(true);
	            } 
	             else if (EmailErr.isDisplayed())
	            {
	            	  Assert.assertTrue(true);
	            } 
	             else if (PassErr.isDisplayed())
	            {
	           	  Assert.assertTrue(true);
	            } 	            
	             else if(name.isEmpty())
	             {
	                 String t1 = driver.findElement(By.id("name_error")).getText();
	                 Assert.assertEquals(t1, "Please enter Name");
	            }else if(mobile.isEmpty())
	            {   
	                String t2 = driver.findElement(By.id("mobile_error")).getText();
	                Assert.assertEquals(t2, "Please enter Mobile");
	            
	            }else if(email.isEmpty())
	             {
	                 String t3 = driver.findElement(By.id("email_error")).getText();
	                 Assert.assertEquals(t3, "Please enter Email");
	            }else if(password.isEmpty())
	            {   
	                String t4 = driver.findElement(By.id("password_error")).getText();
	                Assert.assertEquals(t4, "Please enter Password");
	            }
	            
	            System.out.println(driver.getTitle());
	            
	        }}
	            @DataProvider
	            public Object[][] registerData() throws Exception {
	                return ExcelUtil.getData("registerT");
	            }
	        }
	
	
