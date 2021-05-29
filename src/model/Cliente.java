package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente implements Runnable{
    private int puerto;
    private String mensaje;
    private String host;
    public Cliente(int puerto, String mensaje, String host){
        this.puerto=puerto;
        this.mensaje = mensaje;
        this.host = host;


    }
    @Override
    public void run() {
        final String HOST = "127.0.0.1";
        DataOutputStream out;
        try {

            Socket sc = new Socket(host, puerto);

            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(mensaje);

            sc.close();


        }catch (IOException ex){

        }
    }
}
