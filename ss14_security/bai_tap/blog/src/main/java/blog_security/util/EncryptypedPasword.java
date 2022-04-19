package blog_security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptypedPasword {

    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123456";
//        $2a$10$TPboposyptBZPE9SfA5Dm.G2XU6jS6vUh0EGYvGRi.mtQun4KsyWu
        String encrytedPassword = encrytePassword(password);
        System.out.println("Encryted Password: " + encrytedPassword);
    }
}
