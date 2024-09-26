package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;
/*
  Tác giả: Họ tên sinh viên
*/
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    //sinh viên cải đặt cho các phương thức xử lý sau
   
    public void DocKhachHang(String filename) {
        dsKhachHang.clear();
        ArrayList<String> data = FileHelper.readFileText(filename);
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setLoai(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.valueOf(arr[3]));
            kh.setChisomoi(Double.valueOf(arr[4]));
            dsKhachHang.add(kh);
        }
    }

    public boolean GhiHoaDon(String filename) {
        ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getTieuThu() + ";" + kh.getTienTra();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    }
   
    public void sapXepTheoLoaiHinh() {
        Comparator<KhachHang> compare = (kh1, kh2) -> {
            return Double.compare(kh1.getLoai(), kh2.getLoai());
        };
        Collections.sort(dsKhachHang, compare);
    }
    
    public double getTieuThuCaoNhat()
    {
      return 0;    
    }
    
    public double getTieuThuThapNhat()
    {
        double tieuthuthapnhat = dsKhachHang.get(0).getTieuThu();
        for (KhachHang khachHang : dsKhachHang) {
            double tieuthu = khachHang.getTieuThu();
            if(tieuthuthapnhat > tieuthu){
                tieuthuthapnhat = tieuthu;
            }
        }
        return tieuthuthapnhat;
    }
    
    public double getTieuThuTrungBinh()
    {
        double avg;
        double tongtieuthu = 0;
        int soluongkh = dsKhachHang.size();
        for (int i = 0; i < dsKhachHang.size(); i++) {
            tongtieuthu += dsKhachHang.get(i).getTieuThu();
        }
        avg = tongtieuthu / soluongkh;
        return Double.parseDouble(String.format("%.2f", avg));
    }
}
