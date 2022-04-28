package stud11418025.develops.aplikasipembelajaran.Students;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.lang.ref.WeakReference;
import java.util.List;

import stud11418025.develops.aplikasipembelajaran.DASPRO.DasproDatabase;
import stud11418025.develops.aplikasipembelajaran.DASPRO.Main;
import stud11418025.develops.aplikasipembelajaran.R;

public class DASPROActivity extends AppCompatActivity {
    private RecyclerView rvGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasprostud);

        rvGejala = findViewById(R.id.rv_judul);

        LinearLayoutManager llm = new LinearLayoutManager(DASPROActivity.this);
        rvGejala.setLayoutManager(llm);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetAllGejala(DASPROActivity.this).execute();
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

            DASPROAdapter ua = new DASPROAdapter(c.get(), users);
            rv.setAdapter(ua);
        }
    }
}
