package app.z0nen.slidemenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.parse.ParseUser;

import app.z0nen.slidemenu.LoginAccess.BaseLoginActivity;

public class SplashActivity extends Activity {

    public static final String TAG = SplashActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView sun = (ImageView) findViewById(R.id.sun);
        ImageView clock = (ImageView) findViewById(R.id.clock);
        ImageView hour = (ImageView) findViewById(R.id.hour);

        Animation sunRise = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        Animation clockTurn = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        Animation hourTurn = AnimationUtils.loadAnimation(this, R.anim.hour_turn);

        sun.startAnimation(sunRise);
        clock.startAnimation(clockTurn);
        hour.startAnimation(hourTurn);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    // do stuff with the user
                    Log.i(TAG, currentUser.getUsername());
                    Intent intent = new Intent(SplashActivity.this, MyActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                } else {
                    // show the signup or login screen'
                    Intent intent = new Intent(SplashActivity.this, BaseLoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        }, 7000);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
