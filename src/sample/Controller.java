package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Server;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Controller  implements Observer {
    public Controller(){
        Server s = new Server(6000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    @FXML
    private TextArea textAreamensajes;

    @FXML
    private TextField textFieldMensaje;

    @FXML
    private Button buttonSend;
    @FXML
    private Button venata;

    @FXML
    void onSendClicked(MouseEvent event) {

        String mensaje = "tu: "+ this.textFieldMensaje.getText()+"\n";
        this.textAreamensajes.appendText(mensaje);

        Cliente c = new Cliente(5000, mensaje,"192.168.0.19");
        Thread  t = new Thread(c);
        t.start();
    }

    @Override
    public void update(Observable o, Object arg) {

        this.textAreamensajes.appendText((String) arg);
    }

}