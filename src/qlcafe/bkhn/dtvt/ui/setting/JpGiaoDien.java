package qlcafe.bkhn.dtvt.ui.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import qlcafe.bkhn.dtvt.ui.frmLogin;
import qlcafe.bkhn.dtvt.ui.frmMain;
import qlcafe.bkhn.dtvt.ui.home.JpHome;

@SuppressWarnings("serial")
public class JpGiaoDien extends JPanel {

    private JButton jButton1;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private frmMain frm;
    private frmLogin frmL;
    

    public JpGiaoDien() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jComboBox1 = new JComboBox<>();
        frm = new frmMain();
        frmL = new frmLogin();

        jPanel1.setPreferredSize(new java.awt.Dimension(1035, 400));

        jLabel1.setText("Đối hình nền khởi động:");

        jButton1.setText("Browse");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser= new JFileChooser();
                FileNameExtensionFilter filter=new FileNameExtensionFilter("images", "jpg","gif","png");
                fileChooser.setFileFilter(filter);
                int returnVal=fileChooser.showOpenDialog(null);
                File f=fileChooser.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        jTextField1.setText(f.getName());
                        JpHome.jLabel1.setIcon(new ImageIcon(ImageIO.read(f)));
                    } catch (IOException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        jLabel3.setText("Đổi giao diện:");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Nimbus", "Metal", "CDE/Motif", "Windows", "Windows Classic"}));
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String x = (String) jComboBox1.getSelectedItem();
                if(x.equals("Nimbus")){
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(x.equals("Metal")){
                    try {
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(x.equals("CDE/Motif")){
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(x.equals("Windows")){
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(x.equals("Windows Classic")){
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(JpGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                SwingUtilities.updateComponentTreeUI(frm);
                SwingUtilities.updateComponentTreeUI(frmL);
                
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jComboBox1, 0, 172, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1))
                                        .addComponent(jLabel3))
                                .addContainerGap(659, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(314, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }

}
