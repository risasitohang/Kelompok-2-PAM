package s.develops.asalma_pam_02.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import s.develops.asalma_pam_02.R;
import s.develops.asalma_pam_02.adapter.InformasiAdapter;
import s.develops.asalma_pam_02.entity.EInformasi;
import s.develops.asalma_pam_02.model.InformasiResult;
import s.develops.asalma_pam_02.network.APIClient;
import s.develops.asalma_pam_02.network.APIServices;

public class Informasi extends AppCompatActivity {

    private List<EInformasi> mInformasi;
    private InformasiAdapter informasiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Informasi.this, TambahInformasi.class);
                startActivity(intent);
            }
        });

        mInformasi = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.content_informasi);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        informasiAdapter = new InformasiAdapter(getApplicationContext(), mInformasi);
        recyclerView.setAdapter(informasiAdapter);

        APIServices services = APIClient.getRetrofit().create(APIServices.class);

        Call<InformasiResult> call = services.getInformasi();

        call.enqueue(new Callback<InformasiResult>() {
            @Override
            public void onResponse(Call<InformasiResult> call, Response<InformasiResult> response) {
                if (response.isSuccessful()){
                    mInformasi = response.body().getInformasi();
                    informasiAdapter.setInformasi(mInformasi);
                }else{
                    Toast.makeText(getApplicationContext(), response.message() ,
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<InformasiResult> call, Throwable t) {
                Log.d("error",t.getMessage());
                Toast.makeText(Informasi.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}
