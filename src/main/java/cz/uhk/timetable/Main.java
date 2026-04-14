package cz.uhk.timetable;

import cz.uhk.timetable.gui.TimetableFrame;

import javax.swing.*;

public class Main {
    static void main() {
        SwingUtilities.invokeLater(()-> new TimetableFrame().setVisible(true));
    }
}
