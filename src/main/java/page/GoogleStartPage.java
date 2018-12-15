package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends BasePage{

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@name='btnK']")
    private WebElement searchButton;

    /**
     * Constructor of GoogleStartPage class.
     * @param webDriver - webdriver instance from Test.
     */
    public GoogleStartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Method to enter search word in search field and press Enter.
     * @param searchTerm - word to search in Google.
     * @return SearchResultFirstPage object.
     */
    public SearchResultFirstPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();

        return new SearchResultFirstPage(webDriver);
    }
}
