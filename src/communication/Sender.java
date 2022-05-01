/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LORA
 */
public class Sender {
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }
    public void send(Object object) throws Exception {
        try {
            ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeObject(object);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object: "+ex.getMessage());
            
        }
    }
}
