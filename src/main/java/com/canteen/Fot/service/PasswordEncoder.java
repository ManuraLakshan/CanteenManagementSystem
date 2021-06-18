package com.canteen.Fot.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//this class for my unit testing password encryption and decryption
public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "manura123";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}
