package testapp.example.com.csi;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class FaqActivity extends AppCompatActivity {


    ExpandableListAdapter adapter1;
    ExpandableListView listv;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mReference = mDatabase.getReference();
    String quest[];
    String ansS[];
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        listv = findViewById(R.id.expView);




//        lv = (ListView) findViewById(R.id.listv);
//        final ArrayList <String> list = new ArrayList<>();
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                populate(dataSnapshot);
                //expList.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void populate(DataSnapshot dataSnapshot) {
        final ArrayList<String> Quelist = new ArrayList<>();
        final ArrayList <String> anslist = new ArrayList<>();

        Quelist.clear();
        anslist.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            QueAns qu = new QueAns();

            try {
                for (int j = 1; j <= ds.getChildrenCount(); j++) {
                    qu.setQuestion(Objects.requireNonNull(ds.child(String.valueOf(j)).getValue(QueAns.class)).getQuestion());
                    qu.setAnswer(Objects.requireNonNull(ds.child(String.valueOf(j)).getValue(QueAns.class)).getAnswer());


                    Quelist.add(qu.getQuestion());
                    anslist.add(qu.getAnswer());



                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Quelist);
            adapter1 = new ExpandableListAdapter() {
                @Override
                public void registerDataSetObserver(DataSetObserver dataSetObserver) {

                }

                @Override
                public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

                }

                @Override
                public int getGroupCount() {

                    quest = new String[Objects.requireNonNull(Quelist.toArray()).length];
                    quest = Quelist.toArray(quest);

                    return Objects.requireNonNull(Quelist.toArray()).length;
                }

                @Override
                public int getChildrenCount(int i) {
                    ansS = new String[Objects.requireNonNull(anslist.toArray()).length];
                    ansS = anslist.toArray(ansS);

                    return 1;
                }

                @Override
                public Object getGroup(int i) {
                    return null;
                }

                @Override
                public Object getChild(int i, int i1) {
                    return null;
                }

                @Override
                public long getGroupId(int i) {
                    return 0;
                }

                @Override
                public long getChildId(int i, int i1) {
                    return 0;
                }

                @Override
                public boolean hasStableIds() {
                    return false;
                }

                @Override
                public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setTextSize(20);
                    textView.setTextColor(Color.BLACK);
                    textView.setPadding(10,50,20,50);

                    textView.setText(quest[i]);

                    return textView;
                }

                @Override
                public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setTextSize(18);
                    textView.setTextColor(Color.BLACK);
                    textView.setText(ansS[i]);
                    textView.setPadding(50,50,20,50);
                    return textView;
                }

                @Override
                public boolean isChildSelectable(int i, int i1) {
                    return false;
                }

                @Override
                public boolean areAllItemsEnabled() {
                    return false;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public void onGroupExpanded(int i) {

                }

                @Override
                public void onGroupCollapsed(int i) {

                }

                @Override
                public long getCombinedChildId(long l, long l1) {
                    return 0;
                }

                @Override
                public long getCombinedGroupId(long l) {
                    return 0;
                }
            };

            listv.setAdapter(adapter1);

        }

    }
}
