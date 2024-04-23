import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients;

    public Server(int port) {
        clients = new CopyOnWriteArrayList<>();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Started chat server on port " + port);

            while (true) {
                System.out.println("Waiting for new client...");
                Socket connectionToClient = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));
                String name = reader.readLine();
                ClientHandler client = new ClientHandler(this, connectionToClient,name);
                clients.add(client);
                System.out.println("Accepted new client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public void broadcastMessage(String message) {
        System.out.println(message);
        if (message != null) {
            for (ClientHandler client : clients) {
                client.sendMessage(message);
            }
        }
    }

    public static void main(String[] args) {
        new Server(3141);
    }}
