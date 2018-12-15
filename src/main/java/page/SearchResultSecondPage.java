package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultSecondPage extends BasePage{

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultStatus;

    /**
     * Constructor of SearchResultSecondPage class.
     * @param webDriver - webdriver instance from Test.
     */
    public SearchResultSecondPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Method to confirm load of page.
     * @return true/false
     */
    public boolean isPageLoaded() {
        String resultStatusText = resultStatus.getText();
        return resultStatusText.contains("страница 2")
                && webDriver.getTitle().contains("Selenium")
                && webDriver.getCurrentUrl().contains("Selenium");
    }
}
