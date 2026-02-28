package Ashley;

/**
 * Represents a task with a specific deadline.
 * A <code>Deadline</code> object contains a description and a date/time string indicating the deadline of the task.
 */
public class Deadline extends Task {
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
