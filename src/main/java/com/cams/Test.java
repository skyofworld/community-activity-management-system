package com.cams;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        long time = 1559219520000L;
        Date data = new Date();
        data.setTime(time);
        System.out.println(new SimpleDateFormat().format(data));
    }
}
