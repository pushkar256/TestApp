package com.example.cbluser22.testapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cbluser22.testapp.R;
import com.example.cbluser22.testapp.helper.EmailValidator;

/**
 * Created by cbluser22 on 30/1/17.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvLogin;
    EditText etEmail,etPassword,etFirstName,etLastName;
    Button btnSignUp;
    EmailValidator emailValidator=new EmailValidator();
    Toolbar toolbarSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initViews();
        //setToolbar();




    }

    /**
     * toolbar setting
     */
    private void setToolbar() {
        setSupportActionBar(toolbarSignUp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

    }

    private void initViews() {
        etEmail=(EditText)findViewById(R.id.et_email);
        etPassword=(EditText)findViewById(R.id.et_password);
        etFirstName=(EditText)findViewById(R.id.et_firstname);
        etLastName=(EditText)findViewById(R.id.et_lastname);
        tvLogin=(TextView)findViewById(R.id.tv_login);
        toolbarSignUp=(Toolbar)findViewById(R.id.toolbar_signup);
        btnSignUp=(Button)findViewById(R.id.btn_signup);


        // listeners
        tvLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn_signup)
        {
            if(check(etFirstName)&&check(etLastName)&&check(etEmail)&&emailValidator.validate(etEmail.getText().toString().trim())&&check(etPassword))
            {

            }

        }
        if(v.getId()==R.id.tv_login)
        {
            Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
            startActivity(intent);
        }

    }

    private boolean check(EditText et)
    {
        if(et.getText().toString().isEmpty())
        {
            et.setError(et.getHint().toString()+" "+getResources().getString(R.string.error));
            et.requestFocus();
            return false;
        }
        return true;
    }
}
