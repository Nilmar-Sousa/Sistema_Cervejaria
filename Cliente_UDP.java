package cliente_udp;

/**
 *
 * @author Leonardo
 */
import java.net.*;
import java.io.*;

public class Cliente_UDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence;
        System.out.println("Insira um nome");
        
        while(true){
            sentence = inFormUser.readLine();
            sendData = sentence.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, 9870);
            clientSocket.send(sendPacket);;
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVE: "+modifiedSentence);
            if(sentence.equals("fim"));
            {clientSocket.close(); break;}
        }
        
    }
    
}
