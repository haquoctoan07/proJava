package qlcafe.bkhn.dtvt.ui.banhang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;

@SuppressWarnings("serial")
public final class JpBanHang extends JPanel {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jpBan;

    ConnectSQL cn = new ConnectSQL();//Kết nối cơ sở dữ liệu
    
    ArrayList<Ban> arrBan;
    int MaBan;

    public static JpBanHang bh;

    public JpBanHang() {
        initComponents();
        bh = this;
        FillBan();
        jButton1.setBackground(Color.decode("#66ff66"));
        jButton2.setBackground(Color.decode("#8080ff"));
        jButton3.setBackground(Color.decode("#ff6699"));

    }

    public void fillLb() {
        jPanel2.removeAll();
        jPanel2.add(jLabel1);
        jPanel2.updateUI();
    }

    public void FillBan() {

        arrBan = cn.GetBan(0);
        if (arrBan != null) {
            jpBan.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for (int i = 0; i < arrBan.size(); i++) {
                btn[i] = new JButton();
                btn[i].setName(String.valueOf(arrBan.get(i).GetMaBan()));
                String[] mb = arrBan.get(i).GetTenBan().split(" ");
                btn[i].setText(mb[1]);
                
                // set icon
                btn[i].setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/ico-Table.png")));
                
                //Đường viền quanh button bàn ăn
                Border thickBorder = new LineBorder(Color.WHITE, 8);
                btn[i].setBorder(thickBorder);
                
                //Màu trạng thái cho bàn ăn
                btn[i].setBackground(Color.decode("#8080ff"));
                btn[i].setFont(new Font("Tahoma", 1, 10));
                btn[i].setForeground(new Color(51, 51, 51));
                
                if (arrBan.get(i).GetTrangThai().equals("Đang phục vụ")) {
                    btn[i].setBackground(Color.decode("#66ff66"));
                }
                if (arrBan.get(i).GetTrangThai().equals("Đã đặt trước")) {
                    btn[i].setBackground(Color.decode("#ff6699"));
                }
                
                //Kích thước cho button bàn ăn
                btn[i].setPreferredSize(new Dimension(90, 70));

                //sự kiện click chuột vào bàn
                btn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        JpGoiMon goimon;
                        arrBan = cn.GetBan(Integer.parseInt(e.getComponent().getName()));
                        if (arrBan != null) {
                            goimon = new JpGoiMon(arrBan.get(0).GetTrangThai(), arrBan.get(0).GetTenBan(), arrBan.get(0).GetMaBan());
                            jPanel2.removeAll();
                            jPanel2.add(goimon);
                            jPanel2.updateUI();

                        }
                    }
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();
            }
        }

    }

    private void initComponents() {

        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jpBan = new JPanel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();

        setBackground(Color.decode("#e6e6e6"));
        setPreferredSize(new Dimension(1280, 519));

        jPanel2.setBackground(Color.decode("#e6e6e6"));
        jPanel2.setPreferredSize(new Dimension(580, 519));
        jPanel2.setLayout(new BorderLayout(200, 300));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cafe-menu-abstract-pattern-brown-colors-coffee-beans-background-32625326.jpg")));
        jLabel1.setMaximumSize(new Dimension(580, 519));
        jLabel1.setMinimumSize(new Dimension(580, 519));
        jLabel1.setPreferredSize(new Dimension(580, 519));
        jPanel2.add(jLabel1, BorderLayout.CENTER);

        jPanel1.setBackground(Color.decode("#e6e6e6"));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 102)));

        jpBan.setBackground(Color.decode("#e6e6e6"));

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cooltext171088793851573.png")));

        jLabel3.setFont(new Font("Tahoma", 1, 11));
        jLabel3.setText("Free");

        jLabel4.setFont(new Font("Tahoma", 1, 11));
        jLabel4.setText("Serving");

        jLabel5.setFont(new Font("Tahoma", 1, 11));
        jLabel5.setText("Reserved");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jpBan, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addGap(51, 51, 51)
                                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jpBan, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jButton3)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1)
                                                        .addComponent(jLabel4))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
