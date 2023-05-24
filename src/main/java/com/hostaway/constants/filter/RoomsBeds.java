package com.hostaway.constants.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoomsBeds {
    Beds("Beds"),
    Bedrooms("Bedrooms"),
    Bathrooms("Bathrooms");

    private final String value;
}
