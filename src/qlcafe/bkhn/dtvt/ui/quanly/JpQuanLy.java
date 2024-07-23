package qlcafe.bkhn.dtvt.ui.quanly;

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
public class JpQuanLy extends JPanel {
	private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jpql;

    public JpQuanLy() {
        initComponents();
        LoadPanel(2);
    }
    Jp_QLBan ban;
    Jp_QLThucDon td;
    Jp_QLNhomMon nm;
    Jp_QLTaiKhoan nv;
    public void LoadPanel(int i){
        jpql.removeAll();
        switch (i){ 
            case 1:
                if(ban == null){
                    ban = new Jp_QLBan();
                }
                jpql.add(ban);
                break;  
            case 2:
                if(td == null){
                    td = new Jp_QLThucDon();
                }
                jpql.add(td);                
                break;
            case 3:
                if(nm == null){
                    nm = new Jp_QLNhomMon();
                }
                jpql.add(nm);                
                break; 
            case 4:
                if(nv == null){
                    nv = new Jp_QLTaiKhoan();
                }
                jpql.add(nv);                
                break;                
            default:
                break;
                
        }
        jpql.updateUI();
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel3 = new JPanel();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jpql = new JPanel();

        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new Dimension(1051, 486));

        jPanel3.setBorder(BorderFactory.createEtchedBorder());

        jButton5.setFont(new Font("Tahoma", 1, 10)); 
        jButton5.setForeground(new Color(51, 51, 0));
        jButton5.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/kiemke.png")));
        jButton5.setText("QUẢN LÝ NHÓM MÓN");
        jButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton5.setHorizontalAlignment(SwingConstants.LEADING);
        jButton5.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton5.setIconTextGap(10);
        jButton5.setPreferredSize(new Dimension(0, 35));
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new Font("Tahoma", 1, 10)); 
        jButton6.setForeground(new Color(51, 51, 0));
        jButton6.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/mailinglist.jpg")));
        jButton6.setText("QUẢN LÝ THỰC ĐƠN");
        jButton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton6.setHorizontalAlignment(SwingConstants.LEADING);
        jButton6.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton6.setIconTextGap(10);
        jButton6.setPreferredSize(new Dimension(0, 35));
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new Font("Tahoma", 1, 10)); 
        jButton7.setForeground(new Color(51, 51, 0));
        jButton7.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/thucdon1.png")));
        jButton7.setText("QUẢN LÝ BÀN");
        jButton7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton7.setHorizontalAlignment(SwingConstants.LEADING);
        jButton7.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton7.setIconTextGap(10);
        jButton7.setPreferredSize(new Dimension(0, 35));
        jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new Font("Tahoma", 1, 10)); 
        jButton8.setForeground(new Color(51, 51, 0));
        jButton8.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/qluser.png")));
        jButton8.setText("QUẢN LÝ TÀI KHOẢN");
        jButton8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton8.setHorizontalAlignment(SwingConstants.LEADING);
        jButton8.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton8.setIconTextGap(10);
        jButton8.setPreferredSize(new Dimension(0, 35));
        jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jButton7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jpql.setLayout(new BorderLayout());

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpql, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jpql, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
            .addComponent(jPanel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        LoadPanel(2);
    }

    private void jButton7ActionPerformed(ActionEvent evt) {
    	LoadPanel(1);
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        LoadPanel(3);
    }

    private void jButton8ActionPerformed(ActionEvent evt) {
        LoadPanel(4);  
    }
}
