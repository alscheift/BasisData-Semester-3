import javax.swing.*;

public class LihatRaporSiswa {
    private JLabel lihatNilaiSiswa;
    private JTextField jcomp1;
    private JTextField jcomp3;
    private JLabel nis;
    private JLabel sem;
    private JButton bLihat;

    public LihatRaporSiswa(JPanel mainPanel) {
        jcomp1 = new JTextField(5);
        lihatNilaiSiswa = new JLabel("Lihat Rapor Siswa");
        jcomp3 = new JTextField(5);
        nis = new JLabel("NIS");
        sem = new JLabel("Semester");
        bLihat = new JButton("Lihat");

        // add components
        mainPanel.add(jcomp1);
        mainPanel.add(lihatNilaiSiswa);
        mainPanel.add(jcomp3);
        mainPanel.add(nis);
        mainPanel.add(sem);
        mainPanel.add(bLihat);

        int x_offset = 0;
        int y_offset = 0;
        // set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(x_offset+220, y_offset+330, 100, 25);
        lihatNilaiSiswa.setBounds(x_offset+220, y_offset+280, 100, 25);
        jcomp3.setBounds(x_offset+330, y_offset+330, 100, 25);
        nis.setBounds(x_offset+220, y_offset+305, 100, 25);
        sem.setBounds(x_offset+330, y_offset+305, 100, 25);
        bLihat.setBounds(x_offset+445, y_offset+330, 100, 25);

        bLihat.addActionListener(e-> LihatNilainyeaa());

    }

    private Object LihatNilainyeaa() {
        LoadData.EXEC("EXEC RAPOR_SISWA @NisSiswa = "+ jcomp1.getText()+", @SemesterSiswa = "+jcomp3.getText()+";");
        return null;
    }

}
