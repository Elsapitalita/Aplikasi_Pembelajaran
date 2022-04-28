package stud11418025.develops.aplikasipembelajaran.PAM;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.ref.WeakReference;
import java.util.List;

import stud11418025.develops.aplikasipembelajaran.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvGejala;
    private FloatingActionButton fabAddGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gejala);

        rvGejala = findViewById(R.id.rv_judul);
        fabAddGejala = findViewById(R.id.fab_add_gejala);

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rvGejala.setLayoutManager(llm);

        fabAddGejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddGejalaActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetAllGejala(MainActivity.this).execute();
    }

    public static class GetAllGejala extends AsyncTask<Void, Void, List<Gejala>> {
        private WeakReference<Context> c;

        public GetAllGejala(Context c) {
            this.c = new WeakReference<>(c);
        }

        @Override
        protected List<Gejala> doInBackground(Void... voids) {
            GejalaDatabase ud = GejalaDatabase.getAppDatabase(c.get());
            return ud.gejalaDao().getAllUsers();
        }

        @Override
        protected void onPostExecute(List<Gejala> users) {
            super.onPostExecute(users);
            RecyclerView rv = ((Activity) c.get()).findViewById(R.id.rv_judul);

            GejalaAdapter ua = new GejalaAdapter(c.get(), users);
            rv.setAdapter(ua);
        }
    }
}
