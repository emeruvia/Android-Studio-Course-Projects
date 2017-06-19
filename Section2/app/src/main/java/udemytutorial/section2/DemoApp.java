package udemytutorial.section2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DemoApp extends AppCompatActivity {

    /*
    public void clickFunction(View view) {

        //This is a toast, It displays text and then disappear
        //Toast.makeText(DemoApp.this, "Hi there!", Toast.LENGTH_SHORT).show();

        EditText myTextField = (EditText) findViewById(R.id.myTextField);

        //This is the mini challenge 2.18
        Toast.makeText(DemoApp.this, myTextField.getText().toString(), Toast.LENGTH_SHORT).show();

        Log.i("Info", myTextField.getText().toString());
    }
    */

    public void imageChange (View view){
        ImageView image = (ImageView) findViewById(R.id.carImageView);
        image.setImageResource(R.drawable.car2);
        Log.i("Test", "Button clicked!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_app);
    }
}
