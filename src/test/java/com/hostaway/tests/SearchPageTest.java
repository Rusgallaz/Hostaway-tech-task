package com.hostaway.tests;

import com.google.inject.Inject;
import com.hostaway.constants.filter.Amenity;
import com.hostaway.constants.filter.RoomsBeds;
import com.hostaway.core.annotations.SelenideTest;
import com.hostaway.steps.FiltersSteps;
import com.hostaway.steps.SearchSteps;
import com.hostaway.steps.webdriver.UrlSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static com.hostaway.constants.URLConstant.DATES_SEARCH_PAGE_PATH;
import static com.hostaway.constants.filter.RoomsBeds.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SelenideTest
public class SearchPageTest {

    @Inject private SearchSteps searchSteps;
    @Inject private FiltersSteps filtersSteps;
    @Inject private UrlSteps urlSteps;

    private LocalDate today = LocalDate.now();
    private LocalDate nextWeek = LocalDate.now().plusDays(7);

    @Test
    @DisplayName("Apply rooms and beds filter")
    void applyRoomsBedsFilter() {
        searchSteps
                .openSearchPage()
                .openFilters();
        filtersSteps
                .increaseRoomsBeds(Beds, 3)
                .decreaseRoomsBeds(Beds, 2)
                .increaseRoomsBeds(Bedrooms, 2)
                .checkRoomsBedsValue(Beds, 1)
                .checkRoomsBedsValue(Bedrooms, 2)
                .checkRoomsBedsValue(Bathrooms, 0)
                .applyFilters();
        searchSteps
                .checkPropertiesCountIs(30);
    }

    @ParameterizedTest
    @EnumSource(RoomsBeds.class)
    @DisplayName("Min values for rooms and beds filter")
    void minValuesForRoomsBedsFilter(RoomsBeds filter) {
        searchSteps
                .openSearchPage()
                .openFilters();
        filtersSteps
                .checkMinusButtonDisabled(filter)
                .decreaseRoomsBeds(filter, 2)
                .checkRoomsBedsValue(filter, 0);
    }

    @ParameterizedTest
    @EnumSource(RoomsBeds.class)
    @DisplayName("Max values for rooms and beds filter")
    void maxValuesForRoomsBedsFilter(RoomsBeds filter) {
        searchSteps
                .openSearchPage()
                .openFilters();
        filtersSteps
                .increaseRoomsBeds(filter, 11)
                .checkPlusButtonDisabled(filter)
                .checkRoomsBedsValue(filter, 10);
    }

    @Test
    @DisplayName("Price filter")
    void priceFilter() {
        searchSteps
                .openSearchPageWithDates(today, nextWeek)
                .openFilters();
        filtersSteps
                .enterFromPrice("100")
                .enterToPrice("1000")
                .checkPriceRange("100", "1000")
                .applyFilters();
        searchSteps
                .checkPropertiesCountIs(57);
    }

    @Test
    @DisplayName("Price filter is disabled without date")
    void priceFilterDisabledWithoutDate() {
        searchSteps
                .openSearchPage()
                .openFilters();
        filtersSteps
                .checkPriceDisabled();
    }

    @ParameterizedTest
    @DisplayName("Amenity checkbox is applied")
    @MethodSource("amenityAndPropertiesSource")
    void amenityFilter(Amenity amenity, int propertiesCount) {
        searchSteps
                .openSearchPage()
                .openFilters();
        filtersSteps
                .clickCheckbox(amenity)
                .applyFilters();
        searchSteps
                .checkPropertiesCountIs(propertiesCount);
    }

    @MethodSource
    static Stream<Arguments> amenityAndPropertiesSource() {
        return Stream.of(
                arguments(Amenity.BeachFront, 8),
                arguments(Amenity.FreeWiFi, 13),
                arguments(Amenity.AirConditioning, 63),
                arguments(Amenity.PetsAllowed, 9),
                arguments(Amenity.StreetParking, 8),
                arguments(Amenity.SwimmingPool, 8),
                arguments(Amenity.Kitchen, 9),
                arguments(Amenity.WashingMachine, 14),
                arguments(Amenity.HotTub, 8),
                arguments(Amenity.SuitableForChildren, 62)
        );
    }

    @Test
    @DisplayName("Clear all filters")
    void clearAllFilters() {
        searchSteps
                .openSearchPageWithDates(today, nextWeek)
                .openFilters();
        filtersSteps
                .enterFromPrice("100")
                .enterToPrice("1000")
                .increaseRoomsBeds(Beds, 1)
                .increaseRoomsBeds(Bedrooms, 1)
                .increaseRoomsBeds(Bathrooms, 1)
                .clickCheckbox(Amenity.BeachFront)
                .clearAllFilters()
                .applyFilters();
        urlSteps
                .checkPath(String.format(DATES_SEARCH_PAGE_PATH, today, nextWeek));
    }

    @Test
    @DisplayName("Don't apply filters")
    void quitFiltersWithoutApplying() {
        searchSteps
                .openSearchPageWithDates(today, nextWeek)
                .openFilters();
        filtersSteps
                .enterFromPrice("100")
                .enterToPrice("1000")
                .increaseRoomsBeds(Beds, 1)
                .increaseRoomsBeds(Bedrooms, 1)
                .increaseRoomsBeds(Bathrooms, 1)
                .clickCheckbox(Amenity.BeachFront)
                .closeFilters();
        urlSteps
                .checkPath(String.format(DATES_SEARCH_PAGE_PATH, today, nextWeek));
    }
}
