package kursova.javafx;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Turimatsov
 */
public class HomeViewController implements Initializable {

    @FXML
    private Menu danni;
    @FXML
    private MenuItem vavedi;
    @FXML
    private MenuItem spisak;
    @FXML
    private Menu spravki;
    @FXML
    private MenuBar menuNav;
    @FXML
    private Label hours;
    @FXML
    private Label text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
         int second = LocalDateTime.now().getSecond();
         int minute = LocalDateTime.now().getMinute();
         int hour = LocalDateTime.now().getHour();
        hours.setText(hour + ":" + (minute) + ":" + second);}),
         new KeyFrame(Duration.seconds(1)));
         LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();}    
    
    @FXML
    private void vavediDanniAction(ActionEvent event) throws IOException {
     this.changeMyStage("AddData.fxml");}

    @FXML
    private void spisakAction(ActionEvent event) throws IOException {
     this.changeMyStage("ListShow.fxml");}
    
    
    public void changeMyStage(String view) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(view));  
        Scene scene = new Scene(root);   
        Stage obuvki = new Stage();      
        obuvki.setTitle("                                                                                      Курсов проект");      
        obuvki.getIcons().add(new Image(KursovaJavaFX.class.getResourceAsStream("books-icon.png")));    
        obuvki.setResizable(false);
        obuvki.sizeToScene();
        obuvki.setScene(scene);
        obuvki.show();     
        Stage current = (Stage) menuNav.getScene().getWindow();
        current.hide();
        
        current.sizeToScene();    
        obuvki.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent we){
                current.show();current.sizeToScene();
            }
        });
    }      
    @FXML
    private void ContactEvent(ActionEvent event) throws IOException {
    this.changeMyStage("Contacts.fxml");}

    @FXML
    private void IzgotvenoEvent(ActionEvent event) throws IOException {
    this.changeMyStage("IzgotviliView.fxml");}
   }
