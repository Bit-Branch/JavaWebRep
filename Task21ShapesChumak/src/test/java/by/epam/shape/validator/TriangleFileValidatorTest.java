package by.epam.shape.validator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleFileValidatorTest {
    private TriangleFileValidator triangleFileValidator = new TriangleFileValidator();
    private List<String> content = new ArrayList<>();
    private List<String> expectedContent = new ArrayList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        content.add("1 0 0 0 1 1 0");
        content.add("2 0 0 0 2 2 0");
        content.add("3 1 1 1 2 3 3");
        content.add("");
        content.add("4 0 0 1 1 4 4");
        content.add("5 08 28 8 8 8");
        content.add("6 8ad 2 2 4 5");
        content.add("7 1 1 0 0 0 0");

        expectedContent.add("1 0 0 0 1 1 0");
        expectedContent.add("2 0 0 0 2 2 0");
        expectedContent.add("3 1 1 1 2 3 3");
        expectedContent.add("4 0 0 1 1 4 4");
    }

    @Test
    public void testValidate() throws Exception {
        List<String> validatedContent = triangleFileValidator.validate(content);
        Assert.assertEquals(validatedContent, expectedContent);
    }
}
