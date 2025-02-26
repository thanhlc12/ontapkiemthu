package com.example.ontap4;


import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    List<SinhVien> list = new ArrayList<SinhVien>();

    public void addSinhVien(SinhVien sinhVien) {
        if (sinhVien.getMaSV() == null || sinhVien.getMaSV().trim().isEmpty()) {
            throw new IllegalArgumentException("MaSV is empty");
        }
        list.add(sinhVien);
    }

    public boolean deleteSinhVien(String maSV) {
        return list.removeIf(sinhVien -> sinhVien.getMaSV().equals(maSV));
    }

    public void updateSinhVien(SinhVien sinhVien, String ten, int tuoi, float diemTrungBinh, int hocKy, String chuyenNganh) {
        if (ten == null || ten.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten khong duoc de trong");
        }
        if (tuoi <= 0 || tuoi > 100) {
            throw new IllegalArgumentException("Tuoi phai lon hon 0 va nho hon 100");
        }
        if (diemTrungBinh <= 0 || diemTrungBinh > 10) {
            throw new IllegalArgumentException("Diem trung binh hon 0 va nho hon 10");
        }
        if (hocKy <= 0 || hocKy >= 10) {
            throw new IllegalArgumentException("Hoc Ky phai lon hon 0 va nho hon 10");
        }
        if (chuyenNganh == null || chuyenNganh.trim().isEmpty()) {
            throw new IllegalArgumentException("ChuyenNganh khong duoc de trong");
        }
        sinhVien.setTen(ten);
        sinhVien.setTuoi(tuoi);
        sinhVien.setDiemTrungBinh(diemTrungBinh);
        sinhVien.setHocKy(hocKy);
        sinhVien.setChuyenNganh(chuyenNganh);
    }

    public SinhVien timKiemSinhVien(String maSV) {
        for (SinhVien sinhVien : list) {
            if (sinhVien.getMaSV().equalsIgnoreCase(maSV)) {
                return sinhVien;
            }
        }
        return null;
    }

    public List<SinhVien> getListSinhVien() {
        return list;
    }
}
