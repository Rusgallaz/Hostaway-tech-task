package com.hostaway.ui.elements.filter;

import com.codeborne.selenide.SelenideElement;
import com.hostaway.constants.filter.RoomsBeds;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FiltersWindowElement {

    public SelenideElement window() {
        return $(byXpath("//*[contains(@class, '__modal')]"));
    }

    public RoomBedsFilterElement roomBedsFilter(RoomsBeds filter) {
        String xpath = String.format(".//div[text()='%s']//following-sibling::div", filter.getValue());
        return new RoomBedsFilterElement(window().$(byXpath(xpath)));
    }

    public SelenideElement fromInput() {
        return window().$(byXpath(".//input[@placeholder='From']"));
    }

    public SelenideElement toInput() {
        return window().$(byXpath(".//input[@placeholder='To']"));
    }

    public SelenideElement amenityCheckbox(String value) {
        return window().$(byXpath(String.format(".//span[contains(.,'%s')]", value)));
    }

    public SelenideElement applyButton() {
        return window().$(byXpath(".//button[contains(.,'Apply')]"));
    }

    public SelenideElement clearAllButton() {
        return window().$(byXpath(".//b[contains(.,'Clear all')]"));
    }

    public SelenideElement closeButton() {
        return window().$(byXpath(".//*[name()='use' and @*='#close']"));
    }

}
