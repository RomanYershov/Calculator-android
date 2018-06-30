package kz.exampleandroid.tom.calculator.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.exampleandroid.tom.calculator.Helpers.Validator;

public class Test {
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.calculate("12*4.3*789");
        System.out.println(calculator.get_buffer());





      /*  String [] oper = "12+4.5".split("\\d+\\.?\\d+");
        String [] num = "12+4.5".split("\\+|\\-|\\*|\\/");
        System.out.println(num.length);
        for (String str: num
             ) {
            System.out.println(str.trim());
        }*/
        // String [] arrStr = "16+63".split("^(\\-\\d*\\.?\\d*|\\d*\\.?\\d*)(\\+|\\-|\\*|\\\\)(\\-\\d*\\.?\\d*|\\d*\\.?\\d*)");




       /* Pattern pattern = Pattern.compile("");
        Matcher result = pattern.matcher("12+490");
        while (result.find())
            System.out.println(result.group()+"\n");*/
    }
}
