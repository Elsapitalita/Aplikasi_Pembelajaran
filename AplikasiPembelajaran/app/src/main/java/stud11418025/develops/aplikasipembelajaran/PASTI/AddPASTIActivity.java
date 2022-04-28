package stud11418025.develops.aplikasipembelajaran.PASTI;

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

public class AddPASTIActivity extends AppCompatActivity {
    private EditText etGejala, etDetail;
    private Button btnAdd;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pasti);

        etGejala = findViewById(R.id.et_gejala);
        etDetail = findViewById(R.id.et_detail);

        btnAdd = findViewById(R.id.btn_add);

        if (getIntent().hasExtra("id")) {
            id = getIntent().getIntExtra("id", 0);
            btnAdd.setText("Update");
            new GetPASTI(AddPASTIActivity.this, id).execute();
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



                        new UpdatePASTI(AddPASTIActivity.this, u).execute();
                    } else {
                        Toast.makeText(AddPASTIActivity.this, "Silahkan masukkan judul materi.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (0 != Main.length() ) {
                        Main u = new Main();
                        u.setJudul(Main);
                        u.setDetail1(Detail);
                        new AddPASTI(AddPASTIActivity.this, u).execute();
                    } else {
                        Toast.makeText(AddPASTIActivity.this, "Silahkan masukkan detail materi.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    static class AddPASTI extends AsyncTask<Void, Void, Void> {
        private Main u;
        private WeakReference<Context> c;

        public AddPASTI(Context c, Main u) {
            this.c = new WeakReference<>(c);
            this.u = u;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            PASTIDatabase ud = PASTIDatabase.getAppDatabase(c.get());
            ud.PASTIDao().insert(u);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(c.get(), "materi PASTI added successfully!", Toast.LENGTH_SHORT).show();
            ((Activity) c.get()).finish();
        }
    }

    static class UpdatePASTI extends AsyncTask<Void, Void, Void> {
        private Main u;
        private WeakReference<Context> c;

        public UpdatePASTI(Context c, Main u) {
            this.c = new WeakReference<>(c);
            this.u = u;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            PASTIDatabase ud = PASTIDatabase.getAppDatabase(c.get());
            ud.PASTIDao().update(u);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(c.get(), "materi PASTI updated successfully!", Toast.LENGTH_SHORT).show();
            ((Activity) c.get()).finish();
        }
    }

    static class GetPASTI extends AsyncTask<Void, Void, Main> {
        private WeakReference<Context> c;
        private int id;

        public GetPASTI(Context c, int id) {
            this.c = new WeakReference<>(c);
            this.id = id;
        }

        @Override
        protected Main doInBackground(Void... voids) {
            PASTIDatabase ud = PASTIDatabase.getAppDatabase(c.get());
            Main u = ud.PASTIDao().getUser(id);
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
