package s.develops.asalma_pam_02.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import s.develops.asalma_pam_02.R;
import s.develops.asalma_pam_02.network.APIClient;
import s.develops.asalma_pam_02.network.APIServices;

public class Gejalacovid extends AppCompatActivity {

    Button kirim, yes1, yes2, yes3, no1, no2, no3;
    TextView text1, text2, text3;
    int hasil =0;
    String gejala, aktivitas;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gejalacovid);

        Intent gi = getIntent();
        gejala = gi.getStringExtra("gejala");
        aktivitas = gi.getStringExtra("aktivitas");


        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
        kirim = findViewById(R.id.btngej7);
        yes1 = findViewById(R.id.btngej1);
        yes2 = findViewById(R.id.btngej3);
        yes3 = findViewById(R.id.btngej5);
        no1 = findViewById(R.id.btngej2);
        no2 = findViewById(R.id.btngej4);
        no3 = findViewById(R.id.btngej6);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);

        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil = hasil+1;
                text1.setText("YA");
                Toast.makeText(Gejalacovid.this,"Total hasil :"+ hasil, Toast.LENGTH_SHORT).show();
                yes1.setClickable(false);
                no1.setClickable(true);
            }
        });

        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil = hasil+1;
                text2.setText("YA");
                yes2.setClickable(false);
                no2.setClickable(true);
                Toast.makeText(Gejalacovid.this,"Total hasil :"+ hasil, Toast.LENGTH_SHORT).show();
            }
        });

        yes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil = hasil+1;
                text3.setText("YA");
                yes3.setClickable(false);
                no3.setClickable(true);
                Toast.makeText(Gejalacovid.this,"Total hasil :"+ hasil, Toast.LENGTH_SHORT).show();
            }
        });

        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasil>0){
                    hasil = hasil-1;
                }
                text1.setText("NO");
                yes1.setClickable(true);
                no1.setClickable(false);
                Toast.makeText(Gejalacovid.this,"Total hasil :"+ hasil, Toast.LENGTH_SHORT).show();
            }
        });

        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasil>0){
                    hasil = hasil-1;
                }
                text2.setText("NO");
                yes2.setClickable(true);
                no2.setClickable(false);
                Toast.makeText(Gejalacovid.this,"Total hasil :"+ hasil, Toast.LENGTH_SHORT).show();
            }
        });

        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasil>0){
                    hasil = hasil-1;
                }
                text3.setText("NO");
                yes3.setClickable(true);
                no3.setClickable(false);
                Toast.makeText(Gejalacovid.this,"Total hasil :"+ hasil, Toast.LENGTH_SHORT).show();
            }
        });

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekCovid(hasil);
            }
        });

    }

    public void cekCovid(final int hasil){
            final APIServices services = APIClient.getRetrofit().create(APIServices.class);

            String username = sharedpreferences.getString("username", null);
        services.cekKesehata(gejala, aktivitas,username, hasil)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response){
                        if (response.isSuccessful()){
                            try {
                                JSONObject jr =  new JSONObject(response.body().string());
                                if (jr.getString("success").equals("1")){
                                    int hasil1 = hasil;
                                    Intent intent = new Intent(Gejalacovid.this, HasilCek.class);
                                    intent.putExtra("hasil", hasil1);
                                    startActivity(intent);
                                }
                            }catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("error",t.getMessage());
                        Toast.makeText(Gejalacovid  .this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
