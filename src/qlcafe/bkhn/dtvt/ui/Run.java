package qlcafe.bkhn.dtvt.ui;

import qlcafe.bkhn.dtvt.models.TaiKhoan;

public class Run {
    public static frmMain QlCafe;
    public static frmLogin frmlg;
    public static TaiKhoan tk;
    public static void main(String[] args) {

        lg();
    }
    public static void lg(){
        frmlg = new frmLogin();
        frmlg.setVisible(true);       
    }  
    public static void QLCF(){
        QlCafe = new frmMain();
        QlCafe.setVisible(true);
    }
   
   
}

