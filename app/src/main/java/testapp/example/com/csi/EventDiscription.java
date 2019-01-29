package testapp.example.com.csi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventDiscription extends AppCompatActivity {

    String key;
    TextView name, disp, price;
    EthusiaEvents Event = new EthusiaEvents();
    FirebaseDatabase mDb = FirebaseDatabase.getInstance();
    DatabaseReference mRef = mDb.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_discription);
        Intent i = getIntent();
        key = i.getStringExtra("Event");

        name = findViewById(R.id.Event_name);
        price = findViewById(R.id.Event_price);
        disp = findViewById(R.id.Event_description);

        mRef = FirebaseDatabase.getInstance().getReference("Events").child(key);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Event = dataSnapshot.getValue(EthusiaEvents.class);
                name.setText(Event.getName());
                price.setText(Float.toString(Event.getPrice()));
                disp.setText(Event.getDescription());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


    }


}
