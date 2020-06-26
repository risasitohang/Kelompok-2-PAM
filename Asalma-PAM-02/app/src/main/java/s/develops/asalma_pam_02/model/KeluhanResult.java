package s.develops.asalma_pam_02.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import s.develops.asalma_pam_02.entity.EKeluhan;

public class KeluhanResult {
    @SerializedName("keluhan")
    @Expose
    List<EKeluhan> keluhan;

    public List<EKeluhan> getKeluhan() {
        return keluhan;
    }

    public void setmKeluhan(List<EKeluhan> keluhan) {
        this.keluhan = keluhan;
    }
}
