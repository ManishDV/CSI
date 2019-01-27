package testapp.example.com.csi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class AskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);
        getIn();
    }


    protected void getIn(){

        Log.d("Instance ID", FirebaseInstanceId.getInstance().getId());
    }

}

