package com.hostaway.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AllListingsPage {

    public SelenideElement getAllPropertiesLabel() {
        return $(byXpath("//span[contains(.,'All (')]"));
    }

    public ElementsCollection allProperties() {
        return $$(byXpath("//a[contains(@href,'/listing')]"));
    }
}
