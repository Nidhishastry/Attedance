package app.z0nen.slidemenu.LoginAccess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import app.z0nen.slidemenu.MyActivity;
import app.z0nen.slidemenu.R;

public class LoginActivity extends Activity {
    public static final String TAG = LoginActivity.class.getSimpleName();

    protected EditText mUsername;
    protected EditText mPassword;
    protected Button mSignInButton;
    protected ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText)findViewById(R.id.login_username);
        mPassword = (EditText)findViewById(R.id.login_password);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mSignInButton = (Button)findViewById(R.id.signinbutton);
        mProgress.setVisibility(View.GONE);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.setVisibility(View.VISIBLE);

                String UserName = mUsername.getEditableText().toString();
                 String password = mPassword.getEditableText().toString();

                UserName = UserName.trim();
                password = password.trim();
                if (UserName.isEmpty() || password.isEmpty()) {
                    mProgress.setVisibility(View.GONE);

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

                    builder.setMessage("Please fill all the fields");
                    builder.setTitle("OOPS!!");
                    builder.setPositiveButton(android.R.string.ok, null);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    ParseUser.logInInBackground(UserName, password, new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            mProgress.setVisibility(View.VISIBLE);

                            if (user != null) {
                                Log.i(TAG, user.getUsername());
                                Intent inte = new Intent(LoginActivity.this , MyActivity.class);
                                inte.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                inte.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(inte);

                            } else {
                                // Signup failed. Look at the ParseException to see what happened.
                                mProgress.setVisibility(View.GONE);

                                AlertDialog.Builder popup = new AlertDialog.Builder(LoginActivity.this);
                                popup.setTitle("OOPS");
                                popup.setMessage("Error:-" + e.getMessage());
                                popup.setPositiveButton("Try Again",null);
                                popup.setNegativeButton("Cancel and exit the app", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        LoginActivity.super.onBackPressed();
                                    }
                                });

                                AlertDialog dialog = popup.create();
                                dialog.show();
                            }
                        }
                    });
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
