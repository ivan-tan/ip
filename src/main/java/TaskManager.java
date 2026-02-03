public class TaskManager {
    private Task[] tasks = new Task[100];
    private static int taskId = 1;

    public void addTask(String taskDescription) {
        tasks[taskId] = new Task(taskDescription);
        taskId++;
    }

    public void listTasks() {
        for (int i = 1; i < taskId; i++) {
            System.out.println( i + ":" + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
        }
    }

    public void markAsDone(int taskId) {
        tasks[taskId].markAsDone();
    }

    public void markasNotDone(int taskId) {
        tasks[taskId].markAsNotDone();
    }

    public String getTaskDescription(int taskId) {
        return tasks[taskId].getDescription();
    }

}
