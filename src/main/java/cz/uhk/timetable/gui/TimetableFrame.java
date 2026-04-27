package cz.uhk.timetable.gui;

import cz.uhk.timetable.model.LocationTimetable;
import cz.uhk.timetable.utils.TimetableProvider;
import cz.uhk.timetable.utils.impl.MockTimetableProvider;
import cz.uhk.timetable.utils.impl.StagTimetableProvider;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class TimetableFrame extends JFrame {
    private LocationTimetable timetable;
    private TimetableProvider provider = new StagTimetableProvider();
    private JTable tableTimetable;
    private SearchPanel searchPanel = new SearchPanel(this);

    public TimetableFrame(){
        super("FIM rozvrhy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGui();
    }

    private void initGui() {
        timetable = provider.read("J", "J21");
        tableTimetable = new JTable(new TimetableModel());
        tableTimetable.setAutoCreateRowSorter(true);

        add(new JScrollPane(tableTimetable), BorderLayout.CENTER);
        add(searchPanel, BorderLayout.NORTH);
        pack();

    }

    public void reloadTimetable(String building, String room) {
        timetable = provider.read(building, room);
        TimetableModel model = (TimetableModel) tableTimetable.getModel();
        model.fireTableDataChanged();

        IO.println("Data reloaded for: " + building + " " + room);
    }

    class TimetableModel extends AbstractTableModel {

        @Override
        public String getColumnName(int column) {
            return switch (column) {
                case 0 -> "Zkratka";
                case 1 -> "Název";
                case 2 -> "Den";
                case 3 -> "Začátek";
                case 4 -> "Konec";
                case 5 -> "Učitel";
                default -> "";
            };
        }

        @Override
        public int getRowCount() {
            return timetable.getActivities().size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var act = timetable.getActivities().get(rowIndex);
            return switch (columnIndex) {
                case 0 -> act.getCode();
                case 1 -> act.getName();
                case 2 -> act.getDay();
                case 3 -> act.getStartTime();
                case 4 -> act.getEndTime();
                case 5 -> act.getTeacher();
                default -> null;
            };
        }


    }
}
