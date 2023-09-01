package ru.etu.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class About implements Initializable {
    public Button okBtn;
    public Button copyBtn;
    public TextArea textArea;

    private App appController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        okBtn.setOnAction(event -> {
            Stage stage = (Stage) okBtn.getScene().getWindow();
            stage.close();
            appController.setAboutOpen(false);
        });

        copyBtn.setOnAction(event -> {
            StringSelection stringSelection = new StringSelection(textArea.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            Stage stage = (Stage) okBtn.getScene().getWindow();
            stage.close();
            appController.setAboutOpen(false);
        });
    }

    public void setAppController(App appController) {
        this.appController = appController;
    }

    @FXML
    private void arisGitHubLink() {
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/ilya201232"));
        } catch (Exception ignored) {}
    }

    @FXML
    private void ragrGitHubLink() {
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/mnelenpridumivat"));
        } catch (Exception ignored) {}
    }

    @FXML
    private void kostGitHubLink() {
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/Kostebelova-Elizaveta"));
        } catch (Exception ignored) {}
    }
}
