package in.karanaggarwal1.churchdirectory.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import in.karanaggarwal1.churchdirectory.R;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            Toast.makeText(this,"User unexpectedly logged out", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

    }
}
