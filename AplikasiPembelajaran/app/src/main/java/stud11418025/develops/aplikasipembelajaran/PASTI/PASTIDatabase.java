package stud11418025.develops.aplikasipembelajaran.PASTI;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Main.class}, version = 1, exportSchema = false)
public abstract class PASTIDatabase extends RoomDatabase {
    public abstract PASTIDao PASTIDao();

    private static PASTIDatabase INSTANCE;

    public static PASTIDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PASTIDatabase.class, "pasti-database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }}
