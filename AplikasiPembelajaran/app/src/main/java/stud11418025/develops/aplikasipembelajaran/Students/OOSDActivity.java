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

import stud11418025.develops.aplikasipembelajaran.OOSD.Main;
import stud11418025.develops.aplikasipembelajaran.OOSD.OOSDDatabase;
import stud11418025.develops.aplikasipembelajaran.R;

public class OOSDActivity extends AppCompatActivity {
    private RecyclerView rvGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oosdstud);

        rvGejala = findViewById(R.id.rv_judul);

        LinearLayoutManager llm = new LinearLayoutManager(OOSDActivity.this);
        rvGejala.setLayoutManager(llm);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetAllGejala(OOSDActivity.this).execute();
    }

    public static class GetAllGejala extends AsyncTask<Void, Void, List<Main>> {
        private WeakReference<Context> c;

        public GetAllGejala(Context c) {
            this.c = new WeakReference<>(c);
        }

        @Override
        protected List<Main> doInBackground(Void... voids) {
            OOSDDatabase ud = OOSDDatabase.getAppDatabase(c.get());
            return ud.OOSDDao().getAllUsers();
        }

        @Override
        protected void onPostExecute(List<Main> users) {
            super.onPostExecute(users);
            RecyclerView rv = ((Activity) c.get()).findViewById(R.id.rv_judul);

            OOSDAdapter ua = new OOSDAdapter(c.get(), users);
            rv.setAdapter(ua);
        }
    }
}
