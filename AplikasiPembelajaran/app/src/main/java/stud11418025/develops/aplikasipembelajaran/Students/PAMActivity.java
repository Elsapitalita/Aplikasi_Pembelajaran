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

import stud11418025.develops.aplikasipembelajaran.PAM.Gejala;
import stud11418025.develops.aplikasipembelajaran.PAM.GejalaDatabase;
import stud11418025.develops.aplikasipembelajaran.R;

public class PAMActivity extends AppCompatActivity {
    private RecyclerView rvGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pamstud);

        rvGejala = findViewById(R.id.rv_judul);

        LinearLayoutManager llm = new LinearLayoutManager(PAMActivity.this);
        rvGejala.setLayoutManager(llm);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetAllGejala(PAMActivity.this).execute();
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

            PAMAdapter ua = new PAMAdapter(c.get(), users);
            rv.setAdapter(ua);
        }
    }
}
