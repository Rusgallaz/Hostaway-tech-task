package com.hostaway.steps;

import com.google.inject.Inject;
import com.hostaway.steps.webdriver.UrlSteps;
import com.hostaway.ui.pages.AllListingsPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.hostaway.constants.URLConstant.ALL_LISTING_PAGE_PATH;
import static com.hostaway.utils.ThreadUtil.WAIT;

public class AllListingSteps {

    @Inject private AllListingsPage allListingsPage;
    @Inject private UrlSteps urlSteps;

    public AllListingSteps openPage() {
        urlSteps.openPath(ALL_LISTING_PAGE_PATH);
        allListingsPage.getAllPropertiesLabel().shouldBe(visible, Duration.of(10, ChronoUnit.SECONDS));
        return this;
    }

    public AllListingSteps checkAllPropertiesAreDisplayed() {
        String text = allListingsPage.getAllPropertiesLabel().getText();
        int count = Integer.parseInt(text.substring(5, text.length() - 1));

        long start = System.currentTimeMillis();
        while(allListingsPage.allProperties().size() < count) {
            WAIT(100);
            allListingsPage.allProperties().last().scrollTo();
            if(System.currentTimeMillis() - start > 20_000) {
                throw new IllegalStateException("Timeout during checkAllPropertiesAreDisplayed()");
            }
        }

        allListingsPage.allProperties().shouldHave(size(count));
        return this;
    }
}
