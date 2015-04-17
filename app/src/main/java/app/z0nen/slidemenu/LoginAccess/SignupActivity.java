package app.z0nen.slidemenu.LoginAccess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import app.z0nen.slidemenu.MyActivity;
import app.z0nen.slidemenu.R;

public class SignupActivity extends Activity {

    protected EditText mFname;
    protected EditText muname;
    protected EditText mpword;
    protected EditText mEmail;
    protected ProgressBar mProgress;
    protected Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFname = (EditText) findViewById(R.id.etName);
        muname = (EditText) findViewById(R.id.etUserName);
        mEmail = (EditText) findViewById(R.id.etEmail);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mpword = (EditText) findViewById(R.id.etPass);
        mSignUpButton = (Button) findViewById(R.id.btnSingIn);
        mProgress.setVisibility(View.GONE);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = mFname.getEditableText().toString();
                String username = muname.getEditableText().toString();
                String password = mpword.getEditableText().toString();
                String email = mEmail.getEditableText().toString();

                firstName = firstName.trim();
                username = username.trim();
                password = password.trim();
                email = email.trim();

                if (firstName.isEmpty() ||  username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);

                    builder.setMessage("Please fill all the fields.");
                    builder.setTitle("OOPS!!");
                    builder.setPositiveButton(android.R.string.ok, null);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    ParseUser newUser = new ParseUser();
                    newUser.setUsername(username);
                    newUser.setEmail(email);
                    newUser.setPassword(password);
                    newUser.put("Name", firstName);
                    newUser.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {

                            if (e == null) {
                                Intent intent = new Intent(SignupActivity.this, MyActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder popup = new AlertDialog.Builder(SignupActivity.this);
                                popup.setTitle("OOPS");
                                popup.setMessage("Error:-" + e.getMessage());
                                popup.setPositiveButton("Try Again",null);
                                popup.setNegativeButton("Cancel and exit the app", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SignupActivity.super.onBackPressed();
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
}
