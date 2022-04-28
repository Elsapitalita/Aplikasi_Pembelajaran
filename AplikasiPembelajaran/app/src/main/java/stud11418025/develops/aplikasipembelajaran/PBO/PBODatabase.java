package stud11418025.develops.aplikasipembelajaran.PBO;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Main.class}, version = 1, exportSchema = false)
public abstract class PBODatabase extends RoomDatabase {
    public abstract PBODao PBODao();

    private static PBODatabase INSTANCE;

    public static PBODatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PBODatabase.class, "pbo-database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }}
