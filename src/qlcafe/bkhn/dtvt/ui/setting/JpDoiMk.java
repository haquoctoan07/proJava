package qlcafe.bkhn.dtvt.ui.setting;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import qlcafe.bkhn.dtvt.models.TaiKhoan;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.Run;

@SuppressWarnings("serial")
public class JpDoiMk extends JPanel {

    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JLabel lblten;
    private JPasswordField txtpassnew;
    private JPasswordField txtpassold;
    private JPasswordField txtrepass;
    ConnectSQL cn = new ConnectSQL();

    public JpDoiMk() {
        initComponents();
        lblten.setText(Run.tk.GetUsername());

    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        lblten = new JLabel();
        txtrepass = new JPasswordField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtpassold = new JPasswordField();
        txtpassnew = new JPasswordField();
        jLabel3 = new JLabel();

        setForeground(new Color(156, 14, 160));

        jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(null, "Đổi mật khẩu", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 13), new Color(11, 93, 153))))));

        jButton1.setText("Xác nhận");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new Font("Tahoma", 1, 12));
        jLabel4.setForeground(new Color(156, 14, 160));
        jLabel4.setText("Nhập lại mật khẩu mới");

        lblten.setFont(new Font("Tahoma", 1, 12));
        lblten.setText("......");

        jLabel1.setFont(new Font("Tahoma", 1, 12));
        jLabel1.setForeground(new Color(156, 14, 160));
        jLabel1.setText("Tên tài khoản:");

        jLabel2.setFont(new Font("Tahoma", 1, 12));
        jLabel2.setForeground(new Color(156, 14, 160));
        jLabel2.setText("Mật khẩu cũ:");

        jLabel3.setFont(new Font("Tahoma", 1, 12));
        jLabel3.setForeground(new Color(156, 14, 160));
        jLabel3.setText("Mật khẩu mới:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblten, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtpassold, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtpassnew, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtrepass, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(124, 124, 124)
                                                .addComponent(jButton1)
                                                .addGap(118, 118, 118)))
                                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(lblten))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtpassold, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtpassnew, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtrepass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE))
        );
    }

    @SuppressWarnings("deprecation")
    private void jButton1ActionPerformed(ActionEvent evt) {
        if (!validate(txtpassold, txtpassold.getText(), "Mật khẩu cũ")) {
            return;
        }
        if (!txtpassold.getText().equals(Run.tk.GetPassword())) {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng !");
            return;
        }

        if (!validate(txtpassnew, txtpassnew.getText(), "Mật khẩu mới")) {
            return;
        }

        if (!validate(txtrepass, txtrepass.getText(), "Nhập lại mật khẩu")) {
            return;
        }
        if (!txtrepass.getText().equals(txtpassnew.getText())) {
            JOptionPane.showMessageDialog(null, "Nhập lại không khớp !");
            return;
        }
        TaiKhoan tk = new TaiKhoan();
        tk.SetID(Run.tk.GetID());
        tk.SetPassword(txtrepass.getText());
        tk.SetUsername(lblten.getText());
        tk.SetLv(Run.tk.GetLv());
        @SuppressWarnings("unused")
        int update = cn.UpdateTK(tk);
        JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
        Run.QlCafe.reloadPanel(2);
    }

    private boolean validate(JTextField tf, String value, String title) {
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(null, title + " không được để trống !");
            tf.requestFocus();
            return false;
        }
        return true;
    }
}
