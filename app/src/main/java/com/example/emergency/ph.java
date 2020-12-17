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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ph extends AppCompatActivity {

    EditText name, email, passw, phno1, phno2, phno3 ;
    Button but;
    Button but2;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph);
        firebaseAuth = FirebaseAuth.getInstance();
        name = (EditText)findViewById(R.id.us_name);
        email = (EditText)findViewById(R.id.us_email);
        passw = (EditText)findViewById(R.id.us_pass);
        phno1 = (EditText)findViewById(R.id.ph1);
        phno2 = (EditText)findViewById(R.id.ph2);
        phno3 = (EditText)findViewById(R.id.ph3);
        but = (Button)findViewById(R.id.button);
        but2 = (Button)findViewById(R.id.button4);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String email1 = email.getText().toString();
                String passw1 = passw.getText().toString();
                String ph1 = phno1.getText().toString();
                String ph2 = phno2.getText().toString();
                String ph3 = phno3.getText().toString();

                if(name1.isEmpty())
                {
                    name.setError("Field must not be empty");
                }
                else if(email1.isEmpty())
                {
                    email.setError("Field must not be empty");
                }
                else if(passw1.isEmpty())
                {
                    passw.setError("Field must not be empty");
                }
                else if(ph1.isEmpty())
                {
                    phno1.setError("Field must not be empty");
                }
                firebaseAuth.createUserWithEmailAndPassword(email1,passw1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(ph.this,"Registration completed",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ph.this, login.class));
                            sendphno();

                        }
                        else
                        {
                            Toast.makeText(ph.this,"Registration failed, try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ph.this, login.class));
            }
        });
    }
    public void sendphno()
    {
        String ph1 = phno1.getText().toString();
        String ph2 = phno2.getText().toString();
        String ph3 = phno3.getText().toString();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("users");
        userphone userph = new userphone(ph1 , ph2, ph3);
        myref.child(firebaseAuth.getUid()).setValue(userph);

    }
}