package by.epam.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleParser {
    private final Pattern trianglePattern = Pattern.compile("(\\d+\\s|\\$){7}");

    public List<Double> parse(String triangleData){
        Matcher matcher = trianglePattern.matcher(triangleData);
        List<Double> values = new ArrayList<>();
        if(matcher.matches()){
            String[] valuesArray = triangleData.split(" ");
            for (String value: valuesArray){
                values.add(Double.parseDouble(value));
            }
        }
        return values;
    }

}
