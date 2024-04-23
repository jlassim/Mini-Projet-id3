package TaskManagement.src.Task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TaskServer {

    public static void main(String[] args) {
        try {
            Task.TaskService taskService = new Task.TaskServiceImpl();
            int port = 1000;
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind("TaskService", taskService);
            System.out.println("Serveur RMI démarré sur le port " + port);
        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage du serveur RMI: " + e.getMessage());
        }
    }
}