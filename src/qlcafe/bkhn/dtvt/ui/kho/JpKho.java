package qlcafe.bkhn.dtvt.ui.kho;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JpKho extends JPanel {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;

    public JpKho() {
        initComponents();

    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton1 = new JButton();
        jButton4 = new JButton();
        jPanel3 = new JPanel();

        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1051, 486));

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10));
        jButton2.setForeground(new java.awt.Color(51, 0, 51));
        jButton2.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/kiemke.png")));
        jButton2.setText("KIỂM KÊ");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalAlignment(SwingConstants.LEADING);
        jButton2.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton2.setIconTextGap(10);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 10));
        jButton3.setForeground(new java.awt.Color(51, 0, 51));
        jButton3.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/nhap.png")));
        jButton3.setText("NHẬP MUA");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalAlignment(SwingConstants.LEADING);
        jButton3.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton3.setIconTextGap(10);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10));
        jButton1.setForeground(new java.awt.Color(51, 0, 51));
        jButton1.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/mailinglist.jpg")));
        jButton1.setText("DANH MỤC NL");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalAlignment(SwingConstants.LEADING);
        jButton1.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton1.setIconTextGap(10);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 10));
        jButton4.setForeground(new java.awt.Color(51, 0, 51));
        jButton4.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/nguyenlieu.png")));
        jButton4.setText("NGUYÊN LIỆU");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalAlignment(SwingConstants.LEADING);
        jButton4.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton4.setIconTextGap(10);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addContainerGap(304, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.BorderLayout());

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

    }
}
