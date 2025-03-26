package my.todo.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.todo.app.entity.LongTodo;
import my.todo.app.entity.ShortTodo;
import my.todo.app.entity.Todo;
import my.todo.app.exceptions.TodoNotFoundException;
import my.todo.app.repository.TodoRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/todo")
public class TodoController {
    
    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Todo> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}") 
    public Todo one(@RequestParam Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping("")
    public Todo create(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo edit(@PathVariable Long id, @RequestBody Todo editedTodo) {
        return repository.findById(id)
            .map(todo -> {
                todo.setTitle(editedTodo.getTitle());
                todo.setDescription(editedTodo.getDescription());
                todo.setStatus(editedTodo.getStatus());
                if (todo instanceof ShortTodo shortTodo) {
                    ((ShortTodo) todo).setTime(((ShortTodo) editedTodo).getTime());
                } else if (todo instanceof LongTodo longTodo) {
                    ((LongTodo) todo).setTimeFrom(((LongTodo) editedTodo).getTimeFrom());
                    ((LongTodo) todo).setTimeTo(((LongTodo) editedTodo).getTimeTo());
                }
                return repository.save(todo);
            })
            .orElseGet(() -> {
                return repository.save(editedTodo);
            });
    }
    
    



}
