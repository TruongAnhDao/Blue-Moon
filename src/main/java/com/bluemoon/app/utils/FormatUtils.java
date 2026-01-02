package com.bluemoon.app.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatUtils {

    /**
     * Định dạng số tiền sang kiểu tiền tệ Việt Nam
     * Ví dụ: 1000000.0 -> "1.000.000 ₫"
     * @param amount Số tiền (double)
     * @return Chuỗi đã định dạng
     */
    public static String formatCurrency(double amount) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        return currencyVN.format(amount);
    }

    /**
     * Định dạng ngày tháng từ đối tượng Date sang chuỗi
     * Ví dụ: Date object -> "25/12/2025"
     * @param date Ngày cần định dạng
     * @return Chuỗi ngày tháng hoặc rỗng nếu date null
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    /**
     * Hàm tiện ích parse chuỗi ngày tháng từ giao diện về Date (nếu cần xử lý ngược lại)
     */
    public static Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }
}