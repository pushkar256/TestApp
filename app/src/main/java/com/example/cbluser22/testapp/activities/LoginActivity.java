package com.example.cbluser22.testapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cbluser22.testapp.R;
import com.example.cbluser22.testapp.helper.EmailValidator;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar1;
    Button btnLogin;
    TextView tvSignup;
    EmailValidator emailValidator=new EmailValidator();
    EditText etEmail,et,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        listeners();
        setToolBar();



    }

    private void setToolBar() {
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    }

    private void listeners() {
        tvSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    private void init() {
        etEmail=(EditText)findViewById(R.id.et_email);
        etPassword=(EditText)findViewById(R.id.et_password);
        toolbar1=(Toolbar)findViewById(R.id.toolbar_1);
        tvSignup=(TextView)findViewById(R.id.tv_signup1);
        btnLogin=(Button)findViewById(R.id.btn_login);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_signup1:
                Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
                break;

            case R.id.btn_login:
                if(check(etEmail)&&emailValidator.validate(etEmail.getText().toString().trim())&&check(etEmail)&&check(etPassword))
                {
                    Intent intent = new Intent(LoginActivity.this,HomeCardActivity.class);
                    startActivity(intent);

                }
                break;


        }

    }
    private boolean check(EditText et)
    {
        if(et.getText().toString().isEmpty())
        {
            et.setError(et.getHint().toString()+getResources().getString(R.string.error));
            et.requestFocus();
            return false;
        }
        return true;
    }
}
