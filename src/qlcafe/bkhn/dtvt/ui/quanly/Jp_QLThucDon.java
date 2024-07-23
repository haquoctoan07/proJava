package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.models.ThucDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.Run;
import qlcafe.bkhn.dtvt.ui.banhang.JpThucDon;

@SuppressWarnings("serial")
public class Jp_QLThucDon extends JPanel {
	private JButton bntSuaMon;
	private JButton bntThem;
	private JButton bntXoa;
	private JComboBox<String> cbbNhomMon;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JLabel lblthongtin;
	private JTable tbBan;
	private JTextField txttim;
	ConnectSQL cn = new ConnectSQL();
	public static Jp_QLThucDon td;
	public Jp_QLThucDon() {
		td = this;
		initComponents();
		Fillcbb();
		FillTable(null);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void Fillcbb() {
		Vector<Loai> Vcbb = cn.GetNhomMon();

		if (Vcbb != null) {
			DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel(Vcbb);
			cbbNhomMon.setModel(cbbmodel);
		} else {
			JOptionPane.showMessageDialog(null, "Không có nhóm nào !");
		}

	}    
	public void FillTable(String nhom) {
		ArrayList<ThucDon> arrTable = cn.GetThucDon(nhom);
		DefaultTableModel tbmodel = new DefaultTableModel();

		tbmodel.addColumn("Mã món");
		tbmodel.addColumn("Tên món");
		tbmodel.addColumn("Mã loại");
		tbmodel.addColumn("Đơn giá");
		tbmodel.addColumn("ĐVT");

		if (arrTable != null) {
			int somon = 0;
			for (ThucDon td : arrTable) {
				somon++;
				tbmodel.addRow(new Object[]{td.GetMaMon(), td.GetTenMon(), td.GetMaLoai(), td.GetDonGia(), td.GetDVT()});
			}
			lblthongtin.setText(String.valueOf(somon)+" món");

		} else {
			JOptionPane.showMessageDialog(null, "Không có thực đơn !");
		}
		tbBan.setModel(tbmodel);
		for(int i = 0; i < tbBan.getColumnCount();i++){
			Class<?> col = tbBan.getColumnClass(i);
			tbBan.setDefaultEditor(col, null);
		}        
	}    
	private void initComponents() {

		jPanel1 = new JPanel();
		bntXoa = new JButton();
		jScrollPane1 = new JScrollPane();
		tbBan = new JTable();
		jLabel1 = new JLabel();
		bntThem = new JButton();
		cbbNhomMon = new JComboBox<>();
		lblthongtin = new JLabel();
		jLabel2 = new JLabel();
		bntSuaMon = new JButton();
		jLabel10 = new JLabel();
		jLabel3 = new JLabel();
		txttim = new JTextField();
		jLabel4 = new JLabel();

		bntXoa.setFont(new Font("Tahoma", 1, 11)); 
		bntXoa.setForeground(new Color(51, 0, 51));
		bntXoa.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/file_delete.png")));
		bntXoa.setText("Xóa");
		bntXoa.setHorizontalAlignment(SwingConstants.LEADING);
		bntXoa.setHorizontalTextPosition(SwingConstants.RIGHT);
		bntXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bntXoaActionPerformed(evt);
			}
		});

		tbBan.setForeground(new Color(51, 0, 51));
		tbBan.setModel(new DefaultTableModel(
				new Object [][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null}
				},
				new String [] {
						"Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false, false, false, true
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		tbBan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tbBanMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbBan);

		jLabel1.setFont(new Font("Tahoma", 1, 12)); 
		jLabel1.setForeground(new Color(51, 51, 0));
		jLabel1.setText("Nhóm món :");

		bntThem.setFont(new Font("Tahoma", 1, 11)); 
		bntThem.setForeground(new Color(51, 0, 51));
		bntThem.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/file_add.png")));
		bntThem.setText("Thêm");
		bntThem.setHorizontalAlignment(SwingConstants.LEADING);
		bntThem.setHorizontalTextPosition(SwingConstants.RIGHT);
		bntThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bntThemActionPerformed(evt);
			}
		});

		cbbNhomMon.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cbbNhomMon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				cbbNhomMonItemStateChanged(evt);
			}
		});

		lblthongtin.setFont(new Font("Tahoma", 1, 11)); 
		lblthongtin.setForeground(new Color(153, 0, 0));
		lblthongtin.setText("Total");

		jLabel2.setFont(new Font("Tahoma", 1, 11)); 
		jLabel2.setForeground(new Color(51, 0, 51));
		jLabel2.setText("Tổng số món:");

		bntSuaMon.setFont(new Font("Tahoma", 1, 11)); 
		bntSuaMon.setForeground(new Color(51, 0, 51));
		bntSuaMon.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/document_edit.png")));
		bntSuaMon.setText("Sửa");
		bntSuaMon.setHorizontalAlignment(SwingConstants.LEADING);
		bntSuaMon.setHorizontalTextPosition(SwingConstants.RIGHT);
		bntSuaMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bntSuaMonActionPerformed(evt);
			}
		});

		jLabel10.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cooltext171088793851573.png")));

		jLabel3.setFont(new Font("Tahoma", 1, 11)); 
		jLabel3.setForeground(new Color(102, 0, 0));
		jLabel3.setText("Quản lý thực đơn");

		txttim.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				txttimKeyReleased(evt);
			}
		});

		jLabel4.setFont(new Font("Tahoma", 1, 12)); 
		jLabel4.setText("Tìm món:");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(27, 27, 27)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel1)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(cbbNhomMon, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
														.addGap(199, 199, 199)
														.addComponent(jLabel4)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(txttim, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 795, GroupLayout.PREFERRED_SIZE)
														.addGap(31, 31, 31)
														.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																.addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
																.addComponent(bntSuaMon, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
																.addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(38, Short.MAX_VALUE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jLabel3)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblthongtin, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
										.addGap(283, 283, 283))))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(cbbNhomMon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txttim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(bntSuaMon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(lblthongtin)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGap(19, 19, 19))
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
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
	}

	private void tbBanMouseClicked(MouseEvent evt) {
	}

	private void bntThemActionPerformed(ActionEvent evt) {
		Dl_Them_ThucDon td = new Dl_Them_ThucDon(Run.QlCafe, true);
		td.setVisible(true);
	}

	private void bntSuaMonActionPerformed(ActionEvent evt) {
		int select=tbBan.getSelectedRow();
		if(select<0){
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn món nào !");
		}else{
			String mamon = (String) tbBan.getValueAt(select, 0);
			Dl_Sua_ThucDon sua = new Dl_Sua_ThucDon(Run.QlCafe, true, mamon);
			sua.setVisible(true);
		}
	}

	private void bntXoaActionPerformed(ActionEvent evt) {
		int[] selectedRows = tbBan.getSelectedRows();

		if (selectedRows.length <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn món nào !");
		} else {
			ArrayList<String> ListMaBan = new ArrayList<String>();
			String sp = "";
			for (int i : selectedRows) {
				String ma = (String) tbBan.getValueAt(i, 0);
				ListMaBan.add(ma);
				String tenban = (String) tbBan.getValueAt(i, 1);

				sp += tenban + "\n";
			}
			int qs;
			qs = JOptionPane.showConfirmDialog(null, "Xóa món: \n " + sp, "Xóa món", JOptionPane.YES_NO_OPTION);
			if (qs == JOptionPane.YES_OPTION) {
				boolean xoa = cn.DeleteThucDon(ListMaBan);
				if (xoa == true) {
					FillTable(null);
					try{
						JpThucDon.td.FillLoai();
						JpThucDon.td.updateUI();
					}catch(Exception e){

					}
				}else
					JOptionPane.showMessageDialog(null, "Không xóa được món !");
			}
		}
	}

	private void cbbNhomMonItemStateChanged(ItemEvent evt) {
		Loai selected = (Loai) cbbNhomMon.getSelectedItem();
		FillTable(selected.GetMaLoai());
	}

	private void txttimKeyReleased(KeyEvent evt) {

		ArrayList<ThucDon> arrTable = cn.SearchMon(txttim.getText());
		if(arrTable != null){
			DefaultTableModel tbmodel = new DefaultTableModel();

			tbmodel.addColumn("Mã món");
			tbmodel.addColumn("Tên món");
			tbmodel.addColumn("Mã loại");
			tbmodel.addColumn("Đơn giá");
			tbmodel.addColumn("ĐVT");

			int somon = 0;
			for (ThucDon td : arrTable) {
				somon++;
				tbmodel.addRow(new Object[]{td.GetMaMon(), td.GetTenMon(), td.GetMaLoai(), td.GetDonGia(), td.GetDVT()});
				lblthongtin.setText(String.valueOf(somon)+" món");
			}
			tbBan.setModel(tbmodel);
			for(int i = 0; i < tbBan.getColumnCount();i++){
				Class<?> col = tbBan.getColumnClass(i);
				tbBan.setDefaultEditor(col, null);
			}
		}
	}
}
