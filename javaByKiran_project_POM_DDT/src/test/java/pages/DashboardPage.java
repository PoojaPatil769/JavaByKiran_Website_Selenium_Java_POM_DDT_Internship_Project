package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
      WebDriver driver;
      WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        // Dashboard header
        @FindBy(xpath = "/html/body/div/div[1]/section[1]/ol/li[2]")
        private WebElement dashtitle;

        // Course cards (for course count)
        @FindBy(xpath = "//div[@class='col-lg-3 col-xs-6']")
        private List<WebElement> courses;

        // Course names
        @FindBy(xpath = "//h3")
        private List<WebElement> courseNames;
        
        //LEFT MENU LIST
        @FindBy(xpath = "//ul[@class='sidebar-menu']/li/a/span")
        private List<WebElement> leftMenuItems;

        // Logout button
        @FindBy(xpath = "//a[normalize-space()='Logout']")
        private WebElement logoutBtn;
     
            // for userspage
        @FindBy(xpath = "/html/body/div/aside/section/ul/li[3]/a/span")
        WebElement usersMenu;   
        @FindBy(xpath = "/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")
        WebElement addUserbtn;
             
        @FindBy(xpath = "//span[text()='Operators']")
        WebElement operatorsMenu;
        
        @FindBy(xpath = "/html/body/div/aside/section/ul/li[5]/a/span")
        WebElement usefulLinksMenu;

        @FindBy(xpath = "/html/body/div/aside[1]/section/ul/li[6]/a/span")
        WebElement download;
        
        //  dashboard Actions
        public String getDashboardTitle() {
            return dashtitle.getText();
        }

        public int getCoursesCount() {
            return courses.size();
        }

        public void printCourseNames() {
            for (WebElement course : courseNames) {
                System.out.println(course.getText());
            }
        }     
        public int getLeftMenuCount() {
            return leftMenuItems.size();
        }
        
        public void PrintMenuNames() {
	        for (WebElement menu : leftMenuItems) {
	            System.out.println(menu.getText());
	        }
        }
        
        public void goToAddUserPage() throws InterruptedException {
            usersMenu.click();
            Thread.sleep(1000);
            addUserbtn.click();         
        }
   
        public void goToOperatorsPage() {
            operatorsMenu.click();
        }
             
        public void goToUsefulLinksPage() {
            usefulLinksMenu.click();
        }

        public void goTodownloadPage() {
        	download.click();
        }
            
	}

    



