package RegistrationMenu;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import PIB_RuotaDellaFortuna.Domain.User;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {
    @FXML
    TextField TFNome;
    @FXML
    TextField TFCognome;
    @FXML
    TextField TFUsername;
    @FXML
    PasswordField PBPassword;
    @FXML
    TextField TFEmail;
    @FXML
    ComboBox<String> CBDominioMail;
    @FXML
    Label lblAt;

    ObservableList<String> DomainsList= FXCollections.observableArrayList("gmail.com","outlook.com","libero.it","virgilio.it", "studenti.uninsubria");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CBDominioMail.setItems(DomainsList);
    }
    @FXML
    public User AddUser()
    {
        System.out.println("Inizio a salvare l'utente");
        User  newUser= new User();
        newUser.setNome(TFNome.getText());
        newUser.setCognome(TFCognome.getText());
        newUser.setUsername(TFUsername.getText());
        String str= TFEmail.getText()+lblAt.getText()+CBDominioMail.getValue();
        System.out.println(str);
        newUser.setEmail(str);

        try {

            FXMLLoader loader= new FXMLLoader(getClass().getResource("/Main/MainPageInterface.fxml"));
            AnchorPane root= loader.load();

            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new User();
    }
}
