import javax.swing.*;

public class ViewComboBox {
    private JComboBox ViewComboBox;
    private JButton View;

    ViewComboBox(JPanel thisPanel){
        String[] ViewComboBoxItems = {"GURU_MAPEL", "SISWA_PERKELAS", "GURU_WALIKELAS", "SISWA_NONAKADEMIK", "SISWA_PERLOMBAAN", "SISWA_LULUS_NILAI", "DATA_SISWA_KELUAR", "SISWA_PRESENSI", "SISWA_TOP_ANGKATAN2020", "SISWA_TOP_ANGKATAN2021", "SISWA_TOP_ANGKATAN2022"};

        //construct components
        ViewComboBox = new JComboBox (ViewComboBoxItems);
        View = new JButton ("Lihat");

        //add components
        add (ViewComboBox);
        add (View);

        //set component bounds (only needed by Absolute Positioning)
        ViewComboBox.setBounds (300, 70, 100, 25);
        View.setBounds (410, 70, 100, 25);
    }
}
