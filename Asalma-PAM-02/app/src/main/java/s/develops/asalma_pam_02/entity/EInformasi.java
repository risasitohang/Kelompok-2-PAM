package s.develops.asalma_pam_02.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class EInformasi {
    @SerializedName("id_informasi ")
    @Expose
    private int id_informasi;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("tanggal")
    @Expose
    private Date tanggal;
    @SerializedName("kateogori")
    @Expose
    private String kategori;
    @SerializedName("isi")
    @Expose
    private String isi;

    public int getId_informasi() {
        return id_informasi;
    }

    public void setId_informasi(int id_informasi) {
        this.id_informasi = id_informasi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
