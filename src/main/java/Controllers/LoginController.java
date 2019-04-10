package Controllers;

import Employees.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    public TextField Name;

    @FXML
    public TextField Password;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }


    public void LogGo(MouseEvent mouseEvent) {

        if(Employee.checkLog(Name.getText(),Password.getText())){

            Parent root = null;

            try {

                root = FXMLLoader.load(getClass().getResource("/WinFirst.fxml"));

            } catch (IOException e) {
                e.printStackTrace();
            }




            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Shop");
            stage.setScene(scene);


            stage.show();

            stage = (Stage) Name.getScene().getWindow();
            stage.close();
        }

        else
        {

            JOptionPane.showMessageDialog(null,"Wrong login or password");

        }
    }
}