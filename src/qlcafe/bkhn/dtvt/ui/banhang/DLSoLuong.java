package qlcafe.bkhn.dtvt.ui.banhang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.models.ChiTietHD;
import qlcafe.bkhn.dtvt.models.HoaDon;
import qlcafe.bkhn.dtvt.models.ThucDon;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;

@SuppressWarnings("serial")
public class DLSoLuong extends JDialog {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    
    private JLabel lblDVT;
    private JLabel lblTenMon;
    private JLabel lblban;
    
    private JPanel jPanel1;
    
    private JTextField txtSl;
    private JTextField txtgia;
    
    ConnectSQL cn = new ConnectSQL();
    int sl = 0;
    ArrayList<ThucDon> arrThucDon;
    public String gioden, mamon, TenBan;
    public int maban;
    ChiTietHD mon;
    
    public DLSoLuong(Frame parent, boolean modal, String MaMon, String tenban, int MaBan) {
        super(parent, modal);
        initComponents();
        mamon = MaMon;
        TenBan = tenban;
        maban = MaBan;
        Fill();
        mon = cn.GetDsChiTiet(MaMon, MaBan);
        if(mon != null){
            txtgia.setText(String.valueOf(mon.GetGia()));
            txtSl.setText(String.valueOf(mon.GetSoLuong()));
            
        }
                

    }
    
    //Hàm điền các thông số mặc định khi hiển thị dialog
    private void Fill(){
        arrThucDon = cn.GetThucDonByMa(mamon);
        txtSl.setText("1");
        lblban.setText(TenBan + " ");
        
        lblTenMon.setText(arrThucDon.get(0).GetTenMon());
        lblDVT.setText(arrThucDon.get(0).GetDVT());
        txtgia.setText(String.valueOf(arrThucDon.get(0).GetDonGia()));
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        lblTenMon = new JLabel();
        lblDVT = new JLabel();
        txtSl = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        lblban = new JLabel();
        txtgia = new JTextField();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//dialog vẫn chạy ngầm khi tắt, chỉ ẩn cửa số dialog đi.
        setBackground(new Color(140, 140, 6));
        setLocation(new Point(500, 200));
        setUndecorated(true);
        setResizable(false);
        
        //Viền khung
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 0), 2));
        
        // Tên món ăn và đơn vị tiền khi nhấn
        lblTenMon.setFont(new Font("Tahoma", 1, 18)); 
        lblTenMon.setForeground(new Color(51, 0, 0));
        lblTenMon.setText("Cà phê sữa");

        lblDVT.setText("Ly");

        //Xử lý sự kiện 
        txtSl.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txtSlKeyReleased(evt);
            }
        });

        jButton1.setFont(new Font("Tahoma", 1, 11)); 
        jButton1.setText("Đồng ý");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new Font("Tahoma", 1, 11)); 
        jButton2.setText("Hủy");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/tru(-).png"))); 
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/Cong(+).png"))); 
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 1, 11)); 
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setText("Số lượng:");

        jLabel3.setFont(new Font("Tahoma", 1, 11)); 
        jLabel3.setText("Giá:");

        lblban.setFont(new Font("Tahoma", 1, 20)); 
        lblban.setForeground(new Color(0, 51, 0));
        lblban.setText("Bàn1");

        txtgia.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txtgiaKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/thucdon2.png"))); 

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblban))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTenMon)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtSl, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblDVT, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtgia, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblban)
                    .addComponent(lblTenMon))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDVT)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtgia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
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

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
            sl = Integer.parseInt(txtSl.getText());
            if(sl < 1000){
                sl++;
                txtSl.setText(String.valueOf(sl));
            }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        try{
            sl = Integer.parseInt(txtSl.getText());
            if(sl != 1 && sl != 0){
                sl--;
                txtSl.setText(String.valueOf(sl));
            }
        }catch(Exception e){
                txtSl.setText("1");
        }

    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();  
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // Nếu bàn chưa có hóa đơn thì tạo hóa đơn kèm giờ đến
        if(cn.GetMaHD(maban) == 0){
            HoaDon hd = new HoaDon();
            hd.SetMaBan(maban); //hóa đơn của bàn nào
            hd.SetTrangThai(0); //trạng thái chưa thanh toán
            //JOptionPane.showMessageDialog(null, gioden);
            cn.InsertHoaDon(hd, gioden);
        }

        // Cập nhật chi tiết hóa đơn nếu món ăn đã gọi rồi
        if(mon != null){
            ChiTietHD ct = new ChiTietHD();
            ct.SetGia(Integer.parseInt(txtgia.getText()));
            ct.SetSoLuong(Integer.parseInt(txtSl.getText()));
            ct.SetMaChiTietHD(mon.GetMaChiTietHD());
            cn.UpdateChiTiet(ct);
        }
        
        // Thêm món ăn vào chi tiết hóa đơn nếu món ăn chưa được gọi trong danh sách
        if(mon == null){
            ChiTietHD cthd = new ChiTietHD();
            cthd.SetGia(Integer.parseInt(txtgia.getText()));
            cthd.SetMaHD(cn.GetMaHD(maban));
            cthd.SetMaMon(mamon);
            cthd.SetSoLuong(Integer.parseInt(txtSl.getText()));
            cn.InsertChiTietHD(cthd);
        }

        //Cập nhật lại bàn ăn sau khi chọn 
        Ban b = new Ban();
        b.SetTrangThai("Đang phục vụ");
        b.SetTenBan(TenBan);
        b.SetMaBan(maban);
        cn.UpdateBan(b);

        //Cập nhật lại giao diện sau khi chọn món xong và tắt dialog
        JpBanHang.bh.FillBan();
        JpBanHang.bh.updateUI();
        JpGoiMon.gm.fillDsMon(cn.GetMaHD(maban));
        JpGoiMon.gm.updateUI();

        this.dispose();
    }

    private void txtSlKeyReleased(KeyEvent evt) {
        try{
            sl = Integer.parseInt(txtSl.getText());
            if(txtSl.getText().equals("0") || sl > 1000 || sl<0)
                txtSl.setText("1");
        }catch(Exception e){
           
        }
    }

    private void txtgiaKeyReleased(KeyEvent evt) {
        try{
            Integer.parseInt(txtgia.getText());

        }catch(Exception e){
            txtgia.setText(String.valueOf(arrThucDon.get(0).GetDonGia()));
        }
        if(txtgia.getText().equals("0")){
            txtgia.setText(String.valueOf(arrThucDon.get(0).GetDonGia()));
        }       
    }
}

