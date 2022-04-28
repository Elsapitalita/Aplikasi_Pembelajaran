package stud11418025.develops.aplikasipembelajaran.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import stud11418025.develops.aplikasipembelajaran.R;

public class DasproEssay extends AppCompatActivity {
    TextView mtvSkor2,mtvSoal2;
    EditText medtJawaban;
    Button mbtnSubmit2;
    int x=0;
    int arr;
    int skor;
    String jawaban;

    DasproSoalEssay essay = new DasproSoalEssay();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasproessay);

        mtvSkor2 = (TextView) findViewById(R.id.tvSkor2);
        mtvSoal2 = (TextView) findViewById(R.id.tvSoal2);
        medtJawaban = (EditText) findViewById(R.id.edtJawaban);
        mbtnSubmit2 = (Button) findViewById(R.id.btnSubmit2);

        setKonten();

        mbtnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setKonten(){
        medtJawaban.setText(null);
        arr = essay.pertanyaan.length;
        if(x >= arr){
            //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)
            String jumlahSkor = String.valueOf(skor);	//menjadikan skor menjadi string
            Intent i = new Intent(DasproEssay.this, HasilSkoringDaspro.class);
            //waktu pindah activity, sekalian membawa nilai jumlahSkor yang ditampung dengan inisial skorAkhir2
            //singkatnya skorAkhir2 = jumlahSkor
            //jika masih belum jelas silahkan bertanya
            i.putExtra("skorAkhir2",jumlahSkor);
            i.putExtra("activity","Essay");
            startActivity(i);
        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalEssay
            mtvSoal2.setText(essay.getPertanyaan(x));
            jawaban = essay.getJawabanBenar(x);
        }
        x++;
    }


    public void cekJawaban(){
        if(!medtJawaban.getText().toString().isEmpty()){ //jika edit text TIDAK kosong
            //jika text yang tertulis di edit text tsb = nilai dari var jawaban
            if(medtJawaban.getText().toString().equalsIgnoreCase(jawaban)){
                skor = skor + 10;
                mtvSkor2.setText(""+skor);	//mtvSkor2 diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                mtvSkor2.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else{
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }
    }

    //ini adalah method bawaan dari Android Studio
    //fungsi : memberi aksi ketika tombol back pada hp diklik
    public void onBackPressed(){
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
        //jadi yang awalnya klik tombol back maka akan kembali ke activity sebelumnya
        //kali ini ketika tombol back diklik maka
        //hanya muncul Toast
    }

}
