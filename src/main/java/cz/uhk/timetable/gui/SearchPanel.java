package cz.uhk.timetable.gui;

import javax.swing.*;

public class SearchPanel extends JPanel {
    private final String[] building = { "A", "J" };
    private final String[] room = { "J1", "J2", "J3", "J4", "J5", "J6"};
    private final JComboBox<String> roomCombobox = new JComboBox<String>(room);
    private final JComboBox<String> buildingComboBox = new JComboBox<String>(building);

}
