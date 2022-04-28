package stud11418025.develops.aplikasipembelajaran.OOSD;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Main.class}, version = 1, exportSchema = false)
public abstract class OOSDDatabase extends RoomDatabase {
    public abstract OOSDDao OOSDDao();

    private static OOSDDatabase INSTANCE;

    public static OOSDDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), OOSDDatabase.class, "oosd-database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }}
