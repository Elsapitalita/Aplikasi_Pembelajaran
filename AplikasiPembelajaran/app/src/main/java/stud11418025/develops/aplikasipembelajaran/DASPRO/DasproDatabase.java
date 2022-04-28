package stud11418025.develops.aplikasipembelajaran.DASPRO;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Main.class}, version = 1, exportSchema = false)
public abstract class DasproDatabase extends RoomDatabase {
    public abstract DasproDao DasproDao();

    private static DasproDatabase INSTANCE;

    public static DasproDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DasproDatabase.class, "daspro-database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }}
