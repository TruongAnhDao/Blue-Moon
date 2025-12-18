package com.bluemoon.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/blue_moon_db";
    private static final String USER = "root"; 
    private static final String PASS = "T06012005a@"; // Mật khẩu MySQL của bạn, nếu không có thì để trống ""

    /**
     * Hàm lấy kết nối CSDL
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Đăng ký driver (MySQL 8.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Kết nối CSDL BlueMoon thành công!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
        return conn;
    }

    /*
     * Hàm tiện ích
     */
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
        return pstmt.executeQuery();
        // Cần đóng ResultSet và Connection sau khi dùng
    }

    public static int executeUpdate(String sql, Object... params) throws SQLException {
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        }
    }

    /**
     * Hàm chạy thử để test kết nối (Nhấn Run để kiểm tra)
     */
    public static void main(String[] args) {
        getConnection();
    }
}