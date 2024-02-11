/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KnockKnockClientManager implements Runnable {

    private Socket clientSocket;
    private KnockKnockProtocol kkp;

    public KnockKnockClientManager(Socket c) {
        this.clientSocket = c;
        this.kkp = new KnockKnockProtocol();
    }

    @Override
    public void run() {
        try (
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream()); 
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());) 
        {
            String inputLine, outputLine;
            outputLine = kkp.processInput(null);
            out.writeUTF(outputLine);
            while ((inputLine = in.readUTF()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.writeUTF(outputLine);
                if (outputLine.equals("Bye.")) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println("Salio un cliente");
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(KnockKnockClientManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
