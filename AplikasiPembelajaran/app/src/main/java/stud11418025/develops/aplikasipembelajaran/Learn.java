package stud11418025.develops.aplikasipembelajaran;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import stud11418025.develops.aplikasipembelajaran.DASPRO.DasPro;
import stud11418025.develops.aplikasipembelajaran.OOSD.OOSD;
import stud11418025.develops.aplikasipembelajaran.PAM.MainActivity;
import stud11418025.develops.aplikasipembelajaran.PASTI.PASTI;
import stud11418025.develops.aplikasipembelajaran.PBO.PBO;

public class Learn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

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
                        Intent donut = new Intent(Learn.this, MainActivity.class);
                        startActivity(donut);
                        break;
                    case 1:
                        Intent cookie = new Intent(Learn.this, PBO.class);
                        startActivity(cookie);
                        break;
                    case 2:
                        Intent pieceOfCake = new Intent(Learn.this, PASTI.class);
                        startActivity(pieceOfCake);
                        break;
                    case 3:
                        Intent pastry = new Intent(Learn.this, OOSD.class);
                        startActivity(pastry);
                        break;
                    case 4:
                        Intent next = new Intent(Learn.this, DasPro.class);
                        startActivity(next);
                        break;
                }
            }
        });

    }
}
