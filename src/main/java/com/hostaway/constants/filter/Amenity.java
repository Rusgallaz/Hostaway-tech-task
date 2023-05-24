package com.hostaway.constants.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Amenity {
    BeachFront("Beach front"),
    FreeWiFi("Free WiFi"),
    AirConditioning("Air conditioning"),
    PetsAllowed("Pets allowed"),
    StreetParking("Street parking"),
    SwimmingPool("Swimming pool"),
    Kitchen("Kitchen"),
    WashingMachine("Washing Machine"),
    HotTub("Hot tub"),
    SuitableForChildren("Suitable for children");

    private String value;

}
