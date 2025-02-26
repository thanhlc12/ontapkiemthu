package com.example.ontap4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SinhVienTest {
    private SinhVienService sinhVienService;
    private SinhVien sinhVien;

    @BeforeEach
    public void setUp() {
        sinhVienService = new SinhVienService();
        sinhVienService.addSinhVien(new SinhVien("SV01", "Thanh", 20, 8.0f, 2, "IT"));
        sinhVien = new SinhVien("SV01", "Thanh", 20, 8.0f, 2, "IT");
    }

    @Test
    public void testAddSinhVien() {
        SinhVien sv = new SinhVien("SV02", "Hien", 21, 8.5f, 3, "IT");
        sinhVienService.addSinhVien(sv);
        assertEquals(2, sinhVienService.list.size());
    }


    @Test
    public void deleteSinhVien() {
        boolean result = sinhVienService.deleteSinhVien("SV01");
        assertTrue(result);
        assertEquals(0, sinhVienService.getListSinhVien().size());
    }

    @Test
    public void deleteSinhVienMaKhongHopLe() {
        boolean result = sinhVienService.deleteSinhVien("SV99");
        assertFalse(result);
    }
    @Test
    public void updateSinhVien() {
        sinhVienService.updateSinhVien(sinhVien, "Hien", 21, 8.5f, 3, "KTPM");
        assertEquals("Hien", sinhVien.getTen());
        assertEquals(21, sinhVien.getTuoi());
        assertEquals(8.5f, sinhVien.getDiemTrungBinh());
        assertEquals(3, sinhVien.getHocKy());
        assertEquals("KTPM", sinhVien.getChuyenNganh());
    }

    @Test
    public void updateSinhVienTrongTen() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.updateSinhVien(sinhVien, " ", 21, 8.5f, 3, "IT");
        });
        assertEquals("Ten khong duoc de trong", exception.getMessage());
    }

    @Test
    public void updateSinhVienTuoiNhoHon0() {
        assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.updateSinhVien(sinhVien, "Hien", -1, 8.5f, 3, "IT");
        });
    }

    @Test
    public void updateSinhVienDiemTrungBinhLonHon10() {
        assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.updateSinhVien(sinhVien, "Hien", 21, 11f, 3, "IT");
        });
    }

    @Test
    public void updateSinhVienHocKyLonHon10() {
        assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.updateSinhVien(sinhVien, "Hien", 21, 8.5f, 11, "KTPM");
        });
    }

    @Test
    public void updateSinhVienChuyenNganhTrong() {
        assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.updateSinhVien(sinhVien, "Hien", 21, 8.5f, 3, " ");
        });
    }

    @Test
    public void timKiemSinhVien() {
        List<SinhVien> ketQua = sinhVienService.timKiemSinhVien("SV01");
        assertFalse(ketQua.isEmpty());
        SinhVien sinhVien = ketQua.get(0);
        assertEquals("Thanh", sinhVien.getTen());
    }
}
