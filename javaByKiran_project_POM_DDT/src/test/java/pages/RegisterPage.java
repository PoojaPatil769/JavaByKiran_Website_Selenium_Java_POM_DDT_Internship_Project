package pages;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class RegisterPage {
	      WebDriverWait wait;
          WebDriver driver;

	    @FindBy(id = "name") WebElement name;
	    @FindBy(id = "mobile") WebElement mobile;
	    @FindBy(id = "email") WebElement email;
	    @FindBy(id = "password") WebElement password;
	    @FindBy(xpath = "//button[@type='submit']") WebElement signIN;
	    
	    public RegisterPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }
	    
	    public void name(String n)  {    
	    	name.sendKeys(n);
	    }
	    public void mobile(String m) {   
	    	mobile.sendKeys(m);
	    }  
	    public void email(String e)  {    
	    	email.sendKeys(e);
	    }
	    public void pass(String p)  {       	
	    	password.sendKeys(p);
	    }
	    public void btnregister() throws InterruptedException {  
	        Thread.sleep(1000); // 1 second pause
	          signIN.click();
	        Thread.sleep(1000); 
	      }
	    public String getAlertText() {
	        try {
	            Alert alert = driver.switchTo().alert();
	            String text = alert.getText();
	            alert.accept();
	            return text;
	        } catch (Exception e) {
	            return "";
	        }
	    }
        
		}

		
	      
    
    
	



