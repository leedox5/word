package kr.leedox.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User update(UserRequest req) {
        Optional<User> user = userRepository.findById(req.getId());
        if(user.isPresent()) {
            User userRepo = user.get();
            userRepo.setName(req.getName());
            return userRepository.save(userRepo);
        } else {
            return null;
        }
    }
}
