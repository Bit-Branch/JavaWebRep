package by.epam.committiee.security;

import java.security.SecureRandom;

public class SaltGenerator {
    private static final int KEY_LENGTH = 256;

    public byte[] generate() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[KEY_LENGTH/8];
        random.nextBytes(salt);
        return salt;
    }
}
