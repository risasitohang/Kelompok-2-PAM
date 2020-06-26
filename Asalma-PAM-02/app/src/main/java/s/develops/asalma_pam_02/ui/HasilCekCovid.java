package s.develops.asalma_pam_02.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import s.develops.asalma_pam_02.R;
import s.develops.asalma_pam_02.adapter.CekKesehatanAdapter;
import s.develops.asalma_pam_02.entity.CekKesehatan;
import s.develops.asalma_pam_02.entity.ECekKesehatan;
import s.develops.asalma_pam_02.model.CekKesehatanResult;
import s.develops.asalma_pam_02.model.CekKesehatanViewModel;
import s.develops.asalma_pam_02.network.APIClient;
import s.develops.asalma_pam_02.network.APIServices;

public class HasilCekCovid extends AppCompatActivity {

    private CekKesehatanViewModel mCekKesehatanViewModel;
    List<CekKesehatan> mCekKesehatan;
    CekKesehatanAdapter cekKesehatanAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_cek_covid);

        sharedPreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);

        mCekKesehatan = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.content_cekKesehatan);
//        final CekKesehatanAdapter adapter = new CekKesehatanAdapter(this);
//        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        cekKesehatanAdapter = new CekKesehatanAdapter(getApplicationContext(), mCekKesehatan);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cekKesehatanAdapter);


        mCekKesehatanViewModel = ViewModelProviders.of(this).get(CekKesehatanViewModel.class);
//        mCekKesehatanViewModel = new ViewModelProvider(this).get(CekKesehatanViewModel.class);

        mCekKesehatanViewModel.getCekKesehatan().observe(this, new Observer<List<ECekKesehatan>>() {
            @Override
            public void onChanged(List<ECekKesehatan> ECekKesehatans) {
//                adapter.setCekKesehatan(ECekKesehatans);
            }
        });

        APIServices services = APIClient.getRetrofit().create(APIServices.class);

        if (sharedPreferences.getString("role", null).equals("penduduk")){
            String username =  sharedPreferences.getString("username", null);
            Call<CekKesehatanResult> call =  services.searchCekKesehatan(username);

           call.enqueue(new Callback<CekKesehatanResult>() {
               @Override
               public void onResponse(Call<CekKesehatanResult> call, Response<CekKesehatanResult> response) {
                    if (response.isSuccessful()){
                        mCekKesehatan = response.body().getCekKesehatan();
                        cekKesehatanAdapter.setCekKesehatan(mCekKesehatan);
                    }else{
                        Toast.makeText(getApplicationContext(), response.message() ,
                                Toast.LENGTH_LONG).show();
                    }
               }

               @Override
               public void onFailure(Call<CekKesehatanResult> call, Throwable t) {
                   Log.d("error",t.getMessage());
                   Toast.makeText(HasilCekCovid.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
               }
           });
        }else{
                Call<CekKesehatanResult> call = services.getCekKesehatan();

                call.enqueue(new Callback<CekKesehatanResult>() {
                    @Override
                    public void onResponse(Call<CekKesehatanResult> call, Response<CekKesehatanResult> response) {
                       if (response.isSuccessful()){
                           mCekKesehatan = response.body().getCekKesehatan();
                           cekKesehatanAdapter.setCekKesehatan(mCekKesehatan);
                       }else {
                           Toast.makeText(getApplicationContext(), response.message() ,
                                   Toast.LENGTH_LONG).show();
                       }
                    }

                    @Override
                    public void onFailure(Call<CekKesehatanResult> call, Throwable t) {
                        Log.d("error",t.getMessage());
                    Toast.makeText(HasilCekCovid.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        }


    }
}
