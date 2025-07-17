package todo.todolist01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.todolist01.entity.User;
import todo.todolist01.entity.todo;
import todo.todolist01.repository.UserRepo;
import todo.todolist01.repository.todoRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class todoController {

	@Autowired
	UserRepo userRepo;

	@Autowired
	todoRepository todoRepo;

	@PostMapping("/newUser")
	public ResponseEntity<?> createUser(@RequestBody User user){
		if(userRepo.findByUserName(user.getUserName()).isPresent()) {
			return ResponseEntity.status(200).body("User name already exists");
		}
		userRepo.save(user);
		return ResponseEntity.status(200).body(user);
	}

	@PostMapping("/{username}")
	public ResponseEntity<?> addTodo(@PathVariable String username,@RequestBody todo todoItem) {
		User user = userRepo.findByUserName(username)
				.orElseThrow(() -> new RuntimeException("User not found"));
		todoItem.setUser(user);
		todo todowork = todoRepo.save(todoItem);
		return ResponseEntity.ok(todoItem);
	}
	@GetMapping("/users/{userId}/todos")
	public ResponseEntity<?> getTodos(@PathVariable Long userId) {
		if (!userRepo.existsById(userId)) {
			return ResponseEntity.badRequest().body("User not found");
		}
		List<todo> todos = todoRepo.findByUserUserId(userId);
		return ResponseEntity.ok(todos);
	}

	// Delete todo by id
	@DeleteMapping("/todos/{todoId}")
	public ResponseEntity<?> deleteTodo(@PathVariable Long todoId) {
		if (!todoRepo.existsById(todoId)) {
			return ResponseEntity.badRequest().body("Todo not found");
		}
		todoRepo.deleteById(todoId);
		return ResponseEntity.ok("todo deleted:\n id: "+todoId);
	}

	@PutMapping("/todos/{todoId}")
	public Optional<ResponseEntity<todo>> updateTodo(@PathVariable Long todoId, @RequestBody todo updatedTodo) {
		return todoRepo.findById(todoId).map(todo->{todo.setTodo(updatedTodo.getTodo());
					                         todoRepo.save(todo);
											 return ResponseEntity.ok(todo);
		                                     });
	}
}
