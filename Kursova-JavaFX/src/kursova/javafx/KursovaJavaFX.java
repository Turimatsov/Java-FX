package kursova.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Turimatsov
 */
public class KursovaJavaFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));   
        stage.setResizable(false);
        stage.sizeToScene();
        stage.getIcons().add(new Image(KursovaJavaFX.class.getResourceAsStream("books-icon.png")));
        stage.setTitle("     Курсов проект - Admin");
        Scene scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
