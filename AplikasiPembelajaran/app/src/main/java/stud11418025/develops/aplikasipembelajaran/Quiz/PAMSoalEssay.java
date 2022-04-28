package stud11418025.develops.aplikasipembelajaran.Quiz;

public class PAMSoalEssay {
    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Method yang Tidak digunakan atau Tidak terkait dengan proses penggunaan internal storage adalah ...",
            "Pada saat sebuah aplikasi android dijalankan, method yang dieksekusi pertama kali sama dengan proses eksekusi" +
                    "program java, yaitu memanggil method public static void main (String[] args)",
            "Untuk penyimpanan data bertipe primitif dengan format pasangan key-value pada android dapat dilakukan dengan menggunakan API ...",
            "Kelas yang diperlukan pada saat menambahkan/mengupdate isi dari database pada saat menggunakan SQLite adalah..",
            "Method pada sebuah adapter yang digunakan untuk mengambil deklarasi layout XML untuk setiap item ListView dan mengassign data ke masing-masing baris item adalah...",
            "Method yang Tidak digunakan atau Tidak terkait dengan proses menuliskan data kedalam sebuah sharedPreferences adalah...",
            "Nama Kelas yang objeknya diperlukan pada saat menambahkan atau memperbaharui data pada database ketika menggunakan SQLite adalah...",
            "Method yang dapat digunakan untuk mengambil informasi alamat absolut sebuah file pada aplikasi Android adalah...",
            "Anda dapat mengoverride method pada saat mengextends kelas SQLiteOpenHelper, Kecuali...",
            "Callback method yang dapat anda gunakan pada sebuah sub class dari SQLiteOpenHelper adalah, Kecuali..."
    };

    //membuat array untuk set gambar (dari String diubah jadi ImageView)
    //pastikan yang tertulis disini sama dengan nama di drawable
    //lihat gambar penjelasan1

    //membuat array jawaban benar
    private String jawabanBenar[] = {
            "closed()",
            "FALSE",
            "SharedPreferences",
            "InsertValues",
            "getView()",
            "saved()",
            "ContentValues",
            "getFilesDir()",
            "onCloseConnection()",
            "onResume"
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
