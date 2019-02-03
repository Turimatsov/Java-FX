package kursova.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Turimatsov
 */
public class AddDataController implements Initializable {
    @FXML
    private ImageView image;
    @FXML
    private TextField zaglavie;
    @FXML
    private TextField avtor;
    @FXML
    private TextField godina;
    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private ComboBox<String> signatura;
    @FXML
    private ComboBox<String> ezik;
    @FXML
    private ComboBox<String> janr;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> signat =
        FXCollections.observableArrayList("Учебник","Творба","Документ","Автобиография");
        signatura.setItems(signat);
        
        ObservableList<String> eziK =
        FXCollections.observableArrayList("Български","Английски","Друг");
        ezik.setItems(eziK);
        
        ObservableList<String> janR =
        FXCollections.observableArrayList("Поема","Елегия","Повест","Роман","Стихотворение","Ода","Фантастика","Друг");
        janr.setItems(janR);
    }    
    @FXML
    private void SaveButtonEvent(ActionEvent event) {                   
        String a = zaglavie.getText();
        String b = avtor.getText();
        String c = godina.getText();
        String d=signatura.getSelectionModel().getSelectedItem();
        String e=ezik.getSelectionModel().getSelectedItem();
        String f=janr.getSelectionModel().getSelectedItem();
        boolean D = (signatura.getValue() == null);
        boolean E = (signatura.getValue() == null);
        boolean F = (signatura.getValue() == null);  
        ReadWrite file = new ReadWrite();   
        if(a.equals("")||b.equals("")||c.equals("")||D==true||E==true||F==true)
        {JOptionPane.showMessageDialog(null,"Моля попълнете всички данни!");}
        else{file.writeKnigaToFile(new String[]{a,d,b,e,f,c});
        zaglavie.setText("");
        avtor.setText("");
        godina.setText("");
        signatura.getSelectionModel().clearSelection();
        ezik.getSelectionModel().clearSelection();
        janr.getSelectionModel().clearSelection();
        JOptionPane.showMessageDialog(null,"Успех!");}  
    }
    @FXML
    private void CancelButtonEvent(ActionEvent event) {
        zaglavie.setText("");
        avtor.setText("");
        godina.setText("");
        signatura.getSelectionModel().clearSelection();
        ezik.getSelectionModel().clearSelection();
        janr.getSelectionModel().clearSelection();
    }  
}
