package kursova.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Turimatsov
 */
public class AdminController implements Initializable {

    @FXML
    private TextField ime;
    @FXML
    private TextField parola;
    @FXML
    private AnchorPane window;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void changeMyStage(String view) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(view)); 
        Scene scene = new Scene(root);
        Stage knigi = new Stage();
        knigi.setTitle("                                                                                      Курсов проект");      
        knigi.getIcons().add(new Image(KursovaJavaFX.class.getResourceAsStream("books-icon.png")));
        knigi.setResizable(false);
        knigi.sizeToScene();
        knigi.setScene(scene);
        knigi.show();
        Stage current = (Stage) window.getScene().getWindow();
        current.hide();current.sizeToScene();
        knigi.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent we){
               current.sizeToScene();
                current.show();}});
    }
    @FXML
    private void adminEvent(ActionEvent event) throws IOException {
        String ime1=ime.getText();
        String parola1=parola.getText();
        if(ime1.equals("AdMiN")&&parola1.equals("admiN")){
        this.changeMyStage("HomeView.fxml");
        ime.setText("");parola.setText("");}
        else{JOptionPane.showMessageDialog(null,"Грешно потребителско име и/или парола! ");}
}}
