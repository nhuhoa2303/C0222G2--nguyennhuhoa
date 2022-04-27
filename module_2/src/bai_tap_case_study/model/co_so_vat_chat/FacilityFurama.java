package bai_tap_case_study.model.co_so_vat_chat;

import java.util.Date;

public abstract class FacilityFurama {
    private String tenDichVu;
    private String chiPhiThue;
    private String dienTichSuDung;
    private String soLuongNguoi;
    private String kieuThue;
    public FacilityFurama(){}

    public FacilityFurama(String tenDichVu, String chiPhiThue, String dienTichSuDung,
                          String soLuongNguoi,String kieuThue) {
        this.tenDichVu = tenDichVu;
        this.chiPhiThue= chiPhiThue;
        this.dienTichSuDung = dienTichSuDung;
        this.soLuongNguoi = soLuongNguoi;
        this.kieuThue = kieuThue;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(String chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public String getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(String dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public String getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(String soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }


    @Override
    public String toString() {
        return "tenDichVu='" + tenDichVu +
                ", chiPhiThue='" + chiPhiThue +
                ", dienTichSuDung='" + dienTichSuDung +
                ", soLuongNguoi='" + soLuongNguoi +
                ", kieuThue='" + kieuThue ;
    }
}
