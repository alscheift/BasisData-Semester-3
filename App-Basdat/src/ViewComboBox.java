import javax.swing.*;
import java.util.Arrays;

public class ViewComboBox {
    private JComboBox<String> ViewComboBox;
    private JButton View;
    private static String[] ViewComboBoxItems = {"GURU_MAPEL", "SISWA_PERKELAS", "GURU_WALIKELAS", "SISWA_NONAKADEMIK", "SISWA_PERLOMBAAN", "SISWA_LULUS_NILAI", "DATA_SISWA_KELUAR", "SISWA_PRESENSI", "SISWA_TOP_ANGKATAN2020", "SISWA_TOP_ANGKATAN2021", "SISWA_TOP_ANGKATAN2022"};
    private static String[] comboBoxName = {"1. Menampilkan data guru dan nama mata pelajaran yang diampu",
                                "2. Menampilkan data siswa perkelas",
                                "3. Menampilkan nama guru yang menjadi wali kelas",
                                "4. Menampilkan nama siswa yang mengikuti ekstrakurikuler dan organisasi",
                                "5. Menampilkan nama siswa yang mengikuti perlombaan",
                                "6. Menampilkan data siswa yang telah lulus dan nilai rata-rata akhirnya",
                                "7. Menampilkan data siswa yang telah keluar",
                                "8. Menampilkan data presensi siswa",
                                "9. Menampilkan TOP 3 Siswa angkatan 2020 / Kelas 9",
                                "10. Menampilkan TOP 3 Siswa angkatan 2021 / Kelas 8",
                                "11. Menampilkan TOP 3 Siswa angkatan 2022 / Kelas 7"};

    public static int findIndex(String arr[], Object t)
    {
  
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
    
    ViewComboBox(JPanel thisPanel){
        //construct components
        ViewComboBox = new JComboBox<String> (comboBoxName);
        View = new JButton ("Lihat");

        //set component bounds (only needed by Absolute Positioning)
        ViewComboBox.setBounds (150, 70, 350, 30);
        View.setBounds (510, 70, 100, 25);

        thisPanel.add(ViewComboBox);
        thisPanel.add(View);

        View.addActionListener(e -> execSelectedView());
    }

    private Object execSelectedView() {

        LoadData.EXEC("SELECT * FROM "+ViewComboBoxItems[findIndex(comboBoxName, ViewComboBox.getSelectedItem())]+";");
        return null;
    }
}

