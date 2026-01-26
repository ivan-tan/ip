public class TaskManager {
    private Task[] tasks = new Task[100];
    private static int taskCount = 0;

    public void addTask(String taskDescription) {
        tasks[taskCount] = new Task(taskDescription, taskCount + 1); //the ID starts with 1
        taskCount++;
    }

    public void listTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(tasks[i].getTaskId() + ":" + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
        }
    }

    public void markAsDone(int taskId) {
        tasks[taskId - 1].markAsDone(); //tasks array starts from 0 while task ID starts with 1
    }

    public void markasNotDone(int taskId) {
        tasks[taskId - 1].markAsNotDone();
    }

    public String getTaskDescription(int taskId) {
        return tasks[taskId - 1].getDescription();
    }

}
