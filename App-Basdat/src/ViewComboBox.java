import javax.swing.*;

public class ViewComboBox {
    private JComboBox<String> ViewComboBox;
    private JButton View;

    ViewComboBox(JPanel thisPanel){
        String[] ViewComboBoxItems = {"GURU_MAPEL", "SISWA_PERKELAS", "GURU_WALIKELAS", "SISWA_NONAKADEMIK", "SISWA_PERLOMBAAN", "SISWA_LULUS_NILAI", "DATA_SISWA_KELUAR", "SISWA_PRESENSI", "SISWA_TOP_ANGKATAN2020", "SISWA_TOP_ANGKATAN2021", "SISWA_TOP_ANGKATAN2022"};

        //construct components
        ViewComboBox = new JComboBox<String> (ViewComboBoxItems);
        View = new JButton ("Lihat");

        //set component bounds (only needed by Absolute Positioning)
        ViewComboBox.setBounds (300, 70, 200, 30);
        View.setBounds (510, 70, 100, 25);

        thisPanel.add(ViewComboBox);
        thisPanel.add(View);

        View.addActionListener(e -> execSelectedView());
    }

    private Object execSelectedView() {
        LoadData.EXEC("SELECT * FROM "+ViewComboBox.getSelectedItem()+";");
        return null;
    }
}
