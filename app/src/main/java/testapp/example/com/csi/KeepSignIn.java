package testapp.example.com.csi;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class KeepSignIn extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if(user != null)
        {
            startActivity(new Intent(KeepSignIn.this,userPic.class));
        }
        else
            {
                startActivity(new Intent(KeepSignIn.this,MainActivity.class));
            }

    }
}
