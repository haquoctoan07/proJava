package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.Run;
import qlcafe.bkhn.dtvt.ui.banhang.JpBanHang;

@SuppressWarnings("serial")
public class Jp_QLBan extends JPanel {
	private JButton bntSua;
	private JButton bntThem;
	private JButton bntXoa;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JLabel lblthongtin;
	private JTable tbBan;
	private JTextField txttim;
	ConnectSQL cn = new ConnectSQL();
	
	public static Jp_QLBan B;
	public Jp_QLBan() {
		B = this;
		initComponents();
		FillTable();
	}
	public void FillTable() {
		ArrayList<Ban> arrTable = cn.GetBan(0);
		DefaultTableModel tbmodel = new DefaultTableModel();

		tbmodel.addColumn("Mã Bàn");
		tbmodel.addColumn("Tên bàn");
		tbmodel.addColumn("Trạng thái");

		if (arrTable != null) {
			int soban = 0;
			for (Ban b : arrTable) {
				soban++;
				tbmodel.addRow(new Object[]{b.GetMaBan(), b.GetTenBan(), b.GetTrangThai()});
			}
			lblthongtin.setText(String.valueOf(soban)+" bàn");
		} else {
			JOptionPane.showMessageDialog(null, "Không có bàn nào");
		}
		tbBan.setModel(tbmodel);
		for(int i = 0; i < tbBan.getColumnCount();i++){
			Class<?> col = tbBan.getColumnClass(i);
			tbBan.setDefaultEditor(col, null);
		}        
	}
	private void initComponents() {

		jScrollPane1 = new JScrollPane();
		tbBan = new JTable();
		bntThem = new JButton();
		bntSua = new JButton();
		bntXoa = new JButton();
		jLabel10 = new JLabel();
		jLabel3 = new JLabel();
		lblthongtin = new JLabel();
		jLabel2 = new JLabel();
		jLabel1 = new JLabel();
		txttim = new JTextField();

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

		bntThem.setFont(new Font("Tahoma", 1, 11));
		bntThem.setForeground(new Color(51, 51, 0));
		bntThem.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/file_add.png")));
		bntThem.setText("Thêm");
		bntThem.setHorizontalAlignment(SwingConstants.LEADING);
		bntThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bntThemActionPerformed(evt);
			}
		});

		bntSua.setFont(new Font("Tahoma", 1, 11));
		bntSua.setForeground(new Color(51, 51, 0));
		bntSua.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/document_edit.png")));
		bntSua.setText("Sửa");
		bntSua.setHorizontalAlignment(SwingConstants.LEADING);
		bntSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bntSuaActionPerformed(evt);
			}
		});

		bntXoa.setFont(new Font("Tahoma", 1, 11));
		bntXoa.setForeground(new Color(51, 51, 0));
		bntXoa.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/file_delete.png")));
		bntXoa.setText("Xóa");
		bntXoa.setHorizontalAlignment(SwingConstants.LEADING);
		bntXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bntXoaActionPerformed(evt);
			}
		});

		jLabel10.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cooltext171088793851573.png")));

		jLabel3.setFont(new Font("Tahoma", 1, 11));
		jLabel3.setForeground(new Color(102, 0, 0));
		jLabel3.setText("Quản lý bàn");

		lblthongtin.setFont(new Font("Tahoma", 1, 11));
		lblthongtin.setForeground(new Color(153, 0, 0));
		lblthongtin.setText("Total");

		jLabel2.setFont(new Font("Tahoma", 1, 11));
		jLabel2.setForeground(new Color(51, 0, 51));
		jLabel2.setText("Tổng số bàn:");

		jLabel1.setFont(new Font("Tahoma", 1, 12));
		jLabel1.setText("Tìm bàn:");

		txttim.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				txttimKeyReleased(evt);
			}
		});

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(32, 32, 32)
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
																		.addGap(30, 30, 30)
																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
																				.addComponent(bntSua, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
																				.addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jLabel3)
																		.addGap(309, 309, 309)
																		.addComponent(jLabel2)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(lblthongtin))))
												.addGroup(layout.createSequentialGroup()
														.addGap(116, 116, 116)
														.addComponent(jLabel1)
														.addGap(18, 18, 18)
														.addComponent(txttim, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 66, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(txttim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(bntSua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(lblthongtin)))
						.addGap(23, 23, 23)
						.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(24, Short.MAX_VALUE))
				);
	}

	private void tbBanMouseClicked(MouseEvent evt) {
	}

	private void bntThemActionPerformed(ActionEvent evt) {
		DLQl_Them_Ban ban = new DLQl_Them_Ban(Run.QlCafe, true);
		ban.setVisible(true);
	}

	private void bntSuaActionPerformed(ActionEvent evt) {
		int select=tbBan.getSelectedRow();
		if(select<0){
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn bàn nào !");
		}else{
			int MaBan = (int) tbBan.getValueAt(select, 0);
			DLQl_Sua_Ban sua = new DLQl_Sua_Ban(Run.QlCafe, true, MaBan);
			sua.setVisible(true);
		}
	}

	private void bntXoaActionPerformed(ActionEvent evt) {
		int[] selectedRows = tbBan.getSelectedRows();

		if (selectedRows.length <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn bàn nào !");
		} else {
			ArrayList<Integer> ListMaBan = new ArrayList<Integer>();
			String sp = "";
			for (int i : selectedRows) {
				int ma = (int) tbBan.getValueAt(i, 0);
				ListMaBan.add(ma);
				String tenban = (String) tbBan.getValueAt(i, 1);

				sp += tenban + "\n";
			}
			int qs;
			qs = JOptionPane.showConfirmDialog(null, "Xóa bàn: \n " + sp, "Xóa bàn", JOptionPane.YES_NO_OPTION);
			if (qs == JOptionPane.YES_OPTION) {
				boolean xoa = cn.DeleteBan(ListMaBan);

				if (xoa == true) {
					Jp_QLBan.B.FillTable();
					Jp_QLBan.B.updateUI();
					try{
						JpBanHang.bh.FillBan();
						JpBanHang.bh.updateUI();
					}catch(Exception e){

					}
				}else
					JOptionPane.showMessageDialog(null, "Không xóa được bàn !");

			}
		}
	}

	private void txttimKeyReleased(KeyEvent evt) {
		ArrayList<Ban> arrTable = cn.SearchBan(txttim.getText());
		if(arrTable != null){
			DefaultTableModel tbmodel = new DefaultTableModel();

			tbmodel.addColumn("Mã Bàn");
			tbmodel.addColumn("Tên bàn");
			tbmodel.addColumn("Trạng thái");

			int soban = 0;
			for (Ban b : arrTable) {
				soban++;
				tbmodel.addRow(new Object[]{b.GetMaBan(), b.GetTenBan(), b.GetTrangThai()});
			}
			lblthongtin.setText(String.valueOf(soban)+" bàn");
			tbBan.setModel(tbmodel);
			for(int i = 0; i < tbBan.getColumnCount();i++){
				Class<?> col = tbBan.getColumnClass(i);
				tbBan.setDefaultEditor(col, null);
			}
		}
	}
}
