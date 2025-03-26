package my.todo.app.exceptions;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(Long id) {
        super(String.format("Todo with id %d not found", id));
    }
    
}
