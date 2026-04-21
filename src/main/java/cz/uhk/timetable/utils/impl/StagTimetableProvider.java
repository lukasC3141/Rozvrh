package cz.uhk.timetable.utils.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.uhk.timetable.model.LocationTimetable;
import cz.uhk.timetable.utils.StagTimeAdapter;
import cz.uhk.timetable.utils.TimetableProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;

public class StagTimetableProvider implements TimetableProvider {

    @Override
    public LocationTimetable read(String building, String room) {
        //1. prepare URL for load from STAG
        var url = "https://stag-demo.uhk.cz" +
                "/ws/services/rest2/rozvrhy/getRozvrhByMistnost" +
                "?semestr=LS&budova=%s&mistnost=%s&outputFormat=JSON".formatted(building, room);
        //2. connect to server
        try {
            URL server = new URL(url);
            //3. create instance gson parser
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalTime.class, new StagTimeAdapter())
                    .create();
            //4. load data of timetable with parser
            return gson.fromJson(
                    new InputStreamReader(server.openStream()),
                    LocationTimetable.class
            );
        }
        catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
