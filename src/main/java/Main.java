import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by balaji on 5/24/2017.
 */
public class Main {
    public static void main(String[] args) {

        int port = 5000;
        Server server = new Server(port);
        Client client = new Client(port);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(client);
        executorService.submit(server);
    }
}
