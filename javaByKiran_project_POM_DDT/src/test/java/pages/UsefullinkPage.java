package pages;


	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class UsefullinkPage {
		

	    WebDriver driver;

	    public UsefullinkPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
		}

	
	    // Page header
	    @FindBy(xpath = "/html/body/div/div[1]/section[1]/h1")
	    WebElement usefulLinksHeader;


	    // All content names
	    @FindBy(xpath = "//table/tbody/tr/td[2]")
	    List<WebElement> linkNames;

	    // All Go buttons
	    @FindBy(xpath = "//table/tbody/tr/td[3]//a")

	    List<WebElement> goButtons;

	    // ---------- Actions ----------

	    public boolean isUsefulLinksPageDisplayed() {
	        return usefulLinksHeader.isDisplayed();
	    }

	    public int getLinksCount() {
	        return linkNames.size();
	    }

	    public boolean isLinkPresent(String linkText) {

	        String expected = linkText.trim().replaceAll("\\s+", " ");

	        for (WebElement e : linkNames) {
	            String actual = e.getText().trim().replaceAll("\\s+", " ");
	            if (actual.equalsIgnoreCase(expected)) {
	                return true;
	            }
	        }
	        return false;
	    }


	    public void clickGoButton(String linkText) {
	        for (int i = 0; i < linkNames.size(); i++) {
	            if (linkNames.get(i).getText().equalsIgnoreCase(linkText)) {
	                goButtons.get(i).click();
	                break;
	            }
	        }
	    }
	}



