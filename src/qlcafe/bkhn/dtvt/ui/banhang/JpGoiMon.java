package qlcafe.bkhn.dtvt.ui.banhang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.models.DsOrder;
import qlcafe.bkhn.dtvt.models.HoaDon;
import qlcafe.bkhn.dtvt.models.ThucDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.Run;
import qlcafe.bkhn.dtvt.ui.quanly.Jp_QLBan;

@SuppressWarnings("serial")
public final class JpGoiMon extends JPanel {

    private JButton btndatban;
    private JButton btngoi;
    private JButton btnthugon;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;

    private JPanel jPanel1;

    private JScrollPane jScrollPane1;

    private JSeparator jSeparator1;

    private JPanel jpDsMon;
    private JPanel jpThongTinBan;
    private JPanel jpThongTinThanhToan;
    private JPanel jpthucdon;
    private JLabel lblTenBan;
    private JLabel lblgiamgia;
    private JLabel lblgioden;
    private JLabel lbltienmon;
    private JLabel lbltongtien;
    private JLabel lbltrangthai;

    String TenBan;
    int MaBan;
    int MaHD, tienmon = 0, tongtien = 0;
    ConnectSQL cn = new ConnectSQL();
    HoaDon arrhd;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    ArrayList<DsOrder> order;

    public static JpGoiMon gm;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");

    public JpGoiMon(String trangthai, String tenban, int maban) {
        initComponents();
        gm = this;
        MaBan = maban;
        TenBan = tenban;

        jpDsMon.setVisible(false);
        jpThongTinThanhToan.setVisible(false);
        jScrollPane1.setVisible(false);

        //Lấy hóa đơn theo mã bàn
        arrhd = cn.GetHDbyMaBan(maban);
        if (arrhd != null) {
            order = cn.GetDsOrder(arrhd.GetMaHD());
            fillDsMon(0);
            MaHD = arrhd.GetMaHD();
            lblgioden.setText(df.format(arrhd.GetGioDen()));
        }
        lblTenBan.setText(tenban);
        lbltrangthai.setText(trangthai);

        if (lbltrangthai.getText().equals("Trống")) {
            btndatban.setText("Đặt chỗ");
            return;

        }
        if (lbltrangthai.getText().equals("Đã đặt trước")) {
            btndatban.setText("Hủy đặt");
            return;
        }
        if (lbltrangthai.getText().equals("Đang phục vụ")) {
            btndatban.setVisible(false);
            btnthugon.setVisible(false);
            JpThucDon thucdon = new JpThucDon();
            thucdon.tenban = TenBan;
            thucdon.maban = maban;
            jpthucdon.removeAll();
            jpthucdon.add(thucdon);
            jpthucdon.updateUI();
        }
    }

    private void initComponents() {

        jLabel5 = new JLabel();
        jpThongTinBan = new JPanel();
        lblTenBan = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel6 = new JLabel();
        lblgioden = new JLabel();
        lbltrangthai = new JLabel();
        jPanel1 = new JPanel();
        btndatban = new JButton();
        btngoi = new JButton();
        jSeparator1 = new JSeparator();
        jpThongTinThanhToan = new JPanel();
        lbltongtien = new JLabel();
        jLabel8 = new JLabel();
        lblgiamgia = new JLabel();
        jLabel7 = new JLabel();
        lbltienmon = new JLabel();
        jLabel9 = new JLabel();
        btnthugon = new JButton();
        jScrollPane1 = new JScrollPane();
        jpDsMon = new JPanel();
        jpthucdon = new JPanel();
        jLabel1 = new JLabel();

        jLabel5.setFont(new Font("Tahoma", 1, 11));
        jLabel5.setForeground(new Color(51, 0, 0));
        jLabel5.setText("Thời gian phục vụ gần nhất");

        setBackground(Color.decode("#e6e6e6"));

        jpThongTinBan.setBackground(Color.decode("#e6e6e6"));
        jpThongTinBan.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jpThongTinBan.setAutoscrolls(true);

        lblTenBan.setFont(new Font("Tahoma", 1, 24));
        lblTenBan.setForeground(new Color(102, 51, 0));
        lblTenBan.setText("Bàn 1");

        jLabel2.setFont(new Font("Tahoma", 1, 11));
        jLabel2.setForeground(new Color(51, 51, 0));
        jLabel2.setText("Giờ đến:");

        jLabel3.setFont(new Font("Tahoma", 1, 12));
        jLabel3.setForeground(new Color(102, 0, 0));
        jLabel3.setText("Status:");

        jLabel6.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/logo_goi_mon.png")));

        lblgioden.setText(".....");

        lbltrangthai.setText("....");

        jPanel1.setBackground(Color.decode("#e6e6e6"));

        btndatban.setFont(new Font("Tahoma", 1, 9));
        btndatban.setForeground(new Color(102, 51, 0));
        btndatban.setText("Đặt chỗ");
        btndatban.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btndatban.setPreferredSize(new Dimension(100, 40));
        btndatban.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btndatbanActionPerformed(evt);
            }
        });
        jPanel1.add(btndatban);

        btngoi.setFont(new Font("Tahoma", 1, 9));
        btngoi.setForeground(new Color(102, 51, 0));
        btngoi.setText("Gọi món");
        btngoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btngoi.setPreferredSize(new Dimension(100, 40));
        btngoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btngoiActionPerformed(evt);
            }
        });
        jPanel1.add(btngoi);

        jSeparator1.setBackground(Color.decode("#e6e6e6"));
        jSeparator1.setForeground(new Color(21, 75, 158));

        jpThongTinThanhToan.setBackground(Color.decode("#d8ed1a"));
        jpThongTinThanhToan.setAutoscrolls(true);
        jpThongTinThanhToan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jpThongTinThanhToan.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jpThongTinThanhToanMousePressed(evt);
            }
        });

        lbltongtien.setFont(new Font("Tahoma", 1, 11));
        lbltongtien.setForeground(new Color(255, 0, 0));
        lbltongtien.setText("0");

        jLabel8.setFont(new Font("Tahoma", 1, 11));
        jLabel8.setForeground(new Color(51, 0, 51));
        jLabel8.setText("Giảm giá:");

        lblgiamgia.setFont(new Font("Tahoma", 1, 10));
        lblgiamgia.setForeground(new Color(51, 0, 51));
        lblgiamgia.setText("0");
        lblgiamgia.setBackground(Color.RED);

        jLabel7.setFont(new Font("Tahoma", 1, 11));
        jLabel7.setForeground(new Color(51, 0, 51));
        jLabel7.setText("Tiền món:");

        lbltienmon.setFont(new Font("Tahoma", 1, 10));
        lbltienmon.setText("0");

        jLabel9.setFont(new Font("Tahoma", 1, 15));
        jLabel9.setForeground(new Color(255, 0, 0));
        jLabel9.setText("THÀNH TIỀN:");

        GroupLayout jpThongTinThanhToanLayout = new GroupLayout(jpThongTinThanhToan);
        jpThongTinThanhToan.setLayout(jpThongTinThanhToanLayout);
        jpThongTinThanhToanLayout.setHorizontalGroup(
                jpThongTinThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblgiamgia, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                                        .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbltienmon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(5, 5, 5))
                                        .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbltongtien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(10, 30, 40))
        );
        jpThongTinThanhToanLayout.setVerticalGroup(
                jpThongTinThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(lbltienmon))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(lblgiamgia))
                                .addGap(18, 40, 40)
                                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(lbltongtien))
                                .addContainerGap())
        );

        btnthugon.setFont(new Font("Tahoma", 1, 12));
        btnthugon.setForeground(new Color(0, 51, 51));
        btnthugon.setText("<<");
        btnthugon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnthugonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(Color.decode("#e6e6e6"));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jpDsMon.setBackground(Color.decode("#e6e6e6"));
        jpDsMon.setMaximumSize(new Dimension(32767, 400));
        jpDsMon.setOpaque(false);

        GroupLayout jpDsMonLayout = new GroupLayout(jpDsMon);
        jpDsMon.setLayout(jpDsMonLayout);
        jpDsMonLayout.setHorizontalGroup(
                jpDsMonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 297, Short.MAX_VALUE)
        );
        jpDsMonLayout.setVerticalGroup(
                jpDsMonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 265, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jpDsMon);

        GroupLayout jpThongTinBanLayout = new GroupLayout(jpThongTinBan);
        jpThongTinBan.setLayout(jpThongTinBanLayout);
        jpThongTinBanLayout.setHorizontalGroup(
                jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jpThongTinBanLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                                .addComponent(lbltrangthai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(260, 260, 260))
                                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                                .addComponent(lblgioden, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(227, 227, 227))))
                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTenBan)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                .addGap(10, 30, 30)
                                                .addComponent(jpThongTinThanhToan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addComponent(btnthugon, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpThongTinBanLayout.setVerticalGroup(
                jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(lblTenBan)))
                                .addGap(18, 18, 18)
                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lblgioden))
                                .addGap(18, 18, 18)
                                .addGroup(jpThongTinBanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(lbltrangthai))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpThongTinThanhToan, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnthugon, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpthucdon.setBackground(Color.decode("#e6e6e6"));
        jpthucdon.setLayout(new BorderLayout());

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cafe-menu-background-28410418.jpg")));
        jLabel1.setMaximumSize(new Dimension(1258, 519));
        jLabel1.setMinimumSize(new Dimension(1258, 519));
        jLabel1.setPreferredSize(new Dimension(410, 470));
        jpthucdon.add(jLabel1, BorderLayout.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jpThongTinBan, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jpthucdon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jpthucdon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpThongTinBan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);
    }

    public void fillThongTin() {
        arrhd = cn.GetHDbyMaBan(MaBan);
        MaHD = arrhd.GetMaHD();
        int ck = cn.CheckDsMon(MaHD, MaBan);
        btngoi.setVisible(true);
        if (ck == 0) {
            //btngoi.setVisible(false);
            HuyHD();
        }

        if (arrhd.GetGiamGia() > 100) {
            lblgiamgia.setText(chuyentien.format(arrhd.GetGiamGia()) + " VNĐ");
            if (tienmon - arrhd.GetGiamGia() <= 0) {
                tongtien = 0;
                lbltongtien.setText("0 VNĐ");
            } else {
                tongtien = tienmon - arrhd.GetGiamGia();
                lbltongtien.setText(String.valueOf(chuyentien.format(tongtien)) + " VNĐ");
            }
        }
        if (arrhd.GetGiamGia() <= 100) {
            tongtien = tienmon - (tienmon * arrhd.GetGiamGia() / 100);
            lbltongtien.setText(String.valueOf(chuyentien.format(tongtien)) + " VNĐ");
            lblgiamgia.setText(String.valueOf(arrhd.GetGiamGia()) + " %");
        }
        lbltienmon.setText(String.valueOf(chuyentien.format(tienmon)) + " VNĐ");
    }

    public void fillDsMon(int mahd) {
        if (mahd != 0) {
            order = cn.GetDsOrder(mahd);
            arrhd = cn.GetHDbyMaBan(MaBan);
            tienmon = 0;
        }
        mahd = MaHD;
        if (order != null) {

            jpDsMon.setVisible(true);
            jpThongTinThanhToan.setVisible(true);
            jScrollPane1.setVisible(true);
            btngoi.setText("Thanh toán");

            JPanel[] pn = new JPanel[order.size()];
            jpDsMon.removeAll();
            jpDsMon.setLayout(new BoxLayout(jpDsMon, BoxLayout.Y_AXIS));
            for (int i = 0; i < order.size(); i++) {
                tienmon += order.get(i).GetGia() * order.get(i).GetSoLuong();
                pn[i] = new JPanel();
                pn[i].setName(order.get(i).GetMaMon());
                pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                pn[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                pn[i].setBackground(Color.decode("#b3ff99"));
                GridLayout gridLayout = new GridLayout();
                pn[i].setLayout(gridLayout);
                pn[i].setPreferredSize(new Dimension(275, 40));
                pn[i].setMaximumSize(new Dimension(275, 40));
//                pn[i].setMinimumSize(new Dimension(275, 42));
                JLabel tmon = new JLabel(order.get(i).GetTenMon());
                    //tmon.setPreferredSize(new Dimension(100, 25));
                    //tmon.setMinimumSize(new Dimension(100, 25));
                    tmon.setBackground(Color.decode("#03fcf4"));
                    //tmon.setOpaque(true);
                    pn[i].add(tmon).setForeground(Color.decode("#001a66"));
                JLabel ttien = new JLabel(String.valueOf(chuyentien.format(order.get(i).GetGia())) + " VNĐ", JLabel.CENTER);
                    //ttien.setSize(100, 25);
                    //ttien.setBackground(Color.decode("#f4fc03"));
                    //ttien.setOpaque(true);
                    pn[i].add(ttien).setForeground(Color.decode("#ff0000"));
                JLabel slg = new JLabel(String.valueOf(order.get(i).GetSoLuong()) + " " + order.get(i).GetDVT(), JLabel.CENTER);
                    //slg.setSize(40, 25);
                    //slg.setBackground(Color.decode("#e703fc"));
                   // slg.setOpaque(true);slg.setOpaque(true);
                    pn[i].add(slg).setForeground(Color.decode("#0b0e0f"));
                //Icon ic = new ImageIcon("/qlcafe/bkhn/dtvt/ui/images/DeleteRed.png");
                JLabel lbl = new JLabel("", JLabel.CENTER);
                lbl.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/DeleteRed.png")));
                    lbl.setName(order.get(i).GetMaMon());
                pn[i].add(lbl).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int qs;
                        ArrayList<ThucDon> td = cn.GetThucDonByMa(e.getComponent().getName());
                        qs = JOptionPane.showConfirmDialog(null, "Hủy món: " + td.get(0).GetTenMon() + " ?", "Hủy món", JOptionPane.YES_NO_OPTION);
                        if (qs == JOptionPane.YES_OPTION) {
                            int xoa = cn.DeleteMon(e.getComponent().getName(), MaHD, MaBan);
                            if (xoa == 1) {
                                fillDsMon(MaHD);
                            }
                            if (xoa == 2) {
                                fillDsMon(MaHD);
                                HuyHD();
                            }
                        }
                    }
                });
                pn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        DLSoLuong sl = new DLSoLuong(Run.QlCafe, true, e.getComponent().getName(), TenBan, MaBan);
                        sl.setVisible(true);
                    }
                });
                jpDsMon.add(pn[i], JPanel.CENTER_ALIGNMENT);
                jpDsMon.updateUI();

            }

            fillThongTin();
        }
    }

    private void HuyHD() {

        JButton btnhuy = new JButton("Hủy bàn");
        btnhuy.setPreferredSize(new Dimension(100, 40));
        btnhuy.setBounds(100, 50, 100, 40);
        jpDsMon.setLayout(null);
        btngoi.setVisible(false);
        jpThongTinThanhToan.setVisible(false);
        btnhuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Ban b = new Ban();
                b.SetTrangThai("Trống");
                b.SetMaBan(MaBan);
                cn.UpDateTrangThaiBan(b);

                JpBanHang.bh.FillBan();
                JpGoiMon.gm.removeAll();
                JpBanHang.bh.fillLb();

                HoaDon hd = new HoaDon();
                hd.SetMaHD(MaHD);
                cn.HuyHD(hd);
            }
        });
        jpDsMon.add(btnhuy);
        jpDsMon.updateUI();
    }

    private void btngoiActionPerformed(ActionEvent evt) {
        if (btngoi.getText().equals("Hủy bàn")) {

            jpthucdon.removeAll();
            jpthucdon.add(jLabel1);
            jpthucdon.updateUI();
            jpThongTinThanhToan.setVisible(false);
            btnthugon.setVisible(true);
            lblgioden.setText("......");
            lbltrangthai.setText("Trống");
            String TrangThai = "Trống";
            Ban b = new Ban(MaBan, lblTenBan.getText(), TrangThai);
            @SuppressWarnings("unused")
            int Update = cn.UpdateBan(b);
            JpBanHang.bh.FillBan();
            btngoi.setText("Gọi món");
            btndatban.setVisible(true);
            btndatban.setText("Đặt bàn");
            return;

        }
        if (btngoi.getText().equals("Thanh toán")) {
            DLThanhToan thanhtoan = new DLThanhToan(Run.QlCafe, true, tongtien, TenBan, MaBan, MaHD);//tongtien trang thai ban ten ban
            thanhtoan.setVisible(true);
            return;
        }
        if (btngoi.getText().equals("Gọi món")) {
            jpthucdon.setVisible(true);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lblgioden.setText(df.format(date));
            lbltrangthai.setText("Đang phục vụ");
            btndatban.setVisible(false);
            btnthugon.setVisible(false);

            btngoi.setText("Hủy bàn");

            JpThucDon thucdon = new JpThucDon();
            thucdon.maban = MaBan;
            thucdon.tenban = TenBan;

            thucdon.gioden = sf.format(date);
            jpthucdon.removeAll();
            jpthucdon.add(thucdon);
            jpthucdon.revalidate();
        }
    }

    private void btndatbanActionPerformed(ActionEvent evt) {
        if (lbltrangthai.getText().equals("Đã đặt trước")) {
            lbltrangthai.setText("Trống");
            btndatban.setText("Đặt chỗ");
            String TrangThai = "Trống";
            Ban b = new Ban(MaBan, TenBan, TrangThai);
            @SuppressWarnings("unused")
            int Update = cn.UpdateBan(b);
            JpBanHang.bh.FillBan();
            JpBanHang.bh.updateUI();
            //Jp_QLBan.B.FillTable();
            //Jp_QLBan.B.updateUI();
        } else {
            lbltrangthai.setText("Đã đặt trước");
            btndatban.setText("Hủy đặt");
            String TrangThai = "Đã đặt trước";
            Ban b = new Ban(MaBan, TenBan, TrangThai);
            @SuppressWarnings("unused")
            int Update = cn.UpdateBan(b);
            JpBanHang.bh.FillBan();
            JpBanHang.bh.updateUI();
            //Jp_QLBan.B.FillTable();
            //Jp_QLBan.B.updateUI();
            //            Run.QlCafe.reloadPanel(1, MaBan);
        }
    }

    private void jpThongTinThanhToanMousePressed(MouseEvent evt) {
        DLGiamGia giam = new DLGiamGia(Run.QlCafe, true, MaHD, TenBan, tienmon);
        giam.setVisible(true);
    }

    private void btnthugonActionPerformed(ActionEvent evt) {
        JpBanHang.bh.fillLb();
    }
}
