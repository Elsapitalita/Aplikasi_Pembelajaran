package stud11418025.develops.aplikasipembelajaran;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import stud11418025.develops.aplikasipembelajaran.Article.PendaftaranPraktikumStud;
import stud11418025.develops.aplikasipembelajaran.Quiz.Quiz;
import stud11418025.develops.aplikasipembelajaran.Students.LearnStud;

public class HomeStudents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_students);

        ImageView showRide = (ImageView) findViewById(R.id.learn);
        ImageView showRide1 = (ImageView) findViewById(R.id.article);
        ImageView showRide2 = (ImageView) findViewById(R.id.quiz);
        ImageView showRide3 = (ImageView) findViewById(R.id.about);
        Button btnExit = (Button) findViewById(R.id.btnExit);

        showRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeStudents.this, LearnStud.class);
                startActivity(intent);
            }
        });
        showRide1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeStudents.this, PendaftaranPraktikumStud.class);
                startActivity(intent);
            }
        });
        showRide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeStudents.this, Quiz.class);
                startActivity(intent);
            }
        });
        showRide3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeStudents.this, About.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeStudents.this, Splashscreen.class);
                startActivity(i);
            }
        });
    }
}
