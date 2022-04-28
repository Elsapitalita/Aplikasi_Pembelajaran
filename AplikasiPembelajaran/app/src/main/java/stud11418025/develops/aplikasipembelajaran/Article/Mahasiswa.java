package stud11418025.develops.aplikasipembelajaran.Article;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import stud11418025.develops.aplikasipembelajaran.Home;
import stud11418025.develops.aplikasipembelajaran.R;

public class Mahasiswa extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        Button btnkembali = (Button)findViewById(R.id.btnkembali);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mahasiswa.this, Home.class);
                startActivity(i);
            }
        });

    }
}
