package qlcafe.bkhn.dtvt.ui.thongke;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import datechooser.beans.DateChooserCombo;
import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.models.DsOrder;
import qlcafe.bkhn.dtvt.models.HoaDon;
import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.models.TaiKhoan;
import qlcafe.bkhn.dtvt.models.ThucDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;

@SuppressWarnings("serial")
public final class JpThongKe extends JPanel {

    private DateChooserCombo dateChooser1;
    private DateChooserCombo dateChooser2;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JLabel lblgiam;
    private JLabel lblhd;
    private JLabel lblmon;
    private JLabel lbltaikhoan;
    private JLabel lbltienmon;
    private JLabel lbltienthu;
    private JLabel lbltongban;
    private JLabel lbltongloai;
    private JLabel lbltongmon;
    private JTable tbaleHD;
    private JTable tbmon;
    ConnectSQL cn = new ConnectSQL();
    NumberFormat chuyentien = new DecimalFormat("#,###,###");

    public JpThongKe() {
        initComponents();
        FillTableHD();
        FillTableMon();
        loadinfo();

    }

    @SuppressWarnings("unused")
    public void loadinfo() {
        ArrayList<Ban> arrTable = cn.GetBan(0);
        if (arrTable.size() > 0) {
            int soban = 0;
            for (Ban b : arrTable) {
                soban++;
            }
            lbltongban.setText(String.valueOf(soban));
        }
        ArrayList<Loai> loai = cn.GetLoai();
        if (arrTable.size() > 0) {
            int soban = 0;
            for (Loai b : loai) {
                soban++;
            }
            lbltongloai.setText(String.valueOf(soban));
        }
        ArrayList<ThucDon> td = cn.GetThucDon(null);
        if (arrTable.size() > 0) {
            int soban = 0;
            for (ThucDon b : td) {
                soban++;
            }
            lbltongmon.setText(String.valueOf(soban));
        }
        ArrayList<TaiKhoan> tk = cn.GetTaiKhoan();
        if (arrTable.size() > 0) {
            int soban = 0;
            for (TaiKhoan b : tk) {
                soban++;
            }
            lbltaikhoan.setText(String.valueOf(soban));
        }
    }

    public void FillTableHD() {
        ArrayList<HoaDon> arrTable = cn.GetDSHD();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Mã hóa đơn");
        tbmodel.addColumn("Thời gian");
        tbmodel.addColumn("Tiền món");
        tbmodel.addColumn("Giảm giá");
        tbmodel.addColumn("Thành tiền");
        tbmodel.addColumn("Điểm bán");
        tbmodel.addColumn("Các món");
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        if (arrTable.size() > 0) {
            @SuppressWarnings("unused")
            int hd = 0, tongtien = 0, tongtienmon = 0, giam = 0, tonggiam = 0;
            for (HoaDon td : arrTable) {
                hd++;
                tongtien += td.GetTongTien();
                String tenban = cn.GetBan(td.GetMaBan()).get(0).GetTenBan();
                ArrayList<DsOrder> order = cn.GetDsOrder(td.GetMaHD());
                String cacmon = "";
                int tienmon = 0;
                for (DsOrder ds : order) {
                    tienmon += ds.GetGia() * ds.GetSoLuong();
                    cacmon += ds.GetTenMon() + "(" + ds.GetSoLuong() + ")" + ", ";
                }
                tongtienmon += tienmon;

                String dv = "";
                if (td.GetGiamGia() > 100) {
                    giam = td.GetGiamGia();
                }
                if (td.GetGiamGia() == 0) {
                    giam = 0;
                }
                if (td.GetGiamGia() <= 100 && td.GetGiamGia() != 0) {
                    giam = td.GetGiamGia() * tienmon / 100;
                    dv = "(" + String.valueOf(td.GetGiamGia()) + "%)";
                }
                tonggiam += giam;
                tbmodel.addRow(new Object[]{td.GetMaHD(),
                    sf.format(td.GetGioDen()),
                    chuyentien.format(tienmon),
                    chuyentien.format(giam) + dv,
                    chuyentien.format(td.GetTongTien()),
                    tenban, cacmon});
            }
            lblgiam.setText(chuyentien.format(tonggiam) + " VNĐ");
            lbltienmon.setText(chuyentien.format(tongtienmon) + " VNĐ");
            lbltienthu.setText(chuyentien.format(tongtienmon - tonggiam) + " VNĐ");
            lblhd.setText(String.valueOf(hd) + " hóa đơn");

        }
        tbaleHD.setModel(tbmodel);
        for (int i = 0; i < tbaleHD.getColumnCount(); i++) {
            Class<?> col = tbaleHD.getColumnClass(i);
            tbaleHD.setDefaultEditor(col, null);
        }
        tbaleHD.getColumnModel().getColumn(0).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(1).setMinWidth(130);
        tbaleHD.getColumnModel().getColumn(1).setMaxWidth(130);
        tbaleHD.getColumnModel().getColumn(2).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(3).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(4).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(5).setMaxWidth(100);
    }

    public void FillTableMon() {
        ArrayList<ThucDon> arrTable = cn.GetChiTietMonByMa();

        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Tên món");
        tbmodel.addColumn("Đơn vị tính");
        tbmodel.addColumn("Số lượng");
        tbmodel.addColumn("Doanh thu");
        if (arrTable != null) {

            @SuppressWarnings("unused")
            int somon = 0, tienmon = 0;
            for (ThucDon td : arrTable) {
                ArrayList<DsOrder> ct = cn.GetGiaSoLuong(td.GetMaMon());
                if (cn.GetGiaSoLuong(td.GetMaMon()).size() > 0) {
                    int gia = 0, soluong = 0;
                    for (DsOrder i : ct) {
                        somon += i.GetSoLuong();
                        soluong += i.GetSoLuong();
                        gia += i.GetGia() * i.GetSoLuong();
                    }
                    tienmon += gia;
                    tbmodel.addRow(new Object[]{ct.get(0).GetTenMon(),
                        ct.get(0).GetDVT(),
                        soluong,
                        chuyentien.format(gia) + " VNĐ"});
                }
            }
            lblmon.setText(String.valueOf(somon) + " món");

        } else {
        }
        tbmon.setModel(tbmodel);
        for (int i = 0; i < tbmon.getColumnCount(); i++) {
            Class<?> col = tbmon.getColumnClass(i);
            tbmon.setDefaultEditor(col, null);
        }
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        tbmon = new JTable();
        jScrollPane2 = new JScrollPane();
        tbaleHD = new JTable();
        jLabel1 = new JLabel();
        lblhd = new JLabel();
        jLabel2 = new JLabel();
        lblmon = new JLabel();
        jLabel3 = new JLabel();
        lbltienthu = new JLabel();
        lbltienmon = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        lblgiam = new JLabel();
        jLabel6 = new JLabel();
        lbltongban = new JLabel();
        jLabel7 = new JLabel();
        lbltongmon = new JLabel();
        jLabel8 = new JLabel();
        lbltongloai = new JLabel();
        jLabel9 = new JLabel();
        lbltaikhoan = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jButton1 = new JButton();
        jSeparator1 = new JSeparator();
        dateChooser1 = new datechooser.beans.DateChooserCombo();
        dateChooser2 = new datechooser.beans.DateChooserCombo();

        setForeground(new Color(162, 11, 11));

        tbmon.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Tên món", "Đơn vị tính", "Số lượng", "Doanh thu"
                }
        ));
        jScrollPane1.setViewportView(tbmon);

        tbaleHD.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "Mã hóa đơn", "Thời gian", "Tiền món", "Giảm giá", "Thành tiền", "Điểm bán", "Các món"
                }
        ));
        jScrollPane2.setViewportView(tbaleHD);

        jLabel1.setFont(new Font("Tahoma", 1, 12));
        jLabel1.setText("Tổng số hóa đơn thanh toán:");

        lblhd.setFont(new Font("Tahoma", 1, 12));
        lblhd.setForeground(new Color(82, 15, 172));
        lblhd.setText(".....");

        jLabel2.setText("Tổng số món đã bán:");

        lblmon.setFont(new Font("Tahoma", 1, 12));
        lblmon.setForeground(new Color(10, 85, 157));
        lblmon.setText(".....");

        jLabel3.setFont(new Font("Tahoma", 1, 12));
        jLabel3.setText("Tiền thu về:");

        lbltienthu.setFont(new Font("Tahoma", 1, 14));
        lbltienthu.setForeground(new Color(162, 11, 11));
        lbltienthu.setText(".....");

        lbltienmon.setFont(new Font("Tahoma", 1, 11));
        lbltienmon.setForeground(new Color(162, 11, 11));
        lbltienmon.setText("....");

        jLabel4.setFont(new Font("Tahoma", 1, 12));
        jLabel4.setText("Tiền giảm giá: ");

        jLabel5.setFont(new Font("Tahoma", 1, 12));
        jLabel5.setText("Tiền món:");

        lblgiam.setFont(new Font("Tahoma", 1, 12));
        lblgiam.setForeground(new Color(16, 121, 95));
        lblgiam.setText("......");

        jLabel6.setFont(new Font("Tahoma", 1, 11));
        jLabel6.setText("Tổng số bàn: ");

        lbltongban.setFont(new Font("Tahoma", 1, 12));
        lbltongban.setForeground(new Color(17, 131, 40));
        lbltongban.setText("jLabel7");

        jLabel7.setFont(new Font("Tahoma", 1, 11));
        jLabel7.setText("Tổng số món:");

        lbltongmon.setFont(new Font("Tahoma", 1, 12));
        lbltongmon.setForeground(new Color(17, 131, 40));
        lbltongmon.setText("jLabel7");

        jLabel8.setFont(new Font("Tahoma", 1, 11));
        jLabel8.setText("Tổng số loại:");

        lbltongloai.setFont(new Font("Tahoma", 1, 12));
        lbltongloai.setForeground(new Color(17, 131, 40));
        lbltongloai.setText("jLabel7");

        jLabel9.setFont(new Font("Tahoma", 1, 11));
        jLabel9.setText("Tổng số tài khoản:");

        lbltaikhoan.setFont(new Font("Tahoma", 1, 12));
        lbltaikhoan.setForeground(new Color(17, 131, 40));
        lbltaikhoan.setText("jLabel7");

        jLabel10.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cooltext171088793851573.png")));

        jLabel11.setFont(new Font("Tahoma", 1, 14));
        jLabel11.setForeground(new Color(172, 0, 5));
        jLabel11.setText("Thống kê theo món");

        jLabel12.setFont(new Font("Tahoma", 1, 14));
        jLabel12.setForeground(new Color(153, 0, 0));
        jLabel12.setText("Thống kê theo hóa đơn");

        jLabel13.setText("Từ ngày");

        jLabel14.setText("Đến ngày");

        jButton1.setText("Thống kê");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new Color(23, 12, 132));

        dateChooser1.setCurrentView(new datechooser.view.appearance.AppearancesList("custom",
                new datechooser.view.appearance.ViewAppearance("custom",
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 0),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 0),
                                new Color(0, 0, 255),
                                true,
                                true,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 255),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(128, 128, 128),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.LabelPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.BOLD, 11),
                                new Color(0, 51, 255),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.LabelPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 0),
                                new Color(255, 0, 0),
                                false,
                                false,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        (datechooser.view.BackRenderer) null,
                        false,
                        true)));
        dateChooser1.setCalendarBackground(new Color(133, 140, 148));
        dateChooser1.setLocale(new java.util.Locale("vi", "VN", ""));
        dateChooser1.setNavigateFont(new Font("Tahoma", Font.PLAIN, 11));
        dateChooser1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        dateChooser2.setCurrentView(new datechooser.view.appearance.AppearancesList("custom",
                new datechooser.view.appearance.ViewAppearance("custom",
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 0),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.BOLD, 11),
                                new Color(0, 51, 255),
                                new Color(0, 0, 255),
                                true,
                                true,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 255),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(128, 128, 128),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.LabelPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 0),
                                new Color(0, 0, 255),
                                false,
                                true,
                                new datechooser.view.appearance.swing.LabelPainter()),
                        new datechooser.view.appearance.swing.SwingCellAppearance(new Font("Tahoma", Font.PLAIN, 11),
                                new Color(0, 0, 0),
                                new Color(255, 0, 0),
                                false,
                                false,
                                new datechooser.view.appearance.swing.ButtonPainter()),
                        (datechooser.view.BackRenderer) null,
                        false,
                        true)));
        dateChooser2.setCalendarBackground(new Color(133, 140, 148));
        dateChooser2.setLocale(new java.util.Locale("vi", "VN", ""));
        dateChooser2.setNavigateFont(new Font("Tahoma", Font.PLAIN, 11));
        dateChooser2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addGap(334, 334, 334)
                                .addComponent(jLabel13)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooser1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooser2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(39, 39, 39))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel5)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(lbltienmon, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                                                                                .addGap(44, 44, 44))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel4)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(lblgiam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addGap(8, 8, 8))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(27, 27, 27)
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(lbltienthu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                                .addGap(94, 94, 94))
                                                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblhd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lbltongban)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lbltongmon)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbltongloai)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lbltaikhoan)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblmon)
                                                                .addGap(335, 335, 335))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 726, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(dateChooser1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel14, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(dateChooser2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addGap(16, 16, 16))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblmon)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(lblhd))
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(lbltienmon))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(lblgiam))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(lbltienthu)
                                                        .addComponent(jLabel7)
                                                        .addComponent(lbltongmon)
                                                        .addComponent(jLabel6)
                                                        .addComponent(lbltongban)
                                                        .addComponent(jLabel8)
                                                        .addComponent(lbltongloai)
                                                        .addComponent(jLabel9)
                                                        .addComponent(lbltaikhoan)))
                                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void fillbydate1() {
        ArrayList<ThucDon> arrTable = cn.GetChiTietMonByMa();
        Date d1 = dateChooser1.getSelectedDate().getTime();
        Date d2 = dateChooser2.getSelectedDate().getTime();
        String s1 = String.format("%1$tY-%1$tm-%1$td", d1);
        String s2 = String.format("%1$tY-%1$tm-%1$td", d2);

        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Tên món");
        tbmodel.addColumn("Đơn vị tính");
        tbmodel.addColumn("Số lượng");
        tbmodel.addColumn("Doanh thu");
        if (arrTable.size() > 0) {
            @SuppressWarnings("unused")
            int somon = 0, tienmon = 0;
            for (ThucDon td : arrTable) {
                ArrayList<DsOrder> ct = cn.GetHdByDate(s1, s2, td.GetMaMon());
                if (ct.size() > 0) {
                    int gia = 0, soluong = 0;
                    for (DsOrder i : ct) {
                        somon += i.GetSoLuong();
                        soluong += i.GetSoLuong();
                        gia += i.GetGia() * i.GetSoLuong();
                    }
                    tienmon += gia;
                    tbmodel.addRow(new Object[]{ct.get(0).GetTenMon(),
                        ct.get(0).GetDVT(), soluong,
                        chuyentien.format(gia) + " VNĐ"});
                }
            }
            lblmon.setText(String.valueOf(somon) + " món");
            tbmon.setModel(tbmodel);
        }

        for (int i = 0; i < tbmon.getColumnCount(); i++) {
            Class<?> col = tbmon.getColumnClass(i);
            tbmon.setDefaultEditor(col, null);
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        if (dateChooser1.getText().isEmpty() || dateChooser2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn cần chọn ngày để thống kê !");
            return;
        }
        fillbydate1();
        fillbydate2();

        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void fillbydate2() {
        Date d1 = dateChooser1.getSelectedDate().getTime();
        Date d2 = dateChooser2.getSelectedDate().getTime();
        String s1 = String.format("%1$tY-%1$tm-%1$td", d1);
        String s2 = String.format("%1$tY-%1$tm-%1$td", d2);
        ArrayList<HoaDon> arrTable = cn.GetDSHD();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Mã hóa đơn");
        tbmodel.addColumn("Thời gian");
        tbmodel.addColumn("Tiền món");
        tbmodel.addColumn("Giảm giá");
        tbmodel.addColumn("Thành tiền");
        tbmodel.addColumn("Điểm bán");
        tbmodel.addColumn("Các món");
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        if (arrTable.size() > 0) {
            @SuppressWarnings("unused")
            int hd = 0, tongtien = 0, tongtienmon = 0, giam = 0, tonggiam = 0;
            for (HoaDon td : arrTable) {

                tongtien += td.GetTongTien();
                String tenban = cn.GetBan(td.GetMaBan()).get(0).GetTenBan();
                ArrayList<DsOrder> order = cn.GetCtHDByDate(td.GetMaHD(), s1, s2);
                if (order.size() > 0) {
                    hd++;
                    String cacmon = "";
                    int tienmon = 0;
                    for (DsOrder ds : order) {
                        tienmon += ds.GetGia() * ds.GetSoLuong();
                        cacmon += ds.GetTenMon() + "(" + ds.GetSoLuong() + ")" + ", ";
                    }
                    tongtienmon += tienmon;

                    String dv = "";
                    if (td.GetGiamGia() > 100) {
                        giam = td.GetGiamGia();
                    }
                    if (td.GetGiamGia() == 0) {
                        giam = 0;
                    }
                    if (td.GetGiamGia() <= 100 && td.GetGiamGia() != 0) {
                        giam = td.GetGiamGia() * tienmon / 100;
                        dv = "(" + String.valueOf(td.GetGiamGia()) + "%)";
                    }
                    tonggiam += giam;
                    tbmodel.addRow(new Object[]{td.GetMaHD(),
                        sf.format(td.GetGioDen()),
                        chuyentien.format(tienmon),
                        chuyentien.format(giam) + dv,
                        chuyentien.format(td.GetTongTien()), tenban, cacmon});

                }
            }
            lblgiam.setText(chuyentien.format(tonggiam) + " VNĐ");
            lbltienmon.setText(chuyentien.format(tongtienmon) + " VNĐ");
            lbltienthu.setText(chuyentien.format(tongtienmon - tonggiam) + " VNĐ");
            lblhd.setText(String.valueOf(hd) + " hóa đơn");
            tbaleHD.setModel(tbmodel);
        }

        for (int i = 0; i < tbaleHD.getColumnCount(); i++) {
            Class<?> col = tbaleHD.getColumnClass(i);
            tbaleHD.setDefaultEditor(col, null);
        }
        tbaleHD.getColumnModel().getColumn(0).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(1).setMinWidth(130);
        tbaleHD.getColumnModel().getColumn(1).setMaxWidth(130);
        tbaleHD.getColumnModel().getColumn(2).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(3).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(4).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(5).setMaxWidth(100);
    }
}
