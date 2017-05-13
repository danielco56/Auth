package com.example.daniel.auth;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
    }
        public void register(View v)
        {
            final ProgressDialog progressDialog= ProgressDialog.show(MainActivity.this,"Please wait...", "Processing...", true);
            mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                               @Override
                                               public void onComplete(@NonNull Task<AuthResult> task) {
                                                   progressDialog.dismiss();
                                                   if(task.isSuccessful())
                                                   {
                                                       Toast.makeText(MainActivity.this,"Merge FMM",Toast.LENGTH_LONG).show();
                                                   }
                                                   else
                                                   {
                                                       Toast.makeText(MainActivity.this,"Nu merge",Toast.LENGTH_LONG).show();
                                                   }
                                               }

                                           }
                    );

        }

    }



