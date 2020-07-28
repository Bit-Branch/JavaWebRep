package by.epam.committiee.security;

import by.epam.committiee.exception.HasherException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class HasherTest {

    private boolean compareHashes(byte[] hash1, byte[] hash2) {
     /*   boolean isEqual = hash1.length == hash2.length;
        for (int i = 0; i < hash1.length && i < hash2.length; i++) {
            isEqual &= hash1[i] == hash2[i];
        }
        return isEqual;*/
        int diff = hash1.length ^ hash2.length;
        for(int i = 0; i < hash1.length && i < hash2.length; i++)
        {
            diff |= hash1[i] ^ hash2[i];
        }
        return diff == 0;
    }

    @Test
    public void hashTestEquals() throws HasherException {
        String passw1 = "Passw8337";
        String passw2 = "Passw8337";
        Hasher hasher = new Hasher();

        byte[] salt = new SaltGenerator().generate();

        byte[] s1 = hasher.hash(passw1, salt);

        hasher = new Hasher();
        byte[] s2 = hasher.hash(passw2, salt);

        Assert.assertTrue(compareHashes(s1,s2));
        assertEquals(new String(s1), new String(s2));
    }

    @Test
    public void hashTestNotEquals() throws HasherException {
        Hasher hasher = new Hasher();
        String pass1 = "p";
        String pass2 = "c";
        byte[] salt = new byte[] { 1 };
        byte[] s1 = hasher.hash(pass1, salt);
        byte[] s2 = hasher.hash(pass2, salt);

        assertNotEquals(new String(s1), new String(s2));
    }

    @Test(timeOut=1000)
    public void testSpeed() throws HasherException {
        new Hasher().hash("P@ssw0rd", new SaltGenerator().generate());
    }

}