package com.creativediligence.saloonsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_LoginSignup extends AppCompatActivity {

    EditText saloonName;
    EditText userName;
    EditText password;

    Spinner userTypeSpinner;
    Button signup;
    TextView signin;
    TextView prompt;

    boolean isSignUp = true;
    int userType = 0;
    String regUserName;
    String regUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login_signup);

        InitializeXMLElements();
    }

    public void InitializeXMLElements() {
        saloonName = findViewById(R.id.login_activity_saloonname);
        userName = findViewById(R.id.login_activity_username);
        password = findViewById(R.id.activity_login_password);

        userTypeSpinner = findViewById(R.id.activity_login_usertype);
        signup = findViewById(R.id.activity_login_signup_button);
        signin = findViewById(R.id.activity_login_signin_text);
        prompt = findViewById(R.id.activity_login_prompt);

        //Initial States
        userName.setVisibility(View.GONE);

        //onClickListeners
        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = userTypeSpinner.getItemAtPosition(i).toString();
                Toast.makeText(Activity_LoginSignup.this, temp, Toast.LENGTH_SHORT).show();
                userType = userTypeSpinner.getSelectedItemPosition();
                if (userType == 0) {
                    userName.setVisibility(View.GONE);
                    saloonName.setVisibility(View.VISIBLE);
                } else {
                    userName.setVisibility(View.VISIBLE);
                    saloonName.setVisibility(View.GONE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSignUp) {
                    signup.setText(R.string.activity_login_sign_in);
                    signin.setText(R.string.activity_login_sign_up);
                    prompt.setText(R.string.activity_login_sign_up_prompt);

                } else {
                    signup.setText(R.string.activity_login_sign_up);
                    signin.setText(R.string.activity_login_sign_in);
                    prompt.setText(R.string.activity_login_sign_in_prompt);
                }
                isSignUp = !isSignUp;
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasEmptyString=true;
                boolean isAllGood=false;
                if (userType == 0) {
                    hasEmptyString=GetEditTextString(saloonName,password);

                } else if (userType == 1) {
                    hasEmptyString=GetEditTextString(userName,password);
                }
                if(isSignUp){
                    isAllGood=UploadUserData(hasEmptyString);
                }else{
                    isAllGood=ConfirmUserData(hasEmptyString);
                }
                StartIntent(isAllGood);

                //StartIntent();


            }
        });
    }

    public boolean GetEditTextString(EditText editText1, EditText editText2){
        boolean isInputEmpty=true;

        if (editText1.getText().toString().trim().equals("") || editText2.getText().toString().trim().equals("")) {
            Toast.makeText(Activity_LoginSignup.this, "Empty Input Available", Toast.LENGTH_SHORT).show();

        } else {
            regUserName = editText1.getText().toString().trim();
            regUserPassword = editText2.getText().toString().trim();
            isInputEmpty=false;
        }
        return isInputEmpty;
    }
    public boolean UploadUserData(boolean isEmptyString){
        boolean isAllGood=false;
        if(!isEmptyString){
            Toast.makeText(this, "Thanks For Registering, "+regUserName+"!", Toast.LENGTH_SHORT).show();
            isAllGood=true;
        }
        return isAllGood;
    }

    public boolean ConfirmUserData(boolean isEmptyString){
        boolean isAllGood=false;
        if(!isEmptyString){
            Toast.makeText(this, "You Came Back! Thank You "+regUserName+"!", Toast.LENGTH_SHORT).show();
            isAllGood=true;
        }
        return isAllGood;
    }

    public void StartIntent(boolean isAllGood){
        if(isAllGood) {
            Bundle options = new Bundle();
            options.putString("userName", regUserName);
            Intent homePageIntent = new Intent(Activity_LoginSignup.this, Activity_Homepage.class);
            Activity_LoginSignup.this.startActivity(homePageIntent, options);
            finish();
        }
    }
}
