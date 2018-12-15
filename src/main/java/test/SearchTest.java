package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultFirstPage;
import page.SearchResultSecondPage;
import java.util.List;

public class SearchTest extends BaseTest {

    String searchTerm = "Selenium ";

    /**
     * Preconditions:
     * - Open browser
     * - Navigate to google.com
     * Scenario:
     * - Enter "Selenium" into search field
     * - Click on "Search" button
     * - Assert number of Search results is 10 on page 1
     * - Assert that each result in a list contains searchterm
     * - Click on "2" link to switch to next page
     * - Assert number of Search results is 10 on page 2
     * - Assert that each result in a list contains searchterm
     * Postcondition:
     * - Close browser
     **/
    @Test
    public void basicSearchTest() {
        String searchTerm = "Selenium";

        SearchResultFirstPage searchResultFirstPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(searchResultFirstPage.isPageLoaded(), "Search result first page is not loaded.");
        Assert.assertEquals(searchResultFirstPage.getSearchResultsCount(), 10, "Search results count is wrong.");
        List<String> searchResultFirstPageList = searchResultFirstPage.getSearchResults();

        for (String searchResult : searchResultFirstPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm " + searchTerm + " not found in: \n" + searchResult);
        }

        SearchResultSecondPage searchResultSecondPage = searchResultFirstPage.navigateToSecondPage();
        Assert.assertTrue(searchResultSecondPage.isPageLoaded(), "Search result second page is not loaded.");
        Assert.assertEquals(searchResultFirstPage.getSearchResultsCount(), 10, "Search results count is wrong.");
        List<String> searchResultSecondPageList = searchResultFirstPage.getSearchResults();

        for (String searchResult : searchResultSecondPageList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm " + searchTerm + " not found in: \n" + searchResult);
        }
    }
}