package TaskManagement.src.Task;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl extends UnicastRemoteObject implements TaskService {

    private List<String> tasks;

    protected TaskServiceImpl() throws RemoteException {
        super();
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(String task) throws RemoteException {
        if (!tasks.contains(task)) {
            tasks.add(task);
        } else {
            System.out.println("La tâche existe déjà dans la liste.");}}

    @Override

    public void removeTask(String task) throws RemoteException {
        if (tasks.contains(task)) {
            tasks.remove(task);
        } else {
            System.out.println("La tâche n'existe pas dans la liste.");}
    }

    @Override
    public List<String> getTasks() throws RemoteException {
        return new ArrayList<>(tasks);
    }
}