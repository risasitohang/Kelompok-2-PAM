package s.develops.asalma_pam_02.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import s.develops.asalma_pam_02.entity.CekKesehatan;

public class CekKesehatanResult {
    @SerializedName("cekKesehatan")
    @Expose
    private List<CekKesehatan> cekKesehatan;

    public List<CekKesehatan> getCekKesehatan(){
        return cekKesehatan;
    }
}
