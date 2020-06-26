package s.develops.asalma_pam_02.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import s.develops.asalma_pam_02.database.LocalRepository;
import s.develops.asalma_pam_02.entity.ECekKesehatan;


public class CekKesehatanViewModel extends AndroidViewModel {

    private LocalRepository mRipository;

    private LiveData<List<ECekKesehatan>> mCekKesehatan;

    public CekKesehatanViewModel(Application application){
        super(application);
        mRipository = new LocalRepository(application);
        mCekKesehatan = mRipository.getCekKesehatan();
    }

    public LiveData<List<ECekKesehatan>> getCekKesehatan(){
        return mCekKesehatan;
    }

    public void insetCekKesehata(ECekKesehatan ECekKesehatan){
        mRipository.insertCekKesehatan(ECekKesehatan);
    }
}
