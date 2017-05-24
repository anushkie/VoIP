import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by balaji on 5/24/2017.
 */
public class Client implements Runnable {

    private final int port;

    public Client(int port) {
        this.port = port;
    }

    public void run() {

        try {
            DatagramSocket clientSocket = new DatagramSocket(port);
            byte[] buffer = new byte[65507];
            while(true) {
                DatagramPacket datagramPacket = new DatagramPacket(buffer, 0 , buffer.length);
                clientSocket.receive(datagramPacket);

                String recieveData = new String(datagramPacket.getData());
                System.out.println(recieveData);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
