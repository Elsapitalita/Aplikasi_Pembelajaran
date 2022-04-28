package stud11418025.develops.aplikasipembelajaran.PBO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PBODao {
    @Insert
    Long insert(Main u);

    @Query("SELECT * FROM `Main` ORDER BY `id` DESC")
    List<Main> getAllUsers();

    @Query("SELECT * FROM `Main` WHERE `id` =:id")
    Main getUser(int id);

    @Update
    void update(Main u);

    @Delete
    void delete(Main u);
}
