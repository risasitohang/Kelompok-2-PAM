package s.develops.asalma_pam_02.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import s.develops.asalma_pam_02.R;

public class Dashboard extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public final static String TAG_NAMA = "nama";
    public final static String TAG_JK = "jk";
    public final static String TAG_TANGGALLAHIR = "tanggallahir";
    public final static String TAG_ALAMAT = "alamat";
    public final static String TAG_USERNAME = "username";
    public final static String TAG_PASSWORD = "password";
    public final static String TAG_PEKERJAAN = "perkerjaan";
    public final static String TAG_NIK = "nik";
    public final static String TAG_FOTO = "foto";

    TextView txt_profil, txt_informasi, txt_keluhan, txt_data;
    TextView txt_status, txt_about;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);


        txt_profil =  findViewById(R.id.cekprofil);
        txt_informasi = findViewById(R.id.cekinformasi);
        txt_keluhan =  findViewById(R.id.cekkeluhan);

        txt_about = findViewById(R.id.tentangkami);

        txt_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Profil.class);
                startActivity(intent);
            }
        });

        txt_informasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Informasi.class);
                startActivity(intent);
            }
        });

        txt_keluhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Keluhan.class);
                startActivity(intent);
            }
        });

        txt_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, DataPenduduk.class);
                startActivity(intent);
            }
        });

        txt_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, KategoriStatus.class);
                startActivity(intent);
            }
        });


        LinearLayout mCekCovid = findViewById(R.id.cekCovid);
        mCekCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Kategoricovid.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean  onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId()==R.id.about){
//            startActivity(new Intent(this, AboutActivity.class));
//        } else if (item.getItemId() == R.id.setting) {
//            startActivity(new Intent(this, SettingActivity.class));
//        } else if (item.getItemId() == R.id.help) {
//            startActivity(new Intent(this, HelpActivity.class));
//        }



        if (item.getItemId()== R.id.logut){
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(Login.session_status, false);
            editor.putString(TAG_JK, null);
            editor.putString(TAG_NAMA, null);
            editor.putString(TAG_PASSWORD, null);
            editor.putString(TAG_USERNAME, null);
            editor.putString(TAG_TANGGALLAHIR,null);
            editor.putString(TAG_ALAMAT,null);
            editor.putString(TAG_FOTO,null);
            editor.putString(TAG_NIK,null);
            editor.putString(TAG_PEKERJAAN,null);
            editor.commit();
            Intent ua = new Intent(Dashboard.this, Login.class);
            finish();
            startActivity(ua);
        }

        return true;
    }
}
