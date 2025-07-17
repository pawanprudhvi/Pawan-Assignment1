package todo.todolist01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.todolist01.entity.User;
import todo.todolist01.entity.todo;

import java.util.List;

@Repository
public interface todoRepository extends JpaRepository<todo,Long> {
    public List<todo> findByUser(User user);
    public   List<todo> findByUserUserId(Long userId);
}

