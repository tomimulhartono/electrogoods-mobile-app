package com.example.electrogoods;

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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class loginwphone extends AppCompatActivity {



    EditText editTextPhone, editTextCode;

    FirebaseAuth mAuth;

    String codeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginwphone);

        mAuth = FirebaseAuth.getInstance();

        editTextCode = findViewById(R.id.editTextCode);
        editTextPhone = findViewById(R.id.editTextPhone);


        findViewById(R.id.buttonGetVerificationCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerificationCode();
            }
        });
        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifySignInCode();
                Intent intent = new Intent(loginwphone.this, Explore.class);
                startActivity(intent);
                finishAndRemoveTask();
            }
        });
    }

    private void verifySignInCode(){
        String code = editTextCode.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "login sukses", Toast.LENGTH_LONG).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(getApplicationContext(),
                                        "verif kode salah", Toast.LENGTH_LONG).show();

                            }
                        }
                    }
                });
    }

    private void sendVerificationCode(){
        String phone = editTextPhone.getText().toString();

        if (phone.isEmpty()) {
            editTextPhone.setError("phone number is required");
            editTextPhone.requestFocus();
            return;
        }

        if (phone.length() < 10) {
            editTextPhone.setError("please enter a valid phone number");
            editTextPhone.requestFocus();
            return;
        }


        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }


    @Override
    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        super.onCodeSent(s, forceResendingToken);

        codeSent = s;
    }
};

}
