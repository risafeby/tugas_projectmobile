package com.risafebyrastuti.siakstmikpontianakc1b;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.risafebyrastuti.siakstmikpontianakc1b.PemakaiModel;
import com.tonywijaya.siakstmikpontianakc1b.R;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class TampilUbahHapusPemakaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_ubah_hapus_pemakai);

        inisialisasiRecyclerView();
    }

    private void inisialisasiRecyclerView() {
        AsyncHttpClient ahc;
        String url;

        //url = "http://tonywijaya.000webhostapp.com/011100862/tampilPemakai.php";
        url = "http://192.168.222.205/011100862/tampilPemakai.php";

        ahc = new AsyncHttpClient ();

        ahc.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson g;
                List<PemakaiModel> pemakaiModelList;
                PemakaiAdapter pa;
                RecyclerView rv;
                RecyclerView.LayoutManager lm;

                g = new Gson();
                pemakaiModelList = g.fromJson(new String(responseBody), new TypeToken<List<PemakaiModel>>(){}.getType());
                pa = new PemakaiAdapter(pemakaiModelList);
                rv = (RecyclerView)findViewById(R.id.rv1);
                lm = new LinearLayoutManager(TampilUbahHapusPemakaiActivity.this);

                rv.setLayoutManager(lm);
                rv.setAdapter(pa);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
