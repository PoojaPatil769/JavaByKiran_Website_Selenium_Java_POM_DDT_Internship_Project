package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class AddUserPage {

    WebDriver driver;
    WebDriverWait wait;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Disable HTML5 validation
        ((JavascriptExecutor) driver)
                .executeScript("document.querySelector('form').setAttribute('novalidate','true');");
    }

    // ----------- Fields -----------
    @FindBy(id = "username") WebElement username;
    @FindBy(id = "mobile") WebElement mobile;
    @FindBy(id = "email") WebElement email;
    @FindBy(id = "course") WebElement course;
    @FindBy(id = "password") WebElement password;

    @FindBy(id = "Male") WebElement male;
    @FindBy(id = "Female") WebElement female;

    @FindBy(tagName = "select") WebElement stateDropdown;

    @FindBy(id = "submit") WebElement submitBtn;

    // ----------- Error Messages -----------
    @FindBy(id = "username_error") WebElement usernameError;
    @FindBy(id = "mobile_error") WebElement mobileError;
    @FindBy(id = "email_error") WebElement emailError;
    @FindBy(id = "course_error") WebElement courseError;
    @FindBy(id = "password_error") WebElement passwordError;
   
    // ----------- Actions -----------

    public void fillForm(String u, String m, String e, String c, String g, String s, String p) {

        if (!u.isEmpty()) username.sendKeys(u);
        if (!m.isEmpty()) mobile.sendKeys(m);
        if (!e.isEmpty()) email.sendKeys(e);
        if (!c.isEmpty()) course.sendKeys(c);
        if (!p.isEmpty()) password.sendKeys(p);

        if (!g.isEmpty()) {
            if (g.equalsIgnoreCase("male")) male.click();
            if (g.equalsIgnoreCase("female")) female.click();
        }

        if (!s.isEmpty()) {
            new Select(stateDropdown).selectByVisibleText(s);
        }
    }

    public void submit() {
        submitBtn.click();
    }

    // ----------- Alert Handling -----------

    public String handleAlertIfPresent() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (TimeoutException e) {
            return "";
        }
    }

    // ----------- Error Getters -----------

    public String getUsernameError() { return usernameError.getText(); }
    public String getMobileError() { return mobileError.getText(); }
    public String getEmailError() { return emailError.getText(); }
    public String getCourseError() { return courseError.getText(); }
    public String getPasswordError() { return passwordError.getText(); }
}
