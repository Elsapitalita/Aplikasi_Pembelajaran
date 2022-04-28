package stud11418025.develops.aplikasipembelajaran.OOSD;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import stud11418025.develops.aplikasipembelajaran.R;

public class AddOOSDActivity extends AppCompatActivity {
    private EditText etGejala, etDetail;
    private Button btnAdd;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_oosd);

        etGejala = findViewById(R.id.et_gejala);
        etDetail = findViewById(R.id.et_detail);

        btnAdd = findViewById(R.id.btn_add);

        if (getIntent().hasExtra("id")) {
            id = getIntent().getIntExtra("id", 0);
            btnAdd.setText("Update");
            new GetOOSD(AddOOSDActivity.this, id).execute();
        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Main = etGejala.getText().toString().trim();
                String Detail = etDetail.getText().toString().trim();



                if (getIntent().hasExtra("id")) {
                    if (0 != Main.length()) {
                        Main u = new Main();
                        u.setId(id);
                        u.setJudul(Main);
                        u.setDetail1(Detail);



                        new UpdateOOSD(AddOOSDActivity.this, u).execute();
                    } else {
                        Toast.makeText(AddOOSDActivity.this, "Silahkan masukkan judul materi.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (0 != Main.length() ) {
                        Main u = new Main();
                        u.setJudul(Main);
                        u.setDetail1(Detail);
                        new AddOOSD(AddOOSDActivity.this, u).execute();
                    } else {
                        Toast.makeText(AddOOSDActivity.this, "Silahkan masukkan detail materi.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    static class AddOOSD extends AsyncTask<Void, Void, Void> {
        private Main u;
        private WeakReference<Context> c;

        public AddOOSD(Context c, Main u) {
            this.c = new WeakReference<>(c);
            this.u = u;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            OOSDDatabase ud = OOSDDatabase.getAppDatabase(c.get());
            ud.OOSDDao().insert(u);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(c.get(), "materi OOSD added successfully!", Toast.LENGTH_SHORT).show();
            ((Activity) c.get()).finish();
        }
    }

    static class UpdateOOSD extends AsyncTask<Void, Void, Void> {
        private Main u;
        private WeakReference<Context> c;

        public UpdateOOSD(Context c, Main u) {
            this.c = new WeakReference<>(c);
            this.u = u;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            OOSDDatabase ud = OOSDDatabase.getAppDatabase(c.get());
            ud.OOSDDao().update(u);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(c.get(), "materi OOSD updated successfully!", Toast.LENGTH_SHORT).show();
            ((Activity) c.get()).finish();
        }
    }

    static class GetOOSD extends AsyncTask<Void, Void, Main> {
        private WeakReference<Context> c;
        private int id;

        public GetOOSD(Context c, int id) {
            this.c = new WeakReference<>(c);
            this.id = id;
        }

        @Override
        protected Main doInBackground(Void... voids) {
            OOSDDatabase ud = OOSDDatabase.getAppDatabase(c.get());
            Main u = ud.OOSDDao().getUser(id);
            return u;
        }

        @Override
        protected void onPostExecute(Main u) {
            super.onPostExecute(u);

            EditText etGejala = ((Activity) c.get()).findViewById(R.id.et_gejala);
            EditText etDetail = ((Activity) c.get()).findViewById(R.id.et_detail);

            etGejala.setText(u.getJudul());
            etDetail.setText(u.getDetail1());


        }
    }
}
