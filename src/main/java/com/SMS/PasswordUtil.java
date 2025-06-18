package com.SMS;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    public static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert byte array into hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();  // This is the hashed password
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
