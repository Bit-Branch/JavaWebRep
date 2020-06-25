package by.epam.committiee.security;

import by.epam.committiee.exception.HasherException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Hasher {
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 1000;
    private static final int KEY_LENGTH = 256;

    public byte[] hash(String password, byte[] salt) throws HasherException {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt,
                    ITERATIONS, KEY_LENGTH);

            SecretKeyFactory fact = SecretKeyFactory.getInstance(ALGORITHM);

            return fact.generateSecret(spec).getEncoded();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new HasherException("Couldn't produce hash: " + e.getMessage());
        }
    }

}