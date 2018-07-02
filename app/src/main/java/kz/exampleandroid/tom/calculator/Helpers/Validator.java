package kz.exampleandroid.tom.calculator.Helpers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.exampleandroid.tom.calculator.abstraction.IValidator;
import kz.exampleandroid.tom.calculator.abstraction.OperatorBase;
import kz.exampleandroid.tom.calculator.models.Addition;
import kz.exampleandroid.tom.calculator.models.Division;
import kz.exampleandroid.tom.calculator.models.Multiplication;
import kz.exampleandroid.tom.calculator.models.Substraction;

public class Validator implements IValidator {
    private static final String VALID_STRING_PATTERN = "^(\\s+)?[\\-\\+]?(\\s+)?\\d+([\\.\\,]\\d+)?(\\s+)?[\\-\\+\\*\\/]" +
            "(\\s+)?[\\-]?(\\s+)?\\d+([\\.\\,]\\d+)?";

    private static final String SPLIT_VALID_STRING_PATTERN = "(^[\\+\\-]?\\d*(\\.)?\\d*)|(?<=\\d[\\+\\-\\*\\/])" +
            "([\\-\\+]?\\d+(\\.)?\\d*)|[\\-\\+\\*\\/]";


    private String getOperator(String string) {
        Pattern pattern = Pattern.compile("(?<!^)[\\+\\-\\*\\/]");
        Matcher result = pattern.matcher(string);
        StringBuilder stringBuilder = new StringBuilder(3);
        while (result.find()) {
            stringBuilder.append(result.group());
        }
        return stringBuilder.substring(0, 1);
    }

    private String getValidString(String string) {
        Pattern pattern = Pattern.compile(VALID_STRING_PATTERN);
        Matcher matcher = pattern.matcher(string);
        String validString = "";
        while (matcher.find())
            validString = matcher.group(0);
        return validString;
    }

    private ArrayList<String> getResArr(String validString) {
        Pattern pattern = Pattern.compile(SPLIT_VALID_STRING_PATTERN);
        Matcher result = pattern.matcher(validString);
        ArrayList<String> resArr = new ArrayList<>();
        while (result.find())
            resArr.add(result.group());
        return resArr;
    }

    @Override
    public boolean isValidString(String string) {
        Pattern pattern = Pattern.compile(VALID_STRING_PATTERN);
        Matcher result = pattern.matcher(string);
        return result.find();
    }

    @Override
    public String getNextString(String str, double buffer) {
        String validString = getValidString(str);
        String nextString = str.replace(validString, Double.toString(buffer));
        return nextString;
    }

    @Override
    public OperatorBase getOperation(String str, double buffer) {
        OperatorBase operation = null;
        ArrayList<String> arrX_Y = getResArr(getValidString(str));
        double X = Double.parseDouble(arrX_Y.get(0));
        double Y = Double.parseDouble(arrX_Y.get(2));
        String operator = arrX_Y.get(1);
        switch (operator) {
            case "+":
                operation = new Addition(X, Y);
                break;
            case "-":
                operation = new Substraction(X, Y);
                break;
            case "*":
                operation = new Multiplication(X, Y);
                break;
            case "/":
                operation = new Division(X, Y);
                break;
        }
        return operation;
    }
}
