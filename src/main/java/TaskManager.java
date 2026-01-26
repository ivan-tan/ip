public class TaskManager {
    private Task[] tasks = new Task[100];
    private static int taskCount = 0;

    public void addTask(String taskDescription) {
        tasks[taskCount] = new Task(taskDescription, taskCount + 1); //the ID starts with 1
        taskCount++;
    }
    public void listTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(tasks[i].getTaskId() + ": " + tasks[i].getDescription());
        }
    }

}
