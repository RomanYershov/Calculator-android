package kz.exampleandroid.tom.calculator.models;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kz.exampleandroid.tom.calculator.Helpers.Validator;

public class Test {
    public static void main(String[] args) {
       /* SimpleCalculator calculator = new SimpleCalculator(new Validator());
        calculator.calculate("6/77");
        System.out.println(new DecimalFormat("###.####").format(calculator.getBuffer()));*/

        String str = "12*6.4";
        System.out.println(str.charAt(str.length()-1));
        System.out.println(str.substring(0, str.length() - 1));



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
