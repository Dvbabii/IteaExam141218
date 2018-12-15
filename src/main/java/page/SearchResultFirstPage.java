package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class SearchResultFirstPage extends BasePage{

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultStatus;

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//*[@aria-label='Page 2']")
    private WebElement secondPageButton;

    /**
     * Constructor of SearchResultFirstPage class.
     * @param webDriver - webdriver instance from Test.
     */
    public SearchResultFirstPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Method to confirm load of page.
     * @return true/false
     */
    public boolean isPageLoaded() {
        return resultStatus.isDisplayed()
                && webDriver.getTitle().contains("Selenium")
                && webDriver.getCurrentUrl().contains("Selenium");
    }

    /**
     * Getting number of results displayed.
     * @return number of results.
     */
    public int getSearchResultsCount() {
        return searchResults.size();
    }

    /**
     * Method to return list of results.
     * @return texted list of displayed results.
     */
    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

    /**
     * Method to navigate to secong result page.
     * @return SearchResultSecondPage object.
     */
    public SearchResultSecondPage navigateToSecondPage() {
        secondPageButton.click();
        return new SearchResultSecondPage(webDriver);
    }

}
