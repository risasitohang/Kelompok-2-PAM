package s.develops.asalma_pam_02.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import s.develops.asalma_pam_02.entity.ECekKesehatan;


@Dao
public interface CekKesehatanDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertKesehatan(ECekKesehatan cekkesehatan);

    @Query("SELECT * FROM CekKesehatan")
    LiveData<List<ECekKesehatan>> getCekKesehatan();
}
