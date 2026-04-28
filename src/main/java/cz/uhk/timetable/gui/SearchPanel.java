package cz.uhk.timetable.gui;

import cz.uhk.timetable.utils.TimetableProvider;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    private final String[] building = { "J", "A" };
    private final String[] roomJ = {
            "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10",
            "J11", "J12", "J13", "J14", "J15", "J16", "J17", "J18", "J19", "J20",
            "J21", "J22"
    };
    private final String[] roomA = {
            "A203", "A204", "A205"
    };
    private JComboBox<String> roomCombobox = new JComboBox<String>(roomJ);
    private JComboBox<String> buildingComboBox = new JComboBox<String>(building);
    private JLabel roomText = new JLabel("místnost: ");
    private JLabel buildingText  = new JLabel("budova: ");

    public SearchPanel(TimetableFrame frame) {initGui(frame);}

    private void initGui(TimetableFrame frame) {
        JButton btnSearch = new JButton("Hledat");

        //set room combobox based on building
        buildingComboBox.addActionListener((e) -> {
            var selected = buildingComboBox.getSelectedItem();
            //surely not null
            assert selected != null;
            if(selected.equals("A")){
                roomCombobox.setModel(new DefaultComboBoxModel<>(roomA));
            } else if (selected.equals("J")) {
                roomCombobox.setModel(new DefaultComboBoxModel<>(roomJ));
            }
        });

        btnSearch.addActionListener((e) -> {
            String roomSel = (String) roomCombobox.getSelectedItem();
            String buildingSel = (String)buildingComboBox.getSelectedItem();
            frame.reloadTimetable(buildingSel, roomSel);
        });

        add(buildingText);
        add(buildingComboBox);
        add(roomText);
        add(roomCombobox);
        add(btnSearch);
    }
}
