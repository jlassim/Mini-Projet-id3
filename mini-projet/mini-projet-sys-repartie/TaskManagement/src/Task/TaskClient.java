package TaskManagement.src.Task;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class TaskClient {

    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:1000/TaskService";
            Task.TaskService taskService = (Task.TaskService) Naming.lookup(url);
            Scanner scanner =new Scanner(System.in);
            while(true) {
                String Task = scanner.nextLine();
                if (Task.equals("no more Task"))
                    break;
                taskService.addTask(Task);
            }

            List<String> tasks = taskService.getTasks();
            System.out.println("Liste des tâches :");
            for (String task : tasks) {
                System.out.println("- " + task);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'accès au service RMI: " + e.getMessage());
        }
    }
}
