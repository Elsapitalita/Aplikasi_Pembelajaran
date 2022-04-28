package stud11418025.develops.aplikasipembelajaran.OOSD;

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

public class OOSD extends AppCompatActivity {
    private RecyclerView rvOOSD;
    private FloatingActionButton fabAddOOSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oosd);

        rvOOSD = findViewById(R.id.rv_judul);
        fabAddOOSD = findViewById(R.id.fab_add_gejala);

        LinearLayoutManager llm = new LinearLayoutManager(OOSD.this);
        rvOOSD.setLayoutManager(llm);

        fabAddOOSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OOSD.this, AddOOSDActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetAllGejala(OOSD.this).execute();
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

