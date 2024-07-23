package qlcafe.bkhn.dtvt.ui.banhang;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.models.ThucDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.Run;

@SuppressWarnings("serial")
public class JpThucDon extends JPanel {

    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jpChonMon;
    private JPanel jpLoai;
    private JLabel lblNhom;

    ConnectSQL cn = new ConnectSQL();
    public String gioden, tenban;
    public int maban;
    public ArrayList<ThucDon> arrdsmon;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");

    public static JpThucDon td;

    public void FillLoai() {
        ArrayList<Loai> arrLoai = cn.GetLoai();
        if (arrLoai != null) {
            JButton btn;
            jpLoai.setLayout(new BoxLayout(jpLoai, BoxLayout.PAGE_AXIS));
            jpLoai.removeAll();
            jpChonMon.setLayout(new FlowLayout(FlowLayout.CENTER));
            for (Loai l : arrLoai) {
                btn = new JButton(l.GetTenLoai());
                btn.setName(l.GetMaLoai());
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setMaximumSize(new Dimension(140, 40));
                btn.setForeground(Color.decode("#331a00"));
                btn.setBackground(Color.decode(l.GetMauSac()));
                btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        lblNhom.setText("    Nhóm " + l.GetTenLoai());
                        lblNhom.setBackground(Color.decode(l.GetMauSac()));
                        ArrayList<ThucDon> arrThucDon = cn.GetThucDon(l.GetMaLoai());
                        jpChonMon.removeAll();
                        jpChonMon.updateUI();
                        if (arrThucDon != null) {
                            JPanel[] pn = new JPanel[arrThucDon.size()];
                            //jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.PAGE_AXIS));
                            for (int i = 0; i < arrThucDon.size(); i++) {
                                pn[i] = new JPanel();
                                pn[i].setName(arrThucDon.get(i).GetMaMon());
                                pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                                pn[i].setBackground(Color.decode("#dfff80"));
                                pn[i].setBorder(BorderFactory.createLineBorder(Color.decode("#a3a375"), 2));
                                pn[i].setPreferredSize(new Dimension(128, 60));
                                pn[i].add(new JLabel(arrThucDon.get(i).GetTenMon())).setFont(new Font("Tahoma", 1, 12));
                                pn[i].add(new JLabel(String.valueOf(chuyentien.format(arrThucDon.get(i).GetDonGia())) + " VNĐ/ " + arrThucDon.get(i).GetDVT())).setForeground(Color.decode("#ff0000"));
                                pn[i].addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {

                                        DLSoLuong sl = new DLSoLuong(Run.QlCafe, true, e.getComponent().getName(), tenban, maban);
                                        sl.gioden = gioden;
                                        sl.setVisible(true);
                                    }
                                });
                                jpChonMon.add(pn[i]);
                                jpChonMon.updateUI();
                            }
                        }

                    }
                });
                jpLoai.add(btn);
                jpLoai.updateUI();
            }

        }

    }

    public JpThucDon() {
        initComponents();
        td = this;
        FillLoai();

    }

    private void initComponents() {

        jPanel1 = new JPanel();
        lblNhom = new JLabel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jpChonMon = new JPanel();
        jpLoai = new JPanel();

        setBackground(Color.decode("#e6e6e6"));

        jPanel1.setBackground(Color.decode("#e6e6e6"));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanel1.setAlignmentX(0.0F);

        lblNhom.setBackground(new Color(11, 112, 14));
        lblNhom.setFont(new Font("Tahoma", 1, 14));
        lblNhom.setForeground(new Color(253, 253, 253));
        lblNhom.setHorizontalAlignment(SwingConstants.LEFT);
        lblNhom.setText("                          Chọn món");
        lblNhom.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        lblNhom.setHorizontalTextPosition(SwingConstants.LEADING);
        lblNhom.setIconTextGap(7);
        lblNhom.setOpaque(true);

        jPanel2.setBackground(Color.decode("#e6e6e6"));
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/yw_circle_food.png")));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jpChonMon.setBackground(Color.decode("#e6e6e6"));
        jpChonMon.setAutoscrolls(true);
        jpChonMon.setPreferredSize(new Dimension(289, 420));

        GroupLayout jpChonMonLayout = new GroupLayout(jpChonMon);
        jpChonMon.setLayout(jpChonMonLayout);
        jpChonMonLayout.setHorizontalGroup(
                jpChonMonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 289, Short.MAX_VALUE)
        );
        jpChonMonLayout.setVerticalGroup(
                jpChonMonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblNhom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jpChonMon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNhom, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpChonMon, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jpLoai.setBackground(Color.decode("#e6e6e6"));
        jpLoai.setLayout(null);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jpLoai, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jpLoai, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                .addGap(143, 143, 143))
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

}
