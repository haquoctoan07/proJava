package qlcafe.bkhn.dtvt.ui.quanly;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import qlcafe.bkhn.dtvt.models.TaiKhoan;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.Run;

@SuppressWarnings("serial")
public class Jp_QLTaiKhoan extends JPanel {
	private JButton bntSua;
    private JButton bntThem;
    private JButton bntXoa;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JLabel lblthongtin;
    private JTable tbBan;
    ConnectSQL cn = new ConnectSQL();
    public static Jp_QLTaiKhoan tk;
    public Jp_QLTaiKhoan() {
        initComponents();
        tk = this;
        FillTable();
    }
    public void FillTable() {
        ArrayList<TaiKhoan> arrTable = cn.GetTaiKhoan();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("ID");
        tbmodel.addColumn("Tên tài khoản");
        tbmodel.addColumn("Mật khẩu");
        tbmodel.addColumn("Level");

        if (arrTable != null) {
            int soban = 0;
            for (TaiKhoan b : arrTable) {
                soban++;
                tbmodel.addRow(new Object[]{b.GetID(), b.GetUsername(), b.GetPassword(), b.GetLv()});
            }
            lblthongtin.setText(String.valueOf(soban)+" tài khoản");
        } else {
            JOptionPane.showMessageDialog(null, "Không có tài khoản !");
        }
        tbBan.setModel(tbmodel);
        for(int i = 0; i < tbBan.getColumnCount();i++){
            Class<?> col = tbBan.getColumnClass(i);
            tbBan.setDefaultEditor(col, null);
        }        
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        tbBan = new JTable();
        bntThem = new JButton();
        bntSua = new JButton();
        bntXoa = new JButton();
        jLabel10 = new JLabel();
        jLabel3 = new JLabel();
        lblthongtin = new JLabel();
        jLabel2 = new JLabel();

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
        jLabel3.setText("Quản lý tài khoản");

        lblthongtin.setFont(new Font("Tahoma", 1, 11)); 
        lblthongtin.setForeground(new Color(153, 0, 0));
        lblthongtin.setText("Total");

        jLabel2.setFont(new Font("Tahoma", 1, 11)); 
        jLabel2.setForeground(new Color(51, 0, 51));
        jLabel2.setText("Tổng số tài khoản");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3)
                        .addGap(305, 305, 305)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblthongtin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntSua, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntSua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblthongtin)))
                .addGap(50, 50, 50)
                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void tbBanMouseClicked(MouseEvent evt) {
    }

    private void bntThemActionPerformed(ActionEvent evt) {
        DL_Them_TaiKhoan ban = new DL_Them_TaiKhoan(Run.QlCafe, true);
        ban.setVisible(true);
    }

    private void bntSuaActionPerformed(ActionEvent evt) {
        int select=tbBan.getSelectedRow();
        if(select<0){
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn !");
        }else{
            int MaBan = (int) tbBan.getValueAt(select, 0);
            DL_Sua_TaiKhoan sua = new DL_Sua_TaiKhoan(Run.QlCafe, true, MaBan);
            sua.setVisible(true);
        }
    }

    private void bntXoaActionPerformed(ActionEvent evt) {
        int[] selectedRows = tbBan.getSelectedRows();

        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa tài khoản !");
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
            qs = JOptionPane.showConfirmDialog(null, "Xóa tài khoản: \n " + sp, "Xóa tài khoản", JOptionPane.YES_NO_OPTION);
            if (qs == JOptionPane.YES_OPTION) {
                boolean xoa = cn.DeleteTaiKhoan(ListMaBan);

                if (xoa == true) {
                    FillTable();
 
                }else
                JOptionPane.showMessageDialog(null, "Không xóa được tài khoản !");

            }
        }
    }
}

