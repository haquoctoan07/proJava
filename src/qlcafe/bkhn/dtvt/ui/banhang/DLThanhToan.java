package qlcafe.bkhn.dtvt.ui.banhang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.models.HoaDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;

@SuppressWarnings("serial")
public class DLThanhToan extends JDialog {

    private JButton btnhuy;
    private JButton btnxacnhan;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JLabel lblTongTien;
    private JLabel lbltienthoi;
    private JTextField txtTienDua;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    ConnectSQL cn = new ConnectSQL();
    int tong, MaHD;
    int MaBan;

    public DLThanhToan(Frame parent, boolean modal, int tongtien, String tenban, int maban, int mahd) {
        super(parent, modal);
        initComponents();
        tong = tongtien;
        MaHD = mahd;
        MaBan = maban;
        jLabel1.setText(tenban + " - Thanh toán");
        lblTongTien.setText(String.valueOf(chuyentien.format(tongtien) + " VNĐ"));
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        lblTongTien = new JLabel();
        jLabel4 = new JLabel();
        txtTienDua = new JTextField();
        btnhuy = new JButton();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        lbltienthoi = new JLabel();
        btnxacnhan = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new Point(500, 200));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new Color(216, 226, 67));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(51, 0, 51)));

        lblTongTien.setFont(new Font("Tahoma", 1, 14));
        lblTongTien.setForeground(new Color(220, 33, 33));
        lblTongTien.setText("....");

        jLabel4.setFont(new Font("Tahoma", 1, 11));
        jLabel4.setText("Tiền thừa");

        txtTienDua.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txtTienDuaKeyReleased(evt);
            }
        });

        btnhuy.setFont(new Font("Tahoma", 1, 11));
        btnhuy.setForeground(new Color(51, 51, 51));
        //bnthuy.setB
        btnhuy.setText("Hủy bỏ");
        btnhuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnhuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 1, 18));
        jLabel1.setForeground(new Color(0, 51, 0));
        jLabel1.setText("Bàn 5 - Thanh toán");

        jLabel3.setFont(new Font("Tahoma", 1, 11));
        jLabel3.setText("Số tiền khách đưa:");

        lbltienthoi.setFont(new Font("Tahoma", 1, 12));
        lbltienthoi.setForeground(new Color(209, 20, 20));
        lbltienthoi.setText("...");

        btnxacnhan.setFont(new Font("Tahoma", 1, 11));
        btnxacnhan.setForeground(new Color(51, 51, 51));
        btnxacnhan.setText("Xác nhận");
        btnxacnhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnxacnhanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Tahoma", 1, 11));
        jLabel2.setText("Số tiền cần trả:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lblTongTien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtTienDua, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 17, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lbltienthoi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jLabel1))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addComponent(btnxacnhan)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(btnhuy)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lblTongTien))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtTienDua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(lbltienthoi))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnhuy, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                        .addComponent(btnxacnhan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnhuyActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void txtTienDuaKeyReleased(KeyEvent evt) {
        try {
            int tiendua = Integer.parseInt(txtTienDua.getText());
            if (tiendua - tong >= 0) {
                lbltienthoi.setText(String.valueOf(chuyentien.format(tiendua - tong)) + " VNĐ");
            }
        } catch (Exception e) {
            txtTienDua.setText("");
            //JOptionPane.showMessageDialog(null, "Thiếu tiền !");
        }
    }

    private void btnxacnhanActionPerformed(ActionEvent evt) {
        try {
            int tiendua = Integer.parseInt(txtTienDua.getText());
            if (tiendua - tong >= 0){
                //Sau khi xác nhận thanh toán
                Ban b = new Ban();
                b.SetTrangThai("Trống");
                b.SetMaBan(MaBan);
                cn.UpDateTrangThaiBan(b);

                HoaDon hd = new HoaDon();
                hd.SetTongTien(tong);
                hd.SetMaHD(MaHD);
                cn.ThanhToan(hd);

                JpBanHang.bh.FillBan();
                JpGoiMon.gm.removeAll();
                JpBanHang.bh.fillLb();
                this.dispose();
            } else{
                JOptionPane.showMessageDialog(null, "Không đủ tiền !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa nhập tiền !");
            txtTienDua.setText("");
        }

    }
}
