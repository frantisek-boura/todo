package my.todo.app.entity;

import java.sql.Timestamp;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import my.todo.app.enums.TodoStatus;

@Entity
@DiscriminatorValue("2")
public class LongTodo extends Todo {

    private Timestamp timeFrom;

    private Timestamp timeTo;

    LongTodo() {
        super();
    }

    public LongTodo(String title, String description, TodoStatus status, Timestamp timeFrom, Timestamp timeTo) {
        super(title, description, status);
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public Timestamp getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Timestamp timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Timestamp getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Timestamp timeTo) {
        this.timeTo = timeTo;
    }
    
}
