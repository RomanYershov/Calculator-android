package kz.exampleandroid.tom.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import kz.exampleandroid.tom.calculator.Helpers.Validator;
import kz.exampleandroid.tom.calculator.models.SimpleCalculator;

public class MainActivity extends AppCompatActivity {
    private static String inputString = "";
    private static SimpleCalculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new SimpleCalculator(new Validator());

        final Button btnDel = findViewById(R.id.ma_delete_btnDel);
        Button btnClear = findViewById(R.id.ma_clear_btnClear);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputString.substring(0, inputString.length() - 1);
                TextView textViewOp = findViewById(R.id.ma_op_tv);
                TextView textViewResult = findViewById(R.id.ma_result_tv);
                calculator.calculate(inputString);
                double result = calculator.getBuffer();
                textViewOp.setText(inputString);
                textViewResult.setText(new DecimalFormat("###.####").format(result));
            }
        });
    }


    public void Operation(View view) {
        TextView textViewOp = findViewById(R.id.ma_op_tv);
        TextView textViewResult = findViewById(R.id.ma_result_tv);
        CharSequence text = ((Button) view).getText();
        inputString += text.toString();
        calculator.calculate(inputString);
        double result = calculator.getBuffer();
        textViewOp.setText(inputString);
        textViewResult.setText(new DecimalFormat("###.####").format(result));
    }


}
