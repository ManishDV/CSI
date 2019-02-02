package testapp.example.com.csi;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.Telephony;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Objects;

import static testapp.example.com.csi.R.drawable.check;

public class ParticipationForm extends AppCompatActivity {

    TextInputLayout mPart1name,mPart1Email,mPart2name,mPart3name,mPart4name,mEventname,mCollege;
    ScrollView scrollView;
    String price;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participation_form);

        mEventname = findViewById(R.id.text_event_name);
        mPart1name = findViewById(R.id.text_part1);
        mPart1Email = findViewById(R.id.text_part1_email);
        mPart2name = findViewById(R.id.text_part2);
        mPart3name = findViewById(R.id.text_part3);
        mPart4name = findViewById(R.id.text_part4);
        scrollView = findViewById(R.id.scView);
        mCollege = findViewById(R.id.college);

        Intent i = getIntent();
        String maxParts = i.getStringExtra("maxPart");
        String event = i.getStringExtra("eventName");
        price = i.getStringExtra("price");

        int allowed = (int )Integer.parseInt(maxParts);

        mEventname.getEditText().setText(event);
        mEventname.getEditText().setEnabled(false);
        enableTextfields(allowed);
        /*errorCheck();*/

    }

    protected void enableTextfields(int allowed)
    {
        if(allowed == 2)
        {
            mPart3name.setVisibility(View.GONE);
            mPart4name.setVisibility(View.GONE);

        }
        else if(allowed == 3)
        {
            mPart4name.setVisibility(View.GONE);

            mPart4name.setVisibility(View.VISIBLE);
        }
        else
        {
            //all textfields are displayed
            mPart3name.setVisibility(View.VISIBLE);
            mPart4name.setVisibility(View.VISIBLE);
            mCollege.setVisibility(View.VISIBLE);
        }
    }

    
    protected boolean validateName() {
        if (mPart1name.getEditText().getText().toString().trim().length() == 0) {
            mPart1name.setError("Participant 1 Name is Required");
            return false;
        }
        else
        {
            mPart1name.setError("");
            mPart1name.setErrorEnabled(false);
            mPart1name.setNextFocusDownId(R.id.text_part1_email);
        }
        return  true;
    }

    protected boolean validateEmail() {

        if(mPart1Email.getEditText().getText().toString().trim().length() == 0)
        {
            mPart1Email.setError("Email Can't Be Empty");
            return false;
        }
        else {
            if (!(Patterns.EMAIL_ADDRESS.matcher(mPart1Email.getEditText().getText().toString()).matches())) {
                mPart1Email.setError("Please Enter Valid Email");
                return false;
            }
            mPart1Email.setError("");
            mPart1Email.setErrorEnabled(false);
            mPart1Email.setNextFocusDownId(R.id.text_part2);
        }
        return true;
    }

    protected boolean validateCollege()
    {

        if(mCollege.getEditText().getText().toString().trim().length() == 0)
        {
            mCollege.setError("Enter College Name");
            mCollege.getEditText().requestFocus();
            return false;
        }
        return true;

    }

    public void payment(View view) {
            if(validateName() && validateEmail() && validateCollege())
            {

                startActivity(new Intent(ParticipationForm.this, payment.class));
            }
            else
            {

            }

    }


}
