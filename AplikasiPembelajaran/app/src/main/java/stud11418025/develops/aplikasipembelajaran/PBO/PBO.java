package stud11418025.develops.aplikasipembelajaran.PBO;

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

public class PBO extends AppCompatActivity {
    private RecyclerView rvPBO;
    private FloatingActionButton fabAddPBO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pbo);

        rvPBO = findViewById(R.id.rv_judul);
        fabAddPBO = findViewById(R.id.fab_add_gejala);

        LinearLayoutManager llm = new LinearLayoutManager(PBO.this);
        rvPBO.setLayoutManager(llm);

        fabAddPBO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PBO.this, AddPBOActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetAllGejala(PBO.this).execute();
    }

    public static class GetAllGejala extends AsyncTask<Void, Void, List<Main>> {
        private WeakReference<Context> c;

        public GetAllGejala(Context c) {
            this.c = new WeakReference<>(c);
        }

        @Override
        protected List<Main> doInBackground(Void... voids) {
            PBODatabase ud = PBODatabase.getAppDatabase(c.get());
            return ud.PBODao().getAllUsers();
        }

        @Override
        protected void onPostExecute(List<Main> users) {
            super.onPostExecute(users);
            RecyclerView rv = ((Activity) c.get()).findViewById(R.id.rv_judul);

            PBOAdapter ua = new PBOAdapter(c.get(), users);
            rv.setAdapter(ua);
        }
    }
}

