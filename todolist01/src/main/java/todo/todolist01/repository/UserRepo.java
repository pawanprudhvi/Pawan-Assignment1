package todo.todolist01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.todolist01.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	public Optional<User> findByUserName(String username);
}
