package s.develops.asalma_pam_02.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName =  "cekKesehatan")
public class ECekKesehatan {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_cek")
    int id_cek;

    @ColumnInfo(name = "daftarpertanyaan_gejala")
    String gejala;

    @ColumnInfo(name = "daftarpertanyaan_aktivitas")
    String  aktivitas;

    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "hasil")
    String hasil;

    public int getId_cek() {
        return id_cek;
    }

    public void setId_cek(int id_cek) {
        this.id_cek = id_cek;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }

    public String getAktivitas() {
        return aktivitas;
    }

    public void setAktivitas(String aktivitas) {
        this.aktivitas = aktivitas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }
}
