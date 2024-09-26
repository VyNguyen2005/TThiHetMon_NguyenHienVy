package model;
/*
  Tác giả: Nguyễn Hiền Vy
*/
public class KhachHang {
    private String maso;
    private String hoten;
    private int loai;
    private double chisocu;
    private double chisomoi;            

    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int loai, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.loai = loai;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }
    
    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }

    //sinh viên cài đặt xử lý cho các phương thức sau    
    public double getTieuThu()
    {
       return getChisomoi() - getChisocu();
    }
   
    public double getTienTra()
    {
       double tientra = 0;
       if(getLoai() == 1){
           tientra = getTieuThu() * 4575;
       }
       else if(getLoai() == 2){
           if(getTieuThu() <= 50){
               tientra = getTieuThu() * 1806;
           }
           else if(getTieuThu() <= 100 && getTieuThu() > 50){
               tientra = 50 * 1806 + ((getTieuThu() - 50) * 1866);
           }
           else if(getTieuThu() <= 200 && getTieuThu() > 100){
               tientra = 50 * 1806 + 50 * 1866 + ((getTieuThu() - 100) * 2167);
           }
           else if(getTieuThu() <= 300 && getTieuThu() > 200){
               tientra = 50 * 1806 + 50 * 1866 + 100 * 2167 + ((getTieuThu() - 200) * 2729);
           }
           else if(getTieuThu() <= 400 && getTieuThu() > 300){
               tientra = 50 * 1806 + 50 * 1866 + 100 * 2167 + 100 * 2729 + ((getTieuThu() - 300) * 3050);
           }
           else{
               tientra = 50 * 1806 + 50 * 1866 + 100 * 2167 + 100 * 2729 + 100 * 3050 + ((getTieuThu() - 400) * 3151);
           }
       }
       tientra = tientra * 1.08;
       
       return tientra;
    }         
}
