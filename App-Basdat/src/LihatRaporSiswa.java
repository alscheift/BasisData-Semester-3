import javax.swing.*;

public class LihatRaporSiswa {
    private JLabel lihatNilaiSiswa;
    private JTextField fieldNIS;
    private JTextField fieldSemester;
    private JLabel labelNIS;
    private JLabel labelSemester;
    private JButton buttonLihatRapor;

    public LihatRaporSiswa(JPanel mainPanel) {
        fieldNIS = new JTextField(5);
        lihatNilaiSiswa = new JLabel("Lihat Rapor Siswa");
        fieldSemester = new JTextField(5);
        labelNIS = new JLabel("NIS");
        labelSemester = new JLabel("Semester");
        buttonLihatRapor = new JButton("Lihat");

        // add components
        mainPanel.add(fieldNIS);
        mainPanel.add(lihatNilaiSiswa);
        mainPanel.add(fieldSemester);
        mainPanel.add(labelNIS);
        mainPanel.add(labelSemester);
        mainPanel.add(buttonLihatRapor);

        int x_offset = 0;
        int y_offset = 380;
        // set component bounds (only needed by Absolute Positioning)
        fieldNIS.setBounds(x_offset+20, y_offset+50, 100, 25);
        lihatNilaiSiswa.setBounds(x_offset+20, y_offset+0, 150, 25);
        fieldSemester.setBounds(x_offset+130, y_offset+50, 100, 25);
        labelNIS.setBounds(x_offset+20, y_offset+25, 100, 25);
        labelSemester.setBounds(x_offset+130, y_offset+25, 100, 25);
        buttonLihatRapor.setBounds(x_offset+245, y_offset+50, 100, 25);

        buttonLihatRapor.addActionListener(e-> LihatNilainyeaa());

    }

    private Object LihatNilainyeaa() {
        LoadData.EXEC("EXEC RAPOR_SISWA @NisSiswa = "+ fieldNIS.getText()+", @SemesterSiswa = "+fieldSemester.getText()+";");
        return null;
    }

}
