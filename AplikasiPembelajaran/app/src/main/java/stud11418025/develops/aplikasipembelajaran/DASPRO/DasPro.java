package stud11418025.develops.aplikasipembelajaran.DASPRO;

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

public class DasPro extends AppCompatActivity {
    private RecyclerView rvDaspro;
    private FloatingActionButton fabAddDaspro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daspro);

        rvDaspro = findViewById(R.id.rv_judul);
        fabAddDaspro = findViewById(R.id.fab_add_gejala);

        LinearLayoutManager llm = new LinearLayoutManager(DasPro.this);
        rvDaspro.setLayoutManager(llm);

        fabAddDaspro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DasPro.this, AddDasproActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetAllGejala(DasPro.this).execute();
    }

    public static class GetAllGejala extends AsyncTask<Void, Void, List<Main>> {
        private WeakReference<Context> c;

        public GetAllGejala(Context c) {
            this.c = new WeakReference<>(c);
        }

        @Override
        protected List<Main> doInBackground(Void... voids) {
            DasproDatabase ud = DasproDatabase.getAppDatabase(c.get());
            return ud.DasproDao().getAllUsers();
        }

        @Override
        protected void onPostExecute(List<Main> users) {
            super.onPostExecute(users);
            RecyclerView rv = ((Activity) c.get()).findViewById(R.id.rv_judul);

            DasproAdapter ua = new DasproAdapter(c.get(), users);
            rv.setAdapter(ua);
        }
    }
}

