package stud11418025.develops.aplikasipembelajaran.Article;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import stud11418025.develops.aplikasipembelajaran.HomeStudents;
import stud11418025.develops.aplikasipembelajaran.R;

public class PendaftaranPraktikumStud extends AppCompatActivity {

    public static final String URL = "http://192.168.43.114:4433/PAM/AplikasiPembelajaran/";
    private RadioButton radioSexButton;
    private ProgressDialog progress;


    @BindView(R.id.radioSesi)
    RadioGroup radioGroup;
    @BindView(R.id.editTextNPM)
    EditText editTextNPM;
    @BindView(R.id.editTextNama)
    EditText editTextNama;
    @BindView(R.id.editTextKelas)
    EditText editTextKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_stud);
        ButterKnife.bind(this);

        Button btnBack = (Button)findViewById(R.id.back1);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PendaftaranPraktikumStud.this, HomeStudents.class);
                startActivity(i);
            }
        });

    }


    @OnClick(R.id.buttonDaftar1)
    void daftar() {
        //membuat progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        //mengambil data dari edittext
        String npm = editTextNPM.getText().toString();
        String nama = editTextNama.getText().toString();
        String kelas = editTextKelas.getText().toString();

        int selectedId = radioGroup.getCheckedRadioButtonId();

        // mencari id radio button
        radioSexButton = (RadioButton) findViewById(selectedId);
        String sesi = radioSexButton.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(npm, nama, kelas, sesi);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(PendaftaranPraktikumStud.this, message, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(PendaftaranPraktikumStud.this, HomeStudents.class);
                } else {
                    Toast.makeText(PendaftaranPraktikumStud.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(PendaftaranPraktikumStud.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
