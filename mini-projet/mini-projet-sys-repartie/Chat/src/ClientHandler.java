import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Server Server;
    private Socket connectionToClient;

    private String name;

    private BufferedReader fromClientReader;
    private PrintWriter toClientWriter;

    public ClientHandler(Server Server, Socket connectionToClient,String name) {
        this.Server = Server;
        this.connectionToClient = connectionToClient;

        this.name=name;

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            fromClientReader = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));
            toClientWriter = new PrintWriter(new OutputStreamWriter(connectionToClient.getOutputStream()));

            Server.broadcastMessage(name + " connected.");

            String message = fromClientReader.readLine();
            while (message != null) {
                Server.broadcastMessage(name + ": " + message);
                message = fromClientReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Server.removeClient(this);
            Server.broadcastMessage(name + " disconnected.");

            if (fromClientReader != null) {
                try {
                    fromClientReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (toClientWriter != null) {
                toClientWriter.close();
            }
        }
    }

    public void sendMessage(String message) {
        toClientWriter.println(message);
        toClientWriter.flush();
    }
}
