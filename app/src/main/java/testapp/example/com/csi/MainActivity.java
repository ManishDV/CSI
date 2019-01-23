package testapp.example.com.csi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//LOGIN ACTIVITY
public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText pass, email;
    ProgressBar pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email_e);
        pass = findViewById(R.id.pass_e);
        mAuth = FirebaseAuth.getInstance();
        //pg = findViewById(R.id.progressBar);
        //   pg.setIndeterminate(false);
        //   pg.setVisibility(View.GONE);

    }

    public void login(View view) {
        String username = email.getText().toString();
        String passWord = pass.getText().toString();

        pg = new ProgressBar(getApplicationContext());
        pg.setIndeterminate(true);

        //Basic Validations
        if (username.isEmpty()) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            email.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            Toast.makeText(this, "Enter VALID Email", Toast.LENGTH_SHORT).show();
            email.requestFocus();
            return;

        }
        if (passWord.isEmpty() || passWord.length() < 7) {

            pass.setError("Password Required");
            return;

        }

        //REAL CODE STARTS HERE
        pg.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(username, passWord).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //IF LOG IN IS SUCCESSFULL
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "WELCOME", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, userPic.class);
                    startActivity(i);
                }
                //DISPLAY ERROR
                else {
                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        pg.setVisibility(View.GONE);

    }

    public void SignUp(View view) {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }
}
