package pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DownloadsPage {

    WebDriver driver;
    WebDriverWait wait;

    public DownloadsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page heading
    @FindBy(xpath = "//h1[contains(text(),'Downloads')]")
    WebElement downloadsHeader;

    // Software names column
   @FindBy(xpath = "//table//tbody//tr//td[3]") List<WebElement> softwareNames;

    // Official Website buttons
    @FindBy(xpath = "//table//tbody//tr//td[last()]//a")
    List<WebElement> officialButtons;

    // Logout
    @FindBy(linkText="LOGOUT") WebElement logout;

    // ---------- Actions ----------

    public boolean isDownloadsPageDisplayed() {
        return downloadsHeader.isDisplayed();
    }

    public boolean isSoftwarePresent(String software) {
        for (WebElement s : softwareNames) {

            String actualText = s.getText()
                    .replace("\n", " ")
                    .replaceAll("\\s+", " ")
                    .trim()
                    .toLowerCase();

            String expectedText = software
                    .replaceAll("\\s+", " ")
                    .trim()
                    .toLowerCase();

            System.out.println("UI TEXT     : " + actualText);
            System.out.println("EXCEL TEXT  : " + expectedText);

            if (actualText.contains(expectedText)) {
                return true;
            }
        }
        return false;
    }
    
public void logoutWeb() {
	logout.click();
}
}
	