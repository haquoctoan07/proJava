package qlcafe.bkhn.dtvt.ui.setting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JpSetting extends JPanel {

    private JPanel JpPaneSetting;
    private JButton btnAmThanh;
    private JButton btnCapNhat;
    private JButton btnGiaoDien;
    private JButton btnGoCaiDat;
    private JButton btnKhoiPhuc;
    private JButton btnThongTin;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JpSetting() {
        initComponents();
        JpThongTin tt = new JpThongTin();
        JpPaneSetting.removeAll();
        JpPaneSetting.add(tt);
        JpPaneSetting.revalidate();

    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        btnGiaoDien = new JButton();
        btnAmThanh = new JButton();
        btnKhoiPhuc = new JButton();
        btnThongTin = new JButton();
        btnCapNhat = new JButton();
        btnGoCaiDat = new JButton();
        JpPaneSetting = new JPanel();

        setPreferredSize(new Dimension(1255, 500));

        jPanel1.setPreferredSize(new Dimension(1255, 500));

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        btnGiaoDien.setFont(new Font("Tahoma", 1, 10));
        btnGiaoDien.setForeground(new Color(51, 0, 51));
        btnGiaoDien.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/theme.png")));
        btnGiaoDien.setText("GIAO DIỆN");
        btnGiaoDien.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnGiaoDien.setHorizontalAlignment(SwingConstants.LEFT);
        btnGiaoDien.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnGiaoDien.setIconTextGap(7);
        btnGiaoDien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnGiaoDienActionPerformed(evt);
            }
        });

        btnAmThanh.setFont(new Font("Tahoma", 1, 10));
        btnAmThanh.setForeground(new Color(51, 0, 51));
        btnAmThanh.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/Sound.png")));
        btnAmThanh.setText("ÂM THANH");
        btnAmThanh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAmThanh.setHorizontalAlignment(SwingConstants.LEFT);
        btnAmThanh.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnAmThanh.setIconTextGap(7);

        btnKhoiPhuc.setFont(new Font("Tahoma", 1, 10));
        btnKhoiPhuc.setForeground(new Color(51, 0, 51));
        btnKhoiPhuc.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/icon-circle-tools-blue.png")));
        btnKhoiPhuc.setText("KHÔI PHỤC CÀI ĐẶT");
        btnKhoiPhuc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKhoiPhuc.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhoiPhuc.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnKhoiPhuc.setIconTextGap(7);

        btnThongTin.setFont(new Font("Tahoma", 1, 10));
        btnThongTin.setForeground(new Color(51, 0, 51));
        btnThongTin.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/info.png")));
        btnThongTin.setText("THÔNG TIN");
        btnThongTin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThongTin.setHorizontalAlignment(SwingConstants.LEFT);
        btnThongTin.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnThongTin.setIconTextGap(7);
        btnThongTin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnThongTinActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new Font("Tahoma", 1, 10));
        btnCapNhat.setForeground(new Color(51, 0, 51));
        btnCapNhat.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/update.png")));
        btnCapNhat.setText("ĐỔI MẬT KHẨU");
        btnCapNhat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCapNhat.setHorizontalAlignment(SwingConstants.LEFT);
        btnCapNhat.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnCapNhat.setIconTextGap(7);
        btnCapNhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnGoCaiDat.setFont(new Font("Tahoma", 1, 10));
        btnGoCaiDat.setForeground(new Color(51, 0, 51));
        btnGoCaiDat.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/unistall.png")));
        btnGoCaiDat.setText("HỖ TRỢ");
        btnGoCaiDat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnGoCaiDat.setHorizontalAlignment(SwingConstants.LEFT);
        btnGoCaiDat.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnGoCaiDat.setIconTextGap(7);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnCapNhat, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThongTin, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnKhoiPhuc, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(btnAmThanh, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGiaoDien, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGoCaiDat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnGiaoDien)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAmThanh)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKhoiPhuc)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCapNhat)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGoCaiDat)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThongTin)
                                .addContainerGap(271, Short.MAX_VALUE))
        );

        JpPaneSetting.setBorder(BorderFactory.createEtchedBorder());
        JpPaneSetting.setLayout(new BorderLayout());

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JpPaneSetting, GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JpPaneSetting, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38))
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

    private void btnGiaoDienActionPerformed(ActionEvent evt) {

        btnGiaoDien.setPressedIcon(new ImageIcon("down.png"));
        JpGiaoDien gd = new JpGiaoDien();
        JpPaneSetting.removeAll();
        JpPaneSetting.add(gd);
        JpPaneSetting.revalidate();
    }

    private void btnThongTinActionPerformed(ActionEvent evt) {
        JpThongTin tt = new JpThongTin();
        JpPaneSetting.removeAll();
        JpPaneSetting.add(tt);
        JpPaneSetting.revalidate();

    }

    private void btnCapNhatActionPerformed(ActionEvent evt) {
        JpDoiMk dmk = new JpDoiMk();
        JpPaneSetting.removeAll();
        JpPaneSetting.add(dmk);
        JpPaneSetting.updateUI();
    }
}
