package kz.exampleandroid.tom.calculator;

import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kz.exampleandroid.tom.calculator.models.SimpleCalculator;

public class MainActivity extends AppCompatActivity {
    private static String STRING = "";
    private static final SimpleCalculator calculator = new SimpleCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Operation(View view) {
        TextView textViewOp = findViewById(R.id.ma_op_tv);
        TextView textViewResult = findViewById(R.id.ma_result_tv);
        CharSequence text = ((Button) view).getText();
        STRING += text.toString();
        calculator.calculate(STRING);
        double result = calculator.get_buffer();
        textViewOp.setText(STRING);
        textViewResult.setText(Double.toString(result));
    }
}
