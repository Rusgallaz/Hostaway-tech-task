package com.hostaway.tests;

import com.google.inject.Inject;
import com.hostaway.core.annotations.SelenideTest;
import com.hostaway.steps.AllListingSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SelenideTest
public class AllListingTest {

    @Inject private AllListingSteps allListingSteps;

    @Test
    @DisplayName("Check all properties are displayed")
    void allPropertiesAreDisplayed() {
        allListingSteps
                .openPage()
                .checkAllPropertiesAreDisplayed();
    }
}
