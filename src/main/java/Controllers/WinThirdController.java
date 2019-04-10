package Controllers;

import Animals.*;
import Employees.Employee;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

import static Employees.Employee.getEmployees;

public class WinThirdController {

    @FXML
    public TextField TextFieldAName;

    @FXML
    public ListView ListEmployee;

    @FXML
    public TextField TextFieldAPrice;

    @FXML
    public TextField TextFieldAAge;

    @FXML
    private ComboBox<String> cBAnimalTypes;

    @FXML
    ListView<Animal> listViewForAnimals ;

    @FXML
    TextField textFieldEName;

    @FXML
    TextField textFieldEPassword;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    private ObservableList<Animal> animalObservableList = FXCollections.observableArrayList(AnimalSerializator.Deserialize());
    private ObservableList<Employee> employees = FXCollections.observableArrayList(getEmployees());


    @FXML
    void initialize() {


        ListEmployee.getItems().addAll(employees);



        ObservableList<String> strings = FXCollections.observableArrayList("Cat","Dog","Ferret","Owl");

        cBAnimalTypes.setItems(strings);

        listViewForAnimals.getItems().addAll(animalObservableList);

        TextFieldAPrice.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    TextFieldAPrice.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });


        TextFieldAAge.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    TextFieldAAge.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
       animalFieldsRefresh();
       employeeFieldRefresh();
    }

    public void AddNewEmployee(MouseEvent mouseEvent) {

        if(!textFieldEName.getText().equals("") && !textFieldEPassword.getText().equals(""))
        {
            Employee employee = new Employee(textFieldEName.getText(),textFieldEPassword.getText());
            employee.Serialize();

            ListEmployee.getItems().add(new Employee(textFieldEName.getText(),textFieldEPassword.getText()));
            ListEmployee.refresh();

            employeeFieldRefresh();

            JOptionPane.showMessageDialog(null,"New employee added");


        }
        else
            JOptionPane.showMessageDialog(null,"Fill all information");
    }

    public void DeleteEmployee(MouseEvent mouseEvent) {
        if (ListEmployee.getSelectionModel().getSelectedItem() != null)
        {
           Employee employee = (Employee) ListEmployee.getSelectionModel().getSelectedItem();

           employee.deleteEmployee();
           ListEmployee.getItems().remove(ListEmployee.getSelectionModel().getSelectedItem());
        }

    }


    public void AddNewAnimal(MouseEvent mouseEvent) {


        Animal animal = new Cat("Test",12,12,true);

        if(!TextFieldAName.getText().equals("") && !TextFieldAPrice.getText().equals("") && !TextFieldAPrice.getText().equals("") && !cBAnimalTypes.getValue().equals(""))
     {

         switch (cBAnimalTypes.getValue())
         {
             case "Cat":
                 animal = new Cat(TextFieldAName.getText(), Integer.valueOf(TextFieldAPrice.getText()), Integer.valueOf(TextFieldAAge.getText()), true);
                 break;
             case "Dog":
                 animal = new Dog(TextFieldAName.getText(), Integer.valueOf(TextFieldAPrice.getText()), Integer.valueOf(TextFieldAAge.getText()), true);
                 break;
             case "Ferret":
                 animal = new Ferret(TextFieldAName.getText(), Integer.valueOf(TextFieldAPrice.getText()), Integer.valueOf(TextFieldAAge.getText()), true);
                 break;
             case "Owl":
                 animal = new Owl(TextFieldAName.getText(), Integer.valueOf(TextFieldAPrice.getText()), Integer.valueOf(TextFieldAAge.getText()), true);
                 break;


         }
         listViewForAnimals.getItems().add(animal);
         animalFieldsRefresh();

         JOptionPane.showMessageDialog(null,"New animal added");

     }
        else
            JOptionPane.showMessageDialog(null,"Fill all information");


    }



    private void employeeFieldRefresh()
    {
        textFieldEPassword.setText("");
        textFieldEName.setText("");
    }

    private void animalFieldsRefresh()
    {

        TextFieldAAge.setText("");
        TextFieldAPrice.setText("");
        TextFieldAName.setText("");
        cBAnimalTypes.setValue("");
        listViewForAnimals.refresh();

    }
}