package qlcafe.bkhn.dtvt.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import qlcafe.bkhn.dtvt.models.Ban;
import qlcafe.bkhn.dtvt.models.TaiKhoan;
import qlcafe.bkhn.dtvt.mysql.ConnectSQL;
import qlcafe.bkhn.dtvt.ui.banhang.JpBanHang;
import qlcafe.bkhn.dtvt.ui.home.JpHome;
import qlcafe.bkhn.dtvt.ui.kho.JpKho;
import qlcafe.bkhn.dtvt.ui.quanly.JpQuanLy;
import qlcafe.bkhn.dtvt.ui.setting.JpSetting;
import qlcafe.bkhn.dtvt.ui.thongke.JpThongKe;

public final class frmMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btnBanHang;
    private JButton btnKho;
    private JButton btnQuanLy;
    private JButton btnSound;
    private JButton btnThietLap;
    private JButton btnThongKe;
    private JButton btnTrangChu;
    private JButton btnmute;
    private JButton btnthoat;
    private Box.Filler filler1;
    private JLabel jLabel1;
    private JPanel jPanel2;
    private JPanel jpLayout;
    private JLabel lbldat;
    private JLabel lblpv;
    private JLabel lbltime;
    private JLabel txtqtv;
    ConnectSQL cn = new ConnectSQL();

    public TaiKhoan loadtaikhoan(String user, String pass) {
        return cn.GetTaiKhoan(user, pass);
    }

    public static int lm;
    public frmMain() {
        initComponents();
        fill();
        Clock clock = new Clock();
        clock.start();
        txtqtv.setText(Run.tk.GetUsername());
        if (Run.tk.GetLv() != 1) {
            btnQuanLy.setEnabled(false);
            btnQuanLy.setVisible(false);
            btnThongKe.setEnabled(false);
            btnThongKe.setVisible(false);
            btnKho.setEnabled(false);
            btnKho.setVisible(false);
        }else {
            btnBanHang.setVisible(false);
            btnBanHang.setEnabled(false);
        }
btnSound.setVisible(false);
        btnmute.setVisible(false);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss_a");

    public class Clock extends Thread {

        public Clock() {
        }

        @Override
        public void run() {
            while (true) {
                int bandat = 0, banpv = 0;
                ArrayList<Ban> arrBan = cn.GetBan(0);
                for (int i = 0; i < arrBan.size(); i++) {
                    if (arrBan.get(i).GetTrangThai().equals("Đang phục vụ")) {
                        banpv++;
                    }
                    if (arrBan.get(i).GetTrangThai().equals("Đã đặt trước")) {
                        bandat++;
                    }
                }
                lblpv.setText(+banpv + " bàn đang phục vụ");
                lbldat.setText(+bandat + " bàn đặt trước");
                Calendar calendar = Calendar.getInstance();
                String str;
                str = sdf.format(calendar.getTime());
                lbltime.setText(str);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void fill() {
        home = new JpHome();
        jpLayout.add(home);
        jpLayout.updateUI();
        mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/Ai la trieu phu - ai la trieu phu.mp3");
        mp3.play();
        btnmute.setVisible(false);

        //Khai bao dinh dang ngay thang
    }
    MP3 mp3;
    JpBanHang banhang;
    JpHome home;
    JpKho kho;
    JpSetting Set;
    JpQuanLy ql;
    JpThongKe tk;

    public void reloadPanel(int i) {
        jpLayout.removeAll();
        switch (i) {
            case 1:
                if (banhang == null) {
                    banhang = new JpBanHang();
                }
                btnBanHang.setPressedIcon(new ImageIcon("down.png"));
                mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/kasya.mp3");
                mp3.play();
                jpLayout.add(banhang);
                break;
            case 2:
                if (home == null) {
                    home = new JpHome();
                }
                //
                btnTrangChu.setPressedIcon(new ImageIcon("down.png"));
                mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/kasya.mp3");
                mp3.play();
                jpLayout.add(home);
                break;
            case 3:
                if (ql == null) {
                    ql = new JpQuanLy();
                }
                btnQuanLy.setPressedIcon(new ImageIcon("down.png"));
                jpLayout.add(ql);
                mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/kasya.mp3");
                mp3.play();
                break;
            case 4:
                tk = new JpThongKe();

                btnThongKe.setPressedIcon(new ImageIcon("down.png"));
                jpLayout.add(tk);
                mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/kasya.mp3");
                mp3.play();
                break;
            case 5:
                if (kho == null) {
                    kho = new JpKho();
                }
                btnKho.setPressedIcon(new ImageIcon("down.png"));
                mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/kasya.mp3");
                mp3.play();
                jpLayout.add(kho);
                break;
            case 6:
                if (Set == null) {
                    Set = new JpSetting();
                }
                btnThietLap.setPressedIcon(new ImageIcon("down.png"));
                mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/kasya.mp3");
                mp3.play();
                jpLayout.add(Set);
                break;
            default:
                break;
        }
        jpLayout.updateUI();
    }

    class MP3 {

        private Player player;
        private String filename;

        public MP3(String filename) {
            this.filename = filename;
        }

        public void stop() {
            if (player != null) {
                player.close();
            }
        }

        public void play() {
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
                player = new Player(bis);
            } catch (FileNotFoundException | JavaLayerException ex) {
                System.out.println(ex);
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }).start();
        }
    }
    //Lam gi do trong thoi gian phat nhac

    private void initComponents() {

        filler1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(0, 32767));
        jPanel2 = new JPanel();
        btnThietLap = new JButton();
        btnQuanLy = new JButton();
        btnBanHang = new JButton();
        btnThongKe = new JButton();
        btnKho = new JButton();
        jpLayout = new JPanel();
        btnthoat = new JButton();
        btnTrangChu = new JButton();
        btnSound = new JButton();
        btnmute = new JButton();
        lbltime = new JLabel();
        lblpv = new JLabel();
        lbldat = new JLabel();
        txtqtv = new JLabel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Coffee Music");
        setBackground(Color.decode("#e6e6e6"));
        setBounds(new Rectangle(0, 0, 0, 0));
        setForeground(new Color(255, 204, 255));
        setLocation(new Point(0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new Dimension(1280, 620));
        setResizable(false);
        setSize(new Dimension(0, 0));
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setBackground(Color.decode("#e6e6e6"));
        jPanel2.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 0), 2));
        jPanel2.setPreferredSize(new Dimension(1280, 600));

        btnThietLap.setFont(new Font("Tahoma", 1, 11));
        btnThietLap.setForeground(new Color(51, 51, 51));
        btnThietLap.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/Settings-L-icon.png")));
        btnThietLap.setText("THIẾT LẬP");
        btnThietLap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThietLap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnThietLapActionPerformed(evt);
            }
        });

        btnQuanLy.setFont(new Font("Tahoma", 1, 11));
        btnQuanLy.setForeground(new Color(51, 51, 51));
        btnQuanLy.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/icon-hoc-nau-an-Huong-nghiep-a-au-2015.png")));
        btnQuanLy.setText("QUẢN LÝ");
        btnQuanLy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnQuanLy.setPreferredSize(new Dimension(140, 49));
        btnQuanLy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });

        btnBanHang.setFont(new Font("Tahoma", 1, 11));
        btnBanHang.setForeground(new Color(51, 51, 51));
        btnBanHang.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/sellicon.png")));
        btnBanHang.setText("BÁN HÀNG");
        btnBanHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBanHang.setHorizontalAlignment(SwingConstants.TRAILING);
        btnBanHang.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnBanHang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnThongKe.setFont(new Font("Tahoma", 1, 11));
        btnThongKe.setForeground(new Color(51, 51, 51));
        btnThongKe.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/thongke.png")));
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThongKe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnKho.setFont(new Font("Tahoma", 1, 11));
        btnKho.setForeground(new Color(51, 51, 51));
        btnKho.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/kho.png")));
        btnKho.setText("KHO-NVL");
        btnKho.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnKhoActionPerformed(evt);
            }
        });

        jpLayout.setBackground(Color.decode("#e6e6e6")
        );
        jpLayout.setBorder(BorderFactory.createEtchedBorder(new Color(0, 102, 0), new Color(0, 51, 51)));
        jpLayout.setLayout(new BorderLayout());

        btnthoat.setFont(new Font("Tahoma", 1, 9));
        btnthoat.setForeground(new Color(0, 51, 0));
        btnthoat.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/Logout.png")));
        btnthoat.setText("Đăng xuất");
        btnthoat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnthoat.setHorizontalAlignment(SwingConstants.TRAILING);
        btnthoat.setHorizontalTextPosition(SwingConstants.LEFT);
        btnthoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        btnTrangChu.setFont(new Font("Tahoma", 1, 11));
        btnTrangChu.setForeground(new Color(51, 51, 51));
        btnTrangChu.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/HOME.png")));
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTrangChu.setHorizontalAlignment(SwingConstants.TRAILING);
        btnTrangChu.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnTrangChu.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                btnTrangChuFocusGained(evt);
            }
        });
        btnTrangChu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }

            public void mousePressed(MouseEvent evt) {
                btnTrangChuMousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                btnTrangChuMouseReleased(evt);
            }
        });
        btnTrangChu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnSound.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/Sound.png")));
        btnSound.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });

        btnmute.setIcon(new ImageIcon(getClass().getResource("/qlcafe/bkhn/dtvt/ui/images/mute.png")));
        btnmute.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnmute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnmuteActionPerformed(evt);
            }
        });

        lbltime.setFont(new Font("Tahoma", 1, 13));
        lbltime.setForeground(new Color(51, 102, 0));
        lbltime.setText("jLabel1");

        lblpv.setForeground(new Color(94, 94, 21));
        lblpv.setText("jLabel1");

        lbldat.setForeground(new Color(94, 94, 21));
        lbldat.setText("jLabel1");

        txtqtv.setFont(new Font("Tahoma", 1, 11));
        txtqtv.setForeground(new Color(204, 0, 0));
        txtqtv.setText("jLabel1");

        jLabel1.setForeground(new Color(51, 51, 0));
        jLabel1.setText("QTV:");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jpLayout, GroupLayout.PREFERRED_SIZE, 1254, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 2, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnTrangChu)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnBanHang)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnQuanLy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnThongKe)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnKho)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnThietLap)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbltime)
                                                        .addComponent(lbldat)
                                                        .addComponent(lblpv))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnmute, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSound, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtqtv))
                                                        .addComponent(btnthoat))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnQuanLy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnBanHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnTrangChu))
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(lbldat)
                                                        .addGap(3, 3, 3))
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnThongKe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnKho, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnThietLap)
                                                        .addComponent(lblpv)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtqtv)
                                                        .addComponent(lbltime)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnSound, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnthoat)
                                                        .addComponent(btnmute, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
                                .addGap(8, 8, 8)
                                .addComponent(jpLayout, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(1241, 1241, 1241)
                                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnBanHangActionPerformed(ActionEvent evt) {
        reloadPanel(1);
    }

    public void thoat() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng phần mềm ?", "FBI Warning", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            System.exit(0);
        }
    }

    private void btnthoatActionPerformed(ActionEvent evt) {
        int kq = JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản " + Run.tk.GetUsername() + "?", "FBI Warning", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            MP3 mp3 = new MP3("src/qlcafe/bkhn/dtvt/sound/tyaran.mp3");
            mp3.play();
            Run.frmlg.setVisible(true);
            Run.frmlg.thoat();
            this.setVisible(false);
        }

    }

    private void btnTrangChuActionPerformed(ActionEvent evt) {
        reloadPanel(2);
    }

    private void btnThietLapActionPerformed(ActionEvent evt) {
        reloadPanel(6);
    }

    private void formMouseClicked(MouseEvent evt) {
    }

    private void btnKhoActionPerformed(ActionEvent evt) {
        reloadPanel(5);
    }

    private void btnThongKeActionPerformed(ActionEvent evt) {
        reloadPanel(4);
        //        this.dispose();
        //        Run.rerun();
    }

    private void btnTrangChuFocusGained(FocusEvent evt) {
    }

    private void btnTrangChuMouseClicked(MouseEvent evt) {
    }

    private void btnTrangChuMouseEntered(MouseEvent evt) {

    }

    private void btnTrangChuMouseExited(MouseEvent evt) {

    }

    private void btnTrangChuMouseReleased(MouseEvent evt) {

    }

    private void btnTrangChuMousePressed(MouseEvent evt) {

    }
    MP3 nhacnen;

    private void btnSoundActionPerformed(ActionEvent evt) {
        nhacnen = new MP3("src/qlcafe/bkhn/dtvt/sound/Fur Elise - Richard Clayderman.mp3");
        nhacnen.play();
        btnSound.setVisible(false);
        btnmute.setVisible(true);
    }

    private void btnmuteActionPerformed(ActionEvent evt) {
        nhacnen.stop();
        btnSound.setVisible(true);
        btnmute.setVisible(false);
    }

    private void btnQuanLyActionPerformed(ActionEvent evt) {
        reloadPanel(3);

    }
}
