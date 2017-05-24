import java.io.IOException;
import java.net.*;

/**
 * Created by balaji on 5/23/2017.
 */
public class Server implements Runnable {

    private final int clientPort;

    public Server(int clientPort) {
        this.clientPort = clientPort;
    }

    public void run() {

        try {
            DatagramSocket serverSocket = new DatagramSocket(50);
            for(int i = 0; i < 3; i++) {
                String message = "message no :" + i;

                DatagramPacket datagramPacket = new DatagramPacket(
                        message.getBytes(),
                            message.length(),
                                InetAddress.getLocalHost(),
                                    clientPort
                );
                serverSocket.send(datagramPacket);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}