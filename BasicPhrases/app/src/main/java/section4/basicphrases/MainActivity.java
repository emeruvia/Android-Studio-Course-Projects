package section4.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view){

        int id = view.getId();
        String ourId = "";

        //This will give us the id of the objects.
        ourId = view.getResources().getResourceEntryName(id);

        int resourceId = getResources().getIdentifier(ourId, "raw", "section4.basicphrases");

        MediaPlayer mPlayer = MediaPlayer.create(this, resourceId);
        mPlayer.start();

        Log.i("button tapped", ourId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
