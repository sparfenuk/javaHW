import Animals.*;
import Employees.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Employee e = new Employee("admin", "admin");
        e.Serialize();

        Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();

    }


    public static void main(String[] args) {

//        ArrayList<Animal> animals = new ArrayList<>();
//        animals.add(new Cat("xD",12,4,false));
//        animals.add(new Dog("woof",12,4,false));
//        animals.add(new Ferret("allo",12,4,false));
//        animals.add(new Owl("Hoodiny",12,4,false));
//        animals.add(new Cat("get to the choppa",12,4,false));
//        animals.add(new Dog("ama good boy",12,4,false));
//        System.out.print(AnimalSerializator.Serialize(animals));

        launch(args);
//        for (  Animal animal:AnimalSerializator.Deserialize()) {
//            System.out.println(animal.type);
//        }
    }
}

