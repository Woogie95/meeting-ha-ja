package com.example.gatheringhaja.entity.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MeetingType {

    HIKING("Hiking"),
    SPORTS("Sports"),
    STUDY("Study"),
    MOVIE("Movie"),
    COOKING("Cooking"),
    MUSIC("Music"),
    TRAVEL("Travel"),
    PHOTOGRAPHY("Photography");

    private final String meetingType;

}
