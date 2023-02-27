package finalcase;

import finalcase.model.User;
import finalcase.model.enums.RoleType;
import finalcase.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FinalcaseApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public FinalcaseApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalcaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFirstName("MURAT");
		user.setFirstName("Yapici");
		user.setUsername("murat");
		user.setPassword(passwordEncoder.encode("123"));
		user.setRoleType(RoleType.ADMIN);

		userRepository.save(user);
	}
}
