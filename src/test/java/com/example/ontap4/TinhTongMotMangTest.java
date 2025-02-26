package com.example.ontap4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TinhTongMotMangTest {
    TinhTongMotMang tinhTongMotMang = new TinhTongMotMang();

    @Test
    public void tinhTongMotMang() {
        int[] arr = {1, 2, 3, 4, 5};
        Assertions.assertEquals(25, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang2() {
        int[] arr = {};
        Assertions.assertEquals(0, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang3() {
        int[] arr = {-10, 2, 4, -3, 5};
        Assertions.assertEquals(-2, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang4() {
        int[] arr = {10};
        Assertions.assertEquals(10, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang5() {
        int[] arr = {-1, -2, -3, -4, -5};
        Assertions.assertEquals(-15, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang6() {
        int[] arr = {0, -1, 2, -3, 4, 5};
        Assertions.assertEquals(7, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang7() {
        int[] arr = {Integer.MAX_VALUE};
        Assertions.assertEquals(Integer.MAX_VALUE, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang8() {
        int[] arr = {Integer.MIN_VALUE};
        Assertions.assertEquals(Integer.MIN_VALUE, tinhTongMotMang.tinhTongMot(arr));
    }

    @Test
    public void tinhTongMotMang9() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        Assertions.assertEquals(-1, tinhTongMotMang.tinhTongMot(arr));
    }
}
