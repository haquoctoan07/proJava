package qlcafe.bkhn.dtvt.ui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import qlcafe.bkhn.dtvt.models.TaiKhoan;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;


public class frmLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnExit;
	private JButton btnLogIn;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPanel jPanel1;
	private JPasswordField txtPassWord;
	private JTextField txtUserName;
	ConnectSQL cn = new ConnectSQL();
	public frmLogin() {
		initComponents();
		JRootPane rp = this.getRootPane();
		rp.setDefaultButton(btnLogIn);
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();

		btnLogIn = new JButton();
		btnExit = new JButton();
		txtUserName = new JTextField();
		txtPassWord = new JPasswordField();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Đóng toàn bộ các cửa sổ liên quan đến nó
		setUndecorated(true);// Không hiển thị các thành phần điều khiển viền ngoài của cửa sổ

		jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0))); // set viền sửa sổ
                
		jLabel1.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cooltext171088793851573.png")));
		
		jLabel2.setFont(new Font("Tahoma", 1, 11));// Định dạng phông chữ
		jLabel2.setForeground(new Color(51, 51, 0));// Màu chữ
		jLabel2.setText("Username");

		jLabel3.setFont(new Font("Tahoma", 1, 11));// Định dạng phông chữ
		jLabel3.setForeground(new Color(51, 51, 0));// Màu chữ
		jLabel3.setText("Password");
		
		jLabel4.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/logginlogo.png")));
		
		jLabel5.setFont(new Font("Tahoma", 1, 15));// Định dạng phông chữ
		jLabel5.setForeground(new Color(102, 0, 0));// Màu chữ
		jLabel5.setText("Đăng nhập-Giao ca");

		btnLogIn.setFont(new Font("Tahoma", 1, 11));// Định dạng phông chữ
		btnLogIn.setForeground(new Color(102, 51, 0));// Màu chữ
		btnLogIn.setText("Đăng nhập");
		btnLogIn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent evt) {
				btnLogInActionPerformed(evt);
			}
		});
		
		btnExit.setFont(new Font("Tahoma", 1, 11));
		btnExit.setForeground(new Color(102, 51, 0));
		btnExit.setText("Thoát");
		btnExit.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addGap(125, 125, 125)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(11, 11, 11))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(7, 7, 7)))
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGap(19, 19, 19)
														.addComponent(btnLogIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addComponent(txtPassWord)
												.addComponent(txtUserName, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(18, 18, 18))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(110, 110, 110))))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel1)
								.addComponent(jLabel5))
						.addGap(25, 25, 25)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel2)
														.addGap(23, 23, 23))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)))
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(txtPassWord, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnExit)
								.addComponent(btnLogIn))
						.addContainerGap(13, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack(); //giúp cửa sổ có kích thước vừa đủ với nội dung của nó
		setLocationRelativeTo(null);// cửa sổ xuất hiện chính giữa
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	public void thoat(){
		txtPassWord.setText("");
		txtPassWord.requestFocus();//con trỏ ở vị trí nhập password
	}
	@SuppressWarnings("deprecation")
	private void btnLogInActionPerformed(ActionEvent evt) {
		String user, pass;
		user = txtUserName.getText();
		pass = txtPassWord.getText();

		TaiKhoan tk = new TaiKhoan();

		tk.SetUsername(user);
		tk.SetPassword(pass);
		boolean check = cn.CheckLogin(tk);//kiểm tra xem có tài khoản người dùng nhập không
		cn.LVTK(tk); // lấy quyền đăng nhập

		if(check == true){
			Run.tk = cn.GetTaiKhoan(user, pass);
			this.setVisible(false);
			Run.QLCF();
		}else{
			JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
