package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired private UserRepository repo;
	
	public User add(User user) {
		return repo.save(user);
	}
	
	 public User update(User user) {
	        if (user.getId() == null) {
	            throw new IllegalArgumentException("The given id must not be null");
	        }
	        return repo.save(user);
	    }
	

	
	public User get(Long id) throws UserNotFoundException {
		Optional<User> result = repo.findById(id);
		
		if (result.isPresent()) {
			return result.get();
		}
		
		throw new UserNotFoundException();
	}
	
	public List<User> list() {
		return (List<User>) repo.findAll();
	}
	
	public void delete(Long id) throws UserNotFoundException {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
		
		throw new UserNotFoundException(); 
	}
}
