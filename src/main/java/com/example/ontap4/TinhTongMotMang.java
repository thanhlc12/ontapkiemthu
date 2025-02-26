package com.example.ontap4;

public class TinhTongMotMang {
    public int tinhTongMot(int[] arr) {
        int tong = 0;
        for (int sum : arr) {
            tong += sum;
        }
        return tong;
    }
}
