package my.todo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.todo.app.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
