package cz.uhk.timetable.utils.impl;

import cz.uhk.timetable.model.Activity;
import cz.uhk.timetable.model.LocationTimetable;
import cz.uhk.timetable.utils.TimetableProvider;

import java.time.LocalTime;
import java.util.List;

/**
 * fake class Provider with source data
 */
public class MockTimetableProvider implements TimetableProvider {

    @Override
    public LocationTimetable read(String building, String room) {
        var tt = new LocationTimetable(building, room);
        var activities = List.of(
                new Activity("PRO1", "Programování 1", "Úterý", LocalTime.of(12,25), LocalTime.of(13, 55), "Kozel"),
                new Activity("ZMI2", "Zaklady matematiky", "Pondělí", LocalTime.of(8,55), LocalTime.of(10, 25), "Bauer"),
                new Activity("DIMA", "Diskrétní matematika", "Čtvrek", LocalTime.of(10,35), LocalTime.of(11, 05), "Slaby")
        );
        return null;
    }
}
