public class Task {
    private String description;
    private int taskId;
    private boolean isDone;


    public Task(String description, int taskId) {
        this.description = description;
        this.taskId = taskId;
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }
}
