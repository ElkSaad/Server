/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.server;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author elkha
 */
public class ConnectionServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket server = null;
        Socket client;
        String stringaRicevuta;
        String risposta;
        BufferedReader inDalClient;
        DataOutputStream output;
        BufferedReader tastiera;
        try{
            System.out.println("Server partito...");
            server = new ServerSocket(3500);
            client = server.accept();
            server.close();
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new DataOutputStream(client.getOutputStream());
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            stringaRicevuta =  inDalClient.readLine();
            System.out.println("Il client ha mandato il seguente messaggio: "+ stringaRicevuta);
            risposta = tastiera.readLine();
            output.writeBytes(risposta);
            System.out.println("Il server ha mandato il seguente messaggio al client: " + risposta);
            client.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
    }
}
