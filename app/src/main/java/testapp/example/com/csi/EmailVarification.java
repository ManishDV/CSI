package testapp.example.com.csi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailVarification extends AppCompatActivity {

    TextView verificationText;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_varification);
        verificationText = findViewById(R.id.veri_text);
        user = FirebaseAuth.getInstance().getCurrentUser();


    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void resendEmail(View view) {


        if (!user.isEmailVerified()) {
            FirebaseAuth.getInstance().getCurrentUser()
                    .sendEmailVerification()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(EmailVarification.this, "Email Send", Toast.LENGTH_SHORT).show();
                        }
                    });
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    public void checkStatus(View view) {
        if(user.isEmailVerified())
        {
            verificationText.setText("Email Verified");
            verificationText.setTextColor(Color.GREEN);
            finish();
        }
        Toast.makeText(this, "Nope", Toast.LENGTH_SHORT).show();
    }
}
