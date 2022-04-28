package stud11418025.develops.aplikasipembelajaran.Quiz;

class SoalOOSDPilihanGanda {
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

    //membuat array untuk pilihan jawaban
    private String pilihanJawaban[][] = {
            {"closed()","write()","openFileInput()"},
            {"TRUE","Maybe","FALSE"},
            {"SharedPrefs", "Preference", "SharedPreferences"},
            {"ContentProvider", "InsertValues","CursorValues"},
            {"getView()", "setAdapter()", "getAdapterView()"},
            {"edit()", "saved()","commit()"},
            {"ContentValues", "Cursor","Values"},
            {"deleteFile()","getDir()","getFilesDir()"},
            {"onClose()","onCreate()", "onCloseConnection()"},
            {"onOpen()","onUpgrade()","onResume()"}
    };

    //membuat array untuk jawaban benar
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

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
