package s.develops.asalma_pam_02.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import s.develops.asalma_pam_02.R;
import s.develops.asalma_pam_02.adapter.PendudukAdapter;
import s.develops.asalma_pam_02.entity.Account;
import s.develops.asalma_pam_02.model.AccountResult;
import s.develops.asalma_pam_02.network.APIClient;
import s.develops.asalma_pam_02.network.APIServices;

public class DataPenduduk extends AppCompatActivity {

    List<Account> mAccount;
    PendudukAdapter pendudukAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_penduduk);


        mAccount = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.content_penduduk);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        pendudukAdapter = new PendudukAdapter(getApplicationContext(), mAccount);
        recyclerView.setAdapter(pendudukAdapter);

        APIServices services = APIClient.getRetrofit().create(APIServices.class);
        Call<AccountResult> call = services.getAcc();

        call.enqueue(new Callback<AccountResult>() {
            @Override
            public void onResponse(Call<AccountResult> call, Response<AccountResult> response) {
                if(response.isSuccessful()){


                    mAccount = response.body().getAcc();
                    pendudukAdapter.setAccount(mAccount);

                }else {
                    Toast.makeText(getApplicationContext(), response.message() ,
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AccountResult> call, Throwable t) {
                Log.d("error",t.getMessage());
                Toast.makeText(DataPenduduk.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
