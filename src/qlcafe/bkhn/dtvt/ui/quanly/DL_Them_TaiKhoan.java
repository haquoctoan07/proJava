package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import qlcafe.bkhn.dtvt.models.TaiKhoan;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;

@SuppressWarnings("serial")
public class DL_Them_TaiKhoan extends JDialog {
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JPanel jPanel1;
	private JTextField txtlv;
	private JTextField txtpass;
	private JTextField txtten;
	ConnectSQL cn = new ConnectSQL();
	
	public DL_Them_TaiKhoan(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		txtlv = new JTextField();
		jButton2 = new JButton();
		txtpass = new JTextField();
		jLabel4 = new JLabel();
		txtten = new JTextField();
		jLabel3 = new JLabel();
		jButton1 = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);

		jPanel1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 0), 2));

		txtlv.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				txtlvKeyReleased(evt);
			}
		});

		jButton2.setFont(new Font("Tahoma", 1, 11)); 
		jButton2.setForeground(new Color(51, 0, 51));
		jButton2.setText("Xác nhận");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel4.setText("Level:");

		jLabel3.setText("Mật khẩu:");

		jButton1.setFont(new Font("Tahoma", 1, 11)); 
		jButton1.setForeground(new Color(51, 0, 51));
		jButton1.setText("Hủy bỏ");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new Font("Tahoma", 1, 12)); 
		jLabel1.setText("Thêm tài khoản");

		jLabel2.setText("Tên tài khoản:");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel2, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(txtten)
												.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtlv, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(61, 61, 61)
										.addComponent(jLabel1))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(21, 21, 21)
										.addComponent(jButton2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton1)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addGap(34, 34, 34)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(txtten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(32, 32, 32)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(24, 24, 24)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(txtlv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1)
								.addComponent(jButton2))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		if(txtten.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Tên tài khoản không được trống !");
			txtten.requestFocus();
			return;
		}
		if(txtpass.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Mật khẩu không được trống !");
			txtpass.requestFocus();
			return;
		}
		if(txtlv.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Nhâp Level !");
			txtlv.requestFocus();
			return;
		}        
		TaiKhoan tk = new TaiKhoan();
		tk.SetUsername(txtten.getText());
		tk.SetPassword(txtpass.getText());
		tk.SetLv(Integer.parseInt(txtlv.getText()));

		int in = cn.InserTK(tk);
		if(in > 0){
			Jp_QLTaiKhoan.tk.FillTable();
			Jp_QLTaiKhoan.tk.updateUI();

			this.dispose();            
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		this.dispose();      
	}

	private void txtlvKeyReleased(KeyEvent evt) {
		try{
			Integer.parseInt(txtlv.getText());
		}catch(Exception e){
			txtlv.setText("");
		}

	}
}

