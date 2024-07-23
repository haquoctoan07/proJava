package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.models.ThucDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.banhang.JpThucDon;

@SuppressWarnings("serial")
public class Dl_Them_ThucDon extends JDialog {
	private JComboBox<String> cbbNhomMon;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPanel jPanel1;
	private JTextField txtGia;
	private JTextField txtTenMon;
	private JTextField txtdvt;
	
	ConnectSQL cn = new ConnectSQL();
	public Dl_Them_ThucDon(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		Fillcbb();

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void Fillcbb() {
		Vector Vcbb = cn.GetNhomMon();

		if (Vcbb != null) {
			DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel(Vcbb);
			cbbNhomMon.setModel(cbbmodel);
			cbbNhomMon.removeItemAt(0);
		} else {
			JOptionPane.showMessageDialog(null, "Không có nhóm nào !");
		}
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel2 = new JLabel();
		jLabel5 = new JLabel();
		jButton1 = new JButton();
		jLabel4 = new JLabel();
		jLabel3 = new JLabel();
		jButton2 = new JButton();
		txtGia = new JTextField();
		jLabel1 = new JLabel();
		cbbNhomMon = new JComboBox<>();
		txtdvt = new JTextField();
		txtTenMon = new JTextField();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);

		jPanel1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));

		jLabel2.setFont(new Font("Tahoma", 1, 11)); 
		jLabel2.setForeground(new Color(0, 51, 0));
		jLabel2.setText("Tên món:");

		jLabel5.setFont(new Font("Tahoma", 1, 11)); 
		jLabel5.setForeground(new Color(0, 51, 0));
		jLabel5.setText("Nhóm món:");

		jButton1.setFont(new Font("Tahoma", 1, 11)); 
		jButton1.setForeground(new Color(153, 51, 0));
		jButton1.setText("Xác nhận");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel4.setFont(new Font("Tahoma", 1, 11)); 
		jLabel4.setForeground(new Color(0, 51, 0));
		jLabel4.setText("ĐVT:");

		jLabel3.setFont(new Font("Tahoma", 1, 11)); 
		jLabel3.setForeground(new Color(0, 51, 0));
		jLabel3.setText("Đơn giá:");

		jButton2.setFont(new Font("Tahoma", 1, 11)); 
		jButton2.setForeground(new Color(153, 51, 0));
		jButton2.setText("Hủy");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		txtGia.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				txtGiaKeyReleased(evt);
			}
		});

		jLabel1.setFont(new Font("Tahoma", 1, 18)); 
		jLabel1.setForeground(new Color(51, 51, 0));
		jLabel1.setText("Thêm món mới");

		cbbNhomMon.setForeground(new Color(51, 0, 51));
		cbbNhomMon.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cbbNhomMon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				cbbNhomMonItemStateChanged(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(31, 31, 31)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel5, GroupLayout.Alignment.TRAILING))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(txtGia, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtdvt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbNhomMon, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenMon, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 23, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(71, 71, 71)
						.addComponent(jLabel1)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(jButton1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton2)
						.addGap(11, 11, 11))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(19, 19, 19)
						.addComponent(jLabel1)
						.addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(txtTenMon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(cbbNhomMon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(15, 15, 15)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(txtGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(txtdvt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1)
								.addComponent(jButton2))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

	private void cbbNhomMonItemStateChanged(ItemEvent evt) {
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		this.dispose();    
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		if(!validate(txtTenMon,txtTenMon.getText(),"Tên món")){
			return;
		}
		if(!validate(txtGia,txtGia.getText(),"Giá món")){
			return;
		}

		if(!validate(txtdvt,txtdvt.getText(),"Đơn vị tính")){
			return;
		}

		ThucDon td = new ThucDon();
		td.SetTenMon(txtTenMon.getText());
		td.SetDonGia(Integer.parseInt(txtGia.getText()));
		td.SetDVT(txtdvt.getText());
		String MaNhom = ((Loai)cbbNhomMon.getSelectedItem()).GetMaLoai();
		td.SetMaLoai(MaNhom);

		int Insert = cn.InsertThucDon(td);
		if(Insert == 0){
			JOptionPane.showMessageDialog(null, "Thêm mới không thành công!");
			return;
		}
		Jp_QLThucDon.td.FillTable(MaNhom);
		Jp_QLThucDon.td.updateUI();
		try{
			JpThucDon.td.FillLoai();
			JpThucDon.td.updateUI();
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Lỗi thucdon");
		}
		this.dispose(); 
	}

	private void txtGiaKeyReleased(KeyEvent evt) {
		try{
			Integer.parseInt(txtGia.getText());
		}catch(Exception ex){
			txtGia.setText("");
		}
	}
	private boolean validate(JTextField tf, String value, String title){
		if(value.isEmpty()){
			JOptionPane.showMessageDialog(null, title+" không được để trống !");
			tf.requestFocus();
			return false;
		}
		return true;
	}
}
