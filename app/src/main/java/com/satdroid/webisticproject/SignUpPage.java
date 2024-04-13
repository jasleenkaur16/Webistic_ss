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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;

public class SignUpPage extends AppCompatActivity {

    private AppCompatButton signupBTn;

    private  FirebaseAuth firebaseAuth;

   private EditText email_edt, pass_edt,name_edt;
   private CardView Cemail,Cpass,Cname;

    private ProgressBar progressBar;
    private  TextView login_tv;

    FirebaseFirestore firestore;

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        firebaseAuth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        login_tv=findViewById(R.id.login_textView);
        progressBar=findViewById(R.id.progressBar);

        Cemail=findViewById(R.id.cardView_email);
        Cpass=findViewById(R.id.cardView_password);
        Cname=findViewById(R.id.cardView_name);

        email_edt=Cemail.findViewById(R.id.email_id);
        pass_edt=Cpass.findViewById(R.id.password_id);
        name_edt=Cname.findViewById(R.id.name_id);

        signupBTn=findViewById(R.id.signup_btn);

        signupBTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                String emailText, PassTxt,Name;
                //store data in the string
                emailText=email_edt.getText().toString();
                PassTxt=pass_edt.getText().toString();
                Name=name_edt.getText().toString();
                if(TextUtils.isEmpty(emailText)){
                    Toast.makeText(SignUpPage.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(PassTxt)){
                    Toast.makeText(SignUpPage.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(emailText,PassTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUpPage.this,"User registered",Toast.LENGTH_SHORT).show();
                            CollectionReference UserCollection=firestore.collection("Users");
                            HashMap<String,String> UserHash=new HashMap<>();
                            UserHash.put("User Name",Name);
                            UserHash.put("Email",emailText);
                            UserHash.put("Password",PassTxt);

                            UserCollection.add(UserHash).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(SignUpPage.this,"User data saved",Toast.LENGTH_SHORT).show();

                                    }
                                    else
                                    {
                                        Toast.makeText(SignUpPage.this,"User data not saved",Toast.LENGTH_SHORT).show();

                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignUpPage.this,"Some error occured",Toast.LENGTH_SHORT).show();
                                }
                            });
                            progressBar.setVisibility(View.GONE);
                            Intent isignin=new Intent(SignUpPage.this,LoginPage.class);
                            startActivity(isignin);
                            finish();

                        }
                        else
                        {
                            Toast.makeText(SignUpPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUpPage.this,"Some error occured",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });

            }
        });
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent isignin=new Intent(SignUpPage.this,LoginPage.class);
                startActivity(isignin);
                finish();
            }
        });
    }
}