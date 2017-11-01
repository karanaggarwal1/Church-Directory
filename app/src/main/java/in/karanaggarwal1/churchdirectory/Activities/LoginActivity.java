package in.karanaggarwal1.churchdirectory.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import in.karanaggarwal1.churchdirectory.R;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    private FirebaseAuth firebaseAuth;
    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString(),
                        password = etPassword.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
                            if (task.isSuccessful()) {
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                        Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                            } else {
                                Log.d(TAG, "onComplete: " + task.getException().getMessage());
                            }
                        }
                    }
                });
            }
        });
    }
}
