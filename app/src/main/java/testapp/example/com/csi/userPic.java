package testapp.example.com.csi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class userPic extends AppCompatActivity {

    DatabaseReference eventFB;
    FirebaseUser user;
    FirebaseAuth auth;
    TextView veri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pic);

        veri = findViewById(R.id.veriId);
        eventFB = FirebaseDatabase.getInstance().getReference("Event");
        EthusiaEvents c = new EthusiaEvents(1, "E", "HALWA", 9.0f);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        eventFB.setValue(c);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater app_menu = getMenuInflater();
        app_menu.inflate(R.menu.csi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signOutBtn:
                auth.signOut();
                Intent i = new Intent(userPic.this, MainActivity.class);
                //TO AVOID BACK
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;
            case R.id.faq_tag:
                Intent intent = new Intent(userPic.this, FaqActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!user.isEmailVerified()) {
            Toast.makeText(this, "Please Verify Email First!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, EmailVarification.class);
            startActivity(i);
        }


    }
}
