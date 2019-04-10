package Controllers;

import Animals.Animal;
import Employees.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class WinSecondController {

    public Animal animal = WinFirstController.animal;



    @FXML
    private ResourceBundle resources;

    @FXML
    private Label animalName;

    @FXML
    private Label animalPrice;

    @FXML
    private Label sellerName;

    private Stage currentStage;

    @FXML
    private URL location;

    @FXML
    void initialize() {



         sellerName.setText(Employee.currentUser.userName);
         animalName.setText(animal.name);
         animalPrice.setText(String.valueOf(animal.price));

    }




    private void printCheck (String check)
    {



     try {
         FileWriter fileWriter = new FileWriter("check.txt");
         fileWriter.write(check);
         fileWriter.close();
     }

     catch (Exception e)
     {
         System.out.print(e.getMessage());
     }


    }

    public void Confirmation(MouseEvent mouseEvent) {

       String checkInfo = String.format("------------------------\n" +
               "cashier name - %s\n" +
               "animal - %s \n" +
               "price - %d\n" +
               "------------------------\n",Employee.currentUser.userName,animal.name,animal.price);

        if(0 == JOptionPane.showConfirmDialog(null,checkInfo))
        {
            printCheck(checkInfo);
            currentStage = (Stage)sellerName.getScene().getWindow();
            currentStage.close();
        }
    }
}
