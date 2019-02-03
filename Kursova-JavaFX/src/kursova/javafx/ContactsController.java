package kursova.javafx;

import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Turimatsov
 */
public class ContactsController implements Initializable {
    @FXML
    private Button button;
    @FXML
    private TextField ime;
    @FXML
    private TextField familiq;
    @FXML
    private TextField telefon;
    @FXML
    private TextField email;
    @FXML
    private TextArea pole;
    @FXML
    private ImageView image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public static boolean isValidEmailAddress(TextField email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email.getText());
      emailAddr.validate();} catch (AddressException ex) {
      result = false;} return result;}
    @FXML
    private void SendEvent(ActionEvent event) {
     if(!ime.getText().equals("")&&!familiq.getText().equals("")
             &&((telefon.getText().length()==10)&&(
             (telefon.getText().startsWith("088"))||
             (telefon.getText().startsWith("089"))||
             (telefon.getText().startsWith("087"))))
             &&(isValidEmailAddress(email)==true)){
        
         try{
            String host ="smtp.gmail.com" ;
            String user = "emailzakursova@gmail.com";
            String pass = "antoniyan96";
            String to = "roncho0o28@gmail.com";
            String from = "emailzakursova@gmail.com";
            String subject = "Съобщение от Форма за контакт!";     
            String messageText = "Име: "+ime.getText()+"\nФамилия: "+familiq.getText()+
            "\nТелефон: "+telefon.getText()+"\nИмейл на подателя: "+email.getText()+
                    "\nСъобщение:\n"+pole.getText();           
            boolean sessionDebug = false;
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           ime.setText("");
           familiq.setText("");
           telefon.setText("");
           email.setText("");
           pole.setText("");
           JOptionPane.showMessageDialog(null, "Съобщението е изпратено успешно!");
        }catch(Exception ex) {System.out.println(ex);}
    }else{JOptionPane.showMessageDialog(null, "Моля попълнете правилно всички полета!");}
    } 
}