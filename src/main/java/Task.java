public class Task {
    private String description;
    private int taskId;

    public Task(String description, int taskId) {
        this.description = description;
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }
}
