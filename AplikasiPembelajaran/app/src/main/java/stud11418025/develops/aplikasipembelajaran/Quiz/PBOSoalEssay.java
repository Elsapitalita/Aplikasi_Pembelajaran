package stud11418025.develops.aplikasipembelajaran.Quiz;

public class PBOSoalEssay {
    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Abstraksi dari sesuatu yang mewakili dunia nyata adalah pengertian...",
            "Nilai atau elemen-elemen data yang dimiliki obyek dalam kelas obyek dan merupakan ciri dari sebuah obyek adalah...",
            "Suatu kelas dapat diturunkan dari kelas yang lain, dimana atribut dari kelas semula dapat diwariskan ke kelas yang baru adalah prinsip...",
            "Berikut adalah cara untuk mendeklarasikan sebuah package, yaitu...",
            "Pada pemrograman java, file dengan ekstensi class (nama_file.class) sebenarnya berisikan:",
            "Untuk mengunci metode info agar tidak dapat di override jika dipanggil pada kelas lain adalah dengan syntax…..",
            "Untuk mengurutkan isi array secara ascending, bisa menggunakan…",
            "int A = 40, B = 12;\n" +
                    "System.out.println(\"A | B = \" + ( A | B ));\n" + " Jika program tersebut dijalankan maka akan menghasilkan tampilan sebagai berikut:",
            "Method yang menghasilkan nilai mutlak adalah ...",
            "Berikut ini pernyataan yang benar adalah:"
    };

    //membuat array untuk set gambar (dari String diubah jadi ImageView)
    //pastikan yang tertulis disini sama dengan nama di drawable
    //lihat gambar penjelasan1

    //membuat array jawaban benar
    private String jawabanBenar[] = {
            "Objek",
            "Atribut",
            "Inheritance",
            "package <nama_package>",
            "Bytecode program",
            "final void info( )",
            "Arrays.sort()",
            "44",
            "Public static double abs (double a)",
            "if(srt1.equals(“budi”)) {System.out.println(“budi”);}"
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
