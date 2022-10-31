package application.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserEntity createNewUser(UserDto userDto) throws UserAlreadyExistsException {
        UserEntity existingUser = repository.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            throw new UserAlreadyExistsException(
                            "A user with that email address already exists.");
        }
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        user.setEnabled(true);
        user.setAuthority("ROLE_USER");

        return repository.save(user);
    }

    public UserEntity get(String email) {
        return repository.findByEmail(email);
    }

}
