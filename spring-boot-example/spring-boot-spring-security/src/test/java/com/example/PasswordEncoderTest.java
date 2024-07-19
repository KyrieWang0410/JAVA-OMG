package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Objects;

@SpringBootTest
public class PasswordEncoderTest {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 测试BCryptPasswordEncoder加密
     */
    @Test
    public void testBCryptPasswordEncoder() {
        boolean aNull = Objects.isNull(authenticationManager);
        System.out.println("======="+aNull);

        // $2a$10$FZo793oe/Ftlki1MnlBfMOcaf6optaOLBXEw5tGV82JtIlqTMc/Bi
        // $2a$10$Rn3ldalLTdY.zvF9Bs2qg.VzBJ6qsYFuK8Q4wRbmGiU4TIJGFNdBu
        System.out.println(passwordEncoder.encode("123"));
        System.out.println(passwordEncoder.matches("123", "$2a$10$FZo793oe/Ftlki1MnlBfMOcaf6optaOLBXEw5tGV82JtIlqTMc/Bi"));
    }


}
