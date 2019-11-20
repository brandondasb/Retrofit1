package com.example.retrofit1;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CatFactsAsyncTask extends AsyncTask<String, Void, GsonCatFacts> {
    String baseUrl ;
    CatFactsCallback catFactsCallback;

    public CatFactsAsyncTask(String baseUrl, CatFactsCallback catFactsCallback) {
        this.baseUrl = baseUrl;
        this.catFactsCallback = catFactsCallback;
    }

    @Override
    protected GsonCatFacts doInBackground(String... strings) {

        try {
            URL url = new URL(baseUrl + "facts");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer builder = new StringBuffer();

            String inputString;
            while((inputString= bufferedReader.readLine())!= null){
                builder.append(inputString);
            }

            JSONObject topLevel = new JSONObject(builder.toString()); // create new object instance of JSON
            urlConnection.disconnect();

            Gson gson = new Gson();
            GsonCatFacts topLevelList = gson.fromJson(topLevel.toString(), GsonCatFacts.class);

            catFactsCallback.onDataRetreived(topLevelList);
            return topLevelList;

        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
