package com.hostaway.steps;

import com.google.inject.Inject;
import com.hostaway.ui.pages.SearchPage;
import com.hostaway.steps.webdriver.UrlSteps;
import io.qameta.allure.Step;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.hostaway.constants.URLConstant.DATES_SEARCH_PAGE_PATH;
import static com.hostaway.constants.URLConstant.DEFAULT_SEARCH_PAGE_PATH;

public class SearchSteps {

    @Inject private SearchPage searchPage;
    @Inject private FiltersSteps filtersSteps;
    @Inject private UrlSteps urlSteps;

    @Step("Open search page")
    public SearchSteps openSearchPage() {
        urlSteps.openPath(DEFAULT_SEARCH_PAGE_PATH);
        return this;
    }

    @Step("Open search page with dates `{start}`-`{end}`")
    public SearchSteps openSearchPageWithDates(LocalDate start, LocalDate end) {
        urlSteps.openPath(String.format(DATES_SEARCH_PAGE_PATH, start.toString(), end.toString()));
        return this;
    }

    @Step("Wait until properties are loaded")
    public SearchSteps waitUntilPropertiesLoaded() {
        searchPage.propertiesFoundLabel().shouldBe(visible, Duration.of(15, ChronoUnit.SECONDS));
        return this;
    }

    @Step("Click on filter button")
    public SearchSteps clickFilterButton() {
        searchPage.filterButton().shouldBe(visible).click();
        return this;
    }

    @Step("Open Filters")
    public FiltersSteps openFilters() {
        clickFilterButton();
        filtersSteps.waitUntilLoaded();
        return filtersSteps;
    }

    @Step("Check properties count is `{count}`")
    public SearchSteps checkPropertiesCountIs(int count) {
        searchPage.propertiesFoundLabel().shouldHave(text(String.format("%d properties found", count)), Duration.of(15, ChronoUnit.SECONDS));
        return this;
    }
}
