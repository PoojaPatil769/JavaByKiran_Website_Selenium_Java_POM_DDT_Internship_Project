package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperatorsPage {

    WebDriver driver;
    WebDriverWait wait;

    public OperatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page heading
    @FindBy(xpath = "//h1[contains(text(),'Operators')]")
    private WebElement operatorsTitle;

    // Table rows
    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> tableRows;

    // Person column (2nd column)
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> operatorNames;
    
    @FindBy(xpath = "/html/body/div/aside[1]/section/ul/li[3]/a/span")
    WebElement usersMenu;

    // ---------- Actions ----------

    public boolean isOperatorsPageOpened() {
        return operatorsTitle.isDisplayed();
    }

    public int getOperatorCount() {
        return tableRows.size();
    }

    public boolean isOperatorPresent(String name) {
        for (WebElement operator : operatorNames) {
            if (operator.getText().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void printAllOperators() {
        for (WebElement operator : operatorNames) {
            System.out.println("Operator: " + operator.getText());
        }
    }
}
