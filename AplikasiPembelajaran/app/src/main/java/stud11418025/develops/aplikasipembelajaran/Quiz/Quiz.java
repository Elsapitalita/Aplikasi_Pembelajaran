package stud11418025.develops.aplikasipembelajaran.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import stud11418025.develops.aplikasipembelajaran.LearnAdapter;
import stud11418025.develops.aplikasipembelajaran.Learning;
import stud11418025.develops.aplikasipembelajaran.R;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ArrayList<Learning> learn = new ArrayList<Learning>();

        learn.add(new Learning("PAM"));
        learn.add(new Learning("PBO"));
        learn.add(new Learning("PASTI"));
        learn.add(new Learning("OOSD"));
        learn.add(new Learning("DasPro"));

        LearnAdapter matkulAdapter = new LearnAdapter(this, learn);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(matkulAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Dessert dessert = desserts.get(i);
                switch(i) {
                    case 0:
                        Intent donut = new Intent(Quiz.this, PAMQuiz.class);
                        startActivity(donut);
                        break;
                    case 1:
                        Intent cookie = new Intent(Quiz.this, PBOQuiz.class);
                        startActivity(cookie);
                        break;
                    case 2:
                        Intent pieceOfCake = new Intent(Quiz.this, PASTIQuiz.class);
                        startActivity(pieceOfCake);
                        break;
                    case 3:
                        Intent pastry = new Intent(Quiz.this, OOSDQuiz.class);
                        startActivity(pastry);
                        break;
                    case 4:
                        Intent next = new Intent(Quiz.this, DasProQuiz.class);
                        startActivity(next);
                        break;
                }
            }
        });
    }
}
