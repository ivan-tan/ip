package Ashley;

/**
 * Represents exceptions specific to the chatbot.
 * Handles and prints domain-specific errors like invalid commands and empty task descriptions.
 */
public class AshleyException extends RuntimeException {
    public AshleyException(String message) {
        super(message);
    }
}
