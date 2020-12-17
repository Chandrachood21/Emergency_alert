package com.example.emergency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText email, passw ;
    Button but,but2;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


            firebaseAuth = FirebaseAuth.getInstance();
            if(firebaseAuth.getCurrentUser()!=null)
            {
                startActivity(new Intent(login.this, MainActivity.class));
            }

            email = (EditText)findViewById(R.id.email1);
            passw = (EditText)findViewById(R.id.pass1);

            but = (Button)findViewById(R.id.button2);
            but2 = (Button)findViewById(R.id.button6);

            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email1 = email.getText().toString();
                    String passw1 = passw.getText().toString();



                    if(email1.isEmpty())
                    {
                        email.setError("Field must not be empty");
                    }
                    else if(passw1.isEmpty())
                    {
                        passw.setError("Field must not be empty");
                    }

                    firebaseAuth.signInWithEmailAndPassword(email1,passw1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(login.this,"Login successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(login.this, MainActivity.class));


                            }
                            else
                            {
                                Toast.makeText(login.this,"Login failed, try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(login.this, ph.class));
                }
            });

        }
}