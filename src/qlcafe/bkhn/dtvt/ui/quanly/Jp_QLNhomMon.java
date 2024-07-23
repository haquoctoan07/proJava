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

import qlcafe.bkhn.dtvt.models.Loai;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.Run;
import qlcafe.bkhn.dtvt.ui.banhang.JpThucDon;

@SuppressWarnings("serial")
public class Jp_QLNhomMon extends JPanel {

    private JButton bntSua;
    private JButton bntThem;
    private JButton bntXoa;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JLabel lblthongtin;
    private JTable tbNhomMon;
    private JTextField txttim;
    ConnectSQL cn = new ConnectSQL();
    public static Jp_QLNhomMon nhom;

    public Jp_QLNhomMon() {
        initComponents();
        nhom = this;
        FillTable();
    }

    public void FillTable() {
        ArrayList<Loai> arrTable = cn.GetLoai();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Mã loại");
        tbmodel.addColumn("Tên loại");
        tbmodel.addColumn("Màu sắc");

        if (arrTable != null) {
            int soloai = 0;
            for (Loai l : arrTable) {
                soloai++;
                tbmodel.addRow(new Object[]{l.GetMaLoai(), l.GetTenLoai(), l.GetMauSac()});
            }
            lblthongtin.setText(String.valueOf(soloai) + " loại");
        } else {
            JOptionPane.showMessageDialog(null, "Không có loại nào");
        }
        tbNhomMon.setModel(tbmodel);
        for (int i = 0; i < tbNhomMon.getColumnCount(); i++) {
            Class<?> col = tbNhomMon.getColumnClass(i);
            tbNhomMon.setDefaultEditor(col, null);
        }
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        tbNhomMon = new JTable();
        bntThem = new JButton();
        bntSua = new JButton();
        bntXoa = new JButton();
        jLabel10 = new JLabel();
        jLabel3 = new JLabel();
        lblthongtin = new JLabel();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        txttim = new JTextField();

        tbNhomMon.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbNhomMon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tbNhomMonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhomMon);

        bntThem.setFont(new Font("Tahoma", 1, 11));
        bntThem.setForeground(new Color(51, 51, 0));
        bntThem.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/file_add.png")));
        bntThem.setText("Thêm");
        bntThem.setHorizontalAlignment(SwingConstants.LEADING);
        bntThem.addActionListener((ActionEvent evt) -> {
            bntThemActionPerformed(evt);
        });

        bntSua.setFont(new Font("Tahoma", 1, 11));
        bntSua.setForeground(new Color(51, 51, 0));
        bntSua.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/document_edit.png")));
        bntSua.setText("Sửa");
        bntSua.setHorizontalAlignment(SwingConstants.LEADING);
        bntSua.addActionListener((ActionEvent evt) -> {
            bntSuaActionPerformed(evt);
        });

        bntXoa.setFont(new Font("Tahoma", 1, 11));
        bntXoa.setForeground(new Color(51, 51, 0));
        bntXoa.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/file_delete.png")));
        bntXoa.setText("Xóa");
        bntXoa.setHorizontalAlignment(SwingConstants.LEADING);
        bntXoa.addActionListener((ActionEvent evt) -> {
            bntXoaActionPerformed(evt);
        });

        jLabel10.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/cooltext171088793851573.png")));

        jLabel3.setFont(new Font("Tahoma", 1, 11));
        jLabel3.setForeground(new Color(102, 0, 0));
        jLabel3.setText("Quản lý Loại món");

        lblthongtin.setFont(new Font("Tahoma", 1, 11));
        lblthongtin.setForeground(new Color(153, 0, 0));
        lblthongtin.setText("Total");

        jLabel2.setFont(new Font("Tahoma", 1, 11));
        jLabel2.setForeground(new Color(51, 0, 51));
        jLabel2.setText("Tổng số loại:");

        jLabel1.setFont(new Font("Tahoma", 1, 12));
        jLabel1.setText("Tìm loại:");

        txttim.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                txttimKeyReleased(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bntSua, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(38, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(309, 309, 309)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblthongtin)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttim, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txttim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bntThem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(bntSua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(bntXoa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(lblthongtin))
                                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    private void tbNhomMonMouseClicked(MouseEvent evt) {
    }

    private void bntThemActionPerformed(ActionEvent evt) {
        DLQl_Them_Loai l = new DLQl_Them_Loai(Run.QlCafe, true);
        l.setVisible(true);
//        Loai a;
//
//        if (cn.InsertLoai(Loai a)) {
//            FillTable();
//            try {
//                Jp_QLThucDon.td.Fillcbb();
//                Jp_QLThucDon.td.FillTable(null);
//                Jp_QLThucDon.td.updateUI();
//                JpThucDon.td.FillLoai();
//                JpThucDon.td.updateUI();
//            } catch (Exception e) {
//
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Không thêm được loại !");
//        }

    }

    private void bntSuaActionPerformed(ActionEvent evt) {
        int select = tbNhomMon.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhóm nào !");
        } else {
            String manhom = (String) tbNhomMon.getValueAt(select, 0);

            DLQl_Sua_Nhom sua = new DLQl_Sua_Nhom(Run.QlCafe, true, manhom);
            sua.setVisible(true);
        }
    }

    private void bntXoaActionPerformed(ActionEvent evt) {
        int[] selectedRows = tbNhomMon.getSelectedRows();

        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhóm nào !");
        } else {
            ArrayList<String> listmamon = new ArrayList<>();
            String sp = "";
            for (int i : selectedRows) {
                String ma = (String) tbNhomMon.getValueAt(i, 0);
                listmamon.add(ma);
                String tennhom = (String) tbNhomMon.getValueAt(i, 1);

                sp += tennhom + "\n";
            }
            int qs;
            qs = JOptionPane.showConfirmDialog(null, "Xóa nhóm: \n " + sp, "Xóa nhóm", JOptionPane.YES_NO_OPTION);
            if (qs == JOptionPane.YES_OPTION) {
                boolean xoa = cn.DeleteNhom(listmamon);

                if (xoa == true) {
                    FillTable();
                    try {
                        Jp_QLThucDon.td.Fillcbb();
                        Jp_QLThucDon.td.FillTable(null);
                        Jp_QLThucDon.td.updateUI();
                        JpThucDon.td.FillLoai();
                        JpThucDon.td.updateUI();
                    } catch (Exception e) {

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không xóa được loại !");
                }

            }
        }
    }

    private void txttimKeyReleased(KeyEvent evt) {
        ArrayList<Loai> arrTable = cn.SearchLoai(txttim.getText());
        if (arrTable != null) {
            DefaultTableModel tbmodel = new DefaultTableModel();

            tbmodel.addColumn("Mã loại");
            tbmodel.addColumn("Tên loại");
            tbmodel.addColumn("Màu sắc");

            @SuppressWarnings("unused")
            int soloai = 0;
            for (Loai l : arrTable) {
                soloai++;
                tbmodel.addRow(new Object[]{l.GetMaLoai(), l.GetTenLoai(), l.GetMauSac()});
            }
            tbNhomMon.setModel(tbmodel);
            for (int i = 0; i < tbNhomMon.getColumnCount(); i++) {
                Class<?> col = tbNhomMon.getColumnClass(i);
                tbNhomMon.setDefaultEditor(col, null);
            }
        }
    }
}
