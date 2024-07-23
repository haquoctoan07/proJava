package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
public class DLQl_Sua_Ban extends JDialog {
	private JButton btnhuy;
	@SuppressWarnings("unused")
	private ButtonGroup buttonGroup1;
	private JButton jButton1;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JLabel lblten;
	private JTextField txttenban;
	ConnectSQL cn = new ConnectSQL();
	int maban;
	String trangthai, tenban;
	public DLQl_Sua_Ban(Frame parent, boolean modal, int ma) {
		super(parent, modal);
		initComponents();
		ArrayList<Ban> b = cn.GetBan(ma);
		maban = b.get(0).GetMaBan();
		trangthai = b.get(0).GetTrangThai();
		String[] mb = b.get(0).GetTenBan().split(" ");
		tenban = mb[1];
		txttenban.setText(mb[1]);
		lblten.setText("Sửa bàn - "+b.get(0).GetTenBan());
	}
	private void initComponents() {

		buttonGroup1 = new ButtonGroup();
		jPanel1 = new JPanel();
		jLabel2 = new JLabel();
		txttenban = new JTextField();
		lblten = new JLabel();
		jButton1 = new JButton();
		btnhuy = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);

		jPanel1.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 102)));

		jLabel2.setFont(new Font("Tahoma", 1, 11));
		jLabel2.setText("Tên bàn: ");

		txttenban.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				txttenbanKeyReleased(evt);
			}
		});

		lblten.setFont(new Font("Tahoma", 1, 14));
		lblten.setForeground(new Color(51, 0, 51));
		lblten.setText("Sửa bàn 19");

		jButton1.setFont(new Font("Tahoma", 1, 11));
		jButton1.setForeground(new Color(102, 51, 0));
		jButton1.setText("Xác nhận");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		btnhuy.setFont(new Font("Tahoma", 1, 11));
		btnhuy.setForeground(new Color(102, 51, 0));
		btnhuy.setText("Hủy bỏ");
		btnhuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnhuyActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(lblten)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addGap(0, 27, Short.MAX_VALUE)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel2)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txttenban, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jButton1)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnhuy)))))
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblten)
						.addGap(33, 33, 33)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txttenban, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addGap(21, 87, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnhuy)
								.addComponent(jButton1))
						.addContainerGap())
				);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				);

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		if(txttenban.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Tên bàn không được để trống !");
			return;
		}        
		Ban b = new Ban();
		b.SetTenBan("Bàn " +txttenban.getText());
		b.SetMaBan(maban);
		b.SetTrangThai(trangthai);
		cn.UpdateBan(b);

		Jp_QLBan.B.FillTable();
		Jp_QLBan.B.updateUI();
		try{
			JpBanHang.bh.FillBan();
			JpBanHang.bh.updateUI();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error !");
		}
		this.dispose();        
	}

	private void btnhuyActionPerformed(ActionEvent evt) {
		this.dispose();      
	}

	private void txttenbanKeyReleased(KeyEvent evt) {
		try{
			Integer.parseInt(txttenban.getText());
		}catch(Exception e){
			txttenban.setText(tenban);
		}        
	}
}
