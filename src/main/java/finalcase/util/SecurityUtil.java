package finalcase.util;

import finalcase.constant.UserResultMessages;
import finalcase.exception.NotFoundException;
import finalcase.model.User;
import java.util.Objects;
import java.util.Optional;

import finalcase.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
public class SecurityUtil {

    private final UserRepository userRepository;

    public SecurityUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.nonNull(authentication)) {
            final String userName = authentication.getName();
            final Optional<User> currentUser = userRepository.findByUsername(userName);

            if (currentUser.isPresent()) {
                return currentUser.get();
            }
        }

        throw new NotFoundException(UserResultMessages.USER_NOT_FOUND);
    }

}
