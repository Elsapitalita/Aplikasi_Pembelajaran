package stud11418025.develops.aplikasipembelajaran.Quiz;

class SoalPBOPilihanGanda {
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

    //membuat array untuk pilihan jawaban
    private String pilihanJawaban[][] = {
            {"Class","Atribut","Objek"},
            {"Atribut","Method","Abstraksi"},
            {"Enkapsulasi", "Inheritance", "Polymorphism"},
            {" package.<nama_package>;", "package <nama_package>","package <nama_package>.<nama_kelas>"},
            {"Statement program", " Instruksi program", "Bytecode program"},
            {"protected void info( )", "final void info( )","private void info( )"},
            {"Arrays.sort()", " System.sorting()","Array.Sort()"},
            {"42","44","40()"},
            {"Public static double max (double a, b)","Public static double float (double a)", "Public static double abs (double a)"},
            {"if(srt1 == “budi”) {System.out.println(“budi”);}","if(srt1.equals(“budi”)) {System.out.println(“budi”)}","if(srt1.equals(“budi”)) {System.out.println(“budi”);}"}
    };

    //membuat array untuk jawaban benar
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
