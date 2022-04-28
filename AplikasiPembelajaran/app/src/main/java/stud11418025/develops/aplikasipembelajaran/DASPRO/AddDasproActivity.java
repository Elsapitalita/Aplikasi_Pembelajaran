package stud11418025.develops.aplikasipembelajaran.DASPRO;

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

public class AddDasproActivity extends AppCompatActivity {
    private EditText etGejala, etDetail;
    private Button btnAdd;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daspro);

        etGejala = findViewById(R.id.et_gejala);
        etDetail = findViewById(R.id.et_detail);

        btnAdd = findViewById(R.id.btn_add);

        if (getIntent().hasExtra("id")) {
            id = getIntent().getIntExtra("id", 0);
            btnAdd.setText("Update");
            new GetDaspro(AddDasproActivity.this, id).execute();
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



                        new UpdateDaspro(AddDasproActivity.this, u).execute();
                    } else {
                        Toast.makeText(AddDasproActivity.this, "Silahkan masukkan judul materi.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (0 != Main.length() ) {
                        Main u = new Main();
                        u.setJudul(Main);
                        u.setDetail1(Detail);
                        new AddDaspro(AddDasproActivity.this, u).execute();
                    } else {
                        Toast.makeText(AddDasproActivity.this, "Silahkan masukkan detail materi.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    static class AddDaspro extends AsyncTask<Void, Void, Void> {
        private Main u;
        private WeakReference<Context> c;

        public AddDaspro(Context c, Main u) {
            this.c = new WeakReference<>(c);
            this.u = u;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            DasproDatabase ud = DasproDatabase.getAppDatabase(c.get());
            ud.DasproDao().insert(u);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(c.get(), "materi DasPro added successfully!", Toast.LENGTH_SHORT).show();
            ((Activity) c.get()).finish();
        }
    }

    static class UpdateDaspro extends AsyncTask<Void, Void, Void> {
        private Main u;
        private WeakReference<Context> c;

        public UpdateDaspro(Context c, Main u) {
            this.c = new WeakReference<>(c);
            this.u = u;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            DasproDatabase ud = DasproDatabase.getAppDatabase(c.get());
            ud.DasproDao().update(u);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(c.get(), "materi DasPro updated successfully!", Toast.LENGTH_SHORT).show();
            ((Activity) c.get()).finish();
        }
    }

    static class GetDaspro extends AsyncTask<Void, Void, Main> {
        private WeakReference<Context> c;
        private int id;

        public GetDaspro(Context c, int id) {
            this.c = new WeakReference<>(c);
            this.id = id;
        }

        @Override
        protected Main doInBackground(Void... voids) {
            DasproDatabase ud = DasproDatabase.getAppDatabase(c.get());
            Main u = ud.DasproDao().getUser(id);
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
