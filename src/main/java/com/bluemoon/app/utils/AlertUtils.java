package com.bluemoon.app.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class AlertUtils {

    /**
     * Hiển thị thông báo thành công (Icon chữ i màu xanh)
     * @param content Nội dung thông báo
     */
    public static void showSuccess(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo thành công");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Hiển thị cảnh báo (Icon tam giác vàng - thường dùng khi nhập thiếu dữ liệu)
     * @param content Nội dung cảnh báo
     */
    public static void showWarning(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Cảnh báo");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Hiển thị lỗi (Icon màu đỏ - dùng khi lỗi hệ thống hoặc Exception)
     * @param content Nội dung lỗi
     */
    public static void showError(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi hệ thống");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Hiển thị hộp thoại xác nhận (Yes/No)
     * @param content Câu hỏi xác nhận (Ví dụ: Bạn có chắc muốn xóa?)
     * @return true nếu chọn OK, false nếu chọn Cancel
     */
    public static boolean showConfirmation(String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setHeaderText(null);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}