import javax.swing.*;

public class AnggotaKelompok {
    private JLabel labelAnggotaKelompok;
    private JLabel labelAnggota1;
    private JLabel labelAnggota2;
    private JLabel labelAnggota3;
    private String[] StringAnggota = {
        "Afif Nur Fauzi (M0521007)",
        "Alfiki Diastama Afan Firdaus (M0521009)",
        "Hafidh Muhammad Akbar (M0521026)"
    };
    
    public AnggotaKelompok(JPanel mainPanel) {
        

        //label
        labelAnggotaKelompok = new JLabel ("AnggotaKelompok");
        labelAnggota1 = new JLabel (StringAnggota[0]);
        labelAnggota2 = new JLabel (StringAnggota[1]);
        labelAnggota3 = new JLabel (StringAnggota[2]);

        //add ke mainPanel
        mainPanel.add (labelAnggotaKelompok);
        mainPanel.add (labelAnggota1);
        mainPanel.add (labelAnggota2);
        mainPanel.add (labelAnggota3);

        //atur posisi absolut
        int x_offset = 10;
        int y_offset = 50;
        int name_width =300;
        int name_height = 25;
        labelAnggotaKelompok.setBounds (x_offset, y_offset, name_width, 30);
        labelAnggota1.setBounds (x_offset, y_offset+30, name_width, name_height);
        labelAnggota2.setBounds (x_offset, y_offset+60, name_width, name_height);
        labelAnggota3.setBounds (x_offset, y_offset+90, name_width, name_height);
    }

}
