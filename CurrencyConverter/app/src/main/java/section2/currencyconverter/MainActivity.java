package section2.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view) {
        EditText dollarAmountEditText = (EditText) findViewById(R.id.dollarAmountEditText);

        Double dollarAmount = Double.parseDouble(dollarAmountEditText.getText().toString());
        Double bolivianos = dollarAmount * 6.91;

        Toast.makeText(MainActivity.this, bolivianos.toString() + " Bolivianos", Toast.LENGTH_LONG).show();
            
        Log.i("Amount", dollarAmountEditText.getText().toString());
        Log.i("Bolivianos", bolivianos.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
