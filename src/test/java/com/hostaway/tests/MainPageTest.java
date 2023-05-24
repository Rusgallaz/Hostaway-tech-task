package com.hostaway.tests;

import com.google.inject.Inject;
import com.hostaway.core.annotations.SelenideTest;
import com.hostaway.steps.MainPageSteps;
import com.hostaway.steps.SearchSteps;
import com.hostaway.steps.webdriver.UrlSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.hostaway.constants.URLConstant.DEFAULT_SEARCH_PAGE_PATH;

@SelenideTest
public class MainPageTest {

    @Inject private MainPageSteps mainPageSteps;
    @Inject private SearchSteps searchSteps;
    @Inject private UrlSteps urlSteps;

    @Test
    @DisplayName("Open search page with search button")
    void openSearchPageWithSearchButton() {
        mainPageSteps
                .openMainPage()
                .clickSearchButton();
        searchSteps
                .waitUntilPropertiesLoaded();
        urlSteps
                .checkPath(DEFAULT_SEARCH_PAGE_PATH);
    }
}
