package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.models.ThucDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.banhang.JpThucDon;

@SuppressWarnings("serial")
public class Dl_Sua_ThucDon extends JDialog {
	private JComboBox<Object> cbbNhomMon;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JLabel lblten;
    private JTextField txtGia;
    private JTextField txtTenMon;
    private JTextField txtdvt;
    ConnectSQL cn = new ConnectSQL();
    ArrayList<ThucDon> td ;
    String MaMon;
    public Dl_Sua_ThucDon(Frame parent, boolean modal, String mamon) {
        super(parent, modal);
        initComponents();
        MaMon = mamon;
        td = cn.GetThucDonByMa(mamon);
        Fillcbb();
        lblten.setText("Sửa món - "+td.get(0).GetTenMon());
        txtTenMon.setText(td.get(0).GetTenMon());
        txtGia.setText(String.valueOf(td.get(0).GetDonGia()));
        txtdvt.setText(td.get(0).GetDVT());  

    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void Fillcbb() {
        Vector Vcbb = cn.GetNhomMon();

        if (Vcbb != null) {
			DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel(Vcbb);
            cbbmodel.removeElementAt(0);
            cbbNhomMon.setModel(cbbmodel);
            for(int i =0; i<cbbNhomMon.getItemCount();i++){
                Loai l = ((Loai)cbbNhomMon.getItemAt(i));
                if(td.get(0).GetMaLoai().equals(l.GetMaLoai())){
                    cbbNhomMon.setSelectedIndex(i);
                }
            }
        } else {
        }

    }    
    private void initComponents() {

        jPanel1 = new JPanel();
        txtGia = new JTextField();
        jButton1 = new JButton();
        txtdvt = new JTextField();
        jLabel2 = new JLabel();
        jLabel5 = new JLabel();
        lblten = new JLabel();
        jLabel4 = new JLabel();
        jButton2 = new JButton();
        cbbNhomMon = new JComboBox<>();
        txtTenMon = new JTextField();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102), 2));

        txtGia.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txtGiaKeyReleased(evt);
            }
        });

        jButton1.setFont(new Font("Tahoma", 1, 11)); 
        jButton1.setForeground(new Color(153, 51, 0));
        jButton1.setText("Xác nhận");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Tahoma", 1, 11)); 
        jLabel2.setForeground(new Color(0, 51, 0));
        jLabel2.setText("Tên món:");

        jLabel5.setFont(new Font("Tahoma", 1, 11)); 
        jLabel5.setForeground(new Color(0, 51, 0));
        jLabel5.setText("Nhóm món:");

        lblten.setFont(new Font("Tahoma", 1, 16)); 
        lblten.setForeground(new Color(51, 51, 0));
        lblten.setText("Sửa món");

        jLabel4.setFont(new Font("Tahoma", 1, 11)); 
        jLabel4.setForeground(new Color(0, 51, 0));
        jLabel4.setText("ĐVT:");

        jButton2.setFont(new Font("Tahoma", 1, 11)); 
        jButton2.setForeground(new Color(153, 51, 0));
        jButton2.setText("Hủy");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbbNhomMon.setForeground(new Color(51, 0, 51));
        cbbNhomMon.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNhomMon.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                cbbNhomMonItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new Font("Tahoma", 1, 11)); 
        jLabel3.setForeground(new Color(0, 51, 0));
        jLabel3.setText("Đơn giá:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGia, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdvt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNhomMon, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenMon, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblten)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblten)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenMon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbNhomMon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdvt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void cbbNhomMonItemStateChanged(ItemEvent evt) {
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        if(!validate(txtTenMon,txtTenMon.getText(),"Tên món")){
            return;
        }
        if(!validate(txtGia,txtGia.getText(),"Giá món")){
            return;
        }

        if(!validate(txtdvt,txtdvt.getText(),"Đơn vị tính")){
            return;
        }
        ThucDon mon = new ThucDon();
        mon.SetMaMon(MaMon);
        mon.SetTenMon(txtTenMon.getText());
        mon.SetDonGia(Integer.parseInt(txtGia.getText()));
        mon.SetDVT(txtdvt.getText());
        String MaNhom = ((Loai)cbbNhomMon.getSelectedItem()).GetMaLoai();
        mon.SetMaLoai(MaNhom);

        int Insert = cn.UpdateThucDon(mon);
        if(Insert == 0){
            JOptionPane.showMessageDialog(null, "Sửa không thành công!");
            return;
        }
        Jp_QLThucDon.td.FillTable(MaNhom);
        Jp_QLThucDon.td.updateUI();
        try{
            JpThucDon.td.FillLoai();
            JpThucDon.td.updateUI();
        }catch(Exception e){

        }
        this.dispose();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose(); 
    }

    private void txtGiaKeyReleased(KeyEvent evt) {
        try{
            Integer.parseInt(txtGia.getText());
        }catch(Exception ex){
            txtGia.setText("");
        }
    }
    private boolean validate(JTextField tf, String value, String title){
        if(value.isEmpty()){
            JOptionPane.showMessageDialog(null, title+" không được để trống !");
            tf.requestFocus();
            return false;
        }
        return true;
    }
}

