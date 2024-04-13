package com.satdroid.webisticproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

  private  AppCompatButton loginButton;
   private TextView signup_tv;

    private FirebaseAuth firebaseAuth_login;

    private EditText email_edt_login, pass_edt_login;
    private CardView Cemail_login,Cpass_login;
    private ProgressBar progressBar_login;

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth_login.getCurrentUser();
        if(currentUser != null){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginButton=findViewById(R.id.login_btn);
        signup_tv=findViewById(R.id.Signup_tv);

        progressBar_login=findViewById(R.id.progressBar_login);

        Cemail_login=findViewById(R.id.cardView_email_login);
        Cpass_login=findViewById(R.id.cardView_password_login);

        email_edt_login=Cemail_login.findViewById(R.id.email_login);
        pass_edt_login=Cpass_login.findViewById(R.id.password_login);

        firebaseAuth_login = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar_login.setVisibility(View.VISIBLE);
                String emailstr,passwordstr;
                emailstr=String.valueOf(email_edt_login.getText());
                passwordstr=String.valueOf(pass_edt_login.getText());

                if(TextUtils.isEmpty(emailstr)){
                    Toast.makeText(LoginPage.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passwordstr)){
                    Toast.makeText(LoginPage.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth_login.signInWithEmailAndPassword(emailstr,passwordstr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar_login.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                            Intent iLogin=new Intent(LoginPage.this,MainActivity.class);
                             startActivity(iLogin);
                            finish();
                        }
                        else
                        {
                            progressBar_login.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressBar_login.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Some error occured",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signup_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iSignUpTv=new Intent(LoginPage.this, SignUpPage.class);
                startActivity(iSignUpTv);
            }
        });
    }
}