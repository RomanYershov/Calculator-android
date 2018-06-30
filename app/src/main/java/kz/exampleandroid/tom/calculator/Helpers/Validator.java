package kz.exampleandroid.tom.calculator.Helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.exampleandroid.tom.calculator.abstraction.IValidator;
import kz.exampleandroid.tom.calculator.abstraction.OperatorBase;
import kz.exampleandroid.tom.calculator.models.Addition;
import kz.exampleandroid.tom.calculator.models.Division;
import kz.exampleandroid.tom.calculator.models.Multiplication;
import kz.exampleandroid.tom.calculator.models.SimpleCalculator;
import kz.exampleandroid.tom.calculator.models.Substraction;

public class Validator implements IValidator {
    private static final String PATTERN = "^(\\s+)?[\\-\\+]?(\\s+)?\\d+([\\.\\,]\\d+)?(\\s+)?[\\-\\+\\*\\/]" +
            "(\\s+)?[\\-]?(\\s+)?\\d+([\\.\\,]\\d+)?";



    private String getOperator(String string) {
        Pattern pattern = Pattern.compile("(?<!^)[\\+\\-\\*\\/]");
        Matcher result = pattern.matcher(string);
        String res = "";
        while (result.find())
            res = result.group();
        return res;
    }

    private String getValidString(String string) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher result = pattern.matcher(string);
        String res = "";
        while (result.find())
            res = result.group(0);
        return res;
    }

    @Override
    public boolean isValidString(String string) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher result = pattern.matcher(string);
        return result.find();
    }

    @Override
    public  String getNextString(String str, double buffer){
        String validString = getValidString(str);
        String nextString = str.replace(validString, Double.toString(buffer));
        return nextString;
    }

    @Override
    public OperatorBase getOperation(String str, double buffer) {
        OperatorBase operation = null;
        String validString = getValidString(str);
        String operator = getOperator(validString);
        String[] arrX_Y = validString.split("["+operator+"]");
        double X = Double.parseDouble(arrX_Y[0]);
        double Y = Double.parseDouble(arrX_Y[1]);
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
