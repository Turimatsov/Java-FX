package kursova.javafx;

import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Turimatsov
 */
public class ListShowController implements Initializable {

    @FXML
    private TableView<BooksClass> tablica;
    @FXML
    private TableColumn<BooksClass,String> zaglavie;
    @FXML
    private TableColumn<BooksClass,String> signatura;
    @FXML
    private TableColumn<BooksClass,String> avtor;
    @FXML
    private TableColumn<BooksClass,String> ezik;
    @FXML
    private TableColumn<BooksClass,String> janr;
    @FXML
    private TableColumn<BooksClass,String> godina;
    @FXML
    private Button delete;
    @FXML
    private Button save;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private ComboBox<String> sign;
    @FXML
    private Button butonchi;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> eziK =
        FXCollections.observableArrayList("Български","Английски","Друг");
        combo.setItems(eziK);
        ObservableList<String> signat =
        FXCollections.observableArrayList("Учебник","Творба","Документ","Автобиография");
        sign.setItems(signat);
        
        
    ReadWrite file = new ReadWrite();
    ObservableList<String> data = FXCollections.observableArrayList();
    data = file.readKnigaFromFile();
    tablica.setEditable(true);
    
    zaglavie.setCellValueFactory(new PropertyValueFactory<>("name"));
    signatura.setCellValueFactory(new PropertyValueFactory<>("signature"));
    avtor.setCellValueFactory(new PropertyValueFactory<>("author"));
    ezik.setCellValueFactory(new PropertyValueFactory<>("language"));
    janr.setCellValueFactory(new PropertyValueFactory<>("janr"));
    godina.setCellValueFactory(new PropertyValueFactory<>("year"));
        
    zaglavie.setCellFactory(TextFieldTableCell.forTableColumn());
    signatura.setCellFactory(TextFieldTableCell.forTableColumn());
    avtor.setCellFactory(TextFieldTableCell.forTableColumn());
    ezik.setCellFactory(TextFieldTableCell.forTableColumn());
    janr.setCellFactory(TextFieldTableCell.forTableColumn());
    godina.setCellFactory(TextFieldTableCell.forTableColumn());
    
    for(int i = 0; i < data.size(); i++){
            String[] line = data.get(i).split(":");
            BooksClass kniga = new BooksClass(
            line[0], line[1], line[2], line[3], line[4], line[5]);
            tablica.getItems().add(kniga);
             
    }
    }

    public void nameEdit(TableColumn.CellEditEvent<BooksClass, String> event) {
        BooksClass bs = tablica.getSelectionModel().getSelectedItem();
        bs.setName(event.getNewValue());
    }
    public void sigEdit(TableColumn.CellEditEvent<BooksClass, String> event) {
        BooksClass bs = tablica.getSelectionModel().getSelectedItem();
        bs.setSignature(event.getNewValue());
    }
    public void avtorEdit(TableColumn.CellEditEvent<BooksClass, String> event) {
        BooksClass bs = tablica.getSelectionModel().getSelectedItem();
        bs.setAuthor(event.getNewValue());
    }
    public void ezikEdit(TableColumn.CellEditEvent<BooksClass, String> event) {
        BooksClass bs = tablica.getSelectionModel().getSelectedItem();
        bs.setLanguage(event.getNewValue());
    }
    public void janrEdit(TableColumn.CellEditEvent<BooksClass, String> event) {
        BooksClass bs = tablica.getSelectionModel().getSelectedItem();
        bs.setJanr(event.getNewValue());
    }
    public void godinaEdit(TableColumn.CellEditEvent<BooksClass, String> event) {
        BooksClass bs = tablica.getSelectionModel().getSelectedItem();
        bs.setYear(event.getNewValue());
    }

    @FXML
    private void Delete(ActionEvent event) {
    tablica.getItems().remove(tablica.getSelectionModel().getSelectedItem());
    JOptionPane.showMessageDialog(null,"Изтрито!");
    }
   
    @FXML
    private void Save(ActionEvent event) {
    FileChooser myFile = new FileChooser();
        myFile.setInitialFileName("Knigi"+".txt");
        
        PrintWriter p = null;
        try
        {
            p= new PrintWriter(myFile.getInitialFileName());
            ObservableList<BooksClass> bs = tablica.getItems();
            
            for(BooksClass item: bs){
                String novZapis = item.getName()
                        + ":" + item.getSignature() 
                        + ":" + item.getAuthor()
                        + ":" + item.getLanguage()
                        + ":" + item.getJanr()
                        + ":" + item.getYear();
                p.write(novZapis);
                p.println();
            }
            p.close();
            JOptionPane.showMessageDialog(null,"Запазено!");
        }
        catch(Exception e)
        {
        System.exit(1);
        }
    }

    @FXML
    private void SelectedElement(ActionEvent event) {
     ReadWrite file = new ReadWrite();
    ObservableList<String> data = FXCollections.observableArrayList();
    data = file.readKnigaFromFile();
    tablica.getItems().clear();
        for(int i = 0; i < data.size(); i++){
            String[] line = data.get(i).split(":");
            BooksClass kniga = new BooksClass(
            line[0], line[1], line[2], line[3], line[4], line[5]);
            
            if(sign.getSelectionModel().getSelectedIndex()==-1){
            if(kniga.language.equals(combo.getSelectionModel().getSelectedItem()))
            {
            tablica.getItems().add(kniga);
                }}else if((kniga.language.equals(combo.getSelectionModel().
                        getSelectedItem()))&&kniga.signature.equals
        (sign.getSelectionModel().getSelectedItem())){
                tablica.getItems().add(kniga);}}}
    
    
    @FXML
    private void SelectedElement2(ActionEvent event) {
    ReadWrite file = new ReadWrite();
    ObservableList<String> data = FXCollections.observableArrayList();
    data = file.readKnigaFromFile();
    tablica.getItems().clear();
        for(int i = 0; i < data.size(); i++){
            String[] line = data.get(i).split(":");
            BooksClass kniga = new BooksClass(
            line[0], line[1], line[2], line[3], line[4], line[5]);
        if(combo.getSelectionModel().getSelectedIndex()==-1){
            if(kniga.signature.equals(sign.getSelectionModel().getSelectedItem()))
            {
                tablica.getItems().add(kniga);
                }}else if((kniga.language.equals(combo.getSelectionModel().getSelectedItem()))&&kniga.signature.equals(sign.getSelectionModel().getSelectedItem())){
                tablica.getItems().add(kniga);
                }}}

    @FXML
    private void sortiraneDelete(ActionEvent event) {
        combo.getSelectionModel().select(-1);
        sign.getSelectionModel().select(-1);
        ReadWrite file = new ReadWrite();
    ObservableList<String> data = FXCollections.observableArrayList();
    data = file.readKnigaFromFile();
    tablica.getItems().clear();
        for(int i = 0; i < data.size(); i++){
            String[] line = data.get(i).split(":");
            BooksClass kniga = new BooksClass(
            line[0], line[1], line[2], line[3], line[4], line[5]);
            tablica.getItems().add(kniga);}}

}

     
  
