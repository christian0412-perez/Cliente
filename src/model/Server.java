package model;

import javafx.beans.InvalidationListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Server extends Observable implements Runnable{
    private int port;
    public Server(int port){
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;

        try{
            servidor = new ServerSocket(port);
            System.out.println("toy on");
            DataInputStream in;

            while(true){

                sc = servidor.accept();
                System.out.println("cliente conectado");
                in = new DataInputStream(sc.getInputStream());

                //se lee lo que el cliente envia
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();


                //se cierra el socket
                sc.close();
                System.out.println("cliente desconectado");

            }
        }catch (IOException ex){

        }

    }

}
