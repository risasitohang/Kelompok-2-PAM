package s.develops.asalma_pam_02.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import s.develops.asalma_pam_02.entity.ECekKesehatan;

@Database(entities = {ECekKesehatan.class}, version = 2, exportSchema = false)
public abstract class DBRoom extends RoomDatabase {

    public abstract CekKesehatanDao cDao();

    private static volatile DBRoom INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static DBRoom getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (DBRoom.class){
                if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        DBRoom.class,"lapcov19")
                        .fallbackToDestructiveMigration()
//                        .addCallback(sRoomDatabaseCallback)
                        .build();
                }
            }
        }
        return INSTANCE;
    }
    ;

}
