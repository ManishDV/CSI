package testapp.example.com.csi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class userPic extends AppCompatActivity {


    FirebaseUser user;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pic);


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


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
            case R.id.events_tag:
                Intent i2 = new Intent(userPic.this, EventsListActivity.class);
                startActivity(i2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}
