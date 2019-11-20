package com.example.retrofit1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CatFactsCallback{
    CatApi catApi;
    private final String BASE_URL = "https://cat-fact.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CatFactsAsyncTask catFactsAsyncTask = new CatFactsAsyncTask(BASE_URL,this);
        catFactsAsyncTask.execute();
    }

    @Override
    public void onDataRetreived(GsonCatFacts gsonCatFacts) {
        //setup recycler view adapter
        Log.e("###", "onDataRetreived: "+ gsonCatFacts.getAll() );
    }
}



/*
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        catApi = retrofit.create(CatApi.class);

        catApi.getCatsFacts().enqueue(new Callback<GsonCatFacts>() {
            @Override
            public void onResponse(Call<GsonCatFacts> call, Response<GsonCatFacts> response) {
                    //setup recycler view adapter
                response.body().getAll();
            }

            @Override
            public void onFailure(Call<GsonCatFacts> call, Throwable t) {

            }
        });
 */
