package finalcase.service;

import finalcase.constant.UserResultMessages;
import finalcase.exception.UserNotFoundException;
import finalcase.model.User;
import finalcase.model.enums.RoleType;
import finalcase.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = getUserByUsername(username);
        final SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRoleType().getRoleName());
        final List<SimpleGrantedAuthority> authorities = List.of(authority);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    private User getUserByUsername(final String username){
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UserNotFoundException(UserResultMessages.USER_NOT_FOUND));
    }
}