package Controllers;

import Animals.*;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class WinFirstController  {

    static  Animal animal = new Cat("test",123,123,true);


    @FXML
    public Label Owl;
    @FXML
    public Label Ferret;
    @FXML
    public Label Dog;
    @FXML
    public Label CatPrice;
    @FXML
    public Label PriceDog;
    @FXML
    public Label OwlPrice;
    @FXML
    public Label FerretPrice;

    @FXML
    private ResourceBundle resources;



    @FXML
    private URL location;

    private  WinSecondController winSecondController;

    private Stage management;



    // JOptionPane.showMessageDialog(null,"Hellllo!!!");
    @FXML
    void initialize() {

    }

    public void BuyCat(MouseEvent mouseEvent)
    {

        animal = new Cat("Cat",Integer.valueOf(CatPrice.getText()),12,true);
        showScene();

    }

    public void BuyDog(MouseEvent mouseEvent)
    {

        animal = new Dog("Dog",Integer.valueOf(PriceDog.getText()),12,true);
        showScene();

    }

    public void BuyOwl(MouseEvent mouseEvent)
    {

        animal = new Owl("Owl",Integer.valueOf(OwlPrice.getText()),12,true);
        showScene();

    }
    public void BuyFerret(MouseEvent mouseEvent)
    {

        animal = new Ferret("Ferret",Integer.valueOf(FerretPrice.getText()),12,true);
        showScene();

    }


    public void toManagement(MouseEvent mouseEvent)
    {
        if(management == null) {
            Parent root = null;

            try {

                root = FXMLLoader.load(getClass().getResource("/WinThird.fxml"));

            } catch (IOException e) {
                e.printStackTrace();
            }


            Scene scene = new Scene(root);
            management = new Stage();

            management.setTitle("Management");
            management.setScene(scene);


            management.show();
        }
        else if(management.isShowing())
        {

            management.toFront();
        }
        else
        {
            management.show();
        }

    }


    public void showScene()
    {


        Parent root = null;

        try {

            root = FXMLLoader.load(getClass().getResource("/WinSecond.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }




        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setTitle("Confirmation");
        stage.setScene(scene);

        stage.show();

    }
}