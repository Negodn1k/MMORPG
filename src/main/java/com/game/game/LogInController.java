package com.game.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    Label invalidData;

    @FXML
    Button loginButton;

    @FXML
    protected void onLoginButtonClick() {
        try {
            Account account = new Account(loginField.getText(), passwordField.getText());
            if (!account.accountValidation()) {
                invalidData.setText("Неверный логин или пароль");
            } else {
                openMainWindow();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
            }

        } catch (NullPointerException e) {
            invalidData.setText("Неверный логин или пароль");
        }
    }

    private void openMainWindow() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(LogInController.class.getResource("choose-character-page.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Game");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {

        }
    }
}