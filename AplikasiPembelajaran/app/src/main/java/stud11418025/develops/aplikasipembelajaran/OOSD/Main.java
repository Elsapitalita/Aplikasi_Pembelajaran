package stud11418025.develops.aplikasipembelajaran.OOSD;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Main {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "judul")
    private String judul;

    @ColumnInfo(name = "detail1")
    private String detail1;

    @ColumnInfo(name = "detail2")
    private String detail2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }
}
