package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

     public LoginPage(WebDriver driver) {  	 
	       PageFactory.initElements(driver, this);
	 }

    @FindBy(id = "email") WebElement txtEmail;
    @FindBy(id = "password") WebElement txtPassword;
    @FindBy(xpath = "//*[@id=\"form\"]/div[3]/div/button") WebElement signIN;  
    
    @FindBy(linkText ="Register a new membership") WebElement registerLink;

    public void email(String mail) throws InterruptedException  { 
        txtEmail.clear();
        Thread.sleep(700); // 
        txtEmail.sendKeys(mail);
        }
    
    public void password(String pass) throws InterruptedException {
        txtPassword.clear();
        Thread.sleep(900); // 
        txtPassword.sendKeys(pass);
    }
    
    public void signin() throws InterruptedException {  
      Thread.sleep(900); // 
      	signIN.click();
    }
    
   public void clickRegisterLink() {
        registerLink.click();
	}
}
   
