package s.develops.asalma_pam_02.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BASE_URL = "http://192.168.43.84:8080/";

    private static Retrofit mRetrofit;

    public static Retrofit getRetrofit(){
        if (mRetrofit==null){
            mRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }
}
