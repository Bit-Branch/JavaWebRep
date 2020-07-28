package by.epam.committiee.security;

import by.epam.committiee.exception.HasherException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AccountValidatorTest {

    private static String login = "use";
    private static  String password = "Passw8337";

    @Test
    public void accountValidateTest() throws HasherException {
        Assert.assertTrue(new AccountValidator().validate(login,password));
    }

}
