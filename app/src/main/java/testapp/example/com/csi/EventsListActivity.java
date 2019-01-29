package testapp.example.com.csi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EventsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);



    }

    public void EventClick(View view) {

        Intent i = new Intent(EventsListActivity.this,EventDiscription.class);

        switch (view.getId())
        {

            case R.id.e1:
                i.putExtra("Event","e1");
                break;
            case R.id.e2:
                i.putExtra("Event","e2");
                break;
            case R.id.e3:
                i.putExtra("Event","e3");
                break;
            case R.id.e4:
                i.putExtra("Event","e4");
                break;
            case R.id.e5:
                i.putExtra("Event","e5");
                break;
            case R.id.e6:
                i.putExtra("Event","e6");
                break;

        }
        startActivity(i);

    }
}
