package com.hostaway.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import com.hostaway.constants.filter.Amenity;
import com.hostaway.constants.filter.RoomsBeds;
import com.hostaway.ui.elements.filter.FiltersWindowElement;
import io.qameta.allure.Step;

import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.*;

public class FiltersSteps {

    @Inject private FiltersWindowElement filtersWindow;

    @Step("Wait until filters window is appeared")
    public FiltersSteps waitUntilLoaded() {
        filtersWindow.window().shouldBe(visible);
        return this;
    }

    @Step("Increase `{filter}` by `{count}`")
    public FiltersSteps increaseRoomsBeds(RoomsBeds filter, int count) {
        SelenideElement plusButton = filtersWindow.roomBedsFilter(filter).plusButton();
        IntStream.range(0, count).forEach((i -> plusButton.click()));
        return this;
    }

    @Step("Decrease `{filter}` by `{count}`")
    public FiltersSteps decreaseRoomsBeds(RoomsBeds filter, int count) {
        SelenideElement minusButton = filtersWindow.roomBedsFilter(filter).minusButton();
        IntStream.range(0, count).forEach((i -> minusButton.click()));
        return this;
    }

    @Step("Check `{filter}` label is `{value}`")
    public FiltersSteps checkRoomsBedsValue(RoomsBeds filter, int count) {
        filtersWindow.roomBedsFilter(filter).countLabel().shouldHave(text(String.valueOf(count)));
        return this;
    }

    @Step("Check minus button for `{filter}` is disabled")
    public FiltersSteps checkMinusButtonDisabled(RoomsBeds filter) {
        filtersWindow.roomBedsFilter(filter).minusButton().shouldHave(attribute("disabled"));
        return this;
    }

    @Step("Check plus button for `{filter}` is disabled")
    public FiltersSteps checkPlusButtonDisabled(RoomsBeds filter) {
        filtersWindow.roomBedsFilter(filter).plusButton().shouldHave(attribute("disabled"));
        return this;
    }

    @Step("Enter from price `{price}`")
    public FiltersSteps enterFromPrice(String price) {
        filtersWindow.fromInput().val(price);
        return this;
    }

    @Step("Enter to price `{price}`")
    public FiltersSteps enterToPrice(String price) {
        filtersWindow.toInput().val(price);
        return this;
    }

    @Step("Check price range is `{from}` - `{to}`")
    public FiltersSteps checkPriceRange(String from, String to) {
        filtersWindow.fromInput().shouldHave(Condition.attribute("value", from));
        filtersWindow.toInput().shouldHave(Condition.attribute("value", to));
        return this;
    }

    @Step("Check price filters are disabled")
    public FiltersSteps checkPriceDisabled() {
        filtersWindow.fromInput().shouldHave(Condition.attribute("disabled"));
        filtersWindow.toInput().shouldHave(Condition.attribute("disabled"));
        return this;
    }

    @Step("Click checkbox `{value}`")
    public FiltersSteps clickCheckbox(Amenity amenity) {
        filtersWindow.amenityCheckbox(amenity.getValue()).shouldBe(visible).click();
        return this;
    }

    @Step("Apply filter")
    public FiltersSteps applyFilters() {
        filtersWindow.applyButton().shouldBe(visible).click();
        return this;
    }

    @Step("Clear all filters")
    public FiltersSteps clearAllFilters() {
        filtersWindow.clearAllButton().shouldBe(visible).click();
        return this;
    }

    @Step("Close filters window")
    public FiltersSteps closeFilters() {
        filtersWindow.closeButton().shouldBe(visible).click();
        return this;
    }

}
