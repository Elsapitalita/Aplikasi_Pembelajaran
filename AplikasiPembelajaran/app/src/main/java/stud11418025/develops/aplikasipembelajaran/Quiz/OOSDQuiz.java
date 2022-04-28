package stud11418025.develops.aplikasipembelajaran.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import stud11418025.develops.aplikasipembelajaran.OOSD.OOSD;
import stud11418025.develops.aplikasipembelajaran.R;

public class OOSDQuiz extends AppCompatActivity {
    Button mlinePilGan,mLineEssay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oosd_quiz);
        mlinePilGan = (Button) findViewById(R.id.linePilGan);
        mLineEssay = (Button) findViewById(R.id.lineEssay);

        //memberi aksi ketika diklik
        mlinePilGan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hasil aksinya ditulis disini (dalam method onClick)
                //pada kali ini hasil yang diinginkan adalah pindah activity, maka

                //membuat objek baru dari kelas intent,
                //dari MainActivity akan pindah ke KuisPilihaGanda
                Intent i = new Intent(OOSDQuiz.this, OosdPilihanGanda.class);
                startActivity(i); //jalankan Intent
            }
        });

        mLineEssay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hasil aksinya ditulis disini (dalam method onClick)
                //pada kali ini hasil yang diinginkan adalah pindah activity, maka

                //membuat objek baru dari kelas intent,
                //dari MainActivity akan pindah ke KuisEssay
                Intent i = new Intent(OOSDQuiz.this, OOSDEssay.class);
                startActivity(i);
            }
        });

    }
}
