package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Font;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.banhang.JpThucDon;

@SuppressWarnings("serial")
public class DLQl_Sua_Nhom extends JDialog {
	private JColorChooser chonmau;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPanel jPanel1;
	private JPanel jpmau;
	private JLabel lblten;
	private JTextField txtten;
	ConnectSQL cn = new ConnectSQL();
	
	String mausac, MaNhom;
	public DLQl_Sua_Nhom(Frame parent, boolean modal, String manhom) {
		super(parent, modal);
		initComponents();
		MaNhom = manhom;
		Loai l = cn.GetLoaiByMa(manhom);
		mausac = l.GetMauSac();
		txtten.setText(l.GetTenLoai());
		jpmau.setBackground(Color.decode(mausac));
		lblten.setText("Sửa nhóm - "+l.GetTenLoai());  

		ColorSelectionModel model = chonmau.getSelectionModel();
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				Color cl = chonmau.getColor();
				String hex = String.format("#%06x", cl.getRGB() & 0x00FFFFFF);
				jpmau.setBackground(Color.decode(hex));                
			}
		};
		model.addChangeListener(changeListener);        
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		lblten = new JLabel();
		jButton1 = new JButton();
		txtten = new JTextField();
		jButton2 = new JButton();
		chonmau = new JColorChooser();
		jLabel3 = new JLabel();
		jpmau = new JPanel();
		jLabel2 = new JLabel();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);

		jPanel1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 0), 2));

		jLabel1.setFont(new Font("Tahoma", 1, 11)); 
		jLabel1.setText("Tên loại:");

		lblten.setFont(new Font("Tahoma", 1, 14)); 
		lblten.setForeground(new Color(51, 0, 51));
		lblten.setText("Sửa nhóm");

		jButton1.setFont(new Font("Tahoma", 1, 11)); 
		jButton1.setForeground(new Color(51, 0, 51));
		jButton1.setText("Hủy bỏ");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
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

		chonmau.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				chonmauMousePressed(evt);
			}
		});
		chonmau.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				chonmauPropertyChange(evt);
			}
		});

		jLabel3.setFont(new Font("Tahoma", 1, 11)); 
		jLabel3.setText("Màu sắc:");

		jLabel2.setFont(new Font("Tahoma", 1, 12)); 
		jLabel2.setForeground(new Color(255, 255, 255));
		jLabel2.setText("Màu sắc hiển thị");

		GroupLayout jpmauLayout = new GroupLayout(jpmau);
		jpmau.setLayout(jpmauLayout);
		jpmauLayout.setHorizontalGroup(
				jpmauLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jpmauLayout.createSequentialGroup()
						.addGap(114, 114, 114)
						.addComponent(jLabel2)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jpmauLayout.setVerticalGroup(
				jpmauLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jpmauLayout.createSequentialGroup()
						.addGap(24, 24, 24)
						.addComponent(jLabel2)
						.addContainerGap(27, Short.MAX_VALUE))
				);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(32, 32, 32)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel1, GroupLayout.Alignment.TRAILING))
										.addGap(18, 18, 18)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(chonmau, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(txtten, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addGap(73, 73, 73)
																		.addComponent(lblten)))
														.addGap(57, 57, 57)
														.addComponent(jpmau, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(176, 176, 176)
										.addComponent(jButton2)
										.addGap(44, 44, 44)
										.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
						.addGap(22, 22, 22))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(lblten)
										.addGap(28, 28, 28)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(txtten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1)))
								.addComponent(jpmau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(chonmau, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		setLocationRelativeTo(null);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		this.dispose();        
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		if(txtten.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Tên loại không được để trống !");
			txtten.requestFocus();
			return;
		}
		Color cl = chonmau.getColor();
		String hex = String.format("#%06x", cl.getRGB() & 0x00FFFFFF);
		if("#ffffff".equals(hex)){
			hex = mausac;
		} 

		Loai loai = new Loai();
		loai.SetTenLoai(txtten.getText());
		loai.SetMauSac(hex);
		loai.SetMaLoai(MaNhom);
		int update = cn.UpdateLoai(loai);
		if(update > 0){
			Jp_QLNhomMon.nhom.FillTable();
			Jp_QLNhomMon.nhom.updateUI();
			try{
				Jp_QLThucDon.td.Fillcbb();
				Jp_QLThucDon.td.FillTable(null);
				Jp_QLThucDon.td.updateUI();
				JpThucDon.td.FillLoai();
				JpThucDon.td.updateUI();
			}catch(Exception e){

			}
			this.dispose();
		}
	}

	private void chonmauMousePressed(MouseEvent evt) {
	}

	private void chonmauPropertyChange(PropertyChangeEvent evt) {
	}
}

