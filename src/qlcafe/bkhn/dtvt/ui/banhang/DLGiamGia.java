package qlcafe.bkhn.dtvt.ui.banhang;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import qlcafe.bkhn.dtvt.models.HoaDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;

@SuppressWarnings("serial")
public class DLGiamGia extends JDialog {

    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;

    private JPanel jPanel1;

    ConnectSQL cn = new ConnectSQL();
    private final int mahd;
    int TienMon;

    public DLGiamGia(Frame parent, boolean modal, int mahd, String tenban, int tienmon) {
        super(parent, modal);
        initComponents();
        TienMon = tienmon;
        this.mahd = mahd;

        jLabel1.setText(tenban + " - Giảm giá");
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//dialog vẫn chạy ngầm khi tắt, chỉ ẩn cửa số dialog đi.
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new Color(95, 164, 154));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 0)));

        jLabel3.setText("%");

        jLabel1.setFont(new Font("Tahoma", 1, 18));
        jLabel1.setForeground(new Color(126, 27, 63));
        jLabel1.setText("Bàn 3 - Giảm giá");

        jLabel2.setFont(new Font("Tahoma", 1, 12));
        jLabel2.setText("Giảm giá:");

        jButton2.setBackground(new Color(52, 235, 67));
        jButton2.setForeground(new Color(249, 245, 245));
        jButton2.setText("Xác nhận");
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));//đổi hình con trot chuột thành hình bàn tay trỏ khi để vào
        //jButton2.setBackground(Color.decode("#e6e6e6"));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"5", "10", "15", "20", "25", "30", "35", "40", "45", "50"}));
        jComboBox1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });

        jButton1.setBackground(new Color(176, 61, 50));
        jButton1.setForeground(new Color(249, 245, 245));
        jButton1.setText("Hủy bỏ");
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/discount.png")));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(2, 2, 2)
                                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton1))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(104, 104, 104)
                                                .addComponent(jLabel1)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);// dialog xuất hiện chính giữa
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();//hủy dialog và giải phóng bộ nhớ        
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        try {
            int gia = Integer.parseInt(jComboBox1.getSelectedItem().toString());

            //Nếu nhập tiền giảm giá > tiền phải trả thì gán tieeenf giảm gí = tiền phải trả
            if (gia > TienMon) {
                gia = TienMon;
            }

            // Khởi tạo và cập nhật lại hóa đơn sau khi chọn giảm giá
            HoaDon hd = new HoaDon();
            hd.SetMaHD(mahd);// set mã hóa đơn giảm giá
            hd.SetGiamGia(gia);
            cn.UpdateHD(hd);
            this.dispose();

            // Cập nhật lại giao diện gọi món khi chọn xong giảm giá
            JpGoiMon.gm.fillThongTin();
            JpGoiMon.gm.updateUI();
        } catch (Exception e) {
            jComboBox1.setSelectedIndex(0);
        }
    }

    private void jComboBox1KeyReleased(KeyEvent evt) {

    }
}
