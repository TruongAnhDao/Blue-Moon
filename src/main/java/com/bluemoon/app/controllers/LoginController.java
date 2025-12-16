package com.bluemoon.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;

    @FXML
    public void handleLogin() {
        String user = tfUsername.getText();
        String pass = pfPassword.getText();
        System.out.println("DL Test: Đang đăng nhập với " + user);
        // Sau này sẽ gọi MysqlConnection ở đây để check DB
    }
}