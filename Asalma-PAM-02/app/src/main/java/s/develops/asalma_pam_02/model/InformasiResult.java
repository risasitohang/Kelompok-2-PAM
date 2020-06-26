package s.develops.asalma_pam_02.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import s.develops.asalma_pam_02.entity.EInformasi;

public class InformasiResult {
    @SerializedName("informasi")
    @Expose
    List<EInformasi> informasi;

    public List<EInformasi> getInformasi() {
        return informasi;
    }

    public void setInformasi(List<EInformasi> informasi) {
        this.informasi = informasi;
    }
}
