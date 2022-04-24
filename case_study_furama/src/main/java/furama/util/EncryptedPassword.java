package furama.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPassword {


    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = "123";
       String passEncoded = encoder.encode(pass);
// $2a$10$6u1kNPSIvdd0wOG3Cf.ieeKhWxBp3DutPatCDaKcDTvY8La6rN.J.
        System.out.println(passEncoded);
    }
}
