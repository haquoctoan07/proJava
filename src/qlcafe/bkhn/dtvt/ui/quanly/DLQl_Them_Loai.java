package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.banhang.JpThucDon;

@SuppressWarnings("serial")
public class DLQl_Them_Loai extends JDialog {
	private JColorChooser chonmau;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jpchonmau;
    private JTextField txtTenLoai;
    ConnectSQL cn = new ConnectSQL();
    
    public DLQl_Them_Loai(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        ColorSelectionModel model = chonmau.getSelectionModel();
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                Color cl = chonmau.getColor();
                String hex = String.format("#%06x", cl.getRGB() & 0x00FFFFFF);
                jpchonmau.setBackground(Color.decode(hex));                
            }
        };
        model.addChangeListener(changeListener);        
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        txtTenLoai = new JTextField();
        jButton2 = new JButton();
        chonmau = new JColorChooser();
        jLabel3 = new JLabel();
        jpchonmau = new JPanel();
        jLabel5 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(37, 186, 173), 2));

        jLabel1.setFont(new Font("Tahoma", 1, 11)); 
        jLabel1.setText("Tên loại:");

        jLabel2.setFont(new Font("Tahoma", 1, 14)); 
        jLabel2.setForeground(new Color(51, 0, 51));
        jLabel2.setText("Thêm loại mới");

        jButton1.setFont(new Font("Tahoma", 1, 11)); 
        jButton1.setForeground(new Color(51, 0, 51));
        jButton1.setText("Hủy bỏ");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new Font("Tahoma", 1, 11)); 
        jButton2.setForeground(new Color(51, 0, 51));
        jButton2.setText("Xác nhận");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new Font("Tahoma", 1, 11)); 
        jLabel3.setText("Màu sắc:");

        jLabel5.setFont(new Font("Tahoma", 1, 12)); 
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("Màu sắc hiển thị");

        GroupLayout jpchonmauLayout = new GroupLayout(jpchonmau);
        jpchonmau.setLayout(jpchonmauLayout);
        jpchonmauLayout.setHorizontalGroup(
            jpchonmauLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jpchonmauLayout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(96, 96, 96))
        );
        jpchonmauLayout.setVerticalGroup(
            jpchonmauLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpchonmauLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(chonmau, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenLoai, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpchonmau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jpchonmau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(chonmau, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();     
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        if(txtTenLoai.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Tên loại không được để trống !");
            txtTenLoai.requestFocus();
            return;
        }
        
        Color cl = chonmau.getColor();
        String hex = String.format("#%06x", cl.getRGB() & 0x00FFFFFF);
        
        if("#ffffff".equals(hex)){
            JOptionPane.showMessageDialog(null, "Bạn cần chọn màu sắc hiển thị !");
            return;            
        }
        Loai l = new Loai();
        //l.SetMaLoai();
        l.SetTenLoai(txtTenLoai.getText());
        l.SetMauSac(hex);
        int insert = cn.InsertLoai(l);
        if(insert > 0){
            Jp_QLNhomMon.nhom.FillTable();
            Jp_QLNhomMon.nhom.updateUI();
        try{
            Jp_QLThucDon.td.Fillcbb();
            Jp_QLThucDon.td.updateUI();
            JpThucDon.td.FillLoai();
            JpThucDon.td.updateUI();
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "lỗi thêm nhommon !");
        }
        this.dispose();
        }
    }
}
