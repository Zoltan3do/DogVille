package manu_barone.DogVille.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCrypt {

    BCryptPasswordEncoder getBCrypt() {
        return new BCryptPasswordEncoder(12);
    }

}
