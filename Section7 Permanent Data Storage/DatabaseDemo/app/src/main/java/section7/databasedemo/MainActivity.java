package section7.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            //Creates a table if it doesn't exist
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Edgar', 21)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Juan Pablo', 22)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Mauricio', 13)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Edgar', 9)");

            Cursor cursor = myDatabase.rawQuery("SELECT * FROM users", null);

            //get the indexes of the values in the tables.
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            cursor.moveToFirst();
            while (cursor != null) {

                Log.i("name", cursor.getString(nameIndex));
                Log.i("age", Integer.toString(cursor.getInt(ageIndex)));

                cursor.moveToNext();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
