package by.epam.committiee.security;

import by.epam.committiee.exception.HasherException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class HasherTest {

    @Test
    public void hashTestEquals() throws HasherException {
        Hasher hasher = new Hasher();
        String password = "p";
        byte[] salt = new byte[] { 1 };
        byte[] s1 = hasher.hash(password, salt);
        byte[] s2 = hasher.hash(password, salt);

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