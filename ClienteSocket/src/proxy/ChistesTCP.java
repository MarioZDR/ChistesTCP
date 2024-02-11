/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxy;

import clientesocket.ClienteSocket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChistesTCP implements IChistesTCP{

    @Override
    public void conectar() {
        try (
            Socket kkSocket = new Socket("localhost", 4444);
            DataOutputStream out = new DataOutputStream(kkSocket.getOutputStream());
            DataInputStream in = new DataInputStream(kkSocket.getInputStream());
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));  
            )
            {
            String fromServer;
            String fromUser;
            while ((fromServer = in.readUTF()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;
                
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.writeUTF(fromUser);
                }
            }      
        } catch (IOException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
