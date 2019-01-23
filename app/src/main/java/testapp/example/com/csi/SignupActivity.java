package testapp.example.com.csi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText passR,emailR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailR = findViewById(R.id.email_r);
        passR = findViewById(R.id.pass_r);
        auth = FirebaseAuth.getInstance();
    }
    public void SignUp(View view) {

        String name = emailR.getText().toString();
        String password = passR.getText().toString();

        if(name.isEmpty())
        {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            emailR.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(name).matches())
        {
            Toast.makeText(this, "Enter VALID Email", Toast.LENGTH_SHORT).show();
            emailR.requestFocus();
            return;
        }
        if(password.isEmpty()||password.length()<7)
        {
            passR.setError("Password Required");
            return;
        }

       auth.createUserWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful())
               {
                   Toast.makeText(SignupActivity.this, "DONE", Toast.LENGTH_SHORT).show();
               }
           }
       });




    }

    public void login(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
