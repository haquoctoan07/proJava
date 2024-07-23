package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

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

import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.banhang.JpBanHang;

@SuppressWarnings("serial")
public class DLQl_Them_Ban extends JDialog {
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JTextField txtTenBan;
	ConnectSQL cn = new ConnectSQL();
	public DLQl_Them_Ban(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jButton1 = new JButton();
		txtTenBan = new JTextField();
		jButton2 = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);

		jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 204), 2));

		jLabel1.setFont(new Font("Tahoma", 1, 11)); 
		jLabel1.setText("Tên bàn: ");

		jLabel2.setFont(new Font("Tahoma", 1, 14)); 
		jLabel2.setForeground(new Color(51, 0, 51));
		jLabel2.setText("Thêm bàn mới");

		jButton1.setFont(new Font("Tahoma", 1, 11)); 
		jButton1.setForeground(new Color(51, 0, 51));
		jButton1.setText("Hủy bỏ");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		txtTenBan.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				txtTenBanKeyReleased(evt);
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

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addContainerGap(66, Short.MAX_VALUE)
										.addComponent(jButton2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton1))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(3, 3, 3)
										.addComponent(jLabel2)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(32, 32, 32)
										.addComponent(jLabel1)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtTenBan)))
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel2)
						.addGap(28, 28, 28)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtTenBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addGap(29, 66, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1)
								.addComponent(jButton2))
						.addContainerGap())
				);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				);

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		this.dispose();       
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		if(txtTenBan.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Tên bàn không được để trống !");
			return;
		}
		Ban b = new Ban();
		b.SetMaBan(Integer.parseInt(txtTenBan.getText()));
		b.SetTenBan("Bàn "+txtTenBan.getText());
		b.SetTrangThai("Trống");
		cn.InsertBan(b);

		Jp_QLBan.B.FillTable();
		Jp_QLBan.B.updateUI();
		JpBanHang.bh.FillBan();
		JpBanHang.bh.updateUI();

		this.dispose();
	}

	private void txtTenBanKeyReleased(KeyEvent evt) {
		try{
			Integer.parseInt(txtTenBan.getText());
		}catch(Exception e){
			txtTenBan.setText("");
		}
	}
}

