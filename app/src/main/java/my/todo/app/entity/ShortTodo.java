package my.todo.app.entity;

import java.sql.Timestamp;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import my.todo.app.enums.TodoStatus;

@Entity
@DiscriminatorValue("1")
public class ShortTodo extends Todo {

    private Timestamp time;
 
    ShortTodo() {
        super();
    }

    public ShortTodo(String title, String description, TodoStatus status, Timestamp time) {
        super(title, description, status);
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
