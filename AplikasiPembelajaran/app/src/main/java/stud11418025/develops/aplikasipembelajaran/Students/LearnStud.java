package stud11418025.develops.aplikasipembelajaran.Students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import stud11418025.develops.aplikasipembelajaran.R;

public class LearnStud extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        final ArrayList<LearningStud> learn = new ArrayList<LearningStud>();

        learn.add(new LearningStud("PAM"));
        learn.add(new LearningStud("PBO"));
        learn.add(new LearningStud("PASTI"));
        learn.add(new LearningStud("OOSD"));
        learn.add(new LearningStud("DasPro"));

        LearnStudAdapter matkulAdapter = new LearnStudAdapter(this, learn);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(matkulAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Dessert dessert = desserts.get(i);
                switch(i) {
                    case 0:
                        Intent donut = new Intent(LearnStud.this, PAMActivity.class);
                        startActivity(donut);
                        break;
                    case 1:
                        Intent cookie = new Intent(LearnStud.this, PBOActivity.class);
                        startActivity(cookie);
                        break;
                    case 2:
                        Intent pieceOfCake = new Intent(LearnStud.this, PASTIActivity.class);
                        startActivity(pieceOfCake);
                        break;
                    case 3:
                        Intent pastry = new Intent(LearnStud.this, OOSDActivity.class);
                        startActivity(pastry);
                        break;
                    case 4:
                        Intent next = new Intent(LearnStud.this, DASPROActivity.class);
                        startActivity(next);
                        break;
                }
            }
        });

    }
}
