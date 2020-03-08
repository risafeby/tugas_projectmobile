package com.risafebyrastuti.siakstmikpontianakc1b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tonywijaya.siakstmikpontianakc1b.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

public class TambahPemakaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pemakai);

        inisialisasiSimpanButton();

    }

    private void inisialisasiSimpanButton() {
        Button simpanButton = (Button) findViewById(R.id.simpanButton);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText idEditText = (EditText)findViewById(R.id.idEditText);
                String id = idEditText.getText().toString();

                try {
                    id = URLEncoder.encode(id, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);
                String password = passwordEditText.getText().toString();

                try {
                    password = URLEncoder.encode(password, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                AsyncHttpClient ahc = new AsyncHttpClient();
                String url = "http://192.168.222.205/011100862/tambahPemakai.php?id=" + id + "&password=" + password;

                ahc.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(getApplicationContext(), "Record telah disimpan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

